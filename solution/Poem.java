/**
 * A subclass of Book
 * @see Book
 * @author XXX
 */
public class Poem extends Book {
	private int verses;	// The number of verses

	/**
	 * Constructor
	 *
	 * @param title
	 * @param author
	 */
	public Poem(String title, String author, int verses, int year) {
		super(title, author, year);
		this.verses = verses;
	}

	@Override
	public Type getType() {
		return Type.POEM;
	}


	/**
	 * Gets the number of verses
	 * @return a <code>int</code> specify the verses
	 */
	public int getVerses() {
		return verses;
	}
}
