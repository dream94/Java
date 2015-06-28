package json;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
	/**
	 * 生成Json数据
	 */
	public static String createJson(){
		JSONObject json = new JSONObject();
		json.put("classId", 1);      //班级
		json.put("grade", 1);        //年级
		
		JSONArray array = new JSONArray();
		
		JSONObject o1 = new JSONObject();     //第一个学生
		o1.put("id", "101");
		o1.put("name", "zhangsan");
		array.put(o1);
		
		JSONObject o2 = new JSONObject();
		o2.put("id", "102");
		o2.put("name", "lisi");
		o2.put("score", 100);
		array.put(o2);
		
		json.put("student", array);
		return json.toString();
	}
	public static void main(String[] args) {
		//输出生成的JSON数据
		String s = createJson();
		System.out.println(s);
		
		//解析JSON数据
		System.out.println("解析JSON数据:");
		JSONObject obj = new JSONObject(s);       //根据json文本生成JSONObject
		int classId = obj.getInt("classId");
		int grade = obj.getInt("grade");
		JSONArray array = (JSONArray) obj.get("student");
		for(int t=0; t<array.length(); ++t){
			JSONObject o = (JSONObject)array.get(t);
			String id = o.getString("id");
			String name = o.getString("name");
			//int score = o.getInt("score");   //因为有一个数据没有，找不到的话会抛出异常
			System.out.println(id+" "+name);//+" "+score);
		}
		
	}

}
