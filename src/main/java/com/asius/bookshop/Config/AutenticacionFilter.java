package com.asius.bookshop.Config;
import com.asius.bookshop.Services.implement.UserDetailsServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AutenticacionFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServicesImpl userDetailsImpl;

    @Autowired
    private JwtUtilies jwtUtilies;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerToken = request.getHeader("Authorization");
        String username = null;
        String tokenjwt = null;

        if (headerToken != null && headerToken.startsWith("Bearer ")){
            tokenjwt = headerToken.substring(7);
            try {
                username  = this.jwtUtilies.extractUsername(tokenjwt);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Token Invalid, does not start with Bearer");
        }

        if (username != null){
            UserDetails userD = userDetailsImpl.loadUserByUsername(username);
            Boolean validacion = this.jwtUtilies.validateToken(tokenjwt,userD);
            if(validacion){
                UsernamePasswordAuthenticationToken upatoken = new UsernamePasswordAuthenticationToken(userD,null,userD.getAuthorities());
                upatoken.setDetails(userD);
                SecurityContextHolder.getContext().setAuthentication(upatoken);
            }
        }else{
            System.out.println("The user is empty, not associated to the token.");
        }

        filterChain.doFilter(request,response);
    }
}
