package es.urjc.sd.practicafinal.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getByType(TicketType type) {
        return ticketRepository.getByType(type);
    }
    
    public boolean save(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getClient().isEmpty()) {
            return false;
        } else {
            ticketRepository.save(ticket);
            return true;
        }
    }

    public Collection<Ticket> findAllList() {
       return ticketRepository.findAll();
    }
}
