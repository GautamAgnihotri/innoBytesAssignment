package com.example.ELibrary.Management.Controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin
public class TemplateController {
    @RequestMapping("/")
    public String homePage(Model model) {
       
        return "index";
    }
    
}
