package io.incondensable.web.controllers;

import io.incondensable.business.services.UserService;
import io.incondensable.global.aspects.log.aspect.ControllerLog;
import io.incondensable.web.dto.user.UserResponseDto;
import io.incondensable.web.mappers.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author abbas
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @ControllerLog
    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(
                service.getAllUsers().stream().map(
                        mapper::entityToDto
                ).toList()
        );
    }

    @ControllerLog
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable long userId) {
        return ResponseEntity.ok(
                mapper.entityToDto(
                        service.getUserById(userId)
                )
        );
    }

}
