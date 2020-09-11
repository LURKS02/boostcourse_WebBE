## 개발 순서
1. mysql 데이터베이스 생성
2. GuestbookDao.java 에 데이터베이스 연결, 정보를 얻어오고 삽입하는 과정 구현 (dto.Guestbook.java 참조)
3. 구현되어있는 guestbooks.jsp에서 list값을 받아오기 때문에 GuestbookListServlet.java에서 GuestbookDao 개체를 
이용해 데이터베이스에서 list를 Guestbook 리스트를 읽어옴
4. guestbooks.jsp에서 form으로 POST가 요청되므로 GuestbookWriteServlet.java에 화면에 입력된 내용을 getParameter로 읽어와 GuestbookDao 개체를 이용하여
데이터베이스에 삽입하는 과정 구현
5. POST 이후 다시 GuestbookListServlet.java로 redirect


## setCharacterEncoding(), setContentType()
* request.setCharacterEncoding("UTF-8")

폼 태그에서 입력한 값을 전송할 때, POST방식으로 보내는 값이 한글일경우 깨지지 않게 하는 것
GET방식으로 보내진 한글들은 톰캣에 기본적으로 적용된 UTF-8이 자동으로 한글 처리를 해줌

* response.setContentType("text/html; charset=utf-8")

브라우저마다 기본적으로 문자코드를 해석하는 디폴트가 다르기 때문에 사용할 문자코드 메세지를 전달하는 역할
