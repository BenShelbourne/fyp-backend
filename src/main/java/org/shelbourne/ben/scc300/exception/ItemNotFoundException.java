package org.shelbourne.ben.scc300.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
