package lk.fcpl.web.studentRegistration.filter;

import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-03-08
 **/
@Component
public class CORSFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        res.setHeader("Access-Control-Allow-Origin","http://localhost:4200");
        res.setHeader("Access-Control-Allow-Methods","GET, PUT, POST, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers","Content-Type, Authorization");
        super.doFilter(req, res, chain);
    }
}
