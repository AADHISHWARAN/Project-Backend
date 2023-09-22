package com.example.project.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productID;

    private String productName;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("products")
    private Set<Customer> customers = new HashSet<>();

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setcustomers(Set<Customer> customers) {
        this.customers = customers;
        for (Customer customer : customers) {
            customer.setProducts(this);
        }
    }
}