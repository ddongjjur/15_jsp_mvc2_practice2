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

@WebServlet("/bUpdate")
public class BoardUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardBasicDTO boardBasicDTO = BoardBasicDAO.getInstance().getBoardDetail(Integer.parseInt(request.getParameter("num")), false);
		request.setAttribute("boardBasicDTO", boardBasicDTO);
		
		RequestDispatcher dis = request.getRequestDispatcher("step1_boardBasicEx/bUpdate.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		BoardBasicDTO boardBasicDTO = new BoardBasicDTO();
		
		boardBasicDTO.setNum(Integer.parseInt(request.getParameter("num")));
		boardBasicDTO.setSubject(request.getParameter("subject"));
		boardBasicDTO.setPassword(request.getParameter("password"));
		boardBasicDTO.setContent(request.getParameter("content"));
		
		String jsScript = "";
		if (BoardBasicDAO.getInstance().updateBoard(boardBasicDTO)) {
			
			jsScript = "<script>";
			jsScript += "alert('수정되었습니다!');";
			jsScript += "location.href='bList';";
			jsScript += "</script>";
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.print(jsScript);
			
		}
		
		else {
			
			jsScript = "<script>";
			jsScript += "alert('비밀번호을 확인하세요!');";
			jsScript += "history.go(-1);";
			jsScript += "</script>";
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.print(jsScript);
			
		}
		
	}

}
