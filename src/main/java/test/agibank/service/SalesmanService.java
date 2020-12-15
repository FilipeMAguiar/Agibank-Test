package test.agibank.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import test.agibank.entity.Salesman;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class SalesmanService {

    private final List<Salesman> salesmenList;

    private Salesman worstSalesman;

    public SalesmanService() {
        salesmenList = new ArrayList<>();
    }

    public Integer salesmen() {
        return salesmenList.size();
    }

    public void addSalesman(Salesman salesman) {
        salesmenList.add(salesman);
    }

    public String worstSalesman() {
        for (Salesman salesman : salesmenList){
            salesman.calcSaleValue();
            if (worstSalesman == null || salesman.getSales().size() < worstSalesman.getSales().size()){
                worstSalesman = salesman;
            }
        }return worstSalesman.getName();
    }

    public void finalize(){
        try {
            super.finalize();
        } catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }
}
