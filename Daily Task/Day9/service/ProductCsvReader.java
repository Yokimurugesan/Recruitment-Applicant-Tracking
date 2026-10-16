package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductCsvReader {
    public static List<Product> readProducts(Path path) throws IOException {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 3) {
                    throw new IOException("Invalid CSV row: " + line);
                }

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());

                products.add(new Product(id, name, price));
            }
        }

        return products;
    }
}