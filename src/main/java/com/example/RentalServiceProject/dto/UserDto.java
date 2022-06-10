package com.example.RentalServiceProject.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    Long id;
    String name;
    Long number;
    String email, gender, type;
    Long accountNumber, cinic;
    String address;
}
