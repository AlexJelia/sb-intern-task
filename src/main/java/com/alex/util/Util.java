package com.alex.util;

import com.alex.model.City;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
}
