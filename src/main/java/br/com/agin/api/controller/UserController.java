package br.com.agin.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agin.api.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
    

    @GetMapping("{id}")
    public ResponseEntity<User> listarUsuarioPeloId(@PathVariable("id") String id) {

        return null;
    }

    @PostMapping()
    public ResponseEntity<User> criandoUsuario(@RequestBody CriandoUsuarioDto criandoUsuarioDto) {

        return null;
    }

}
