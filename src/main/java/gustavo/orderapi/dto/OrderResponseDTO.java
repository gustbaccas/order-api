package gustavo.orderapi.dto;

import gustavo.orderapi.entity.OrderEntity;

import java.math.BigDecimal;

public class OrderResponseDTO {

    private Integer id;
    private String customerName;
    private BigDecimal totalValue;
    private Enum status;
    private Boolean active;

    public OrderResponseDTO(OrderEntity order) {
        this.id = order.getId();
        this.customerName = order.getCustomerName();
        this.totalValue = order.getTotalValue();
        this.status = order.getStatus();
        this.active = order.getActive();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
