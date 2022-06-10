package com.example.RentalServiceProject.dto;

import com.example.RentalServiceProject.model.Asset;
import com.example.RentalServiceProject.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetBookingDto {
    private Long bookingId;
    private LocalDate startDate, endDate;
    private User users;
    private Asset assets;
}
