package com.greenfield.nexux_client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



public class NexusClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * try {
		 * 
		 * URL url = new URL(
		 * "http://illin3301:28080/nexus/service/local/lucene/search?q=gvme_client_classes"
		 * ); HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 * conn.setRequestMethod("GET"); conn.setRequestProperty("Accept",
		 * "application/json");
		 * 
		 * if (conn.getResponseCode() != 200) { throw new
		 * RuntimeException("Failed : HTTP error code : " +
		 * conn.getResponseCode()); }
		 * 
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader((conn.getInputStream())));
		 * 
		 * String output; System.out.println("Output from Server .... \n");
		 * while ((output = br.readLine()) != null) {
		 * System.out.println(output); }
		 * 
		 * conn.disconnect();
		 * 
		 * } catch (MalformedURLException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * } catch (IOException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 */
		System.out.println(System.getProperty("user.dir"));
		client();

	}

	private static void client() {
		try {

			// Student st = new Student("Adriana", "Barrer", 12, 9);

			Client client = Client.create();

			WebResource webResource = client

					.resource("http://illin3301:28080/nexus").path("/service/local/lucene/search")
					.queryParam("q", "gvme_client_classes");

			ClientResponse response = webResource.accept("application/xml")

					.get(ClientResponse.class);

			/*
			 * if (response.getStatus() != 200) {
			 * 
			 * throw new RuntimeException("Failed : HTTP error code : "
			 * 
			 * + response.getStatus());
			 * 
			 * }
			 */

			SearchNGResponse output = response.getEntity(SearchNGResponse.class);

			System.out.println(output.getTotalCount());
			System.out.println("Server response : \n");

			System.out.println(output);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	private static void downloadUsingStream(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = bis.read(buffer, 0, 1024)) != -1) {
			fis.write(buffer, 0, count);
		}
		fis.close();
		bis.close();
	}

	private static void downloadUsingNIO(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}

}
