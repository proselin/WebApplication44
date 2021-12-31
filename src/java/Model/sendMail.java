package Model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class sendMail {

    final String fromEmail = "quochung9401@gmail.com";// email of sender
    final String password = "oqaoqxpzoziuvqui";// password of sender
    Authenticator auth = new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(fromEmail, password);
        }
    };

    public void sendRegisterConfirmEmail(String emailOfReceiver, String id) throws MessagingException, UnsupportedEncodingException {
        final String toEmail = emailOfReceiver;
        final String subject = "Confirm Email to Sign up new account";
        final String body = "Hello Please click on the link to sign up new account Link:  http://localhost:8080/WebApplication3/register.jsp?email=" + emailOfReceiver + "&id=" + id+" ";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");;
        msg.setFrom(new InternetAddress(fromEmail, "Charmain-Service-Noreply"));
        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
        msg.setSubject(subject, "UTF-8");
        msg.setText(body, "UTF-8");
        msg.setSentDate(new Date());
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gui mail thanh cong");
    }
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        sendMail sm = new sendMail();
        sm.sendOrderLink("danteon442@gmail.com", "ORDER36");
    }
     public void sendOrderLink(String emailOfReceiver, String orderid) throws MessagingException, UnsupportedEncodingException {
        final String toEmail = emailOfReceiver;
        final String subject = "Order invoice from charmain store";
        final String body = "Hello Customer your invoice available at: http://localhost:8080/WebApplication3/order_controller?ac=showInvoice&orderid=" +orderid;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");;
        msg.setFrom(new InternetAddress(fromEmail, "Charmain-Service-Noreply"));
        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
        msg.setSubject(subject, "UTF-8");
        msg.setText(body, "UTF-8");
        msg.setSentDate(new Date());
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gui mail thanh cong");
    }
 

}
