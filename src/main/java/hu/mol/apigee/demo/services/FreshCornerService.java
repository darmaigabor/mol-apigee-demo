package hu.mol.apigee.demo.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

import hu.mol.apigee.demo.model.Shop;
import hu.mol.apigee.demo.model.Meal;
import hu.mol.apigee.demo.model.Drink;

@Path("/masterdata")
public class FreshCornerService {

    @GET
    @Path("shops")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Shop> getShops() {
        ArrayList shops = new ArrayList<Shop>();
        shops.add(new Shop("1", "Budaörs, Repülőtér (Kinizsi u. 4047/2 hrsz.)"));
        shops.add(new Shop("2", "Budapest, Borszéki u."));
        shops.add(new Shop("3", "Budapest, Hunyadi János út 2. (XI.)"));
        shops.add(new Shop("4", "Budapest, Mezőkövesd út 1."));
        shops.add(new Shop("5", "Budapest, Prielle Kornélia u. (XI.)"));
        shops.add(new Shop("6", "Budapest, Weiss Manfréd út (XXI.)"));
        shops.add(new Shop("7", "Budapest, Könyves Kálmán krt. 23 (X.)"));
        shops.add(new Shop("8", "Budapest, Kőbányai út (X.) "));
        shops.add(new Shop("9", "Budapest Kerepesi út 5-7. (VIII.)"));
        return shops;
    }

    @GET
    @Path("meals")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Meal> getMeals() {
        ArrayList meals = new ArrayList<Meal>();
        meals.add(new Meal("1", "Amerikai hot-dog", "A virsli és a kifli klasszikus képlete. A tengerentúl slágere pirított hagymával, jalapenoval.", "890 Ft", "https://freshcorner.hu/file/slides/0/0636/fe_400_400_400x400_amerikai_hotdog.png"));
        return meals;
	}

    @GET
    @Path("drinks")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Drink> getDrinks() {
        ArrayList drinks = new ArrayList<Drink>();
        drinks.add(new Drink("1", "Tea", "Tökéletes meditáció. Egy nagy adag tea a kedvenc ízében.", "350 Ft", "https://freshcorner.hu/file/slides/0/0636/fe_400_400_400x400_amerikai_hotdog.png"));
        return drinks;
	}

}
