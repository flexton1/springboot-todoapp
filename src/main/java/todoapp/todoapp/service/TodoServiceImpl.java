package todoapp.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.todoapp.model.Todo;
import todoapp.todoapp.repository.TodoRepository;


@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;

@Override
public List<Todo> findAll(){
    return todoRepository.findAll();
}

@Override
public Todo save(Todo todo) {
    todoRepository.save(todo);
    return todo;
}

@Override
public Todo findById(long id) {
    if(todoRepository.findById(id).isPresent()){
        return todoRepository.findById(id).get();
    }
    return null;
}

@Override
public void delete(long id) {
    Todo todo = findById(id);
    todoRepository.delete(todo);
    
}

@Override
public Todo saveOrUpdate(long id, Todo todo) {
    todo.completed = !todo.completed;
    Todo todoOne = findById(id);
    todoOne.setCompleted(todo.completed);
    return todoOne;
}




}
