package com.alex.util;

import com.alex.model.City;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Util {

    public static List<City> getCities(String path) {
        List<City> cities = new ArrayList<>();

        try (Scanner scan = new Scanner(new FileInputStream(path))) {
            scan.useDelimiter(";");
            while (scan.hasNext()) {
                cities.add(fromLineToCity(scan.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return cities;
    }

    private static City fromLineToCity(String line) {
        Scanner scan = new Scanner(line);
        City city = new City();
        scan.useDelimiter(";");

        scan.nextInt();
        city.setName(scan.next());
        city.setRegion(scan.next());
        city.setDistrict(scan.next());
        city.setPopulation(scan.nextInt());

        if (scan.hasNext()) {
            city.setFoundation(scan.next());
        } else {
            city.setFoundation("null");
        }
        scan.close();

        return city;
    }

    public static String getMaxPopulation(List<City> citiesList) {
        City[] cities = citiesList.toArray(new City[0]);
        int maxPopulation = 0;
        int maxID = 0;

        for (int i = 1; i < cities.length; i++) {
            if (cities[i].getPopulation() > maxPopulation) {
                maxPopulation = cities[i].getPopulation();
                maxID = i;
            }
        }
        return "[" + maxID + "]" + " = " + maxPopulation;
    }

    public static Map<String, Integer> getCountOfCitiesInRegion(List<City> cities) {
        Map<String, Integer> map = new HashMap<>();
        for (City city : cities) {
            if (map.containsKey(city.getRegion())) {
                map.replace(city.getRegion(), map.get(city.getRegion()) + 1);
            } else {
                map.put(city.getRegion(), 1);
            }
        }
        return map;
    }
}
