package utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.Gson;
import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.GsonBuilder;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CucumberUtils {

    public static String dataTableToJson(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        GsonBuilder gsonMapBuilder = new GsonBuilder();
        Gson gsonObject = gsonMapBuilder.create();
        return rows.size() > 1 ? gsonObject.toJson(rows) : gsonObject.toJson(rows.get(0));
    }

    public static <T> T getObjectBody(DataTable table, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        T mappedBody = null;
        try {
            mappedBody = mapper.readValue(dataTableToJson(table), clazz);
            return mappedBody;
        } catch (IOException e) {
            mappedBody = mapper.readValue("[" + dataTableToJson(table) + "]", clazz);
            return mappedBody;
        }
    }

    public static <T> T getObjectBody(String jsonObject, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        T mappedBody = null;
        try {
            mappedBody = mapper.readValue(jsonObject, clazz);
            return mappedBody;
        } catch (IOException e) {
            mappedBody = mapper.readValue("[" + jsonObject + "]", clazz);
            return mappedBody;
        }
    }

}
