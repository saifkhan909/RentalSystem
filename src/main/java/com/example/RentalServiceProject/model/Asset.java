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
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long assetId;
    String assetName;
    int pricePerHour;
    String location, type;
    String status;
    @ManyToOne
    User user;
}
