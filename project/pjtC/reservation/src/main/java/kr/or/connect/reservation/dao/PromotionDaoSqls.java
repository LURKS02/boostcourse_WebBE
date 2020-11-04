package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
	public static final String SELECT_ALL_PROMOTION = "SELECT promotion.id AS id, promotion.product_id, product.category_id, "
			+ "category.name AS category_name, product.description, file_info.id AS file_id " +
			"FROM promotion, product, category, file_info " +
			"WHERE promotion.product_id = product.id and " +
			"product.category_id = category.id and " +
			"file_info.file_name like concat(promotion.product_id, '#_ma#_%') ESCAPE '#'";
	
	public static final String SELECT_COUNT = "SELECT count(*) FROM promotion, product, category, file_info\r\n" + 
			"WHERE promotion.product_id = product.id and\r\n" + 
			"product.category_id = category.id and\r\n" + 
			"file_info.file_name like concat(promotion.product_id, \'#_ma#_%\') ESCAPE '#'";
}
