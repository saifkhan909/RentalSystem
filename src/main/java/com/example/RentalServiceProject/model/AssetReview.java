package com.example.RentalServiceProject.model;

import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class AssetReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double rating;
    String review, status;
    @ManyToOne
    User user;
    @ManyToOne
    Asset asset;
}
