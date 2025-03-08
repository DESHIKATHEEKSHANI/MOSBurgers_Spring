package edu.icet.ecom.controller;

import edu.icet.ecom.dto.OrderDTO;
import edu.icet.ecom.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO) {
        orderService.saveOrder(orderDTO);
        return new ResponseEntity<>("Order placed successfully!", HttpStatus.CREATED);
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.searchById(id);
    }

    @PutMapping
    public void updateOrder(@RequestBody OrderDTO orderDTO) {
        orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
