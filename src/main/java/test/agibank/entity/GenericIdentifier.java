package test.agibank.entity;

import test.agibank.service.CustomerService;
import test.agibank.service.SaleService;
import test.agibank.service.SalesmanService;

import java.util.logging.Logger;

public abstract class GenericIdentifier {

    private static final String SALESMAN = "001";
    private static final String CUSTOMER = "002";
    private static final String SALE = "003";

    private static Logger log;

    public static GenericIdentifier identify(String[] info){
        String identifier = info[0];
        switch (identifier){
            case SALESMAN:
                return new Salesman(info);
            case CUSTOMER:
                return new Customer(info);
            case SALE:
                return new Sale(info);
            default:
                log.info("Número inválido");
        }
        return null;
    }

    public abstract void sale(SaleService saleService);
    public abstract void salesmanData(SalesmanService salesmanService);
    public abstract void customer(CustomerService customerService);
}
