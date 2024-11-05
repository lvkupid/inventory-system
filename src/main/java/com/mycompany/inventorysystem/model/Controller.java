package com.mycompany.inventorysystem.model;

import com.mycompany.inventorysystem.persistence.PersistenceController;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;

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

    public void saveProduct(String productName, String productDescription, double price, int stock, int catId, int suppId) {
        
        Product prod = new Product();
        prod.setProdName(productName);
        prod.setProdDesc(productDescription);
        prod.setProdPrice(BigDecimal.valueOf(price));
        prod.setProdStock(stock);
        
        Category category = controlPersis.findCategoryById(catId);
        if (category != null) {
            prod.setCategory(category);
        } else {
            JOptionPane.showMessageDialog(null, "Category not found. Please ensure the category ID is correct.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Buscar el proveedor existente
        Supplier supplier = controlPersis.findSupplierById(suppId);
        if (supplier != null) {
            prod.setSupplier(supplier);
        } else {
            JOptionPane.showMessageDialog(null, "Supplier not found. Please ensure the supplier ID is correct.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        prod.setCategory(category);
        prod.setSupplier(supplier);
        
        controlPersis.saveProduct(prod);
        
    }
    
    
    
}
