package model;

public class DTO_user {
	
	private String id;
	private String pw;
	private String name;
	private int score;
	private int max;
	
	public DTO_user(String id, String pw, String name, int score, int max) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.score = score;
		this.max = max;
	}
	public DTO_user(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public DTO_user(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
	
}
