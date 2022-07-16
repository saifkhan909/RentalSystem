package com.example.RentalServiceProject.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    Long id;
    @NotEmpty
    @NotNull(message = "name nahi ha")
    String name;
    Long number;
    String email, gender, type;
    Long accountNumber, cinic;
    String address;
}
