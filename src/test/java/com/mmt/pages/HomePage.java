package com.mmt.pages;

import com.mmt.enums.ServiceOption;
import com.mmt.pages.components.ServiceOptionsHeader;
import com.mmt.pages.components.search.SearchComponent;
import com.mmt.pages.factories.SearchComponentFactory;

import static com.mmt.enums.ServiceOption.DEFAULT;

public class HomePage extends BasePage {
    private String homeUrl = "https://makemytrip.com/";
    private ServiceOptionsHeader serviceOptionsHeader;
    private SearchComponent searchComponent;

    public HomePage() {
        driver.get(homeUrl);
        this.serviceOptionsHeader = new ServiceOptionsHeader();
        this.searchComponent = SearchComponentFactory.getInstance(DEFAULT);
    }

    public HomePage selectService(ServiceOption option) {
        serviceOptionsHeader.select(option);
        searchComponent = SearchComponentFactory.getInstance(option);
        return this;
    }

    public HomePage populateSearchDetails() {
        searchComponent.populateSearchDetails();
        return this;
    }

    public SearchResultPage search() {
        return searchComponent.search();
    }
}
