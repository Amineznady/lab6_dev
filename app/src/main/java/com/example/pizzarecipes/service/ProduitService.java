package com.example.pizzarecipes.service;

import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;
import com.example.pizzarecipes.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed();
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) INSTANCE = new ProduitService();
        return INSTANCE;
    }

    private void seed() {
        data.add(new Produit("BARBECUED CHICKEN PIZZA", 3, R.drawable.pizza1, "35 min", "Ingredients ...", "Pizza au poulet barbecue simple et rapide.", "STEP 1...\nSTEP 2..."));
        data.add(new Produit("SPINACH PIZZA", 2, R.drawable.pizza2, "25 min", "Ingredients ...", "Pizza crémeuse et légère aux légumes.", "STEP 1...\nSTEP 2..."));
        data.add(new Produit("BRUSCHETTA PIZZA", 5, R.drawable.pizza3, "35 min", "Ingredients ...", "Pizza italienne classique.", "STEP 1...\nSTEP 2..."));
        data.add(new Produit("DEEP-DISH SAUSAGE PIZZA", 8, R.drawable.pizza4, "45 min", "Ingredients ...", "Pizza épaisse américaine.", "STEP 1...\nSTEP 2..."));
        data.add(new Produit("HOMEMADE PIZZA", 4, R.drawable.pizza5, "50 min", "Ingredients ...", "Pizza maison traditionnelle.", "STEP 1...\nSTEP 2..."));
        data.add(new Produit("PESTO CHICKEN PIZZA", 3, R.drawable.pizza6, "50 min", "Ingredients ...", "Pizza poulet pesto.", "STEP 1...\nSTEP 2..."));
        data.add(new Produit("LOADED MEXICAN PIZZA", 3, R.drawable.pizza7, "30 min", "Ingredients ...", "Pizza mexicaine épicée.", "STEP 1...\nSTEP 2..."));
        data.add(new Produit("BACON CHEESEBURGER PIZZA", 2, R.drawable.pizza8, "20 min", "Ingredients ...", "Pizza burger.", "STEP 1...\nSTEP 2..."));
        data.add(new Produit("PIZZA MARGHERITA", 1, R.drawable.pizza9, "30 min", "Ingredients ...", "Pizza classique italienne.", "STEP 1...\nSTEP 2..."));
        data.add(new Produit("PEPPERONI-SAUSAGE STUFFED PIZZA", 5, R.drawable.pizza10, "45 min", "Ingredients ...", "Pizza farcie.", "STEP 1...\nSTEP 2..."));
    }

    @Override
    public Produit create(Produit p) {
        data.add(p);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(x -> x.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(data);
    }
}