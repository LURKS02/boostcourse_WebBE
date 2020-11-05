package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationUserComment;

public interface ReservationUserCommentService {
	public static final Integer DISPLAY_LIMIT = 5;
	public List<ReservationUserComment> getAllReservationUserComment(Integer start);
	public List<ReservationUserComment> getReservationUserCommentByProductId(Integer productId, Integer start);
	public int getCount(Integer productId);
	public int getAverage(Integer displayId);
}
