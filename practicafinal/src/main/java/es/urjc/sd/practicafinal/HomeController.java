package es.urjc.sd.practicafinal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
   

    @GetMapping("/")
    public String photos(Model model) {
        ClubSession[] sessions = new ClubSession[] {
            new ClubSession(1, "REMEMBER","13/05 23:00h","Sala 1"),
            new ClubSession(2, "TECHNO","14/05 23:30" ,"Sala 2"),
            new ClubSession(3, "PREUNIVERSIPARTY","05/05 23:00" ,"Sala 1"),
            new ClubSession(4, "REGGAETON","06/05 23:30" ,"Sala 2"),
            new ClubSession(5, "MÚSICA ESPAÑOLA","13/05 23:00" ,"Sala 2"),
            new ClubSession(6, "POP","13/05 23:30" ,"Sala 2"),
        }; 
        model.addAttribute("sessions", sessions);
        return "home";
    }


    @GetMapping("/login.html")
    public String login(Model model) {
       
        return "login";
    }
    @GetMapping("/home.html")
    public String back(Model model) {
       
        return "home";
    }
    
 


}
