package org.shelbourne.ben.scc300.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongStateException extends RuntimeException {

    public WrongStateException(String msg) {
        super(msg);
    }
}
