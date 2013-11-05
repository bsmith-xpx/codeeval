/**
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is an answer to code eval question "lower case" https://www.codeeval.com/open_challenges/20/
 * 
 * This takes a file name as an argument and outputs to the standard output all of the text in lower case. 
 * 
 * @author Brian Smith
 *
 */
public class Main {
	
	private static final Logger LOG = Logger.getLogger(Main.class.getName()); 
	
	/**
	 * The Main Method that runs the program
	 * 
	 * @param args the first argument should be the name of the file to lower case. 
	 */
	public static void main(String[] args) {
		//Using Java 7 nio and auto closeable try catch blocks. 
		Path file = Paths.get(args[0]);
		try(BufferedReader reader = Files.newBufferedReader(file, Charset.forName("UTF-8"))){
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line.toLowerCase());
				line = reader.readLine();
			}
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Unable to read the file " + file.toString());
		}
	}

}
