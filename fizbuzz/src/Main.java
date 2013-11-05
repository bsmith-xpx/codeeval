import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */

/**
 * Submission for code eval Fizz Buzz Challenge  https://www.codeeval.com/open_challenges/1/
 * 
 * @author Brian Smith
 */
public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class.getName()); 

	public static void main(String[] args) {
		Path file = Paths.get(args[0]);
		try(BufferedReader reader = Files.newBufferedReader(file, Charset.forName("UTF-8"))){
			String line = reader.readLine();
			while (line != null) {
				FizBuzz fizbuzz = new FizBuzz(line.split(" "));
				System.out.println(fizbuzz.getFizBuzzSequence());
				line= reader.readLine();
			}
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Unable to read the file " + file.toString());
		}
	}
	
/**
 * Class that represents a round of fizz buzz.  Takes the divisor for fizz, buzz and the max number to
 * count to.
 * 
 * @author Brian Smith
 *
 */
public static class FizBuzz{
		
		private int fizz;
		private int buzz;
		private int max;
		
		/**
		 * Constructor for the FizBuzz object 
		 * 
		 * @param inputSet array of strings containing the fizz divisor the buzz divisor and the max value to count to
		 * 
		 */
		public FizBuzz(String[] inputSet){
			this.fizz = Integer.parseInt(inputSet[0]);
			this.buzz = Integer.parseInt(inputSet[1]);
			this.max = Integer.parseInt(inputSet[2]);
		}
		
		/**
		 * Returns the string sequence for the fizz buzz round this object represents. 
		 * 
		 * @return a fizz buzz round. 
		 */
		public String getFizBuzzSequence(){
			StringBuilder stringBuilder = new StringBuilder();
			
			for (int i = 1 ; i <= max; i++) {
				if(i % fizz == 0 ){
					stringBuilder.append("F");
				}
				if (i % buzz == 0) {
					stringBuilder.append("B");
				}
				if ( stringBuilder.lastIndexOf(" ") == stringBuilder.length() - 1 ){
					stringBuilder.append(i);
				}
				stringBuilder.append(" ");
			}
			
			return stringBuilder.toString().trim();
		}
		
	}
	
}


