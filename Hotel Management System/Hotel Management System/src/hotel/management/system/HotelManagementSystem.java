/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class HotelManagementSystem extends JFrame implements ActionListener{

        
        public HotelManagementSystem() {
		

                setLayout(null);
                setBounds(100,100,1400,650);
                ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
                JLabel image= new JLabel(i1);
                image.setBounds(0,0,1400,650);
                add(image);
                
                JLabel text = new JLabel ("HOTEL MANAGEMENT SYSTEM");
                text.setBounds(20,490,1000,90);
                text.setForeground(Color.WHITE);
                text.setFont(new Font("serif",Font.BOLD, 50));
                image.add(text);
                
                JButton next = new  JButton("Next");
                next.setBounds(1150,510,150,50);
                next.setBackground(Color.WHITE);
                next.setForeground(Color.BLACK);
                next.addActionListener(this);
                next.setFont(new Font("serif",Font.PLAIN, 24));
                image.add(next);
               
                
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
                

        }
        @Override
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Login();
        }
        
        public static void main(String[] args) {
               new HotelManagementSystem();
                			
	}
}
