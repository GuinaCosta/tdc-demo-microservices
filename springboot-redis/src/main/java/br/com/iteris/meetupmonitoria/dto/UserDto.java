package br.com.iteris.meetupmonitoria.dto;

import br.com.iteris.meetupmonitoria.repository.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private Integer age;
    private String email;

    public void createFromEntity(UserEntity userEntity) {
        this.setAge(userEntity.getAge());
        this.setEmail(userEntity.getEmail());
        this.setName(userEntity.getName());
    }
}
