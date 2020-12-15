package test.agibank.entity;

import lombok.Getter;
import lombok.Setter;
import test.agibank.service.CustomerService;
import test.agibank.service.SaleService;
import test.agibank.service.SalesmanService;

import java.util.List;

@Getter
@Setter
public class Salesman extends GenericIdentifier {

    private final String cpf;
    private final String name;
    private final Double salary;
    private List<Sale> sales;
    private Double valueSold;

    public Salesman(String[] info) {
        this.cpf = info[1];
        this.name = info[2];
        this.salary = Double.parseDouble(info[3]);
    }

    public void calcSaleValue() {
        Double sum = (double) 0;
        for (Sale sale : sales){
            sum = sale.getTotalValue();
        }
        this.valueSold = sum;
    }

    @Override
    public void sale(SaleService saleService) {

    }

    @Override
    public void salesmanData(SalesmanService salesmanService) {
        salesmanService.addSalesman(this);
    }

    @Override
    public void customer(CustomerService customerService) {

    }
}
