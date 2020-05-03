package com.example.timeline;

import android.content.Context;

import com.example.timeline.dto.Event;
import com.example.timeline.dto.EventTable;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class JsonManager {

    JsonManager() {}

    private String loadJSONFromAsset(String filename, Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(filename);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    };

    Event[] create(String filename, Context context) {
        String json = loadJSONFromAsset(filename, context);
        Gson gson = new Gson();
        EventTable obj = gson.fromJson(json, EventTable.class);

        return obj.events;
    };

}
