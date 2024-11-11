import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 40, 50));

        System.out.println("Element at index 0:" + numbers.get(0));
        System.out.println("Element at index 2:" + numbers.get(2));
        System.out.println("Element at index 4:" + numbers.get(4));

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of ArrayList elements:" + sum);

        numbers.set(2, 35);
        System.out.println("Updated element at index 2:" + numbers.get(2));

        System.out.println("Elements in the ArrayList:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
