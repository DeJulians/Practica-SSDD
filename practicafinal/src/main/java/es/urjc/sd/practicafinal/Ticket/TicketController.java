package es.urjc.sd.practicafinal.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class TicketController {

    private boolean control = true;

    @Autowired
    private TicketService ticketService; 

    @GetMapping("/tickets1")
    public String showTickets(Model model, @RequestParam(defaultValue = "VIP") String type) {
       if(control){
            Ticket ticket = new Ticket(TicketType.VIP, "Manolo","manolo@gmail.com",633943611);
            ticketService.save(ticket);
        
            Ticket ticket1 = new Ticket(TicketType.NORMAL, "Ruben","ruben@gmail.com",641543011);
            ticketService.save(ticket1);
       
            Ticket ticket2 = new Ticket(TicketType.PREMIUM, "Jose Luis","js@gmail.com",603743011);
            ticketService.save(ticket2);
            control = false;
       }
       
        model.addAttribute("name", "REMEMBER");
        model.addAttribute("date", "2020-12-12");
        model.addAttribute("tickets", ticketService.findAllList());
       
        
        return "showTickets"; 
    }

    @PostMapping("/tickets/add")
    public String addTicket(@RequestParam("name") String name, @RequestParam("email") String email,
            @RequestParam("num") int num, Model model) {

        // Guardar los datos del ticket en la base de datos o donde corresponda
        Ticket ticket = new Ticket(TicketType.NORMAL, name, email, num);
        ticketService.save(ticket);

        // Agregar los datos del ticket al modelo para mostrarlos en la vista
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("num", num);

        // Cargar la vista ticketConfirmation
        return "ticketConfirmation";
    }


 
}


