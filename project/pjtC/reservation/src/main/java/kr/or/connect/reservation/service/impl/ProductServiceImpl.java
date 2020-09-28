package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	
	@Transactional
	@Override
	public List<Product> getProductByCategoryId(Integer id){
		List<Product> list = productDao.selectByCategoryId(id);
		return list;
	}
	
	@Override
	public int getCountByCategoryId(Integer id) {
		return productDao.selectCountByCategoryId(id);
	}
}