package test.agibank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import test.agibank.entity.Customer;
import test.agibank.entity.Item;
import test.agibank.entity.Sale;
import test.agibank.entity.Salesman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;
import static test.agibank.file.OutputFile.outputFile;

@SpringBootApplication
public class AgibankApplication {

    private static final String SALESMAN = "001";
    private static final String CUSTOMER = "002";
    private static final String SALE = "003";
    private static final String SPLIT = "ç";

    public static void processFile(File file, String name) throws FileNotFoundException {
        Scanner fileReaded = new Scanner(file);

        HashMap<String, Salesman> salesmen = new HashMap<>();
        List<Customer> customers = new ArrayList<>();
        List<Sale> sales = new ArrayList<>();

        while (fileReaded.hasNextLine()){
            String line = fileReaded.nextLine();
            String[] info = line.split(SPLIT);
            switch (info[0]){
                case(SALESMAN):
                    Salesman salesman = new Salesman(info[2], Double.parseDouble(info[3]), info[1]);
                    salesmen.put(salesman.getName(), salesman);
                    break;

                case (CUSTOMER):
                    Customer customer = new Customer(info[1], info[2], info[3]);
                    customers.add(customer);
                    break;

                case(SALE):
                    Long idSale = Long.parseLong(info[1]);
                    String salesmanName = info[3];
                    Sale sale = new Sale(idSale, salesmen.get(salesmanName));

                    String[] items = info[2].substring(1, info[2].length() -1).split(",");

                    for (String item : items){
                        String[] infoItem = item.split("-");
                        Item i = new Item(Long.parseLong(infoItem[0]), Integer.parseInt(infoItem[1]), Double.parseDouble(infoItem[2]));
                        sale.addItem(i);
                    }
                    sales.add(sale);
            }
        }

        Salesman worstSalesman = null;
        Sale highestSale = null;

        for (Sale s : sales)
            highestSale = ((highestSale == null || s.getTotalSaleValue() > highestSale.getTotalSaleValue()) ? s : highestSale);
        for (Salesman s : salesmen.values())
            worstSalesman = ((worstSalesman == null || s.getTotalSold() < worstSalesman.getTotalSold()) ? s : worstSalesman);

        assert highestSale != null;
        assert worstSalesman != null;

        outputFile(customers.size(), salesmen.size(), highestSale, worstSalesman, name);
    }

    public static void wait(int minute){
        try {
            TimeUnit.MINUTES.sleep(minute);
        }catch (InterruptedException exception){
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        String homepath = getProperty("user.home");
        int indice = 0;
        while (true) {
            HashSet<File> docs = new HashSet<>(Arrays.asList(Objects.requireNonNull(new File(homepath + File.separator + "data" + File.separator + "in").listFiles())));
            File[] file = docs.toArray(new File[docs.size()]);
            try {
                processFile(file[indice], file[indice ++].getName());
                System.out.println("Um novo arquivo foi adicionado");
            } catch (ArrayIndexOutOfBoundsException | FileNotFoundException e){
                System.out.println("Aguardando por novos arquivos");
                wait(1);
            } finally {
                System.out.println("Um novo arquivo foi adicionado a sua pasta /out");
            }
        }
    }
}
