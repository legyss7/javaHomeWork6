package org.hom6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Laptop> laptopShop = GetLaptop();
        Laptop search = settingSearchOptions();
        searchLaptop(laptopShop, search);
    }
    private static List<Laptop> GetLaptop() {
        List<Laptop> laptoplist = new ArrayList<>();
        laptoplist.add(new Laptop("HP", 16, 1000, "Windows", "Black"));
        laptoplist.add(new Laptop("Asus", 32, 256, "Linux", "Black"));
        laptoplist.add(new Laptop("Dell", 8, 512, "Linux", "Red"));
        laptoplist.add(new Laptop("Acer", 8, 512, "Linux", "Red"));
        laptoplist.add(new Laptop("HP", 8, 256, "Linux", "White"));
        laptoplist.add(new Laptop("Asus", 8, 1000, "Windows", "White"));
        laptoplist.add(new Laptop("HP", 32, 2000, "Windows", "Blue"));
        laptoplist.add(new Laptop("Dell", 8, 512, "Windows", "Blue"));
        laptoplist.add(new Laptop("Dell", 6, 256, "Windows", "White"));
        return laptoplist;
    }

    private static Laptop settingSearchOptions() {
        Map<Integer, String> name = new HashMap<>();
        name.put(1, "Acer");
        name.put(2, "Asus");
        name.put(3, "Dell");
        name.put(4, "HP");

        Map<Integer, String> color = new HashMap<>();
        color.put(1, "White");
        color.put(2, "Black");
        color.put(3, "Red");
        color.put(4, "Yellow");
        color.put(5, "Orange");
        color.put(6, "Green");
        color.put(7, "Blue");
        color.put(8, "Purple");

        Map<Integer, String> operatingSystem = new HashMap<>();
        operatingSystem.put(1, "Windows");
        operatingSystem.put(2, "Linux");

        Map<String, Integer> parameter = new HashMap<>();

        System.out.println("Введите одну или несколько цифр, соответствующую необходимым критериям поиска ");
        System.out.println("1 - Name");
        System.out.println("2 - RAM");
        System.out.println("3 - Hard Disk Capacity");
        System.out.println("4 - Operating System");
        System.out.println("5 - Color");
        System.out.println("вводите цифры без разделителей (12345 для поиска по всем параметрам): ");
        Scanner sc = new Scanner(System.in);
        String request = sc.next();
        System.out.println("Введите параметры, выбраной(-ых) категории(-й) ");

        if (request.contains("1")) {
            System.out.println("1 - Acer");
            System.out.println("2 - Asus");
            System.out.println("3 - Dell");
            System.out.println("4 - HP");
            System.out.print("Name: ");
            parameter.put("Name", sc.nextInt());
        } else {
            parameter.put("Name", null);
        }

        if (request.contains("2")) {
            System.out.print("минимальное значение RAM: ");
            parameter.put("RAM", sc.nextInt());
        } else {
            parameter.put("RAM", null);
        }

        if (request.contains("3")) {
            System.out.print("минимальное значение Hard Disk Capacity: ");
            parameter.put("Hard Disk Capacity", sc.nextInt());
        } else {
            parameter.put("Hard Disk Capacity", null);
        }

        if (request.contains("4")) {
            System.out.println("1 - Windows");
            System.out.println("2 - Linux");
            System.out.print("Operating System: ");
            parameter.put("Operating System", sc.nextInt());
        } else {
            parameter.put("Operating System", null);
        }

        if (request.contains("5")) {
            System.out.println("1 - White");
            System.out.println("2 - Black");
            System.out.println("3 - Red");
            System.out.println("4 - Yellow");
            System.out.println("5 - Orange");
            System.out.println("6 - Green");
            System.out.println("7 - Blue");
            System.out.println("8 - Purple");
            System.out.print("Color: ");
            parameter.put("Color", sc.nextInt());
        } else {
            parameter.put("Color", null);
        }

        Laptop search = new Laptop(name.get(parameter.get("Name")), parameter.get("RAM"), parameter.get("Hard Disk Capacity"),
                operatingSystem.get(parameter.get("Operating System")), color.get(parameter.get("Color")));
        return search;
    }
    private static void searchLaptop(List<Laptop> list, Laptop search) {
        Boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            if (((search.name == null) || list.get(i).name.equals(search.name))
                    && ((search.ram == null) || list.get(i).ram >= search.ram)
                    && ((search.hardDiskCapacity == null) || list.get(i).hardDiskCapacity >= search.hardDiskCapacity)
                    && ((search.operatingSystem == null) || list.get(i).operatingSystem.equals(search.operatingSystem))
                    && ((search.color == null) || list.get(i).color.equals(search.color))
            ) {
                System.out.println(list.get(i));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("По вашему запросу ничего не найденно.");
        }
    }
}