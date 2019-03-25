package hu.mol.apigee.demo.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

    private String id;
    private String dateTime;
    private Shop shop;
    private List<Meal> meals;
    private List<Drink> drinks;

    public Order(){
    }

    public Order(String id, String dateTime, Shop shop, List<Meal> meals, List<Drink> drinks) {
        this.id = id;
        this.dateTime = dateTime;
        this.shop = shop;
        this.meals = meals;
        this.drinks = drinks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

}