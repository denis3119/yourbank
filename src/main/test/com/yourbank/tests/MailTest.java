package com.yourbank.tests;

import com.yourbank.config.Application;
import com.yourbank.config.mail.MailSender;
import com.yourbank.util.Misc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.mail.MessagingException;

import static org.junit.Assert.assertTrue;

/**
 * Created by admin on 31.12.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MailTest {
    @Autowired
    MailSender sendMail;

    @Test
    public void send() throws MessagingException {
        if (Misc.isOnline())
            sendMail.send("yourbankyour@gmail.com", "yourbankyour@gmail.com", "test", " test body");
        assertTrue(true);
    }

    @Test
    public void getBody() {
        String body = sendMail.getConfirmUserBody(null);
        assertTrue(!Misc.isNull(body));
    }
}
