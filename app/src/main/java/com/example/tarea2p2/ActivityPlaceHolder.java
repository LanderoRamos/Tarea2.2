package com.example.tarea2p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tarea2p2.Config.Posts;
import com.example.tarea2p2.Config.RestApiMethods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityPlaceHolder extends AppCompatActivity {

    private RequestQueue requestQueue;

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> Arreglo;

    public ActivityPlaceHolder() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_holder);

        setContentView(R.layout.activity_place_holder);

        listView = findViewById(R.id.listplace);
        Arreglo = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arreglo);
        listView.setAdapter(adapter);

        GetData();

    }

    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, RestApiMethods.Endpointplace, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Procesar la respuesta JSON
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject post = response.getJSONObject(i);

                                String id = post.getString("id");
                                String title = post.getString("title");
                                String body = post.getString("body");
                                String dato = "ID:"+id+"\nTitulo: "+title+"\nCuerpo: "+body+"\n";

                                // Arreglo.add(id);
                                // Arreglo.add(title);
                                Arreglo.add(dato);
                            }
                            adapter.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Manejar el error de la solicitud
                error.printStackTrace();
            }
        });

        // Agregar la solicitud a la cola de solicitudes
        requestQueue.add(request);
    }




    /*private void SendData()
    {
        requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET,
                RestApiMethods.Endpointplace, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                String mensaje = response.toString();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);
    }*/
}