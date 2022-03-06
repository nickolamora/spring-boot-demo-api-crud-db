package com.nickolamora.springbootdemodailycodebuffer.error;

import com.nickolamora.springbootdemodailycodebuffer.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Whatever the class that handles the exceptions needs to be annotated with ControllerAdvice,
 * you can also have different controller advice for different controller and base packages.
 * <p>
 * This class will handle the exceptions and create a response for that exception
 */
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  // Here this method will catch that exception thrown from the controller by the serviceImpl and return back this error which
  // the body is made from ErrorMessage and tied to the ResponseEntity to be sent back to the client
  @ExceptionHandler(DepartmentNotFoundException.class)
  public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException ex, WebRequest request) {

    ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
  }
}

