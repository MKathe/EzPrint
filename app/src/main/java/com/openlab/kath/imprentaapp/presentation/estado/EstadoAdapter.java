package com.openlab.kath.imprentaapp.presentation.estado;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openlab.kath.imprentaapp.R;
import com.openlab.kath.imprentaapp.core.LoaderAdapter;
import com.openlab.kath.imprentaapp.data.entities.ListaEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by katherine on 15/05/17.
 */

public class EstadoAdapter extends LoaderAdapter<ListaEntity> {

    private Context context;


    public EstadoAdapter(ArrayList<ListaEntity> cityEntities, Context context) {
        super(context);
        setItems(cityEntities);
        this.context = context;

    }


    public ArrayList<ListaEntity> getItems() {
        return (ArrayList<ListaEntity>) getmItems();
    }

    @Override
    public long getYourItemId(int position) {
        return getmItems().get(position).getNroItem();
    }

    @Override
    public RecyclerView.ViewHolder getYourItemViewHolder(ViewGroup parent) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(root);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void bindYourViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListaEntity listaEntity = getItems().get(position);

        ((ViewHolder)holder).tvDescript.setText(listaEntity.getDescripcion());
        ((ViewHolder)holder).tvItem.setText("Pedido nro: " + String.valueOf(listaEntity.getNroItem()));


    }


    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_item)
        TextView tvItem;
        @BindView(R.id.tv_descript)
        TextView tvDescript;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //onClickListListener.onClick(getAdapterPosition());
        }
    }
}
