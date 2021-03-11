package com.devmatheus.bddwithcucumber.converters;

import java.util.Date;

public class DateConverter extends Transformer<Date> {

	@Override
	public Date transform(String value) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date retorno = format.parse(value);
			return retorno;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}