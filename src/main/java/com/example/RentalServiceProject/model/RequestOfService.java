package com.example.RentalServiceProject.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class RequestOfService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long requestId;
    @ManyToOne
    User user;
    String type, details, status;
}
