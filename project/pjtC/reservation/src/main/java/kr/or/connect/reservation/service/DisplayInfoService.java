package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfo;

public interface DisplayInfoService {
	public static final Integer DISPLAY_LIMIT = 4;
	public List<DisplayInfo> getAllDisplayInfo();
	public List<DisplayInfo> getDisplayInfoByProductId(Integer id);
}
