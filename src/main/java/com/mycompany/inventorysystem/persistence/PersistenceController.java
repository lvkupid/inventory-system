package com.mycompany.inventorysystem.persistence;

import com.mycompany.inventorysystem.model.Category;

public class PersistenceController {
    
    //instancio los jpacontroller
    CategoryJpaController categoryJpa = new CategoryJpaController();
    ProductJpaController productJpa = new ProductJpaController();
    SupplierJpaController supplierJpa = new SupplierJpaController();

    public void saveCategory(Category cat) {
        categoryJpa.create(cat);
        
    }
    
    
    
}
