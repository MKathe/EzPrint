package com.openlab.kath.imprentaapp.data.remote.request;
import com.openlab.kath.imprentaapp.data.entities.EstadoEntity;
import com.openlab.kath.imprentaapp.data.entities.ResponseEstado;

import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by katherine on 10/05/17.
 */

public interface LoginRequest {

    @GET("trabajos/{codigo}")
    Call<EstadoEntity> getEstado(@Path("codigo") int codigo);


}
