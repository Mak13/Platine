package lille1.eservices.sporaction.json_mysql;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lille1.eservices.sporaction.model.Profil_Partie;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class Profils_Parties {
	public static final String KEY_ID = "id";
	public static final String KEY_PROFIL_ID = "profilId";
	public static final String KEY_PARTIE_ID = "partieId";
	public static final String TABLE_NAME = "Profil_Partie";
	public static final String KEY_TYPE = "type";
	public static final String KEY_URL = "http://ouannane.com/platine_mounir/scriptDb.php";
	public static final String KEY_SUCCESS = "success";
	public static final String KEY_ERROR_MSG = "error_msg";

	JSONObject jObj;
	JSONArray jArr;

	public Profils_Parties() {

	}

	// Attendre Validation du tag
	public ArrayList<String> insert(Profil_Partie profil_partie) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs
				.add(new BasicNameValuePair("tag", "registerProfilPartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_PARTIE_ID, profil_partie
				.getPartieId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_PROFIL_ID, profil_partie
				.getProfilId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_TYPE, profil_partie
				.getType()));

		try {
			/*************************/
			/* Request to the server */
			/*************************/
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(KEY_URL);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			sb.append(line + "\n");
			is.close();

			/****************/
			/* Get response */
			/****************/
			String result = sb.toString();
			jObj = new JSONObject(result);

			res.add(jObj.getString(KEY_SUCCESS));
			res.add(jObj.getString(KEY_ERROR_MSG));
		} catch (Exception e) {
		}

		return res;
	}

	// Attendre Validation du tag
	public ArrayList<String> update(Profil_Partie profil_partie) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs
				.add(new BasicNameValuePair("tag", "registerProfilPartie"));

		nameValuePairs.add(new BasicNameValuePair(KEY_ID, profil_partie.getId()
				+ ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_PARTIE_ID, profil_partie
				.getPartieId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_PROFIL_ID, profil_partie
				.getProfilId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_TYPE, profil_partie
				.getType()));

		try {
			/*************************/
			/* Request to the server */
			/*************************/
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(KEY_URL);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			sb.append(line + "\n");
			is.close();

			/****************/
			/* Get response */
			/****************/
			String result = sb.toString();
			jObj = new JSONObject(result);

			res.add(jObj.getString(KEY_SUCCESS));
			res.add(jObj.getString(KEY_ERROR_MSG));
		} catch (Exception e) {
		}

		return res;
	}

	// Attendre Validation du tag
	public ArrayList<String> delete(int id) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "deleteProfilPartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_ID, id + ""));

		try {
			/*************************/
			/* Request to the server */
			/*************************/
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(KEY_URL);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			sb.append(line + "\n");
			is.close();

			/****************/
			/* Get response */
			/****************/
			String result = sb.toString();
			jObj = new JSONObject(result);

			res.add(jObj.getString(KEY_SUCCESS));
			res.add(jObj.getString(KEY_ERROR_MSG));
		} catch (Exception e) {
		}

		return res;
	}

	// Attendre Validation du tag
	public ArrayList<Profil_Partie> getProfilsByPartie(int partieId) {
		ArrayList<Profil_Partie> list = new ArrayList<Profil_Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listProfilPartie"));
		nameValuePairs
				.add(new BasicNameValuePair(KEY_PARTIE_ID, partieId + ""));

		try {
			/*************************/
			/* Request to the server */
			/*************************/
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(KEY_URL);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			sb.append(line + "\n");
			is.close();

			/****************/
			/* Get response */
			/****************/
			String result = sb.toString();
			jArr = new JSONArray(result);

			for (int i = 0; i < jArr.length(); i++) {
				Profil_Partie profil_partie = new Profil_Partie();

				jObj = jArr.getJSONObject(i);

				profil_partie.setId(jObj.getInt(KEY_ID));
				profil_partie.setProfilId(jObj.getInt(KEY_PROFIL_ID));
				profil_partie.setPartieId(jObj.getInt(KEY_PARTIE_ID));
				profil_partie.setType(jObj.getString(KEY_TYPE));
				list.add(profil_partie);
			}

		} catch (Exception e) {
		}

		return list;
	}

	// Attendre Validation du tag
	public ArrayList<Profil_Partie> getPartiesByProfil(int profilId) {
		ArrayList<Profil_Partie> list = new ArrayList<Profil_Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listProfilPartie"));
		nameValuePairs
				.add(new BasicNameValuePair(KEY_PROFIL_ID, profilId + ""));

		try {
			/*************************/
			/* Request to the server */
			/*************************/
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(KEY_URL);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			sb.append(line + "\n");
			is.close();

			/****************/
			/* Get response */
			/****************/
			String result = sb.toString();
			jArr = new JSONArray(result);

			for (int i = 0; i < jArr.length(); i++) {
				Profil_Partie profil_partie = new Profil_Partie();

				jObj = jArr.getJSONObject(i);

				profil_partie.setId(jObj.getInt(KEY_ID));
				profil_partie.setProfilId(jObj.getInt(KEY_PROFIL_ID));
				profil_partie.setPartieId(jObj.getInt(KEY_PARTIE_ID));
				profil_partie.setType(jObj.getString(KEY_TYPE));
				list.add(profil_partie);
			}

		} catch (Exception e) {
		}

		return list;
	}

	// Attendre Validation du tag
	public ArrayList<Profil_Partie> getPartiesByTypeAndProfil(String type,
			int profilId) {
		ArrayList<Profil_Partie> list = new ArrayList<Profil_Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listProfilPartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_TYPE, type));
		nameValuePairs
				.add(new BasicNameValuePair(KEY_PROFIL_ID, profilId + ""));

		try {
			/*************************/
			/* Request to the server */
			/*************************/
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(KEY_URL);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			sb.append(line + "\n");
			is.close();

			/****************/
			/* Get response */
			/****************/
			String result = sb.toString();
			jArr = new JSONArray(result);

			for (int i = 0; i < jArr.length(); i++) {
				Profil_Partie profil_partie = new Profil_Partie();

				jObj = jArr.getJSONObject(i);

				profil_partie.setId(jObj.getInt(KEY_ID));
				profil_partie.setProfilId(jObj.getInt(KEY_PROFIL_ID));
				profil_partie.setPartieId(jObj.getInt(KEY_PARTIE_ID));
				profil_partie.setType(jObj.getString(KEY_TYPE));
				list.add(profil_partie);
			}

		} catch (Exception e) {
		}

		return list;
	}

	// Attendre Validation du tag
	public ArrayList<Profil_Partie> getAllProfilsParties() {
		ArrayList<Profil_Partie> list = new ArrayList<Profil_Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listProfilPartie"));

		try {
			/*************************/
			/* Request to the server */
			/*************************/
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(KEY_URL);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			sb.append(line + "\n");
			is.close();

			/****************/
			/* Get response */
			/****************/
			String result = sb.toString();
			jArr = new JSONArray(result);

			for (int i = 0; i < jArr.length(); i++) {
				Profil_Partie profil_partie = new Profil_Partie();

				jObj = jArr.getJSONObject(i);

				profil_partie.setId(jObj.getInt(KEY_ID));
				profil_partie.setProfilId(jObj.getInt(KEY_PROFIL_ID));
				profil_partie.setPartieId(jObj.getInt(KEY_PARTIE_ID));
				profil_partie.setType(jObj.getString(KEY_TYPE));
				list.add(profil_partie);
			}

		} catch (Exception e) {
		}

		return list;
	}
}
