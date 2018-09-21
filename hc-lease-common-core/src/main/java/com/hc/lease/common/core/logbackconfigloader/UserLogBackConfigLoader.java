package com.hc.lease.common.core.logbackconfigloader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * 加载初始化logback配置
 * Simple Utility class for loading an external config file for logback
 *
 * @author tong
 */

public class UserLogBackConfigLoader {

    public void load() {

        try {
            String externalConfigFileLocation = "/data/service/conf/logback/user/logback.xml";
            //String externalConfigFileLocation = "config/logback.xml";
            LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
            File externalConfigFile = new File(externalConfigFileLocation);
            if (!externalConfigFile.exists()) {
                throw new IOException("Logback External Config File Parameter does not reference a file that exists");
            } else {
                if (!externalConfigFile.isFile()) {
                    throw new IOException("Logback External Config File Parameter exists, but does not reference a file");
                } else {
                    if (!externalConfigFile.canRead()) {
                        throw new IOException("Logback External Config File exists and is a file, but cannot be read.");
                    } else {
                        JoranConfigurator configurator = new JoranConfigurator();
                        configurator.setContext(lc);
                        lc.reset();
                        configurator.doConfigure(externalConfigFileLocation);
                        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JoranException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) throws IOException, JoranException {
        //LogBackConfigLoader.load("E:/luomingtong/logback.xml");
        Logger logger = LoggerFactory.getLogger("myLogBack");
        logger.debug("Hello");
    }

}