package com.openlab.kath.imprentaapp.data.entities;

import java.io.Serializable;

/**
 * Created by kath on 3/12/17.
 */

public class ListaEntity implements Serializable {

    private int nroItem;
    private String descripcion;
    private String _id;

    public int getNroItem() {
        return nroItem;
    }

    public void setNroItem(int nroItem) {
        this.nroItem = nroItem;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
