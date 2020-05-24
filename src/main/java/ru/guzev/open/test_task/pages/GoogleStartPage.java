package ru.guzev.open.test_task.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.FindBy;
import ru.guzev.open.test_task.config.SystemConfig;

public class GoogleStartPage {

    @FindBy(xpath ="//input[@name='q']")
    private SelenideElement searchInputField;

    @FindBy(xpath ="//input[@type='submit']")
    private SelenideElement searchButton;

    @Step
    public static GoogleStartPage open(){
        return Selenide.open(ConfigFactory.create(SystemConfig.class).uiBaseUrl(), GoogleStartPage.class);
    }

    @Step
    public GoogleStartPage enterTextInSearchField(String text){
        searchInputField.shouldBe(Condition.visible)
                .sendKeys(text);
        return this;
    }

    @Step
    public GoogleSearchResultPage clickOnSearchButton(){
        searchButton.shouldBe(Condition.visible)
                .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }
}
