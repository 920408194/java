import javax.servlet.*;
import java.io.IOException;

/**
 * @author panda
 * @description
 * @date 2020/4/23
 */
public class MyServlet implements Servlet {
    private ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("init MyServlet");

        //获取ServletContext对象并存值到域对象
        ServletContext servletContext = this.getServletContext();
        String value = "panda!";
        servletContext.setAttribute("MyName",value);
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    public ServletContext getServletContext() {
        return getServletConfig().getServletContext();
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //从xml获得ServletConfig并写到页面上
        ServletConfig servletconfig = getServletConfig();
        String name = servletconfig.getInitParameter("name");
        servletResponse.getWriter().write("This is "+ name +"'s server!\n");

        //获取web站点配置信息
        ServletContext servletContext = this.getServletContext();
        String value = servletContext.getInitParameter("password");
        servletResponse.getWriter().write(value+"\n");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
