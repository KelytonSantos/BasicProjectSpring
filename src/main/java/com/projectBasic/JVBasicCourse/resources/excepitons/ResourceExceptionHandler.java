package com.projectBasic.JVBasicCourse.resources.excepitons;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projectBasic.JVBasicCourse.service.exceptions.ResourceNotFoundException;

@ControllerAdvice // intercepta as exceções que acontecerem e então o objeto execute um possivel tratamento
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)//to falando que meu método vai interceptar qualquer exceção desse tipo aqui(no .class); e ai eu faço o tratamento no meu método criado
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now()/*instante de agora*/, status.value()/*aqui eu pego o status e transformo para inteiro*/,
         error/*mensagem de erro criado mais a cima*/,
          e.getMessage()/*mensagem vinda do ResourceNotFoundException*/, request.getRequestURI())/*aqui eu pego o path*/;
          return ResponseEntity.status(status).body(err);//meu body é o err
    }
    
}