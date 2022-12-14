package classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        byte[] bt = loadClassData(name);
        return defineClass(name, bt, 0, bt.length);
    }
    private byte[] loadClassData(String className) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/")+".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        int len;
        try {
            while((len = is.read())!=-1){
                byteSt.write(len);
            }
        } catch (IOException e) {System.out.println(e); }
        return byteSt.toByteArray();
    }

}