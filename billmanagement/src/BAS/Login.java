package BAS;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame 
{

    Connection con;
    PreparedStatement st;
    ResultSet rs;
    public String username;
    public String password;
    
    public Login()
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        loginbutton = new javax.swing.JButton();
        signupbutton = new javax.swing.JButton();
        forgotpasswdbutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36));
        jLabel1.setText("BUDGET APPROVAL SYSTEM");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel2.setText("USERNAME*:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel3.setText("PASSWORD*:");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        loginbutton.setFont(new java.awt.Font("Times New Roman", 1, 18));
        loginbutton.setText("LOGIN");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });

        signupbutton.setFont(new java.awt.Font("Times New Roman", 1, 18));
        signupbutton.setText("Sign Up");
        signupbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbuttonActionPerformed(evt);
            }
        });

        forgotpasswdbutton.setFont(new java.awt.Font("Times New Roman", 1, 18));
        forgotpasswdbutton.setText("Forgot Password");
        forgotpasswdbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotpasswdbuttonActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BAS/BUDGET.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(195, 195, 195))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signupbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgotpasswdbutton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(loginbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addComponent(loginbutton)
                        .addGap(33, 33, 33)
                        .addComponent(signupbutton)
                        .addGap(24, 24, 24)
                        .addComponent(forgotpasswdbutton))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
       try
         {
          connect();
 
          username=jTextField1.getText().trim();
          password=jPasswordField1.getText().trim();

          String str="select LOGIN_TYPE from LOGIN where USERNAME =? and PASSWORD=? ";
          st=con.prepareStatement(str);
          st.setString(1, username);
          st.setString(2, password);

          rs=st.executeQuery();
         
        //rs=st.executeQuery("select LOGIN_TYPE from LOGIN where USERNAME ='"+username+"' and PASSWORD='"+password+"'" );
               
         if(rs.next()==false)
           {
             JOptionPane.showMessageDialog(null,"username or password not exist or is wrong!");
           }
         else 
           {
               this.dispose();
            if(rs.getString(1).equalsIgnoreCase("EMPLOYEE"))
               {
		 Employee_login em=new Employee_login();
                 em.sendusername(username);
                 em.setVisible1(true);
               }
             else if(rs.getString("LOGIN_TYPE").equalsIgnoreCase("MANAGER"))
               {
		 Manager_login mg=new Manager_login();
                 mg.sendusername(username);
                 mg.setVisible2(true);
               }
             else if(rs.getString("LOGIN_TYPE").equalsIgnoreCase("FINANCE_MANAGER"))
               {
		 Finance_manager fm=new Finance_manager();
                 fm.sendusername(username);
                 fm.setVisible3(true);
               }
            }
        
         }
          
         catch(Exception ex)
          {
            System.out.println(ex);
          }
        
    }//GEN-LAST:event_loginbuttonActionPerformed

    private void signupbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbuttonActionPerformed
        Sign_up sign=new Sign_up();
        this.dispose();
        sign.setVisible(true);
    }//GEN-LAST:event_signupbuttonActionPerformed

    private void forgotpasswdbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotpasswdbuttonActionPerformed
             username=jTextField1.getText().trim();
             //System.out.println("hello");
             Forget_password fp=new Forget_password(); 
             fp.sendusername(username);
             this.dispose();
             fp.setVisible(true);
        
    }//GEN-LAST:event_forgotpasswdbuttonActionPerformed
  
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgotpasswdbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton loginbutton;
    private javax.swing.JButton signupbutton;
    // End of variables declaration//GEN-END:variables
}
