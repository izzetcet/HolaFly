package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

//Create a method to convert Json to Java Object (De-serialization)

    //1.STEP: Create an object from ObjectMapper class
    private static ObjectMapper mapper; //Ayni sayfada kullanacagimiz icin private yapti

    static {
        mapper = new ObjectMapper();
    }


//2.STEP: Create De-serialization method

    public static <T> T convertJsonToJava(String json, Class<T> cls) {
        T JavaResult = null;

        try {
            JavaResult = mapper.readValue(json, cls);
        } catch (IOException e) {
          System.out.println("Json could not be converted to Java Object" + e.getMessage());
        }
        return JavaResult;
    }
//================================================
//Create a method to converty Java object to Json Data (Serialization)
public static  String convertJavaToJson(Object obj){

        String jsonResult= null;

    try {
        jsonResult=mapper.writeValueAsString(obj);
    } catch (IOException e) {
      System.out.println("Java object could not be converted to Json Data " + e.getMessage());
    }

    return jsonResult;
}

}


