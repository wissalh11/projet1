package com.hnj.offer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "offer")
public class Offer {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "product_id")
    @NotNull
    private Integer productId;

    @Column(name = "discount_offer")
    private Double discountOffer;
}
