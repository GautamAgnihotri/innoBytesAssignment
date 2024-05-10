package com.example.ELibrary.Management.Controllers;


import com.example.ELibrary.Management.DTO.LoginDto;
import com.example.ELibrary.Management.Entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.filters.ExpiresFilter;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/auth")
public class AuthController {

    private String userName;
    private String password;
    private String role;

    @Value("${adminUsername}")
    public String adminUserName;

    @Value("${adminPassword}")
    public String adminPassword;

    @Value("${adminRole}")
    public String adminRole;

    @CrossOrigin
    @RequestMapping
    public String login(@ModelAttribute("loginDto") LoginDto loginDto, HttpServletRequest request, Model model){

        userName = loginDto.getUserName();
        password = loginDto.getPassword();
        role = loginDto.getRole();
        System.out.println("Login request hit");
        if(userName==null || password==null || role==null){
            System.out.println("One or more than one field is empty");
            model.addAttribute("msg","One or more than one field is empty");
            return "index";
        }else if(userName.equals(adminUserName) && password.equals(adminPassword) && role.equals(adminRole)) {
            System.out.println("login successs");
            model.addAttribute("isLoggedIn", true);
            model.addAttribute("userName", userName);
            HttpSession session = request.getSession();
            session.setAttribute("userName",userName);
            session.setAttribute("role", role);
            return "redirect:/admDashboard";
        }
        model.addAttribute("msg","Invalid Credential Login again");
        System.out.println("Invalid Credential for admin");
        return "index";
    }
    @CrossOrigin
    @RequestMapping("/signout")
    public String SignOut( HttpSession session,Model model){
        System.out.println("Signout request recived");
        model.addAttribute("msg","Signout Succesfully");
        session.invalidate();
        return "index";
    }

}

