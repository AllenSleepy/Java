import javax.swing.*;

public class MainFrame extends JFrame {
	private JTextField fileName;	// Type the name of the document file they want to load
	private JButton loadBtn;		// Load button to cause the file to be loaded
	private JButton displayBtn;		// The display button to check whether a document has already been loaded
	private JButton statusBtn;		// Show status button to display some stats about the document

	/**
	 * Constructor
	 */
	public MainFrame() {
		fileName = new JTextField();
		loadBtn = new JButton("Load");
		displayBtn = new JButton("Display Text");
		statusBtn = new JButton("Show Stats");
		initialize();
	}

	/**
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		// Set the size of the main window
		setTitle("Document Viewer");
		setResizable( false );
		setBounds(300, 300, 320, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Create the first panel
		JPanel topPanel = new JPanel();
		JLabel hint = new JLabel("File Name:");
		hint.setBounds(30, 40, 80, 25);
		fileName.setBounds(100, 40, 140, 25);
		loadBtn.setBounds(100, 70, 100, 25);
		topPanel.add(hint);
		topPanel.add(fileName);
		topPanel.add(loadBtn);
		topPanel.setBounds(10, 10, 285, 135);
		topPanel.setBorder(BorderFactory.createTitledBorder("Load Document"));
		topPanel.setLayout(null);

		// Create the second panel
		JPanel middlePanel = new JPanel();
		middlePanel.setBounds(10, 150, 285, 90);
		displayBtn.setBounds(80, 35, 140, 25);
		middlePanel.add(displayBtn);
		middlePanel.setBorder(BorderFactory.createTitledBorder("Display Text"));
		middlePanel.setLayout(null);

		// Create the third panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(10, 250, 285, 90);
		statusBtn.setBounds(80, 35, 140, 25);
		bottomPanel.add(statusBtn);
		bottomPanel.setBorder(BorderFactory.createTitledBorder("Show Stats"));
		bottomPanel.setLayout(null);

		// Create the main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 320, 400);
		mainPanel.setLayout(null);
		mainPanel.add(topPanel);
		mainPanel.add(middlePanel);
		mainPanel.add(bottomPanel);
		add(mainPanel);
	}

	/**
	 * Gets the load button
	 * @return a <code>JButton</code> to specify the load button
	 */
	public JButton getLoadBtn() {
		return loadBtn;
	}

	/**
	 * Gets the display button
	 * @return a <code>JButton</code> to specify the display button
	 */
	public JButton getDisplayBtn() {
		return displayBtn;
	}

	/**
	 * Gets the status button
	 * @return a <code>JButton</code> to specify the status button
	 */
	public JButton getStatusBtn() {
		return statusBtn;
	}

	/**
	 * Gets the user's entered file name
	 * @return a <code>String</code> specify the file name
	 */
	public String getFileName() {
		return fileName.getText();
	}

	/**
	 * Set the ui visible
	 * @param enable: Display the ui or not
	 */
	public void showUI(boolean enable) {
		setVisible(enable);
	}

	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
}
