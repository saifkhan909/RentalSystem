package com.example.RentalServiceProject.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long number;
    String email, gender, type;
    Long accountNumber, cinic;
    String address;
}
