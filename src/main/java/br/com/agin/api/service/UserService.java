package br.com.agin.api.service;

import org.springframework.stereotype.Service;

import br.com.agin.api.controller.CriandoUsuarioDto;
import br.com.agin.api.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void criandoUsuario(CriandoUsuarioDto criandoUsuarioDto) {

    }
}
