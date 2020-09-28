package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT_ALL_CATEGORY = "SELECT category.id, category.name, count(*) as count FROM category, product, display_info WHERE category.id = product.category_id AND product.id = display_info.product_id GROUP BY category.id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM category";
}
