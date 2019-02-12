package com.zd.mail;
//自动发送邮件练习类

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailTest {
    public static void main(String[] args) {
     Properties properties=new Properties();
     properties.put("mail.smtp.host","smtp.qq.com");
     properties.put("mail.smtp.socketFactory.port","465");
     properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
     properties.put("mail.smtp.auth","true");
     properties.put("mail.smtp.port","25");
     Session session =Session.getDefaultInstance(properties, new Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication("授权地址","授权码");
         }
     });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("收件地址"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("收件地址"));
            message.setSubject("报告");
            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText("内容");
            MimeBodyPart mimeBodyPart=new MimeBodyPart();
            String output="路径";
            DataSource dataSource=new FileDataSource(output);
            mimeBodyPart.setDataHandler(new DataHandler(dataSource));
            mimeBodyPart.setFileName(output);
            Multipart multipart=new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(bodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
