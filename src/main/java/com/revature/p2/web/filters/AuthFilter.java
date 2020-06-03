package com.revature.p2.web.filters;

import com.revature.p2.models.UserRole;
import com.revature.p2.web.dtos.Principal;
import com.revature.p2.web.security.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter("/*")
public class AuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {

        parseToken(req);
        chain.doFilter(req, resp);

    }

    private void parseToken(HttpServletRequest req) {

        try {

            String header = req.getHeader(JwtConfig.HEADER);

            if (header == null || !header.startsWith(JwtConfig.PREFIX)) {
                System.out.println("Unauthenticated request");
                return;
            }

            String token = header.replaceAll(JwtConfig.PREFIX, "");

            Claims claims = Jwts.parser()
                    .setSigningKey(JwtConfig.SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

            int id = Integer.parseInt(claims.getId());
            String username = claims.getSubject();
            UserRole role = UserRole.getByName(claims.get("role", String.class));
            Principal principal = new Principal(id, username, role);
            req.setAttribute("principal", principal);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}