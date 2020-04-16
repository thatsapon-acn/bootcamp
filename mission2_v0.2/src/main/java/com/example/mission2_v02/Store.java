package com.example.mission2_v02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Store {
    private Long id;
    private String storeName;
    private String storeLocation;
    private Float storeRating;

    public Store(Long inputId, String Name, String Location, Float rating) {
        this.id = inputId;
        this.storeName = Name;
        this.storeLocation = Location;
        this.storeRating = rating;
    }

}
