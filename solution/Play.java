/**
 * A subclass of Book
 * @see Book
 * @author XXX
 */
public class Play extends Book {
	private int acts;	// The number of acts
	private int actors;	// The number of actors

	/**
	 * Constructor
	 *
	 * @param title
	 * @param author
	 */
	public Play(String title, String author, int acts, int actors, int year) {
		super(title, author, year);
		this.acts = acts;
		this.actors = actors;
	}

	@Override
	public Type getType() {
		return Type.PLAY;
	}

	/**
	 * Gets the number of acts
	 * @return a <code>int</code> specify the acts
	 */
	public int getActs() {
		return acts;
	}

	/**
	 * Gets the number of actors
	 * @return a <code>int</code> specify the actors
	 */
	public int getActors() {
		return actors;
	}
}
