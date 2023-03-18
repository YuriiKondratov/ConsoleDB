package ru.kordan.taskapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kordan.taskapi.DTO.BaseTask;
import ru.kordan.taskapi.service.TaskService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<BaseTask>> getAll(){
        return ResponseEntity.of(Optional.of(taskService.allTasks()));
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseTask> getOne(@PathVariable int id) {
        return ResponseEntity.of(Optional.of(taskService.findTask(id)));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody BaseTask task) {
        taskService.updateTask(task);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseTask> delete(@RequestBody BaseTask task){
        return ResponseEntity.of(Optional.of(taskService.deleteTask(task.getId())));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addOne(@RequestBody BaseTask task) throws URISyntaxException {
        int id = taskService.insertTask(task);
        URI location = new URI("/api/task/" + id);
        return ResponseEntity.created(location).body(null);
    }
}
