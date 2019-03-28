package com.evry.paytm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evry.paytm.dao.UserDAO;
import com.evry.paytm.dto.UserDTO;
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobilenumber"));
		
		UserDTO dto = new UserDTO();
		dto.setUid(dto.getUid());
		dto.setuUserName(uname);
		dto.setuPassword(pwd);
		dto.setEmailId(email);
		dto.setMobileNumber(mobile);
		
	
		UserDAO dao= new UserDAO();
		
		boolean addUser = dao.addUser(dto);
		if(addUser==true) {
			req.getRequestDispatcher("views/index.jsp").forward(req, resp);
			req.getRequestDispatcher("views/success.jsp").include(req, resp);
		}
		else {
			req.getRequestDispatcher("views/failure.jsp").forward(req, resp);
			req.getRequestDispatcher("views/index.jsp").include(req, resp);
		}
	}

}
