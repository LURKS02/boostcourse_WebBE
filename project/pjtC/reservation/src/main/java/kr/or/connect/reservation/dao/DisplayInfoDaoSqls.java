package kr.or.connect.reservation.dao;

public class DisplayInfoDaoSqls {
	public static final String SELECT_DISPLAYINFO = "SELECT id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date FROM display_info ORDER BY id";
}