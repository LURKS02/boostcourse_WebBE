package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	/*
	 * 읽기만 하는 메서드의 경우 트랜젝션을 처리할 때
	 * transactional 어노테이션을 붙여주면
	 * 내부적으로 readOnly connection 사용
	 */
	@Transactional
	public List<Category> getAllCategory(){
		List<Category> list = categoryDao.selectAllCategory();
		return list;
	}
	
	public int getCount() {
		return categoryDao.selectCount();
	}
	
}
