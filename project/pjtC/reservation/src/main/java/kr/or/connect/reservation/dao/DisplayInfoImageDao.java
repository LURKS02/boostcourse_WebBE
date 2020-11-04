package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.DisplayInfoImageDaoSqls.SELECT_ALL_DISPLAY_INFO_IMAGE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfoImage;

@Repository
public class DisplayInfoImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoImage> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	
	public DisplayInfoImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfoImage> selectAllDisplayInfoImage(Integer displayId){
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(SELECT_ALL_DISPLAY_INFO_IMAGE, params, rowMapper);
	}
}
