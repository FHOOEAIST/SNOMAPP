package at.snomapp.skeleton.restservice;


import at.snomapp.skeleton.repo.APPCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    private APPCRepo repo;

    @Autowired
    public ViewController(APPCRepo readingrepo) {this.repo = readingrepo;}

    @GetMapping("/startPage")
    public String startPage(Model model){
        //APPCController appcController = new APPCController(repo);
        //model.addAttribute("roots", appcController.getTree().getRoots());
        return "startPage";
    }
}
