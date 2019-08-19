package com.napp.api.serializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.napp.api.util.Const;

public class MoedaSerializer extends StdSerializer<BigDecimal> {

	private static final long serialVersionUID = -5669986905617524103L;

	DecimalFormat formatter = null;

	public MoedaSerializer() {
		this(null);
	}

	public MoedaSerializer(Class<BigDecimal> t) {
		super(t);
		DecimalFormatSymbols.getInstance(new Locale("pt", "BR"));
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setGroupingSeparator('.');
		symbols.setDecimalSeparator(',');

		formatter = new DecimalFormat(Const.FORMATO_MOEDA, symbols);
	}

	@Override
	public void serialize(BigDecimal valor, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(formatter.format(valor));
	}

}
