
package hotel.management.system ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
    setBounds(0, 0,1550, 1000);
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1550, 1000);
    add(image);
    
    JLabel text = new JLabel(" WELCOME TO OUR HOTEL");
    text.setBounds(500, 170, 1000, 50);
    text.setFont(new Font("Tahoma", Font.PLAIN, 46));
    text.setForeground(Color.WHITE);
    image.add(text);
    
    JMenuBar mb = new JMenuBar();
    mb.setBounds(0, 0, 1550, 50);
    image.add(mb);
    
    JMenu hotel = new JMenu("CUSTOMER SURVICES");
    hotel.setForeground(Color.BLACK);
    mb.add(hotel);
    
    JMenuItem reception = new JMenuItem("RECEPTION");
    reception.addActionListener(this);
    hotel.add(reception); 
    
    JMenu admin = new JMenu("HOTEL MANAGEMENT");
    admin.setForeground(Color.BLACK);
    mb.add(admin);
    
    JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
    addemployee.addActionListener(this);
    admin.add(addemployee);
    
    JMenuItem addrooms = new JMenuItem("ADD ROOMS");
    addrooms.addActionListener(this);
    admin.add(addrooms);
    
    setVisible(true);
   
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
   if(ae.getActionCommand().equals("ADD EMPLOYEE")){
   new AddEmployee();
      }else if(ae.getActionCommand().equals("ADD ROOMS")){
          new AddRooms();
     }else if(ae.getActionCommand().equals("RECEPTION")){
       new Reception();
   }
    }

    public static void main(String[] args){
    new Dashboard();
    }
}
