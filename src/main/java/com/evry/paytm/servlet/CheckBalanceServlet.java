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
@WebServlet("/checkbalance")
public class CheckBalanceServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
	  System.out.println("Hello you entered into WalletCreation servlet post method");
	  
	  PrintWriter writer = resp.getWriter();
		int id=Integer.parseInt(req.getParameter("uid"));
	    
		UserDTO dto = new UserDTO();
		dto.setUid(id);
		UserDAO dao = new UserDAO();
		double balance = dao.getBalance(dto);

		
		if(balance>=0)
		{
			
			req.getRequestDispatcher("/views/loginsuccess.jsp").include(req, resp);
			
			writer.println("your current balance is:"+balance);
		}
		
		else {
			
			req.getRequestDispatcher("/checkbalance.jsp").forward(req, resp);
			writer.println("Something went wrong . please try again");
		}
		
	       
	       
	}

}
