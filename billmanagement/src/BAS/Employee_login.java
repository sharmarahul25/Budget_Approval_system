package BAS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Employee_login extends Login implements ActionListener
{
   JTextField tf1,tf2;
   JTextArea ta;
   JButton b1,b2,b3,b4,b5;
   ResultSet rs1;
   String s1;
   JComboBox jComboBox;
   JFrame f = new JFrame("EMPLOYEE");
   
   public void sendusername(String str)
    {
        s1=str;
    }
    
public void actionPerformed(ActionEvent ae)
{
 if(ae.getSource() ==  b1)
 {
//     System.out.println("reject");
     try
        {   
            connect();
            int updatebill = Integer.parseInt(tf1.getText().trim());
          
            st=con.prepareStatement("select BILL_NO from BILL_SUBMIT where  BILL_NO=?");
            st.setInt(1, updatebill);
            rs=st.executeQuery();
          
         //   rs=st.executeQuery("select BILL_NO from BILL_SUBMIT where  BILL_NO='"+updatebill+"'");
               
            if(rs.next()==false)
              {
                 JOptionPane.showMessageDialog(null,"bill do not exist please enter the right bill_no!");
               } 
         
           else
            {
              st=con.prepareStatement("delete from BILL_SUBMIT where  BILL_NO=?");
              st.setInt(1, updatebill);
              rs=st.executeQuery();
            }
        }
     catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
  }
    
else if(ae.getSource() == b2)	
  {  
  //  System.out.println("show bills");
      try
        {
          connect();
          
          st=con.prepareStatement("SELECT COUNT (bill_no) from BILL_SUBMIT WHERE username=?");
          st.setString(1, s1);
          rs=st.executeQuery();
          rs.next();
          
          int count=Integer.parseInt(rs.getString(1));
    //      System.out.println("count"+count);
       if(count!=0)
       {
          st=con.prepareStatement("select BILL_NO, MANAGER_NAME, DEPT_TYPE, BILL_DETAILS from BILL_SUBMIT WHERE username=?");
          st.setString(1, s1);
          rs=st.executeQuery();
        
      //    rs=st.executeQuery("select BILL_NO, MANAGER_NAME, DEPT_TYPE, BILL_DETAILS from BILL_SUBMIT where USERNAME='"+s1+"' ");
       
          JFrame f=new JFrame("bill details");
          f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          f.setLayout(new GridLayout(3,4));
      
          JPanel p=new JPanel();
          p.setLayout(new GridLayout(count+1,4));
          p.setSize(500,700);
       
          p.add(new JLabel("BILL_NO"));
          p.add(new JLabel("MAN_NAME"));
          p.add(new JLabel("DEPT_TYPE"));
          p.add(new JLabel("BILL_DETAILS"));

          for(int i=0;i<count;i++)
          {  
            rs.next();
            JTextField j1=new JTextField(rs.getString("BILL_NO"));
            JTextField j2=new JTextField(rs.getString("MANAGER_NAME"));
            JTextField j3=new JTextField(rs.getString("DEPT_TYPE"));
            JTextField j4=new JTextField(rs.getString("BILL_DETAILS"));
          
            j1.setEditable(false);
            j2.setEditable(false);
            j3.setEditable(false);
            j4.setEditable(false);
          
            p.add(j1); 
            p.add(j2); 
            p.add(j3); 
            p.add(j4); 
          }
           f.add(p);
           f.setVisible(true);
           f.setSize(800,700);
           f.pack();
       }
       else if(count==0)
        {
          JOptionPane.showMessageDialog(null,"you have not submitted any bill!");
        } 
     }
        
        catch(Exception ex)
           {
                    System.out.println(ex);
           }
         
 }   
         
 else if(ae.getSource()==b3)
   {
     System.out.println("submit");
    try
        {   
            connect();
            int uploadbill    =Integer.parseInt(tf2.getText().trim());
            String billdetail =ta.getText().trim();
            String dept       =(String) jComboBox.getSelectedItem();
            
            st=con.prepareStatement("select BILL_NO from BILL_SUBMIT where  BILL_NO=?");
            st.setInt(1, uploadbill);
            rs=st.executeQuery();
        
            if(rs.next()==true)
              {
                 JOptionPane.showMessageDialog(null,"bill no alloted to another person please enter the right bill_no!");
               } 
         
           else
            {
     //         System.out.println(s1+"  "+uploadbill+"  "+billdetail+"  "+dept);
            
            if(dept.equalsIgnoreCase("TELEPHONE"))
             {
              st=con.prepareStatement("select NAME from LOGIN where LOGIN_TYPE='MANAGER' AND DEPT_TYPE='TELEPHONE' ");
              rs=st.executeQuery();
              rs.next();
               
            //rs=st.executeQuery("select NAME from LOGIN where LOGIN_TYPE='MANAGER' AND DEPT_TYPE='TELEPHONE' ");
            //rs.next();
                
               if(uploadbill%2==1)
                 {
                   String s=rs.getString("name");
       //            System.out.println("inside first if"+s1);
                   
                   st=con.prepareStatement("select NAME from LOGIN where USERNAME=? ");
                   st.setString(1, s1);
                   rs1=st.executeQuery();
                   rs1.next();
    
                 //rs1=st.executeQuery("select NAME from LOGIN where USERNAME='"+s1+"' ");
                 //rs1.next();
       
                   st=con.prepareStatement("insert into BILL_SUBMIT (USERNAME,BILL_NO,BILL_DETAILS,MANAGER_NAME,DEPT_TYPE,NAME) values (?, ?, ?, ?, ?, ? )");
                   st.setString(1, s1);
                   st.setInt   (2,uploadbill);
                   st.setString(3, billdetail);
                   st.setString(4, s);
                   st.setString(5, dept);
                   st.setString(6, rs1.getString("name"));
                   rs=st.executeQuery();         
                   
                //   rs=st.executeQuery("insert into BILL_SUBMIT (USERNAME,BILL_NO,BILL_DETAILS,MANAGER_NAME,DEPT_TYPE,NAME) values "
                //           + "('"+s1+"' , '"+uploadbill+"' , '"+billdetail+"' , '"+s+"' , '"+dept+"' , '"+rs1.getString("name")+"') ");
                 }  
                       
               else
                 { 
                   rs.next();
                   String s=rs.getString("name");
         //          System.out.println("inside first elseif"+s1);
                   
                   st=con.prepareStatement("select NAME from LOGIN where USERNAME=? ");
                   st.setString(1, s1);
                   rs1=st.executeQuery();
                   rs1.next();
                   
                 //rs1=st.executeQuery("select NAME from LOGIN where USERNAME='"+s1+"' ");
                 //rs1.next();
                   
                   st=con.prepareStatement("insert into BILL_SUBMIT (USERNAME,BILL_NO,BILL_DETAILS,MANAGER_NAME,DEPT_TYPE,NAME) values (?, ?, ?, ?, ?, ? )");
                   st.setString(1, s1);
                   st.setInt   (2,uploadbill);
                   st.setString(3, billdetail);
                   st.setString(4, s);
                   st.setString(5, dept);
                   st.setString(6, rs1.getString("name"));
                   rs1=st.executeQuery();         
                   
                 //rs1=st.executeQuery("insert into BILL_SUBMIT (USERNAME,BILL_NO,BILL_DETAILS,MANAGER_NAME,DEPT_TYPE,NAME) values ('"+s1+"' , '"+uploadbill+"' , '"+billdetail+"' , '"+s+"' , '"+dept+"','"+rs1.getString("name")+"') ");
                 }  
             }     
                
            else if(dept.equalsIgnoreCase("ELECTRICITY"))
             {
               st=con.prepareStatement("select NAME from LOGIN where LOGIN_TYPE='MANAGER' AND DEPT_TYPE='ELECTRICITY' ");
               rs=st.executeQuery();
               rs.next();
             //rs=st.executeQuery("select NAME from LOGIN where LOGIN_TYPE='MANAGER' AND DEPT_TYPE='ELECTRICITY' ");
             //rs.next();
                
               if(uploadbill%2==1)
                 {
                   String s=rs.getString("name");
           //        System.out.println("inside second if"+s1);
              
                   st=con.prepareStatement("select NAME from LOGIN where USERNAME=? ");
                   st.setString(1, s1);
                   rs1=st.executeQuery();
                   rs1.next();          
                 //rs1=st.executeQuery("select NAME from LOGIN where USERNAME='"+s1+"' ");
                 //rs1.next();
                   
                   st=con.prepareStatement("insert into BILL_SUBMIT (USERNAME,BILL_NO,BILL_DETAILS,MANAGER_NAME,DEPT_TYPE,NAME) values (?, ?, ?, ?, ?, ? )");
                   st.setString(1, s1);
                   st.setInt   (2,uploadbill);
                   st.setString(3, billdetail);
                   st.setString(4, s);
                   st.setString(5, dept);
                   st.setString(6, rs1.getString("name"));
                   rs=st.executeQuery();         
                   
                 //rs=st.executeQuery("insert into BILL_SUBMIT (USERNAME,BILL_NO,BILL_DETAILS,MANAGER_NAME,DEPT_TYPE,NAME) values ('"+s1+"' , '"+uploadbill+"' , '"+billdetail+"' , '"+s+"' , '"+dept+"' , '"+rs1.getString("name")+"') ");
                 }  
                       
               else
                 { 
                   rs.next();
                   String s=rs.getString("name");
             //      System.out.println("inside second elseif"+s1);
                   
                   st=con.prepareStatement("select NAME from LOGIN where USERNAME=? ");
                   st.setString(1, s1);
                   rs1=st.executeQuery();
                   rs1.next();
                 
                 //rs1=st.executeQuery("select NAME from LOGIN where USERNAME='"+s1+"' ");
                 //rs1.next();
                   
                   st=con.prepareStatement("insert into BILL_SUBMIT (USERNAME,BILL_NO,BILL_DETAILS,MANAGER_NAME,DEPT_TYPE,NAME) values (?, ?, ?, ?, ?, ? )");
                   st.setString(1, s1);
                   st.setInt   (2,uploadbill);
                   st.setString(3, billdetail);
                   st.setString(4, s);
                   st.setString(5, dept);
                   st.setString(6, rs1.getString("name"));
                   rs1=st.executeQuery();         
                   
                 //rs1=st.executeQuery("insert into BILL_SUBMIT (USERNAME,BILL_NO,BILL_DETAILS,MANAGER_NAME,DEPT_TYPE,NAME) values ('"+s1+"' , '"+uploadbill+"' , '"+billdetail+"' , '"+s+"' , '"+dept+"','"+rs1.getString("name")+"') ");
                 }  
             }
         }
     }
     catch(Exception ex)
        {
          System.out.println(ex);
           JOptionPane.showMessageDialog(null,ex);
           // JOptionPane.showMessageDialog(null,"java.lang.NumberFormatException enter the bill no as integer only");
        }
       
    }                                            

else if(ae.getSource() == b4)
 {
   System.out.println("show status");
    try
      {   
          connect();
          
           st=con.prepareStatement("SELECT COUNT (bill_num) from BILL_REPORT WHERE username=? ");
           st.setString(1, s1);
           rs=st.executeQuery();
           rs.next();
         //rs=st.executeQuery("SELECT COUNT (bill_num) from BILL_REPORT WHERE username='"+s1+"' ");
         //rs.next();
          
          int count=Integer.parseInt(rs.getString(1));
     
         if(count!=0)
         {
           st=con.prepareStatement("select BILL_NUM, BILL_DETAILS, DEPT_TYPE, STATUS from BILL_REPORT where username=? ");
           st.setString(1, s1);
           rs=st.executeQuery();
          
         //rs=st.executeQuery("select BILL_NUM, BILL_DETAILS, DEPT_TYPE, STATUS from BILL_REPORT where USERNAME='"+s1+"' ");
       
          JFrame f=new JFrame("bill details");
          f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          f.setLayout(new GridLayout(3,4));
      
          JPanel p=new JPanel();
          p.setLayout(new GridLayout(count+1,4));
          p.setSize(800,700);
          
          p.add(new JLabel("BILL_NO"));
          p.add(new JLabel("BILL_DETAILS"));
          p.add(new JLabel("DEPT_TYPE"));
          p.add(new JLabel("STATUS"));
       
          for(int i=0;i<count;i++)
          {  
            rs.next();
            JTextField j1=new JTextField(rs.getString("BILL_NUM"));
            JTextField j2=new JTextField(rs.getString("BILL_DETAILS"));
            JTextField j3=new JTextField(rs.getString("DEPT_TYPE"));
            JTextField j4=new JTextField(rs.getString("STATUS"));
             
            j1.setEditable(false);
            j2.setEditable(false);
            j3.setEditable(false);
            j4.setEditable(false);

            p.add(j1); 
            p.add(j2); 
            p.add(j3); 
            p.add(j4); 
          }    
 
           f.add(p);
           f.setVisible(true);
           f.setSize(800,700);
           f.pack();
         }
       else if(count==0)
        {
          JOptionPane.showMessageDialog(null,"you have not submitted any bill!");
        }  
      }   

    catch(Exception ex)
        {
            System.out.println(ex);
        }
   }


else if(ae.getSource() == b5)
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
    f.setLayout(null);
    
    f.setSize(1050,570);
    f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
    JLabel j1 = new JLabel("Employee's Login");
           j1.setLocation(400,0);
	   j1.setSize(700,40);
	   j1.setFont(new Font("Times New Roman", Font.BOLD, 36 ));
           f.add(j1);
    
    JLabel j2 = new JLabel("Department :");
           j2.setLocation(50,60);
	   j2.setSize(170,30);
	   j2.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j2);
    
            jComboBox = new JComboBox();
            jComboBox.setModel(new DefaultComboBoxModel(new String[] { "TELEPHONE", "ELECTRICITY" } ));
            jComboBox.setLocation(310,60);
            jComboBox.setSize(200,30);
            jComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
            f.add(jComboBox);
    
    JLabel j3 = new JLabel("Update Bill's Status  :");
           j3.setLocation(50,120);
	   j3.setSize(250,30);
	   j3.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j3);
    	
    JLabel j4 = new JLabel("Enter Bill no. :");
           j4.setLocation(50,170);
   	   j4.setSize(250,30);
   	   j4.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j4);
    	
           tf1 = new JTextField();
           tf1.setLocation(310,170);
	   tf1.setSize(150,30);
	   tf1.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(tf1);
         
           b1 = new JButton("Reject");
           b1.setLocation(470,170);
	   b1.setSize(120,30);
	   b1.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b1); 
           
            b1.addActionListener(this);
    
   JLabel j5 = new JLabel("Show All Bill's :");
           j5.setLocation(50,220);
	   j5.setSize(250,30);
	   j5.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j5);
    	
           b2 = new JButton("Show Bills");
           b2.setLocation(310,220);
	   b2.setSize(150,30);
	   b2.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b2); 
           b2.addActionListener(this);
   
    JLabel j10 = new JLabel("Show All Bill's Status :");
           j10.setLocation(50,270);
	   j10.setSize(250,30);
	   j10.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j10);
    	
           b4 = new JButton("Show Status");
           b4.setLocation(310,270);
	   b4.setSize(200,30);
	   b4.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b4); 
           
           b4.addActionListener(this);
   
    JLabel j6 = new JLabel("Upload Bill's :");
           j6.setLocation(50,320);
	   j6.setSize(250,30);
	   j6.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j6);
    	
    JLabel j7 = new JLabel("Enter new bill no. :");
           j7.setLocation(50,360);
	   j7.setSize(250,30);
	   j7.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j7);
     
           tf2 = new JTextField();
           tf2.setLocation(310,360);
	   tf2.setSize(150,30);
	   tf2.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(tf2);
          
           b3 = new JButton("Submit");
           b3.setLocation(470,360);
	   b3.setSize(120,30);
	   b3.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b3);
           
           b3.addActionListener(this);
          
    JLabel j8 = new JLabel("Enter bill details. :");
           j8.setLocation(50,410);
	   j8.setSize(250,30);
	   j8.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(j8);
          
           ta = new JTextArea();
           ta.setLocation(310,410);
	   ta.setSize(250,80);
	   ta.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(ta);
           
    ImageIcon icon = new ImageIcon("C://Users/rahul/Documents/NetBeansProjects/billmanagement/src/BAS/employee.jpg");
    JLabel j9 = new JLabel(icon);
           j9.setLocation(610,50);
   	   j9.setSize(400,400);
   	   f.add(j9);
   
          
           b5 = new JButton("Sign Out");
           b5.setLocation(580,470);
	   b5.setSize(150,30);
	   b5.setFont(new Font("Times New Roman", Font.BOLD, 24 ));
           f.add(b5);
           
           b5.addActionListener(this);
           
           f.setVisible(true);
//System.out.println("frame developed");
  }
  
  void setVisible1(boolean b)
  {
      go();
  } 
 
}
