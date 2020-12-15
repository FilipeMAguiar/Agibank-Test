package test.agibank.entity;

import lombok.Getter;
import lombok.Setter;
import test.agibank.service.CustomerService;
import test.agibank.service.SaleService;
import test.agibank.service.SalesmanService;

@Getter
@Setter
public class Customer extends GenericIdentifier {

    private final String cnpj;
    private final String name;
    private final String businessArea;

    public Customer(String[] info) {
        this.cnpj = info[1];
        this.name = info[2];
        this.businessArea = info[3];
    }

    @Override
    public void sale(SaleService saleService) {
    }

    @Override
    public void salesmanData(SalesmanService salesmanService) {
    }

    @Override
    public void customer(CustomerService customerService) {
        customerService.addCustomer(this);
    }
}
