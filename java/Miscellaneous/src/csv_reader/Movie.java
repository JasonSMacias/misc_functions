package csv_reader;

public class Movie {
	private int year;
	private int score;
	private String title;
	
	public int getYear() {
		return year;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getTitle() {
		return title;
	}

	public Movie(int year, int score, String title) {
		super();
		this.year = year;
		this.score = score;
		this.title = title;
	}
	
		
}
