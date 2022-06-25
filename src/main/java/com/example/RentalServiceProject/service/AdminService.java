package com.example.RentalServiceProject.service;

import com.example.RentalServiceProject.dto.AssetDto;
import com.example.RentalServiceProject.dto.AssetReviewDto;
import com.example.RentalServiceProject.model.Asset;
import com.example.RentalServiceProject.model.AssetReview;
import com.example.RentalServiceProject.repo.AdminRepo;
import com.example.RentalServiceProject.repo.AssetRepo;
import com.example.RentalServiceProject.repo.AssetReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AssetRepo assetRepo;
    @Autowired
    AssetReviewRepo assetReviewRepo;
    public List<AssetDto> getAllInreviewAssets() {
        List<AssetDto> assetDtos = new ArrayList<>();
        for(Asset asset: assetRepo.findByStatus("inreview")){
            assetDtos.add(toDto(asset));
        }
        return assetDtos;
    }

    private AssetDto toDto(Asset asset){
        return new AssetDto().builder()
                .assetId(asset.getAssetId())
                .assetName(asset.getAssetName())
                .pricePerHour(asset.getPricePerHour())
                .location(asset.getLocation())
                .type(asset.getType())
                .user(asset.getUser())
                .build();
    }
    private AssetReviewDto toDto1(AssetReview assetReview){
        return new AssetReviewDto().builder()
                .id(assetReview.getId())
                .rating(assetReview.getRating())
                .review(assetReview.getReview())
                .user(assetReview.getUser())
                .asset(assetReview.getAsset())
                .build();
    }

    public void publishAsset(Long id) {
        Optional<Asset> asset = assetRepo.findById(id);
        if(asset.isPresent()){
            asset.get().setStatus("published");
            assetRepo.save(asset.get());
        }
    }

    public List<AssetReviewDto> getAllInreviewOfAssetsReview() {
        List<AssetReviewDto> assetReviewDtos = new ArrayList<>();
        for(AssetReview assetReview: assetReviewRepo.findByStatus("inreview")){
            assetReviewDtos.add(toDto1(assetReview));
        };
        return assetReviewDtos;
    }

    public void publishAssetReview(Long id) {
        Optional<AssetReview> assetReview = assetReviewRepo.findById(id);
        if(assetReview.isPresent()){
            assetReview.get().setStatus("published");
            assetReviewRepo.save(assetReview.get());
        }
    }
}
