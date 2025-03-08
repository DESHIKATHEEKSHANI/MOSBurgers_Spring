package edu.icet.ecom.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String orderId;
    private Long customerId;
    private String customerName;
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal total;
    private List<OrderItemDTO> itemsOrdered;
    private LocalDateTime orderDate;
}
