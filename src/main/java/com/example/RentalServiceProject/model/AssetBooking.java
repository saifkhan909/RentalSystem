package com.example.RentalServiceProject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class AssetBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDate startDate, endDate;
    @ManyToOne
    private User users;
    @ManyToOne
    private Asset assets;
}
