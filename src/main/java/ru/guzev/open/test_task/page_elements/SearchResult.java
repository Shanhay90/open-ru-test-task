package ru.guzev.open.test_task.page_elements;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

@Getter
public class SearchResult extends ElementsContainer {

    @FindBy(xpath ="./div[@class='r']/a")
    private SelenideElement resultLink;

    @FindBy(xpath ="./div[@class='r']/a/h3")
    private SelenideElement resultTitle;

    @FindBy(xpath ="./div[@class='s']//span[@class='st']")
    private SelenideElement resultShortDescription;

    @Step
    public <T> T openSearchResult (Class<T> pageClass){
        resultTitle.click();
        return page(pageClass);
    }
}
