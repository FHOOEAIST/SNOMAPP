package at.snomapp.skeleton.restservice;


import at.snomapp.skeleton.domain.appc.APPCEntry;
import at.snomapp.skeleton.domain.appc.APPCTree;
import at.snomapp.skeleton.domain.conceptMapping.impl.EquivalenceImpl;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.repo.APPCRepo;
import at.snomapp.skeleton.repo.ConceptMapRepo;
import at.snomapp.skeleton.repo.MappingRepo;
import io.swagger.client.model.BrowserDescriptionSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class ViewController {

    private APPCRepo repo;
    private ConceptMapRepo Conceptmaprepo;
    private MappingRepo mappingRepo;

    @Autowired
    public ViewController(APPCRepo readingrepo) {this.repo = readingrepo;}

    @GetMapping("/startPage")
    public String startPage(Model model){
        APPCController appcController = new APPCController(repo);
        //model.addAttribute("roots", appcController.getTree().getRoots());
        APPCTree tree = appcController.getTree();
        model.addAttribute("anatomy", tree.getAnatomyJsonString());
        model.addAttribute("laterality", tree.getLateralityJsonString());
        model.addAttribute("modality", tree.getModalityJsonString());
        model.addAttribute("procedure", tree.getProcedureJsonString());
        return "startPage";
    }

    @GetMapping("/index")
    public String index(Model model){
        APPCController appcController = new APPCController(repo);

        //store in model the json string of nodes for each axis
        model.addAttribute("anatomy", appcController.getTree().getAnatomyJsonString());
        model.addAttribute("laterality", appcController.getTree().getLateralityJsonString());
        model.addAttribute("modality", appcController.getTree().getModalityJsonString());
        model.addAttribute("procedure", appcController.getTree().getProcedureJsonString());
        return "index";
    }

    @GetMapping("/resultPage")
    public String resultPage(Model model, APPCEntry element){
        ConceptMapController conceptMapController = new ConceptMapController(Conceptmaprepo,mappingRepo);
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
