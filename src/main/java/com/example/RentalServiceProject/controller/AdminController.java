package com.example.RentalServiceProject.controller;

import com.example.RentalServiceProject.dto.AssetBookingDto;
import com.example.RentalServiceProject.dto.AssetDto;
import com.example.RentalServiceProject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/asset/{id}")
    public ResponseEntity<Void> publishAsset(@PathVariable Long id){
        adminService.publishAsset(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/asset")
    public ResponseEntity<List<AssetDto>> getAllUnpublishedAssets(){
        return ResponseEntity.of(Optional.of(adminService.getAllInreviewAssets()));
    }
}
