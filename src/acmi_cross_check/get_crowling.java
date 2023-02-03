package acmi_cross_check;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class get_crowling {
	private String URL;
	private String user_id;
	private Set<String> problem_list;
	
	public get_crowling(String url ,String user_id) {
		URL = "https://www.acmicpc.net/user/";
		this.user_id = user_id;
		URL = URL + this.user_id;
		Connection conn = Jsoup.connect(URL);
		
		Document document;
		try {
			document = conn.get();
			Elements problem_list = document.getElementsByClass("problem-list"); 
			Set<String> tmp = new HashSet<>();
			StringTokenizer str = new StringTokenizer(problem_list.get(0).text());
			while(str.hasMoreTokens()) {
				tmp.add(str.nextToken());
			}
			this.setProblem_list(tmp);
		} catch (IOException e) {
			System.out.println("¿©±â");
			e.printStackTrace();
		}
		
		
	}

	public String getUser_id() {
		return user_id;
	}

	public Set<String> getProblem_list() {
		return problem_list;
	}

	public void setProblem_list(Set<String> problem_list) {
		this.problem_list = problem_list;
	}
	
	
}
