package com.example.projetbibliotheque;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AccueilActivity extends Activity {

	static public Button bouton_livre ; 
	static public Button bouton_editeur ; 
	static public Button bouton_auteur ; 
	static public Button bouton_pret ; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		
		// on récupére l'identifiant du bouton dans le XML du layout
		bouton_livre = (Button)findViewById(R.id.accueil_bt_Livre);
		
		// on lui donne une action avec un listener 
		
		bouton_livre.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// si on clique on démarre l'activity en question ( ne pas oublier de déclarer l'activity dans le fichier AndroidManifest
				Intent	var_prochainePage = new Intent("com.example.projetbibliotheque.LivresActivity");
				
				startActivity(var_prochainePage);
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}

}
