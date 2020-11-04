package kr.or.connect.reservation.dao;

public class ProductPriceDaoSqls {
	public static final String SELECT_ALL_PRODUCT_PRICE = "SELECT product_price.id, product_price.product_id, product_price.price_type_name,\r\n" + 
			"product_price.price, product_price.discount_rate,\r\n" + 
			"product_price.create_date, product_price.modify_date\r\n" + 
			"FROM product_price, display_info\r\n" + 
			"WHERE display_info.id = :displayId and display_info.product_id = product_price.product_id";
}
