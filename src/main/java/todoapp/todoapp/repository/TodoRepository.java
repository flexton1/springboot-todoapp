package todoapp.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todoapp.todoapp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
