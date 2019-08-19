package cn.xmkeshe.utils.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(filterName="EncodingFilter",urlPatterns = "/*")
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        arg0.setCharacterEncoding("UTF-8");
        arg2.doFilter(arg0,arg1);
        arg1.setCharacterEncoding("UTF-8");
    }
}
