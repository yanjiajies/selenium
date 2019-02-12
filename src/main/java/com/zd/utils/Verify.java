package com.zd.utils;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class Verify {
    public static StringBuffer verificationErrors = new StringBuffer();
    public static Logger logger =Logger.getRootLogger();
    public static void verifyTrue(boolean o) {
        try {
            Assert.assertTrue(o);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    public static void verifyFalse(boolean o) {
        try {
            Assert.assertFalse(o);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    public static void verifyEquals(Object expected, Object actuals) {
        try {
            Assert.assertEquals(expected, actuals);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    public static void verifyEquals(Object expected, Object actuals, String message) {
        try {
            Assert.assertEquals(expected, actuals, message);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    public static void assertEquals(String actual, String expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            logger.info("执行成功");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    public static void assertEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    public static void tearDown() {
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            logger.info(verificationErrorString);
        }
    }

}
