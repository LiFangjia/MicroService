package fr.polytech.nancy.springRestaurantService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {


    public static ObjectMapper objectMappper = new ObjectMapper();



     //json字符串转JsonNode对象的方法

    public static JsonNode str2JsonNode(String str) {
        try {
            return objectMappper.readTree(str);
        } catch (IOException e) {
            return null;
        }
    }
}