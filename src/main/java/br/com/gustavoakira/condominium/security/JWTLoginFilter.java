package br.com.gustavoakira.condominium.security;

import br.com.gustavoakira.condominium.models.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    public JWTLoginFilter(String url, AuthenticationManager manager){
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(manager);
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        Client client = new ObjectMapper().readValue(httpServletRequest.getInputStream(),Client.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(client.getEmail(),client.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        new JWTTokenAuthenticationService().authenticate(response,authResult.getName());
    }
}
