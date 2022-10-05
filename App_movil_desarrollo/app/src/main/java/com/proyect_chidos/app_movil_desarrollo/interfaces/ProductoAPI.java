package com.proyect_chidos.app_movil_desarrollo.interfaces;

import com.proyect_chidos.app_movil_desarrollo.model.Empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProductoAPI {

    @GET("/consultar/{id}")
    Call<List<Empleado>>getOne(@Path("id")long id);
    @GET("/consultarAll")
    Call<List<Empleado>>getAll();
    @POST("/guardar")
    Call<Empleado> addEmpleado(@Body Empleado empleado);
}
