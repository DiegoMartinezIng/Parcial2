package com.example.aplicacionjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    public JsonReader jsonReader;
    public ArrayList<Habitacion> habitaciones;
    public Intent intent;
    public TextView texto;
    public ImageView imagenBaño;
    private ImageButton baño;
    private ImageButton cocina;
    private ImageButton habitacion1;
    private ImageButton habitacion2;
    private ImageButton habitacion3;
    private ImageButton habitacion4;
    public ArrayList<String> botones ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        habitaciones = new ArrayList<Habitacion>();
        baño = findViewById(R.id.baño);
        cocina = findViewById(R.id.cocina);
        habitacion1 = findViewById(R.id.habitacion1);
        habitacion2 = findViewById(R.id.habitacion2);
        habitacion3 = findViewById(R.id.habitacion3);
        habitacion4 = findViewById(R.id.habitacion4);
        botones = new ArrayList<>();
        callWebService();

    }
    public void post(View view){ callPostService(); }
    public void callPostService () {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlService = new URL ("http://10.10.7.130:3000/aptos/changeAptoStatusBody" );
                    HttpURLConnection connection =  (HttpURLConnection) urlService.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
                    wr.writeBytes("{\"luzBano\":true,\"luzCocina\":true,\"luzHabitacion1\":false,\"luzHabitacion2\":false,\"luzHabitacion3\":true,\"luzHabitacion4\":true}");
                    wr.close();
                    InputStream responseBody = connection.getInputStream();
                    if (connection.getResponseCode() == 200) {
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void callWebService(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlService = new URL ("http://10.10.7.130:3000/aptos/aptoStatus" );
                    HttpURLConnection connection =  (HttpURLConnection) urlService.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream responseBody = connection.getInputStream();
                    if (connection.getResponseCode() == 200) {
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        jsonReader = new JsonReader(responseBodyReader);
                        jsonReader.beginObject();
                        for (int i = 0;i<6;i++){
                            habitaciones.add(new Habitacion(jsonReader.nextName(),jsonReader.nextBoolean()));
                        }
                        for (int i = 0;i<6;i++){
                            if(habitaciones.get(i).getNombre().equals("luzBano")){
                                if(habitaciones.get(i).getEncendido() == false){
                                    baño.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            baño.setImageResource(R.drawable.apagado);
                                        }
                                    });
                                }else{
                                    baño.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            baño.setImageResource(R.drawable.prendido);
                                        }
                                    });
                                }

                            }
                            if(habitaciones.get(i).getNombre().equals("luzCocina")){
                                if(habitaciones.get(i).getEncendido() == false){
                                    cocina.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            cocina.setImageResource(R.drawable.apagado);
                                        }
                                    });
                                }else{
                                    cocina.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            cocina.setImageResource(R.drawable.prendido);
                                        }
                                    });
                                }

                            }
                            if(habitaciones.get(i).getNombre().equals("luzHabitacion1")){
                                if(habitaciones.get(i).getEncendido() == false){
                                    habitacion1.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            habitacion1.setImageResource(R.drawable.apagado);
                                        }
                                    });
                                }else{
                                    habitacion1.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            habitacion1.setImageResource(R.drawable.prendido);
                                        }
                                    });
                                }

                            }
                            if(habitaciones.get(i).getNombre().equals("luzHabitacion2")){
                                if(habitaciones.get(i).getEncendido() == false){
                                    habitacion2.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            habitacion2.setImageResource(R.drawable.apagado);
                                        }
                                    });
                                }else{
                                    habitacion2.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            habitacion2.setImageResource(R.drawable.prendido);
                                        }
                                    });
                                }

                            }
                            if(habitaciones.get(i).getNombre().equals("luzHabitacion3")){
                                if(habitaciones.get(i).getEncendido() == false){
                                    habitacion3.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            habitacion3.setImageResource(R.drawable.apagado);
                                        }
                                    });
                                }else{
                                    habitacion3.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            habitacion3.setImageResource(R.drawable.prendido);
                                        }
                                    });
                                }

                            }
                            if(habitaciones.get(i).getNombre().equals("luzHabitacion4")){
                                if(habitaciones.get(i).getEncendido() == false){
                                    habitacion4.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            habitacion4.setImageResource(R.drawable.apagado);
                                        }
                                    });
                                }else{
                                    habitacion4.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            habitacion4.setImageResource(R.drawable.prendido);
                                        }
                                    });
                                }
                            }
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });}
}