package kr.or.connect.reservation.dao;

public class DisplayInfoDaoSqls {
	public static final String SELECT_ALL_DISPLAYINFO = "SELECT product.id, category.id as categoryId, display_info.id as displayInfoId, category.name, product.description, product.content, product.event, \r\n" + 
						"display_info.opening_hours, display_info.place_name, display_info.place_lot, display_info.place_street, display_info.tel, display_info.homepage, display_info.email, display_info.create_date, display_info.modify_date,\r\n" + 
						"file_info.id as fileId\r\n" + 
						"FROM category, product, display_info, file_info WHERE category.id = product.category_id AND product.id = display_info.product_id AND file_info.file_name like CONCAT(display_info.product_id, '#_ma#_%') ESCAPE '#' ORDER BY product.id limit :start, :limit";
	public static final String SELECT_DISPLAYINFO_BY_CATEGORY = "SELECT product.id, category.id as categoryId, display_info.id as displayInfoId, \r\n" + 
						"category.name, product.description, product.content, product.event, \r\n" + 
						"display_info.opening_hours, display_info.place_name, display_info.place_lot, display_info.place_street, display_info.tel, display_info.homepage, display_info.email, display_info.create_date, display_info.modify_date,\r\n" + 
						"file_info.id as fileId\r\n" + 
						"FROM category, product, display_info, file_info WHERE category.id = :categoryId AND category.id = product.category_id AND product.id = display_info.product_id AND file_info.file_name like CONCAT(display_info.product_id, '#_ma#_%') ESCAPE '#' ORDER BY product.id limit :start, :limit";
	public static final String SELECT_BY_DISPLAYINFO_ID = "SELECT product.id, category.id as categoryId, display_info.id as displayInfoId, category.name, product.description, product.content, product.event, display_info.opening_hours, display_info.place_name, display_info.place_lot, display_info.place_street, "
			+ "display_info.tel, display_info.homepage, display_info.email, display_info.create_date, display_info.modify_date, file_info.id as fileId "
			+ "FROM category, product, display_info, file_info WHERE category.id = product.category_id AND product.id = display_info.product_id AND display_info.id = 1 AND file_info.file_name like CONCAT(display_info.product_id, '#_ma#_%') ESCAPE '#'";
	public static final String SELECT_COUNT = "SELECT count(*) FROM display_info";
	public static final String SELECT_COUNT_BY_CATEGORY = "SELECT count(*) FROM display_info, product WHERE product.category_id = :categoryId AND product.id = display_info.product_id";
}
