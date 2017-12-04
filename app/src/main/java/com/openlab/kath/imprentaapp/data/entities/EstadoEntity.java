package com.openlab.kath.imprentaapp.data.entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kath on 3/12/17.
 */

public class EstadoEntity implements Serializable {
    private String _id;
    private int codigo;
    private String cliente;
    private int __v;
    private ArrayList<ListaEntity> listaItems;
    private String estado;


    public ArrayList<ListaEntity> getListaItems() {
        return listaItems;
    }

    public void setListaItems(ArrayList<ListaEntity> listaItems) {
        this.listaItems = listaItems;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
