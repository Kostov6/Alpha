package endpoints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 * Servlet implementation class GitAuth
 */
@WebServlet("/GitAuth")
public class GitAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GitAuth() {}

	private static final String CLIENT_ID="099b3b26927004bc8273";
	private static final String CLIENT_SECRET="221fb6a5ad8c6aa01f1f7efdb32ae6dd1667f3bc";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		System.out.print("Got code " + code);
		System.out.println("and reposting to https://github.com/login/oauth/access_token ...");
		try {
			JsonObject tokenJson=repostAndGetToken(code,CLIENT_ID,CLIENT_SECRET,null);
			String token=tokenJson.getString("access_token");
			System.out.println("Access-token: "+token);
			System.out.println(request.getSession().getAttribute("git_access_token"));
			request.getSession().setAttribute("git_access_token", token);
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
	}
	
	private JsonObject repostAndGetToken(String code,String clientId,String clientSecret,String state) throws IOException, URISyntaxException
	{
		JsonObject object=null;
		try(CloseableHttpClient defClient=HttpClients.createDefault()){
			HttpGet get=new HttpGet("https://github.com/login/oauth/access_token");
		
			//setting parameters for post method
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("client_id", clientId));
			params.add(new BasicNameValuePair("client_secret", clientSecret));
			params.add(new BasicNameValuePair("code", code));
			if(state!=null) {
				params.add(new BasicNameValuePair("state", state));
			}
			//params.add(new BasicNameValuePair("redirect_uri ", ""));
	
			get.setHeader("Accept", "application/json");
			URI uri = new URIBuilder(get.getURI()).addParameters(params).build();
			get.setURI(uri);
			
			HttpResponse response = defClient.execute(get);
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				try(BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()))){
				//not safe code block
					JsonReader reader= Json.createReader(new StringReader(br.readLine()));
					object=reader.readObject();
				}
			}
		}
		return object;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
