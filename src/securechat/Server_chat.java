
package securechat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Random;

public class Server_chat extends javax.swing.JFrame{

    static ServerSocket ssckt;  
    static Socket sckt;  
    static DataInputStream dtinpt;  
    static DataOutputStream dtotpt;
    static String msgout = "";
    static String msgout1 = "";
    static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static Integer s_chk_flag =0;
    static Integer input;
    static Integer got;
    
    public Server_chat() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        server_session_key = new javax.swing.JTextField();
        OK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        server_area = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Server_input = new javax.swing.JTextArea();
        server_send = new javax.swing.JButton();
        back = new javax.swing.JButton();
        report = new javax.swing.JTextField();
        s_verify = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(33, 97, 140));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURE-COMMUNICATION AREA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(169, 204, 227));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel2.setText("ENTER THE SESSION KEY : ");

        server_session_key.setBackground(new java.awt.Color(169, 204, 227));
        server_session_key.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        server_session_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        OK.setBackground(new java.awt.Color(20, 143, 119));
        OK.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        server_area.setEditable(false);
        server_area.setBackground(new java.awt.Color(236, 240, 241));
        server_area.setColumns(20);
        server_area.setFont(new java.awt.Font("Agency FB", 2, 24)); // NOI18N
        server_area.setRows(100);
        jScrollPane1.setViewportView(server_area);

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel4.setText("ENTER MESSAGE");

        Server_input.setBackground(new java.awt.Color(236, 240, 241));
        Server_input.setColumns(20);
        Server_input.setFont(new java.awt.Font("Agency FB", 2, 24)); // NOI18N
        Server_input.setRows(5);
        jScrollPane2.setViewportView(Server_input);

        server_send.setBackground(new java.awt.Color(22, 160, 133));
        server_send.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        server_send.setText("SEND");
        server_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_sendActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(192, 57, 43));
        back.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        report.setBackground(new java.awt.Color(236, 240, 241));
        report.setFont(new java.awt.Font("Agency FB", 2, 36)); // NOI18N
        report.setForeground(new java.awt.Color(255, 0, 51));
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });

        s_verify.setBackground(new java.awt.Color(46, 134, 193));
        s_verify.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        s_verify.setText("VERIFY");
        s_verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_verifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(server_session_key, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(s_verify, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(report, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(235, 235, 235))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(server_send, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(192, 192, 192)))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(s_verify, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(report))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(server_send, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(server_session_key, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        // TODO add your handling code here:
        String a = server_session_key.getText();
        input = Integer.parseInt(a);  
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sc_base","sc_base");
            
            PreparedStatement ps2 = con.prepareStatement("delete from SK");
            ps2.executeUpdate();
            
            PreparedStatement ps1 = con.prepareStatement("insert into SK values(?)");
            
            ps1.setInt(1, input);
            
           int res1 = ps1.executeUpdate();
           
            
           if(res1>0){
               
               JOptionPane.showMessageDialog(null, " Session Key Established " );
               
           }
        }

        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR !");
        }
        
    }//GEN-LAST:event_OKActionPerformed
  
    
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        Server_window bk = new Server_window();
        bk.setVisible(true);
        bk.pack();
        bk.setLocationRelativeTo(null);
        bk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed
    
    public static String encrypt(String plainText, int shiftKey)
    {
	plainText = plainText.toLowerCase();
	String cipherText = "";
	for (int i = 0; i < plainText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
	    int keyVal = (shiftKey + charPosition) % 26;
	    char replaceVal = ALPHABET.charAt(keyVal);
	    cipherText += replaceVal;
	}
	    return cipherText;
    }

    public static String decrypt(String cipherText, int shiftKey)
    {
	cipherText = cipherText.toLowerCase();
	String plainText = "";
	for (int i = 0; i < cipherText.length(); i++)
	{
	    int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
	    int keyVal = (charPosition - shiftKey) % 26;
	    if (keyVal < 0)
	    {
	        keyVal = ALPHABET.length() + keyVal;
	    }
	    char replaceVal = ALPHABET.charAt(keyVal);
	    plainText += replaceVal;
	}
	return plainText;
    }

    
    
    private void server_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_sendActionPerformed
        // TODO add your handling code here:
        try  
        {  
              
            msgout = Server_input.getText().trim();
            //encrypt
            msgout1=encrypt(msgout, input);            
            dtotpt.writeUTF(msgout1);
            server_area.setText(server_area.getText().trim()+"\n\t\t\t Server: "+msgout);
            Server_input.setText("");
  
        }  
        
        catch (Exception e)  
        {  
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR !");

        }
        
    }//GEN-LAST:event_server_sendActionPerformed

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportActionPerformed

    private void s_verifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_verifyActionPerformed
               
        s_chk_flag = 0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sc_base","sc_base");
            
            Statement st = con.createStatement();
            
            ResultSet rs3 = st.executeQuery("select * from CK");
            
            while(rs3.next()){
                
                got = rs3.getInt("ses_key");
                
            }
            
        }
        
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"NO session key found!");
            
        }
                        
        
        //s_chk_flag = 0;
        Integer k = 0;
        if(input!=got){
            k++;
        }
        System.out.println(k);
        if(k==0){
            report.setText(" The receiptent is authorised!");
            s_chk_flag++;
        }
        
        else{
            report.setText("The receiptent may be compromised !!");
        }
        
    }//GEN-LAST:event_s_verifyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //Client_chat cc = new Client_chat();
        //Integer y = cc.return_cval();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server_chat().setVisible(true);
            }
        });
        
        String msgin = "";  
        String msgin1 = "";
        //if(s_chk_flag>0){
        try  
        {  
            ssckt = new ServerSocket(1201);  
            sckt = ssckt.accept();  
            dtinpt = new DataInputStream(sckt.getInputStream());  
            dtotpt = new DataOutputStream(sckt.getOutputStream());  
            while(!msgin.equals("exit"))  
            {  
                msgin =dtinpt.readUTF();           
                
                msgin1=decrypt(msgin,input);
                server_area.setText(server_area.getText().trim()+"\nClient: "+msgin1);   
            }  
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR !");
            
        }
        //}
        /**else{
            try{
                Random rand= new Random();
                Integer slen =rand.nextInt(15);
                File file = new File("G:\\Subjected\\C programs\\words1.txt");
                BufferedReader b = new BufferedReader(new FileReader(file));
                String sreadLine = "";
                Integer count = 0;
                while ((sreadLine = b.readLine()) != null) {
                    count=sreadLine.length();
                    if(slen == count){
                        server_area.setText(server_area.getText().trim()+"\nClient: "+sreadLine);
                    }
                        
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }*/
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton OK;
    private javax.swing.JTextArea Server_input;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField report;
    private javax.swing.JButton s_verify;
    private static javax.swing.JTextArea server_area;
    private javax.swing.JButton server_send;
    public static javax.swing.JTextField server_session_key;
    // End of variables declaration//GEN-END:variables
}
