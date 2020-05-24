package ru.guzev.open.test_task.ui_tests;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;
import ru.guzev.open.test_task.config.SystemConfig;


public abstract class UiBaseTest {

    protected SystemConfig cfg = ConfigFactory.create(SystemConfig.class);

    @BeforeSuite
    public void setUp() {
        Configuration.browser = cfg.testBrowser();
        Configuration.startMaximized = cfg.testBrowserMaximize();
    }
}
