package kr.or.connect.reservation.dao;

public class ReservationUserCommentDaoSqls {
	public static final String SELECT_ALL_RESERVATION_USER_COMMENT = "SELECT reservation_user_comment.id, reservation_user_comment.product_id, reservation_user_comment.reservation_info_id,\r\n" + 
			"reservation_user_comment.score, reservation_info.reservation_email, reservation_user_comment.comment,\r\n" + 
			"reservation_user_comment.create_date, reservation_user_comment.modify_date \r\n" + 
			"FROM reservationdb.reservation_user_comment, reservation_info\r\n" + 
			"WHERE reservation_user_comment.reservation_info_id = reservation_info.id order by id desc limit :start, :limit";
	public static final String SELECT_RESERVATION_USER_COMMENT_BY_PRODUCT_ID = "SELECT reservation_user_comment.id, reservation_user_comment.product_id, reservation_user_comment.reservation_info_id,\r\n" + 
			"reservation_user_comment.score, reservation_info.reservation_email, reservation_user_comment.comment,\r\n" + 
			"reservation_user_comment.create_date, reservation_user_comment.modify_date \r\n" + 
			"FROM reservationdb.reservation_user_comment, reservation_info\r\n" + 
			"WHERE reservation_user_comment.product_id = :productId and reservation_user_comment.reservation_info_id = reservation_info.id order by id desc limit :start, :limit";
	public static final String SELECT_COUNT = "select count(*) from reservation_user_comment";
	public static final String SELECT_COUNT_BY_PRODUCT_ID = "select count(*) from reservation_user_comment where reservation_user_comment.product_id = :productId";
}
