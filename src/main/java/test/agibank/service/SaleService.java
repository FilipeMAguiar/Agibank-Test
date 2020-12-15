package test.agibank.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import test.agibank.entity.Sale;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class SaleService {

    private final List<Sale> saleList;

    private Sale highestSale;

    public SaleService() {
        saleList = new ArrayList<>();
        highestSale = null;
    }

    public Long getIdHighestSale(){
        return highestSale.getId();
    }

    public void addSale(Sale sale){
        saleList.add(sale);
        highestSale();
    }

    private void highestSale(){
        for (Sale sale : saleList) {
            sale.getTotalValue();
            if (highestSale == null || highestSale.getTotalValue() < sale.getTotalValue()) {
                highestSale = sale;
            }
        }
    }

    public void finalize(){
        try {
            super.finalize();
        } catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }
}
