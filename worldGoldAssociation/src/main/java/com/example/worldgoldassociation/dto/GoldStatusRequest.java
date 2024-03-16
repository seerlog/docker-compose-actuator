package com.example.worldgoldassociation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoldStatusRequest {
    private String name;
    private String country;
    private int goldMiningKilograms;
}
