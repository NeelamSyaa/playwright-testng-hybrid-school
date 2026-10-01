package com.school.automation.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import driver.DriverManager;
import Config.AuthManager;

@Listeners(listeners.TestListener.class)
public class BaseTest {

    @BeforeSuite
    public void globalSuiteSetup() {
        // 🚀 Logs in exactly ONCE at the start of all executions to create the state.json token file
        AuthManager.captureAndSaveToken();
    }

    @BeforeClass
    public void setUp() {
        DriverManager.initDriver();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
