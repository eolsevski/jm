package service;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import model.User;

import java.io.IOException;

public class UserJsonSerializer extends StdSerializer<User> {
    public UserJsonSerializer(Class<User> t) {
        super(t);
    }

    public UserJsonSerializer() {
        this(null);
    }

    @Override
    public void serialize(User user, JsonGenerator  jsonGenerator, SerializerProvider provider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", user.getId());
        jsonGenerator.writeStringField("name", user.getUsername());
        jsonGenerator.writeStringField("email", user.getEmail());
        jsonGenerator.writeEndObject();
    }
}
