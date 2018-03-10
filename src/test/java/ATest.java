

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

//反射就是获取类信息的能力

public class ATest {

    @Test
    public void test() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<A> cl1 = A.class;
        Class<?> cl2 = Class.forName("A");
        Class<? extends A> cl3 = new A().getClass();


        Class<Integer> cl4 = int.class;//泛型里面不能写int
        Class<double[]> cl5 = double[].class;//因为这个是数组，是引用类型  获得泛型的集中方式

        A a = cl1.newInstance(); //反射调用对象

        System.out.println(cl1 == cl2);


        System.out.println(cl1.getSuperclass().getName());//cl 就是反射的A . 获得父类的反射，.取到反射所对应的反射的名字
//        for(Class c : cl.getInterfaces()) //获得所有接口的反射
//            System.out.println(c.getName());
//
        Class[] superInterface = cl1.getInterfaces();


        for (Method method : cl1.getDeclaredMethods())
            System.out.println(method);


        //反射出类 取访问修饰符
        int modifiers = cl1.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.toString(modifiers)); //打印访问修饰符
        System.out.println(Modifier.isPublic(16));
        System.out.println(Modifier.isFinal(1));


        //Method[] methods=cl1.getMethods();
        Method[] methods = cl1.getDeclaredMethods();
        for (Method method : methods)
            System.out.println(method);


        //反射获取注释
        Annotation[] annotations = cl1.getDeclaredAnnotations();
        for (Annotation annotation : annotations)
            System.out.println(annotation);
    }
        //反射调取属性
        @Test
        public void test1() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class cl = A.class;
        Field field = cl.getField("a");
        field.setAccessible(true);
        //代码外面修改类的值
        A a = new A();
        field.set(a, 1);
        System.out.println(field.get(a));

        //反射调取域和方法
        Method method = cl.getDeclaredMethod("f", int.class, String.class);
        method.setAccessible(true);
        method.invoke(a, 1, "");


        Constructor<A> constructor= cl.getDeclaredConstructor();
        A newA=constructor.newInstance();
        newA.f(1,"");
        }

        //动态创建数组
        @Test
        public void test3(){
        int[] numbers =(int[])Array.newInstance(int.class,10);
        numbers[9]=1;
        }

        //测试A类，执行静态块和初始化块，
        @Test
        public void test4() throws ClassNotFoundException {
            //Class c1 = A.class;
            Class c2 = Class.forName("A");
            Class c3 = new A().getClass();
        }

//        @Test
//        public void test5(){
//            //类加载就是将.class文件从硬盘（网络）读取到内存中，产生一个该类的反射对象
//            //类加载器得到的结果就是反射。
//            Class c1=A.class;
//            ClassLoader appClassLoader= getClass().getClassLoader();
//            System.out.println(extClassLoader);



        }

