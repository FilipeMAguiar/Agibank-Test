package test.agibank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ItemSale {

    private final Long saleId;
    private final Item item;
    private final Long quantity;

    public ItemSale(Long saleId, String[] item){
        this.saleId = saleId;
        this.item = new Item(item);
        this.quantity = new Long(item[1]);
    }

    public Double getTotalValue() {
        return this.item.getPrice() * this.quantity;
    }
}
