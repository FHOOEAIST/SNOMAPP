package at.snomapp.skeleton.domain.filter.impl;

import at.snomapp.skeleton.domain.filter.Filter;
import io.swagger.client.model.BrowserDescriptionSearchResult;
import io.swagger.client.model.PageBrowserDescriptionSearchResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AxisFilter implements Filter {
    //private Map<String, String[]> appcAxisToSnowmed;
    private String[] bodystructure = {"body structure"};
    private String[] laterality = {"qualifier value"};
    private String[] modality = {"procedure"};
    private String[] procedures = {"procedure", "physical object", "disorder", "qualifier value"};

    //public AxisFilter() {

        //this.appcAxisToSnowmed = Map.of("Anatomy", bodystructure, "Laterality", laterality, "Modality", modality, "Procedure", procedures);
    //}

    @Override
    public List<BrowserDescriptionSearchResult> filterResults(String appcAxis, PageBrowserDescriptionSearchResult resultsBeforeSearch) {
        List<BrowserDescriptionSearchResult> results = resultsBeforeSearch.getItems();

        //liste für gefilterte ergebnisse
        List<BrowserDescriptionSearchResult> resultsafterFilter = new ArrayList<>();

        //ergebnise durchgehen
        for (BrowserDescriptionSearchResult res : results) {

            //aus browserResult die Terms herausholen
            String term = res.getConcept().getFsn().getTerm();

            //je nach appc achse anderes Stringarray verwenden
            switch (appcAxis) {
                case "Anatomy":
                    if (term.contains(bodystructure[0])) {
                        resultsafterFilter.add(res);
                    }
                    break;
                case "Lateralitiy":
                    if(term.contains(laterality[0])){
                        resultsafterFilter.add(res);
                    }
                    break;
                case "Modality":
                    if(term.contains(modality[0])){
                        resultsafterFilter.add(res);
                    }
                    break;
                case "Procedure":
                    if(term.contains(procedures[0])|| term.contains(procedures[1])||
                            term.contains(procedures[2])||term.contains(procedures[3])){
                        resultsafterFilter.add(res);
                    }

            }
        }
        return resultsafterFilter != null ? resultsafterFilter : null;
    }
}