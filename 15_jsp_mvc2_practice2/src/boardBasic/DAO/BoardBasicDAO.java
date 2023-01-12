package boardBasic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import boardBasic.DTO.BoardBasicDTO;

public class BoardBasicDAO {

	private BoardBasicDAO() {}
	private static BoardBasicDAO instance = new BoardBasicDAO();
	public static BoardBasicDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void getConnection() {
		
		try {
			
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");       
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool"); 		 
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void getClose() {
		
		if (rs != null)    {try {rs.close();}   catch (SQLException e) {}}
    	if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        if (conn != null)  {try {conn.close();}  catch (SQLException e) {}}
        
	}
	
	public ArrayList<BoardBasicDTO> getBoardList() {
		
		ArrayList<BoardBasicDTO> boardBasicList = new ArrayList<BoardBasicDTO>();
		
		try {
			
			getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM BOARD");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				BoardBasicDTO boardBasicDTO = new BoardBasicDTO();
				
				boardBasicDTO.setNum(rs.getInt("NUM"));
				boardBasicDTO.setWriter(rs.getString("WRITER"));
				boardBasicDTO.setEmail(rs.getString("EMAIL"));
				boardBasicDTO.setSubject(rs.getString("SUBJECT"));
				boardBasicDTO.setPassword(rs.getString("PASSWORD"));
				boardBasicDTO.setEnrollDt(rs.getDate("ENROLL_DT"));
				boardBasicDTO.setReadCnt(rs.getInt("READ_CNT"));
				boardBasicDTO.setContent(rs.getString("CONTENT"));
				
				boardBasicList.add(boardBasicDTO);
				
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		return boardBasicList;
		
	}
	
	public void InsertBoard(BoardBasicDTO boardBasicDTO) {
		
		try {
			
			getConnection();
			
			pstmt = conn.prepareStatement("INSERT INTO BOARD (WRITER, SUBJECT, EMAIL, PASSWORD, ENROLL_DT, READ_CNT, CONTENT ) VALUES (?, ?, ?, ?, NOW(), 0, ? )");
			pstmt.setString(1, boardBasicDTO.getWriter());
			pstmt.setString(2, boardBasicDTO.getSubject());
			pstmt.setString(3, boardBasicDTO.getEmail());
			pstmt.setString(4, boardBasicDTO.getPassword());
			pstmt.setString(5, boardBasicDTO.getContent());
			pstmt.executeUpdate();
			
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
	}
	
	public BoardBasicDTO getBoardDetail(int num, boolean isIncreaseReadCnt ) {
		
		 BoardBasicDTO boardBasicDTO = new BoardBasicDTO();
		 
		 try {
				
				getConnection();
				
				pstmt = conn.prepareStatement("SELECT * FROM BOARD WHERE NUM=?");
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					
					boardBasicDTO.setNum(rs.getInt("NUM"));
					boardBasicDTO.setWriter(rs.getString("WRITER"));
					boardBasicDTO.setEmail(rs.getString("EMAIL"));
					boardBasicDTO.setSubject(rs.getString("SUBJECT"));
					boardBasicDTO.setEnrollDt(rs.getDate("ENROLL_DT"));
					boardBasicDTO.setReadCnt(rs.getInt("READ_CNT"));
					boardBasicDTO.setContent(rs.getString("CONTENT"));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				getClose();
			}
		
		return boardBasicDTO;
		
	}
	
	public boolean checkValidateMember(BoardBasicDTO boardBasicDTO) {
		
		boolean isValidateMember = false;
				
				try {
					
					getConnection();
					
					pstmt = conn.prepareStatement("SELECT * FROM BOARD WHERE NUM=? AND PASSWORD=?");
					pstmt.setInt(1, boardBasicDTO.getNum());
					pstmt.setString(2, boardBasicDTO.getPassword());
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						isValidateMember = true;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					getClose();
				}
				
				return isValidateMember;
		
	}
	
	public boolean updateBoard(BoardBasicDTO boardBasicDTO) {
		
		boolean isUpdate = false;
		
		try {
			
			if (checkValidateMember(boardBasicDTO)) {
				
				getConnection();
				
				pstmt = conn.prepareStatement("UPDATE BOARD SET SUBJECT=?, CONTENT=? ENROLL_DT=NOW() WHERE NUM=?");
				pstmt.setString(1, boardBasicDTO.getSubject());
				pstmt.setString(2, boardBasicDTO.getContent());
				pstmt.setInt(3, boardBasicDTO.getNum());
				pstmt.executeUpdate();
				
				isUpdate = true;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		return isUpdate;
		
	}
	
}
