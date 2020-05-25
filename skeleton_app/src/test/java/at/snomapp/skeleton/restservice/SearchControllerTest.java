package at.snomapp.skeleton.restservice;

import io.swagger.client.model.BrowserDescriptionSearchResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchControllerTest {

    @Test
        // should print results for tongue
    void SearchForTongue() {
        SearchController controller = new SearchController();
        List<BrowserDescriptionSearchResult> res = controller.findByDisplayName("tongue");
        assertNotNull(res);
        System.out.println(res);
    }
}