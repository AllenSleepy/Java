import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responsible for loading the document.
 */
public class FileLoader {
	private static String parseLine(String line) {
		int pos = line.indexOf(':');
		return line.substring(pos + 1).trim();
	}

	/**
	 * Assuming the file format is valid
	 * @param fileName The document's file name
	 * @return NULL if file not found
	 */
	public static Book readFile(String fileName) {
		Book book = null;
		try {
			// The line counter
			int idx = 0;
			String line;
			String[] headers = new String[16];
			ArrayList<String> body = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			// Read the head first
			while ( (line = br.readLine()) != null ) {
				if (line.startsWith("Year")) {
					headers[idx] = parseLine(line);
					// Check the type
					if ("Play".equalsIgnoreCase(headers[0])) {
						book = new Play(headers[1], headers[2],
								Integer.parseInt(headers[3]), Integer.parseInt(headers[4]),
								Integer.parseInt(headers[5]));
					}
					else if ("Novel".equalsIgnoreCase(headers[0])) {
						book = new Novel(headers[1], headers[2],
								Integer.parseInt(headers[3]), Integer.parseInt(headers[4]));
					}
					else if ("Poem".equalsIgnoreCase(headers[0])) {
						book = new Poem(headers[1], headers[2],
								Integer.parseInt(headers[3]), Integer.parseInt(headers[4]));
					}
				}
				else if (book == null) {
					headers[idx] = parseLine(line);
				}
				else {
					if (!line.isEmpty()) {
						body.add(line.trim());
					}
				}

				idx++;
			}
			br.close();
			book.setBody(body);
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}

		return book;
	}
}
