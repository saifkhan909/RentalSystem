package com.example.RentalServiceProject.service;

import com.example.RentalServiceProject.dto.AssetDto;
import com.example.RentalServiceProject.model.Asset;
import com.example.RentalServiceProject.repo.AssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    @Autowired
    AssetRepo assetRepo;
    public AssetDto addAsset(AssetDto assetDto) {
        return toDto(assetRepo.save(toDo(assetDto)));
    }

    private Asset toDo(AssetDto assetDto){
        return new Asset().builder()
                .assetId(assetDto.getAssetId())
                    .assetName(assetDto.getAssetName())
                    .pricePerHour(assetDto.getPricePerHour())
                    .location(assetDto.getLocation())
                    .type(assetDto.getType())
                    .status("inreview")
                    .user(assetDto.getUser())
                    .build();
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

    public List<AssetDto> getAllAsset() {
        List<AssetDto> assetDtos = new ArrayList<>();
        for(Asset asset: assetRepo.findByStatus("published")){
            assetDtos.add(toDto(asset));
        }
        return assetDtos;
    }

    public AssetDto getAssetById(Long id) {
        Optional<Asset> asset = assetRepo.findByAssetIdAndStatus(id, "published");
        if(asset.isPresent()){
            return toDto(asset.get());
        }
        return null;
    }

    public void deleteById(Long id) {
        assetRepo.deleteById(id);
    }

    public void updateAsset(AssetDto assetDto) {
        assetRepo.save(toDo(assetDto));
    }
}
