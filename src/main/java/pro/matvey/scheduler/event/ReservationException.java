package pro.matvey.scheduler.event;

import com.sun.xml.internal.ws.api.model.CheckedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReservationException extends RuntimeException {

    public ReservationException() {
        super("Requested date and time already reserved");
    }

}