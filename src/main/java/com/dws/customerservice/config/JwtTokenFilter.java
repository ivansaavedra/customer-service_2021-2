package com.dws.customerservice.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.JwtException;


public class JwtTokenFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
        throws IOException, ServletException {
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
        
        HttpServletResponse response = (HttpServletResponse) res;
        
        try {
	        if (token != null && jwtTokenProvider.validateToken(token)) {
	            Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
	            SecurityContextHolder.getContext().setAuthentication(auth);
	        }
        filterChain.doFilter(req, res);              	        
        } catch(JwtException e) {
        	response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED, "Token Inválido.");
            return ;
        }
        
    }
    
}