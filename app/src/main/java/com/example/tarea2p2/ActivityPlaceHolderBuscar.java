package com.example.tarea2p2;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityPlaceHolderBuscar extends AppCompatActivity {

    private RequestQueue requestQueue;

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> Arreglo;

    private EditText editText;
    private Button button;
    private TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_holder_buscar);

        listView = findViewById(R.id.listplace);
        Arreglo = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arreglo);
        listView.setAdapter(adapter);
        editText = (EditText) findViewById(R.id.editTextText);
        button = (Button) findViewById(R.id.button);
        textView2 = (TextView) findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length()==0){
                    Toast.makeText(getApplicationContext(), "ingrese un dato", Toast.LENGTH_LONG).show();
                }else {
                    GetData();
                }
            }
        });


    }
    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String n = editText.getText().toString();
        int d = Integer.parseInt(n);
        //Toast.makeText(getApplicationContext(), RestApiMethods.Endpointplace2+n, Toast.LENGTH_LONG).show();
        String url = RestApiMethods.Endpointplace2;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Procesar la respuesta JSON
                        try {

                            JSONObject post = response.getJSONObject(d-1);

                            String id = post.getString("id");
                            String title = post.getString("title");
                            String body = post.getString("body");
                            String dato = "ID: "+id+"\n\n Titulo:\n"+title+" \n\n Cuerpo:\n"+body;

                            // Arreglo.add(id);
                            // Arreglo.add(title);
                            textView2.setText(dato);
                            //Arreglo.add(dato);
                            //adapter.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
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
}