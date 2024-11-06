package com.mycompany.inventorysystem.persistence;

import com.mycompany.inventorysystem.model.Category;
import com.mycompany.inventorysystem.model.Product;
import com.mycompany.inventorysystem.model.Supplier;
import com.mycompany.inventorysystem.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

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

    public void saveProduct(Product prod) {
        productJpa.create(prod);
    }

    public Category findCategoryById(int catId) {
        EntityManager em = categoryJpa.getEntityManager();
        try {
            return em.find(Category.class, catId);
        } finally {
            em.close();
        }
    }

    public Supplier findSupplierById(int suppId) {
        EntityManager em = supplierJpa.getEntityManager();
        try {
            return em.find(Supplier.class, suppId);
        } finally {
            em.close();
        }
    }

    public void deleteProduct(int prodId) {
        try {
            productJpa.destroy(prodId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Product getProduct(int prodId) {
        return productJpa.findProduct(prodId);
    }

    public void modifyProduct(Product PROD) {
        try {
            productJpa.edit(PROD);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
