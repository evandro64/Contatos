package com.example.contatos;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListaContatosActivity extends ListActivity {

	SQLiteDatabase mydb;
	private static String strNomeBanco = "Contatos.db";
	private static String strNomeTabela = "Contato";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);

		List<Contato> data = new ArrayList<Contato>();

		try {
			mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
			Cursor allrows = mydb.rawQuery("SELECT * FROM " + strNomeTabela,null);

			if (allrows.moveToFirst()) {
				Log.v ( "MeuLog", "achou a primeira linha");
				do {
					String ID = allrows.getString(0);
					String NOME = allrows.getString(1);
					String TELEFONE = allrows.getString(2);
					String URL = allrows.getString(3);
					String IMAGEM = allrows.getString(4);

					data.add(new Contato(NOME, TELEFONE, URL, IMAGEM));

				} while (allrows.moveToNext());
			}
			mydb.close();
			setListAdapter(new ContatosArrayAdapter(this, data));
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Erro Encontrado",
					Toast.LENGTH_LONG).show();
		}
	}
		
	@Override
	protected void onListItemClick(ListView lstView, View vmView, int iPosicao, long id){
		Log.i("MeuLog","Entrou no onListItemClick");
		super.onListItemClick(lstView, vmView, iPosicao, id);
		
		Object objPosition = this.getListAdapter().getItem(iPosicao);
		String strLinha = ((Contato)objPosition).getURL();
		
		Intent intent = new Intent(ListaContatosActivity.this,VideoActivity.class);
		intent.putExtra("URL", strLinha);
		startActivity(intent);
	}
}
