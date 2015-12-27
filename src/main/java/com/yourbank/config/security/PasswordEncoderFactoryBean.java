package com.yourbank.config.security;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Alexandr Yugov
 */
@Component
public class PasswordEncoderFactoryBean  implements FactoryBean<PasswordEncoder> {

    @Override
    public PasswordEncoder getObject() throws Exception {
        return new BCryptPasswordEncoder(11);
    }

    @Override
    public Class<?> getObjectType() {
        return PasswordEncoder.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
