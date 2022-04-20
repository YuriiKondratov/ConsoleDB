package ru.vibelab.task_api.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

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