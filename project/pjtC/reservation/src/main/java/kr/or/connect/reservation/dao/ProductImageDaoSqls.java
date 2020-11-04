package kr.or.connect.reservation.dao;

public class ProductImageDaoSqls {
	public static final String SELECT_ALL_PRODUCT_IMAGE = "select product_image.product_id, product_image.id AS product_image_id, product_image.type,\r\n" + 
			" product_image.file_id AS file_info_id, file_info.file_name, file_info.save_file_name,\r\n" + 
			" file_info.content_type, file_info.delete_flag, file_info.create_date, file_info.modify_date\r\n" + 
			" FROM product_image, file_info, display_info\r\n" + 
			" WHERE display_info.id = 1 and display_info.product_id = product_image.product_id and not product_image.type =\"th\" and product_image.file_id = file_info.id";
	
}
