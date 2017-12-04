package com.openlab.kath.imprentaapp.presentation.cotiza;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.openlab.kath.imprentaapp.R;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kath on 3/12/17.
 */

public class CotizarActivity extends AppCompatActivity {

    @BindView(R.id.et_servicio)
    EditText etServicio;
    @BindView(R.id.et_color)
    EditText etColor;
    @BindView(R.id.et_material)
    EditText etMaterial;
    @BindView(R.id.et_alto)
    EditText etAlto;
    @BindView(R.id.et_ancho)
    EditText etAncho;
    @BindView(R.id.btn_solicitar)
    Button btnSolicitar;

    private String msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizar);
        ButterKnife.bind(this);
    }


    protected void sendEmail() {

        String servicio = etServicio.getText().toString();
        String material = etMaterial.getText().toString();
        String color = etColor.getText().toString();
        String alto = etAlto.getText().toString();
        String ancho = etAncho.getText().toString();

        msg = "Se requiere cotizar una impresión con las siguientes características: "+
                "   Servicio:    " +  servicio +
                "   Material:    " +  material +
                "   Color:    " +  color +
                "   Medidas alto:    " + alto +
                "   Medidas ancho:   " + ancho;

        String[] TO = {"katherine.caillahua@gmail.com"}; //aquí pon tu correo
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
// Esto podrás modificarlo si quieres, el asunto y el cuerpo del mensaje
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Cotización de impresión");
        emailIntent.putExtra(Intent.EXTRA_TEXT, msg);
        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
            finish();
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(CotizarActivity.this,
                    "No tienes clientes de email instalados.", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_solicitar)
    public void onViewClicked() {
        sendEmail();
    }
}
