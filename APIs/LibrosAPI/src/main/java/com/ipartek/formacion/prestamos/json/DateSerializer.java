package com.ipartek.formacion.prestamos.json;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;

public class DateSerializer extends StdSerializer<Date> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateSerializer() {
        super(Date.class);
    }

    @Override
    public void serialize(Date date, JsonGenerator json,
            SerializerProvider provider) throws IOException,
            JsonGenerationException {
        // The client side will handle presentation, we just want it accurate
        DateFormat df = StdDateFormat.getDateInstance();
        String out = df.format(date);
        json.writeString(out);
    }

}
