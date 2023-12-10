package BUS;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.BookDAO;
import DAO.PublisherDAO;
import DAO.WarehouseDAO;
import DTO.entities.Book;
import DTO.entities.Publisher;
import DTO.entities.WareHouseBook;
import DTO.entities.Warehouse;
import connection.ConnectDB;

public class WareHouseBookBUS {
    private BookDAO bookDAO;
    private PublisherDAO publisherDAO;
    private WarehouseDAO warehouseDAO;
    private ConnectDB connectDB;
    public WareHouseBookBUS(ConnectDB connectDB) throws SQLException, IOException{
        try {
                this.connectDB = new ConnectDB();
        } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    
    public WareHouseBookBUS(WarehouseDAO warehouseDAO, BookDAO bookDAO, PublisherDAO publisherDAO) {
        this.warehouseDAO = warehouseDAO;
        this.bookDAO = bookDAO;
        this.publisherDAO = publisherDAO;
    }
    
    public List<WareHouseBook> getAllWareHouseBook() throws ClassNotFoundException, SQLException, IOException {
        List<WareHouseBook> warehouseBook = new ArrayList<>();
        List<Warehouse> w = warehouseDAO.getAllWH(); 
        List<Book> b = bookDAO.getAllBook();
        List<Publisher> p = publisherDAO.getAllPub();
        for (Warehouse i : w) {
            Publisher publisher = findPubID(p, i.getPublisherID());
            Book book = findBookID(b, i.getBookID());

            WareHouseBook whBook = new WareHouseBook(i, publisher, book);
            warehouseBook.add(whBook);
        }
        
        return warehouseBook;
    }

    private Book findBookID(List<Book> bookList, int bookID) {
        for (Book i : bookList) {
            if (i.getId()== bookID) {
                return i;
            }
        }
        return null; 
    }
    private Publisher findPubID(List<Publisher> pubList, int publisherID) {
        for (Publisher i : pubList) {
            if (i.getId()== publisherID) {
                return i;
            }
        }
        return null; 
    }
}
