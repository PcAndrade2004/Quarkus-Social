package br.com.pauloCesar.service;

import br.com.pauloCesar.entity.UserEntity;
import br.com.pauloCesar.repository.UserRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@Dependent
public class UserService {

    UserRepository userRepository;

    public UserService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserEntity novoUsuario( @Valid UserEntity userEntity) {
        userRepository.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> listarUsuarios( Integer page, Integer size) {
        return userRepository.findAll()
                .page(page, size)
                .list();
    };

    public UserEntity buscarUsuarioId( UUID usuarioId) {
        return userRepository.findById(usuarioId);
    }

    @Transactional
    public UserEntity atualizarUsuario( UUID usuarioId, @Valid UserEntity userEntity) {
        UserEntity usuarioAtual = buscarUsuarioId(usuarioId);
        usuarioAtual.setName(userEntity.getName());
        usuarioAtual.setAge(userEntity.getAge());
        return usuarioAtual;
    }

    @Transactional
    public void deletarUsuario( UUID usuarioId) {
        userRepository.delete(buscarUsuarioId(usuarioId));
    }
}
