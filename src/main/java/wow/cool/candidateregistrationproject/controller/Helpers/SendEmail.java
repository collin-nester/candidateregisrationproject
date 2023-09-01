package wow.cool.candidateregistrationproject.controller.Helpers;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.FileInputStream;
import java.util.Properties;

public class SendEmail {

    public static void sendEmail(String messageSubject, String messageBody, String email) {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/application.properties"));

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(properties.getProperty("mail.smtp.username"), properties.getProperty("mail.smtp.password"));
                }
            });
            Message message = new MimeMessage(session);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();

            message.setFrom(new InternetAddress(properties.getProperty("mail.smtp.username")));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(messageSubject);

            mimeBodyPart.setContent(messageBody, "text/html; charset=utf-8;");

            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);

        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

}
