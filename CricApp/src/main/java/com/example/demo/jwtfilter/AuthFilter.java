package com.example.demo.jwtfilter;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
public class AuthFilter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println(req.getMethod());
		if(req.getMethod().equals("OPTIONS")){
			resp.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			String authHeader = req.getHeader("Authorization");
			System.out.println(authHeader);
			if (authHeader == null || !authHeader.startsWith("Bearer")) {
				throw new ServletException("Missing or Invalid Authorization "
						+ " Header");
			}
			try {
				String token = authHeader.substring(7);	
				Claims claim = Jwts.parser().
						setSigningKey("usersecretkey").
						parseClaimsJws(token).getBody();
				req.setAttribute("claims", claim);
			} catch (Exception e) {
				resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token. Not Authorized");
			}
		}
		chain.doFilter(req, resp);
	}
}