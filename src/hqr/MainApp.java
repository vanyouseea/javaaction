package hqr;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import hqr.util.Brower;

public class MainApp {
	public static void main(String[] args) {
		
		if(args==null||args.length==0) {
			System.out.println("No args, exist program");
		}
		else {
			try(CloseableHttpClient httpclient = Brower.getCloseableHttpClient();) {
				System.out.println("Start to access "+ args[0]);
				HttpClientContext httpClientContext = Brower.getHttpClientContext();
				HttpGet get = new HttpGet(args[0]);
				CloseableHttpResponse cl = httpclient.execute(get, httpClientContext);
				String html = EntityUtils.toString(cl.getEntity(), "UTF-8");
				System.out.println(html);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
