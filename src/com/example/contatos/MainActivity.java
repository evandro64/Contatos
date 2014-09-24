package com.example.contatos;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parse.*;

public class MainActivity extends Activity {
	
	public static final String applicationId = "MRCojaEXIPBeoDFVaZU7Kgm79aAhafnenwnATbDb";
	public static final String clienteId = "uBuA3YMIgefWFGMeT3cvh4DyXISPQM1GoBpi7I5X";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ParseObject.registerSubclass(Tasks.class);
		Parse.initialize(this, applicationId, clienteId);
		ParseACL.setDefaultACL(new ParseACL(), true);
		
		Tasks tarefa = new Tasks();
		tarefa.setDescription("Comprar leite");
		tarefa.saveInBackground(new SaveCallback() {
			
			@Override
			public void done(ParseException arg0) {
				System.out.println("Tarefa salva com sucesso!");
				
			}
		});
		
	}

	public void insereContato(View v) {		
		Intent intent = new Intent(MainActivity.this, NovoContatoActivity.class);
		startActivity(intent);
	}
	
	public void ListaContatos(View v) {		
		Intent intent = new Intent(MainActivity.this, ListaContatosActivity.class);
		startActivity(intent);
	}

	public void BotaoBack() {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
				MainActivity.this);		 
		alertDialog.setTitle(getString(R.string.dialog_exit_title));
		alertDialog.setMessage(R.string.dialog_exit_msg);
		alertDialog.setIcon(R.drawable.agenda72);
		alertDialog.setPositiveButton(R.string.dialog_exit_sim,new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				});
		alertDialog.setNegativeButton(R.string.dialog_exit_nao,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		alertDialog.setNegativeButton(R.string.dialog_exit_cancelar,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});

		alertDialog.show();
	}

	public void onBackPressed() {
		BotaoBack();
		return;
	}

}
