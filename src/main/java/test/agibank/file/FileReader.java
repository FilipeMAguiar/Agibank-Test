package test.agibank.file;

import test.agibank.entity.GenericIdentifier;
import test.agibank.service.CustomerService;
import test.agibank.service.SaleService;
import test.agibank.service.SalesmanService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    public static void readFile(Path file, Properties properties) {
        try {
            CustomerService customerService = new CustomerService();
            SaleService saleService = new SaleService();
            SalesmanService salesmanService = new SalesmanService();
            Stream<String> stream = Files.lines(file);

            infoInterpreter(stream, customerService, saleService, salesmanService);

            FileOutput.generateFile(file, customerService, saleService, salesmanService, properties.getProperty("OUTPUT_FILE_PATH"));
            finalize(customerService, saleService, salesmanService);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void finalize(CustomerService customerService, SaleService saleService, SalesmanService salesmanService) {
        customerService.finalize();
        saleService.finalize();
        salesmanService.finalize();
    }
    
    public static void infoInterpreter(Stream<String> stream, CustomerService customerService, SaleService saleService, SalesmanService salesmanService){
        stream.map(info -> info.split("ç"))
                .collect(Collectors.toList())
                .forEach(info -> GenericIdentifier.identify(info).sale(saleService));
    }
}
