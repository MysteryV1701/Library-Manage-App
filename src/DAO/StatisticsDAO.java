/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tính
 */
import DTO.entities.StatisticDTO;
import DTO.entities.TopBorrowedBook;
import connection.ConnectDB;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import jdk.jfr.Percentage;


public class StatisticsDAO {
    ConnectDB connectDB;
    public static StatisticDTO stt;
    
    public StatisticsDAO() throws ClassNotFoundException, SQLException, IOException{
        connectDB = new ConnectDB();
    }
    
    public  Vector<StatisticDTO> getAll() throws ClassNotFoundException, SQLException{
            Vector<StatisticDTO> datas = new Vector<>();
            connectDB.connect();
            if(ConnectDB.conn != null){
            try {
                String sql = "SELECT * FROM Statistic";
                PreparedStatement pst = ConnectDB.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    StatisticDTO sttDTO = new StatisticDTO();
                    sttDTO.setBank(rs.getFloat(2));
                    sttDTO.setSoLuotMuonBC(rs.getInt(3));
                    sttDTO.setSoLuotTra(rs.getInt(4));
                    sttDTO.setSoSachHong(rs.getInt(5));
                    sttDTO.setThoiGian(rs.getDate(1).toLocalDate());
                    datas.add(sttDTO);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connectDB.disconnect();
            }
        }
        return datas;
    }
    
    
    public Vector<TopBorrowedBook> topLuotMuon() throws ClassNotFoundException, SQLException{
        Vector<TopBorrowedBook> top = new Vector<>();
        connectDB.connect();
        if(ConnectDB.conn != null){
            try {
                String sql = "SELECT TOP 5 b.name AS bName, a.name AS aName, p.name AS pName, COUNT(dBC.ISBN)*dBC.num AS TongSoLuotMuon\n" +
                                "FROM borrow_card bc\n" +
                                "JOIN detail_borrow_card dBC ON dBC.bcID = bc.id\n" +
                                "JOIN cp_book cpB ON  cpB.ISBN = dBC.ISBN\n" +
                                "JOIN book b ON b.id = cpB.bookID\n" +
                                "JOIN author a ON a.id = b.id\n" +
                                "JOIN publisher p ON p.id = cpB.publisherID\n" +
                                "GROUP BY b.name, a.name, p.name, dBC.ISBN, dBC.num\n" +
                                "ORDER BY TongSoLuotMuon DESC";
                PreparedStatement pst = ConnectDB.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    TopBorrowedBook b = new TopBorrowedBook();
                    b.setNameBook(rs.getString(1));
                    b.setBookAuthor(rs.getString(2));
                    b.setNXB(rs.getString(3));
                    b.setSoLuotMuon(rs.getInt(4));
                    top.add(b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connectDB.disconnect();
            }
        }
        return top;
    }
    
    public void SoTienThu(Date time, float total) throws ClassNotFoundException, SQLException{
        connectDB.connect();              
        if(ConnectDB.conn != null){
            try {
                String checkSql = "SELECT 1 FROM Statistic WHERE time = ?";
                String updateSql = "UPDATE Statistic SET bank = bank + ? WHERE time = ?";
                String insertSql = "INSERT INTO Statistic (time, bank) VALUES (?, ?)";
                PreparedStatement pst = ConnectDB.conn.prepareStatement(checkSql);
                pst.setDate(1, (java.sql.Date) time);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    //Nếu cột có tồn tại
                    PreparedStatement pst1 = ConnectDB.conn.prepareCall(updateSql);
                    pst1.setFloat(1, total);
                    pst1.setDate(2, (java.sql.Date) time);
                    pst1.executeUpdate();
                }else{
                    //Nếu cột không tồn tại
                    PreparedStatement pst2 = ConnectDB.conn.prepareCall(insertSql);
                    pst2.setDate(1, (java.sql.Date) time);
                    pst2.setFloat(2, total);
                    pst2.executeUpdate();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connectDB.disconnect();
            }
        }
    }
    
    public void SoLuotMuon() throws ClassNotFoundException, SQLException{
        connectDB.connect();             
        if(ConnectDB.conn != null){
            try {
                //Lấy số phiếu mượn theo ngày tạo
                String sql ="MERGE INTO Statistic AS Target " +
                            "USING (SELECT startDate AS time, COUNT(*) AS numBC FROM borrow_card GROUP BY startDate) AS Source " +
                            "ON Target.time = Source.time " +
                            "WHEN MATCHED THEN UPDATE SET Target.numBC = Source.numBC " +
                            "WHEN NOT MATCHED THEN INSERT (time, numBC) VALUES (Source.time, Source.numBC);";
                PreparedStatement pst = ConnectDB.conn.prepareCall(sql);
                pst.executeUpdate();
                
                //Lấy số phiếu mượn đã được trả
                String sql1 = "MERGE INTO Statistic AS Target " +
                              "USING (SELECT expReDate AS NgayTra, COUNT(*) AS soLuotTra FROM borrow_card " +
                              "WHERE isActive = 0 GROUP BY expReDate) AS Source " +
                              "ON Target.time = Source.NgayTra " +
                              "WHEN MATCHED THEN UPDATE SET Target.numReturn = Source.soLuotTra " +
                              "WHEN NOT MATCHED THEN INSERT (time, numReturn) VALUES (Source.NgayTra, Source.soLuotTra);";            
                PreparedStatement pst1 = ConnectDB.conn.prepareStatement(sql1);
                pst1.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connectDB.disconnect();
            }
        }
    }  
    public void SoSachMat(Date time, int num) throws ClassNotFoundException, SQLException{
        connectDB.connect();               
        if(ConnectDB.conn != null){
            try {              
                String checkSql = "SELECT 1 FROM Statistic WHERE time = ?";
                String updateSql = "UPDATE Statistic SET bookLost = bookLost + ? WHERE time = ?";
                String insertSql = "INSERT INTO Statistic (time, bookLost) VALUES (?, ?)";
                PreparedStatement pst = ConnectDB.conn.prepareStatement(checkSql);
                pst.setDate(1, (java.sql.Date) time);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    PreparedStatement pst1 = ConnectDB.conn.prepareCall(updateSql);
                    pst1.setInt(1, num);
                    pst1.setDate(2, (java.sql.Date) time);
                    pst1.executeUpdate();
                }else{
                    PreparedStatement pst2 = ConnectDB.conn.prepareCall(insertSql);
                    pst2.setDate(1, (java.sql.Date) time);
                    pst2.setInt(2, num);
                    pst2.executeUpdate();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connectDB.disconnect();
            }
        }
    }
}
