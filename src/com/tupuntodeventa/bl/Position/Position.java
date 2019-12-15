package com.tupuntodeventa.bl.Position;

import java.time.LocalDate;
import java.util.Objects;

public class Position {
    private String name;
    private int baseSalary;
    private int bonus;
    private int totalSalary;
    private LocalDate dayContract;

    public Position(String name, int baseSalary, int bonus, int totalSalary, LocalDate dayContract) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.totalSalary = totalSalary;
        this.dayContract = dayContract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public LocalDate getDayContract() {
        return dayContract;
    }

    public void setDayContract(LocalDate dayContract) {
        this.dayContract = dayContract;
    }

    @Override
    public String toString() {
        return "Puestos{" +
                "name='" + name + '\'' +
                ", baseSalary=" + baseSalary +
                ", bonus=" + bonus +
                ", totalSalary=" + totalSalary +
                ", dayContract=" + dayContract +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position puestos = (Position) o;
        return baseSalary == puestos.baseSalary &&
                bonus == puestos.bonus &&
                totalSalary == puestos.totalSalary &&
                Objects.equals(name, puestos.name) &&
                Objects.equals(dayContract, puestos.dayContract);
    }
}
