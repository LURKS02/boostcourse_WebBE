package kr.or.connect.jdbcexam;

import java.util.List;
import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam3 {

	public static void main(String[] args) {
		
		RoleDao dao = new RoleDao();
		List<Role> list = dao.getRoles();
		
		/* 강화 for문
		 * for(타입변수 : 배열이름)
		 */
		for(Role role : list) {
			System.out.println(role);
		}
	}
}