package lille1.eservices.sporaction.json_mysql;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lille1.eservices.sporaction.model.Profil_Sport;

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

public class Profils_Sports {
	public static final String KEY_ID = "id";
	public static final String KEY_PROFIL_ID = "profilId";
	public static final String KEY_SPORT_ID = "sportId";
	public static final String KEY_NIVEAU = "niveau";
	public static final String TABLE_NAME = "Profil_Sport";
	public static final String KEY_URL = "http://ouannane.com/platine_mounir/scriptDb.php";
	public static final String KEY_SUCCESS = "success";
	public static final String KEY_ERROR_MSG = "error_msg";

	JSONObject jObj;
	JSONArray jArr;

	public Profils_Sports() {

	}

	// Attendre Validation du tag
	public ArrayList<String> insert(Profil_Sport profil_sport) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs
				.add(new BasicNameValuePair("tag", "registerProfilSport"));
		nameValuePairs.add(new BasicNameValuePair(KEY_PROFIL_ID, profil_sport
				.getProfilId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_SPORT_ID, profil_sport
				.getSportId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_NIVEAU, profil_sport
				.getNiveau()));

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
	public ArrayList<String> update(Profil_Sport profil_sport) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs
				.add(new BasicNameValuePair("tag", "registerProfilSport"));
		nameValuePairs.add(new BasicNameValuePair(KEY_ID, profil_sport.getId()
				+ ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_PROFIL_ID, profil_sport
				.getProfilId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_SPORT_ID, profil_sport
				.getSportId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_NIVEAU, profil_sport
				.getNiveau()));

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
	public ArrayList<Profil_Sport> getProfilsBySport(int sportId) {
		ArrayList<Profil_Sport> list = new ArrayList<Profil_Sport>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listProfilSport"));
		nameValuePairs.add(new BasicNameValuePair(KEY_SPORT_ID, sportId + ""));

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
				Profil_Sport profil_sport = new Profil_Sport();

				jObj = jArr.getJSONObject(i);

				profil_sport.setId(jObj.getInt(KEY_ID));
				profil_sport.setProfilId(jObj.getInt(KEY_PROFIL_ID));
				profil_sport.setSportId(jObj.getInt(KEY_SPORT_ID));
				profil_sport.setNiveau(jObj.getString(KEY_NIVEAU));
				list.add(profil_sport);

			}

		} catch (Exception e) {
		}

		return list;
	}

	// Attendre Validation du tag
	public ArrayList<Profil_Sport> getSportsByProfil(int profilId) {
		ArrayList<Profil_Sport> list = new ArrayList<Profil_Sport>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listProfilSport"));
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
				Profil_Sport profil_sport = new Profil_Sport();

				jObj = jArr.getJSONObject(i);

				profil_sport.setId(jObj.getInt(KEY_ID));
				profil_sport.setProfilId(jObj.getInt(KEY_PROFIL_ID));
				profil_sport.setSportId(jObj.getInt(KEY_SPORT_ID));
				profil_sport.setNiveau(jObj.getString(KEY_NIVEAU));
				list.add(profil_sport);

			}

		} catch (Exception e) {
		}

		return list;
	}

	// Attendre Validation du tag
	public ArrayList<Profil_Sport> getProfilsBySportAndNiveau(int profilId,
			String niveau) {
		ArrayList<Profil_Sport> list = new ArrayList<Profil_Sport>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listProfilSport"));
		nameValuePairs
				.add(new BasicNameValuePair(KEY_PROFIL_ID, profilId + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_NIVEAU, niveau));

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
				Profil_Sport profil_sport = new Profil_Sport();

				jObj = jArr.getJSONObject(i);

				profil_sport.setId(jObj.getInt(KEY_ID));
				profil_sport.setProfilId(jObj.getInt(KEY_PROFIL_ID));
				profil_sport.setSportId(jObj.getInt(KEY_SPORT_ID));
				profil_sport.setNiveau(jObj.getString(KEY_NIVEAU));
				list.add(profil_sport);

			}

		} catch (Exception e) {
		}

		return list;
	}
}
