package lille1.eservices.sporaction.json_mysql;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.Integer;

import lille1.eservices.sporaction.model.Profil;

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

import android.util.Log;

public class Profils {
	public static final String KEY_ID = "id";
	public static final String KEY_PSEUDO = "pseudo";
	public static final String KEY_MAIL = "mail";
	public static final String KEY_MOTDEPASSE = "motDePasse";
	public static final String KEY_ADRESSE = "adresse";
	public static final String KEY_CODEPOSTAL = "codePostal";
	public static final String KEY_VILLE = "ville";
	public static final String KEY_PLAGESHORAIRES = "plagesHoraires";
	public static final String KEY_RAYONGEOGRAPHIQUE = "rayonGeographique";
	public static final String KEY_URL = "http://ouannane.com/platine_mounir/scriptDb.php";
	public static final String KEY_SUCCESS = "success";
	public static final String KEY_ERROR_MSG = "error_msg";

	JSONObject jObj;
	JSONArray jArr;

	public Profils() {

	}

	public ArrayList<String> insert(Profil profil) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "register"));
		nameValuePairs.add(new BasicNameValuePair(KEY_PSEUDO, profil
				.getPseudo()));
		nameValuePairs.add(new BasicNameValuePair(KEY_MAIL, profil.getMail()));
		nameValuePairs.add(new BasicNameValuePair(KEY_MOTDEPASSE, profil
				.getMotDePasse()));
		nameValuePairs.add(new BasicNameValuePair(KEY_ADRESSE, profil
				.getAdresse()));
		nameValuePairs.add(new BasicNameValuePair(KEY_CODEPOSTAL, profil
				.getCodePostal()));
		nameValuePairs
				.add(new BasicNameValuePair(KEY_VILLE, profil.getVille()));
		nameValuePairs.add(new BasicNameValuePair(KEY_PLAGESHORAIRES, profil
				.getPlagesHoraires()));
		nameValuePairs.add(new BasicNameValuePair(KEY_RAYONGEOGRAPHIQUE, profil
				.getRayonGeographique()));

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

	public ArrayList<String> update(Profil profil) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "editProfil"));
		nameValuePairs.add(new BasicNameValuePair(KEY_ID, profil.getId() + ""));
		nameValuePairs.add(new BasicNameValuePair(KEY_PSEUDO, profil
				.getPseudo()));
		nameValuePairs.add(new BasicNameValuePair(KEY_MAIL, profil.getMail()));
		nameValuePairs.add(new BasicNameValuePair(KEY_MOTDEPASSE, profil
				.getMotDePasse()));
		nameValuePairs.add(new BasicNameValuePair(KEY_ADRESSE, profil
				.getAdresse()));
		nameValuePairs.add(new BasicNameValuePair(KEY_CODEPOSTAL, profil
				.getCodePostal()));
		nameValuePairs
				.add(new BasicNameValuePair(KEY_VILLE, profil.getVille()));
		nameValuePairs.add(new BasicNameValuePair(KEY_PLAGESHORAIRES, profil
				.getPlagesHoraires()));
		nameValuePairs.add(new BasicNameValuePair(KEY_RAYONGEOGRAPHIQUE, profil
				.getRayonGeographique()));

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
		nameValuePairs.add(new BasicNameValuePair("tag", "delete"));
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

	public Profil getProfilByPseudo(String pseudo) {
		Profil profil = new Profil();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "login"));
		nameValuePairs.add(new BasicNameValuePair(KEY_PSEUDO, pseudo));

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

			profil.setId(Integer.parseInt(jObj.getString(KEY_ID)));
			profil.setPseudo(jObj.getString(KEY_PSEUDO));
			profil.setMotDePasse(jObj.getString(KEY_MOTDEPASSE));
			profil.setMail(jObj.getString(KEY_MAIL));
			profil.setAdresse(jObj.getString(KEY_ADRESSE));
			profil.setCodePostal(jObj.getString(KEY_CODEPOSTAL));
			profil.setPlagesHoraires(jObj.getString(KEY_PLAGESHORAIRES));
			profil.setRayonGeographique(jObj.getString(KEY_RAYONGEOGRAPHIQUE));
			profil.setVille(jObj.getString(KEY_VILLE));

		} catch (Exception e) {
		}

		return profil;
	}

	public Profil getProfilByEmail(String mail) {
		Profil profil = new Profil();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "login"));
		nameValuePairs.add(new BasicNameValuePair(KEY_MAIL, mail));

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

			profil.setId(Integer.parseInt(jObj.getString(KEY_ID)));
			profil.setPseudo(jObj.getString(KEY_PSEUDO));
			profil.setMotDePasse(jObj.getString(KEY_MOTDEPASSE));
			profil.setMail(jObj.getString(KEY_MAIL));
			profil.setAdresse(jObj.getString(KEY_ADRESSE));
			profil.setCodePostal(jObj.getString(KEY_CODEPOSTAL));
			profil.setPlagesHoraires(jObj.getString(KEY_PLAGESHORAIRES));
			profil.setRayonGeographique(jObj.getString(KEY_RAYONGEOGRAPHIQUE));
			profil.setVille(jObj.getString(KEY_VILLE));

		} catch (Exception e) {
		}

		return profil;
	}

	public ArrayList<String> getProfil(String pseudo, String motDePasse) {
		ArrayList<String> res = new ArrayList<String>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "login"));
		nameValuePairs.add(new BasicNameValuePair(KEY_PSEUDO, pseudo));
		nameValuePairs.add(new BasicNameValuePair(KEY_MOTDEPASSE, motDePasse));

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
			JSONObject jObj = new JSONObject(result);

			res.add(jObj.getString(KEY_SUCCESS));
			res.add(jObj.getString(KEY_ID));
		} catch (Exception e) {
		}

		return res;
	}

	// Attendre Validation du tag
	public ArrayList<Profil> getProfils() {
		ArrayList<Profil> list = new ArrayList<Profil>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag", "listProfil"));

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
				Profil profil = new Profil();

				jObj = jArr.getJSONObject(i);

				profil.setId(jObj.getInt(KEY_ID));
				profil.setPseudo(jObj.getString(KEY_PSEUDO));
				profil.setMotDePasse(jObj.getString(KEY_MOTDEPASSE));
				profil.setMail(jObj.getString(KEY_MAIL));
				profil.setAdresse(jObj.getString(KEY_ADRESSE));
				profil.setCodePostal(jObj.getString(KEY_CODEPOSTAL));
				profil.setPlagesHoraires(jObj.getString(KEY_PLAGESHORAIRES));
				profil.setRayonGeographique(jObj
						.getString(KEY_RAYONGEOGRAPHIQUE));
				profil.setVille(jObj.getString(KEY_VILLE));

				list.add(profil);
			}

		} catch (Exception e) {
		}

		return list;
	}
}