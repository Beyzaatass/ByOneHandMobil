package io.grpc.helloworldexample;

import org.json.JSONObject;

public class JSONParser {

    JSONObject jsonObject = null;

    public JSONParser() {

    }

    public JSONObject getJSONFromUrl(String message) {

        try {
            if (message != null) {
                jsonObject = new JSONObject(message);
            }
        } catch (Exception excption) {
            excption.printStackTrace();
        }
        return jsonObject;
    }
}
