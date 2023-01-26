package controller;

import java.util.Timer;
import java.util.TimerTask;

import javazoom.jl.player.MP3Player;
import model.DAO_sing;
import model.DAO_user;
import model.DTO_sing;
import model.DTO_user;

public class Controller {
	DAO_user dao_user = new DAO_user();
	DAO_sing dao_sing = new DAO_sing();

	public int login(DTO_user dto) {

		boolean res = dao_user.login(dto);
		// res : true :로그인 성공
		// res : false : 로그인 실패
		if (res) {
			System.out.println("로그인 성공!");
			return 1;
		} else {
			System.out.println("아이디나 비밀번호가 다릅니다.");
			return 0;
		}

	}

	public void join(DTO_user dto) {
		int row = dao_user.join(dto);// row

		if (row > 0) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}

	}

	// 음악 퀴즈
	MP3Player mp3 = new MP3Player();

	public void musicQuiz(DTO_sing dto) {
		DTO_sing dto2 = dao_sing.musicQuiz(dto);

		if (dto2 == null) {
			System.out.println("다시 입력해주세요.");
		} else {
			System.out.println("힌트: " + dto2.getHint());

			Timer timer = new Timer();
			TimerTask task = new TimerTask() {

				@Override
				public void run() {
					mp3.play(dto2.getFile1());

				}

			};
			timer.schedule(task, 3000);

		}
	}
	
	// 정답 확인


}
