package com.tupuntodeventa.bl.Position;

import com.tupuntodeventa.bl.User.User;

import java.util.List;

public interface IPosition {
    List<Position> getAll();

    String save(Position position);

    Position searchByName(String name);
}
