package com.example.contatos;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class NovoContatoActivity extends Activity {

	SQLiteDatabase mydb;
    private static String strNomeBanco 	= "Contatos.db";    
    private static String strNomeTabela = "Contato";
    private TextView nome;
    private TextView telefone;
    private TextView url;
    private RadioGroup radio;
    private Contato contato;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_novo_contato);		
	}	
	
	public void voltar(View v){
		Log.v("MeuLog", "Entrou no voltar");
		finish();
	}
	
	public void limpar(View v){
		Log.v("MeuLog", "Entrou no limpar");
		nome = (TextView)findViewById(R.id.editText2);
		nome.setText("");
		telefone = (TextView)findViewById(R.id.editText1);
		telefone.setText("");
		url = (TextView)findViewById(R.id.editText3);
		url.setText("");
		RadioButton radio0 = (RadioButton)findViewById(R.id.radio0);
		RadioButton radio1 = (RadioButton)findViewById(R.id.radio1);
		RadioButton radio2 = (RadioButton)findViewById(R.id.radio2);
		RadioButton radio3 = (RadioButton)findViewById(R.id.radio3);
		RadioButton radio4 = (RadioButton)findViewById(R.id.radio4);
		radio0.setChecked(true);
		radio1.setChecked(false);
		radio2.setChecked(false);
		radio3.setChecked(false);
		radio4.setChecked(false);
		
	}
	
	public void inserirContato(View v){
		
		nome = (TextView)findViewById(R.id.editText2);
		String name = nome.getText().toString();		
		telefone = (TextView)findViewById(R.id.editText1);
		String phone = telefone.getText().toString();
		url = (TextView)findViewById(R.id.editText3);
		String URL = url.getText().toString();
		radio = (RadioGroup)findViewById(R.id.radioGroup1);
		String imagem = "";
		
		switch (radio.getCheckedRadioButtonId()) {
		case R.id.radio0:
			imagem = "android01";
			break;
		case R.id.radio1:
			imagem = "android02";
			break;
		case R.id.radio2:
			imagem = "android03";
			break;
		case R.id.radio3:
			imagem = "android04";
			break;
		case R.id.radio4:
			imagem = "android05";
			break;	
		default:
			break;
		}		
		
		if (name.equals("") || phone.equals(""))
			Toast.makeText(getApplicationContext(), "Forneça nome e telefone para iserir um contato", Toast.LENGTH_LONG).show();
		else{				
			try
			{
				mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
				mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, TELEFONE, URL, IMAGEM) VALUES('"+name+"',"+"'"+phone+"','"+URL+"','"+imagem+"')");            
				mydb.close();
				Toast.makeText(getApplicationContext(), "Contato inserido", Toast.LENGTH_LONG).show();
				limpar(nome);
			}
			catch(Exception e)
			{
				Toast.makeText(getApplicationContext(), "Erro ao Inserir Dados na Tabela", Toast.LENGTH_LONG).show();
			}
		}
	}
	
}
