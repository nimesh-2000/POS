package dao;

import db.DBConnection;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new ItemDTO(rst.getString(1), rst.getString(2), rst.getBigDecimal(3), rst.getInt(4)));
        }
        return allItems;
    }
    //deleteItem
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?", code);

    }
    //add item
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
    }
   // update item
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());

    }
    //exist item
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?", code).next();
    }
     // generate item id
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
}
