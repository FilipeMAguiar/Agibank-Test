package test.agibank.entity;

import lombok.Getter;

@Getter
public class Item {

    private final Long id;
    private final Double price;

    public Item(String[] data){
        this.id = new Long(data[0]);
        this.price = new Double(data[2]);
    }
}
