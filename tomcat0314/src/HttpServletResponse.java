import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(
        name = "HttpServletResponse",
        value = "/http"
)
public class HttpServletResponse extends HttpServlet {
    protected void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        //设置头信息，告诉浏览器我回送的数据编码是utf-8的
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        //调用getOutputStream()方法向浏览器输出数据
        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.println("bbb\n");
        servletOutputStream.write("嘹亮歌喉".getBytes("UTF-8"));
    }
}
