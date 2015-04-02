import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {

	private String path;
	public int numberOfLines;

	public ReadFile(String file_path) {
		path = file_path;
	}

	public String[] OpenFile() throws IOException {
		FileReader filereader1 = new FileReader(path);
		BufferedReader textReader1 = new BufferedReader(filereader1);

		numberOfLines = getNumberOfLines();
		String[] textData = new String[numberOfLines];

		for (int i = 0; i < numberOfLines; i++) {
			textData[i] = textReader1.readLine();
		}
		textReader1.close();
		return textData;
	}

	public int getNumberOfLines() throws IOException {
		FileReader file_to_read = new FileReader(path);
		BufferedReader bufferedReader2 = new BufferedReader(file_to_read);

		String line;
		int numberOfLines = 0;

		while ((line = bufferedReader2.readLine()) != null) {
			numberOfLines++;
		}
		bufferedReader2.close();
		return numberOfLines;

	}

}