package com.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    public void destroy() {
        System.out.println("destroy 执行了");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("MyFilter执行了");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init 执行了");
    }

}
