package br.com.agin.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.agin.api.controller.CriandoUsuarioDto;
import br.com.agin.api.entity.User;
import br.com.agin.api.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> listarUsuarioPeloId(String userId) {

        return userRepository.findById(UUID.fromString(userId));

    }

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public UUID criandoUsuario(CriandoUsuarioDto criandoUsuarioDto) {

        var entity = new User();
        entity.setNome(criandoUsuarioDto.nome());
        entity.setEmail(criandoUsuarioDto.email());
        entity.setSenha(criandoUsuarioDto.senha());

        var usuarioSalvo = userRepository.save(entity);

        return usuarioSalvo.getUserId();
    }
}
