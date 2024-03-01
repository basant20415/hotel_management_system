package hotel.management.system ;
    //package addrooms;
    import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
    import javax.swing.*;
    /**
     *
     * @author bassant
     */
    public class AddRooms extends JFrame implements ActionListener {
        JButton add,cancel; 
        JTextField tfroom,tfprice;
        JComboBox  typeCombo,cleanCombo,availableCombo ;
    AddRooms (){
           getContentPane().setBackground(Color.WHITE);
           setLayout(null); 
           
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);


         JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.BOLD,16));
        lblroomno.setBounds(60,80,120,20);
        add(lblroomno);

        tfroom  = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

         JLabel lblavailable=new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,30);
       add(lblavailable);

        String availableOptions[]={"Available","Occupied"};
        availableCombo =new JComboBox(availableOptions);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.white);
        add(availableCombo);
        
//        
          JLabel lblclean=new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);
//
        String cleanOptions[]={"Cleaned","Dirty"};
         cleanCombo=new JComboBox(cleanOptions);
        cleanCombo.setBounds(200, 180, 150, 30);
        cleanCombo.setBackground(Color.white);
        add(cleanCombo);
        
        
          JLabel lblprice=new JLabel("price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);

        
        tfprice=new   JTextField();
       tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        
        
        JLabel lbltype=new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);

        String typeOptions[]={"single bed","double bed"};
        typeCombo=new JComboBox(typeOptions);
        typeCombo.setBounds(200, 280, 150, 30);
        typeCombo.setBackground(Color.white);
        add(typeCombo);
        
         add=new JButton("Add Rooms");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK );
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
         cancel=new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK );
        cancel.setBounds(220,350,130,30);
         cancel .addActionListener(this);
        add(cancel  );
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/twelve.jpg"));
       JLabel image =new JLabel (i1);
        image.setBounds(400,30,500,300);
         add(image);
      
       setBounds(330,200,940,470);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);

    }
        @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==add){
          String roomnumber = tfroom.getText();
          String availability =(String) availableCombo.getSelectedItem();
          String status=(String) cleanCombo.getSelectedItem();
          String price= tfprice.getText();
          String type=(String)typeCombo.getSelectedItem();
          try{
              Conn conn = new Conn();
              String str = "INSERT INTO room values( '"+roomnumber+"', '"+availability+"', '"+status+"','"+price+"', '"+type+"')";        
		conn.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Successfully Added");
               setVisible(false);
          }catch(Exception e){
                e.printStackTrace();
            }
      }else{
          setVisible(false);
    }
    }

        public static void main(String[] args) throws IOException  {
            // TODO code application logic here
           new AddRooms();
        }
    }

