package controller;

import model.DAO_sing;
import model.DAO_user;
import model.DTO_sing;
import model.DTO_user;

public class Controller {
	DAO_user dao_user = new DAO_user();
	DAO_sing dao_sing = new DAO_sing();
	
		public void login(DTO_user dto) {
		
		boolean res = dao_user.login(dto);
		// res : true :로그인 성공
		// res : false : 로그인 실패
		if(res) {
			System.out.println("로그인 성공!");
		}else {
			System.out.println("아이디나 비밀번호가 다릅니다.");
		}
		
	}

		public void join(DTO_user dto) {
			int row = dao_user.join(dto);//row
			
			if(row>0) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
			
		}

		// 음악 퀴즈
		public void musicQuiz(DTO_sing dto) {
			dto = dao_sing.musicQuiz(dto);
			
			
		}
	
	
}
