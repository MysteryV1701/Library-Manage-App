/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.RolePermissionBUS;
import MyDesign.ScrollBar;
import connection.ConnectDB;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BUS.SupplyCardWithStaffBUS;
import BUS.WareHouseBookBUS;
import DAO.BookDAO;
import DAO.PublisherDAO;
import DAO.StaffDAO;
import DAO.SupplyCardDAO;
import DAO.SupplyCardDetailDAO;
import DAO.WarehouseDAO;
import DTO.entities.Account;
import DTO.entities.SupplyCardDetail;
import DTO.entities.SupplyCardWithStaff;
import DTO.entities.WareHouseBook;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author QUANG DIEN
 */
public class WareHouse_GUI extends javax.swing.JPanel {
    private SupplyCardDAO supplyCardDAO;
    private Account user;
    private RolePermissionBUS rolePermissionBUS;
    private SupplyCardWithStaffBUS supplyCardWithStaffBUS;
    private SupplyCardDetailDAO supplyCardDetailDAO;
    private WarehouseDAO warehouseDAO;
    private WareHouseBookBUS wareHouseBookBUS;
    
	/**
     * Creates new form WareHouse_GUI
     */
    public WareHouse_GUI(Account user) throws SQLException, SQLException, IOException, ClassNotFoundException {
        initComponents();
        this.user = user;
        this.rolePermissionBUS = new RolePermissionBUS();
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        spTable.setViewportView(tbLichSuNhapHang);
        spTable2.setVerticalScrollBar(new ScrollBar());
        spTable2.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable2.getViewport().setBackground(Color.WHITE);
        spTable2.setViewportView(tbSach);
        p.setBackground(Color.WHITE);
        spTable2.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
    public WareHouse_GUI() throws SQLException, SQLException, IOException, ClassNotFoundException {
        initComponents();
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        spTable.setViewportView(tbLichSuNhapHang);
        spTable2.setViewportView(tbSach);
        spTable2.setVerticalScrollBar(new ScrollBar());
        spTable2.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable2.getViewport().setBackground(Color.WHITE);
        p.setBackground(Color.WHITE);
        spTable2.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        if(rolePermissionBUS.hasPerCreate(this.user.getRoleID(), 4))
            btnNhapSach.setEnabled(true);
        else btnNhapSach.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException, IOException, ClassNotFoundException {

        panelBorder1 = new MyDesign.PanelBorder();
        jLabel5 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tbLichSuNhapHang = new MyDesign.MyTable();
        tbSach = new MyDesign.MyTable();
        
        SupplyCardDAO supplyCardDAO = new SupplyCardDAO(connectDB);
        StaffDAO staffDAO = new StaffDAO();
        
        WarehouseDAO warehouseDAO = new WarehouseDAO(connectDB);
        BookDAO bookDAO = new BookDAO();
        PublisherDAO publisherDAO = new PublisherDAO(connectDB);
        
        SupplyCardDetailDAO supplyCardDetailDAO = new SupplyCardDetailDAO(connectDB);
       
        List<SupplyCardWithStaff> supplyCardWithStaffList = new ArrayList<>();
        List<SupplyCardDetail> supplyCardDetail = new ArrayList<>();
        supplyCardDetail = supplyCardDetailDAO.getAllSupplyCardDetail();
        supplyCardWithStaffList = supplyCardDAO.getAllSupplyCardWithStaff();
        List<WareHouseBook> warehouseBookList = new ArrayList<>();
        warehouseBookList = warehouseDAO.getAllWarehouseBook();
        jLabel7 = new javax.swing.JLabel();
        spTable2 = new javax.swing.JScrollPane();
        panelBorder_Basic1 = new MyDesign.PanelBorder_Basic();
        jLabel8 = new javax.swing.JLabel();
        txtTimKiem = new MyDesign.SearchText();
        btnNhapSach = new MyDesign.MyButton();

        
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 127, 127));
        jLabel5.setText("Lịch sử nhập hàng");

        spTable.setBorder(null);

        tbLichSuNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ngày nhập", "Nhà cung cấp", "Tổng chi", "Thủ kho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        // Xử lý dữ liệu và hiển thị trong JTable hoặc thành phần giao diện khác
        DefaultTableModel model = (DefaultTableModel) tbLichSuNhapHang.getModel();

        for (SupplyCardWithStaff supplyCardWithStaff : supplyCardWithStaffList) {
            // Tạo một mảng các Object chứa thông tin cần hiển thị
            Object[] rowData = {
            	(Object)(model.getRowCount()+1),
                supplyCardWithStaff.getSupply_Card().getSupDate(),
                supplyCardWithStaff.getSupply_Card().getProvider(),
                supplyCardWithStaff.getSupply_Card().getTongchi(),
                supplyCardWithStaff.getStaff().getName()
            };
            model.addRow(rowData);
        }
        
//        tbLichSuNhapHang.addMouseListener(new MouseAdapter() {
//        	public void mouseClicked(MouseEvent e)
//        	{
//                if (e.getClickCount() == 1 || e.getClickCount() == 2) {
//                    DefaultTableModel model = (DefaultTableModel) tbLichSuNhapHang.getModel();
//                    int selectedRow = tbLichSuNhapHang.getSelectedRow();
//                    if (selectedRow >= 0) {
//                        Object ngayNhap = tbLichSuNhapHang.getValueAt(selectedRow, 1);
//
//                        // Chuyển đổi ngày nhập từ Object sang định dạng phù hợp để truy vấn cơ sở dữ liệu
//                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                        String ngayNhapString = dateFormat.format(ngayNhap); // Định dạng ngày nhập
//
//                        // Gọi phương thức trong DAO để lấy danh sách chi tiết phiếu nhập dựa trên ngày nhập
//                        List<SupplyCardDetail> supplyCardDetails = supplyCardDetailDAO.getSupplyCardDetailsByDate(ngayNhapString);
//
//                        // Xóa các dòng hiện tại trong bảng tbChiTietPhieuNhap
//                        DefaultTableModel model2 = (DefaultTableModel) tbSach.getModel();
//                        model2.setRowCount(0);
//
//                        // Thêm các chi tiết phiếu nhập mới vào bảng tbChiTietPhieuNhap
//                        for (SupplyCardDetail detail : supplyCardDetails) {
//                            Object[] rowData = {
//                                    detail.getScID(),
//                                    detail.getISBN(),
//                                    detail.getNum()
//                            };
//                            model2.addRow(rowData);
//                        }
//                    }
//                }
//            }
//        });
        
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(127, 127, 127));
        jLabel7.setText("Sách");

        spTable2.setBorder(null);

        tbSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
            		"STT", "Tên Sách", "Số lượng mượn", "Số lượng sách", "Tái bản", "NXB", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        DefaultTableModel model2 = (DefaultTableModel) tbSach.getModel();

        for (WareHouseBook warehouseBook : warehouseBookList) {
            // Tạo một mảng các Object chứa thông tin cần hiển thị
            Object[] rowData = {
            	(Object)(model2.getRowCount()+1),
            	warehouseBook.getB().getName(),
            	warehouseBook.getW().getBorrowNum(),
            	warehouseBook.getW().getStoreNum(),
            	warehouseBook.getW().getEdition(),
            	warehouseBook.getP().getName(),
            	warehouseBook.getW().getCost()
            };
            model2.addRow(rowData);
        }
        
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        
        
        jLabel8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 || e.getClickCount() == 2) {
                    DefaultTableModel model = (DefaultTableModel) tbLichSuNhapHang.getModel(); // Lấy model của JTable

                    String searchInput = txtTimKiem.getText().trim();
                    String key = "NXB";
                    String keyDate = "20-";
                    if (!searchInput.isEmpty()) {
                    	if(!isNumeric(searchInput))
                    	{
                    		if(containsString(searchInput, keyDate)) {
                    			timkiemSupDate();
                    		}
                    		else {
                    			timkiemNameStaff();
                    		}
                    	}
                    }else {
                    	loadAll();
                    }
                }
            }
        });        
        
        txtTimKiem.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Xử lý khi người dùng nhấn Enter
                    DefaultTableModel model = (DefaultTableModel) tbLichSuNhapHang.getModel(); // Lấy model của JTable

                    String searchInput = txtTimKiem.getText().trim();
                    String key = "NXB";
                    String keyDate = "20-";
                    if (!searchInput.isEmpty()) {
                    	if(!isNumeric(searchInput))
                    	{
                    		if(containsString(searchInput, keyDate)) {
                    			timkiemSupDate();
                    		}
                    		else {
                    			timkiemNameStaff();
                    		}
                    	}
                    }else {
                    	loadAll();
                    }
                }
            }
		});
        javax.swing.GroupLayout panelBorder_Basic1Layout = new javax.swing.GroupLayout(panelBorder_Basic1);
        panelBorder_Basic1.setLayout(panelBorder_Basic1Layout);
        panelBorder_Basic1Layout.setHorizontalGroup(
            panelBorder_Basic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder_Basic1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBorder_Basic1Layout.setVerticalGroup(
            panelBorder_Basic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder_Basic1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder_Basic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder_Basic1Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnNhapSach.setBackground(new java.awt.Color(22, 113, 221));
        btnNhapSach.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/warehouse-white.png"))); // NOI18N
        btnNhapSach.setText("Nhập sách");
        btnNhapSach.setToolTipText("");
        btnNhapSach.setBorderColor(new java.awt.Color(22, 113, 221));
        btnNhapSach.setColor(new java.awt.Color(22, 113, 221));
        btnNhapSach.setColorClick(new java.awt.Color(153, 204, 255));
        btnNhapSach.setColorOver(new java.awt.Color(22, 113, 221));
        btnNhapSach.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        
        btnNhapSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				WareHouseImport_Dialog whid;
                try {
                    whid = new WareHouseImport_Dialog(null, getFocusTraversalKeysEnabled());
                    whid.setVisible(true);
                    if (whid != null && !whid.isVisible()) {
    			        // Dialog đã đóng, thực hiện các thao tác tiếp theo
                    	DefaultTableModel model = (DefaultTableModel) tbLichSuNhapHang.getModel();
                    	List<SupplyCardWithStaff> supplyCardWithStaffList = new ArrayList<>();
                    	supplyCardWithStaffList = supplyCardDAO.getAllSupplyCardWithStaff();
                    	model.setRowCount(0);
                    	for (SupplyCardWithStaff supplyCardWithStaff : supplyCardWithStaffList) {
                            // Tạo một mảng các Object chứa thông tin cần hiển thị
                            Object[] rowData = {
                            	(Object)(model.getRowCount()+1),
                                supplyCardWithStaff.getSupply_Card().getSupDate(),
                                supplyCardWithStaff.getSupply_Card().getProvider(),
                                supplyCardWithStaff.getSupply_Card().getTongchi(),
                                supplyCardWithStaff.getStaff().getName()
                            };
                            model.addRow(rowData);
                        }
                    	
                    	DefaultTableModel model2 = (DefaultTableModel) tbSach.getModel();
                    	List<WareHouseBook> warehouseBookList = new ArrayList<>();
                        warehouseBookList = warehouseDAO.getAllWarehouseBook();
                        model2.setRowCount(0);
                    	for (WareHouseBook warehouseBook : warehouseBookList) {
                            // Tạo một mảng các Object chứa thông tin cần hiển thị
                            Object[] rowData = {
                            	(Object)(model2.getRowCount()+1),
                            	warehouseBook.getB().getName(),
                            	warehouseBook.getW().getBorrowNum(),
                            	warehouseBook.getW().getStoreNum(),
                            	warehouseBook.getW().getEdition(),
                            	warehouseBook.getP().getName(),
                            	warehouseBook.getW().getCost()
                            };
                            model2.addRow(rowData);
                        }
    			    }
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
				
			}
		});
        
        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNhapSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBorder_Basic1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                        .addComponent(spTable2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder_Basic1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhapSach, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    public static boolean isAlpha(String str) {
        return str.matches("[a-zA-Z]+");
    }
    public static boolean containsStringIgnoreCase(String text, String searchString) {
        // Chuyển đổi cả hai chuỗi thành chữ thường trước khi so sánh
        return text.toUpperCase().contains(searchString.toUpperCase());
    }
    public static boolean containsString(String text, String searchString) {
        return text.contains(searchString);
    }
    public void timkiemNameStaff() {
    	DefaultTableModel model = (DefaultTableModel) tbLichSuNhapHang.getModel(); // Lấy model của JTable

        String searchInput = txtTimKiem.getText().trim();
        try {
                        supplyCardDAO = new SupplyCardDAO(connectDB);
			List<SupplyCardWithStaff> supplyCardWithStaffList = supplyCardDAO.searchByStaff(searchInput);
			model.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng

			for (SupplyCardWithStaff supplyCardWithStaff : supplyCardWithStaffList) {
			    // Tạo một mảng các Object chứa thông tin cần hiển thị
			    Object[] rowData = {
			        (model.getRowCount() + 1),
			        supplyCardWithStaff.getSupply_Card().getSupDate(),
			        supplyCardWithStaff.getSupply_Card().getProvider(),
			        supplyCardWithStaff.getSupply_Card().getTongchi(),
			        supplyCardWithStaff.getStaff().getName()
			    };
			    model.addRow(rowData);
			}
			if (supplyCardWithStaffList.isEmpty()) {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Định dạng tìm kiếm không đúng (ghi rõ Họ Tên) hoặc dữ liệu đó không tồn tại.","Lỗi",JOptionPane.ERROR_MESSAGE);
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Định dạng tìm kiếm không đúng (ghi rõ Họ Tên) hoặc dữ liệu đó không tồn tại.","Lỗi",JOptionPane.ERROR_MESSAGE);
		}
    }
    public void timkiemSupDate() {
        DefaultTableModel model = (DefaultTableModel) tbLichSuNhapHang.getModel();
        String searchInput = txtTimKiem.getText().trim();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = sdf.parse(searchInput);
            Timestamp selectedTimestamp = new Timestamp(parsedDate.getTime()); // Lấy thời gian từ ngày đã chọn
            try {
                supplyCardDAO = new SupplyCardDAO(connectDB);
            } catch (SQLException ex) {
                Logger.getLogger(WareHouse_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(WareHouse_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<SupplyCardWithStaff> supplyCardWithStaffList = supplyCardDAO.searchBySupDate(selectedTimestamp);
            model.setRowCount(0);

            for (SupplyCardWithStaff supplyCardWithStaff : supplyCardWithStaffList) {
                Object[] rowData = {
                    (model.getRowCount() + 1),
                    supplyCardWithStaff.getSupply_Card().getSupDate(),
                    supplyCardWithStaff.getSupply_Card().getProvider(),
                    supplyCardWithStaff.getSupply_Card().getTongchi(),
                    supplyCardWithStaff.getStaff().getName()
                };
                model.addRow(rowData);
            }
            // Kiểm tra nếu bảng trống rỗng
            if (supplyCardWithStaffList.isEmpty()) {
            	JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Định dạng tìm kiếm không đúng (ghi rõ yyyy-MM-dd) hoặc dữ liệu đó không tồn tại.","Lỗi",JOptionPane.ERROR_MESSAGE);
            }
        } catch (ParseException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Định dạng tìm kiếm không đúng (ghi rõ yyyy-MM-dd) hoặc dữ liệu đó không tồn tại.","Lỗi",JOptionPane.ERROR_MESSAGE);
        }
    }



    public void loadAll() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbLichSuNhapHang.getModel(); // Lấy model của JTable
            supplyCardDAO = new SupplyCardDAO(connectDB);
            String searchInput = txtTimKiem.getText().trim();
            List<SupplyCardWithStaff> supplyCardWithStaffList = supplyCardDAO.getAllSupplyCardWithStaff();
            model.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng
            
            for (SupplyCardWithStaff supplyCardWithStaff : supplyCardWithStaffList) {
                // Tạo một mảng các Object chứa thông tin cần hiển thị
                Object[] rowData = {
                    (model.getRowCount() + 1),
                    supplyCardWithStaff.getSupply_Card().getSupDate(),
                    supplyCardWithStaff.getSupply_Card().getProvider(),
                    supplyCardWithStaff.getSupply_Card().getTongchi(),
                    supplyCardWithStaff.getStaff().getName()
                };
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WareHouse_GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WareHouse_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MyDesign.MyButton btnNhapSach;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private MyDesign.PanelBorder panelBorder1;
    private MyDesign.PanelBorder_Basic panelBorder_Basic1;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable2;
    public MyDesign.MyTable tbSach;
    public MyDesign.MyTable tbLichSuNhapHang;
    private MyDesign.SearchText txtTimKiem;
    private ConnectDB connectDB;
    // private SupplyCardDAO supplyCardDAO=new SupplyCardDAO(connectDB);
    private WareHouseImport_Dialog whid;
    private WareHouseSearch_Dialog whsdc;
    // private WareHouseScanner_Dialog whscd;
    private SupplyCardWithStaffBUS scws;
    // End of variables declaration//GEN-END:variables
}