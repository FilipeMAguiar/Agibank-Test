package test.agibank.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import test.agibank.entity.Customer;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class CustomerService {

    private final List<Customer> customerList;

    public CustomerService() {
        customerList = new ArrayList<>();
    }

    public Integer customers() {
        return customerList.size();
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public void finalize(){
        try {
            super.finalize();
        } catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }
}
