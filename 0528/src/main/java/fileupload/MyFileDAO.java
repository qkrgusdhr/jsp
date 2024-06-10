package fileupload;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class MyFileDAO extends DBConnPool {
	public int insertFile(MyFileDTO dto) {
		int result = 0;
		try {
			String sql = "INSERT INTO myfile( "
					+ " idx, title, cate, ofile, sfile) "
					+ " VALUES ( "
					+ "seq_board_num.nextval, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getCate());
			pstmt.setString(3, dto.getOfile());
			pstmt.setString(4, dto.getSfile());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("INSERT 중 예외 발생");
		}
		return result;
	}
	
	public List<MyFileDTO> myFileList(){
		List<MyFileDTO> list = new Vector<MyFileDTO>();
		String sql = "SELECT * FROM myfile order by idx desc";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MyFileDTO dto = new MyFileDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setCate(rs.getString(3));
				dto.setOfile(rs.getString(4));
				dto.setSfile(rs.getString(5));
				dto.setPostdate(rs.getString(6));
				
				list.add(dto);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		return list;
	}
}
