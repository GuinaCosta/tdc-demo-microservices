package com.kaikeventura.dynamodb.service.impl;

import com.kaikeventura.dynamodb.dto.MeetupChavesDTO;
import com.kaikeventura.dynamodb.model.MeetupChaves;
import com.kaikeventura.dynamodb.repository.MeetupRepository;
import com.kaikeventura.dynamodb.service.MeetupService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetupServiceImpl implements MeetupService {

    private final MeetupRepository meetupRepository;

    public MeetupServiceImpl(MeetupRepository meetupRepository) {
        this.meetupRepository = meetupRepository;
    }

    @Override
    public MeetupChaves saveItem(MeetupChavesDTO meetupChavesDTO) {
        if(meetupRepository.findById(meetupChavesDTO.getId()).isPresent()) {
            throw new RuntimeException("There is already a item with this number");
        }
        return meetupRepository.save(meetupChavesDTO.dtoToModel());
    }

    @Override
    public List<MeetupChaves> findAllItems() {
        return (List<MeetupChaves>) meetupRepository.findAll();
    }

    @Override
    public List<MeetupChaves> findByName(String name) {
        return meetupRepository.findByName(name);
    }

    @Override
    public MeetupChaves updateItem(Integer id, MeetupChavesDTO meetupChavesDTO) {
        Optional<MeetupChaves> item =
                meetupRepository.findById(id);

        if(item.isEmpty()) {
            throw new RuntimeException("There is no item with this number");
        }

        BeanUtils.copyProperties(meetupChavesDTO, item.get(), "id");

        return meetupRepository.save(item.get());
    }

}
