package com.example.RentalServiceProject.controller;

import com.example.RentalServiceProject.dto.AssetReviewDto;
import com.example.RentalServiceProject.model.AssetReview;
import com.example.RentalServiceProject.service.AssetReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class AssetReviewController {
    @Autowired
    AssetReviewService assetReviewService;

    @PostMapping("/assetReview")
    public ResponseEntity<AssetReviewDto> addAssetReview(@RequestBody AssetReviewDto assetReview){
        return ResponseEntity.of(Optional.of(assetReviewService.addAssetReview(assetReview)));
    }

    @GetMapping("/assetReview")
    public ResponseEntity<List<AssetReviewDto>> getAllAssetReview(){
        return ResponseEntity.of(Optional.of(assetReviewService.getAllAssetReview()));
    }

    @GetMapping("/assetReview/{id}")
    public ResponseEntity<AssetReviewDto> getAssetReviewById(@PathVariable Long id){
        return ResponseEntity.of(Optional.of(assetReviewService.getAssetReviewById(id)));
    }

    @DeleteMapping("/assetReview/{id}")
    public ResponseEntity<Void> getAssetReviewDeleteById(@PathVariable Long id){
        assetReviewService.getAssetReviewDeleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
