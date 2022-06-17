package com.example.RentalServiceProject.controller;

import com.example.RentalServiceProject.dto.AssetDto;
import com.example.RentalServiceProject.model.Asset;
import com.example.RentalServiceProject.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/admin")
@RestController
public class AdminController {


    private final AdminService adminService;

    AdminController(AdminService adminService1){
        this.adminService = adminService1;

    }

    @PatchMapping("/asset/publish/{id}")
    public ResponseEntity<Asset> publishAsset(@PathVariable Long id){
        return ResponseEntity.ok(adminService.publishAsset(id));

    }

    @GetMapping("/asset")
    public ResponseEntity<List<AssetDto>> getAllInreviewAssets(){
        return ResponseEntity.of(Optional.of(adminService.getAllInreviewAssets()));
    }
}
