/**
 * Created by wuzhi1234 on 15/7/27.
 */

public class PolyMorphic_gao{

    public static void main(String[] args) {

        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b));
        System.out.println(a1.show(c));
        System.out.println(a1.show(d));
        System.out.println(a2.show(b));
        System.out.println(a2.show(c));
        System.out.println(a2.show(d));
        System.out.println(b.show(b));
        System.out.println(b.show(c));
        System.out.println(b.show(d));
    }
}
class A {
    public String show(D obj){
        return ("A and D");
    }
    public String show(A obj){
        return ("A and A");
    }
}
class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    }
}
class C extends B{}
class D extends B{}

/*①   A and A  //没有对应参数的实现方法，担忧b的父类的作为参数的实现方法
②   A and A  //没有对应参数的实现方法，担忧c的父类的作为参数的实现方法
③   A and D  //刚刚好
④   B and A  //a2虽然是B类的对象，但是已经?
⑤   B and A
⑥   A and D
⑦   B and B  //刚刚好
⑧   B and B  //b对象中没有对应参数类型的方法，所以找到参数类型的父类在b中的实现，找到输出
⑨   A and D  //b对象中没有对应参数类型的方法，所以去父类中找，找到了输出*/