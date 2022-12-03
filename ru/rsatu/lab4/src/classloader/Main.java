package classloader;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args){
        try{
            MyClassLoader cl = new MyClassLoader();
            Class<?> c1 = cl.findClass("classloader.LoadedClass");
            Object o = c1.getDeclaredConstructor().newInstance();
            Method m = c1.getDeclaredMethod("classLoaded", String.class);
            m.invoke(o, "classloader.LoadedClass");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

