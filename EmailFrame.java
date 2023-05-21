/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication1;

import com.sun.mail.pop3.POP3Store;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Properties;
import java.util.Random;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class EmailFrame extends javax.swing.JFrame {

    /**
     * Creates new form EmailFrame
     */
    public EmailFrame() {
        initComponents();
    }

    public String rssa_chifrement (String subject) {


//___________//generation p,q,n,f,e,d_____________________________________________________________________________________	
		BigInteger p= new BigInteger("11");
		BigInteger q= new BigInteger("13");
		BigInteger n=p.multiply(q);
		BigInteger f=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		
		BigInteger e=new BigInteger("47");
		BigInteger d=e.modInverse(f);
//______________convert a message to a list__________________________________________________________________________
		char[] charmsg=subject.toCharArray();
		int msgascii[]=new int[subject.length()];
		for(int i=0;i<subject.length();i++) {
			msgascii[i]=(int)charmsg[i];
		}
//________________//encryption
		int[] msgcrypt=new int[subject.length()];
		for(int i=0;i<subject.length();i++) {
			BigInteger nb=BigInteger.valueOf(msgascii[i]);
			msgcrypt[i]=nb.modPow(e, n).intValue();		
		}
                String msg="";
                for(int i  = 0;i<msgcrypt.length;i++){
                    msg += (char)msgcrypt[i];
                }
                 
//	System.out.println("le message crypte est : "+msgcrypt.toString());
        return msg;
    }

    public String dechifrer_rssa (String message) {
         //___________//generation of p,q,n,f,e,d_____________________________________________________________________________________
		
		BigInteger p= new BigInteger("11");
		BigInteger q= new BigInteger("13");
		BigInteger n=p.multiply(q);
		BigInteger f=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		Random rnd=new Random() ;
		BigInteger e=new BigInteger("47");
		BigInteger d=e.modInverse(f);
		char[] msgcrypt=message.toCharArray();
               String msg="";
               //we decrypte each value of the message encrypter by a private key
        for(int i=0;i<message.length();i++) {
			BigInteger nb=BigInteger.valueOf(msgcrypt[i]);
			int decode=nb.modPow(d, n).intValue();
                        msg += (char)decode ; 
			//System.out.print((char)decode);
		}
              //  System.out.println();
                return msg ;
    }
  


//--------------------------------------------GRAPHICAL USER INTERFACE-----------------------------------------------------------------------


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        recepient = new javax.swing.JTextField();
        sendEmail = new javax.swing.JButton();
        receiveEmail = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        recepient1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        recepient2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(447, 328));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Email : ");

        username.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Email de destinataire :");

        jLabel3.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3.setFont(new java.awt.Font("Goudy Old Style", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WELCOME GUYS !!!");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Password :");

        recepient.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        recepient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recepientActionPerformed(evt);
            }
        });

        sendEmail.setBackground(new java.awt.Color(0, 255, 0));
        sendEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        sendEmail.setText("Send Email");
        sendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmailActionPerformed(evt);
            }
        });

        receiveEmail.setBackground(new java.awt.Color(51, 255, 0));
        receiveEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        receiveEmail.setText("Receive Email");
        receiveEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveEmailActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Copyright © 2022 oussama lboughaz");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Subject :");

        recepient1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        recepient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recepient1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Texte :");

        recepient2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        recepient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recepient2ActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(receiveEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(49, 49, 49)
                        .addComponent(sendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(recepient2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                            .addComponent(recepient1))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jPasswordField1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recepient))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recepient, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recepient1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recepient2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(receiveEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//--------------------------------------------GRAPHICAL USER INTERFACE-----------------------------------------------------------------------



    private void recepientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recepientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recepientActionPerformed

    private void sendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmailActionPerformed
       String Username = username.getText() ; 
       String Password = jPasswordField1.getText() ;
       String Recipient = recepient.getText() ;
       String subject = recepient1.getText();
       String texte = recepient2.getText();
       
       
       // final String subject = "subject java oussama elmaimoui  ";
        String subjectCH = rssa_chifrement (subject);
        
      //  final String emailmessage = "lboughazz eewolhhlboughazz eewolhhlboughazz eewolhhlboughazz eewolhh lboughaz  safe nelboughaz  safe ne";
        String texteCH = rssa_chifrement (texte);
  
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, Password);
            }
          });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,    InternetAddress.parse(Recipient));
            message.setSubject(subjectCH.toString());
            message.setText(texteCH.toString());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        
        JOptionPane.showMessageDialog(null, "the message sended  succesfully !! ");
        
        
        
    }//GEN-LAST:event_sendEmailActionPerformed

    private void receiveEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveEmailActionPerformed

    String pop3Host = "pop.gmail.com";
    String storeType = "pop3s";      
    String user = username.getText() ; 
    String Pass = jPasswordField1.getText() ;
 try {  
      
      
      
   //1) get the session object  
   Properties properties = new Properties();  
   properties.put("mail.pop3.host", pop3Host);
   properties.put("mail.pop3.port", "995");
   properties.put("mail.pop3.starttls.enable", "true");
   Session emailSession = Session.getDefaultInstance(properties);  
     
   //2) create the POP3 store object and connect with the pop server  
   POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);  
   emailStore.connect(pop3Host,user, Pass);  
  
   //3) create the folder object and open it  
   Folder emailFolder = emailStore.getFolder("INBOX");  
   emailFolder.open(Folder.READ_ONLY);  
   
   
   
   
  
   //4)Receive file messages and print it in list 
   Message[] messages = emailFolder.getMessages();  
   for (int i = 0; i < messages.length; i++) {  
    Message message = messages[i];  
    System.out.println("---------------------------------");  
    System.out.println("Email Number " + (i + 1));  
    String x = dechifrer_rssa (message.getSubject()) ;
    System.out.println("Subject: " +x );   
    System.out.println("From: " + message.getFrom()[0]); 
    String y = dechifrer_rssa (message.getContent().toString()) ;
    System.out.println("Text: " + y+"\n");  
    
   }  
  
   //5) close store objects and the folder
   emailFolder.close(false);  
   emailStore.close();  
  
  } catch (NoSuchProviderException e) {e.printStackTrace();}   
  catch (MessagingException e) {e.printStackTrace();}  
  catch (IOException e) {e.printStackTrace();} 

 JOptionPane.showMessageDialog(null, "the messages received  succesfully !! ");// SUCCESS MESSAGE


    }//GEN-LAST:event_receiveEmailActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void recepient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recepient1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recepient1ActionPerformed

    private void recepient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recepient2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recepient2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(EmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmailFrame().setVisible(true);
            }
        });
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton receiveEmail;
    private javax.swing.JTextField recepient;
    private javax.swing.JTextField recepient1;
    private javax.swing.JTextField recepient2;
    private javax.swing.JButton sendEmail;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}