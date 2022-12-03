package classloader;

public class LoadedClass{
    public static void classLoaded(String className){
        System.out.println("Класс " + className + " загружен!");
    }
}
