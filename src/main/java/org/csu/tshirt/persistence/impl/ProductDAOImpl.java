package org.csu.tshirt.persistence.impl;

import org.csu.tshirt.domain.Product;
import org.csu.tshirt.persistence.ProductDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAOImpl implements ProductDAO {
    ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
    DataSource dataSource= (DataSource) context.getBean("dataSource");
    @Override
    public Product getProduct(String productId) {
        Connection connection=null;
        PreparedStatement pstmt=null;
        Product product= (Product) context.getBean("Product");
        try{
            connection=dataSource.getConnection();
            String sql="select Product.Product_name,Product.Product_price from Product WHERE Product.Product_ID=#{productId}";
            pstmt=connection.prepareStatement(sql);
            product.setProductId(productId);
            product.setProductName(pstmt.getResultSet().getString(1));
            product.setProductPrice(pstmt.getResultSet().getBigDecimal(2));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return product;
    }
}
