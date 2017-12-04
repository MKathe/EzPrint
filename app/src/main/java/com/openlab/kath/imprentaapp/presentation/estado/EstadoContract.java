package com.openlab.kath.imprentaapp.presentation.estado;

import com.openlab.kath.imprentaapp.core.BasePresenter;
import com.openlab.kath.imprentaapp.core.BaseView;
import com.openlab.kath.imprentaapp.data.entities.EstadoEntity;

import java.lang.ref.SoftReference;

/**
 * Created by kath on 3/12/17.
 */

public class EstadoContract {
    interface View extends BaseView<Presenter> {
        void resposeError(String msg);
        void responseOk(EstadoEntity estadoEntity);
        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        void sendResponse(int cod);


    }
}
