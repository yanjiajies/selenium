package com.hy.mail;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 发送邮件方法
 */
public class MailDemo {

    public static void main(String[] args) {

        // 创建一个Property文件对象
        Properties props = new Properties();
        // 设置邮件服务器的信息，这里设置smtp主机名称
        props.put("mail.smtp.host", "smtp.qq.com");
        // 设置socket factory 的端口
        props.put("mail.smtp.socketFactory.port", "465");
        // 设置socket factory
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        // 设置需要身份验证
        props.put("mail.smtp.auth", "true");
        // 设置SMTP的端口，QQ的smtp端口是25
        props.put("mail.smtp.port", "25");
        // 身份验证实现
        Session session = Session.getDefaultInstance(props, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 第二个参数，就是我QQ开启smtp的授权码
                return new PasswordAuthentication("1302711300@qq.com", "nnitmjubkrjajigj");
            }

        });

        try {
            // 创建一个MimeMessage类的实例对象
            Message message = new MimeMessage(session);
            // 设置发件人邮箱地址
            message.setFrom(new InternetAddress("1302711300@qq.com"));
            // 设置收件人邮箱地址
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("308524139@qq.com"));
            // 设置邮件主题
            message.setSubject("测试报告");
            // 创建一个MimeBodyPart的对象，以便添加内容
            BodyPart messageBodyPart1 = new MimeBodyPart();
            // 设置邮件正文内容
            messageBodyPart1.setText("版本");
            // 创建另外一个MimeBodyPart对象，以便添加其他内容
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            // 设置邮件中附件文件的路径
            String output= ".\\test-output\\index.html";
            //String logfile=".\\src\\main\\java\\logs\\debug.log";
            System.out.println(output);
            //System.out.println(logfile);
            // 创建一个datasource对象，并传递文件
            DataSource source = new FileDataSource(output);
            // 设置handler
            messageBodyPart2.setDataHandler(new DataHandler(source));
            // 加载文件
            messageBodyPart2.setFileName(output);
            // 创建一个MimeMultipart类的实例对象
            Multipart multipart = new MimeMultipart();
            // 添加正文1内容
            multipart.addBodyPart(messageBodyPart1);
            // 添加正文2内容
            multipart.addBodyPart(messageBodyPart2);
            // 设置内容
            message.setContent(multipart);
            // 最终发送邮件
            Transport.send(message);
            System.out.println("=====测试报告发送成功=====");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}