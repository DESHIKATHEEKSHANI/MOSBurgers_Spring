package edu.icet.ecom.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private String name;
    private BigDecimal price;
    private int quantity;
}