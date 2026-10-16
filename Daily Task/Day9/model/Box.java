package model;

public class Box<T extends Number> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public double getSquare() {
        return value.doubleValue() * value.doubleValue();
    }

    public void display() {
        System.out.println("Value: " + value);
        System.out.println("Square: " + getSquare());
    }
}