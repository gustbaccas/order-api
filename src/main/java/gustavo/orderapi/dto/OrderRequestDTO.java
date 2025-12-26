package gustavo.orderapi.dto;

import gustavo.orderapi.entity.OrderEntity;
import gustavo.orderapi.enums.OrderStatus;
import org.springframework.http.RequestEntity;

import java.math.BigDecimal;


public class OrderRequestDTO {

    private String customerName;
    private BigDecimal totalValue;
    private Boolean active;
    private OrderStatus status;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public OrderEntity toEntity(){
        OrderEntity order = new OrderEntity();
        order.setCustomerName(this.customerName);
        order.setTotalValue(this.totalValue);
        return order;
    }
}
