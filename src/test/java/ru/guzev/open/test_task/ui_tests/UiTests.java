package ru.guzev.open.test_task.ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.guzev.open.test_task.page_elements.CurrencyExchangeBlock;
import ru.guzev.open.test_task.pages.GoogleStartPage;
import ru.guzev.open.test_task.pages.MainPage;

public class UiTests extends UiBaseTest {

    @Test(description = "Проверить курс обмена валют в интернет-банке")
    public void firstUiTest() {
        MainPage mainPage = GoogleStartPage.open()
                .enterTextInSearchField("«Открытие»")
                .clickOnSearchButton()
                .checkThatResultContainsLink("https://www.open.ru")
                .openSearchResultByPartOfLink("https://www.open.ru", MainPage.class);

        CurrencyExchangeBlock exchangeBlock = mainPage.getCurrencyExchangeBlock();

        Assert.assertTrue(exchangeBlock.getUsdBuyRateValue() < exchangeBlock.getUsdSellRateValue());

        Assert.assertTrue(exchangeBlock.getEurBuyRateValue() < exchangeBlock.getEurSellRateValue());
    }
}
