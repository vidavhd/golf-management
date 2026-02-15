package com.management.golf_management.controller;

import com.management.golf_management.model.request.PlayerRegisterRequest;
import com.management.golf_management.model.response.PlayerRegisterResponse;
import com.management.golf_management.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/golf-management")
public class GolfManagementController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayerRegisterResponse> registerPlayer(
            @Valid @RequestBody PlayerRegisterRequest request) {
        return ResponseEntity.ok(playerService.registerPlayer(request));
    }
}
