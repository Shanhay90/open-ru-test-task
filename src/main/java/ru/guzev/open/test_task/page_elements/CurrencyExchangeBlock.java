package ru.guzev.open.test_task.page_elements;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyExchangeBlock extends ElementsContainer {

    private static final String CURRENCY_ROW_LOCATOR = "//*[contains(@class,'main-page-exchange__row')]";
    private static final String CURRENCY_RATE_LOCATOR = "//*[@class='main-page-exchange__rate']";

    @FindBy(css =".main-page-exchange__dropdown-title")
    private SelenideElement currencyExchangeBlockTitle;

    @FindBy(xpath = "(" + CURRENCY_ROW_LOCATOR + "[contains(.,'USD')]" + CURRENCY_RATE_LOCATOR+")[2]")
    private SelenideElement usdSellRate;

    @FindBy(xpath = "(" + CURRENCY_ROW_LOCATOR + "[contains(.,'USD')]" + CURRENCY_RATE_LOCATOR+")[1]")
    private SelenideElement usdBuyRate;

    @FindBy(xpath = "(" + CURRENCY_ROW_LOCATOR + "[contains(.,'EUR')]" + CURRENCY_RATE_LOCATOR+")[2]")
    private SelenideElement eurSellRate;

    @FindBy(xpath = "(" + CURRENCY_ROW_LOCATOR + "[contains(.,'EUR')]" + CURRENCY_RATE_LOCATOR+")[1]")
    private SelenideElement eurBuyRate;


    public double getUsdSellRateValue(){
        return Double.parseDouble(usdSellRate.getText().replaceAll(",", "."));
    }

    public double getUsdBuyRateValue(){
        return Double.parseDouble(usdBuyRate.getText().replaceAll(",", "."));
    }

    public double getEurSellRateValue(){
        return Double.parseDouble(eurSellRate.getText().replaceAll(",", "."));
    }

    public double getEurBuyRateValue(){
        return Double.parseDouble(eurBuyRate.getText().replaceAll(",", "."));
    }
}
