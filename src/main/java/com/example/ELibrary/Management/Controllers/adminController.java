package com.example.ELibrary.Management.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admDashboard")
public class adminController {
    @RequestMapping
    public String getAdmDashboard(HttpSession session,Model model){
        model.addAttribute("msg","Login Success !");
        String userName =(String) session.getAttribute("userName");
        String role =(String) session.getAttribute("role");
        if(userName != null && role.equals("admin")){
            System.out.println(userName);
            model.addAttribute("isLoggedIn", true);
            model.addAttribute("userName", userName);
            return "adminDashboard";
        }
        else{
            model.addAttribute("msg","Error in login try again");
            session.invalidate();
            return "redirect:/";
        }

    }
}
