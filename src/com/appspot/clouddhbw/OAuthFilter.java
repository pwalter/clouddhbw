package com.appspot.clouddhbw;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.oauth.*;
import com.google.appengine.api.users.User;

public class OAuthFilter implements Filter{
/*
	@Override
	public ContainerRequest filter(ContainerRequest containerRequest) {
		User user = null;
        try {
            OAuthService oauth = OAuthServiceFactory.getOAuthService();
            user = oauth.getCurrentUser();

        } catch (OAuthRequestException e) {
            // The consumer made an invalid OAuth request, used an access token that was
            // revoked, or did not provide OAuth information.
            // ...
        	boolean t = true;
        }
        
        return containerRequest;
	}*/

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);
		
		User user = null;
        try {
            OAuthService oauth = OAuthServiceFactory.getOAuthService();
            user = oauth.getCurrentUser();
            
            session.setAttribute("user", user);
            
            chain.doFilter(req, resp);

        } catch (OAuthRequestException e) {
            // The consumer made an invalid OAuth request, used an access token that was
            // revoked, or did not provide OAuth information.
            // ...
        	boolean t = true;
        	t = false;
        	response.sendRedirect("/auth.html");
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
