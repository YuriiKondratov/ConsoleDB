package ru.vibelab.task_api.execption;

import java.time.LocalDateTime;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
