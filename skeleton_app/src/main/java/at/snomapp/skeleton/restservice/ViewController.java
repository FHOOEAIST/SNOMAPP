package at.snomapp.skeleton.restservice;


import at.snomapp.skeleton.domain.appc.APPCEntry;
import at.snomapp.skeleton.domain.conceptMapping.impl.EquivalenceImpl;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.repo.APPCRepo;
import at.snomapp.skeleton.repo.ConceptMapRepo;
import io.swagger.client.model.BrowserDescriptionSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class ViewController {

    private APPCRepo repo;
    private ConceptMapRepo Conceptmaprepo;

    @Autowired
    public ViewController(APPCRepo readingrepo) {this.repo = readingrepo;}

    @GetMapping("/startPage")
    public String startPage(Model model){
        APPCController appcController = new APPCController(repo);
        model.addAttribute("roots", appcController.getTree().getRoots());
        return "startPage";
    }

    @GetMapping("/resultPage")
    public String resultPage(Model model, APPCEntry element){
        ConceptMapController conceptMapController = new ConceptMapController(Conceptmaprepo);
        SnomedController snomedController = new SnomedController();
        List<BrowserDescriptionSearchResult> resultList = snomedController.findByDisplayName("eye");
        List<EquivalenceImpl> mappings = new ArrayList<>();

        model.addAttribute("results",resultList);
        model.addAttribute("appc", element);
        //ToDo
        model.addAttribute("mappings", mappings);

        return "resultPage";
    }

}
