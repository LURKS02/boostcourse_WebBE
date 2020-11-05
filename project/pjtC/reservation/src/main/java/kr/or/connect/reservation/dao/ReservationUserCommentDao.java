package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationUserCommentDaoSqls.SELECT_ALL_RESERVATION_USER_COMMENT;
import static kr.or.connect.reservation.dao.ReservationUserCommentDaoSqls.SELECT_COUNT;
import static kr.or.connect.reservation.dao.ReservationUserCommentDaoSqls.SELECT_COUNT_BY_PRODUCT_ID;
import static kr.or.connect.reservation.dao.ReservationUserCommentDaoSqls.SELECT_RESERVATION_USER_COMMENT_BY_PRODUCT_ID;

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

import kr.or.connect.reservation.dto.ReservationUserComment;

@Repository
public class ReservationUserCommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationUserComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);
	
	public ReservationUserCommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationUserComment> selectAllReservationUserComment(Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_ALL_RESERVATION_USER_COMMENT, params, rowMapper);
	}
	
	public List<ReservationUserComment> selectReservationUserCommentByProductId(Integer productId, Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_RESERVATION_USER_COMMENT_BY_PRODUCT_ID, params, rowMapper);
	}
	
	public int selectCount(Integer productId) {
		try {
			if (productId == 0) return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
			else {
				Map<String, Integer> params = Collections.singletonMap("productId", productId);
				return jdbc.queryForObject(SELECT_COUNT_BY_PRODUCT_ID, params, Integer.class);
			}
		} catch(EmptyResultDataAccessException e) {
			return -1;
		}
	}
}
