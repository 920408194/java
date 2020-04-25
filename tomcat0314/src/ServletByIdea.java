import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(
        name = "ServletByIdea",
        value = "/ServletByIdea",
        loadOnStartup = 1,
        initParams = {
            @WebInitParam(name="name",value = "panda")
        }
)
public class ServletByIdea extends HttpServlet {
    public void init() throws ServletException {
        super.init();
        System.out.println("started ServletByIdea!");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从注解中获得ServletConfig并写到页面上
        ServletConfig servletConfig = this.getServletConfig();
        String name = servletConfig.getInitParameter("name");
        response.getWriter().write("This is "+ name +"'s servlet create by Idea!\n");

        //获取其他Servlet存储的信息，实现多Servlet通信
        ServletContext servletContext = this.getServletContext();
        String value = (String) servletContext.getAttribute("MyName");
        response.getWriter().write(value+"\n");

        //获取web站点配置信息
        String url = servletContext.getInitParameter("url");
        response.getWriter().write(url+"\n");

        //从src包目录读取文件/图片
        String path1 = "/WEB-INF/classes/img/xxx.jpg";
        InputStream inputStream1 = servletContext.getResourceAsStream(path1);
        response.getWriter().write(inputStream1+"\n");
        //从web目录读取文件/图片
        InputStream inputStream2 = servletContext.getResourceAsStream("xxx.jpg");
        response.getWriter().write(inputStream2+"\n");
        //通过类装载器读取资源文件。
        InputStream inputStream3 = servletContext.getResourceAsStream("xxx.jpg");
        response.getWriter().write(inputStream3+"\n");
    }
}
