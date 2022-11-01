package com.example.lab8;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    void testAddException() {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        list.addCity(city);
        assertThrows( IllegalArgumentException.class, () -> {list.addCity(city); });
    }

    @Test
    void testHasCities() {
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        Assertions.assertEquals(false, list.hasCities(city));
        list.addCity(city);
        Assertions.assertEquals(true, list.hasCities(city));
    }

    @Test
    void testDeleteCities() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        Assertions.assertEquals(1, list.getCities().size());
        list.deleteCities(city);
        Assertions.assertEquals(0, list.getCities().size());
    }

    @Test
    void testDeleteCitiesException() {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        assertThrows( IllegalArgumentException.class, () -> {list.deleteCities(city); });
    }

    @Test
    void testCountCities() {
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        Assertions.assertEquals(0, list.getCities().size());
        list.addCity(city);
        Assertions.assertEquals(1, list.getCities().size());
        list.deleteCities(city);
        Assertions.assertEquals(0, list.getCities().size());
    }
}
