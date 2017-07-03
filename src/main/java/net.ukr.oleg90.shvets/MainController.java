package net.ukr.oleg90.shvets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shvets Oleg
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    public ClientService clientService;

    @RequestMapping("/")
    public String onIndex() {
        return "index";
    }

    @RequestMapping(value = "registration" ,method = RequestMethod.POST)
    public String onRegistration(Model model, @RequestParam  String name, @RequestParam String password ){


        model.addAttribute("name",name);
        System.out.println(12);
        model.addAttribute("password",password);
        clientService.addClient(new Client(name,password));
        System.out.println(name + " name1");
        System.out.println(password + " password1");
        return "reg";


    }
}
