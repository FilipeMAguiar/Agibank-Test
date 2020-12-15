package test.agibank.entity;

import lombok.Getter;
import lombok.Setter;
import test.agibank.service.CustomerService;
import test.agibank.service.SaleService;
import test.agibank.service.SalesmanService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Sale extends GenericIdentifier {

    private final Long id;
    private final List<ItemSale> items;
    private final String salesman;

    public Sale(String[] info) {
        this.id = Long.valueOf(info[1]);
        this.items = new ArrayList<>();
        this.salesman = info[3];

        String[] splitLine = info[2].replace("[", "").replace("]", "").split(",");

        Arrays.stream(splitLine).forEach(item -> items.add(new ItemSale(this.id, item.split("-"))));
    }

    public Double getTotalValue(){
        return items.stream().mapToDouble(ItemSale::getTotalValue).sum();
    }

    @Override
    public void sale(SaleService saleService) {
        saleService.addSale(this);
    }

    @Override
    public void salesmanData(SalesmanService salesmanService) {

    }

    @Override
    public void customer(CustomerService customerService) {

    }
}
