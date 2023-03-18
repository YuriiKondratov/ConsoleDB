package ru.kordan.taskapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ApiException {
    private String message;
    private LocalDateTime timestamp;
}
