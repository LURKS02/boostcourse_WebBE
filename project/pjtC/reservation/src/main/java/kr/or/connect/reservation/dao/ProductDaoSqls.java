package kr.or.connect.reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT_BY_CATEGORY_ID = "SELECT id, category_id, description, content, event, create_date, modify_date FROM product WHERE category_id = :categoryId";
	public static final String SELECT_COUNT_BY_CATEGORY_ID = "SELECT (*) FROM product WHERE category_id = :categoryId";
}
