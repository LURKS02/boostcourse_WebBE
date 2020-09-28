package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.DisplayInfoDao;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {
	@Autowired
	DisplayInfoDao displayInfoDao;
	
	@Transactional
	@Override
	public List<DisplayInfo> getAllDisplayInfo(){
		List<DisplayInfo> list = displayInfoDao.selectAllDisplayInfo();
		return list;
	}
	
	@Transactional
	@Override
	public List<DisplayInfo> getDisplayInfoByProductId(Integer id){
		List<DisplayInfo> list = displayInfoDao.selectById(id);
		return list;
	}
	
}
