package test.agibank.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private final String name;
    private final String cnpj;
    private final String businessArea;

    public Customer(String name, String cnpj, String businessArea) {
        this.name = name;
        this.cnpj = cnpj;
        this.businessArea = businessArea;
    }
}
