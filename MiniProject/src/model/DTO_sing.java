package model;

public class DTO_sing {
	
	private String title;
	private String singer;
	private String file1;
	private int type1;
	private int point1;
	private String hint;
	
	public DTO_sing(String title, String singer, String file1, int type1, int point1, String hint) {
		super();
		this.title = title;
		this.singer = singer;
		this.file1 = file1;
		this.type1 = type1;
		this.point1 = point1;
		this.hint = hint;
	}
	
	public DTO_sing(int type1, int point1) {
		this.type1 = type1;
		this.point1 = point1;
	}

	public String getTitle() {
		return title;
	}

	public String getSinger() {
		return singer;
	}

	public String getFile1() {
		return file1;
	}

	public int getType1() {
		return type1;
	}

	public int getPoint1() {
		return point1;
	}

	public String getHint() {
		return hint;
	}
	
	
	
}
