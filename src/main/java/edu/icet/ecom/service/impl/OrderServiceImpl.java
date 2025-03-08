package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.OrderDTO;
import edu.icet.ecom.dto.OrderItemDTO;
import edu.icet.ecom.entity.Order;
import edu.icet.ecom.entity.OrderItem;
import edu.icet.ecom.repository.OrderRepository;
import edu.icet.ecom.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public void saveOrder(OrderDTO orderDTO) {
        Order order = new Order();

        Long nextId = orderRepository.count() + 1;

        String formattedOrderId = String.format("ORD%04d", nextId);

        order.setOrderId(formattedOrderId);
        order.setCustomerId(orderDTO.getCustomerId());
        order.setCustomerName(orderDTO.getCustomerName());
        order.setSubtotal(orderDTO.getSubtotal());
        order.setDiscount(orderDTO.getDiscount());
        order.setTotal(orderDTO.getTotal());

        order.setItems(orderDTO.getItemsOrdered().stream().map(itemDTO -> {
            OrderItem item = new OrderItem();
            item.setItemName(itemDTO.getName());
            item.setPrice(itemDTO.getPrice());
            item.setQuantity(itemDTO.getQuantity());
            item.setOrder(order);
            return item;
        }).collect(Collectors.toList()));

        orderRepository.save(order);
    }

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public List<OrderDTO> getAll() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(order -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setOrderId(order.getOrderId());
            orderDTO.setCustomerId(order.getCustomerId());
            orderDTO.setCustomerName(order.getCustomerName());
            orderDTO.setSubtotal(order.getSubtotal());
            orderDTO.setDiscount(order.getDiscount());
            orderDTO.setTotal(order.getTotal());
            orderDTO.setOrderDate(order.getOrderDate());

            List<OrderItemDTO> itemDTOs = order.getItems().stream().map(item -> {
                OrderItemDTO itemDTO = new OrderItemDTO();
                itemDTO.setName(item.getItemName());
                itemDTO.setPrice(item.getPrice());
                itemDTO.setQuantity(item.getQuantity());
                return itemDTO;
            }).collect(Collectors.toList());

            orderDTO.setItemsOrdered(itemDTOs);

            return orderDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            orderRepository.delete(orderOptional.get());
        } else {
            throw new RuntimeException("Order with ID " + id + " not found.");
        }
    }

    @Override
    public OrderDTO searchById(Long id) {
        return null;
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {

    }
}
