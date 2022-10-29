package ru.geekbrains.spring.market.dtos;

import lombok.*;

@Data
@NoArgsConstructor
public class OrderDetailsDto {
    private String phone;
    private DeliveryAddressDto deliveryAddress;
}