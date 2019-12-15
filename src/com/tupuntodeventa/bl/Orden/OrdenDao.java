package com.tupuntodeventa.bl.Orden;

import java.util.ArrayList;
import java.util.List;

public class OrdenDao implements IOrden {
    private static ArrayList<Orden> ordens = new ArrayList<>();
    @Override
    public List<Orden> getAll() {
        return ordens;
    }

    @Override
    public String save(Orden orden) {
        ordens.add(orden);
        return "Guardado";
    }
}
