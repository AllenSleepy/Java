import javax.swing.*;
import java.awt.*;

public class TextFrame extends JFrame {
	private JTextArea body;	// The body of the document

	/**
	 * Constructor
	 */
	public TextFrame() {
		body = new JTextArea();
		initialize();
	}

	/**
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		// Set the size of the main window
		setTitle("Display Text");
		setResizable( false );
		setBounds(300, 300, 320, 400);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JScrollPane commScrollPanel = new JScrollPane();
		commScrollPanel.setBounds( 10, 10, 285, 340 );
		body.setEnabled( false );
		body.setBackground(Color.DARK_GRAY);
		commScrollPanel.getViewport().add( body );

		add(commScrollPanel);
	}

	/**
	 * Sets the content of the text area
	 * @param book The contents needs to be displayed
	 */
	public void setBody(Book book) {
		body.setText("");
		// Append the text
		for (String line : book.getBody()) {
			body.append(line + "\n");
		}
	}

	/**
	 * Set the ui visible
	 * @param enable: Display the ui or not
	 */
	public void showUI(boolean enable) {
		setVisible(enable);
	}
}
