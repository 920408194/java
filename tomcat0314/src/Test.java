import java.lang.annotation.*;

/**
 * @author panda
 * @description
 * @date 2020/3/15
 */
public class Test {
    @MyAnnotation
    public void test(){

    }

}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    //注解的参数：参数类型 + 参数名（）
    String name() default "";

}

