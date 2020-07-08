package xilalu.jvm;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader {

        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
//            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        MyClassLoader myClassLoader =
                new MyClassLoader("E:/study/projectSpace/daily-demo/target/classes/xilalu/test/");
//        Class<?> aClass = myClassLoader.loadClass("daily-demo.src.main.java.xilalu.jvm.jvm");
        Class<?> aClass = myClassLoader.loadClass("jvm");
        Object instance = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("sout", null);
        method.invoke(instance, null);
        System.out.println(aClass.getClassLoader().getClass().getName());
    }
}
