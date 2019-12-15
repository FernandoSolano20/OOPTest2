package com.tupuntodeventa.bl.Position;

import java.util.ArrayList;
import java.util.List;

public class PositionDao implements IPosition {
    private static ArrayList<Position> positions = new ArrayList<>();
    @Override
    public List<Position> getAll() {
        return positions;
    }

    @Override
    public String  save(Position position) {
        if(searchByName(position.getName()) == null){
            positions.add(position);
            return "Guardado";
        }
        return "Error";
    }

    @Override
    public Position searchByName(String name) {
        for (Position position:positions) {
            if(position.getName().equals(name)){
                return position;
            }
        }
        return null;
    }
}
