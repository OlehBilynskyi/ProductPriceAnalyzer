package app;
//Імпортуємо класи

import java.util.Arrays; //для створення списку з елементів
import java.util.List; //для роботи зі списками
import java.util.Map; //для зберігання результату у вигляді категорія -> середня ціна
import java.util.stream.Collectors; //для використання Stream API

public class Main {
    public static void main(String[] args) {
        //Створюємо список продуктів
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("Smartphone", "Electronics", 900.0)
        );
//Використовуємо Stream API: групуємо продукти за категорією, обчислюємо середню ціну для кожної категорії
        // Product::getCategory - ключ: назва категорії
        //Collectors.averagingDouble(Product::getPrice) - значення: середнє значення ціни
        Map<String, Double> avgPrices = products.stream().collect(Collectors.groupingBy(Product::getCategory,
                Collectors.averagingDouble(Product::getPrice)
        ));

//Виводимо середні ціни по кожній категорії
        System.out.println("Середні ціни за категоріями:");
        //Використовуємо цикл for-each, щоб пройтись по всіх парах ключ-значення в мапі avgPrices
        //avgPrices - об'єкт типу Map<String, Double>, тобто в ньому зберігаються назва категорії, середня ціна
        //entrySet() - метод, який повертає набір (Set) усіх пар ключ=значення у цій мапі
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue()); //отримуємо назву категорії та середню ціну
        }
        //Шукаємо категорію з найвищою середньою ціною

        String maxCategory = null; //тут збережемо назву категорії
        double maxAvg = Double.MIN_VALUE; //початкове значення для пошуку максимуму

//Перебираємо всі категорії та їхні середні значення
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            //якщо нове значення більше за поточний максимум - оновлюємо максимум, оновлюємо назву категорії
            if (entry.getValue() > maxAvg) {
                maxAvg = entry.getValue();
                maxCategory = entry.getKey();
            }
        }

        System.out.println("Категорія з найвищою середньою ціною: " + maxCategory);
    }
}