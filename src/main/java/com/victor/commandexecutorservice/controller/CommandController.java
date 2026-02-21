package com.victor.commandexecutorservice.controller;

import com.victor.commandexecutorservice.service.CommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commands")
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @GetMapping("/list")
    public ResponseEntity<String> listFiles(@RequestParam(required = false) String path) {
        try {
            String result = commandService.listFiles(path);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error ejecutando comando: " + e.getMessage());
        }
    }
}