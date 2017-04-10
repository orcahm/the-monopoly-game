import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * @author Ahmet Oruc
 * To read the file was created.
 */
public class ReadFile {

	public ArrayList<String> line;
	/**
	 * Creat a ReadFile object.
	 */
	public ReadFile(){
		line = new ArrayList<String>();
	}
	/**
	 * File reads ".txt" extension.
	 * @param txtName File's name.
	 * @throws IOException The error occurs when it can not find the file.
	 */
	public void read(String txtName) throws IOException{
		
		String str = null;
		
		try{
		
			FileInputStream file = new FileInputStream(txtName);
			DataInputStream dStream = new DataInputStream(file);
			BufferedReader bRead = new BufferedReader(new InputStreamReader(dStream));
			
			while((str = bRead.readLine()) != null){
				this.line.add(str);
			}
			
		}catch(Exception e){
			System.err.println("Hata : " + e.getMessage());
		}
		
	
	}
}