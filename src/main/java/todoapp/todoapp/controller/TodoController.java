package todoapp.todoapp.controller;
import todoapp.todoapp.service.TodoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todoapp.todoapp.model.Todo;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    TodoService todoService;
    
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> get(){
       List<Todo> todos = todoService.findAll();
       return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
    }
  
    @PostMapping("/todos")
    public ResponseEntity<Todo> save(@RequestBody Todo todo){
       Todo todoOne = todoService.save(todo);
       return new ResponseEntity<Todo>(todoOne, HttpStatus.OK);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> get(@PathVariable("id")Long id){
      Todo todo =  todoService.findById(id);
       return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }


    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")Long id){
      todoService.delete(id);
       return new ResponseEntity<String>("Expense deleted", HttpStatus.OK);
    }

    @PutMapping("/todos/{id}")  
    public ResponseEntity<String> saveOrUpdate(@PathVariable("id")long id){
    Todo todo = todoService.findById(id);
    todo.setCompleted(!todo.completed);
    todoService.save(todo);
    return new ResponseEntity<String>("todo updated", HttpStatus.OK);
    }
  
 
  
}  
    
  

