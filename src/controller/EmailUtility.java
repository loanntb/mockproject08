package controller;

import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.dao.TaiKhoanDao;
public class EmailUtility {
  public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message,String ht) throws AddressException,
            MessagingException {
      
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("library.UTE@gmail.com","01287575471");
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        MimeMessage msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject,"UTF-8");
        msg.setSentDate(new Date());
        msg.setText("Xin Chào ! "+ ht +"\nĐây là mật khẩu đăng nhập vào hệ thống công ty ABC: "+message +" .\nBạn vui lòng đổi mật khẩu "
        		+ "sau khi đăng nhập thành công ! "
        		+ "\nChân thành cảm ơn !"
        		+ "\n","UTF-8");
 
        // sends the e-mail
        Transport.send(msg);
 
    }
}