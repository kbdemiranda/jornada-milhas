package io.github.jornadamilhas.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class JornadaMilhasException extends RuntimeException {
    private HttpStatus code;
    private String message;
}

