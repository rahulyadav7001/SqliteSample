
package com.ryandro.sqlitesample;

import java.util.List;

public class PlantsDO {

    /* @SerializedName("plants")
     @Expose*/
    private List<Plant> plants = null;

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

}
