package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

    public class UpdateRoom extends JFrame implements ActionListener{

        JTextField tfroom,tfavailable,tfstatus,ccustomer;
        JButton check,update,back;
        UpdateRoom(){
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            
            JLabel text=new JLabel("Update Room Status");
            text.setFont(new Font("Tahoma",Font.PLAIN,25));
            text.setBounds(30,20,250,30);
            text.setForeground(Color.BLACK);
            add(text);

            JLabel lblid=new JLabel ("Customer Id");
            lblid.setBounds(30,80,100,20);
            add(lblid);


            ccustomer=new JTextField();
            ccustomer.setBounds(200,80,150,25);
            add(ccustomer);

            
            JLabel lblroom=new JLabel ("Room Number");
            lblroom.setBounds(30,130,100,20);
            add(lblroom);

            tfroom=new JTextField();
            tfroom.setBounds(200,130,150,25);
            add(tfroom);

            JLabel lblname=new JLabel ("Availability");
            lblname.setBounds(30,180,100,20);
            add(lblname);

            tfavailable=new JTextField();
            tfavailable.setBounds(200,180,150,25);
            add(tfavailable);

            JLabel lblcheckin=new JLabel ("Cleaning Status");
            lblcheckin.setBounds(30,230,100,20);
            add(lblcheckin);

            tfstatus=new JTextField();
            tfstatus.setBounds(200,230,150,25);
            add(tfstatus);


            check=new JButton("Check");
            check.setBackground(Color.BLACK);
            check.setForeground(Color.WHITE);
            check.setBounds(30, 300 ,100, 30);
            check.addActionListener(this);
            add(check);

            update=new JButton("Update");
            update.setBackground(Color.BLACK);
            update.setForeground(Color.WHITE);
            update.setBounds(150, 300 ,100, 30);
            update.addActionListener(this);
            add(update);

            back=new JButton("Back");
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.setBounds(270, 300 ,100, 30);
            back.addActionListener(this);
            add(back);


      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
       Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
      JLabel image=new JLabel (i3);
      image.setBounds(400,50,500,300);
      add(image);

       setBounds(300,200,980,450);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
           try{
           Conn c1=new Conn();
           String id = ccustomer.getText();
           String query="select * from customer where idnumber = '"+id+"'";
           ResultSet rs1=c1.s.executeQuery(query);
           if(rs1.next()){
               if(ae.getSource()==check){
                try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }
                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber ='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("avaliability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
            }catch(Exception e){
               e.printStackTrace();
    }
       }else if (ae.getSource()==update){
            String number=ccustomer.getText();
           String room=tfroom.getText();
           String available=tfavailable.getText();
            String status=tfstatus.getText();

            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set avaliability ='"+available+"', cleaning_status = '"+status+"' where roomnumber = '"+room+"'");
            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            setVisible(false);
            new Reception();
            }catch(Exception e){
            e.printStackTrace();
        }
       }else {
             setVisible(false);
            new Reception();

    }
           }else{
                 JOptionPane.showMessageDialog(null, "Invalid  Customer ID");
                 //setVisible(false);
             }
            }catch(Exception e){
                e.printStackTrace();
            }
            
     }
       
    public static void main(String[] args) {
            new  UpdateRoom();
        }

}
