package view;

import java.util.Scanner;

import controller.Controller;
import javazoom.jl.player.MP3Player;
import model.DTO_sing;
import model.DTO_user;


public class View {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Controller ct = new Controller();
		MP3Player mp3 = new MP3Player();
		String loginID = null;
		int score = 0;
		
		System.out.println(
				"i:i:i::::::::.70M:.:....:.727i0Z:.. :22: ..280::::::::::::i:::i:::i:::i:::::::::i:::::i:\r\n"
						+ ":::i:: MBB:.. XBBi BBBBBBrMBM7BB::7rXBBMi7.BBB..::::...::::i:i:::::::::i:::::::i:::i:i::\r\n"
						+ "i.i::. BBB: BBBBB: BBB22X.8BBXBB.2BBBBBBBB2XBB. ::..:::..:::::::::::::::::::::::::::::i.\r\n"
						+ "::::. 7BBBB.22MBB: BBB8MB 0BBBBB:  i2MMS:  ZBB:i..7BBBBB2... . ..::::::::::i:::::::::i::\r\n"
						+ "i.::2BBB2MBB0 7BB: BBBX0M7ZB0iBB: SBBZ0BBX 0BBBBi BBB.:BBr iSMM2: ::..::::::::::::i:::i:\r\n"
						+ "::::8BM:  2B0 2BBi MM000Xr2B2:BB..BBX  2BB 0BB:i.r:SBBXi..XBBBBBBX .77..:..:::::::::::::\r\n"
						+ "i.i:..:20:    XBBi.. 2M88ZBMM08M: 8BB00BBM 0BB  .BB7 7BB:rBBr  iBB: BBM .77i......::::i:\r\n"
						+ "::::: 7BB2 .   ....:.0MMMMMM0BBBi  78BBM7. MBB...7BBBBBB.8BB   7BB XBBB. BBZ .i7r:..::::\r\n"
						+ "i.i::.2BBBBBBBBBBX.::.. .    0BBr.:.  . ...BBB:.:..:777. iBBM70BB2.BBMBS7BB iBBBBBB7.::.\r\n"
						+ ":::i::i2722S2S2SS7.:::::::::.7X0:.::.:.:::.2XX:::::....:..:XBBBB7 BBB BBBB7.BBX. 7BBi:::\r\n"
						+ "i.i::::.. . . ....::::i::::::.. ..::i::::..   ::::::::::::. ...  :BB7 7BBB XBB  M272:.i:\r\n"
						+ ":::i::::::::::::::::::::::::::.r77iii7722X27:..::::i:i::::::.:.:::.:...MB2 7BB7:SBB8.:::\r\n"
						+ "i.i:::::i:i:::::::::::i::::::7Si..7SXSS22772ZZ2:.:::::::i::::::::.:::::.....7BBBBB8.::i:\r\n"
						+ ":::::::::::::i:::::::::i::.7Xi  7S27i::ii777:.782.:::i:i::::722222::::::::::..:ri. :::::\r\n"
						+ "i.i:::i:::::::::::i::::::.2S  iXi...:.:....i22. 2X.:::::::iXr    :Xr::::::::::....::i:i.\r\n"
						+ ":::i:::i:::::::::i::::::.72  r0..:::...:.:...:Xr.2S.::::::0. .::i  M::::::::::::::::::::\r\n"
						+ "i.i:i:i:::::i:::::::i::::M  .B777i:i7727277i:i7Xr7Bi.::::i0  7BB8  X7.::i:::i:::i:::::i:\r\n"
						+ ":::::::::i:::i:i::::::::SB770M70S7227riiiir7S0X7:iMX..::::0.   .  :M:::i:::::::::i:::i::\r\n"
						+ "i.i:i:::::::::::::::::rXr. .B7i:B7.::::::::..:2X:iM:MX.::::M.   :28i::i:i:::::i:i:i:i:i.\r\n"
						+ ":::i:i:::i:i:i:::::::iZ  .:  2ii:M:::i:i:i:i::.:7MMr:B2.::7BSS2S27.::::i:i:::::::::i:i::\r\n"
						+ "i.i:::::i:::::::i:::.Si   2. 77r 02.i:i:i:iii:i:.XXX 7Xi:::i:.::::::i:i:::::i:::::i:::i.\r\n"
						+ ":::::i:i:::i:i::::::.Xi   7. 27. 02.:iii:i:i:i:::.ZM 7Xr:::::::::::::::i:::::i::::::::::\r\n"
						+ "i:i:::i:::i:::i:i::::iB.  7 .877rB7.::i:iii:::r::.70rBX.::::::::::i:::::::i:i:::::::i:i:\r\n"
						+ ":::::i:::::i:::i::::::787r.:S2S2MX.777:ii::ir02Xr:.ZB8.::::i:i:i:i:::::::i:i:::::::::i::\r\n"
						+ "i.i:i:::i:::i:i:i:i:::::28BM0MMM2.7Sr27:.22.r7.:r:.22 ::::::i:i:::::::::::::::::i:i:i:i.\r\n"
						+ ":::i:::i:i:::i:::i::::::..rB7:::.:i:.i. .XM: .i::.:X2.:::::::::::::::i:::::i::::::::::::\r\n"
						+ "i.i:::::::i:::::::..ir7i:..2B7..:::::i       .i.:2SBi.::::::::i:i:::i:i:::::::::::i:::i.\r\n"
						+ ":::i:::::::::::::.rS7ri722..:207::.:::i:   .:ii2X7.Xi::::::i:i:::::i:::::i:i:::i:i::::::\r\n"
						+ "i.i:i:::::i:::::.S0i     :0:. :BMX2777772222S0MB...0r:::::::i:::::::::i:i:::i:::i:::i:i:\r\n"
						+ ":::::i:i:::::::.2M..iXXr  .0..X7:77222222XSS27:Xi..Zi::::i:i:::i:::i:::i:::i:::::::i:i::\r\n"
						+ "i.i:i::::::::::.M7.:Bir87.72.X2.:.::::::r:. .:.7X..X7.::::::::::::::::::::::::::::i:::i.\r\n"
						+ ":::::i:i:::::::.M2:i0..:227.70.::::i:::r      :r8..r0.:::::::i:::::::::::::::i:i:::i:i::\r\n"
						+ "i.i:::::i:i:i::.2M7.0r..:...M:::i:::::ir.     iiB.: X2.:::i:::::::::i:::::::i:::i:::i:i:\r\n"
						+ ":::i:i::::::::::.00r:0i..:.2S.:::S7777:ir    .:rB777.X2..::::::::::::::::i:::::::i::::::\r\n"
						+ "i.::::::i:i:::i::.X87:S2r. S7.:::2B  Sr:i:  7i.00  77 207:..::::::::::::::::i:::::::::i:\r\n"
						+ ":::i:i:::::i::::::.70Xr772rMr.:i:7i  :X::7BMXi7M . S7..:2X27ii::::::.:.....::i:i:i:i:i::\r\n"
						+ "i.i:i:i:::::::i:i::..70X2772M...::  :7B.::Bi:.Mr :72..::.:r7222222222777722:::::::i:::i:\r\n"
						+ ":::i:::::::::i::::i7rii72SSSMM27722r7MB2 7B2 7MX7XXri:.:.:.:.:.:.:.::r72SX2::::::::::i::\r\n"
						+ "i.i:::::::::i:::::ir7r7rririi7XX0XX227r2XSr2S2ii7rirrirr7727777777S8027:...:::::::i:::i.\r\n"
						+ ":::::::::::i:::::::::::::i:iii:::::i:iii::.::r7777727777r.i. i::.    .8i.::::::::i:i:i::\r\n"
						+ "i.i:::i:i:::i::::::::::::::::::.::::::::::7ri:.   ..::ii. :     .:72SS2:i:::i:::i:::i:i.\r\n"
						+ ":::::::::i:::i:::::::::::::::::::::::::::rM.   .           :r72XXX27r::i:::i:i:::::i:i::\r\n"
						+ "i.i:i:::::::::i:i:i:::i:::::i:i:i:::::::::7222MBM77i::i72X00X27ri::.::::::::::::::::i:i.\r\n");
		while(true) {
			System.out.print("[1]????????? [2]???????????? >> "); 
			int select = sc.nextInt();
			
			if(select == 1) {
				System.out.print("ID??? ?????????????????? >> ");
				String id = sc.next();
				loginID = id;
				System.out.print("PW??? ?????????????????? >> ");
				String pw = sc.next();
				DTO_user dto = new DTO_user(id,pw);
				int cnt = ct.login(dto);
				
				if(cnt == 1) {
					break;
				}else {
					continue;
				}
				
			}else if(select == 2) {
				System.out.print("ID??? ??????????????? >> ");
				String id = sc.next();
				System.out.print("PW??? ??????????????? >> ");
				String pw = sc.next();
				System.out.print("???????????? ??????????????? >> ");
				String name = sc.next();
				
				DTO_user dto = new DTO_user(id,pw,name);
				ct.join(dto);

			}else {
				System.out.println("???????????????????????????. ?????? ?????????????????????.");
			}
		}
		
		while(true) {
			int gameCnt = 0; // ?????? ??????
			System.out.print("[1]???????????? [2]???????????? [3]???????????? >> "); 
			int select = sc.nextInt();
			
			if(select == 1) {
				// ?????? ??????
				ct.musicEffect(1);
				System.out.println("============================????????????===========================");
				System.out.println(" ??? ????????? 3????????? ???????????????.\n ??? 0????????? ???????????? ????????? ??????????????? ????????? ?????????????????? ????????? ????????? ?????????????????????.\n"
						+ " ??? ????????? ???????????? 10????????? ??????????????? ???????????? 2??? ????????? ???????????????.\n ??? ??????????????? ??????????????? ???????????? ????????? ???????????? ???????????????.\n"
						+ " ??? ?????????????????? ????????? ??????????????? ???????????????.");
				System.out.println("============================================================");
				// ?????? ??????
				while (true) {
					System.out.println("????????? ???????????????");
					System.out.print("[1]????????? [2]?????? [3]?????? [4]POP >> ");
					int type1 = sc.nextInt();
					
					// ????????? ??????
					System.out.println("???????????? ???????????????");

					System.out.print("[1]25 [2]50 [3]75 [4]100 >> ");
					int point1 = sc.nextInt();
					DTO_sing dto = new DTO_sing(type1, point1);
					int cnt = ct.musicQuiz(dto); // ?????? ?????? ??????
					
					
					if(cnt == 1) { // ???????????? ?????? ???
						System.out.print("????????? ??????????????? (Hint: 1004 ??????) >> ");
						String title = sc.next();
						if(title.equals("1004")) {
							ct.hint1004(); // 1004 hint ??????
							System.out.print("????????? ??????????????? >> ");
							String title2 = sc.next();
							DTO_sing dto2 = new DTO_sing(title2);
							score = ct.musicCheck(dto2);
							System.out.println("[?????? ??????]: " + score); // ?????? ??????
							gameCnt++;
							DTO_sing dto3 = new DTO_sing(gameCnt);
							ct.heart(dto3); // ?????? ?????? ??????
							System.out.println("--------------------------------------------------------");
							
						}else {							
							DTO_sing dto2 = new DTO_sing(title);
							score = ct.musicCheck(dto2);
							System.out.println("[?????? ??????]: " + score); // ?????? ??????
							gameCnt++;
							DTO_sing dto3 = new DTO_sing(gameCnt);
							ct.heart(dto3); // ?????? ?????? ??????
							System.out.println("--------------------------------------------------------");
						}
					}else {
						continue;
					}
					
					if(gameCnt > 2) {
						System.out.println("                                                                            \r\n"
		                        
                        + "                                     :BB                                    \r\n"
                        + "                                      BB                                    \r\n"
                        + "                   ,Bs, :M2   r:iMr   BB    2ri2r r,  s,rM:                 \r\n"
                        + "                   :r  iBB,  Bh  BB   BB  ,BB  :BBM: Bs  BB                 \r\n"
                        + "                      MBs     ,: BB   BB   BB  ,BB    ,:,BB                 \r\n"
                        + "                    iBB  ,B  BB  BB,  BB   :s, i,   ,BB  BB,                \r\n"
                        + "                   :BB:,sBM  BBr,,B9 ,MB: GBrr2r:   ,BBr :BX                \r\n"
                        + "                                          ,MBGS9MBh                         \r\n"
                        + "                                          BB     M2                         \r\n"
                        + "                                           ii,,,,                           \r\n"
                        + "                                                     ii  Mh                 \r\n"
                        + "                                                    ,BMiM:B :S              \r\n"
                        + "                           ,shGG9s2sr               s9 B: BXrBii:           \r\n"
                        + "                         XMhsi,    ,rGr             22    , :BrBS           \r\n"
                        + "                       MBs            9s            Mr       ,22            \r\n"
                        + "                     sBs          ,    G:           B:      r9r             \r\n"
                        + "                    GM            2     Msr2:       B      G9               \r\n"
                        + "                   9B  ::   i:,9        si  Gi     h9     sB                \r\n"
                        + "                  ,B   ::   :BGs         B2  M    :B     :B                 \r\n"
                        + "                  9s         ,:          M  iB   iB,    ,B                  \r\n"
                        + "                  h                      s9MG   5B      B,                  \r\n"
                        + "                  G        ::s           2G,   BB     ,B,                   \r\n"
                        + "               rX:G,       is:           s   sBh     ,B,                    \r\n"
                        + "               B  2G                     s iBB      rB,                     \r\n"
                        + "               Ss rBi                   5sBB:      GM                       \r\n"
                        + "                r25BB                  BB2,      rBs                        \r\n"
                        + "                    :B,              :MS        92                          \r\n"
                        + "                     :BS           rh5        iB,                           \r\n"
                        + "                       MB5      ,s9s         sB                             \r\n"
                        + "                        SBBBS2sS2r          sM                              \r\n"
                        + "                        9  ,:,,            sM                               \r\n"
                        + "                       iX                 2G                                \r\n"
                        + "                       5i                rM                                 \r\n"
                        );
						System.out.println("?????? ??????! GAME OVER ~~");
						System.out.println("?????????????????????????????????????????????????????????");
					    System.out.println("||========R=A=N=K=I=N=G========||");
					    System.out.println("?????????????????????????????????????????????????????????");
						DTO_user dto4 = new DTO_user(score, loginID);
						ct.scoreInput(dto4); // ?????? ????????? ????????? ??????
						ct.maxScore(dto4); // ????????? ??????
						ct.rank(); // ?????? ?????? ??????
						ct.myRank(dto4);
						break;
					}
					
				}
				
				
				
			}else if(select == 2) {
				// ?????? ??????
			    System.out.println("?????????????????????????????????????????????????????????");
			    System.out.println("||========R=A=N=K=I=N=G========||");
				ct.rank(); // ?????? ?????? ??????
			}else if(select == 3) {
				System.out.println("????????? ?????????????????????. ???????????????");
				break;
			}else {
				System.out.println("???????????????????????????. ?????? ?????????????????????.");
			}
		}
	}
}
