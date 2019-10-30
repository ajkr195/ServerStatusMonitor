package com.servermonitor.tool.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servermonitor.tool.model.MyServer;
import com.sun.net.ssl.SSLContext;

@RestController
@RequestMapping("/api/server")
public class MyRestController {

	@SuppressWarnings("unused")
	private static String myurls;

	@Autowired
	public MyRestController(Environment environment) {
		myurls = environment.getProperty("myurls");
	}

	Map<Long, MyServer> serverStores = new HashMap<Long, MyServer>();

	@PostConstruct
	public void initIt() throws Exception {

		String[] myurlsArray = myurls.split("\\|");

		for (int i = 0; i < myurlsArray.length; i++) {

			URL url = new URL(myurlsArray[i]);

			serverStores.put(Long.valueOf(i), new MyServer(Long.valueOf(1+i), myurlsArray[i], getHostName(url),
					getHostAuthority(url), getHostProtocol(url), getHostort(url), isPortUp(url), getSearchText(url)));

		}
	}

	@GetMapping(value = "/all")
	public List<MyServer> getResource() {

		List<MyServer> serverList = serverStores.entrySet().stream().map(entry -> entry.getValue())
				.collect(Collectors.toList());

		return serverList;
	}

	public static String getHostName(URL url) throws IOException {
		return url.getHost();
	}

	public static String getHostAuthority(URL url) throws IOException {
		return url.getAuthority();
	}

	public static String getHostProtocol(URL url) throws IOException {
		return url.getProtocol();
	}

	public static int getHostort(URL url) throws IOException {
		return url.getPort();
	}

	public static boolean isPortUp(URL url) throws IOException {
		if ((url.getPort() == -1) || (url.getPort() >= 0)) {
			return true;
		}
		return false;
	}

	public static String getSearchText(URL url) throws Exception {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder response = new StringBuilder();
		String inputLine;
		String someStr = null;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		in.close();
		if (response.toString().contains("google")) {
			someStr = "FOUND";
			return someStr;
		}
		someStr = "NOT FOUND";
		return someStr;
	}
	
//	public static void getServerDetails(String webPageURL) throws IOException {
//		URL url = new URL(webPageURL);
//		System.out.println("Protocol :: " + url.getProtocol());
//		System.out.println("Authority :: " + url.getAuthority());
//		System.out.println("Host :: " + url.getHost());
//		System.out.println("Port :: " + url.getPort());
//		System.out.println("Path :: " + url.getPath());
//		System.out.println("Query :: " + url.getQuery());
//		System.out.println("Filename :: " + url.getFile());
//		System.out.println("Ref :: " + url.getRef());
//		System.out.println("UserInfo :: " + url.getUserInfo());
//		System.out.println("ContentObject :: " + url.getContent() + "\n");
//	}
//
//	public static String getWebPageText(String webPageURL) throws Exception {
//		URL url = new URL(webPageURL);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		StringBuilder response = new StringBuilder();
//		String inputLine;
//		while ((inputLine = in.readLine()) != null)
//			response.append(inputLine);
//		in.close();
//		return response.toString();
//	}
//
//	public static void displayWebPageContent(String webPageURL) throws Exception {
//		URL url = new URL(webPageURL);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		StringBuilder response = new StringBuilder();
//		String inputLine;
//		while ((inputLine = in.readLine()) != null)
//			response.append(inputLine);
//		in.close();
//		System.err.println(response.toString());
//	}
//
//	public static void showWebPageContent(String webPageURL) throws Exception {
//		URL url = new URL(webPageURL);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		String inputLine;
//		while ((inputLine = in.readLine()) != null) {
//			System.out.println(inputLine);
//		}
//		in.close();
//	}
}
