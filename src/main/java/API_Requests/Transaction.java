package API_Requests;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;

public class Transaction {

	private final String USER_AGENT = "vendor-id:84445";
	static String password;
	static String Key_Encrypt;
	static int amount = 1;
	static int value;
	static int unit_price = 801102;
	static String currency = "IDR";
	static String reference;
	static String final_key;
	public String POST_PARAMS;

	public static void main(String[] args) throws Exception {

		Transaction http = new Transaction();

		// Sending post request
		http.sendingPostRequest();

	}

	// HTTP Post request
	private void sendingPostRequest() throws Exception {
		////#########Pre-Request Script Start##############
		Random rand = new Random();
		value = rand.nextInt((9999 - 999) + 1) + 999;
		password = "v1account/54445/transaction/gold/po" + unit_price + "1"
				+ "2xOmoSpMjzbwnMQ84445MOrtT7TruPFuUIr" + "952Smyxue8SUDjoneqH3";
		System.out.println(password);
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

		// bytes to hex
		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
		}

		Key_Encrypt = sb.toString();
		System.out.println(Key_Encrypt);
		System.out.println(value);
//		reference = "REF-" + value;
		
		////#########Pre-Request Script End##############
		
//		String url = "http://dev-api-core.pluang.com/vendor/v1/account/200000/transaction/gold/po";
		String url= "https://api.sandbox.emasdigi.com/api/vendor/v1/account/54445/transaction/gold/po";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Setting basic post request
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Api-Key", "MTU2MjMyMzk2MzEyNzEwMDAwMjBpa29GZVozdEw1ajNWN0Y=");

	

		String postJsonData = "{\"amount\":" + amount + ",\"unit_price\":" + unit_price + ",\"currency\":" + currency
				+  ",\"signature\":" + Key_Encrypt + "}";

		// Send post request
		con.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postJsonData);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("Sending 'POST' request to URL : " + url);
		System.out.println("Post Data : " + postJsonData);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String output;
		StringBuffer response = new StringBuffer();

		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		in.close();

		// printing result from response
		System.out.println(response.toString());
	}
}