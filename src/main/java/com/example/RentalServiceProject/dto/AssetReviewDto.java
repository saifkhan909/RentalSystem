package com.example.RentalServiceProject.dto;

import com.example.RentalServiceProject.model.Asset;
import com.example.RentalServiceProject.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetReviewDto {
    Long id;
    Double rating;
    String review, status;
    User user;
    Asset asset;
}
