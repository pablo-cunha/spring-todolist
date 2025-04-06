package br.com.pablocunha.todolist.service;


import br.com.pablocunha.todolist.entity.Todo;
import br.com.pablocunha.todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository repository;

    public TodoService(TodoRepository todoRepository) {
        this.repository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        repository.save(todo);
        return list();
    }

    public List<Todo> list() {
        // Usando "Sort" pra ordenar tarefas por prioridade e nome
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("title").ascending()
        );

        return repository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        repository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        repository.deleteById(id);
        return list();
    }
}
