import java.util.ArrayList;

public abstract class Book {
	private String title;	// The title of the book
	private String author;	// The author of the book
	private int year;		// The published year
	private ArrayList<String> body;	// The body of the book
	protected enum Type {
		POEM, NOVEL, PLAY
	}

	/**
	 * Constructor
	 * @param title
	 * @param author
	 * @param year
	 */
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.body = new ArrayList<>();
	}

	/**
	 * Gets the book's title
	 * @return a <code>String</code> specify the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the book's author
	 * @return a <code>String</code> specify the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Gets the published year
	 * @return a <code>int</code> specify the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Gets the book's body
	 * @return a <code>ArrayList</code> specify the body
	 */
	public ArrayList<String> getBody() {
		return body;
	}

	/**
	 * Sets the book's body
	 * @param body The new body
	 */
	public void setBody(ArrayList<String> body) {
		this.body = body;
	}

	public abstract Type getType();
}
