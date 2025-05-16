package br.com.agin.api.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agin.api.entity.User;
import br.com.agin.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<User> listarUsuarioPeloId(@PathVariable("id") String id) {

        return null;
    }

    @PostMapping()
    public ResponseEntity<User> criandoUsuario(@RequestBody CriandoUsuarioDto criandoUsuarioDto) {
        var userId = userService.criandoUsuario(criandoUsuarioDto);
        return ResponseEntity.created(URI.create("/user/" + userId.toString())).build();
    }

}
