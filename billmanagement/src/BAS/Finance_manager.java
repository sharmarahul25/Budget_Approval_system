package BAS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Finance_manager  extends Login implements ActionListener
{
  JTextField tf;
  JButton b1,b2,b3;
  ResultSet rs1;
  JFrame f = new JFrame("finance manager");
      
  public void sendusername(String str)
    {
       super.username=str;
//       System.out.println(super.username);
    }
 
  
public void actionPerformed(ActionEvent ae)
{
 if(ae.getSource() == b2)	
  {
   System.out.println("show bills");
   try
     {
           super.connect();
//          System.out.println(super.username);
      
           
           
          st=con.prepareStatement("SELECT COUNT (bill_no) from FINANCE_BILL");
          rs=st.executeQuery();
          rs.next();
           
        //rs=st.executeQuery("SELECT COUNT (bill_no) from FINANCE_BILL ");
        //rs.next();
        //System.out.println("helloup");
        
          int count=Integer.parseInt(rs.getString(1));
        //System.out.println("hellodown");
            
         if(count!=0)
         {
            st=con.prepareStatement("select NAME, BILL_NO, BILL_DETAILS, MANAGER_NAME, DEPT_TYPE from FINANCE_BILL");
            rs=st.executeQuery();
          
          //String sql=("select NAME, BILL_NO, BILL_DETAILS, MANAGER_NAME, DEPT_TYPE from FINANCE_BILL");
          //rs=st.executeQuery(sql);
             
            JFrame f=new JFrame("bill details");
            f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            f.setLayout(new GridLayout(3,5));
      
            JPanel p=new JPanel();
            p.setLayout(new GridLayout(count+1,5));
            p.setSize(500,700);
            p.add(new JLabel("NAME"));
            p.add(new JLabel("BILL_NO"));
            p.add(new JLabel("BILL_DETAILS"));
            p.add(new JLabel("MANAGER_NAME"));
            p.add(new JLabel("DEPT_TYPE"));
          
            for(int i=0;i<count;i++)
             {  
              rs.next();
             JTextField j1=new JTextField(rs.getString("NAME"));
             JTextField j2=new JTextField(rs.getString("BILL_NO"));
             JTextField j3=new JTextField(rs.getString("BILL_DETAILS"));
             JTextField j4=new JTextField(rs.getString("MANAGER_NAME"));
             JTextField j5=new JTextField(rs.getString("DEPT_TYPE"));
             
             j1.setEditable(false);  j2.setEditable(false); j3.setEditable(false);  j4.setEditable(false); j5.setEditable(false);
             
             p.add(j1); p.add(j2);  p.add(j3); p.add(j4); p.add(j5);
             
           }
          
            f.add(p);
            f.setVisible(true);
            f.setSize(700,700);
            f.pack();
        }
        
       else if(count==0)
        {
          JOptionPane.showMessageDialog(null,"you have no further bills left!");
        } 
     }
   catch(Exception ex)
        {
            System.out.println(ex);
        }
  } 
  
 else if(ae.getSource()==b1)
  {
      //System.out.println("accept");
                                                
      try
        {   
            connect();
            int updatebill = Integer.parseInt(tf.getText().trim());
            
            st=con.prepareStatement("select BILL_NO,MANAGER_NAME from FINANCE_BILL where  BILL_NO=?");
            st.setInt(1, updatebill);
            rs=st.executeQuery();
          
          //rs=st.executeQuery("select BILL_NO,MANAGER_NAME from FINANCE_BILL where  BILL_NO='"+updatebill+"'");
            
            if(rs.next()==false)
              {
                 JOptionPane.showMessageDialog(null,"bill no not exist please enter the right bill_no!");
              } 
          
           else
            { 
              String man=rs.getString("manager_name");
  //          System.out.println(man);
               
             st=con.prepareStatement("select STATUS from BILL_REPORT where BILL_NUM=?");
             st.setInt(1, updatebill);
             rs=st.executeQuery();
             rs.next();
          
           //String sql=("select STATUS from BILL_REPORT where BILL_NUM='"+updatebill+"'");
           //rs=st.executeQuery(sql);
           //rs.next();
           //System.out.println(rs.getString("status"));
              
             String s="FM accepted bill submitted by "+man;
              
             st=con.prepareStatement("update BILL_REPORT set STATUS=? where BILL_NUM=?");
             st.setString(1, s);
             st.setInt(2, updatebill);
             rs=st.executeQuery();
           
           //sql="update BILL_REPORT set STATUS='"+s+"' where BILL_NUM='"+updatebill+"'";
           //System.out.println(sql);
           //rs=st.executeQuery(sql);
                
             st=con.prepareStatement("delete from FINANCE_BILL where  BILL_NO=?");
             st.setInt(1, updatebill);
             rs=st.executeQuery();
             
           //rs=st.executeQuery("delete from FINANCE_BILL where  BILL_NO='"+updatebill+"'");
            }
        }
     catch(Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null,"java.lang.NumberFormatException enter the bill no as integer only");
        }
           
  }
 
 
else if(ae.getSource() == b3)
 {
   System.out.println("sign out");
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
    
    cp.setSize(1000,500);
    f.setSize(1000,500);
    f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
    JLabel j1 = new JLabel("Finance Manager's Login");
           j1.setLocation(300,0);
	   j1.setSize(700,40);
	   j1.setFont(new Font("Times New Roman", Font.BOLD, 36 ));
           f.add(j1);
    
    JLabel j2 = new JLabel("Update Bill's Status  :");
           j2.setLocation(50,80);
	   j2.setSize(250,25);
	   j2.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j2);
   	
    JLabel j3 = new JLabel("Enter Bill no. :");
           j3.setLocation(50,160);
   	   j3.setSize(250,25);
   	   j3.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j3);

   
   ImageIcon icon = new ImageIcon("C://Users/rahul/Documents/NetBeansProjects/billmanagement/src/BAS/finance manager.jpg");
    JLabel j6 = new JLabel(icon);
           j6.setLocation(500,80);
   	   j6.setSize(400,400);
   	   f.add(j6);
   	
    JLabel j4 = new JLabel("Take Action :");
           j4.setLocation(50,240);
	   j4.setSize(250,25);
	   j4.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j4);
   	
    JLabel j5 = new JLabel("Show All Bills :");
           j5.setLocation(50,320);
	   j5.setSize(250,25);
	   j5.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j5);
   	
           tf = new JTextField();
           tf.setLocation(330,160);
	   tf.setSize(150,25);
	   tf.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(tf);
   
     b1 = new JButton("Accept");
           b1.setLocation(330,240);
	   b1.setSize(120,30);
	   b1.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b1); 
           b1.addActionListener(this);
   	
     b2 = new JButton("Show All");
           b2.setLocation(330,325);
	   b2.setSize(150,30);
	   b2.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b2);
           b2.addActionListener(this);
   
     b3 = new JButton("Sign Out");
           b3.setLocation(340,410);
	   b3.setSize(150,30);
	   b3.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b3);
           b3.addActionListener(this);

         f.setVisible(true);

   }


public void setVisible3(boolean b)
  {
      go();
  } 
 }
 