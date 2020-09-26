package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT_ALL_CATEGORY = "SELECT id, name FROM category ORDER BY id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM category";
}
