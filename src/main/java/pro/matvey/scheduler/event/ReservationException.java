package pro.matvey.scheduler.event;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReservationException extends RuntimeException {

    public ReservationException() {
        super("Requested date and time already reserved");
    }

}