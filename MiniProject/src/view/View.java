package view;

import java.util.Scanner;
import controller.Controller;


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
				
				break;
			}else if(select == 2) {
				System.out.print("ID를 입력하세요 >> ");
				String id = sc.next();
				/*
				System.out.print("닉네임을 입력하세요 >> ");
				String name = sc.next();
				System.out.print("PW 입력하세요 >> ");
				String pw = sc.next();
				*/
				break;
			}else {
				System.out.println("잘못입력하셨습니다. 다시 입력해주십시오.");
			}
		}
		
		while(true) {
			System.out.print("[1]게임시작 [2]랭킹확인 [3]게임종료 >> "); 
			int select = sc.nextInt();
			
			if(select == 1) {
				
				
			}else if(select == 2) {
				
			}else if(select == 3) {
				System.out.println("게임이 종료되었습니다. 감사합니다");
				break;
			}else {
				System.out.println("잘못입력하셨습니다. 다시 입력해주십시오.");
			}
		}
		

	}

}
