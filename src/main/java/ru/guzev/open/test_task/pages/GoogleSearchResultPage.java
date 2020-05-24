package ru.guzev.open.test_task.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;
import ru.guzev.open.test_task.page_elements.SearchResult;

import java.util.List;
import java.util.NoSuchElementException;

public class GoogleSearchResultPage {

    @FindBys(@FindBy(xpath = "//div[@id='search']//div[@class='rc']"))
    private List<SearchResult> searchResults;

    @Step
    public GoogleSearchResultPage checkThatResultContainsLink(String url) {
        Assert.assertTrue(searchResultContainsUrl(url));
        return this;
    }

    @Step
    public GoogleSearchResultPage checkThatResultNotContainsLink(String url) {
        Assert.assertFalse(searchResultContainsUrl(url));
        return this;
    }

    @Step
    public <T> T openSearchResultByPartOfLink(String linkPart, Class<T> pageClass) {
        SearchResult searchResult = searchResults.stream()
                .filter(result -> result.getResultLink().getAttribute("href")
                        .contains(linkPart))
                .findFirst().orElseThrow(() ->
                        new NoSuchElementException("No value present"));
        return searchResult.openSearchResult(pageClass);
    }

    @Step
    private boolean searchResultContainsUrl(String url) {
        return searchResults.stream()
                .map(SearchResult::getResultLink)
                .map(element -> element.getAttribute("href"))
                .anyMatch(href -> href.contains(url));
    }

}
