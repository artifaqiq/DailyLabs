package by.casanova.team.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;

/**
 * Created by artifaqiq on 2/19/17.
 */
public class ZonedDateTimeSerializer implements JsonSerializer<ZonedDateTime> {
    public JsonElement serialize(ZonedDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toInstant().toString());
    }
}
