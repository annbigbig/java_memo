package com.kashu.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		
		request.setAttribute("error", "帳號或是密碼錯誤");
		response.sendRedirect("/janjan/home");
		//request.getRequestDispatcher("/home").forward(request, response);
	}

}
