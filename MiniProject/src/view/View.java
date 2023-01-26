package view;

import java.util.Scanner;

import controller.Controller;
import model.DTO_sing;
import model.DTO_user;


public class View {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Controller ct = new Controller();
		
		while(true) {
			System.out.print("[1]로그인 [2]회원가입 >> "); 
			int select = sc.nextInt();
			
			if(select == 1) {
				System.out.print("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.print("PW를 입력해주세요 >> ");
				String pw = sc.next();
				DTO_user dto = new DTO_user(id,pw);
				int cnt = ct.login(dto);
				
				if(cnt == 1) {
					break;
				}else {
					continue;
				}
				
			}else if(select == 2) {
				System.out.print("ID를 입력하세요 >> ");
				String id = sc.next();
				System.out.print("PW를 입력하세요 >> ");
				String pw = sc.next();
				System.out.print("닉네임을 입력하세요 >> ");
				String name = sc.next();
				
				DTO_user dto = new DTO_user(id,pw,name);
				ct.join(dto);

			}else {
				System.out.println("잘못입력하셨습니다. 다시 입력해주십시오.");
			}
		}
		
		int gameCnt = 0;
		while(true) {
			System.out.print("[1]게임시작 [2]랭킹확인 [3]게임종료 >> "); 
			int select = sc.nextInt();
			
			if(select == 1) {
				// 게임 설명
				System.out.println("============================게임설명===========================");
				System.out.println(" ① 게임은 3회동안 진행됩니다.\n ② 0점에서 시작하여 선택한 난이도만큼 승리시 점수획득하며 실패시 점수가 줄어들게됩니다.\n"
						+ " ③ 노래가 재생되는 10초이내 정답입력시 난이도의 2배 점수를 획득합니다.\n④ 정답입력시 띄어쓰기는 불가하며 영어는 소문자만 가능합니다.\n"
						+ " ⑤ 랭킹순위에는 본인의 최고점수만 반영됩니다.");
				System.out.println("============================================================");
				// 장르 선택
				while (true) {
					System.out.println("장르를 선택하세요 [1]~[4]");
					System.out.print("[1]발라드 [2]댄스 [3]동요 [4]POP >> ");
					int type1 = sc.nextInt();
					
					// 난이도 선택
					System.out.println("장르를 선택하세요 [25]~[100]");
					System.out.print("[25] [50] [75] [100] >> ");
					int point1 = sc.nextInt();
					DTO_sing dto = new DTO_sing(type1, point1);
					int cnt = ct.musicQuiz(dto);
					
					if(cnt == 1) { // 입력값이 맞을 때
						System.out.print("정답을 입력하세요 (Hint: 1004 입력) >> ");
						String title = sc.next();
						DTO_sing dto2 = new DTO_sing(title);
						ct.musicCheck(dto2);
						gameCnt++;
						ct.heart(gameCnt);
						System.out.println("--------------------------------------------------------");
					}else {
						continue;
					}
					if(gameCnt > 2) {
						System.out.println("기회 소진! GAME OVER ~~");
						break;
					}
					
				}
				
				
				
			}else if(select == 2) {
				// 랭킹 확인
				
			}else if(select == 3) {
				System.out.println("게임이 종료되었습니다. 감사합니다");
				break;
			}else {
				System.out.println("잘못입력하셨습니다. 다시 입력해주십시오.");
			}
		}
	}
}
