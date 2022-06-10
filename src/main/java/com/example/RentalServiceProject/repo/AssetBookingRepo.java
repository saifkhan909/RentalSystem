package com.example.RentalServiceProject.repo;

import com.example.RentalServiceProject.dto.AssetBookingDto;
import com.example.RentalServiceProject.model.AssetBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetBookingRepo extends JpaRepository<AssetBooking, Long> {
}
