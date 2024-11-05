package com.mycompany.inventorysystem.model;

import com.mycompany.inventorysystem.persistence.PersistenceController;
import java.util.List;

public class Controller {
    
    PersistenceController controlPersis = new PersistenceController();

    public void saveSupplier(String supplierName, String supplierCel) {
        Supplier sup = new Supplier();
            sup.setSuName(supplierName);
            sup.setSuPhone(supplierCel);
            
            controlPersis.saveSupplier(sup);
        }

    public void saveCategory(String categoryName) {
            Category cat = new Category();
            cat.setCatName(categoryName);
            
            controlPersis.saveCategory(cat);
        }

    public List<Product> getProducts() {
         
        return controlPersis.getProducts();
        
    }

    public List<Category> getAllCategories() {
        
        return controlPersis.getAllCategories();
        
    }

    public List<Supplier> getAllSuppliers() {
        
        return controlPersis.getAllSuppliers();
        
    }

    public void saveProduct(String productName, String productDescription, double price, int stock, String category, String supplier) {
        
        
        
    }
    
    
    
}
