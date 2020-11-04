package kr.or.connect.reservation.dao;

public class DisplayInfoImageDaoSqls {
	public static final String SELECT_ALL_DISPLAY_INFO_IMAGE = "select display_info_image.id, display_info_image.display_info_id, display_info_image.file_id,\r\n" + 
			"file_info.file_name, file_info.save_file_name, file_info.content_type, file_info.delete_flag,\r\n" + 
			"file_info.create_date, file_info.modify_date\r\n" + 
			"FROM display_info_image, file_info\r\n" + 
			"WHERE display_info_image.display_info_id = :displayId and display_info_image.file_id = file_info.id";
}
