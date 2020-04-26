/**
 * @author panda
 * @description
 * @date 2020/3/15
 */
public class Test {
    public static void main(String[] args) throws Exception {

    }

    public @interface Report {
        int type() default 0;
        String level() default "info";
        String value() default "";
    }
}
