package com.yourbank.tests;

import com.yourbank.data.model.user.User;
import com.yourbank.util.Misc;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * Created by admin on 15.12.2015.
 */
public class TestMiscUtil {

    @Test
    public void notNull() {
        User user = new User();
        assertTrue(!Misc.isNull(user));
    }

    @Test
    public void nullTest() {
        User user = null;
        String t = UUID.randomUUID().toString();
        t = UUID.randomUUID().toString();
        t = UUID.randomUUID().toString();
        t = UUID.randomUUID().toString();
        Set<String> strings = new HashSet<>();
        for(int i=0;i<100000;i++){
            strings.add(UUID.randomUUID().toString());
        }
        System.err.println(strings.size());
        assertTrue(Misc.isNull(user));
    }

}
