package com.example.RentalServiceProject.controller;

import com.example.RentalServiceProject.dto.AssetDto;
import com.example.RentalServiceProject.dto.UserDto;
import com.example.RentalServiceProject.model.User;
import com.example.RentalServiceProject.service.AssetService;
import com.example.RentalServiceProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class AssetController {
    @Autowired
    AssetService assetService;
    @PostMapping("/asset")
    public ResponseEntity<AssetDto> addAsset(@RequestBody AssetDto assetDto){
        return ResponseEntity.of(Optional.of(assetService.addAsset(assetDto)));
    }

    @GetMapping("/asset")
    public ResponseEntity<List<AssetDto>> getAllAsset(){
        return ResponseEntity.of(Optional.of(assetService.getAllAsset()));
    }

    @GetMapping("/asset/{id}")
    public ResponseEntity<AssetDto> getAssetById(@PathVariable Long id){
        return ResponseEntity.of(Optional.of(assetService.getAssetById(id)));
    }

    @DeleteMapping("/asset/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        assetService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/asset")
    public ResponseEntity<Void> updateAsset(@RequestBody AssetDto assetDto){
        assetService.updateAsset(assetDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
