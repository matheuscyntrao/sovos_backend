package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Function;

public interface JsonToString {

    Function<Object, String> objectToJsonString = (object) -> {
        ObjectMapper mapper = new ObjectMapper();
        String stringObject = "";
        try {
            stringObject = mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringObject;
    };

}

