package ru.vibelab.task_api.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vibelab.task_api.DTO.BaseTask;
import ru.vibelab.task_api.database.Table;
import ru.vibelab.task_api.execption.NotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    @Autowired
    private Table<BaseTask> db;

    public BaseTask findTask(int id) {
        BaseTask task = db.getOne(id);
        if (task == null) throw new NotFoundException("Task with id " + id + " was not found");
        return task;
    }

    public List<BaseTask> allTasks() {
        List<BaseTask> res = new ArrayList<>();
        for (Map.Entry<Integer, BaseTask> entry : db.getAll())
            res.add(entry.getValue());
        return res;
    }

    public int insertTask(BaseTask task) {
        int id = db.insert(task);
        task.setId(id);
        return id;
    }

    public void updateTask(BaseTask task) {
        int id = task.getId();
        boolean res = db.update(id, task);
        if (!res) throw new NotFoundException("Task with id " + id + " was not found");
    }

    public BaseTask deleteTask(int id) {
        BaseTask task = db.delete(id);
        if (task == null) throw new NotFoundException("Task with id " + id + " was not found");
        return task;
    }
}
