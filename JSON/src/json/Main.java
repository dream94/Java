package json;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
	/**
	 * ����Json����
	 */
	public static String createJson(){
		JSONObject json = new JSONObject();
		json.put("classId", 1);      //�༶
		json.put("grade", 1);        //�꼶
		
		JSONArray array = new JSONArray();
		
		JSONObject o1 = new JSONObject();     //��һ��ѧ��
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
		//������ɵ�JSON����
		String s = createJson();
		System.out.println(s);
		
		//����JSON����
		System.out.println("����JSON����:");
		JSONObject obj = new JSONObject(s);       //����json�ı�����JSONObject
		int classId = obj.getInt("classId");
		int grade = obj.getInt("grade");
		JSONArray array = (JSONArray) obj.get("student");
		for(int t=0; t<array.length(); ++t){
			JSONObject o = (JSONObject)array.get(t);
			String id = o.getString("id");
			String name = o.getString("name");
			//int score = o.getInt("score");   //��Ϊ��һ������û�У��Ҳ����Ļ����׳��쳣
			System.out.println(id+" "+name);//+" "+score);
		}
		
	}

}
