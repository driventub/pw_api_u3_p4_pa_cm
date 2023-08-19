package uce.edu.unidad3.pw_u3_p4_pa_cm.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter{

    @Autowired
    private JwtUtils jwtUtils;

    private static final Logger LOG = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
        try{
            String jwt=parseJwt(request);
        if(jwt!=null && this.jwtUtils.validateJwtToken(jwt)){
            //como e valido el token se debe autenticar
            String nombre=this.jwtUtils.getUsernameFromJwToken(jwt);

            //le debemos autenticar (generacion de autenticacion)
            UsernamePasswordAuthenticationToken authentication=
            new UsernamePasswordAuthenticationToken( nombre, null, new ArrayList<>());

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            //seteamos la autenticacion en la sesion
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        }catch (Exception e){
            LOG.error("No se pudo realizar la autenticacion con el token enviado: {}", e.getMessage());
        }
        filterChain.doFilter(request, response);//procesar lo que se ha trabajado
    
    }

    private String parseJwt(HttpServletRequest request){
        String valorCompleto = request.getHeader("Authorization");//obtener cabeceras//valor completo con el "bearer"
        if(StringUtils.hasText(valorCompleto)&& valorCompleto.startsWith("Bearer ")){
            return valorCompleto.substring(7,valorCompleto.length());
        }
        return null;
    }

}
