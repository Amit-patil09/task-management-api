package com.devops.task_management;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private List<Todo> todos = new ArrayList<>();

    private AtomicLong counter = new AtomicLong(1);

    // Returns the total number of tasks
    @GetMapping
    public List<Todo> getTodos() {
        return todos;
    }

    @PostMapping
    public Todo addTodo(@RequestBody TodoRequest request) {

        Todo todo = new Todo(
                counter.getAndIncrement(),
                request.task());

        todos.add(todo);

        return todo;
    }

    public record TodoRequest(String task) {
    }
}