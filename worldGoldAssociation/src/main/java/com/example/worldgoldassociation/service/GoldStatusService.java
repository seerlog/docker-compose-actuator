package com.example.worldgoldassociation.service;

import com.example.worldgoldassociation.domain.goldStatus.GoldStatus;
import com.example.worldgoldassociation.domain.goldStatus.repository.CustomGoldStatusRepo;
import com.example.worldgoldassociation.domain.goldStatus.repository.GoldStatusRepo;
import com.example.worldgoldassociation.request.GoldStatusRequest;
import com.example.worldgoldassociation.response.GoldStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoldStatusService {
    private final GoldStatusRepo goldStatusRepo;
    private final CustomGoldStatusRepo customGoldStatusRepo;

    public List<GoldStatusResponse> getGoldStatus(String name) {
        return customGoldStatusRepo.getGoldStatus(name);
    }

    public void saveGoldStatus(GoldStatusRequest goldStatusRequest) {
        goldStatusRepo.save(GoldStatus.of(goldStatusRequest));
    }
}
