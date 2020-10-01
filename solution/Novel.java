public class Novel extends Book {
	private int chapters;	// The number of chapters

	/**
	 * Constructor
	 * @param chapters
	 * @param year
	 * @param title
	 * @param author
	 */
	public Novel(String title, String author, int chapters, int year) {
		super(title, author, year);
		this.chapters = chapters;
	}

	@Override
	public Type getType() {
		return Type.NOVEL;
	}

	/**
	 * Gets the number of chapters
	 * @return a <code>int</code> specify the chapter
	 */
	public int getChapters() {
		return chapters;
	}
}
