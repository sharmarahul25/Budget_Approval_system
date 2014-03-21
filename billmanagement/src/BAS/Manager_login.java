package BAS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.awt.GridLayout;

public class Manager_login extends Login implements ActionListener 
{
    JTextField tf;
    JButton b1,b2,b3,b4;
    ResultSet rs1;
    String s1;
    JFrame f = new JFrame("MANAGER");
    
    public void sendusername(String str)
    {
       s1=str;
//       System.out.println("golu="+s1);
    }
   
public void actionPerformed(ActionEvent ae)
{
 if(ae.getSource() == b1)	
  {
     System.out.println("accept button");
        try
        {
            connect();
            int bill_no = Integer.parseInt(tf.getText().trim());
            
            st=con.prepareStatement("select BILL_NO from BILL_SUBMIT where  BILL_NO=?");
            st.setInt(1, bill_no);
            rs=st.executeQuery();
            
         // rs=st.executeQuery("select BILL_NO from BILL_SUBMIT where  BILL_NO='"+bill_no+"' ");
               
            if(rs.next()==false)
              {
                 JOptionPane.showMessageDialog(null,"bill no not exist please enter the right bill_no!");
               } 
         
             else
              {
                st=con.prepareStatement("select USERNAME, BILL_NO, BILL_DETAILS, MANAGER_NAME, DEPT_TYPE, NAME from BILL_SUBMIT where BILL_no=?");
                st.setInt(1, bill_no);
                rs=st.executeQuery();
                rs.next();
                 
              //String sql=("select USERNAME, BILL_NO, BILL_DETAILS, MANAGER_NAME, DEPT_TYPE, NAME from BILL_SUBMIT "
              //+ " where BILL_no='"+bill_no+"' ");
              //rs.next();
                
                String usr=rs.getString("username");
                String bd=rs.getString("bill_details");
                String man=rs.getString("manager_name");
                String dt=rs.getString("dept_type");
                String nm=rs.getString("name");
               
            System.out.println("hello="+usr+"  "+bill_no+"  "+bd+"  "+man+"  "+dt+"  "+nm);
         
                st=con.prepareStatement("select BILL_NO from FINANCE_BILL where  BILL_NO=?");
                st.setInt(1, bill_no);
                rs=st.executeQuery();
                
             //rs=st.executeQuery("select BILL_NO from FINANCE_BILL where BILL_NO ='"+bill_no+"'");
               
                 if(rs.next()==true)
                 {
                    JOptionPane.showMessageDialog(null,"bill already submitted!");
                 }
      
                 else
                 {
                   st=con.prepareStatement("insert into FINANCE_BILL (USERNAME, BILL_NO, BILL_DETAILS, MANAGER_NAME, DEPT_TYPE, NAME) values (?, ?, ?, ?, ?, ?)");
                   st.setString(1,usr);
                   st.setInt(2, bill_no);
                   st.setString(3,bd);
                   st.setString(4,man);
                   st.setString(5,dt);
                   st.setString(6,nm);
                
                   rs1=st.executeQuery();
                     
              //   sql=("insert into FINANCE_BILL (USERNAME, BILL_NO, BILL_DETAILS, MANAGER_NAME, DEPT_TYPE, NAME) "
              //   + " values ('"+usr+"' , '"+bill_no+"' , '"+bd+"' , '"+man+"' , '"+dt+"' , '"+nm+"')");  
              //   rs1=st.executeQuery(sql);
                
                String message="forwarded to FM by manager ";
                
                   st=con.prepareStatement("insert into BILL_REPORT (USERNAME, BILL_NUM, BILL_DETAILS, DEPT_TYPE, STATUS) values (? , ?, ?, ?, ?) ");
                   st.setString(1,usr);
                   st.setInt(2, bill_no);
                   st.setString(3,bd);
                   st.setString(4,dt);
                   st.setString(5,message+man);
                   rs1=st.executeQuery();
                
               // sql=("insert into BILL_REPORT (USERNAME, BILL_NUM, BILL_DETAILS, DEPT_TYPE, STATUS) "
               // + "values ('"+usr+"' , '"+bill_no+"' , '"+bd+"' , '"+dt+"' , '" +message+man+ "') ");  
               // rs1=st.executeQuery(sql);
     
                   st=con.prepareStatement("delete from BILL_SUBMIT where BILL_no=? ");
                   st.setInt(1, bill_no);
                   rs=st.executeQuery();
                
                   //sql=("delete from BILL_SUBMIT where BILL_no='"+bill_no+"' ");
                
                    }
          }
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null,"java.lang.NumberFormatException enter the bill no as integer only");
        }     
   }                                        

 else if(ae.getSource() == b2)	
 {
   //  System.out.println("reject button");
        try
          {
            connect();
            int bill_no = Integer.parseInt(tf.getText().trim());
            st=con.prepareStatement("select BILL_NO  from BILL_SUBMIT where BILL_no=? ");
            st.setInt(1, bill_no);
            rs=st.executeQuery();
            
            //rs=st.executeQuery("select BILL_NO from BILL_SUBMIT where  BILL_NO='"+bill_no+"'");
               
            if(rs.next()==false)
              {
                 JOptionPane.showMessageDialog(null,"bill no not exist please enter the right bill_no!");
              } 
         
             else
              {
            
                st=con.prepareStatement("select USERNAME, BILL_NO, BILL_DETAILS, MANAGER_NAME, DEPT_TYPE, NAME from BILL_SUBMIT where BILL_no=? ");
                st.setInt(1, bill_no);
                rs=st.executeQuery();
                rs.next();
                
                //String sql=("select USERNAME, BILL_NO, BILL_DETAILS, MANAGER_NAME, DEPT_TYPE, NAME from BILL_SUBMIT "
                //        + " where BILL_no='"+bill_no+"' ");
                //rs=st.executeQuery(sql);
                
                
                String usr=rs.getString("username");
                String bd=rs.getString("bill_details");
                String man=rs.getString("manager_name");
                String dt=rs.getString("dept_type");
                String nm=rs.getString("name");
               
              //System.out.println("hello="+usr+"  "+bill_no+"  "+bd+"  "+man+"  "+dt+"  "+nm);
             
              //System.out.println("rejection by manager");
                
                String message="rejected by manager ";
                
                st=con.prepareStatement("insert into BILL_REPORT (USERNAME, BILL_NUM, BILL_DETAILS, DEPT_TYPE, STATUS) values (? , ?, ?, ?, ?) ");
                st.setString(1,usr);
                st.setInt(2, bill_no);
                st.setString(3,bd);
                st.setString(4,dt);
                st.setString(5,message+man);
                rs1=st.executeQuery();
                
               //sql=("insert into BILL_REPORT (USERNAME, BILL_NUM, BILL_DETAILS, DEPT_TYPE, STATUS) "
               //         + "values ('"+usr+"' , '"+bill_no+"' , '"+bd+"' , '"+dt+"' , '" +message+man+ "') ");  
               // rs1=st.executeQuery(sql);
               
              //  System.out.println("ended");
                
               st=con.prepareStatement("delete from BILL_SUBMIT where BILL_no=? ");
               st.setInt(1, bill_no);
               rs=st.executeQuery();
                
              //  sql=("delete from BILL_SUBMIT where BILL_no='"+bill_no+"' ");
              //  rs=st.executeQuery(sql);
               } 
           }
       
        catch(Exception ex)
          {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null,"java.lang.NumberFormatException enter the bill no as integer only");
         }    
    }                                        

 else if(ae.getSource()==b3)
 {
     //System.out.println("show all button");
      try
        {
          connect();

          st=con.prepareStatement("select NAME from LOGIN where USERNAME=? ");
          st.setString(1, s1);
          rs=st.executeQuery();
          rs.next();
              
        //rs=st.executeQuery("select NAME from LOGIN where USERNAME='"+s1+"' ");
        //rs.next();
          
          String s=rs.getString("NAME");
        
          st=con.prepareStatement("SELECT COUNT (bill_no) from BILL_SUBMIT WHERE MANAGER_NAME=? ");
          st.setString(1, s);
          rs=st.executeQuery();
          rs.next();
          
        //rs=st.executeQuery("SELECT COUNT (bill_no) from BILL_SUBMIT WHERE MANAGER_NAME='"+s+"' ");
        //rs.next();
          
          int count=Integer.parseInt(rs.getString(1));
       
         if(count!=0)
         {
       //    System.out.println("count is not zero");
         
          st=con.prepareStatement("select BILL_NO, BILL_DETAILS from BILL_SUBMIT where MANAGER_NAME=? ");
          st.setString(1, s);
          rs1=st.executeQuery();
             
        //rs1=st.executeQuery("select BILL_NO, BILL_DETAILS from BILL_SUBMIT where MANAGER_NAME='"+s+"' ");
          
          JFrame f=new JFrame("bill details");
          f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          f.setLayout(new GridLayout(3,2));
      
          JPanel p=new JPanel();
          p.setLayout(new GridLayout(count+1,2));
          p.setSize(400,700);
          
          p.add(new JLabel("BILL_NO"));
          p.add(new JLabel("BILL_DETAILS"));
          
   //       System.out.println("hey ");
          for(int i=0;i<count;i++)
          {  
     //       System.out.println("hey "+i);
            rs1.next();
       //     System.out.println("hey hellofds"+i);
          
            JTextField j1=new JTextField(rs1.getString("BILL_NO"));
            JTextField j2=new JTextField(rs1.getString("BILL_DETAILS"));
          
            j1.setEditable(false);
            j2.setEditable(false);
            
            p.add(j1); 
            p.add(j2); 
            
            
          }
          
           f.add(p);
           f.setVisible(true);
           f.setSize(400,700);
           f.pack();
          }
        
       else if(count==0)
        {
          JOptionPane.showMessageDialog(null,"you have no bills to be processed!");
        } 
     } 
        catch(Exception ex)
        {
            System.out.println(ex);
        }
  }
 
 
else if(ae.getSource() == b4)
 {
  // System.out.println("sign out");
    try
        {   
          f.dispose();              
          Login l1=new Login();
          l1.setVisible(true);
        }
    catch(Exception ex)
        {
            System.out.println(ex);
        }
  }
}
   
public void go()
  {
    Container cp = f.getContentPane();
    cp.setLayout(null);
    f.setLayout(null);
    
    cp.setSize(980,500);
    f.setSize(980,500);
    f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
    JLabel j1 = new JLabel("Manager's Login");
           j1.setLocation(300,0);
	   j1.setSize(600,40);
	   j1.setFont(new Font("Times New Roman", Font.BOLD, 36 ));
           f.add(j1);
    		 
    JLabel j2 = new JLabel("Update Bill's Status  :");
           j2.setLocation(50,80);
	   j2.setSize(250,30);
	   j2.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j2);
    	
    JLabel j3 = new JLabel("Enter Bill no. :");
           j3.setLocation(50,170);
   	   j3.setSize(200,30);
   	   j3.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j3);
    	
    JLabel j4 = new JLabel("Take Action :");
           j4.setLocation(50,250);
	   j4.setSize(200,30);
	   j4.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j4);
    	
    JLabel j5 = new JLabel("Show All Bills :");
           j5.setLocation(50,330);
	   j5.setSize(200,30);
	   j5.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j5);
    	
           tf = new JTextField();
           tf.setLocation(260,170);
	   tf.setSize(150,30);
	   tf.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(tf);
    
     b1 = new JButton("Accept");
           b1.setLocation(260,250);
	   b1.setSize(120,30);
	   b1.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b1); 
           
            b1.addActionListener(this);
           
     b2 = new JButton("Reject");
           b2.setLocation(390,250);
	   b2.setSize(120,30);
	   b2.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b2); 
           
           b2.addActionListener(this);
     
    ImageIcon icon = new ImageIcon("C://Users/rahul/Documents/NetBeansProjects/billmanagement/src/BAS/managers1.jpg");
    JLabel j6 = new JLabel(icon);
           j6.setLocation(520,80);
   	   j6.setSize(400,400);
   	   f.add(j6);
   
     b3 = new JButton("Show All");
           b3.setLocation(260,330);
	   b3.setSize(180,30);
	   b3.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b3);
           
           b3.addActionListener(this);
           
     b4 = new JButton("Sign out");
           b4.setLocation(290,410);
	   b4.setSize(150,30);
	   b4.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b4);
           
           b4.addActionListener(this);
           f.setVisible(true);
 }

 void setVisible2(boolean b)
  {
      go();
  } 
     
}
