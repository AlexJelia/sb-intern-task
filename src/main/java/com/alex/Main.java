package com.alex;

import com.alex.model.City;
import com.alex.util.Util;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Список городов
        List<City> cities = Util.getCities("data.csv");

        //Количество городов в каждом регионе
        System.out.println(Util.getCountOfCitiesInRegion(cities));
    }
}
