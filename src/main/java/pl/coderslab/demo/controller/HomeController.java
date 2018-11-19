package pl.coderslab.demo.controller;

import com.sun.deploy.association.RegisterFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.demo.domain.User;
import pl.coderslab.demo.domain.dto.RegisterDto;
import pl.coderslab.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController { //kontroller gdzie do endpointów dostęp mają niezalogowani użytkownicy

    @Autowired
    UserService userService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET) //
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@Valid RegisterDto dto, BindingResult result){
        User user=null;

        if(!result.hasErrors() ){
            try {
                user=userService.registerUser(dto);
            }catch (RegisterFailedException e){
                return "register";
            }

            if(user!=null) {
                return "redirect:login";
            }
        }
        return "register";

    }
    @RequestMapping(value = "/404",method = RequestMethod.GET)
    public String print404(){
        return "404";
    }
    @RequestMapping(value = "/blank",method = RequestMethod.GET)
    public String blank(){
        return "blank";
    }

}
