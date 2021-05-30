package practice.docs.spring.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get mapping");
        ApplicationContext attribute =
                (ApplicationContext) req.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        TmpService tmpService = attribute.getBean("tmpService", TmpService.class);
        if (tmpService != null) {
            tmpService.print();
            System.out.println("application context and bean loaded!");
        }
        resp.setStatus(200);
        super.doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }
}
