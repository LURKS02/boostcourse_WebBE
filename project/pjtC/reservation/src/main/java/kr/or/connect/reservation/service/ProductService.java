package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Product;

public interface ProductService {
	public List<Product> getProductByCategoryId(Integer id);
	public int getCountByCategoryId(Integer id);
	
}
