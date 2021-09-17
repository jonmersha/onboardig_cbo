package cbo.onborading.utility;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class NotificationService {

    public static void emailNotification(String subject,String message,String destination)throws AddressException, MessagingException, IOException {
         Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "mail.lehulupay.com");
            props.put("mail.smtp.port", "587");
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("hullupay@lehulupay.com", "Yohannes@hira123");
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("no-replay@coopay.io", false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destination));
            msg.setSubject(subject);
            msg.setContent(message,"text/html");
            msg.setSentDate(new Date());
            Transport.send(msg);
        }


    public static void smsNotification(String message,String destination){

    }
}
