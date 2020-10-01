import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StatusFrame extends JFrame {
	private JLabel hint;
	private JTextField words;	// The number of words in document
	private JTextArea frequency;// Display high frequency words

	/**
	 * Constructor
	 */
	public StatusFrame() {
		hint = new JLabel("Total Words:");
		words = new JTextField();
		frequency = new JTextArea();
		initialize();
	}

	/**
	 * Set the ui visible
	 * @param enable: Display the ui or not
	 */
	public void showUI(boolean enable) {
		setVisible(enable);
	}

	/**
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		// Set the size of the main window
		setTitle("Show Stats");
		setResizable( false );
		setBounds(300, 300, 320, 400);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Create top panel
		JPanel topPanel = new JPanel();
		topPanel.setBounds(10, 10, 285, 60);
		hint.setBounds(25, 25, 120, 25);
		topPanel.add(hint);
		words.setEnabled(false);
		words.setBounds(150, 25, 120, 25);
		topPanel.add(words);
		topPanel.setLayout(null);

		JLabel caption = new JLabel("Frequency Table");
		caption.setFont(new Font("Serif", Font.BOLD, 24));
		caption.setBounds(70, 80, 180, 25);

		// Create bottom panel
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setBounds( 18, 125, 280, 235 );
		frequency.setEnabled( false );
		frequency.setBackground(Color.DARK_GRAY);
		scrollPanel.getViewport().add( frequency );

		// Create the main panel and add the top and bottom panels
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 320, 400);
		mainPanel.add(topPanel);
		mainPanel.add(caption);
		mainPanel.add(scrollPanel);
		mainPanel.setLayout(null);
		add(mainPanel);
	}


	/**
	 * Sets the content of the text area
	 * @param book The contents needs to be displayed
	 */
	public void setBody(Book book) {
		frequency.setText("");
		List<String> stringList = new ArrayList<>();
		List<Integer> integerList = new ArrayList<>();
		int totalWords = WordCount.topOccurrence(book, 10, stringList, integerList);
		words.setText(String.valueOf(totalWords));
		for (int i = 0; i < integerList.size(); i++) {
			frequency.append(stringList.get(i) + ": " + integerList.get(i) + "\n");
		}
	}
}
