package org.csu.tshirt.persistence.impl;

import org.csu.tshirt.domain.Item;
import org.csu.tshirt.persistence.ItemDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
    DataSource dataSource=(DataSource) context.getBean("dataSource");
    @Override
    public List<Item> getItemListByProduct(String productId) {
        Connection connection=null;
        PreparedStatement pstmt=null;


        List<Item> listItem;
        listItem =new ArrayList<>();
        try{
            connection=dataSource.getConnection();
            String sql="select Item.Item_ID from Item WHERE Product_ID=#{productId}";
            pstmt=connection.prepareStatement(sql);
            for(int i=1;i<pstmt.getFetchSize();i++){
                Item item=getItem(pstmt.getResultSet().getString(i));
                listItem.add(item);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listItem;
    }

    @Override
    public Item getItem(String itemId) {
        Connection connection=null;
        PreparedStatement pstmt=null;

        Item item= (Item) context.getBean("Item");
        try{
            connection=dataSource.getConnection();
            String sql="select Item.Item_name,Item.Product_ID,Item.Item_color,Item.Item_pic from Item WHERE Item.Item_ID=#{itemId}";
            pstmt=connection.prepareStatement(sql);
            item.setItemId(itemId);
            item.setItemName(pstmt.getResultSet().getString(1));//查询结果放入bean中
            item.setItemColor(pstmt.getResultSet().getString(3));
            item.setItemImage(pstmt.getResultSet().getString(4));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return item;
    }
}
