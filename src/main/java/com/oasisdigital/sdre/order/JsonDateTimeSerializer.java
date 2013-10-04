package com.oasisdigital.sdre.order;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class JsonDateTimeSerializer extends JsonSerializer<DateTime> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:MM:ss");

	@Override
	public void serialize(DateTime date, JsonGenerator gen, 
			SerializerProvider provider) throws IOException, JsonProcessingException {
		String formattedDate = dateFormat.format(date);
		gen.writeString(formattedDate);
	}
}