package com.example.projetbibliotheque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.projetbibliotheque.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class LivresActivity extends Activity {

	static public ListView maListeView ; 
	
	static public ArrayList <Map<String, String>> listeDeLivre = new ArrayList<Map<String,String>>();
	static public SimpleAdapter adaptateurPourListeView ;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_livres);
		
		 // je récupère la liste view du layout 
		maListeView = (ListView)findViewById(id.maListeView);
		
		// fonction d'init 
		initFausseListeLivre();
		
		adaptateurPourListeView = new SimpleAdapter(this, listeDeLivre, android.R.layout.simple_list_item_1, new String[] {"livre"}, new int[] {android.R.id.text1});
		
		maListeView.setAdapter(adaptateurPourListeView);
		
		



		maListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	     public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {


	    	// utilisation d'un toast pour afficher le clic (toast = popup simple)
	         TextView clickedView = (TextView) view;

	         Toast.makeText(LivresActivity.this, "Clique sur livre :"+id, Toast.LENGTH_SHORT).show();


	     }

	});
	


  
	registerForContextMenu(maListeView);


	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		
		getMenuInflater().inflate(R.menu.livres, menu);
		return true;
	}

	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		int itemId = item.getItemId();

		// utilisation d'un toast pour afficher le clic (toast = popup simple)
	    Toast.makeText(this, "Clic sur liste numero : "+itemId, Toast.LENGTH_SHORT).show();
	    return true;
	
	}

	
	
	// fonction de création de menu option sur android 
	@Override
	  public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
	          
	    super.onCreateContextMenu(menu, v, menuInfo);
	      
	      AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;
	      
	      
	      
	      HashMap map =  (HashMap) adaptateurPourListeView.getItem(aInfo.position);
	      menu.setHeaderTitle("Livre : " + map.get("livre"));
	      menu.add(1, 1, 1, "info");
	      menu.add(1, 2, 2, "supprimer");

	  }
	
	

private void initFausseListeLivre() {

    // ajout de livre dans une liste pour 'simuler' une BDD 

    listeDeLivre.add(createLivre("livre", "Harry Potter"));
    listeDeLivre.add(createLivre("livre", "Les fleurs du mal"));
    listeDeLivre.add(createLivre("livre", "Mathématique appliqué"));
    listeDeLivre.add(createLivre("livre", "Twilight"));
    listeDeLivre.add(createLivre("livre", "Le java pour les nuls"));
    listeDeLivre.add(createLivre("livre", "Découvre ta région"));
    listeDeLivre.add(createLivre("livre", "Don Juan"));
    listeDeLivre.add(createLivre("livre", "Sombre Créature"));
    listeDeLivre.add(createLivre("livre", "Histoire Géo 3ème"));

}


// fonction simpliste de création d'une hastMap  
private HashMap<String, String> createLivre(String key, String name) {

    HashMap<String, String> _livre = new HashMap<String, String>();
    _livre.put(key, name);
    
    return _livre;
    
}

	
	
}
