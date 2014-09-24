package com.example.contatos;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContatosArrayAdapter extends ArrayAdapter<Contato> 
{
	private LayoutInflater inflater;
	private List<Contato> data;
	
	public ContatosArrayAdapter(Context context,List<Contato> objects) 
	{
		super(context, R.layout.activity_lista_contatos, objects);
		
		inflater= LayoutInflater.from(context);
		this.data=objects;
		Log.v ( "MeuLog", "Entrou no ContatosArrayAdapter");
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ListaDados MinhaLista;
		if(convertView == null)
		{
			convertView = inflater.inflate(R.layout.activity_lista_contatos, null);
			MinhaLista = new ListaDados();
			MinhaLista.imagem =(ImageView) convertView.findViewById(R.id.imageView1);			
			MinhaLista.sNome =(TextView) convertView.findViewById(R.id.textViewName);
			MinhaLista.sTelefone =(TextView) convertView.findViewById(R.id.textViewPhone);
			MinhaLista.sUrl =(TextView) convertView.findViewById(R.id.textViewURL);
			convertView.setTag(MinhaLista);
		}
		else 
		{
			MinhaLista =(ListaDados) convertView.getTag();
		}		
		MinhaLista.imagem.setImageResource(getResourceImage(data.get(position).getImagem())); 
		MinhaLista.sNome.setText((CharSequence) data.get(position).getNome());
		MinhaLista.sTelefone.setText((CharSequence) data.get(position).getTelefone());
		MinhaLista.sUrl.setText((CharSequence) data.get(position).getURL());
		return convertView;
	}

	static class ListaDados
	{
		ImageView imagem;
		TextView sNome;
		TextView sTelefone;
		TextView sUrl;
	}
	
	private int getResourceImage( String nome ){			
		if( nome.equals("android01"))return R.drawable.android01;
		if( nome.equals("android02"))return R.drawable.android02;
		if( nome.equals("android03"))return R.drawable.android03;
		if( nome.equals("android04"))return R.drawable.android04;
		if( nome.equals("android05"))return R.drawable.android05;
		
		return 0;	
	}
}
