import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * property.json file is read in thic class
 * @author Ahmet Oruc
 *
 */
public class PropertyJson extends JsonRead{
	
	private ArrayList<Integer> id;
	private ArrayList<String> name;
	private ArrayList<Integer> cost;
	
	public PropertyJson(String fileName) throws IOException, ParseException {
		super(fileName);
		this.id = new ArrayList<Integer>();
		this.name = new ArrayList<String>();
		this.cost = new ArrayList<Integer>();
		for(int i=1;i<4;i++){
			putArray(Integer.toString(i));
		}
			
	}

	public void putArray(String str){
		JSONArray array =  (JSONArray) super.obj.get(str);
		if(array==null) return;
			for(int i=0;i<array.size();i++){
				JSONObject temp = (JSONObject)array.get(i);
				this.id.add(Integer.parseInt((String) temp.get("id")));
				this.name.add((String) temp.get("name"));
				this.cost.add(Integer.parseInt((String) temp.get("cost")));
			}
	}
	
	public void clear(){
		this.id.clear();
		this.name.clear();
		this.cost.clear();
	}
	
	public int getId(int index) {
		return id.get(index);
	}
	
	public String getName(int index) {
		return name.get(index);
	}

	public int getCost(int index) {
		return cost.get(index);
	}
	
	public ArrayList<Integer> getId() {
		return id;
	}

	public void setId(ArrayList<Integer> id) {
		this.id = id;
	}

	public ArrayList<String> getName() {
		return name;
	}

	public void setName(ArrayList<String> name) {
		this.name = name;
	}

	public ArrayList<Integer> getCost() {
		return cost;
	}

	public void setCost(ArrayList<Integer> cost) {
		this.cost = cost;
	}

}
