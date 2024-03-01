/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.time.LocalTime;
public class AddEmployee extends JFrame implements ActionListener,Time {

    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfid;
    JRadioButton rbmale ,rbfemale;
    JButton submit ;
    JComboBox cbjob;


    AddEmployee() {
        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(60, 230, 120, 30);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(200, 230, 150, 30);
        add(tfid);
        

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);

        String str[] = {"Receptionest","Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/waitress", "Manager", "Accountant","Porters"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);


        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 380, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 380, 150, 30);
        add(tfsalary);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = il.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);


        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

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
    public boolean checkText(String name, String id, String phone) {
        
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name should not be empty");
                return false;
            }
            else if(id.equals("")||id.matches("[a-z A-Z]+")){
                JOptionPane.showMessageDialog(null,"ID should not be empty or contains characters");
                return false ;
            }else if(phone.equals("")||phone.matches("[a-z A-Z]+")){
                JOptionPane.showMessageDialog(null,"Phone should not be empty or contains characters");
                return false;
            }else return true;
    }
    @Override
    public void actionPerformed(ActionEvent ae){

            String name = tfname.getText();
            String age = tfage.getText();
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String id = tfid.getText();
            String gender = null;

            if (checkText(name,id,phone)){
 
            if (rbmale.isSelected()) {
                gender = "Male";
            }
            else if(rbfemale.isSelected()){
                gender = "Female";
            }
            
            String job = (String) cbjob.getSelectedItem();
            if (checkTime()){
        JOptionPane.showMessageDialog(null,"Sorry We can't add new customers now");
        }else{
            try{
                 Conn conn =new Conn();
                 String query ="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+id+"','"+phone+"','"+email+"','"+salary+"')";
                 conn.s.executeUpdate(query);

                 JOptionPane.showMessageDialog(null,"Employee added successfully");
                 setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }



}

/* creat table employee(name varchar(25),age varchar(10),gedger varchar(15),job varchar(30),salary varchar(15),phone varchar(15),email varchar(40),aadhar varchar(20));
   describe employee;
   select * from employee;
 */
