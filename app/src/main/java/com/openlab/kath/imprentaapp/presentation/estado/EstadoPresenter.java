package com.openlab.kath.imprentaapp.presentation.estado;

import android.content.Context;
import android.support.annotation.NonNull;

import com.openlab.kath.imprentaapp.data.entities.EstadoEntity;
import com.openlab.kath.imprentaapp.data.entities.ResponseEstado;
import com.openlab.kath.imprentaapp.data.remote.ServiceFactory;
import com.openlab.kath.imprentaapp.data.remote.request.LoginRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kath on 3/12/17.
 */

public class EstadoPresenter implements EstadoContract.Presenter {

    private final EstadoContract.View mView;
    private Context context;

    public EstadoPresenter(@NonNull EstadoContract.View mView, @NonNull Context context) {
        this.context = context;
        this.mView = mView;
        this.mView.setPresenter(this);


    }
    @Override
    public void sendResponse(int cod) {
        LoginRequest loginService =
                ServiceFactory.createService(LoginRequest.class);
        Call<EstadoEntity> call = loginService.getEstado(cod);
        mView.setLoadingIndicator(true);
        call.enqueue(new Callback<EstadoEntity>() {
            @Override
            public void onResponse(Call<EstadoEntity> call, Response<EstadoEntity> response) {
               if(!mView.isActive()){
                    return;
                }
                if (response.isSuccessful()) {
                    mView.responseOk(response.body());

                } else {
                    mView.setLoadingIndicator(false);
                    mView.resposeError("Obtener estado fallido");
                }
            }

            @Override
            public void onFailure(Call<EstadoEntity> call, Throwable t) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.resposeError("No se puede conectar al servidor");
            }
        });
    }

    @Override
    public void start() {

    }
}
