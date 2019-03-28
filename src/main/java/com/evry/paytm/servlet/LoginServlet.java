package com.evry.paytm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evry.paytm.dao.UserDAO;
import com.evry.paytm.dto.UserDTO;
@WebServlet(value="/login", loadOnStartup=1)
public class LoginServlet extends HttpServlet{
	
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		UserDAO dao= new UserDAO();
		UserDTO dto = new UserDTO();
		dto.setuUserName(userName);
		dto.setuPassword(password);
		
		long res = dao.login(dto);
		
		if(res==1) {
			System.out.println("login success");
			req.getRequestDispatcher("views/loginsuccess.jsp").forward(req, resp);
		}
		else {
			System.out.println("Login failed..");
			req.getRequestDispatcher("views/loginfailed.jsp").forward(req, resp);
			req.getRequestDispatcher("views/index.jsp").include(req, resp);
		}
		
	}

}
