package gustavo.orderapi.controller;

import gustavo.orderapi.dto.OrderRequestDTO;
import gustavo.orderapi.dto.OrderResponseDTO;
import gustavo.orderapi.entity.OrderEntity;
import gustavo.orderapi.enums.OrderStatus;
import gustavo.orderapi.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> create(@RequestBody @Valid OrderRequestDTO dto) {

        OrderEntity saved = service.create(dto.toEntity());

        return ResponseEntity
                .status(201)
                .body(new OrderResponseDTO(saved));

    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll(
            @RequestParam(value = "status", required = false) OrderStatus status) {

        List<OrderEntity> orders = service.findAll(Optional.ofNullable(status));

        List<OrderResponseDTO> response = orders.stream()
                .map(OrderResponseDTO::new)
                .toList();

        return ResponseEntity.ok(response);
    }


    @GetMapping("{id}")
    public ResponseEntity<OrderResponseDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(
                new OrderResponseDTO(service.findById(id)));
    }

    @PutMapping("/{id}/pay")
    public ResponseEntity<OrderResponseDTO> payOrder(@PathVariable("id") Integer id) {
        OrderEntity order = service.payOrder(id);

        return ResponseEntity.ok(new OrderResponseDTO(order));
    }

    @PutMapping("{id}/cancel")
    public ResponseEntity<OrderResponseDTO> cancelOrder(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(
                new OrderResponseDTO(service.cancelOrder(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
