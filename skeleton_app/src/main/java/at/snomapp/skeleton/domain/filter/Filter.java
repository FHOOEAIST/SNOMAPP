package at.snomapp.skeleton.domain.filter;

import io.swagger.client.model.BrowserDescriptionSearchResult;
import io.swagger.client.model.PageBrowserDescriptionSearchResult;

import java.util.List;

public interface Filter {
    List<BrowserDescriptionSearchResult> filterResults(String appcAxis, PageBrowserDescriptionSearchResult resultsBeforeSearch);
}