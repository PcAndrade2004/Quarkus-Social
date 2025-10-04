package br.com.pauloCesar.repository;

import br.com.pauloCesar.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.Dependent;

import java.util.UUID;

@Dependent
public class UserRepository implements PanacheRepositoryBase<UserEntity, UUID> {

}
