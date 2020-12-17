package test.agibank.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Sale {

    private Long id;
    private Salesman salesman;
    private List<Item> items;

    public Sale(Long id, Salesman salesman) {
        this.id = id;
        this.salesman = salesman;
        this.items = new ArrayList<>();
    }

    public Double getTotalSaleValue(){
        return items.stream().mapToDouble(Item::getTotalValue).sum();
    }

    public void addItem(Item item){
        items.add(item);
        salesman.addSale(item.getTotalValue());
    }
}
