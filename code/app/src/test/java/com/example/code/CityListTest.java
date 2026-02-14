package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    /**
     * Creates a mock CityList with one default city.
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Creates a mock City object.
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Tests adding cities to the list.
     */
    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        // Initially contains 1 city
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        // Now should contain 2 cities
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Tests that adding a duplicate city throws exception.
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        // Adding duplicate should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Tests that getCities() returns cities sorted alphabetically.
     */
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // Check first city matches mockCity
        assertEquals(0,
                mockCity().compareTo(cityList.getCities().get(0)));

        // Add city that should come first alphabetically
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Charlottetown should now be first
        assertEquals(0,
                city.compareTo(cityList.getCities().get(0)));

        // Edmonton should now be second
        assertEquals(0,
                mockCity().compareTo(cityList.getCities().get(1)));
    }
}
