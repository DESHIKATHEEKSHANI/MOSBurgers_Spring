package edu.icet.ecom.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private Long id;
    private String name;
    private String contact;
}
