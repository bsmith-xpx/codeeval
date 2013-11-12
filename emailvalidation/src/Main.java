import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class.getName());

	private static final String EMAIL_PATTERN = "((\"[A-Za-z0-9!#$@.%&'+-/=?^_`{|}~]+\")|([A-Za-z0-9!#$%&'+-/=?^_`{|}~]+))@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";
	
	public static void main(String[] args) {
		Path file = Paths.get(args[0]);
		try(BufferedReader reader = Files.newBufferedReader(file, Charset.forName("UTF-8"))){
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line.matches(EMAIL_PATTERN));				
				line = reader.readLine();
			}
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Unable to read the file " + file.toString());
		}

	}

}
