package com.example.RentalServiceProject.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class UserRatingAndReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    User user;
    @ManyToOne
    User provider;
    Double rating;
    String review, status;
}
