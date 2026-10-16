package app;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Box;
import model.CustomResource;
import model.Pair;
import model.Product;
import service.GenericUtils;
import service.InMemoryRepository;
import service.ProductCsvReader;
import service.WildcardUtils;

public class GenericToolkitApp {
    public static void main(String[] args) throws IOException {

        System.out.println("=== Pair Demo ===");
        Pair<Integer, String> pair = new Pair<>(101, "Keyboard");
        pair.display();

        System.out.println("\n=== Bounded Type Demo ===");
        Box<Integer> box = new Box<>(10);
        box.display();

        System.out.println("\n=== Generic max() Demo ===");
        System.out.println("Maximum integer: " + GenericUtils.max(10, 20));
        System.out.println("Maximum string: " + GenericUtils.max("Apple", "Zoo"));

        System.out.println("\n=== Wildcard Demo ===");
        List<Integer> numbers = List.of(10, 20, 30);
        System.out.println("Sum: " + WildcardUtils.sum(numbers));

        List<Number> numberList = new ArrayList<>();
        WildcardUtils.addNumbers(numberList);
        System.out.println("Added numbers: " + numberList);

        System.out.println("\n=== CSV and Repository Demo ===");
        Path csvPath = Path.of("data", "products.csv");
        List<Product> products = ProductCsvReader.readProducts(csvPath);

        InMemoryRepository<Product, Integer> repository =
            new InMemoryRepository<>(Product::getId);

        for (Product product : products) {
            repository.save(product);
        }

        repository.findAll().forEach(System.out::println);

        System.out.println("\nFind product 103:");
        repository.findById(103).ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Product not found")
        );

        System.out.println("\nDelete product 102: " + repository.deleteById(102));
        System.out.println("Remaining products: " + repository.findAll().size());

        System.out.println("\n=== AutoCloseable Demo ===");
        try (
            CustomResource first = new CustomResource("First");
            CustomResource second = new CustomResource("Second")
        ) {
            first.use();
            second.use();
        }
    }
}