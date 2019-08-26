package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter",urlPatterns = "/*",
            initParams = {@WebInitParam(name = "encoding",value = "Utf-8")})
public class CharacterEncodingFilter implements Filter {
    private String encoding = null;
    public void destroy() {
        this.encoding = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       if (encoding==null){
           encoding = "utf-8";
       }
       req.setCharacterEncoding(encoding);
       chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter("encoding");
    }

}
