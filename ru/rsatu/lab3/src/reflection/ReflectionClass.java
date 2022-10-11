package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionClass {
    public void printMethods(Class clazz){ //Выгрузить все поля и методы класса с помощью рефлексии
        Method[] methods = clazz.getMethods();
        System.out.println("Методы класса " + clazz.getName() + ": ");
        for (Method m : methods){
            System.out.println(m.toString());
        }
        Field[] fields = clazz.getFields();
        System.out.println("\nПоля класса " + clazz.getName() + ": ");
        for (Field f : fields){
            System.out.println(f.toString());
        }
    }

    public void invokeMethods(Class clazz){ //Вызвать несколько методов класса
        System.out.println("\nВызванные методы класса " + clazz.getName() + ": ");
        try {
            clazz.getMethods()[0].invoke(new Cat());
            clazz.getMethods()[1].invoke(new Cat());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void printParents(Class clazz){ //Вывести на экран всех предков класса
        System.out.println("\nПредки класса " + clazz.getName() + ": ");
        Class superClass = clazz.getSuperclass();
        while (superClass != null){
            System.out.println(superClass);
            superClass = superClass.getSuperclass();
        }
    }
}
