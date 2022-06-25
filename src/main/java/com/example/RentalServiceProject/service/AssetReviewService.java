package com.example.RentalServiceProject.service;

import com.example.RentalServiceProject.dto.AssetDto;
import com.example.RentalServiceProject.dto.AssetReviewDto;
import com.example.RentalServiceProject.model.Asset;
import com.example.RentalServiceProject.model.AssetBooking;
import com.example.RentalServiceProject.model.AssetReview;
import com.example.RentalServiceProject.repo.AssetReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AssetReviewService {
    @Autowired
    AssetReviewRepo assetReviewRepo;
    public AssetReviewDto addAssetReview(AssetReviewDto assetReview) {
        return toDto(assetReviewRepo.save(toDo(assetReview)));
    }

    private AssetReview toDo(AssetReviewDto assetReviewDto){
        return new AssetReview().builder()
                        .id(assetReviewDto.getId())
                        .rating(assetReviewDto.getRating())
                        .review(assetReviewDto.getReview())
                        .status("inreview")
                        .user(assetReviewDto.getUser())
                        .asset(assetReviewDto.getAsset())
                        .build();
    }

    private AssetReviewDto toDto(AssetReview assetReview){
        return new AssetReviewDto().builder()
                .id(assetReview.getId())
                .rating(assetReview.getRating())
                .review(assetReview.getReview())
                .user(assetReview.getUser())
                .asset(assetReview.getAsset())
                .build();
    }

    public List<AssetReviewDto> getAllAssetReview() {
        List<AssetReviewDto> assetReviewDtos = new ArrayList<>();
        for(AssetReview assetReview: assetReviewRepo.findAll()){
            assetReviewDtos.add(toDto(assetReview));
        }
        return assetReviewDtos;
    }

    public AssetReviewDto getAssetReviewById(Long id) {
        Optional<AssetReview> assetReviewDto = assetReviewRepo.findById(id);
        if(assetReviewDto.isPresent()){
            return toDto(assetReviewDto.get());
        }
        return null;
    }

    public void getAssetReviewDeleteById(Long id) {
        assetReviewRepo.deleteById(id);
    }
}
