package reflection;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        ReflectionClass reflectionClass = new ReflectionClass();
        reflectionClass.printMethods(cat.getClass());
        reflectionClass.invokeMethods(cat.getClass());
        reflectionClass.printParents(cat.getClass());
    }
}
