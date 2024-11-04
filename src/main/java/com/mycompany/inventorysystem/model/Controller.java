package com.mycompany.inventorysystem.model;

import com.mycompany.inventorysystem.persistence.PersistenceController;

public class Controller {
    
    PersistenceController controlPersis = new PersistenceController();

    public void saveProduct(String productName, String productDescription, double price, int stock, String category, String supplier) {
        }

    public void saveCategory(String categoryName) {
            Category cat = new Category();
            cat.setCatName(categoryName);
            
            controlPersis.saveCategory(cat);
        }
    
    
    
}
