package com.java.news.service;

import com.google.gson.Gson;
import com.java.news.model.New;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class NewService {

    public List<New> getAllJava() throws IOException, ParseException {
        return getByQuery("java");
    }

    public List<New> getByQuery(String query) throws IOException, ParseException {
        List<New> news = new ArrayList<>();

        var url = new URL("https://hn.algolia.com/api/v1/search_by_date?query="+query);

        var conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Obteniendo el codigo del response
        int responsecode = conn.getResponseCode();

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            var inline = new StringBuilder();
            var scanner = new Scanner(url.openStream());

            //Cargando todo el contenido del json en un un string builder usando el scanner
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }
            scanner.close();

            //Carga el contenido en un json
            var parse = new JSONParser();
            var data_obj = (JSONObject) parse.parse(inline.toString());

            //objentiendo la propieda "hits" que es donde se encuentran los datos
            var arr = (JSONArray) data_obj.get("hits");

            //recorriendo el objeto para cargar los datos
            for (Object o : arr) {

                var new_obj = (JSONObject) o;
                //usando gson para parsear los datos a la clase creada
                var gson = new Gson();
                var obj = gson.fromJson(new_obj.toString(),New.class);
                news.add(obj);
            }
        }
        return news;
    }
}
