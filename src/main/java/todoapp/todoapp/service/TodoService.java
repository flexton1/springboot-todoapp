package todoapp.todoapp.service;

import java.util.List;

import todoapp.todoapp.model.Todo;

public interface TodoService {
    
    List<Todo> findAll();
    Todo save(Todo todo);
    Todo findById(long id);
    void delete(long id);
    Todo saveOrUpdate(long id, Todo todo);
}
