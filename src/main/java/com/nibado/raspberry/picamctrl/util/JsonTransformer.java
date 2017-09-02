package com.nibado.raspberry.picamctrl.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import spark.ResponseTransformer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class JsonTransformer implements ResponseTransformer {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        SimpleModule module = new SimpleModule();
        module.addSerializer(ZonedDateTime.class, new JsonSerializer<ZonedDateTime>() {
            @Override
            public void serialize(ZonedDateTime zonedDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString(zonedDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
            }
        });

        MAPPER.registerModule(module);
    }

    @Override
    public String render(Object o) throws Exception {
        return MAPPER.writeValueAsString(o);
    }
}
