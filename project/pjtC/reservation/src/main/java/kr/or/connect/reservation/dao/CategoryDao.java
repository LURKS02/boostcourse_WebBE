package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import static kr.or.connect.reservation.dao.CategoryDaoSqls.*;

/*
 * Data Access Object (DAO)
 * 데이터를 조회하거나 조작하는 기능을 전담하는 객체
 * 데이터베이스를 조작
 */

//저장소 역할
@Repository
public class CategoryDao {
	//Spring JDBC에서 JDBC를 더 편하게 하기 위해 이미 구현해 놓은 객체들
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	/*
	 * JdbcTemplate는 바인딩 시 ?를 사용
	 * sql문자열만 보았을때는 어떤 값이 매핑되는지 알아보기 힘든 문제
	 * NamedParameterJdbcTemplate는 이름을 이용해 바인딩하거나 결과값을 가져올 수 있음
	 */
	
	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> selectAllCategory(){
		return jdbc.query(SELECT_ALL_CATEGORY, Collections.emptyMap(), rowMapper);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
}
