package com.tupuntodeventa.bl.Orden;

import java.util.List;

public interface IOrden {
    List<Orden> getAll();

    String save(Orden orden);
}
