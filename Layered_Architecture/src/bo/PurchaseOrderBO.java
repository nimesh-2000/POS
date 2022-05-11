package bo;

import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBO<T,Y,Z,ID> {
     T searchCustomer(ID id) throws SQLException, ClassNotFoundException;


     Y searchItem(ID code) throws SQLException, ClassNotFoundException;


     boolean checkItemIsAvailable(ID code) throws SQLException, ClassNotFoundException;


     boolean checkCustomerIsAvailable(ID id) throws SQLException, ClassNotFoundException;

     String generateNewOrderID() throws SQLException, ClassNotFoundException;


     ArrayList<T> getAllCustomers() throws SQLException, ClassNotFoundException;


     ArrayList<Y> getAllItems() throws SQLException, ClassNotFoundException;

     boolean purchaseOrder(ID orderId, LocalDate orderDate, ID customerId, List<Z> orderDetails) throws SQLException, ClassNotFoundException;
}
