package rest.example;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.util.StdConverter;

import java.io.IOException;
import java.util.Date;

@SuppressWarnings("NotNullNullableValidation")
public final class TimeExample {
  @JsonSerialize(converter = FromTimeExampleConvertor.class)
  @JsonDeserialize(converter = ToTimeExampleConvertor.class)
  @JsonProperty("date")
  private Date date;

  public static void main(String[] args) throws IOException {
    final TimeExample example = new TimeExample(new Date());
    final ObjectMapper objectMapper = new ObjectMapper();
    final String json = objectMapper.writeValueAsString(example);
    System.out.println("Java to JSON:\n" + json);

    final TimeExample javaObject = objectMapper.readValue(json, TimeExample.class);
    System.out.println("JSON to Java:\n" + javaObject);
  }

  public TimeExample() {
  }

  public TimeExample(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "TimeExample{" +
            "date=" + date +
            ", millis=" + date.getTime() +
            '}';
  }

  public static final class FromTimeExampleConvertor extends StdConverter<Date, Long> {

    @Override
    public Long convert(Date value) {
      System.out.println("Serialize");
      return value.getTime();
    }
  }

  public static final class ToTimeExampleConvertor extends StdConverter<Long, Date> {

    @Override
    public Date convert(Long value) {
      System.out.println("Deserialize");
      return new Date(value);
    }
  }
}
