import javax.servlet.*;
import java.io.IOException;

/**
 * @author panda
 * @description
 * @date 2020/4/23
 */
@javax.servlet.annotation.WebServlet(value = "/MyServlet",loadOnStartup = 1)
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init MyServlet");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("This is panda's server!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
