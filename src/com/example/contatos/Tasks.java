package com.example.contatos;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("task")
public class Tasks extends ParseObject {
	
	public static final String FIELD_OBJECT_ID = "objectId";
	public static final String FIELD_DESCRIPTION = "description";
	
	public void setDescription(String description){
		put(FIELD_DESCRIPTION, description);
		
	}
	public String getDescription(){
		return getString(FIELD_DESCRIPTION);
	} 
	
}

