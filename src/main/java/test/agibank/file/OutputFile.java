package test.agibank.file;

import test.agibank.entity.Sale;
import test.agibank.entity.Salesman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static java.lang.System.getProperty;

public class OutputFile {
    public static void outputFile(int qtdCustomers, int qtdSalesmen, Sale highestSale, Salesman worstSalesman, String fileName) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(getProperty("user.home") + File.separator + "data" + File.separator + "out" + File.separator + "out_" + fileName);

        output.println("Quantidade de Clientes: " + qtdCustomers);
        output.println("Quantidade de Vendedores: " + qtdSalesmen);
        output.println("Id da venda de maior valor: " + highestSale.getId());
        output.println("Nome do pior vendedor: " + worstSalesman.getName());
        output.close();
    }
}
