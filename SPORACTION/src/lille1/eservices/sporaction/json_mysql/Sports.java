package lille1.eservices.sporaction.json_mysql;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lille1.eservices.sporaction.model.Sport;

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

public class Sports {
	public static final String KEY_ID = "id";
	public static final String KEY_NOM = "nom";
	public static final String KEY_MIN_PARTICIPANTS = "minParticipants";
	public static final String KEY_MAX_PARTICIPANTS = "maxParticipants";
	public static final String KEY_MATERIELS = "materiels";
	public static final String TABLE_NAME = "Sport";
	public static final String KEY_URL = "http://ouannane.com/platine_mounir/scriptDb.php";
	public static final String KEY_SUCCESS = "success";
	public static final String KEY_ERROR_MSG = "error_msg";

	JSONObject jObj;
	JSONArray jArr;

	public Sports() {

	}

	// Attendre Validation du tag
	public ArrayList<String> insert(Sport sport) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "registerSport"));
		nameValuePairs.add(new BasicNameValuePair(KEY_NOM, sport.getNom()));
		nameValuePairs.add(new BasicNameValuePair(KEY_MIN_PARTICIPANTS, sport
				.getMinParticipants() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_MAX_PARTICIPANTS, sport
				.getMaxParticipants() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_MATERIELS, sport
				.getMateriels()));

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
	public ArrayList<String> update(Sport sport) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "registerSport"));
		nameValuePairs.add(new BasicNameValuePair(KEY_ID, sport.getId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_NOM, sport.getNom()));
		nameValuePairs.add(new BasicNameValuePair(KEY_MIN_PARTICIPANTS, sport
				.getMinParticipants() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_MAX_PARTICIPANTS, sport
				.getMaxParticipants() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_MATERIELS, sport
				.getMateriels()));

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
		nameValuePairs.add(new BasicNameValuePair("tag", "deleteSport"));
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
	public ArrayList<Sport> getSports() {
		ArrayList<Sport> list = new ArrayList<Sport>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listSport"));

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
				Sport sport = new Sport();

				jObj = jArr.getJSONObject(i);

				sport.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				sport.setNom(jObj.getString(KEY_NOM));
				sport.setMinParticipants(jObj.getInt(KEY_MIN_PARTICIPANTS));
				sport.setMaxParticipants(jObj.getInt(KEY_MAX_PARTICIPANTS));
				sport.setMateriels(jObj.getString(KEY_MATERIELS));
				list.add(sport);
			}

		} catch (Exception e) {
		}

		return list;
	}

	// Attendre Validation du tag
	public Sport getSportById(int id) {
		Sport sport = new Sport();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "partie"));
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

			sport.setId(Integer.parseInt(jObj.getString(KEY_ID)));
			sport.setNom(jObj.getString(KEY_NOM));
			sport.setMinParticipants(jObj.getInt(KEY_MIN_PARTICIPANTS));
			sport.setMaxParticipants(jObj.getInt(KEY_MAX_PARTICIPANTS));
			sport.setMateriels(jObj.getString(KEY_MATERIELS));

		} catch (Exception e) {
		}

		return sport;
	}

	// Attendre Validation du tag
	public Sport getSportByNom(String nom) {
		Sport sport = new Sport();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "partie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_NOM, nom));

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

			sport.setId(Integer.parseInt(jObj.getString(KEY_ID)));
			sport.setNom(jObj.getString(KEY_NOM));
			sport.setMinParticipants(jObj.getInt(KEY_MIN_PARTICIPANTS));
			sport.setMaxParticipants(jObj.getInt(KEY_MAX_PARTICIPANTS));
			sport.setMateriels(jObj.getString(KEY_MATERIELS));

		} catch (Exception e) {
		}

		return sport;
	}

}
