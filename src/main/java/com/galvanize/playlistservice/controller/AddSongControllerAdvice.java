package com.galvanize.playlistservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.galvanize.playlistservice.exception.GenericNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class
AddSongControllerAdvice {

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(GenericNotFoundException genericNotFoundException) throws Exception {
        return new ResponseEntity<>(this.buildResponseEntity(genericNotFoundException.getMessage()), HttpStatus.BAD_REQUEST);
    }
    private String buildResponseEntity(String message) throws Exception {
        //forming json to return in the response;
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode errorNode = mapper.createObjectNode();
        errorNode.put("error", message);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorNode);
    }
}
