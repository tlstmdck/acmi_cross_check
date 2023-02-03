package acmi_cross_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class main {
	private static String[] user_list = {"tlstmdck","wogus0","dntmdqls0912","mont_4857","dbrhdwn123","qotnqls1998"}; //백준 id 입력
	private static String[] input_problem_list = {"1181"};  //문제 번호 입력
	private static get_crowling[] instance_list;
	
	public static void load_problem() {
		instance_list = new get_crowling[user_list.length];
		for(int i=0; i<user_list.length; i++) {
			instance_list[i] = new get_crowling(null, user_list[i]);
		}
	}
	public static void cross_check() {
		if(instance_list == null) {
			System.out.println("데이터가 없습니다!!");
			return;
		}
		for(get_crowling instance : instance_list) {
			Set<String> problem_list = instance.getProblem_list();
			for (String input_problem : input_problem_list) {
				if (problem_list.contains(input_problem) == true)
					System.out.println("문제번호 : " + input_problem + " " + instance.getUser_id() + "가 이미 푼 문제!");
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1. 문제 불러오기" + "     " + "2. 중복체크" + "     "  + "3. 종료");
			String menu = br.readLine();
			switch (menu) {
				case "1": {
					System.out.println("불러오는중...");
					load_problem();
					System.out.println("불러오기 완료!");
					break;
				}
				case "2": {
					cross_check();
					break;
				}
				case "3": {
					return;
				}
			}
		}
	}
}
