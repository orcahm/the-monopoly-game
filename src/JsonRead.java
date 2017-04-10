import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * 
 * @author orcahm
 *
 */
public abstract class JsonRead{
	
	JSONObject obj;
	
	public JsonRead(String fileName) throws IOException, ParseException{
		
		FileReader fr = new FileReader(new File(fileName));
		JSONParser parser = new JSONParser();
		obj = (JSONObject) parser.parse(fr);
	}
	/**
	 *function which is splitting json file
	 * @param str
	 */
	public abstract void putArray(String str);
}
