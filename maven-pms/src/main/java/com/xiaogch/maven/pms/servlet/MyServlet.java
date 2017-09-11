package com.xiaogch.maven.pms.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
@WebServlet(name = "myServlet", urlPatterns = "/myServlet.do")
public class MyServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(MyServlet.class);

    /**
     * A convenience method which can be overridden so that there's no need
     * to call <code>super.init(config)</code>.
     * <p>
     * <p>Instead of overriding {@link #init(ServletConfig)}, simply override
     * this method and it will be called by
     * <code>GenericServlet.init(ServletConfig config)</code>.
     * The <code>ServletConfig</code> object can still be retrieved via {@link
     * #getServletConfig}.
     *
     * @throws ServletException if an exception occurs that
     *                          interrupts the servlet's
     *                          normal operation
     */
    @Override
    public void init() throws ServletException {
        logger.info("MyServlet is initing ....");
        super.init();
    }

    /**
     * Called by the servlet container to indicate to a servlet that the
     * servlet is being placed into service.  See {@link Servlet#init}.
     * <p>
     * <p>This implementation stores the {@link ServletConfig}
     * object it receives from the servlet container for later use.
     * When overriding this form of the method, call
     * <code>super.init(config)</code>.
     *
     * @param config the <code>ServletConfig</code> object
     *               that contains configutation
     *               information for this servlet
     * @throws ServletException if an exception occurs that
     *                          interrupts the servlet's normal
     *                          operation
     * @see UnavailableException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("MyServlet is initing ....");
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("myservlet do post ..");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("myservlet do get ..");
    }
}
