package com.example.contatos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class SplashScreen extends Activity 
{
	private static int SPLASH_TIME_OUT = 3000;
	SQLiteDatabase mydb;
    private static String strNomeBanco 	= "Contatos.db";    
    private static String strNomeTabela = "Contato"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);		
		
		CriaTabela();
		Log.v("MeuLog","Criou a tabela!");
		//InsereDados();		
		
		new Handler().postDelayed(new Runnable() 
		{
			@Override
			public void run() 
			{
				Intent i = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		}, SPLASH_TIME_OUT);		
		
	}
	
	public void CriaTabela()
    {
        try
        {
	        mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
	        mydb.execSQL("CREATE TABLE IF  NOT EXISTS "+ strNomeTabela +" (ID INTEGER PRIMARY KEY, NAME TEXT, TELEFONE TEXT, URL TEXT, IMAGEM TEXT);");
	        mydb.close();
	        Toast.makeText(getApplicationContext(), "Banco Criado.", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Erro ao Criar o Banco de Dados", Toast.LENGTH_LONG).show();
        }
    }
	
	public void InsereDados()
    {
        try
        {
            mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, TELEFONE, URL, IMAGEM) VALUES('João da Silva','65988754','https://www.youtube.com/watch?v=4w63OdDvbIw','android01')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, TELEFONE, URL, IMAGEM) VALUES('Manoel dos Santos','98653265','https://www.youtube.com/watch?v=4w63OdDvbIw','android01')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, TELEFONE, URL, IMAGEM) VALUES('Tereza dos Santos','98548754','https://www.youtube.com/watch?v=4w63OdDvbIw','android01')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, TELEFONE, URL, IMAGEM) VALUES('Claudio dos Rios','98586325','https://www.youtube.com/watch?v=4w63OdDvbIw','android01')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, TELEFONE, URL, IMAGEM) VALUES('Juscelino Alves','87543265','https://www.youtube.com/watch?v=4w63OdDvbIw','android01')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, TELEFONE, URL, IMAGEM) VALUES('Dario Pederneiras','87562312','https://www.youtube.com/watch?v=4w63OdDvbIw',''android01)");
            mydb.close();
            Toast.makeText(getApplicationContext(), "Dados inseridos", Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Erro ao Inserir Dados na Tabela", Toast.LENGTH_LONG).show();
        }
    }

}


