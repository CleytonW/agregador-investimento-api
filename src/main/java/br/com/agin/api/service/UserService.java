package br.com.agin.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.agin.api.controller.AtualizarUsuarioDto;
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

    public void atualizarUsuarioPeloId(String userId, AtualizarUsuarioDto atualizarUsuarioDto) {
        var id = UUID.fromString(userId);

        var usuarioExiste = userRepository.findById(id);

        if (usuarioExiste.isPresent()) {
            var usuario = usuarioExiste.get();

            if (atualizarUsuarioDto.nome() != null) {
                usuario.setNome(atualizarUsuarioDto.nome());
            }

            if (atualizarUsuarioDto.senha() != null) {
                usuario.setSenha(atualizarUsuarioDto.senha());
            }

            userRepository.save(usuario);
        }

    }

    public void deletarPeloId(String userId) {
        var id = UUID.fromString(userId);

        var usuarioExiste = userRepository.existsById(id);

        if (usuarioExiste) {
            userRepository.deleteById(id);
        }
    }
}
