//package com.inventine.util;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Map;
//import java.util.Properties;
//
//public class Mailer {
//
//    public static void main(String[] args) {
//
//        Map<String,String> dotEnv = DotEnv.load();
//
//        final String username = dotEnv.get("EMAIL_USERNAME");
//        final String password = dotEnv.get("EMAIL_PASSWORD");
//
//        Properties prop = new Properties();
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.starttls.enable", "true"); //TLS
//
//        Session session = Session.getInstance(prop,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(
//                    Message.RecipientType.TO,
//                    InternetAddress.parse(mailId)
//            );
//            message.setSubject(subject);
//            message.setText(body);
//
//            Transport.send(message);
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//
//        }
//    }
//
//}