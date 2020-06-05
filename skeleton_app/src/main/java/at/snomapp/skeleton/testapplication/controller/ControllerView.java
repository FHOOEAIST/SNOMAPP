package at.snomapp.skeleton.testapplication.controller;

import at.snomapp.skeleton.appc.APPCEntry;
import at.snomapp.skeleton.repo.APPCRepo;
import at.snomapp.skeleton.restservice.APPCController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerView {

    private APPCRepo repo;

    @Autowired
    public ControllerView(APPCRepo readingrepo) {this.repo = readingrepo;}

    @GetMapping("/startPage")
    public String startPage(Model model){
        APPCController appcController = new APPCController(repo);
        model.addAttribute("roots", appcController.getTree().getRoots());
        return "startPage";
    }
}
