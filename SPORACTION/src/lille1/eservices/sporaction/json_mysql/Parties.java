package lille1.eservices.sporaction.json_mysql;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lille1.eservices.sporaction.model.Partie;

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

public class Parties {
	public static final String KEY_ID = "id";
	public static final String KEY_DATE = "date";
	public static final String KEY_HORAIRE = "horaire";
	public static final String KEY_SPORT_ID = "sportId";
	public static final String KEY_NIVEAU = "niveau";
	public static final String KEY_VILLE = "ville";
	public static final String KEY_TERRAIN_ID = "terrainId";
	public static final String TABLE_NAME = "Partie";
	public static final String KEY_URL = "http://ouannane.com/platine_mounir/scriptDb.php";
	public static final String KEY_SUCCESS = "success";
	public static final String KEY_ERROR_MSG = "error_msg";
	
	JSONObject jObj;
	JSONArray jArr;

	public Parties() {

	}
	
	// Attendre Validation du tag
	public ArrayList<String> insert(Partie partie) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "registerPartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_DATE, partie
				.getDate()));
		nameValuePairs.add(new BasicNameValuePair(KEY_HORAIRE, partie.getHoraire()));
		nameValuePairs.add(new BasicNameValuePair(KEY_SPORT_ID, partie
				.getSportId()+""));
		nameValuePairs.add(new BasicNameValuePair(KEY_NIVEAU, partie
				.getNiveau()));
		nameValuePairs.add(new BasicNameValuePair(KEY_VILLE, partie
				.getVille()));
		nameValuePairs
				.add(new BasicNameValuePair(KEY_TERRAIN_ID, partie.getVille()));


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
	public ArrayList<String> update(Partie partie) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "updatePartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_ID, partie
				.getId()+""));
		nameValuePairs.add(new BasicNameValuePair(KEY_DATE, partie
				.getDate()));
		nameValuePairs.add(new BasicNameValuePair(KEY_HORAIRE, partie.getHoraire()));
		nameValuePairs.add(new BasicNameValuePair(KEY_SPORT_ID, partie
				.getSportId()+""));
		nameValuePairs.add(new BasicNameValuePair(KEY_NIVEAU, partie
				.getNiveau()));
		nameValuePairs.add(new BasicNameValuePair(KEY_VILLE, partie
				.getVille()));
		nameValuePairs
				.add(new BasicNameValuePair(KEY_TERRAIN_ID, partie.getVille()));


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
		nameValuePairs.add(new BasicNameValuePair("tag", "deletePartie"));
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
	public ArrayList<Partie> getParties() {
		ArrayList<Partie> list = new ArrayList<Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listPartie"));

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
				Partie partie = new Partie();

				jObj = jArr.getJSONObject(i);

				partie.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				partie.setDate(jObj.getString(KEY_DATE));
				partie.setHoraire(jObj.getString(KEY_HORAIRE));
				partie.setNiveau(jObj.getString(KEY_NIVEAU));
				partie.setSportId(jObj.getInt(KEY_SPORT_ID));
				partie.setTerrainId(jObj.getInt(KEY_TERRAIN_ID));
				partie.setVille(jObj.getString(KEY_VILLE));
				list.add(partie);
			}

		} catch (Exception e) {
		}

		return list;
	}
	

	// Attendre Validation du tag
	public ArrayList<Partie> getPartiesByDate(String date) {
		ArrayList<Partie> list = new ArrayList<Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listPartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_DATE, date));

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
				Partie partie = new Partie();

				jObj = jArr.getJSONObject(i);

				partie.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				partie.setDate(jObj.getString(KEY_DATE));
				partie.setHoraire(jObj.getString(KEY_HORAIRE));
				partie.setNiveau(jObj.getString(KEY_NIVEAU));
				partie.setSportId(jObj.getInt(KEY_SPORT_ID));
				partie.setTerrainId(jObj.getInt(KEY_TERRAIN_ID));
				partie.setVille(jObj.getString(KEY_VILLE));
				list.add(partie);
			}

		} catch (Exception e) {
		}

		return list;
	}


	// Attendre Validation du tag
	public ArrayList<Partie> getPartiesByHoraire(String horaire) {
		ArrayList<Partie> list = new ArrayList<Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listPartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_HORAIRE, horaire));

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
				Partie partie = new Partie();

				jObj = jArr.getJSONObject(i);

				partie.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				partie.setDate(jObj.getString(KEY_DATE));
				partie.setHoraire(jObj.getString(KEY_HORAIRE));
				partie.setNiveau(jObj.getString(KEY_NIVEAU));
				partie.setSportId(jObj.getInt(KEY_SPORT_ID));
				partie.setTerrainId(jObj.getInt(KEY_TERRAIN_ID));
				partie.setVille(jObj.getString(KEY_VILLE));
				list.add(partie);
			}

		} catch (Exception e) {
		}

		return list;
	}
	

	// Attendre Validation du tag
	public ArrayList<Partie> getPartiesBySport(int sportId) {
		ArrayList<Partie> list = new ArrayList<Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listPartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_SPORT_ID, sportId+""));

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
				Partie partie = new Partie();

				jObj = jArr.getJSONObject(i);

				partie.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				partie.setDate(jObj.getString(KEY_DATE));
				partie.setHoraire(jObj.getString(KEY_HORAIRE));
				partie.setNiveau(jObj.getString(KEY_NIVEAU));
				partie.setSportId(jObj.getInt(KEY_SPORT_ID));
				partie.setTerrainId(jObj.getInt(KEY_TERRAIN_ID));
				partie.setVille(jObj.getString(KEY_VILLE));
				list.add(partie);
			}

		} catch (Exception e) {
		}

		return list;
	}
	

	// Attendre Validation du tag
	public ArrayList<Partie> getPartiesByNiveau(String niveau) {
		ArrayList<Partie> list = new ArrayList<Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listPartie"));
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
				Partie partie = new Partie();

				jObj = jArr.getJSONObject(i);

				partie.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				partie.setDate(jObj.getString(KEY_DATE));
				partie.setHoraire(jObj.getString(KEY_HORAIRE));
				partie.setNiveau(jObj.getString(KEY_NIVEAU));
				partie.setSportId(jObj.getInt(KEY_SPORT_ID));
				partie.setTerrainId(jObj.getInt(KEY_TERRAIN_ID));
				partie.setVille(jObj.getString(KEY_VILLE));
				list.add(partie);
			}

		} catch (Exception e) {
		}

		return list;
	}


	// Attendre Validation du tag
	public ArrayList<Partie> getPartiesByVille(String ville) {
		ArrayList<Partie> list = new ArrayList<Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listPartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_VILLE, ville));

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
				Partie partie = new Partie();

				jObj = jArr.getJSONObject(i);

				partie.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				partie.setDate(jObj.getString(KEY_DATE));
				partie.setHoraire(jObj.getString(KEY_HORAIRE));
				partie.setNiveau(jObj.getString(KEY_NIVEAU));
				partie.setSportId(jObj.getInt(KEY_SPORT_ID));
				partie.setTerrainId(jObj.getInt(KEY_TERRAIN_ID));
				partie.setVille(jObj.getString(KEY_VILLE));
				list.add(partie);
			}

		} catch (Exception e) {
		}

		return list;
	}


	// Attendre Validation du tag
	public ArrayList<Partie> getPartiesByTerrain(int terrainId) {
		ArrayList<Partie> list = new ArrayList<Partie>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listPartie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_TERRAIN_ID, terrainId+""));

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
				Partie partie = new Partie();

				jObj = jArr.getJSONObject(i);

				partie.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				partie.setDate(jObj.getString(KEY_DATE));
				partie.setHoraire(jObj.getString(KEY_HORAIRE));
				partie.setNiveau(jObj.getString(KEY_NIVEAU));
				partie.setSportId(jObj.getInt(KEY_SPORT_ID));
				partie.setTerrainId(jObj.getInt(KEY_TERRAIN_ID));
				partie.setVille(jObj.getString(KEY_VILLE));
				list.add(partie);
			}

		} catch (Exception e) {
		}

		return list;
	}


	// Attendre Validation du tag
	public Partie getPartieById(int id) {
		Partie partie = new Partie();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "partie"));
		nameValuePairs.add(new BasicNameValuePair(KEY_ID, id+""));

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

			partie.setId(Integer.parseInt(jObj.getString(KEY_ID)));
			partie.setDate(jObj.getString(KEY_DATE));
			partie.setHoraire(jObj.getString(KEY_HORAIRE));
			partie.setNiveau(jObj.getString(KEY_NIVEAU));
			partie.setSportId(jObj.getInt(KEY_SPORT_ID));
			partie.setTerrainId(jObj.getInt(KEY_TERRAIN_ID));
			partie.setVille(jObj.getString(KEY_VILLE));

		} catch (Exception e) {
		}

		return partie;
	}

}
