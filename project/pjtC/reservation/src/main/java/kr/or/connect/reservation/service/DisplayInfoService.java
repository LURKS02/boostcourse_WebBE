package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfo;

public interface DisplayInfoService {
	public static final Integer DISPLAY_LIMIT = 4;
	public List<DisplayInfo> getAllDisplayInfo(Integer start);
	public List<DisplayInfo> getDisplayInfoByCategory(Integer categoryId, Integer start);
	public List<DisplayInfo> getDisplayInfoByProductId(Integer id);
	public int getCount(Integer categoryId);
}
