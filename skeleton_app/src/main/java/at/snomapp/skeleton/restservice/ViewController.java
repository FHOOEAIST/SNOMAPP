package at.snomapp.skeleton.restservice;


import at.snomapp.skeleton.domain.appc.APPCTree;
import at.snomapp.skeleton.domain.appc.Entry;
import at.snomapp.skeleton.repo.APPCRepo;
import com.sun.source.tree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ViewController {

    private APPCRepo repo;

    @Autowired
    public ViewController(APPCRepo readingrepo) {this.repo = readingrepo;}

    @GetMapping("/startPage")
    public String startPage(Model model){
        APPCController appcController = new APPCController(repo);
        model.addAttribute("roots", appcController.getTree().getRoots());
        return "startPage";
    }


    @GetMapping("/index")
    public String index(Model model){
        APPCController appcController = new APPCController(repo);

        //store in model the json string of nodes for each axis
        APPCTree tree = appcController.getTree();
        model.addAttribute("anatomy", tree.getAnatomyJsonString());
        model.addAttribute("laterality", tree.getLateralityJsonString());
        model.addAttribute("modality", tree.getModalityJsonString());
        model.addAttribute("procedure", tree.getProcedureJsonString());
        return "index";
    }








}
