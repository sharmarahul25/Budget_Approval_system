package BAS;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.*;
import java.text.*;
import java.util.regex.*;


public class Sign_up extends javax.swing.JFrame 
{
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    public Sign_up() 
    {
        initComponents(); 
    }

    public void connect()
    {
                try
          {     
            String driverName ="oracle.jdbc.driver.OracleDriver";//to access databse
            Class.forName(driverName);//loading the driver
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","system","71687");
           }
        
        catch(Exception ex)
           {
            System.out.println(ex);
           }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headingsignup = new javax.swing.JLabel();
        namelabel = new javax.swing.JLabel();
        mbnolabel = new javax.swing.JLabel();
        emaillabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        passlabel = new javax.swing.JLabel();
        logintypelabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        Passwdtf = new javax.swing.JPasswordField();
        usernametf = new javax.swing.JTextField();
        emailidtf = new javax.swing.JTextField();
        mobiletf = new javax.swing.JTextField();
        nametf = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        logintypelabel2 = new javax.swing.JLabel();
        logintypelabel1 = new javax.swing.JLabel();
        securitylabel = new javax.swing.JLabel();
        teacherlabel = new javax.swing.JLabel();
        anstf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        headingsignup.setFont(new java.awt.Font("Times New Roman", 1, 36));
        headingsignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingsignup.setText("Sign Up Form");

        namelabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
        namelabel.setText("Name :");

        mbnolabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
        mbnolabel.setText("Mobile no. :");

        emaillabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        emaillabel.setText("Email Id :");

        usernamelabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
        usernamelabel.setText("Username :");

        passlabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
        passlabel.setText("Password :");

        logintypelabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
        logintypelabel.setText("Login Type :");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EMPLOYEE", "MANAGER", "FINANCE_MANAGER" }));

        usernametf.setFont(new java.awt.Font("Times New Roman", 1, 18));

        emailidtf.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        emailidtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailidtfKeyTyped(evt);
            }
        });

        mobiletf.setFont(new java.awt.Font("Times New Roman", 1, 18));
        mobiletf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobiletfKeyTyped(evt);
            }
        });

        nametf.setFont(new java.awt.Font("Times New Roman", 1, 18));

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TELEPHONE", "ELECTRICITY" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        logintypelabel2.setFont(new java.awt.Font("Times New Roman", 0, 12));
        logintypelabel2.setText("Only For Manager");

        logintypelabel1.setFont(new java.awt.Font("Times New Roman", 1, 24));
        logintypelabel1.setText("Department:");

        securitylabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
        securitylabel.setText("Security Question :");

        teacherlabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
        teacherlabel.setText("What is your's first class teacher's name?");

        anstf.setFont(new java.awt.Font("Times New Roman", 1, 18));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BAS/sign up.jpg"))); // NOI18N

        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(headingsignup, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)))
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(anstf, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButton1)))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logintypelabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logintypelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mbnolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emaillabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(emailidtf, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(usernametf, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nametf, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Passwdtf, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(logintypelabel2))
                            .addComponent(mobiletf, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(securitylabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(teacherlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(headingsignup)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nametf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namelabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mbnolabel)
                            .addComponent(mobiletf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emaillabel)
                            .addComponent(emailidtf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(usernamelabel)
                                    .addComponent(usernametf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(passlabel))
                            .addComponent(Passwdtf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(logintypelabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logintypelabel1)
                            .addComponent(logintypelabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(teacherlabel)
                            .addComponent(securitylabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(anstf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        connect();
        try 
        {
            String name       = nametf.getText().trim();
            float mobile_no     = Float.parseFloat(mobiletf.getText().trim());
            String email      = emailidtf.getText().trim();
            String username   = usernametf.getText().trim();
            String password   = Passwdtf.getText().trim();
            String login_type =(String) jComboBox1.getSelectedItem();
            String dept       =(String) jComboBox2.getSelectedItem();
            String ans        = anstf.getText().trim();
            
            st = con.prepareStatement("select LOGIN_TYPE from LOGIN where USERNAME =?");
            st.setString(1, username);
            rs=st.executeQuery();
            
            if(rs.next()==true)
            {
                JOptionPane.showMessageDialog(null,"username or email-id not available please sign up again!");
            }
            else
            {
                if(login_type.equalsIgnoreCase("MANAGER")) 
                  {
                    st = con.prepareStatement("insert into LOGIN (NAME,MOBILE_NO,EMAIL_ID,USERNAME,PASSWORD,LOGIN_TYPE,SECURITY_ANS,DEPT_TYPE)"
                            + " values (?, ?, ?, ?, ?, ?, ?, ?)");
                    st.setString(1, name);
                    st.setFloat(2, mobile_no);
                    st.setString(3, email);
                    st.setString(4, username);
                    st.setString(5, password);
                    st.setString(6, login_type);
                    st.setString(7, ans);
                    st.setString(8, dept);
                         
                    rs=st.executeQuery();  
                   }
                else
                  {
                    dept=null;
                    st = con.prepareStatement("insert into LOGIN (NAME,MOBILE_NO,EMAIL_ID,USERNAME,PASSWORD,LOGIN_TYPE,SECURITY_ANS,DEPT_TYPE)"
                            + " values (?, ?, ?, ?, ?, ?, ?, ?)");
                    st.setString(1, name);
                    st.setFloat(2, mobile_no);
                    st.setString(3, email);
                    st.setString(4, username);
                    st.setString(5, password);
                    st.setString(6, login_type);
                    st.setString(7, ans);
                    st.setString(8, dept);
                         
                    rs=st.executeQuery();  
                  }
            }
        
       this.dispose();
        Login l2=new Login();
        l2.setVisible(true);
        
        }
        
        catch(Exception ex)
        {
             JOptionPane.showMessageDialog(null,"java.lang.NumberFormatException enter the mobile no as integer only");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyTyped

    }//GEN-LAST:event_jLabel2KeyTyped

    private void emailidtfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailidtfKeyTyped
        String email=emailidtf.getText();
        String exp="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence seq = email;
        Pattern pattern = Pattern.compile(exp,Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(seq);
        if (m.matches()) 
            jLabel2.setVisible(false);

        else 
        {
            jLabel2.setText("* Invalid Email ID");
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_emailidtfKeyTyped

    private void mobiletfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobiletfKeyTyped
       String input =mobiletf.getText();
       Pattern p = Pattern.compile("[A-Z,a-z,&%$@!()*^]");
       Matcher m = p.matcher(input);
       
       if (m.find()) 
        {
          jLabel3.setText("* Enter only Numeric Value");
          jLabel3.setVisible(true);
          jLabel3.setForeground(Color.red);
        }

       else
          jLabel3.setVisible(false);
               // TODO add your handling code here:
    }//GEN-LAST:event_mobiletfKeyTyped
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {

      public void run()
      {
                new Sign_up().setVisible(true);
      }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Passwdtf;
    private javax.swing.JTextField anstf;
    private javax.swing.JTextField emailidtf;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JLabel headingsignup;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logintypelabel;
    private javax.swing.JLabel logintypelabel1;
    private javax.swing.JLabel logintypelabel2;
    private javax.swing.JLabel mbnolabel;
    private javax.swing.JTextField mobiletf;
    private javax.swing.JLabel namelabel;
    private javax.swing.JTextField nametf;
    private javax.swing.JLabel passlabel;
    private javax.swing.JLabel securitylabel;
    private javax.swing.JLabel teacherlabel;
    private javax.swing.JLabel usernamelabel;
    private javax.swing.JTextField usernametf;
    // End of variables declaration//GEN-END:variables
}
