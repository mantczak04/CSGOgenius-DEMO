package com.csgog.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.csgog.Objects.Field;

@Service
public class RouletteService {

	private static RouletteService instance;
	private List<Field> fields;
	
	public static RouletteService getInstance() {
		if(instance==null) {
			instance = new RouletteService();
		}
		return instance;
	}
	

	public RouletteService() {
		generateFields();
	}
	
	public void generateFields() {
		fields=new ArrayList<Field>();
		fields.clear();
		for(int i=0; i<11; i++) {
			Field field = new Field();
			if(i==5) field.setHTMLclass(field.getHTMLclass()+" bg-warning");
			fields.add(field);
	}
	}
	

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	
}
