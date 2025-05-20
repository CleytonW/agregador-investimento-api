package br.com.agin.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agin.api.entity.User;
import br.com.agin.api.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> listarUsuarioPeloId(@PathVariable("userId") String userId) {
        var user = userService.listarUsuarioPeloId(userId);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios() {

        var user = userService.listarUsuarios();
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> criandoUsuario(@RequestBody CriandoUsuarioDto criandoUsuarioDto) {
        var userId = userService.criandoUsuario(criandoUsuarioDto);
        return ResponseEntity.created(URI.create("/user/" + userId.toString())).build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> atualizarUsuarioPeloId(@PathVariable("userId") String userId, @RequestBody AtualizarUsuarioDto atualizarUsuarioDto) {

        userService.atualizarUsuarioPeloId(userId, atualizarUsuarioDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletarPeloId(@PathVariable("userId") String userId) {

        userService.deletarPeloId(userId);

        return ResponseEntity.noContent().build();
    }

}
