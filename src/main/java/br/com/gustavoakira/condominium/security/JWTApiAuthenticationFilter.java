package br.com.gustavoakira.condominium.security;

import org.springframework.security.core.Authentication;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTApiAuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = new JWTTokenAuthenticationService().getAuthentication((HttpServletRequest) servletRequest,(HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
