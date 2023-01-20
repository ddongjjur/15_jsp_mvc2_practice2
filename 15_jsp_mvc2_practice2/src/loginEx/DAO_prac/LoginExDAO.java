package loginEx.DAO_prac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginExDAO {

	private LoginExDAO() {}
	private static LoginExDAO instance = new LoginExDAO();
	public static LoginExDAO getInstance() {
		return instance;
	}
	
	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	
    public void getConnection() {
        
    	try {
    		
    		Context initCtx = new InitialContext();
    		Context envCtx = (Context)initCtx.lookup("java:comp/env");
    		DataSource ds = (DataSource)envCtx.lookup("jdbc/pool");
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
    
    public boolean checkId(String memberId) {
		
    	boolean ischeckId = true;
    	
    	try {
			
    		getConnection();
    		pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID=?");
    		pstmt.setString(1, memberId);
    		rs = pstmt.executeQuery();
    		
    		if (rs.next()) {
				ischeckId = false;
			}
    				
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		getClose();
    	}
    	
    	return ischeckId;
    	
	}
	
}
