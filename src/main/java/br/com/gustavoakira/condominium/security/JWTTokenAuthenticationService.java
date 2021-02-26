package br.com.gustavoakira.condominium.security;

import br.com.gustavoakira.condominium.config.ApplicationContextLoad;
import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.repositories.ClientRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Service
public class JWTTokenAuthenticationService {
    @Autowired
    ClientRepository repository;

    private static final Long EXPIRATION_TIME = 172800000L;

    private static final String SECRET = "**--*/4265a3-*-3*/e9s+w9/3e*-";

    private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";

    public void authenticate(HttpServletResponse response, String email) throws IOException {
        String token = createToken(email);
        response.addHeader(HEADER_STRING,token);
        liberationCors(response);
        response.getWriter().write("{\"Authorization\": \""+token+"\"}");
    }

    public String createToken(String email){
        String Jwt = Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        String token = TOKEN_PREFIX + " " + Jwt;
        return token;
    }

    public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response){
        String token = request.getHeader(HEADER_STRING);
        liberationCors(response);
        if(token != null){
            String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody().getSubject();
            if(user != null){
                Client client = ApplicationContextLoad.getApplicationContext().getBean(ClientRepository.class).getClientByEmail(user);
                if(client != null){
                    return new UsernamePasswordAuthenticationToken(client.getEmail(),client.getPassword(), client.getAuthorities());
                }
            }
        }
        return null;
    }

    private void liberationCors(HttpServletResponse response) {
        if(response.getHeader("Access-Control-Allow-Origin") == null){
            response.addHeader("Access-Control-Allow-Origin","*");
        }

        if(response.getHeader("Access-Control-Allow-Headers") == null){
            response.addHeader("Access-Control-Allow-Headers","*");
        }

        if(response.getHeader("Access-Control-Request-Headers") == null){
            response.addHeader("Access-Control-Request-Headers","*");
        }

        if(response.getHeader("Access-Control-Allow-Methods") == null){
            response.addHeader("Access-Control-Allow-Methods","*");
        }
    }
}
