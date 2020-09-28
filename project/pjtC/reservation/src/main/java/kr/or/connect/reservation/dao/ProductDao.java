package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import static kr.or.connect.reservation.dao.ProductDaoSqls.*;
import kr.or.connect.reservation.dto.Product;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao (DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Product> selectByCategoryId(Integer id){
		try {
			Map<String, ?> params = Collections.singletonMap("categoryId", id);
			return jdbc.query(SELECT_BY_CATEGORY_ID, params, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public int selectCountByCategoryId(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("categoryId", id);
			return jdbc.queryForObject(SELECT_COUNT_BY_CATEGORY_ID, params, Integer.class);
		} catch(EmptyResultDataAccessException e) {
			return -1;
		}
	}
	
}
