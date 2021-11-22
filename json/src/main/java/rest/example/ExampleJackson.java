package rest.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import rest.example.json.JsonExample;

import java.io.IOException;

@SuppressWarnings("NotNullNullableValidation")
public final class ExampleJackson {
  public static void main(String[] args) throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();
    final String json = "{" +
            "\"data\": \"something\", " +
            "\"valueNames\": [5, 4, 3, 2, 1]" +
            "}";

    final JsonExample jsonExample = objectMapper.readValue(json, JsonExample.class);
    System.out.println("JSON to Java:\n" + jsonExample);

    final String s = objectMapper.writeValueAsString(jsonExample);
    System.out.println("\nJava to JSON:\n" + s);

    final JsonNode jsonNode = objectMapper.readTree(json);
    final String key = "data";
    System.out.println("\nGetting JSON node" + key + ":\n" + jsonNode.get(key).asText());
  }
}
