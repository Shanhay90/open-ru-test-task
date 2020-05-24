package ru.guzev.open.test_task.pages;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.guzev.open.test_task.page_elements.CurrencyExchangeBlock;


@Getter
public class MainPage {

    @FindBy(css = ".main-page-exchange")
    private CurrencyExchangeBlock currencyExchangeBlock;
}
