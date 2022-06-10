package com.example.RentalServiceProject.service;

import com.example.RentalServiceProject.dto.AssetBookingDto;
import com.example.RentalServiceProject.model.AssetBooking;
import com.example.RentalServiceProject.repo.AssetBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

@Service
public class AssetBookingService {
    @Autowired
    AssetBookingRepo assetBookingRepo;
    public AssetBookingDto addBooking(AssetBookingDto bookingDto) {
        return toDto(assetBookingRepo.save(toDo(bookingDto)));
    }



    private AssetBooking toDo(AssetBookingDto bookingDto){
        return new AssetBooking().builder()
                        .bookingId(bookingDto.getBookingId())
                        .startDate(bookingDto.getStartDate())
                        .endDate(bookingDto.getEndDate())
                        .users(bookingDto.getUsers())
                        .assets(bookingDto.getAssets())
                        .build();
    }

    private AssetBookingDto toDto(AssetBooking assetBooking){
        return new AssetBookingDto().builder()
                .bookingId(assetBooking.getBookingId())
                .startDate(assetBooking.getStartDate())
                .endDate(assetBooking.getEndDate())
                .users(assetBooking.getUsers())
                .assets(assetBooking.getAssets())
                .build();
    }

    public List<AssetBookingDto> getAllBooking() {
        List<AssetBookingDto> assetBookingDtos = new ArrayList<>();

        for(AssetBooking assetBooking: assetBookingRepo.findAll()){
            assetBookingDtos.add(toDto(assetBooking));
        }
        return assetBookingDtos;
    }

    public AssetBookingDto getBookingById(Long id) {
        Optional<AssetBooking> assetBooking = assetBookingRepo.findById(id);
        if(assetBooking.isPresent()){
            return toDto(assetBooking.get());
        }
        return null;
    }

    public void updateBooking(AssetBookingDto bookingDto) {
        assetBookingRepo.save(toDo(bookingDto));
    }

    public void deleteBookingById(Long id) {
        assetBookingRepo.deleteById(id);
    }
}
