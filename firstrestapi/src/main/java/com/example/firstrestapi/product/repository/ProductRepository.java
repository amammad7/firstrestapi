package com.example.firstrestapi.product.repository;

import com.example.firstrestapi.product.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private final Map<Long, Product> database = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public Product save(Product product) {
        return setId(product);
    }

    private Product setId(Product product) {
        if (product.getId() == null) {
            product.setId(idGenerator.incrementAndGet());
        }
        database.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }
}