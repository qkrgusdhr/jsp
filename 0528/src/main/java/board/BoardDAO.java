package board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class BoardDAO extends DBConnPool {

	DBConnPool pool = new DBConnPool();

	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		String sql = "SELECT COUNT(*) FROM BOARD1";
		if (map.get("searchWord") != null) {
			sql += " WHERE " + map.get("searchField") + " " + " LIKE '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = pool.con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}

	public List<BoardDTO> selectList(Map<String, Object> map) {
		List<BoardDTO> list = new Vector<BoardDTO>();

		String sql = "SELECT * FROM BOARD1 ";
		if (map.get("searchWord") != null && map.get("searchField") != null) {
			sql += " WHERE " + map.get("searchField") + " " + " LIKE '%" + map.get("searchWord") + "%'";
		} else {
			sql += " ORDER BY NUM DESC";
		}
		try {
			stmt = pool.con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("Content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));

				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return list;
	}

	public int insertWrite(BoardDTO dto) {
		int result = 0;

		try {
			String sql = "INSERT INTO BOARD1(" + " NUM, TITLE, CONTENT, ID, VISITCOUNT) " + " VALUES ( "
					+ "SEQ_BOARD_NUM.NEXTVAL, ?, ?, ?, 0)";

			pstmt = pool.con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getId());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	public BoardDTO selectView(String num) {
		BoardDTO dto = new BoardDTO();
		try {
			String sql = "SELECT B.*, M.NAME " + " FROM LOGIN M INNER JOIN BOARD1 B " + " ON M.ID=B.ID "
					+ " WHERE NUM = ?";

			pstmt = pool.con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("게시물 상세 보기 중 예외 발생");
		}
		return dto;
	}

	public void updateVisitCount(String num) {
		String sql = "UPDATE BOARD1 SET " + "VISITCOUNT=VISITCOUNT + 1" + "WHERE NUM = ?";

		try {
			pstmt = pool.con.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("게시물 조회수 증가 중 예외 발생");
		}
	}

	public int UpdateBoard(BoardDTO dto) {
		int result = 0;

		try {
			String sql = "UPDATE BOARD1 SET " + " TITLE=?, CONTENT=? " + " WHERE NUM=?";

			pstmt = pool.con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getNum());

			rs = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	public int DeletePost(BoardDTO dto) {
		int result = 0;

		try {
			String sql = "DELETE FROM BOARD1 WHERE NUM=?";

			pstmt = pool.con.prepareStatement(sql);
			pstmt.setString(1, dto.getNum());

			rs = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	public List<BoardDTO> selectListPage(Map<String, Object> map) {
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		String sql = " SELECT * FROM ( " + 
				" SELECT Tb.*, ROWNUM rNum FROM ( "
				+ " SELECT * FROM board1 ";
		
		if	(map.get("searchWord") != null) {
			sql += "WHERE " + map.get("searchField")
				+ " LIKE '%" + map.get("searchWord") + "%' ";
		}
		sql += " ORDER BY num DESC "
				+ " ) Tb "
				+ " ) "
				+ " WHERE rNum BETWEEN ? AND ?";
		try {
			pstmt = pool.con.prepareStatement(sql);
			pstmt.setString(1, map.get("start").toString());
			pstmt.setString(2, map.get("end").toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				bbs.add(dto);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 조회 중 예외 발생");
		}
		
		return bbs;
	}
}
