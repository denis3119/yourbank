package com.yourbank.service.user.impl;

import com.yourbank.data.model.user.User;
import com.yourbank.util.Misc;
import org.junit.Test;

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
        assertTrue(Misc.isNull(user));
    }
}
