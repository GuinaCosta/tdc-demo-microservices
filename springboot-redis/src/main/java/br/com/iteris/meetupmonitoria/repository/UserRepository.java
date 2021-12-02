package br.com.iteris.meetupmonitoria.repository;

import br.com.iteris.meetupmonitoria.repository.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
}
