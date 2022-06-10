package com.example.RentalServiceProject.dto;

import com.example.RentalServiceProject.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {
    Long assetId;
    String assetName;
    int pricePerHour;
    String location, type;
    String status;
    User user;
}
