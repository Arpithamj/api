package files;

public class Payload {

	public static String getpayload(String fname,String lname) {
		String payload="{\\r\\n\" + \r\n" + 
				"				\"    \\\"name\\\": \\\"\"+fname+\"\\\",\\r\\n\" + \r\n" + 
				"				\"    \\\"job\\\": \\\"leader\\\"\\r\\n\" + \r\n" + 
				"				\"}";
		return payload;
	}
}
