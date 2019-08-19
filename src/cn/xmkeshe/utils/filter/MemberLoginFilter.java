package cn.xmkeshe.utils.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//@WebFilter(filterName = "MemberLoginFilter",urlPatterns = "/pages/*")
public class MemberLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession ses = request.getSession();
        System.out.println(ses.getAttribute("member")+"***");
        if(ses.getAttribute("member") != null){
            filterChain.doFilter(request,servletResponse);
        }else {
            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
