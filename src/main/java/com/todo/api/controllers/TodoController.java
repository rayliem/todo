package com.todo.api.controllers;

import com.todo.api.application.requests.AddToDoRequest;
import com.todo.api.application.requests.GetToDoRequest;
import com.todo.api.application.requests.UpdateToDoRequest;
import com.todo.api.application.service.interfaces.IAddToDoService;
import com.todo.api.application.service.interfaces.IDeleteToDoService;
import com.todo.api.application.service.interfaces.IGetToDoService;
import com.todo.api.application.service.interfaces.IUpdateToDoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/todos")
public class TodoController {
    @Autowired
    private IGetToDoService getToDoService;
    @Autowired
    private IAddToDoService addToDoService;
    @Autowired
    private IUpdateToDoService updateToDoService;
    @Autowired
    private IDeleteToDoService deleteToDoService;
    @GetMapping("/")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Request completed successfully")
    })
    public ResponseEntity GetToDos(){
        return new ResponseEntity<>(getToDoService.getToDoS(), HttpStatus.OK);
    }

    @GetMapping("/{todoId}")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Request completed successfully"),
            @ApiResponse(responseCode = "404", description= "Not Found")
    })
    public ResponseEntity GetToDo(@PathVariable Integer todoId){
        var getToDoRequest = new GetToDoRequest();
        getToDoRequest.setTodoId(todoId);
        var todo = getToDoService.getToDo(getToDoRequest);
        //logger.debug("Hello from Log4j 2 - num : {}", () -> todo);
        return new ResponseEntity<>(todo.getTodos(), HttpStatus.OK);
    }

    @PutMapping("/{todoId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Request completed successfully"),
            @ApiResponse(responseCode = "404", description= "Not Found")
    })
    public ResponseEntity UpdateProfession(@RequestBody UpdateToDoRequest updateToDoRequest){
        var response = updateToDoService.updateToDo(updateToDoRequest);
        return new ResponseEntity<>(HttpStatus.OK );
    }

    @PostMapping("/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ToDo created",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Conflict",
                    content = @Content)})
    public ResponseEntity SetProfession(@RequestBody AddToDoRequest addToDoRequest) throws ValidationException {

        var response = addToDoService.addToDo(addToDoRequest);
        return new ResponseEntity<>(HttpStatus.CREATED );
    }

    @DeleteMapping("{toDoId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Request completed successfully"),
            @ApiResponse(responseCode = "404", description= "Not Found")
    })
    public ResponseEntity<Long> deletePost(@PathVariable int toDoId) {

        deleteToDoService.deleteToDo(toDoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
