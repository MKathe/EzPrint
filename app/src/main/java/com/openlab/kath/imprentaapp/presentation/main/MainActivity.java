package com.openlab.kath.imprentaapp.presentation.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.openlab.kath.imprentaapp.R;
import com.openlab.kath.imprentaapp.presentation.cotiza.CotizarActivity;
import com.openlab.kath.imprentaapp.presentation.estado.EstadoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_top)
    ImageView ivTop;
    @BindView(R.id.btn_cotizar)
    Button btnCotizar;
    @BindView(R.id.btn_estado)
    Button btnEstado;
    //private Button btn_cotiza;
    //private Button btn_estado;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

       /* btn_cotiza = findViewById(R.id.btn_cotizar);

        btn_estado = findViewById(R.id.btn_estado);

        btn_estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EstadoActivity.class);
                startActivity(intent);
            }
        });

        btn_cotiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CotizarActivity.class);
                startActivity(intent);
            }
        });*/

    }

    @OnClick({R.id.btn_cotizar, R.id.btn_estado})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cotizar:

                Intent intent_cotizar = new Intent(MainActivity.this, CotizarActivity.class);
                startActivity(intent_cotizar);
                break;
            case R.id.btn_estado:

                Intent intent = new Intent(MainActivity.this, EstadoActivity.class);
                startActivity(intent);

                break;
        }
    }
}
