package com;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import rp.com.google.common.io.BaseEncoding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Listener extends ReportPortalTestNGListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        byte[] bytes = null;

        try {
            bytes = Files.readAllBytes(Paths.get("README.md"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.info("Attach for test: " + result.getMethod().getMethodName());
        LOGGER.info("RP_MESSAGE#BASE64#{}#{}", BaseEncoding.base64().encode(bytes), "Attach on Fail");
        super.onTestFailure(result);
    }
}
