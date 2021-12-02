package br.com.iteris.meetupmonitoria.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RedisHash("User")
public class UserEntity implements Serializable {

    private String name;
    private Integer age;
    private String email;
    private String id;

}
