package com.example.RentalServiceProject.controller;

import com.example.RentalServiceProject.dto.AssetBookingDto;
import com.example.RentalServiceProject.dto.AssetDto;
import com.example.RentalServiceProject.service.AssetBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class AssetBookingController {
    @Autowired
    AssetBookingService assetBookingService;
    @PostMapping("/assetBooking")
    public ResponseEntity<AssetBookingDto> addBooking(@RequestBody AssetBookingDto BookingDto){
        return ResponseEntity.of(Optional.of(assetBookingService.addBooking(BookingDto)));
    }

    @GetMapping("/assetBooking")
    public ResponseEntity<List<AssetBookingDto>> getAllBooking(){
        return ResponseEntity.of(Optional.of(assetBookingService.getAllBooking()));
    }

    @GetMapping("/assetBooking/{id}")
    public ResponseEntity<AssetBookingDto> getBookingById(@PathVariable Long id){
        return ResponseEntity.of(Optional.of(assetBookingService.getBookingById(id)));
    }

    @PutMapping("/assetBooking")
    public ResponseEntity<Void> getBookingById(@RequestBody AssetBookingDto bookingDto){
        assetBookingService.updateBooking(bookingDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/assetBooking/{id}")
    public ResponseEntity<Void> deleteBookingById(@PathVariable Long id){
        assetBookingService.deleteBookingById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
