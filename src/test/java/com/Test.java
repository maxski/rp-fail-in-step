package com;

import com.epam.reportportal.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    @org.testng.annotations.Test
    public void testWithStep() {
        LOGGER.info("testWithStep");
        step();
    }

    @org.testng.annotations.Test
    public void testWithoutStep() {
        LOGGER.info("testWithoutStep");
        Assert.fail("Fail in test");
    }

    @Step
    public void step() {
        LOGGER.info("step");
        Assert.fail("Fail in step");
    }
}
