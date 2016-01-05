package com.yourbank.util;

import com.yourbank.data.model.user.User;
import lombok.Getter;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by admin on 04.01.2016.
 */
public class MailUtil {
    public static final String FROM = "yourbankyour@gmail.com";

    public static SimpleMailMessage generateConfirmMessage(User user) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(FROM);
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject(Subject.REGISTRATION.getText());
        simpleMailMessage.setText(generateBody(user));
        return simpleMailMessage;
    }

    private static String generateBody(User user) {
        StringBuilder body = new StringBuilder();
        body.append("Добрый день.").append("</br>");
        String url = "";
        body.append("<a href='").append(url).append("'>").append("Ссылка на активацию вашего профиля в банке").append("</a>");
        return body.toString();
    }

    @Getter
    public enum Subject {
        REGISTRATION("Регистрация");
        private String text;

        Subject(String text) {
            this.text = text;
        }
    }
}
