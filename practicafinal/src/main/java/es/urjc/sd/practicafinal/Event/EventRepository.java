package es.urjc.sd.practicafinal.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findByName(String name);

    List<Event> findByRoom(int room);

}
