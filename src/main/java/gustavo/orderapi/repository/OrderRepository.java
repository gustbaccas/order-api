package gustavo.orderapi.repository;

import gustavo.orderapi.entity.OrderEntity;
import gustavo.orderapi.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findByStatus(OrderStatus status);
}
