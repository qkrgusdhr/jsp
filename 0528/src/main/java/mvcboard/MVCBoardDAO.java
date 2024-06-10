package mvcboard;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class MVCBoardDAO extends DBConnPool{
	public MVCBoardDAO() {
		super();
	}
	
	public int selectCount(Map<String, Object> map) {
		int totalcount = 0;
		
		String sql = "SELECT COUNT (*) FROM MVCBOARD";
		if(map.get("serchWord") != null) {
			sql += " WHERE " + map.get("searchField") + " "
					+ " LIKE '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			totalcount = rs.getInt(1);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("게시물 카운트 중 예외 발생");
		}
		return totalcount;
	}
	
	public List<MVCBoardDTO> selectListPage(Map<String, Object> map){
		List<MVCBoardDTO> list = new Vector<MVCBoardDTO>();
		String sql = " " 
				+ " SELECT * FROM ( "
				+ 	"SELECT Tb.*, ROWNUM rNum FROM ( "
				+	"	SELECT * FROM mvcboard";
		if(map.get("searchWord") != null) {
			sql += " WHERE " + map.get("searchField")
				+ " LIKE '%" + map.get("searchWord") + "%' ";
		}
		sql += "	ORDER BY IDX DESC "
				+"	) Tb "
				+ " )	"
				+ " WHERE rNum BETWEEN ? AND ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, map.get("start").toString());
			pstmt.setString(2, map.get("end").toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MVCBoardDTO dto = new MVCBoardDTO();
				
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
				
				list.add(dto);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("게시물 조회 중 예외 발생");
		}
		return list;
	}
	
	public int insertWrite(MVCBoardDTO dto) {
		int result = 0;
		try {
			String sql = "INSERT INTO MVCBOARD ( " 
					+ " IDX, NAME, TITLE, CONTENT, OFILE, SFILE, PASS)"
					+ " VALUES ( "
					+ " SEQ_BOARD_NUM.NEXTVAL,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getOfile());
			pstmt.setString(5, dto.getSfile());
			pstmt.setString(6, dto.getPass());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("게시물 입력 중 예외 발생");
		}
		return result;
	}
	
	public MVCBoardDTO selectView(String idx) {
		MVCBoardDTO dto = new MVCBoardDTO();
		String sql = "SELECT * FROM MVCBOARD WHERE IDX = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
			
		}
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("게시물 상세보기 중 예외 발생");
	}
		return dto;
	}
	public void UpdateVisitCount(String idx) {
		String sql = "UPDATE MVCBOARD SET "
				+ " VISITCOUNT=VISITCOUNT+1 "
				+ " WHERE IDX = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idx);
			pstmt.executeQuery();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("게시물 조회수 증가 중 예외 발생");
		}
	}
	
	public void downCountPlus(String idx) {
		String sql = "UPDATE MVCBOARD SET "
				+ " DOWNCOUNT=DOWNCOUNT+1 "
				+ " WHERE IDX=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idx);
			pstmt.executeQuery();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
}
