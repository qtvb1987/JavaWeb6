package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebFilter(urlPatterns = "/safe")
public class SafeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String[] products = req.getParameterValues("product");
        System.out.println("过滤前:"+ Arrays.toString(products));
        List<String> list = Stream.of(products).filter(t -> !t.equals("手榴弹")).filter(t -> !t.equals("冲锋枪")).collect(Collectors.toList());
        System.out.println("过滤后"+list);
        req.setAttribute("list",list);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
