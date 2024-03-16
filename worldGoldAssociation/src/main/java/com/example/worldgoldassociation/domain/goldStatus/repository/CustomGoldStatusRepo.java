package com.example.worldgoldassociation.domain.goldStatus.repository;

import com.example.worldgoldassociation.response.GoldStatusResponse;

import java.util.List;

public interface CustomGoldStatusRepo {
    List<GoldStatusResponse> getGoldStatus(String name);
}
