package com.example.RentalServiceProject.service;

import com.example.RentalServiceProject.dto.AssetDto;
import com.example.RentalServiceProject.model.Asset;
import com.example.RentalServiceProject.repo.AdminRepo;
import com.example.RentalServiceProject.repo.AssetRepo;
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

    public Asset publishAsset(Long id) {
        Optional<Asset> asset = assetRepo.findById(id);
        if(asset.isPresent()){
            asset.get().setStatus("published");
             return  assetRepo.save(asset.get());
        }
        return null;
    }
}
