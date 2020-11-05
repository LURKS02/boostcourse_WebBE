package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationUserCommentDao;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.ReservationUserCommentService;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService {
	@Autowired
	ReservationUserCommentDao reservationUserCommentDao;
	
	@Transactional
	@Override
	public List<ReservationUserComment> getAllReservationUserComment(Integer start){
		List<ReservationUserComment> list = reservationUserCommentDao.selectAllReservationUserComment(start, ReservationUserCommentService.DISPLAY_LIMIT);
		return list;
	}
	
	@Transactional
	@Override
	public List<ReservationUserComment> getReservationUserCommentByProductId(Integer productId, Integer start){
		List<ReservationUserComment> list = reservationUserCommentDao.selectReservationUserCommentByProductId(productId, start, ReservationUserCommentService.DISPLAY_LIMIT);
		return list;
	}
	
	@Override
	public int getCount(Integer productId) {
		return reservationUserCommentDao.selectCount(productId);
	}
}
