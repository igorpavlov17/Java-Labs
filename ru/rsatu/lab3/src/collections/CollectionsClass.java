package collections;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CollectionsClass {
    List<Integer> list = new ArrayList<>();
    Map<Integer, String> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public void setList(){
        for (int i = 0; i < 100; i++) {
            list.add(ThreadLocalRandom.current().nextInt(100));
        }
        System.out.print("List: ");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println("\nListSize: " + list.size());
        Collections.sort(list);
        System.out.print("Sorted list: ");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    public void setMap(){
        System.out.println("Map:");
        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");
        map.put(4, "Четыре");
        map.put(5, "Пять");
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.print("Ключ:" + entry.getKey() + ", ");
            System.out.println("Значение: " + map.get(entry.getKey()) + ";");
        }
    }

    public void setSet(){
        for (int i = 0; i < 100; i++) {
            set.add(ThreadLocalRandom.current().nextInt(100));
        }
        System.out.print("Set: ");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println("\nSet size: " + set.size());
    }
}
