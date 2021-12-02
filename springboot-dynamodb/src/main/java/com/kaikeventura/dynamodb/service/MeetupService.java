package com.kaikeventura.dynamodb.service;

import com.kaikeventura.dynamodb.dto.MeetupChavesDTO;
import com.kaikeventura.dynamodb.model.MeetupChaves;

import java.util.List;

public interface MeetupService {
    MeetupChaves saveItem(MeetupChavesDTO costumerDTO);
    List<MeetupChaves> findAllItems();
    List<MeetupChaves> findByName(String companyName);
    MeetupChaves updateItem(Integer id, MeetupChavesDTO costumerDTO);
}
