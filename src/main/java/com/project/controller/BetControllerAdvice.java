package com.project.controller;

import com.project.exception.InvalidRequestBodyException;
import com.project.rest.ErrorMessage;
import org.apache.log4j.Logger;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {BetController.class})
public class BetControllerAdvice {

    private static Logger logger = Logger.getLogger(BetControllerAdvice.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(ex.getMessage());
        //logger.error(ex.getLogMsg());
        //logger.info(ex.getLogMsg());
        return new ResponseEntity<Object>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidRequestBodyException.class})
    public ResponseEntity<Object> handleInvalidRequestBodyException(InvalidRequestBodyException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(ex.getMessage());
        logger.error(ex.getLogMsg());
        logger.info(ex.getLogMsg());
        return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
