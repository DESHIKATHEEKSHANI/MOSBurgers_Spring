package edu.icet.ecom.service;

import edu.icet.ecom.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO addOrder(OrderDTO orderDTO);
    List<OrderDTO> getAll();
    OrderDTO searchById(Long id);
    void updateOrder(OrderDTO orderDTO);
    void deleteOrder(Long id);
    void saveOrder(OrderDTO orderDTO);
}
