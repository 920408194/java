import java.util.logging.Logger;

/**
 * @author panda
 * @description
 * @date 2020/3/15
 */
public class Test {
    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.info("1");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
    }
}