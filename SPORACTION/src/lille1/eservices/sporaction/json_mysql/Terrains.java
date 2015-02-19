package lille1.eservices.sporaction.json_mysql;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lille1.eservices.sporaction.model.Terrain;

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

public class Terrains {
	public static final String KEY_ID = "id";
	public static final String KEY_NOM = "nom";
	public static final String KEY_ADRESSE = "adresse";
	public static final String KEY_CODEPOSTAL= "codePostal";
	public static final String KEY_VILLE = "ville";
	public static final String TABLE_NAME = "Terrain";
	public static final String KEY_URL = "http://ouannane.com/platine_mounir/scriptDb.php";
	public static final String KEY_SUCCESS = "success";
	public static final String KEY_ERROR_MSG = "error_msg";

	JSONObject jObj;
	JSONArray jArr;

	public Terrains() {

	}

	// Attendre Validation du tag
	public ArrayList<String> insert(Terrain terrain) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "registerTerrain"));
		nameValuePairs.add(new BasicNameValuePair(KEY_NOM, terrain.getNom()));
		nameValuePairs.add(new BasicNameValuePair(KEY_ADRESSE, terrain.getAdresse()));
		nameValuePairs.add(new BasicNameValuePair(KEY_CODEPOSTAL, terrain.getCodePostal()));
		nameValuePairs.add(new BasicNameValuePair(KEY_VILLE, terrain.getVille()));

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
	public ArrayList<String> update(Terrain terrain) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "registerTerrain"));
		nameValuePairs.add(new BasicNameValuePair(KEY_ID, terrain.getId()+""));
		nameValuePairs.add(new BasicNameValuePair(KEY_NOM, terrain.getNom()));
		nameValuePairs.add(new BasicNameValuePair(KEY_ADRESSE, terrain.getAdresse()));
		nameValuePairs.add(new BasicNameValuePair(KEY_CODEPOSTAL, terrain.getCodePostal()));
		nameValuePairs.add(new BasicNameValuePair(KEY_VILLE, terrain.getVille()));

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
		nameValuePairs.add(new BasicNameValuePair("tag", "deleteTerrain"));
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
	public ArrayList<Terrain> getTerrains() {
		ArrayList<Terrain> list = new ArrayList<Terrain>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listTerrain"));

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
				Terrain terrain = new Terrain();

				jObj = jArr.getJSONObject(i);

				terrain.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				terrain.setNom(jObj.getString(KEY_NOM));
				terrain.setAdresse(jObj.getString(KEY_ADRESSE));
				terrain.setCodePostal(jObj.getString(KEY_CODEPOSTAL));
				terrain.setVille(jObj.getString(KEY_VILLE));
				list.add(terrain);
			}

		} catch (Exception e) {
		}

		return list;
	}

	// Attendre Validation du tag
	public Terrain getTerrainById(int id) {
		Terrain terrain = new Terrain();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "terrain"));
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

			terrain.setId(Integer.parseInt(jObj.getString(KEY_ID)));
			terrain.setNom(jObj.getString(KEY_NOM));
			terrain.setAdresse(jObj.getString(KEY_ADRESSE));
			terrain.setCodePostal(jObj.getString(KEY_CODEPOSTAL));
			terrain.setVille(jObj.getString(KEY_VILLE));

		} catch (Exception e) {
		}

		return terrain;
	}

	// Attendre Validation du tag
	public Terrain getTerrainByNom(String nom) {
		Terrain terrain = new Terrain();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "terrain"));
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

			terrain.setId(Integer.parseInt(jObj.getString(KEY_ID)));
			terrain.setNom(jObj.getString(KEY_NOM));
			terrain.setAdresse(jObj.getString(KEY_ADRESSE));
			terrain.setCodePostal(jObj.getString(KEY_CODEPOSTAL));
			terrain.setVille(jObj.getString(KEY_VILLE));

		} catch (Exception e) {
		}

		return terrain;
	}


	// Attendre Validation du tag
	public ArrayList<Terrain> getTerrainsByCodePostal(String codePostal) {
		ArrayList<Terrain> list = new ArrayList<Terrain>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listTerrain"));
		nameValuePairs.add(new BasicNameValuePair(KEY_CODEPOSTAL, codePostal));
		
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
				Terrain terrain = new Terrain();

				jObj = jArr.getJSONObject(i);

				terrain.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				terrain.setNom(jObj.getString(KEY_NOM));
				terrain.setAdresse(jObj.getString(KEY_ADRESSE));
				terrain.setCodePostal(jObj.getString(KEY_CODEPOSTAL));
				terrain.setVille(jObj.getString(KEY_VILLE));
				list.add(terrain);
			}

		} catch (Exception e) {
		}

		return list;
	}


	// Attendre Validation du tag
	public ArrayList<Terrain> getTerrainsByVille(String ville) {
		ArrayList<Terrain> list = new ArrayList<Terrain>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listTerrain"));
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
				Terrain terrain = new Terrain();

				jObj = jArr.getJSONObject(i);

				terrain.setId(Integer.parseInt(jObj.getString(KEY_ID)));
				terrain.setNom(jObj.getString(KEY_NOM));
				terrain.setAdresse(jObj.getString(KEY_ADRESSE));
				terrain.setCodePostal(jObj.getString(KEY_CODEPOSTAL));
				terrain.setVille(jObj.getString(KEY_VILLE));
				list.add(terrain);
			}

		} catch (Exception e) {
		}

		return list;
	}
}
