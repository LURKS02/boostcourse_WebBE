package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.DisplayInfoDaoSqls.*;
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

import kr.or.connect.reservation.dto.DisplayInfo;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfo> selectAllDisplayInfo(Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_ALL_DISPLAYINFO, params, rowMapper);
	}
	
	public List<DisplayInfo> selectDisplayInfoByCategory(Integer categoryId, Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_DISPLAYINFO_BY_CATEGORY, params, rowMapper);
	}
	
	public List<DisplayInfo> selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("prductId", id);
			return jdbc.query(SELECT_BY_DISPLAYINFO_ID, params, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public int selectCount(Integer categoryId) {
		try {
			if (categoryId == 0) return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
			else {
				Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
				return jdbc.queryForObject(SELECT_COUNT_BY_CATEGORY, params, Integer.class);
			}
		} catch(EmptyResultDataAccessException e) {
			return -1;
		}
		
	}
	
}
