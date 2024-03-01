package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalTime;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener, Time{

    JComboBox comboid,croom;
    JTextField tfnumber ,tfname ,tfphone,tfdeposit;
    JRadioButton rmale ,rfemale ;
    JButton add,back;
    JLabel checkintime;
    

    AddCustomer() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("New Customer");

        JLabel text =new JLabel("NEW CUSTOMER FORM");
        text.setBounds(235,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,24));
        add(text);

        JLabel lblid =new JLabel("ID",JLabel.CENTER);
        lblid.setBounds(200,80,100,20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);

        String [] options = {"National ID","Passport"};
        comboid = new JComboBox(options);
        comboid.setBounds(380,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber =new JLabel("ID NUMBER");
        lblnumber.setBounds(200,120,120,20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);

        tfnumber =new JTextField();
        tfnumber.setBounds(380,120,150,25);
        add(tfnumber);


        JLabel lblname =new JLabel("NAME",JLabel.CENTER);
        lblname.setBounds(200,160,100,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);

        tfname =new JTextField();
        tfname.setBounds(380,160,150,25);
        add(tfname);


        JLabel lblgender =new JLabel("GENDER",JLabel.CENTER);
        lblgender.setBounds(200,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);

        rmale=new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(380,200,60,25);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(450,200,100,25);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblphone =new JLabel("PHONE NUMBER");
        lblphone.setBounds(180,240,180,20);
        lblphone.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblphone);

        tfphone =new JTextField();
        tfphone.setBounds(380,240,150,25);
        add(tfphone);

        JLabel lblroom =new JLabel("Room Number");
        lblroom.setBounds(185,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);

        croom=new JComboBox();

        try {
            Conn conn =new Conn();
            String query="select * from room where avaliability ='Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.addItem(rs.getString("roomnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        croom.setBounds(380,280,150,25);
        add(croom);
        
        
        JLabel lbltime =new JLabel("Checkin Time");
        lbltime.setBounds(185,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);

        Date date=new Date();
        checkintime =new JLabel(""+date);
        checkintime.setBounds(380,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkintime);


        JLabel lbldeposit =new JLabel("Deposit",JLabel.CENTER);
        lbldeposit.setBounds(195,360,100,20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);

        tfdeposit =new JTextField();
        tfdeposit.setBounds(380,360,150,25);
        add(tfdeposit);

        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setBounds(210,410,120,30);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setBounds(360,410,120,30);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setBounds(600,200,800,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
        @Override
    public boolean checkText(String name, String id, String phone) {
        
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name should not be empty");
                return false;
            }
//            else if(id.equals("")||id.matches("[a-z A-Z]+")){
//                JOptionPane.showMessageDialog(null,"ID should not be empty or contains any characters");
//                return false ;
            else if(phone.equals("")||phone.matches("[a-z A-Z]+")){
                JOptionPane.showMessageDialog(null,"Phone should not be empty or contains any characters");
                return false;
            }else return true;
    }
    
        @Override
    public boolean checkTime() {  
       LocalTime t1= LocalTime.parse("23:00:00");
       LocalTime t3= LocalTime.parse("08:00:00");
       LocalTime t2 = LocalTime.now();
       
        
        if (t2.compareTo(t1) >= 0 || t2.compareTo(t3)<=0 ){
            return true;
            
    }else 
            return false;
        }

       @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if (checkText(name,id,number)){
            if (rmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }

            String country = tfphone.getText();
            String room = (String)croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            
       if (checkTime()){
        JOptionPane.showMessageDialog(null,"Sorry We can't add new customers now");
        }else if (room == null){
         JOptionPane.showMessageDialog(null,"Sorry there are no empty rooms");
        }
       else{
            try {
                String query ="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set avaliability ='Occupied' where roomnumber ='"+room+"' ";

                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null , "New Customer Added Successfully") ;

                setVisible(false);
                new Reception();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
            }

        }else if(ae.getSource()==back){

            setVisible(false);
            new Reception();
        }
        }


    
    public static void main(String[] args) {
    new AddCustomer();
    }



}

/*

select * from customer ;
*/
