package com.example.RentalServiceProject.dto;

import lombok.Data;

import java.security.PrivateKey;
@Data
public class SearchCriteria {
    private String key;
    private  String operation;
    private Object value;
}
