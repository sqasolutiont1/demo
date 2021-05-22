package examplesOfJSON;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ExamplesJSON {

  public static void main(String[] args) throws FileNotFoundException {
    // creating JSONObject
    JSONObject jsonObject = new JSONObject();

    // putting data to JSONObject
    jsonObject.put("firstName", "John");
    jsonObject.put("lastName", "Smith");
    jsonObject.put("age", 25);

    // for address data, first create LinkedHashMap
    Map m = new LinkedHashMap(4);
    m.put("streetAddress", "21 2nd Street");
    m.put("city", "New York");
    m.put("state", "NY");
    m.put("postalCode", 10021);

    // putting address to JSONObject
    jsonObject.put("address", m);
//
    // for phone numbers, first create JSONArray
    JSONArray jsonArray = new JSONArray();

    m = new LinkedHashMap(2);
    m.put("type", "home");
    m.put("number", "212 555-1234");

    // adding map to list
    jsonArray.add(m);

    m = new LinkedHashMap(2);
    m.put("type", "fax");
    m.put("number", "212 555-1234");

    // adding map to list
    jsonArray.add(m);

    // putting phoneNumbers to JSONObject
    jsonObject.put("phoneNumbers", jsonArray);

    // writing JSON to file:"JSONExample.json" in cwd
    PrintWriter printWriter = new PrintWriter("JSONExample.json");
    printWriter.write(jsonObject.toJSONString());

    printWriter.flush();
    printWriter.close();
  }

}
