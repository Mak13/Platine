package lille1.eservices.sporaction;

import java.util.regex.Pattern;

import lille1.eservices.sporaction.model.Profil;
import lille1.eservices.sporaction.sqlite.ProfilsDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;


public class ParticipationDetails extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participationdetails);
    }
    
    @Override
	protected void onStart() {
    	super.onStart();
	}
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
	}
}