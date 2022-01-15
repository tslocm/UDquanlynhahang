//package com.iuh.quanlynhahang.guis;
//
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.ListSelectionModel;
//import javax.swing.ScrollPaneConstants;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//
//import org.apache.commons.lang3.RandomStringUtils;
//
//import com.iuh.quanlynhahang.daoimpls.LoaiMonDAOImpl;
//import com.iuh.quanlynhahang.daoimpls.MonDAOImpl;
//import com.iuh.quanlynhahang.entities.LoaiMon;
//import com.iuh.quanlynhahang.entities.Mon;
//
//public class MonUI extends JFrame implements ActionListener {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 4306434632363466260L;
//	public JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MonUI frame = new MonUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	private JScrollPane scrollPane;
//	private DefaultTableModel tableModel;
//	private DefaultTableModel modelDVT;
//	private JTable tableMonAn;
//	private JPanel panel;
//	private JButton btnTimKiem;
//	private JLabel lblNhpTnNgi;
//	private JPanel panel_1;
//	private JLabel lblThngTinTi;
//	private JLabel lblMTiKhon;
//	private JLabel lblTnTiKhon;
//	private JLabel lblMKhchHng;
//	private JButton btnLamMoi;
//	private JButton btnThem;
//	private JButton btnXoa;
//	private JButton btnCapNhat;
//	private JTextField txtTimMonAn;
//	private JTextField txtMaMon;
//	private JButton btnLamMoiDuLieu;
//	private JLabel lblTrngThit;
//	private JTextField txtTenMon;
//	private JTextField txtGiaTien;
//	@SuppressWarnings("rawtypes")
//	private JComboBox cbxLoaiMon;
//	private static final String PRICE_PATTERN = "^[0-9]*$";
//
//	private static LoaiMonDAOImpl loaiMonDAO = new LoaiMonDAOImpl();
//	private static MonDAOImpl monDAO = new MonDAOImpl();
//	private JTextField txtDonViTinh;
//	private JButton btnThemDVT;
//	private JTable table;
//	private JButton btnXoaDVT;
//	private static List<String> donViTinhs = new ArrayList<String>();// for create, update
//	private static List<String> dvts = new ArrayList<String>();
//
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public MonUI() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1084, 551);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//
//		JLabel lblTiKhon = new JLabel("MÓN ĂN");
//		lblTiKhon.setForeground(Color.RED);
//		lblTiKhon.setFont(new Font("Times New Roman", Font.BOLD, 25));
//
//		String[] header = "STT;Mã Món;Tên Món;Loại Món;Giá Tiền".split(";");
//		tableModel = new DefaultTableModel(header, 0);
//		scrollPane = new JScrollPane(tableMonAn = new JTable(tableModel), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
//				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		tableMonAn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		panel = new JPanel();
//		panel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "T\u00ECm M\u00F3n \u0102n",
//				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
//
//		btnTimKiem = new JButton("Tìm");
//		btnTimKiem.setIcon(new ImageIcon("images\\search.png"));
//		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		lblNhpTnNgi = new JLabel("Nhập Tên Món");
//		lblNhpTnNgi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		panel_1 = new JPanel();
//		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
//
//		lblThngTinTi = new JLabel("Thông TinMón Ăn");
//		lblThngTinTi.setForeground(Color.BLACK);
//		lblThngTinTi.setFont(new Font("Times New Roman", Font.BOLD, 18));
//
//		lblMTiKhon = new JLabel("Mã Món");
//		lblMTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		lblTnTiKhon = new JLabel("Tên Món");
//		lblTnTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		lblMKhchHng = new JLabel("Loại Món");
//		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		GroupLayout gl_contentPane = new GroupLayout(contentPane);
//		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
//				.createSequentialGroup().addContainerGap()
//				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createSequentialGroup().addGap(440).addComponent(lblTiKhon,
//								GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
//						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
//						.addGroup(gl_contentPane.createSequentialGroup()
//								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE).addGap(12)))
//				.addPreferredGap(ComponentPlacement.RELATED)
//				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)));
//		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
//				.createSequentialGroup().addContainerGap().addComponent(lblTiKhon).addGap(23)
//				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
//						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
//								Short.MAX_VALUE)
//						.addGroup(gl_contentPane.createSequentialGroup()
//								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
//								.addPreferredGap(ComponentPlacement.RELATED)
//								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
//				.addGap(4)));
//
//		txtTimMonAn = new JTextField();
//		txtTimMonAn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtTimMonAn.setColumns(10);
//
//		btnLamMoiDuLieu = new JButton("Làm Mới Dữ Liệu");
//		btnLamMoiDuLieu.setIcon(new ImageIcon("images\\refresh.png"));
//		btnLamMoiDuLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		GroupLayout gl_panel = new GroupLayout(panel);
//		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(lblNhpTnNgi)
//						.addPreferredGap(ComponentPlacement.UNRELATED)
//						.addComponent(txtTimMonAn, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
//						.addPreferredGap(ComponentPlacement.UNRELATED)
//						.addComponent(btnTimKiem, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
//						.addPreferredGap(ComponentPlacement.UNRELATED)
//						.addComponent(btnLamMoiDuLieu, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
//						.addContainerGap()));
//		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
//				.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE)
//				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
//						.addComponent(lblNhpTnNgi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
//						.addComponent(txtTimMonAn, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
//						.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
//						.addComponent(btnLamMoiDuLieu, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
//				.addGap(19)));
//		panel.setLayout(gl_panel);
//
//		txtMaMon = new JTextField();
//		txtMaMon.setEditable(false);
//		txtMaMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtMaMon.setColumns(10);
//
//		btnThem = new JButton("Thêm");
//		btnThem.setIcon(new ImageIcon("images\\add.png"));
//		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		btnXoa = new JButton("Xóa");
//		btnXoa.setIcon(new ImageIcon("images\\delete.png"));
//		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		btnCapNhat = new JButton("Cập Nhật");
//		btnCapNhat.setIcon(new ImageIcon("images\\edit.png"));
//		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		btnLamMoi = new JButton("Làm Mới");
//		btnLamMoi.setIcon(new ImageIcon("images\\refresh.png"));
//		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		lblTrngThit = new JLabel("Giá Tiền");
//		lblTrngThit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		txtTenMon = new JTextField();
//		txtTenMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtTenMon.setColumns(10);
//
//		cbxLoaiMon = new JComboBox();
//		cbxLoaiMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		txtGiaTien = new JTextField();
//		txtGiaTien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtGiaTien.setColumns(10);
//
//		JLabel lblnVTnh = new JLabel("Đơn Vị Tính");
//		lblnVTnh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//
//		txtDonViTinh = new JTextField();
//		txtDonViTinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtDonViTinh.setColumns(10);
//
//		btnThemDVT = new JButton("Thêm");
//		btnThemDVT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		btnXoaDVT = new JButton("Xóa");
//		btnXoaDVT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
//		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
//				.createSequentialGroup().addContainerGap()
//				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
//						.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
//								.addComponent(lblnVTnh)
//								.addGroup(gl_panel_1.createSequentialGroup()
//										.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
//										.addPreferredGap(ComponentPlacement.RELATED)
//										.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
//										.addPreferredGap(ComponentPlacement.RELATED)
//										.addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
//										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLamMoi,
//												GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
//						.addPreferredGap(ComponentPlacement.RELATED))
//						.addGroup(gl_panel_1.createSequentialGroup()
//								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
//										.addGroup(gl_panel_1.createSequentialGroup()
//												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
//														.addComponent(lblTnTiKhon, GroupLayout.PREFERRED_SIZE, 65,
//																GroupLayout.PREFERRED_SIZE)
//														.addComponent(lblMKhchHng))
//												.addGap(18).addGroup(gl_panel_1
//														.createParallelGroup(Alignment.LEADING)
//														.addComponent(
//																txtTenMon, GroupLayout.DEFAULT_SIZE, 320,
//																Short.MAX_VALUE)
//														.addComponent(cbxLoaiMon, 0, 320, Short.MAX_VALUE)))
//										.addGroup(gl_panel_1.createSequentialGroup()
//												.addComponent(lblTrngThit, GroupLayout.PREFERRED_SIZE, 73,
//														GroupLayout.PREFERRED_SIZE)
//												.addPreferredGap(ComponentPlacement.UNRELATED)
//												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
//														.addGroup(gl_panel_1.createSequentialGroup()
//																.addComponent(txtDonViTinh, GroupLayout.DEFAULT_SIZE,
//																		144, Short.MAX_VALUE)
//																.addPreferredGap(ComponentPlacement.RELATED)
//																.addComponent(btnThemDVT, GroupLayout.PREFERRED_SIZE,
//																		82, GroupLayout.PREFERRED_SIZE)
//																.addPreferredGap(ComponentPlacement.RELATED)
//																.addComponent(btnXoaDVT, GroupLayout.PREFERRED_SIZE, 82,
//																		GroupLayout.PREFERRED_SIZE))
//														.addComponent(txtGiaTien, GroupLayout.DEFAULT_SIZE, 320,
//																Short.MAX_VALUE)
//														.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 320,
//																Short.MAX_VALUE)))
//										.addGroup(gl_panel_1.createSequentialGroup()
//												.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 65,
//														GroupLayout.PREFERRED_SIZE)
//												.addGap(19).addComponent(txtMaMon, GroupLayout.DEFAULT_SIZE, 319,
//														Short.MAX_VALUE)))
//								.addGap(36)))
//				.addGap(0))
//				.addGroup(gl_panel_1.createSequentialGroup().addGap(143)
//						.addComponent(lblThngTinTi, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
//						.addContainerGap(159, Short.MAX_VALUE)));
//		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblThngTinTi).addGap(11)
//						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
//								.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
//								.addComponent(txtMaMon, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
//						.addGap(19)
//						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
//								.addComponent(lblTnTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
//								.addComponent(txtTenMon, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
//						.addGap(18)
//						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
//								.addComponent(cbxLoaiMon, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
//								.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
//						.addGap(18)
//						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
//								.addComponent(txtGiaTien, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
//								.addComponent(lblTrngThit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
//						.addGroup(gl_panel_1
//								.createParallelGroup(Alignment.LEADING)
//								.addGroup(gl_panel_1.createSequentialGroup().addGap(18).addComponent(lblnVTnh,
//										GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
//								.addGroup(
//										gl_panel_1.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
//												.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
//														.addComponent(btnXoaDVT, GroupLayout.PREFERRED_SIZE, 31,
//																GroupLayout.PREFERRED_SIZE)
//														.addComponent(btnThemDVT, GroupLayout.PREFERRED_SIZE, 31,
//																GroupLayout.PREFERRED_SIZE)))
//								.addGroup(gl_panel_1.createSequentialGroup().addGap(11).addComponent(txtDonViTinh,
//										GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
//						.addPreferredGap(ComponentPlacement.RELATED)
//						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
//						.addPreferredGap(ComponentPlacement.UNRELATED)
//						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
//								.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
//								.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
//								.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
//								.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
//						.addContainerGap()));
//
//		table = new JTable();
//		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		modelDVT = new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Đơn Vị Tính" });
//		table.setModel(modelDVT);
//		scrollPane_1.setViewportView(table);
//
//		panel_1.setLayout(gl_panel_1);
//		contentPane.setLayout(gl_contentPane);
//		cbxLoaiMon.addActionListener(this);
//		btnTimKiem.addActionListener(this);
//		btnCapNhat.addActionListener(this);
//		btnThem.addActionListener(this);
//		btnLamMoiDuLieu.addActionListener(this);
//		btnLamMoi.addActionListener(this);
//		btnXoa.addActionListener(this);
//		btnThemDVT.addActionListener(this);
//		btnXoaDVT.addActionListener(this);
//
////		tableMonAn.addMouseListener(this);
//		tableMonAn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		for (int c = 0; c < tableMonAn.getColumnCount(); c++) {
//			Class<?> col_class = tableMonAn.getColumnClass(c);
//			tableMonAn.setDefaultEditor(col_class, null); // remove editor
//		}
//
////		table.addMouseListener(this);
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		for (int c = 0; c < table.getColumnCount(); c++) {
//			Class<?> col_class = table.getColumnClass(c);
//			table.setDefaultEditor(col_class, null); // remove editor
//		}
//
//		tableMonAn.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				modelDVT = (DefaultTableModel) table.getModel();
//				modelDVT.getDataVector().removeAllElements();
////		        JTable source = (JTable)e.getSource();
////		        int row = source.rowAtPoint( e.getPoint() );
////		        int column = source.columnAtPoint( e.getPoint() );
////
////		        if (! source.isRowSelected(row))
////		            source.changeSelection(row, column, false, false);
////				modelDVT.fireTableDataChanged();
//				int row = tableMonAn.getSelectedRow();
//				System.out.println("row " + row);
//				if (row != -1) {
//					String maMon = tableModel.getValueAt(row, 1).toString();
////					dvts = new ArrayList<String>();
////					dvts.clear();
//					try {
//						Mon mon = monDAO.getMonByMa(maMon);
//						txtMaMon.setText(mon.getMaMon());
//						txtTenMon.setText(mon.getTenMon());
//						txtGiaTien.setText(mon.getGiaTien().toString());
//						cbxLoaiMon.setSelectedItem(mon.getLoaiMon().getTenLoaiMon());
////						dvts.clear();
//						dvts = mon.getDonViTinh();
//						dvts.forEach(x -> System.out.println("======" + x));
//
//						int i = 0;
//						for (String dvt : dvts) {
//							i++;
//							modelDVT.addRow(new Object[] { i, dvt });
//							table.setModel(modelDVT);
//							modelDVT.fireTableDataChanged();
//						}
//					} catch (Exception e2) {
//						System.out.println("error mouse clicked");
//						e2.printStackTrace();
//					}
//					modelDVT.fireTableDataChanged();
//				}
//
//			}
//		});
//
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent me) {
////				if (me.getClickCount() == 2) { // to detect doble click events
////					JTable target = (JTable) me.getSource();
////					int row = target.getSelectedRow(); // select a row
//////	               int column = target.getSelectedColumn(); // select a column
////					String dvt = (String) table.getValueAt(row, 1);
////					System.out.println(dvt);
//////					JOptionPane.showMessageDialog(null, table.getValueAt(row, 1)); // get the value of a row and column.
////				}
//				System.out.println("click");
//				int row = table.getSelectedRow();
////				System.out.println(table.getValueAt(row, 1));
//
//			}
//		});
//
//		List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
//		for (LoaiMon loaiMon : loaiMons) {
//			cbxLoaiMon.addItem(loaiMon.getTenLoaiMon());
//		}
//
//		updateTable();
//		txtMaMon.setText(randomMaMonNotExisted());
//
//	}
//
////	@Override
////	public void mouseClicked(MouseEvent e) {
////		int row = tableMonAn.getSelectedRow();
////		String maMon = tableModel.getValueAt(row, 1).toString();
////		dvts = new ArrayList<String>();
////		dvts.clear();
////		try {
////			Mon mon = monDAO.getMonByMa(maMon);
////			txtMaMon.setText(mon.getMaMon());
////			txtTenMon.setText(mon.getTenMon());
////			txtGiaTien.setText(mon.getGiaTien().toString());
////			cbxLoaiMon.setSelectedItem(mon.getLoaiMon().getTenLoaiMon());
////
////			dvts = mon.getDonViTinh();
////			int i = 0;
////			for (String dvt : dvts) {
////				i++;
////				modelDVT.addRow(new Object[] { i, dvt });
////				table.setModel(modelDVT);
////			}
////		} catch (Exception e2) {
////			System.out.println("error mouse clicked");
////			e2.printStackTrace();
////		}
////	}
//
////	@Override
////	public void mousePressed(MouseEvent e) {
////	}
////
////	@Override
////	public void mouseReleased(MouseEvent e) {
////	}
////
////	@Override
////	public void mouseEntered(MouseEvent e) {
////	}
////
////	@Override
////	public void mouseExited(MouseEvent e) {
////	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object obj = e.getSource();
//		if (obj.equals(btnThem)) {
//			try {
//				if (checkExistedTenMon() == true) {
//
//					boolean checkE = checkExistedId();
//					if (checkE) {
//
//						String maMon = txtMaMon.getText().trim();
//						String tenMon = txtTenMon.getText().trim();
//						String tenLoaiMon = cbxLoaiMon.getSelectedItem().toString();
//						String giaTien = txtGiaTien.getText().trim();
//						StringBuilder msg = new StringBuilder();
//						boolean check = true;
//						if (tenMon.isEmpty()) {
//							msg.append("Vui lòng nhập tên món!\n");
//							check = false;
//						}
//						if (giaTien.isEmpty()) {
//							msg.append("Vui lòng nhập giá tiền!\n");
//							check = false;
//						} else if (giaTien.matches(PRICE_PATTERN) == false) {
//							msg.append("Giá tiền không hợp lệ!\n");
//							check = false;
//						}
//
//						List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
//						for (LoaiMon loaiMon : loaiMons) {
//							if (tenMon.equalsIgnoreCase(loaiMon.getTenLoaiMon())) {
//								msg.append("Tên món ăn không được trùng với tên loại món!");
//								check = false;
//								break;
//							}
//
//						}
//
//						if (check == false) {
//							JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.ERROR_MESSAGE,
//									new ImageIcon("images\\warning.png"));
//						} else {
//							boolean checkIdExisted = checkExistedId();
//							if (checkIdExisted == false) {
//								JOptionPane.showMessageDialog(this, "Mã món đã tồn tại. Vui lòng làm mới dữ liệu nhập!",
//										"Thông báo", JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//							} else {
//								BigDecimal giaTienBD = new BigDecimal(giaTien);
//								LoaiMon loaiMon = loaiMonDAO.getLoaiMonByTenLoai(tenLoaiMon);
//								Mon mon = new Mon(maMon, tenMon, loaiMon, giaTienBD, donViTinhs);
//								monDAO.createMon(mon);
//								JOptionPane.showMessageDialog(this, "Thêm món thành công!", "Thông báo",
//										JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
//								updateTable();
//								donViTinhs.clear();
//								refresh();
//								modelDVT = (DefaultTableModel) table.getModel();
//								modelDVT.getDataVector().removeAllElements();
//								modelDVT.fireTableDataChanged();
//							}
//
//						}
//
//					} else {
//						JOptionPane.showMessageDialog(this, "Món đã tồn tại. Vui lòng làm mới dữ liệu nhập!",
//								"Thông báo", JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//					}
//				} else {
//					JOptionPane.showMessageDialog(this, "Món đã tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE,
//							new ImageIcon("images\\warning.png"));
//				}
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		} else if (obj.equals(btnLamMoi)) {
//			cbxLoaiMon.removeAllItems();
//			List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
//			for (LoaiMon loaiMon : loaiMons) {
//				cbxLoaiMon.addItem(loaiMon.getTenLoaiMon());
//			}
//			refresh();
//			modelDVT = (DefaultTableModel) table.getModel();
//			modelDVT.getDataVector().removeAllElements();
//			modelDVT.fireTableDataChanged();
//			tableMonAn.getSelectionModel().clearSelection();
//			donViTinhs.clear();
//		} else if (obj.equals(btnXoa)) {
//			int row = tableMonAn.getSelectedRow();
//			if (row != -1) {
//				String maMon = txtMaMon.getText();
//				try {
//					Mon mon = monDAO.getMonByMa(maMon);
//					boolean check = monDAO.deleteMon(mon);
//					if (check) {
//						JOptionPane.showMessageDialog(this, "Xóa món thành công!", "Thông báo",
//								JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
//						updateTable();
//						refresh();
//					} else {
//						JOptionPane.showMessageDialog(this, "Xóa món thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE,
//								new ImageIcon("images\\warning.png"));
//					}
//				} catch (Exception e2) {
//					e2.printStackTrace();
//					JOptionPane.showMessageDialog(this, "Lỗi. Vui lòng thử lại!", "Thông báo",
//							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//				}
//			} else {
//				JOptionPane.showMessageDialog(this, "Vui lòng chọn món để xóa!", "Thông báo", JOptionPane.ERROR_MESSAGE,
//						new ImageIcon("images\\warning.png"));
//			}
//		} else if (obj.equals(btnCapNhat)) {
//			int row = tableMonAn.getSelectedRow();
//			if (row != -1) {
//				String maMon = txtMaMon.getText().trim();
//				String tenMon = txtTenMon.getText().trim();
//				String tenLoaiMon = cbxLoaiMon.getSelectedItem().toString();
//				String giaTien = txtGiaTien.getText().trim();
//				StringBuilder msg = new StringBuilder();
//				boolean check = true;
//				if (tenMon.isEmpty()) {
//					msg.append("Vui lòng nhập tên món!\n");
//					check = false;
//				}
//				if (giaTien.isEmpty()) {
//					msg.append("Vui lòng nhập giá tiền!\n");
//					check = false;
//				} else if (giaTien.matches(PRICE_PATTERN)) {
//					msg.append("Giá tiền không hợp lệ!\n");
//					check = false;
//				}
//
//				if (check == false) {
//					JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.ERROR_MESSAGE,
//							new ImageIcon("images\\warning.png"));
//				} else {
//
//					BigDecimal giaTienBD = new BigDecimal(giaTien);
//					Mon mon = monDAO.getMonByMa(maMon);
//					LoaiMon loaiMon = loaiMonDAO.getLoaiMonByTenLoai(tenLoaiMon);
//					mon.setTenMon(tenMon);
//					mon.setLoaiMon(loaiMon);
//					mon.setGiaTien(giaTienBD);
//					mon.setDonViTinh(donViTinhs);
//					monDAO.updateMon(mon);
//					JOptionPane.showMessageDialog(this, "Cập nhật món thành công!", "Thông báo",
//							JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
//					updateTable();
//					refresh();
//					donViTinhs.clear();
////					updateTableDVT();
//					modelDVT = (DefaultTableModel) table.getModel();
//					modelDVT.getDataVector().removeAllElements();
//					modelDVT.fireTableDataChanged();
////					modelDVT.getDataVector().removeAllElements();
////					tableMonAn.getSelectionModel().clearSelection();
//				}
//
//			}
//		} else if (obj.equals(btnTimKiem)) {
//			String tenMon = txtTimMonAn.getText();
//			if (tenMon.isEmpty()) {
//				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên món cần tìm!", "Thông báo",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//				txtTimMonAn.requestFocus();
//			} else {
//				try {
//					Mon mon = monDAO.getMonByTen(tenMon);
//					tableModel.getDataVector().removeAllElements();
//					tableModel.addRow(new Object[] { 1, mon.getMaMon(), mon.getTenMon(),
//							mon.getLoaiMon().getTenLoaiMon(), mon.getGiaTien() });
//					txtTimMonAn.selectAll();
//					txtTimMonAn.requestFocus();
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(this, "Không tồn tại món!", "Thông báo", JOptionPane.ERROR_MESSAGE,
//							new ImageIcon("images\\warning.png"));
//					txtTimMonAn.selectAll();
//					txtTimMonAn.requestFocus();
//				}
//			}
//
//		} else if (obj.equals(btnLamMoiDuLieu)) {
//			updateTable();
//		} else if (obj.equals(btnThemDVT)) {
//			donViTinhs.addAll(dvts);
//			String donViTinh = txtDonViTinh.getText().trim();
//			if (donViTinh.isEmpty()) {
//				JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn vị tính!", "Thông báo",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//			} else {
//				if (!donViTinhs.contains(donViTinh)) {
//
//					modelDVT = (DefaultTableModel) table.getModel();
//					modelDVT.getDataVector().removeAllElements();
//					modelDVT.fireTableDataChanged();
//					donViTinhs.add(donViTinh);
//					txtDonViTinh.setText("");
//					txtDonViTinh.requestFocus();
//					updateTableDVT();
//				} else {
//					JOptionPane.showMessageDialog(this, "Đơn vị tính đã tồn tại!", "Thông báo",
//							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//				}
//			}
//		} else if (obj.equals(btnXoaDVT)) {
//			int row = table.getSelectedRow();
//			if (row != -1) {
//
////				if(dvts.isEmpty()) {
////					String donViTinh = (String) table.getValueAt(row, 1);
////					donViTinhs.remove(donViTinh);
////					updateTableDVT();
////				}else {
//				donViTinhs.addAll(dvts);
//				dvts.clear();
//				String donViTinh = (String) table.getValueAt(row, 1);
//				donViTinhs.remove(donViTinh);
//				modelDVT.removeRow(row);
//				updateTableDVT();
////				}
//			} else {
//				JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn vị tính để xóa!", "Thông báo",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//			}
//		}
//	}
//
//	public void updateTable() {
//		tableModel = (DefaultTableModel) tableMonAn.getModel();
//		tableModel.getDataVector().removeAllElements();
//		try {
//			List<Mon> mons = monDAO.getAllMon();
//			int i = 0;
//			for (Mon mon : mons) {
//				i++;
//				tableModel.addRow(new Object[] { i, mon.getMaMon(), mon.getTenMon(), mon.getLoaiMon().getTenLoaiMon(),
//						mon.getGiaTien() });
//			}
//			tableMonAn.setModel(tableModel);
//			tableMonAn.getSelectionModel().clearSelection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@SuppressWarnings("static-access")
//	public String randomMaMonNotExisted() {
//		String maMon;
//		List<String> idMons = new ArrayList<String>();
//		List<Mon> mons = monDAO.getAllMon();
//		for (Mon mon : mons) {
//			idMons.add(mon.getMaMon());
//		}
//		do {
//			RandomStringUtils randomStringUtils = new RandomStringUtils();
//			maMon = randomStringUtils.randomNumeric(8);
//
//		} while (idMons.contains(maMon));
//		return "M" + maMon;
//	}
//
//	private boolean checkExistedId() {
//		List<String> ids = new ArrayList<String>();
//		List<Mon> mons = monDAO.getAllMon();
//		for (Mon mon : mons) {
//			ids.add(mon.getMaMon());
//		}
//		if (ids.contains(txtMaMon.getText())) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	private boolean checkExistedTenMon() {
//		List<String> tenMons = new ArrayList<String>();
//		List<Mon> mons = monDAO.getAllMon();
//		for (Mon mon : mons) {
//			tenMons.add(mon.getTenMon());
//		}
//		if (tenMons.contains(txtTenMon.getText().trim())) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	private void refresh() {
//		txtMaMon.setText(randomMaMonNotExisted());
//		txtGiaTien.setText("");
//		txtTenMon.setText("");
//	}
//
//	public void updateTableDVT() {
//		modelDVT = (DefaultTableModel) table.getModel();
//		modelDVT.getDataVector().removeAllElements();
//		try {
//			int i = 0;
//			for (String dvt : donViTinhs) {
//				i++;
//				modelDVT.addRow(new Object[] { i, dvt });
//			}
//			table.setModel(modelDVT);
////			table.getSelectionModel().clearSelection();
////			modelDVT.fireTableDataChanged();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}

package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.commons.lang3.RandomStringUtils;

import com.iuh.quanlynhahang.daoimpls.LoaiMonDAOImpl;
import com.iuh.quanlynhahang.daoimpls.MonDAOImpl;
import com.iuh.quanlynhahang.entities.LoaiMon;
import com.iuh.quanlynhahang.entities.Mon;

public class MonUI extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4306434632363466260L;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MonUI frame = new MonUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable tableMonAn;
	private JPanel panel;
	private JButton btnTimKiem;
	private JLabel lblNhpTnNgi;
	private JPanel panel_1;
	private JLabel lblThngTinTi;
	private JLabel lblMTiKhon;
	private JLabel lblTnTiKhon;
	private JLabel lblMKhchHng;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JTextField txtTimMonAn;
	private JTextField txtMaMon;
	private JButton btnLamMoiDuLieu;
	private JLabel lblTrngThit;
	private JTextField txtTenMon;
	private JTextField txtGiaTien;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxLoaiMon;
	private static final String PRICE_PATTERN = "^[0-9]*$";
	private static NumberFormat df = new DecimalFormat("#,###.00 VNĐ");

	private static LoaiMonDAOImpl loaiMonDAO = new LoaiMonDAOImpl();
	private static MonDAOImpl monDAO = new MonDAOImpl();
	private JTextField txtDonViTinh;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MonUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTiKhon = new JLabel("MÓN ĂN");
		lblTiKhon.setForeground(Color.RED);
		lblTiKhon.setFont(new Font("Times New Roman", Font.BOLD, 25));

		String[] header = "STT;Mã Món;Tên Món;Loại Món;Giá Tiền;Đơn Vị Tính".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(tableMonAn = new JTable(tableModel), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableMonAn.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "T\u00ECm M\u00F3n \u0102n",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		btnTimKiem = new JButton("Tìm");
		btnTimKiem.setIcon(new ImageIcon("images\\search.png"));
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblNhpTnNgi = new JLabel("Nhập Tên Món");
		lblNhpTnNgi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));

		lblThngTinTi = new JLabel("Thông TinMón Ăn");
		lblThngTinTi.setForeground(Color.BLACK);
		lblThngTinTi.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblMTiKhon = new JLabel("Mã Món");
		lblMTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTnTiKhon = new JLabel("Tên Món");
		lblTnTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng = new JLabel("Loại Món");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(440).addComponent(lblTiKhon,
								GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE).addGap(12)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblTiKhon).addGap(23)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
				.addGap(4)));

		txtTimMonAn = new JTextField();
		txtTimMonAn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTimMonAn.setColumns(10);

		btnLamMoiDuLieu = new JButton("Làm Mới Dữ Liệu");
		btnLamMoiDuLieu.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoiDuLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(lblNhpTnNgi)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtTimMonAn, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnTimKiem, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnLamMoiDuLieu, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNhpTnNgi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimMonAn, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLamMoiDuLieu, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGap(19)));
		panel.setLayout(gl_panel);

		txtMaMon = new JTextField();
		txtMaMon.setEditable(false);
		txtMaMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaMon.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("images\\add.png"));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("images\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setIcon(new ImageIcon("images\\edit.png"));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTrngThit = new JLabel("Giá Tiền");
		lblTrngThit.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTenMon = new JTextField();
		txtTenMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenMon.setColumns(10);

		cbxLoaiMon = new JComboBox();
		cbxLoaiMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtGiaTien = new JTextField();
		txtGiaTien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaTien.setColumns(10);

		JLabel lblnVTnh = new JLabel("Đơn Vị Tính");
		lblnVTnh.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtDonViTinh = new JTextField();
		txtDonViTinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDonViTinh.setColumns(10);

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblTnTiKhon, GroupLayout.PREFERRED_SIZE, 65,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMKhchHng))
										.addGap(18)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(txtTenMon, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
												.addComponent(cbxLoaiMon, 0, 330, Short.MAX_VALUE)))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 65,
												GroupLayout.PREFERRED_SIZE)
										.addGap(19)
										.addComponent(txtMaMon, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1
												.createParallelGroup(Alignment.LEADING)
												.addComponent(lblTrngThit, GroupLayout.PREFERRED_SIZE, 73,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblnVTnh))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(txtDonViTinh, GroupLayout.DEFAULT_SIZE, 330,
														Short.MAX_VALUE)
												.addComponent(txtGiaTien, GroupLayout.DEFAULT_SIZE, 330,
														Short.MAX_VALUE)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addGroup(gl_panel_1
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(btnXoa, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnThem, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
														.addGap(27)
														.addGroup(gl_panel_1
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE, 147,
																		Short.MAX_VALUE))))))
						.addGap(36))
				.addGroup(gl_panel_1.createSequentialGroup().addGap(143)
						.addComponent(lblThngTinTi, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(169, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblThngTinTi).addGap(11)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaMon, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(19)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenMon, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbxLoaiMon, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtGiaTien, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTrngThit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtDonViTinh, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblnVTnh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGap(27)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		TableColumnModel columnModel = tableMonAn.getColumnModel();
		tableMonAn.setDefaultEditor(Object.class, null);
		tableMonAn.setRowHeight(30);
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(200);
		columnModel.getColumn(3).setPreferredWidth(150);
		columnModel.getColumn(4).setPreferredWidth(200);
		columnModel.getColumn(5).setPreferredWidth(100);
		tableMonAn.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		cbxLoaiMon.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnThem.addActionListener(this);
		btnLamMoiDuLieu.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		tableMonAn.addMouseListener(this);
		tableMonAn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableMonAn.getColumnCount(); c++) {
			Class<?> col_class = tableMonAn.getColumnClass(c);
			tableMonAn.setDefaultEditor(col_class, null); // remove editor
		}

		List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
		for (LoaiMon loaiMon : loaiMons) {
			cbxLoaiMon.addItem(loaiMon.getTenLoaiMon());
		}

		updateTable();
		txtMaMon.setText(randomMaMonNotExisted());

	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			boolean checkE = checkExistedId();
			if (checkE) {

				String maMon = txtMaMon.getText().trim();
				String tenMon = txtTenMon.getText().trim();
				String tenLoaiMon = cbxLoaiMon.getSelectedItem().toString();
				String giaTien = txtGiaTien.getText().trim();
				String dvt = txtDonViTinh.getText();
				StringBuilder msg = new StringBuilder();
				boolean check = true;
				if (tenMon.isEmpty()) {
					msg.append("Vui lòng nhập tên món!\n");
					check = false;
				}
				if (giaTien.isEmpty()) {
					msg.append("Vui lòng nhập giá tiền!\n");
					check = false;
				} else if (giaTien.matches(PRICE_PATTERN) == false) {
					msg.append("Giá tiền không hợp lệ!\n");
					check = false;
				}
				if (dvt.isEmpty()) {
					msg.append("Vui lòng nhập đơn vị tính!\n");
					check = false;
				}

				List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
				for (LoaiMon loaiMon : loaiMons) {
					if (tenMon.equalsIgnoreCase(loaiMon.getTenLoaiMon())) {
						msg.append("Tên món ăn không được trùng với tên loại món!");
						check = false;
						break;
					}

				}

				if (check == false) {
					JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
				} else {
					boolean checkIdExisted = checkExistedId();
					if (checkIdExisted == false) {
						JOptionPane.showMessageDialog(this, "Mã món đã tồn tại. Vui lòng làm mới dữ liệu nhập!",
								"Thông báo", JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					} else {

						BigDecimal giaTienBD = new BigDecimal(giaTien);
						LoaiMon loaiMon = loaiMonDAO.getLoaiMonByTenLoai(tenLoaiMon);
						Mon mon = new Mon(maMon, tenMon, loaiMon, giaTienBD, dvt);
						monDAO.createMon(mon);
						JOptionPane.showMessageDialog(this, "Thêm món thành công!", "Thông báo",
								JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
						updateTable();
						refresh();
					}

				}

			} else {
				JOptionPane.showMessageDialog(this, "Món đã tồn tại. Vui lòng làm mới dữ liệu nhập!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			}
		} else if (obj.equals(btnLamMoi)) {
			cbxLoaiMon.removeAllItems();
			List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
			for (LoaiMon loaiMon : loaiMons) {
				cbxLoaiMon.addItem(loaiMon.getTenLoaiMon());
			}
			refresh();
		} else if (obj.equals(btnXoa)) {
			int row = tableMonAn.getSelectedRow();
			if (row != -1) {
				String maMon = txtMaMon.getText();
				try {
					Mon mon = monDAO.getMonByMa(maMon);
					boolean check = monDAO.deleteMon(mon);
					if (check) {
						JOptionPane.showMessageDialog(this, "Xóa món thành công!", "Thông báo",
								JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
						updateTable();
						refresh();
					} else {
						JOptionPane.showMessageDialog(this, "Xóa món thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE,
								new ImageIcon("images\\warning.png"));
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Lỗi. Vui lòng thử lại!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn món để xóa!", "Thông báo", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("images\\warning.png"));
			}
		} else if (obj.equals(btnCapNhat)) {
			int row = tableMonAn.getSelectedRow();
			if (row != -1) {
				String maMon = txtMaMon.getText().trim();
				String tenMon = txtTenMon.getText().trim();
				String tenLoaiMon = cbxLoaiMon.getSelectedItem().toString();
				String giaTien = txtGiaTien.getText().trim();
				String dvt = txtDonViTinh.getText();
				StringBuilder msg = new StringBuilder();
				boolean check = true;
				if (tenMon.isEmpty()) {
					msg.append("Vui lòng nhập tên món!\n");
					check = false;
				}
				if (giaTien.isEmpty()) {
					msg.append("Vui lòng nhập giá tiền!\n");
					check = false;
				} else if (giaTien.matches(PRICE_PATTERN)) {
					msg.append("Giá tiền không hợp lệ!\n");
					check = false;
				}
				if (dvt.isEmpty()) {
					msg.append("Vui lòng nhập đơn vị tính!\n");
					check = false;
				}

				if (check == false) {
					JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
				} else {

					BigDecimal giaTienBD = new BigDecimal(giaTien);
					Mon mon = monDAO.getMonByMa(maMon);
					LoaiMon loaiMon = loaiMonDAO.getLoaiMonByTenLoai(tenLoaiMon);

					mon.setTenMon(tenMon);
					mon.setLoaiMon(loaiMon);
					mon.setGiaTien(giaTienBD);
					mon.setDonViTinh(dvt);
					mon.setLoaiMon(loaiMon);
					monDAO.updateMon(mon);
					updateTable();
					refresh();
					JOptionPane.showMessageDialog(this, "Cập nhật món thành công!", "Thông báo",
							JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
				}

			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn món để cập nhật!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			}
		} else if (obj.equals(btnTimKiem)) {
			String tenMon = txtTimMonAn.getText();
			if (tenMon.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên món cần tìm!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				txtTimMonAn.requestFocus();
			} else {
				try {
					Mon mon = monDAO.getMonByTen(tenMon);
					tableModel.getDataVector().removeAllElements();
					tableModel.addRow(new Object[] { 1, mon.getMaMon(), mon.getTenMon(),
							mon.getLoaiMon().getTenLoaiMon(), mon.getGiaTien() });
					txtTimMonAn.selectAll();
					txtTimMonAn.requestFocus();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Không tồn tại món!", "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
					txtTimMonAn.selectAll();
					txtTimMonAn.requestFocus();
				}
			}

		} else if (obj.equals(btnLamMoiDuLieu)) {
			updateTable();
			refresh();
		}
	}

	public void updateTable() {
		tableModel = (DefaultTableModel) tableMonAn.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			List<Mon> mons = monDAO.getAllMon();
			int i = 0;
			for (Mon mon : mons) {
				i++;
				tableModel.addRow(new Object[] { i, mon.getMaMon(), mon.getTenMon(), mon.getLoaiMon().getTenLoaiMon(),
						df.format(mon.getGiaTien()), mon.getDonViTinh() });
			}
			tableMonAn.setModel(tableModel);
			tableMonAn.getSelectionModel().clearSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public String randomMaMonNotExisted() {
		String maMon;
		List<String> idMons = new ArrayList<String>();
		List<Mon> mons = monDAO.getAllMon();
		for (Mon mon : mons) {
			idMons.add(mon.getMaMon());
		}
		do {
			RandomStringUtils randomStringUtils = new RandomStringUtils();
			maMon = randomStringUtils.randomNumeric(8);

		} while (idMons.contains(maMon));
		return "M" + maMon;
	}

	private boolean checkExistedId() {
		List<String> ids = new ArrayList<String>();
		List<Mon> mons = monDAO.getAllMon();
		for (Mon mon : mons) {
			ids.add(mon.getMaMon());
		}
		if (ids.contains(txtMaMon.getText())) {
			return false;
		} else {
			return true;
		}
	}

	private void refresh() {
		txtMaMon.setText(randomMaMonNotExisted());
		txtGiaTien.setText("");
		txtTenMon.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableMonAn.getSelectedRow();
		if (row != -1) {
			String maMon = tableModel.getValueAt(row, 1).toString();
			try {
				Mon mon = monDAO.getMonByMa(maMon);
				txtMaMon.setText(mon.getMaMon());
				txtTenMon.setText(mon.getTenMon());
				txtGiaTien.setText(mon.getGiaTien().toString());
				cbxLoaiMon.setSelectedItem(mon.getLoaiMon().getTenLoaiMon());
				txtDonViTinh.setText(mon.getDonViTinh());
			} catch (Exception e2) {
				System.out.println("error mouse clicked");
				e2.printStackTrace();
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
