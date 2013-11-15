import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author brian
 * 
 *
 */
public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		Path file = Paths.get(args[0]);
		try(BufferedReader reader = Files.newBufferedReader(file, Charset.forName("UTF-8"))){
			String line = reader.readLine();
			while (line != null) {
				//get the characters and alphabetize them 
				List<Character> chars = new ArrayList<>();
				for (char character : line.toCharArray()){
					chars.add(character);
				}
				Collections.sort(chars);
				
				System.out.println(permiatate(new ArrayList<String>(),chars));
				line = reader.readLine();
			}
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Unable to read the file " + file.toString());
		}

	}
	
	
	private static String permiatate(List<String> current, List<Character> characters){
		Collections.sort(characters);
		
		List<String> values = new ArrayList<>();
		//if the current list is empty then just add the current strings
		if (current.isEmpty()){
			for (Character character : characters) {
				values.add(character.toString());
			}
		//otherwise add each character in order to every current value.  This relys on the character
		//list being in the right order
		}else {
			for (String value : current){
				for(Character character : characters){
					if (!value.contains(character.toString())){
						values.add(value + character);
					}
				}
				
			}
		}
		
		//if our values are as long as the number of characeters we are using then create our string. 
		if (values.get(0).length() >= characters.size()){
			StringBuilder builder = new StringBuilder();
			for(String value : values){
				builder.append(value);
				builder.append(",");
			}
			//need to ignore the last comma
			return builder.substring(0, builder.length() -1);
		//otherwise recurse with our new list of values. 
		} else {
			return permiatate(values, characters);
		}	
	}
}
