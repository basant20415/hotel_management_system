/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Reception extends JFrame implements ActionListener{
     JButton newCustomer ,rooms,allEmployee,customers,managerInfo,searchRoom ,update,roomstatus,checkout,logout;
Reception(){
    getContentPane().setBackground(Color.WHITE);
    
    
    setLayout(null);
    newCustomer =new JButton("New Customer Form"); 
    newCustomer.setBounds(10,30,200,30);
    newCustomer.setBackground(Color.black);
    newCustomer.setForeground(Color.white);
    newCustomer.addActionListener(this);
    add(newCustomer);
    
    rooms =new JButton("Rooms"); 
    rooms.setBounds(10,80,200,30);
    rooms.setBackground(Color.black);
    rooms.setForeground(Color.white);
    rooms.addActionListener(this);
    add(rooms);
    
   
    allEmployee =new JButton("All Employee"); 
    allEmployee.setBounds(10,130,200,30);
    allEmployee.setBackground(Color.black);
    allEmployee.setForeground(Color.white);
    allEmployee.addActionListener(this);
    add(allEmployee);
    
    
    customers =new JButton("Customer Info"); 
    customers.setBounds(10,180,200,30);
   customers.setBackground(Color.black);
    customers.setForeground(Color.white);
    customers.addActionListener(this);
    add(customers);
    
    
    managerInfo =new JButton("Manager Info"); 
    managerInfo.setBounds(10,230,200,30);
   managerInfo.setBackground(Color.black);
   managerInfo.setForeground(Color.white);
   managerInfo.addActionListener(this);
    add(managerInfo);
    
    checkout =new JButton("Checkout"); 
    checkout.setBounds(10,280,200,30);
  checkout.setBackground(Color.black);
   checkout.setForeground(Color.white);
    checkout.addActionListener(this);
    add(checkout);
    
      update =new JButton("Update Status"); 
   update.setBounds(10,330,200,30);
  update.setBackground(Color.black);
   update.setForeground(Color.white);
     update.addActionListener(this);
    add(update);
    
      roomstatus =new JButton("Update Room Status"); 
   roomstatus.setBounds(10,380,200,30);
  roomstatus.setBackground(Color.black);
   roomstatus.setForeground(Color.white);
   roomstatus.addActionListener(this);
    add(roomstatus);
    
    
      searchRoom =new JButton("search Room"); 
   searchRoom.setBounds(10,430,200,30);
  searchRoom.setBackground(Color.black);
   searchRoom.setForeground(Color.white);
     searchRoom.addActionListener(this);
    add(searchRoom);
    
     
   logout =new JButton("Logout"); 
  logout.setBounds(10,480,200,30);
  logout.setBackground(Color.black);
   logout.setForeground(Color.white);
   logout.addActionListener(this);
    add(logout);
    
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
   JLabel image=new JLabel (i1);
   image.setBounds(250,30,500,470);
   add(image);
    
        setBounds(350,200,800,570);
    setVisible(true);
    
    
}
  

    @Override
    public void actionPerformed(ActionEvent ae) {
 if(ae.getSource()==  newCustomer ){
            setVisible(false);
            new AddCustomer();
  }else if(ae.getSource()==  rooms ){
            setVisible(false);
            new Room();
    }

  else if(ae.getSource()==  allEmployee ){
            setVisible(false);
            new EmployeeInfo();
    }
    else if(ae.getSource()==  customers ){
            setVisible(false);
            new CustomerInfo();
    }
  else if(ae.getSource()==  managerInfo ){
            setVisible(false);
            new ManagerInfo();
    }
   else if(ae.getSource()==  searchRoom ){
            setVisible(false);
            new SearchRoom();
    }
    else if(ae.getSource()==  update ){
            setVisible(false);
            new UpdateCheck();
    }
     else if(ae.getSource()==  roomstatus ){
            setVisible(false);
            new UpdateRoom();
    }
      else if(ae.getSource()==  checkout ){
            setVisible(false);
            new Checkout();
    }
       else if(ae.getSource()==  logout ){
            setVisible(false);
            System.exit(0);
    }
    
 
}
        public static void main(String[] args) {
       new Reception();
    }
}


