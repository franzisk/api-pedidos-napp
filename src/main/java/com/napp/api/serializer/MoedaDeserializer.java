package com.napp.api.serializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.napp.api.util.Const;

public class MoedaDeserializer extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException, JsonProcessingException {
		
		DecimalFormatSymbols.getInstance(new Locale("pt", "BR"));
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setGroupingSeparator('.');
		symbols.setDecimalSeparator(',');

		DecimalFormat format = new DecimalFormat(Const.FORMATO_MOEDA, symbols);
		String valor = jsonParser.getText();
		try {
			return new BigDecimal(format.parse(valor).doubleValue());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
