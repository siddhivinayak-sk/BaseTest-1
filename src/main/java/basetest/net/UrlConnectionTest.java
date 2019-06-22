package basetest.net;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;

public class UrlConnectionTest {

	
	
	public static void main(String...args) throws Throwable {
		//java.net.InetAddress
		//java.net.ServerSocket
		//java.net.Socket
		
		
		
		
		String keyword = "spiderman";
    	List<Movie> mList = new ArrayList<Movie>();
    	int page = 1;
    	String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + keyword + "&page=";
    	int tpage = 0; 
    	do {
    		Container c1 = getDataFromUrl(url + page);
    		if(null != c1) {
    			if(tpage == 0) {
    				tpage = c1.getTotal_pages();
    			}
    			mList.addAll(c1.getData());
    		}
    		page++;
    	}while(tpage >= page);
    	
    	Collections.sort(mList, new Comparator<Movie>() {
    		public int compare(Movie m1, Movie m2) {
    			return m1.getTitle().compareTo(m2.getTitle());
    		}
		});

    	for(Movie m:mList) {
    		System.out.println(m.getTitle());
    	}
    	
    	String[] arr = new String[mList.size()];
    	int i = 0;
    	for(Movie m:mList) {
    		arr[i] = m.getTitle();
    		i++;
    	}
	}

	
    public static Container getDataFromUrl(String url) throws Throwable {
    	Container retVal = null;
    	String USER_AGENT = "Mozilla/5.0";
    	URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			Gson gson = new Gson();
			if(null != response.toString()) {
				retVal = gson.fromJson(response.toString(), Container.class);
			}
		} else {
			System.out.println("GET request not worked");
		}    	
    	return retVal;
    }
	
	
    class Movie implements Serializable {
    	final private static long serialVersionUID = 1L;
    	
    	private String Poster;
    	private String Title;
    	private String Type;
    	private Integer Year;
    	private String imdbID;
    	
    	
    	public String getPoster() {
    		return Poster;
    	}
    	public void setPoster(String poster) {
    		Poster = poster;
    	}
    	public String getTitle() {
    		return Title;
    	}
    	public void setTitle(String title) {
    		Title = title;
    	}
    	public String getType() {
    		return Type;
    	}
    	public void setType(String type) {
    		Type = type;
    	}
    	public Integer getYear() {
    		return Year;
    	}
    	public void setYear(Integer year) {
    		Year = year;
    	}
    	public String getImdbID() {
    		return imdbID;
    	}
    	public void setImdbID(String imdbID) {
    		this.imdbID = imdbID;
    	}
    }
    
    
    class Container implements Serializable {
    	final private static long serialVersionUID = 1L;
    	
    	private String page;
    	private Integer per_page;
    	private Integer total;
    	private Integer total_pages;
    	private List<Movie> data;
    	public String getPage() {
    		return page;
    	}
    	public void setPage(String page) {
    		this.page = page;
    	}
    	public Integer getPer_page() {
    		return per_page;
    	}
    	public void setPer_page(Integer per_page) {
    		this.per_page = per_page;
    	}
    	public Integer getTotal() {
    		return total;
    	}
    	public void setTotal(Integer total) {
    		this.total = total;
    	}
    	public Integer getTotal_pages() {
    		return total_pages;
    	}
    	public void setTotal_pages(Integer total_pages) {
    		this.total_pages = total_pages;
    	}
    	public List<Movie> getData() {
    		return data;
    	}
    	public void setData(List<Movie> data) {
    		this.data = data;
    	}
    }
    
}
