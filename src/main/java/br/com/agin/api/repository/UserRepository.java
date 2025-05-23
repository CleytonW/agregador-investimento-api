package br.com.agin.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agin.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
