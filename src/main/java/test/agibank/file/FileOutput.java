package test.agibank.file;

import test.agibank.service.CustomerService;
import test.agibank.service.SaleService;
import test.agibank.service.SalesmanService;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

public class FileOutput {

    private static Logger logger;
    public static void generateFile(Path file,
                                    CustomerService customerService,
                                    SaleService saleService,
                                    SalesmanService salesmanService,
                                    String outputFilePath){
        FileWriter fw = null;
        try {
            String outputFileName = String.format(outputFilePath, file);
            fw = new FileWriter(outputFileName);
            fw.write(lineConstructor("Total Customers: " + customerService.customers()));
            fw.write(lineConstructor("Total Salesmen: " + salesmanService.salesmen()));
            fw.write(lineConstructor("ID of the highest sale: " + saleService.getIdHighestSale()));
            fw.write(lineConstructor("Name of the worst salesman: " + salesmanService.worstSalesman()));

        } catch (IOException e) {
            logger.info("Error while building output file - " + file);
            e.printStackTrace();
        } finally {
            if (fw != null) try {
                fw.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static String lineConstructor(String msg){
        return msg + System.lineSeparator();
    }
}
