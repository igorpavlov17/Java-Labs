package generics;

public class Printer<T> {
    public <T> void print(T[] items){
        for (T item: items){
            System.out.println(item);
        }
    }
}
