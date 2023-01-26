package controller;

import java.util.Random;
import java.util.Scanner;
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
	String answer = null;
	int score = 0;
	int myScore = 0; // 나의 점수 (누적)
	String file1 = null;
	String singer = null;

	public int musicQuiz(DTO_sing dto) {
		DTO_sing dto2 = dao_sing.musicQuiz(dto);
		answer = dto2.getTitle();
		score = dto2.getPoint1();
		file1 = dto2.getFile1();
		singer = dto2.getSinger();

		if (dto2.getTitle() == null) {
			System.out.println("다시 입력해주세요.");
			return 0;
		} else {
			System.out.println("힌트: " + dto2.getHint());

			Timer timer = new Timer();
			TimerTask task = new TimerTask() {

				@Override
				public void run() {
					mp3.play(dto2.getFile1());

				}

			};
			timer.schedule(task, 1000);

			return 1;
		}
	}
	
	// 정답 확인
	public int musicCheck(DTO_sing dto2) {
		if (mp3.isPlaying() == true) {
			if(answer.equals(dto2.getTitle())){				
				System.out.println("점수 두배 획득");
				myScore += score*2;
				mp3.stop();
			}else {
				System.out.println("땡");
				myScore -= score;
				mp3.stop();
			}
		}else {			
			if (answer.equals(dto2.getTitle())) {
				System.out.println("정답입니다.");
				myScore += score;
				mp3.stop();
			} else {
				System.out.println("땡");
				myScore -= score;
				mp3.stop();
			}
		}

		return myScore;

	}
	// 게임 기회 확인
	public void heart(DTO_sing dto3) {
		String heart = "♡♡♡";
		System.out.println("남은 기회: " + heart.substring(0, 3 - dto3.getGameCnt()));
	}
	
	// 1004 가위바위보 힌트 게임
	public void hint1004() {
		
		if (mp3.isPlaying() == true) {
			mp3.stop();
		}
			
	      Scanner sc = new Scanner(System.in);
	      Random rd = new Random();
	      String [] arr = {"주먹", "가위","보"};
	      
	      int cnt = 0;
	      while(true) {
	            System.out.println("================[가위바위보 미니 게임]=================");
	            System.out.println("[주먹] [가위] [보]");
	            System.out.print("[주먹] [가위] [보] 중 하나를 입력하세요 : ");
	            
	            String com = arr[rd.nextInt(3)];
	            String user = sc.next();            
	            
	            System.out.print("컴퓨터 ["+ com + "]" + "VS 유저 ["+user+"]");
	            
	            
	            
	            if(user.equals("주먹")) {
	               
	               if(com.equals("가위")) {
	                  System.out.println("<승리>");
	                  System.out.println("추가 힌트 획득! >>> "+ singer);
	                  break;
	               }
	               else if(com.equals("보")) {
	                  System.out.println("<패배>");
	                  System.out.println("\n아쉬워요!");
	                  break;
	               }else {
//	                  if(cnt==1) {
//	                	  break;
//	                  }
//	                  cnt++;
	            	   System.out.println("<무승부>");
	                  System.out.println("\n다시 한번 더!");
	               }
	            }
	            else if(user.equals("가위")) {
	               
	               if(com.equals("가위")) {
//	            	   if(cnt==1) {
//		                	  break;
//		                  }
//		                  cnt++;
	                  System.out.println("<무승부>");
	                  System.out.println("\n다시 한번 더!");

	               }
	               else if(com.equals("보")) {
	                  System.out.println("<승리>");
	                  System.out.println("추가 힌트 획득! >>> "+ singer);

	                  break;
	               }
	               else {
	                  System.out.println("<패배>");
	                  System.out.println("\n아쉬워요!");

	                  break;
	               }
	            }
	            else if(user.equals("보")) {
	               if(com.equals("가위")) {
	                  System.out.println("<패배>");
	                  System.out.println("\n아쉬워요!");

	                  break;
	               }
	               else if(com.equals("보")) {
//	            	   if(cnt==1) {
//		                	  break;
//		                  }
//		                  cnt++;
	                  System.out.println("<무승부>");
	                  System.out.println("\n다시 한번 더!");

	               }
	               else {
	                  System.out.println("<승리>");
	                  System.out.println("추가 힌트 획득! >>> "+ singer);

	                  break;
	               }
	            }
	            else {
	               System.out.println("X==[주먹 가위 보 중에 골라주세요]==X");
	            }
	         }
	      
	      Timer timer = new Timer();
	  	TimerTask task = new TimerTask() {

	  		@Override
	  		public void run() {
	  			mp3.play(file1);
	  				
	  		}

	  	};
	  	timer.schedule(task, 1000);
		
		
	}
	
	
	

}
