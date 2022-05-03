package dao;

import db.DBConnection;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    //deleteItem
     boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    //add item
     boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    // update item
     boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    //exist item
     boolean existItem(String code) throws SQLException, ClassNotFoundException;
    // generate item id
     String generateNewId() throws SQLException, ClassNotFoundException;
}
