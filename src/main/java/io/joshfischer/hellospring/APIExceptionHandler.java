package io.joshfischer.hellospring;

import io.joshfischer.hellospring.domain.ApiResponse;
import io.joshfischer.hellospring.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class APIExceptionHandler {

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public @ResponseBody ApiResponse handleValidationException(final Exception e) {
    return new ApiResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(ResourceNotFoundException.class)
  public @ResponseBody ApiResponse handleNotFoundException(final Exception e) {
    return new ApiResponse(HttpStatus.NOT_FOUND.toString(), e.getMessage());
  }
}
