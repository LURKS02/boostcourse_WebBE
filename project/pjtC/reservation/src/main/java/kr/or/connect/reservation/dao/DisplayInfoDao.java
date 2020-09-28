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

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayInfo;

import static kr.or.connect.reservation.dao.DisplayInfoDaoSqls.*;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfo> selectAllDisplayInfo(){
		return jdbc.query(SELECT_ALL_DISPLAYINFO, Collections.emptyMap(), rowMapper);
	}
	
	public List<DisplayInfo> selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("prductId", id);
			return jdbc.query(SELECT_BY_DISPLAYINFO_ID, params, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
