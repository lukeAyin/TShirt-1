package org.csu.tshirt.persistence;

import org.csu.tshirt.domain.Item;//从数据库查找Item表的信息储存在bean中

import java.util.List;
import java.util.Map;
import java.sql.SQLException;
public interface ItemDAO {
    List<Item> getItemListByProduct(String productId);
    Item getItem(String itemId);
}
