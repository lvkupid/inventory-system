package com.mycompany.inventorysystem.persistence;

import com.mycompany.inventorysystem.model.Category;
import com.mycompany.inventorysystem.model.Product;
import com.mycompany.inventorysystem.model.Supplier;
import java.util.List;

public class PersistenceController {
    
    //instancio los jpacontroller
    CategoryJpaController categoryJpa = new CategoryJpaController();
    ProductJpaController productJpa = new ProductJpaController();
    SupplierJpaController supplierJpa = new SupplierJpaController();

    public void saveCategory(Category cat) {
        categoryJpa.create(cat);
        
    }

    public List<Product> getProducts() {
        
        return productJpa.findProductEntities();
        
    }

    public void saveSupplier(Supplier sup) {
        
        supplierJpa.create(sup);
    
    }

    public List<Category> getAllCategories() {
        return categoryJpa.findCategoryEntities();
    }

    public List<Supplier> getAllSuppliers() {
        return supplierJpa.findSupplierEntities();
    }
    
    
    
}
