package br.ebac.andre.MemeMeme.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiResponseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ApiResponseException(String message) {
        super(message);
    }


}