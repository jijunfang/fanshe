import java.io.Serializable;

public final class A implements Serializable{
    //静态模块
    static{
        System.out.println("static init...");
    }

    //初始化块
    {
        System.out.println("init...");
    }

    private int a;
    private int b;
    private int c;

    public A() {
    }

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void f(){

    }
    public void f(int a,String b){

    }

}
