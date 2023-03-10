package model;

public class DTO_user {
	
	private String id;
	private String pw;
	private String name;
	private int score;
	private int max;
	
	private String loginID;
	private int rownum;
	
	
	
	public int getRownum() {
		return rownum;
	}
	public DTO_user(String id, String name, int max) {
		super();
		this.id = id;
		this.name = name;
		this.max = max;
	}
	public DTO_user(String id, String name, int max, int rownum) {
		super();
		this.id = id;
		this.name = name;
		this.max = max;
		this.rownum = rownum;
	}
	public String getLoginID() {
		return loginID;
	}
	public DTO_user(int score, String loginID) {
		super();
		this.score = score;
		this.loginID = loginID;
	}
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
