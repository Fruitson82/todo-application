package com.fruitson.study.todo.controller;

import com.fruitson.study.todo.dto.ResponseDTO;
import com.fruitson.study.todo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String testController() {
        return "Hello world";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
        return "Hello World! ID " + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerWithRequestParam(@RequestParam(required = false) int id) {
        return "Hello World! ID " + id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerWithRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World! ID " + testRequestBodyDTO.getId() + ", Message: " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBdoy")
    public ResponseDTO<String> testContollerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testContollerReponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status를 400으로 설정
        return ResponseEntity.badRequest().body(response);
    }
}
