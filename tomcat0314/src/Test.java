import java.lang.reflect.Constructor;

/**
 * @author panda
 * @description
 * @date 2020/3/15
 */
public class Test {
    public static void main(String[] args) throws Exception {
        C c = new C();
        c.a();
        c.b();
        c.bb();
    }
}

interface A{
    default public void a(){
        System.out.println("A");
    }
};

interface B{
    default public void bb(){
        System.out.println("bb");
    }
    default public void b(){
        System.out.println("b");
    }
};

class C implements A,B{

}
