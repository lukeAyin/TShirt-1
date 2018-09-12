package org.csu.tshirt.persistence;

import org.csu.tshirt.domain.Product;

public interface ProductDAO {
    Product getProduct(String productId);
}
