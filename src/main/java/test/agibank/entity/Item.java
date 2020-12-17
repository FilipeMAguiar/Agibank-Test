package test.agibank.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private Long id;
    private int quantity;
    private Double price;
    private Double totalValue;

    public Item(Long id, int quantity, Double price){
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.totalValue = price * quantity;
    }
}
