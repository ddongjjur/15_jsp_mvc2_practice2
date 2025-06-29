package boardBasic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardBasic.DAO.BoardBasicDAO;
import boardBasic.DTO.BoardBasicDTO;

@WebServlet("/bList")
public class BoardList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<BoardBasicDTO> boardBasicDTO = BoardBasicDAO.getInstance().getBoardList();
		
		request.setAttribute("boardBasicDTO", boardBasicDTO);
		
		RequestDispatcher dis = request.getRequestDispatcher("step1_boardBasicEx/bList.jsp");
		dis.forward(request, response);
		
	}

}
