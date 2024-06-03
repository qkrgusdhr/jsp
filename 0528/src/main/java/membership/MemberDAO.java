package membership;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnPool;

public class MemberDAO extends DBConnPool{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDTO getMemberDTO(String uid, String upass) {
		DBConnPool pool = new DBConnPool();
		MemberDTO dto = new MemberDTO();
		String sql = "SELECT * FROM LOGIN WHERE ID = ? AND PASS = ?";
		
		try {
			pstmt = pool.con.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, upass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;
	}
}
