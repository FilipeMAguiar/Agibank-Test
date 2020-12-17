package test.agibank.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Salesman {

    private String name;
    private Double salary;
    private Double sale;
    private String cpf;

    public Salesman(String name, Double salary, String cpf) {
        this.name = name;
        this.salary = salary;
        this.cpf = cpf;
        this.sale = (double) 0;
    }
    public void addSale(double price){
        sale += price;
    }
    public double getTotalSold(){
        return sale;
    }
}
