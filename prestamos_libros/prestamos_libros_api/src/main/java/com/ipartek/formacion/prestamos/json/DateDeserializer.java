package com.ipartek.formacion.prestamos.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;

public class DateDeserializer extends StdDeserializer<Date> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser json, DeserializationContext context)
            throws IOException, JsonProcessingException {
        try {
            DateFormat df = StdDateFormat.getDateInstance();
            return df.parse(json.getText());
        } catch (ParseException e) {
            return null;
        }
    }

}
