package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import  java.util.Date;

public class Checkout extends JFrame implements ActionListener {
JTextField ccustomer;
JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
JButton checkout ,back,show;

    Checkout(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text =new JLabel("Checkout");
        text.setBounds(100,20,200,30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(text);

        JLabel lblid =new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        ccustomer =new JTextField();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);

        JLabel lblroom =new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);

        lblroomnumber =new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);

        JLabel lblcheckin =new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);

        lblcheckintime =new JLabel();
        lblcheckintime.setBounds(150,180,100,30);
        add(lblcheckintime);

        JLabel lblcheckout =new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);


        Date date =new Date();
        lblcheckouttime =new JLabel(""+date);
        lblcheckouttime.setBounds(150,230,150,30);
        add(lblcheckouttime);

        show = new JButton("Show Info");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(30,280,120,30);
        show.addActionListener(this);
        add(show);

        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(170,280,120,30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(100,330,120,30);
        back.addActionListener(this);
        add(back);


        ImageIcon i4 =new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 =i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 =new ImageIcon(i5);
        JLabel image =new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);

        setBounds(300, 200, 800, 460);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
         try{
           Conn c1=new Conn();
           String id = ccustomer.getText();
           String query="select * from customer where idnumber = '"+id+"'";
           ResultSet rs1=c1.s.executeQuery(query);
           if(rs1.next()){
            if(ae.getSource()==show){
            
                try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                lblroomnumber.setText(rs1.getString("room"));
               lblcheckintime.setText(rs1.getString("checkintime"));
                }
               
            }catch(Exception e){
               e.printStackTrace();
    }
       }else if(ae.getSource()==checkout){
          String query1 ="delete from customer where idnumber = '"+ccustomer.getText()+"'";
          String query2 ="update room set avaliability ='Available' where  roomnumber = '"+lblroomnumber.getText()+"'";

          try {
            Conn c =new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null,"Checkout done");
              setVisible(false);
              new Reception();

          }catch (Exception e){
              e.printStackTrace();
          }


        }else {
            setVisible(false);
            new Reception();
        }
           }
  
    else{
                 JOptionPane.showMessageDialog(null, "Invalid  Customer ID");
                 //setVisible(false);
             }}catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        new Checkout();
    }
}
