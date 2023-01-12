package boardBasic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardBasic.DAO.BoardBasicDAO;
import boardBasic.DTO.BoardBasicDTO;

@WebServlet("/bWrite")
public class BoardWrite extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dis = request.getRequestDispatcher("step1_boardBasicEx/bWrite.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		BoardBasicDTO boardBasicDTO = new BoardBasicDTO();
		boardBasicDTO.setWriter(request.getParameter("writer"));
		boardBasicDTO.setSubject(request.getParameter("subject"));
		boardBasicDTO.setEmail(request.getParameter("email"));
		boardBasicDTO.setPassword(request.getParameter("password"));
		boardBasicDTO.setContent(request.getParameter("content"));
		
		BoardBasicDAO.getInstance().InsertBoard(boardBasicDTO);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = response.getWriter();

		String jsScript = "<script>";
		   	jsScript += "alert('등록되었습니다!');";
		   	jsScript += "location.href='bList';";
		   	jsScript += "</script>";
				
		pw.print(jsScript);
		
	}

}
