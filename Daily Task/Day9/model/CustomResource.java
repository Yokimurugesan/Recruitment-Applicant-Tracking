package model;

public class CustomResource implements AutoCloseable {
    private final String name;

    public CustomResource(String name) {
        this.name = name;
        System.out.println(name + " opened");
    }

    public void use() {
        System.out.println(name + " is being used");
    }

    @Override
    public void close() {
        System.out.println(name + " closed");
    }
}