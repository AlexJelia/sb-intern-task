package com.alex.util;

import com.alex.model.City;

import java.util.Comparator;
import java.util.List;

public class Sorter {

    public static void sortByName(List<City> cities) {
        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    public static void sortByDistrict(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }
}
