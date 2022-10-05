package com.proyect_chidos.app_movil_desarrollo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.proyect_chidos.app_movil_desarrollo.interfaces.ProductoAPI;
import com.proyect_chidos.app_movil_desarrollo.model.Empleado;
import com.proyect_chidos.app_movil_desarrollo.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Empleado>empleados;
    EditText EditUser;
    EditText Edipassword;
    ProductoAPI ProductoAPI;
    private String EmailAddress;
    private String Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAll();
        EditUser=findViewById(R.id.EmailAddress);
        Edipassword=findViewById(R.id.Password);

        Button button1=findViewById(R.id.Log_In);
        Button button2=findViewById(R.id.Sign_Up);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EmailAddress.equals(EditUser.getText().toString())&&Password.equals(Edipassword.getText().toString())) {
                        Intent intent = new Intent(MainActivity.this, contenido_activity.class);
                        startActivity(intent);
                    }}});
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Sing_Up.class);
                startActivity(intent);
            }});
    }

    private void getAll(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        ProductoAPI=retrofit.create(ProductoAPI.class);
        Call<List<Empleado>>call=ProductoAPI.getAll();
        call.enqueue(new Callback<List<Empleado>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {
                if(!response.isSuccessful()){
                    Toast toast=Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG);
                    toast.show();

                    Log.e("Response err: ",response.message());
                    return;
                }
                empleados=response.body();
                empleados.forEach(p -> {
                    int i = Log.i("Prods: ", p.getEmail());
                    EmailAddress=p.getEmail();
                });
                empleados.forEach(p -> {
                    int i = Log.i("Prods: ", p.getPassword());
                    Password=p.getPassword();
                });

                Log.i("prueba",EmailAddress);
                Log.i("prueba",Password);

            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                Toast toast=Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err: ",t.getMessage());
            }
        });
    }
}