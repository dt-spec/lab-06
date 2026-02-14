package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {

    /**
     * The name of the city
     */
    private String city;

    /**
     * The province of the city
     */
    private String province;

    /**
     * Constructor for City
     * @param city Name of the city
     * @param province Name of the province
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return city name
     */
    public String getCityName(){
        return this.city;
    }

    /**
     * Gets the province name
     * @return province name
     */
    public String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return this.city.equals(city.city) &&
                this.province.equals(city.province);
    }

    @Override
    public int hashCode() {
        return city.hashCode() + province.hashCode();
    }
}
