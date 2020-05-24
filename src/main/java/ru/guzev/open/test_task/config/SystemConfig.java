package ru.guzev.open.test_task.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources("file:src/main/resources/systemConfig.properties")
public interface SystemConfig extends Config {

    @Key("environment.baseurl.api")
    String apiBaseUrl();

    @Key("environment.baseurl.ui")
    String uiBaseUrl();

    @Key("test.browser")
    String testBrowser();

    @Key("test.browser.maximize")
    boolean testBrowserMaximize();
}
