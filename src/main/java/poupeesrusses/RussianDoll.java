package poupeesrusses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class RussianDoll {
	
	private RussianDoll doll1;
	
	private RussianDoll doll2;
	
	private String dollName;

	public RussianDoll(URL file) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(file.openStream()));
		
		String line;
		RussianDoll rd = this;
		rd.setDollName("ADELINE");
		
		//It is obviously not using the recommended solution that YOU should be using
		StringBuilder sb = new StringBuilder();
		while((line = reader.readLine()) != null){
			sb.append(line+";");
		}
		
		ArrayList<String> names = new ArrayList<>(Arrays.asList(sb.toString().split(";")));
		this.initiate(names);
		
		reader.close();		
	}
	
	/**
	 * Initialisation des russian dolls
	 * @param names
	 */
	private void initiate(ArrayList<String> names){
		String name;

		if(!names.isEmpty()){
			name = names.get(0);
			this.setDoll1(new RussianDoll(name));
			names.remove(0);
		}
		
		if(!names.isEmpty()){
			name = names.get(0);
			this.setDoll2(new RussianDoll(name));
			names.remove(0);
		}
		
		if(names.isEmpty()){
			return;
		}		
		
		Double half = Math.floor(names.size() / 2d);
		ArrayList<String> arrayFirstHalf = new ArrayList<>(names.subList(0, half.intValue()));
		ArrayList<String> arraySecondHalf = new ArrayList<>(names.subList(half.intValue(), names.size()));
		
		this.getDoll1().initiate(arrayFirstHalf);
		this.getDoll2().initiate(arraySecondHalf);
	}
	
	public RussianDoll(String dollName){
		this.dollName = dollName;
	}

	public RussianDoll getDoll1() {
		return doll1;
	}

	public void setDoll1(RussianDoll doll1) {
		this.doll1 = doll1;
	}

	public RussianDoll getDoll2() {
		return doll2;
	}

	public void setDoll2(RussianDoll doll2) {
		this.doll2 = doll2;
	}

	public String getDollName() {
		return dollName;
	}

	public void setDollName(String dollName) {
		this.dollName = dollName;
	}
	
	@Override
	public String toString() {
	
		StringBuilder sb = new StringBuilder();
		sb.append(this.dollName + ": ");
		if(doll1 != null){
			sb.append(doll1.getDollName() + " ");
		}
		if(doll2 != null){
			sb.append(doll2.getDollName());
		}
		sb.append("\r\n");
		
		if(doll1 != null){
			sb.append(doll1.toString());
		}
		if(doll2 != null){
			sb.append(doll2.toString());
		}
		
		return sb.toString();  
	}
	
}
