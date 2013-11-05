import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author brian
 * 
 * Code Eval Solution for the N Mod M problem found here https://www.codeeval.com/open_challenges/62/
 *
 */
public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		Path file = Paths.get(args[0]);
		try(BufferedReader reader = Files.newBufferedReader(file, Charset.forName("UTF-8"))){
			String line = reader.readLine();
			while (line != null) {
				String[] input = line.split(",");
				System.out.println(mod(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
				line = reader.readLine();
			}
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Unable to read the file " + file.toString());
		}

	}
	
	/** 
	 * Calculates the mod of a value and a divisor
	 * 
	 * @param value the value to get the mod from 
	 * @param divisor the divisor to calculate the mod
	 * @return the mod of the two numbers passed in
	 */
	private static int mod(int value, int divisor){
		return value-((divisor*(value/divisor)));
	}

}
