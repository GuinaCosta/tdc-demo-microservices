package br.com.iteris.meetupmonitoria.service;

import br.com.iteris.meetupmonitoria.client.CustomersClient;
import br.com.iteris.meetupmonitoria.client.SalesClient;
import br.com.iteris.meetupmonitoria.dto.CustomerDto;
import br.com.iteris.meetupmonitoria.dto.UserDto;
import br.com.iteris.meetupmonitoria.dto.UserSalesDto;
import br.com.iteris.meetupmonitoria.repository.UserRepository;
import br.com.iteris.meetupmonitoria.repository.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log
@AllArgsConstructor
@Service
public class UserService {

    /**
     * user repository
     */
    private final UserRepository userRepository;

    /**
     * customers client
     */
    private final CustomersClient customersClient;

    /**
     * sales client
     */
    private final SalesClient salesClient;

    /**
     * save the user
     * @param user the user informations
     * @return the user ID
     */
    public String saveUser(UserDto user) {
        String userId = UUID.randomUUID().toString();

        userRepository.save(new UserEntity(user.getName(), user.getAge(), user.getEmail(), userId));
        log.info("m=saveUser r=" + userId);
        return userId;
    }

    /**
     * Find user on the database
     * @param userId the user id to find
     * @return user found on database
     */
    public UserDto findUser(String userId) {
        final UserDto userDto = new UserDto();
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        userEntity.ifPresent(userDto::createFromEntity);
        log.info("m=findUser r=" + userDto);
        return userEntity.isPresent() ? userDto : null;
    }

    /**
     * Find user on the database
     * @param userId the user id to find
     * @return user found on database
     */
    public UserSalesDto findUserPrice(String userId) {
        final UserSalesDto userDto = new UserSalesDto();
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        userEntity.ifPresent(userDto::createFromEntity);

        userDto.setPrice(salesClient.getCurrencyPrice("real"));
        List<CustomerDto> customers = customersClient.listAllCustomers();

        log.info("m=findUser r=" + userDto);
        log.info("m=findUser customers=" + customers);

        return userEntity.isPresent() ? userDto : null;
    }

    /**
     * update the user with specified id
     * @param userId  user ID
     * @param user user data
     * @return the user ID
     */
    public String saveUser(String userId, UserDto user) {
        userRepository.save(new UserEntity(user.getName(), user.getAge(), user.getEmail(), userId));
        log.info("m=saveUser r=" + userId);
        return userId;
    }

    /**
     * deletes the user from database
     * @param userId the user ID
     */
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
        log.info("m=findUser r=" + userId);
    }
}
