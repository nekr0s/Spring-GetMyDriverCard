package nekr0s.project.card_users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Username already exists")
public class UserAlreadyExistAuthenticationException extends Exception {

    public UserAlreadyExistAuthenticationException(final String msg) {
        super(msg);
    }

}