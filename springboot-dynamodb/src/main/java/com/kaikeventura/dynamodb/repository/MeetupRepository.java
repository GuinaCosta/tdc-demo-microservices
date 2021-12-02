package com.kaikeventura.dynamodb.repository;

import com.kaikeventura.dynamodb.model.MeetupChaves;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface MeetupRepository extends CrudRepository<MeetupChaves, String> {
    List<MeetupChaves> findByName(String Name);
    Optional<MeetupChaves> findById(Integer id);
}
