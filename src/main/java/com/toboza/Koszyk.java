package com.toboza;

import java.util.HashMap;

public class Koszyk {
    int id_koszyk;
    String owner;
    HashMap<Integer, Double> itemMap;
    double pos_qty=0;
    double koszyk_value=0;

    public Koszyk(int id_koszyk, String owner) {
        this.id_koszyk = id_koszyk;
        this.owner = owner;
    }

    public int getId_koszyk() {
        return id_koszyk;
    }

    public void setId_koszyk(int id_koszyk) {
        this.id_koszyk = id_koszyk;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public HashMap<Integer, Double> getItemMap() {
        return itemMap;
    }

    public void putItem(Integer item_id, Double qty) {
        this.itemMap.put(item_id, qty);
        this.pos_qty = pos_qty++;
    }

    public void removeItem(Integer item_id, Double qty) {
        if (this.itemMap.containsKey(item_id)) {
            if (this.itemMap.get(item_id) <= qty) {
                this.itemMap.remove(item_id);
                this.pos_qty--;
            } else {
                Double temp_qty = this.itemMap.get(item_id) - qty;
                this.itemMap.remove(item_id);
                this.itemMap.put(item_id, temp_qty);
            }

        }
    }


    public double getKoszyk_value() {
        return koszyk_value;
    }


}

