package gustavo.orderapi.service;

import gustavo.orderapi.entity.OrderEntity;
import gustavo.orderapi.enums.OrderStatus;
import gustavo.orderapi.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderEntity create(OrderEntity order) {
        order.setStatus(OrderStatus.OPEN);

        return repository.save(order);
    }

    public List<OrderEntity> findAll(Optional<OrderStatus> status) {
        if (status.isPresent()) {
            return repository.findByStatus(status.get());
        }
        return repository.findByStatus(OrderStatus.OPEN);
    }


    public OrderEntity findById(Integer id) {
        OrderEntity order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        if (order.getStatus() == OrderStatus.CANCELED) {
            throw new RuntimeException("Order is canceled");
        }
        return order;
    }

    public OrderEntity payOrder(Integer id) {
        OrderEntity order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() != OrderStatus.OPEN) {
            throw new RuntimeException("Only open orders can be paid.");
        }

        order.setStatus(OrderStatus.PAID);

        return repository.save(order);
    }

    public OrderEntity cancelOrder(Integer id) {
        OrderEntity order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() == OrderStatus.PAID) {
            throw new RuntimeException("Orden has already been paid");
        }

        order.setStatus(OrderStatus.CANCELED);

        return repository.save(order);
    }

    public void deleteOrder(Integer id){
        OrderEntity order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if(order.getStatus() != OrderStatus.CANCELED){
            throw new RuntimeException("Deletion is allowed only for orders with status CANCELED.");
        }

        repository.delete(order);
    }
}



