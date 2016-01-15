package com.yourbank.config.mail;

import com.yourbank.data.model.bank.Request;
import com.yourbank.data.model.user.User;
import com.yourbank.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailSender {
    private String link = "https://localhost:8443";

    @Autowired
    private JavaMailSender javaMailSender;

    private void send(String from, String to, String subject, String body) {
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setSubject(subject);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(body, true);
            System.err.println(body);
            javaMailSender.send(message);
        } catch (Exception e) {
            /*ignore*/
        }

    }

    private String getConfirmUserBody(User user) {
        String url = link + "/profile/confirm/" + user.getId() + "/" + user.getEmail().hashCode() + "/";
        return "<a href='" + url + "'>Нажми сюда</a>";
    }

    public void sendConfirmMail(User user) {
        String body = getConfirmUserBody(user);
        send(MailUtil.FROM, user.getEmail(), "Confirm", body);
    }

    public void sendConfirmInBank(String email, boolean approve, Request request) {
        String body;
        if (approve) {
            body = "Приходите в банк";
        } else {
            body = "Не приходите в банк";
        }
        long id = request.getId();
        int hash = request.getEmail().hashCode();
        body += "</br> <a href='" + link + "/request/remove/" + id + "/" + hash + "'>Если вы не подавали в банк заявку, просто нажмите тут</a>";
        send(MailUtil.FROM, email, "Ваша заявка рассмотрена", body);
    }

    @Bean
    public JavaMailSenderImpl javaMailSenderImpl() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        mailSender.setUsername(MailUtil.FROM);
        mailSender.setPassword("yourbankyour1");
        Properties prop = mailSender.getJavaMailProperties();
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.debug", "true");
        return mailSender;
    }
}
