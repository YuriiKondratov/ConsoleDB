package ru.kordan.taskapi.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kordan.taskapi.DTO.ApiException;

import java.time.LocalDateTime;

@ControllerAdvice
public class TaskApiExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ApiException> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(new ApiException(e.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
