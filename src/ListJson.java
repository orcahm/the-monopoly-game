import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * list.json file is reading in this class
 * @author Ahmet Oruc
 *
 */
public class ListJson extends JsonRead{

	private ArrayList<String> chanceList;
	private ArrayList<String> communityChestList;

	public ListJson(String fileName) throws IOException, ParseException {
		super(fileName);
		chanceList = new ArrayList<String>();
		communityChestList = new ArrayList<String>();
		putArray("chanceList");
		putArray("communityChestList");
	
	}
	
	public void putArray(String str){
		JSONArray array =  (JSONArray) super.obj.get(str);
		if(array==null) return;
			for(int i=0;i<array.size();i++){
				JSONObject temp = (JSONObject)array.get(i);
				if(str.equals("chanceList")) {
					chanceList.add((String)temp.get("item"));
				}
				else {
					communityChestList.add((String)temp.get("item"));
				}
			}
	}


	public String getCommunityChestList(int index) {
		return communityChestList.get(index);
	}

	public String getChanceList(int index) {
		return chanceList.get(index);
	}

	
	
	public ArrayList<String> getChanceList() {
		return chanceList;
	}

	public void setChanceList(ArrayList<String> chanceList) {
		this.chanceList = chanceList;
	}

	public ArrayList<String> getCommunityChestList() {
		return communityChestList;
	}

	public void setCommunityChestList(ArrayList<String> communityChestList) {
		this.communityChestList = communityChestList;
	}

}
