package com.in28minutes.spring.web.springbootfirstwebapp.controller;

        import com.in28minutes.spring.web.springbootfirstwebapp.service.LoginService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
//    @RequestMapping("/login")
//    public String loginMessage(@RequestParam String name, ModelMap model){
//        model.put("name", name);
//        return "login";
//    }
    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(ModelMap model, @RequestParam String name) {
        boolean isValidUser =  service.validateUser(name);
        model.put("name", name);
        return "welcome";
    }
}

