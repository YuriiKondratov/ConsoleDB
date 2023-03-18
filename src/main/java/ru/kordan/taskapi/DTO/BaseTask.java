package ru.kordan.taskapi.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BaseTask {
    private String name;
    private String description;
    private LocalDateTime deadline;
    private boolean done;
    private int id;
}