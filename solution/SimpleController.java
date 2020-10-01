import javax.swing.*;

/**
 * A simple controller to connect the view and model
 */
public class SimpleController {
	private Book book;
	private MainFrame mainFrame;
	private TextFrame textFrame;
	private StatusFrame statusFrame;

	/**
	 * Constructor
	 */
	public SimpleController() {
		mainFrame = new MainFrame();
		textFrame = new TextFrame();
		statusFrame = new StatusFrame();
		initialize();
	}

	/**
	 * Attach the event listeners
	 */
	private void initialize() {
		// Add event listener for the load button
		mainFrame.getLoadBtn().addActionListener(e -> {
			String fileName = mainFrame.getFileName();
			if (fileName.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Empty file name.");
			}
			else {
				book = FileLoader.readFile(fileName);
				if (book == null) {
					JOptionPane.showMessageDialog(null, "File not found.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Succeed to load document.");
				}
			}
		});

		// Add event listener for the display button
		mainFrame.getDisplayBtn().addActionListener(e -> {
			if (book == null) {
				JOptionPane.showMessageDialog(null, "Load document first.");
			}
			else {
				// mainFrame.showUI(false);
				textFrame.setBody(book);
				textFrame.showUI(true);
			}
		});

		// Add event listener for the status button
		mainFrame.getStatusBtn().addActionListener(e -> {
			if (book == null) {
				JOptionPane.showMessageDialog(null, "Load document first.");
			}
			else {
				statusFrame.setBody(book);
				statusFrame.showUI(true);
			}
		});
	}

	/**
	 * Launch the application
	 */
	public void launch() {
		mainFrame.showUI(true);
	}
}
