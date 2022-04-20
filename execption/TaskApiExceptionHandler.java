package ru.vibelab.task_api.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vibelab.task_api.DTO.ApiException;

import java.time.LocalDateTime;
import java.util.Optional;

@ControllerAdvice
public class TaskApiExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ApiException> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(new ApiException(e.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
