package com.openlab.kath.imprentaapp.presentation.estado;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.openlab.kath.imprentaapp.R;
import com.openlab.kath.imprentaapp.data.entities.EstadoEntity;
import com.openlab.kath.imprentaapp.data.entities.ListaEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by kath on 3/12/17.
 */

public class EstadoFragment extends Fragment implements EstadoContract.View {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    Unbinder unbinder;
    @BindView(R.id.tv_cliente)
    TextView tvCliente;
    private EstadoContract.Presenter mPresenter;
    private Button btn_enviar;
    private EditText et_cod;
    private TextView tv_result;


    private EstadoAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;


    public EstadoFragment() {
        // Requires empty public constructor
    }

    public static EstadoFragment newInstance() {
        return new EstadoFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new EstadoPresenter(this, getContext());

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_estado, container, false);

        et_cod = root.findViewById(R.id.et_cod);
        tv_result = root.findViewById(R.id.tv_result);
        btn_enviar = root.findViewById(R.id.btn_enviar);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLayoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(mLayoutManager);
        mAdapter = new EstadoAdapter(new ArrayList<ListaEntity>(), getContext());
        rvList.setAdapter(mAdapter);
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "text", Toast.LENGTH_SHORT).show();
                mPresenter.sendResponse(Integer.valueOf(et_cod.getText().toString()));
            }
        });

    }

    @Override
    public void resposeError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void responseOk(EstadoEntity estadoEntity) {
        tv_result.setText(estadoEntity.getEstado());
        tvCliente.setText(estadoEntity.getCliente());
        mAdapter.setItems(estadoEntity.getListaItems());
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(EstadoContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
