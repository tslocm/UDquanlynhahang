//package com.iuh.quanlynhahang.guis;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//import javax.swing.AbstractButton;
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
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.ListSelectionModel;
//import javax.swing.ScrollPaneConstants;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//
//import com.iuh.quanlynhahang.daoimpls.BanDAOImpl;
//import com.iuh.quanlynhahang.daoimpls.SanhDAOImpl;
//import com.iuh.quanlynhahang.entities.Ban;
//import com.iuh.quanlynhahang.entities.Sanh;
//import com.toedter.calendar.JDateChooser;
//import javax.swing.JTree;
//import javax.swing.tree.DefaultTreeModel;
//import javax.swing.tree.DefaultMutableTreeNode;
//
//public class DatBanTiec_ChonBan2 extends JFrame implements ActionListener, MouseListener {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1365508516624801001L;
//	public JPanel contentPane;
//	private JTextField txtSoLuong;
//	private DefaultTableModel tableModel;
//	private JTable tableBanDaChon;
//	@SuppressWarnings("rawtypes")
//	private JComboBox cbxGio;
//	@SuppressWarnings("rawtypes")
//	private JComboBox cbxPhut;
//	private JDateChooser dateNgaySuDung;
//	private JScrollPane scrollPane;
//	private JPanel panel;
//	private JButton btnTroVe;
//	private AbstractButton btnTiepTuc;
//	private JPanel panel_6;
//	private JLabel lblangChn;
//	private JLabel lblClickChn;
//	private static final String DATE_PATTERN = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((?:19|20)[0-9][0-9])$";
//	private static final String SOLUONG_PARRERN = "[0-9]{1,4}$";
//
//	private static SanhDAOImpl sanhDAO = new SanhDAOImpl();
//	private static BanDAOImpl banDAO = new BanDAOImpl();
//	List<Ban> banDaChon = new ArrayList<Ban>();
//	private JScrollPane scrollPane_1;
//	private JTabbedPane tabbedPane;
//	private GroupLayout gl_panel;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DatBanTiec_ChonBan2 frame = new DatBanTiec_ChonBan2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public DatBanTiec_ChonBan2() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 1084, 551);
//		setLocationRelativeTo(null);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//
//		panel = new JPanel();
//		panel.setBorder(
//				new TitledBorder(null, "Ch\u1ECDn b\u00E0n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		JLabel lblChnBnTic_1 = new JLabel("CHỌN BÀN TIỆC2");
//		lblChnBnTic_1.setForeground(Color.RED);
//		lblChnBnTic_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
//
//		JPanel panel_3 = new JPanel();
//		panel_3.setBorder(new TitledBorder(null, "Th\u00F4ng tin ch\u1ECDn b\u00E0n", TitledBorder.LEADING,
//				TitledBorder.TOP, null, null));
//
//		JLabel lblt = new JLabel("Đã đặt");
//		lblt.setFont(new Font("Times New Roman", Font.ITALIC, 16));
//
//		JLabel lblTrng = new JLabel("Trống");
//		lblTrng.setFont(new Font("Times New Roman", Font.ITALIC, 16));
//
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(Color.GRAY);
//
//		JPanel panel_4 = new JPanel();
//		panel_4.setBackground(SystemColor.activeCaption);
//
//		JLabel lblNewLabel = new JLabel("Nhập số lượng người");
//		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		txtSoLuong = new JTextField();
//		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtSoLuong.setColumns(10);
//
//		panel_6 = new JPanel();
//		panel_6.setBackground(Color.RED);
//
//		lblangChn = new JLabel("Đang chọn");
//		lblangChn.setFont(new Font("Times New Roman", Font.ITALIC, 16));
//
//		lblClickChn = new JLabel("Click để chọn hoặc bỏ chọn");
//		lblClickChn.setForeground(Color.RED);
//		lblClickChn.setFont(new Font("Times New Roman", Font.ITALIC, 16));
//		GroupLayout gl_contentPane = new GroupLayout(contentPane);
//		gl_contentPane.setHorizontalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
//							.addPreferredGap(ComponentPlacement.RELATED)
//							.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
//							.addGap(102)
//							.addComponent(lblChnBnTic_1))
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//								.addGroup(gl_contentPane.createSequentialGroup()
//									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.RELATED)
//									.addComponent(lblt, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
//									.addGap(18)
//									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.RELATED)
//									.addComponent(lblTrng, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.UNRELATED)
//									.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.RELATED)
//									.addComponent(lblangChn)
//									.addGap(18)
//									.addComponent(lblClickChn, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
//								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE))
//							.addPreferredGap(ComponentPlacement.UNRELATED)
//							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)))
//					.addContainerGap())
//		);
//		gl_contentPane.setVerticalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addGap(18)
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
//								.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
//						.addComponent(lblChnBnTic_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addGap(8)
//							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addGap(6)
//							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
//							.addGap(0)))
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
//							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
//							.addComponent(lblt, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
//						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
//							.addComponent(lblTrng, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
//							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//								.addComponent(lblClickChn, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
//								.addComponent(lblangChn, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
//								.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
//					.addGap(4))
//		);
//		
//		scrollPane_1 = new JScrollPane();
//		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		 
//		 JTree tree = new JTree();
//		 tree.setModel(new DefaultTreeModel(
//		 	new DefaultMutableTreeNode("qwe") {
//		 		{
//		 			add(new DefaultMutableTreeNode("123"));
//		 		}
//		 	}
//		 ));
//		 gl_panel = new GroupLayout(panel);
//		 gl_panel.setHorizontalGroup(
//		 	gl_panel.createParallelGroup(Alignment.LEADING)
//		 		.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
//		 			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//		 			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
//		 			.addContainerGap())
//		 		.addGroup(gl_panel.createSequentialGroup()
//		 			.addGap(100)
//		 			.addComponent(tree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//		 			.addContainerGap(358, Short.MAX_VALUE))
//		 );
//		 gl_panel.setVerticalGroup(
//		 	gl_panel.createParallelGroup(Alignment.LEADING)
//		 		.addGroup(gl_panel.createSequentialGroup()
//		 			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
//		 			.addGap(56)
//		 			.addComponent(tree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//		 			.addContainerGap(244, Short.MAX_VALUE))
//		 );
//		
//		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
//		scrollPane_1.setViewportView(tabbedPane);
//		panel.setLayout(gl_panel);
//		
//		
//		
//		gl_panel = new GroupLayout(panel);
//		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
//						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
//						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
//		gl_panel.setVerticalGroup(
//				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
//						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE).addContainerGap()));
//		
//		
//		
//		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Mã Bàn", "Thuộc Sảnh" });
//		scrollPane = new JScrollPane(tableBanDaChon = new JTable(tableModel));
//		tableBanDaChon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		JPanel panel_5 = new JPanel();
//		panel_5.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EED d\u1EE5ng", TitledBorder.LEADING,
//				TitledBorder.TOP, null, null));
//		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
//		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
//				gl_panel_3.createSequentialGroup().addContainerGap()
//						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
//								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 454,
//										Short.MAX_VALUE)
//								.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
//										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//						.addContainerGap()));
//		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
//				.addGroup(gl_panel_3.createSequentialGroup().addGap(10)
//						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE).addGap(18)
//						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
//						.addContainerGap()));
//
//		JLabel lblNgySDng = new JLabel("Ngày sử dụng");
//		lblNgySDng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		dateNgaySuDung = new JDateChooser();
//		dateNgaySuDung.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		dateNgaySuDung.setLocale(Locale.forLanguageTag("vi-VN"));
//		dateNgaySuDung.setDateFormatString("dd-MM-yyyy");
//
//		JLabel lblGi = new JLabel("Giờ");
//		lblGi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		cbxGio = new JComboBox();
//		cbxGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		for (int i = 8; i < 24; i++) {
//			cbxGio.addItem(i + "");
//		}
//
//		JLabel lblPht = new JLabel("Phút");
//		lblPht.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		cbxPhut = new JComboBox();
//		cbxPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		cbxPhut.addItem("00");
//		for (int i = 10; i <= 50; i++) {
//			if (i % 10 == 0) {
//				cbxPhut.addItem(i + "");
//			}
//		}
//
//		btnTroVe = new JButton("Trở Về");
//		btnTroVe.setIcon(new ImageIcon("images\\back.png"));
//		btnTroVe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		btnTiepTuc = new JButton("Tiếp Tục");
//		btnTiepTuc.setIcon(new ImageIcon("images\\continue.png"));
//		btnTiepTuc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
//		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
//		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5
//				.createSequentialGroup().addContainerGap()
//				.addComponent(lblNgySDng, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
//				.addPreferredGap(ComponentPlacement.RELATED)
//				.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5.createSequentialGroup()
//						.addComponent(dateNgaySuDung, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE).addGap(18)
//						.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
//						.addPreferredGap(ComponentPlacement.RELATED).addComponent(cbxGio, 0, 68, Short.MAX_VALUE))
//						.addGroup(gl_panel_5.createSequentialGroup()
//								.addComponent(btnTroVe, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
//								.addPreferredGap(ComponentPlacement.RELATED)
//								.addComponent(btnTiepTuc, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
//				.addPreferredGap(ComponentPlacement.UNRELATED)
//				.addComponent(lblPht, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
//				.addPreferredGap(ComponentPlacement.RELATED).addComponent(cbxPhut, 0, 24, Short.MAX_VALUE)
//				.addContainerGap()));
//		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5
//				.createSequentialGroup().addGap(22)
//				.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
//						.addComponent(lblNgySDng, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
//						.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
//								.addComponent(dateNgaySuDung, GroupLayout.PREFERRED_SIZE, 28,
//										GroupLayout.PREFERRED_SIZE)
//								.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
//										.addComponent(cbxPhut, GroupLayout.PREFERRED_SIZE, 29,
//												GroupLayout.PREFERRED_SIZE)
//										.addComponent(lblPht, GroupLayout.PREFERRED_SIZE, 26,
//												GroupLayout.PREFERRED_SIZE)
//										.addComponent(cbxGio, GroupLayout.PREFERRED_SIZE, 28,
//												GroupLayout.PREFERRED_SIZE)
//										.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 26,
//												GroupLayout.PREFERRED_SIZE))))
//				.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
//				.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
//						.addComponent(btnTroVe, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
//						.addComponent(btnTiepTuc, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
//				.addContainerGap()));
//		panel_5.setLayout(gl_panel_5);
//
////		tableBanDaChon = new JTable();
////		tableBanDaChon.setModel(new DefaultTableModel(new Object[][] {},
////				new String[] { "STT", "M\u00E3 B\u00E0n", "Thu\u1ED9c S\u1EA3nh" }));
//
////		String[] header = "STT;Mã Bàn;Thuộc Sảnh".split(";");
////		tableModel = new DefaultTableModel(header, 0);
////		scrollPane = new JScrollPane(tableBanDaChon = new JTable(tableModel));
////		tableBanDaChon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//
////		scrollPane.setViewportView(tableBanDaChon);
//		panel_3.setLayout(gl_panel_3);
//		contentPane.setLayout(gl_contentPane);
//
//		tableBanDaChon.addMouseListener(this);
//		tableBanDaChon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		for (int c = 0; c < tableBanDaChon.getColumnCount(); c++) {
//			Class<?> col_class = tableBanDaChon.getColumnClass(c);
//			tableBanDaChon.setDefaultEditor(col_class, null); // remove editor
//		}
//
////		JPanel panel_2 = new JPanel();
////		tabbedPane.addTab("Sảnh ", null, panel_2, null);
////		panel.setLayout(gl_panel);
////		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
////
////				JButton btnBan = new JButton("uuu");
////				btnBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
////				panel_2.add(btnBan);
//
////		List<Sanh> sanhs = sanhDAO.getAllSanh();
////		List<Ban> bans = banDAO.getAllBan();
////		List<Ban> banDaChon = new ArrayList<Ban>();
////		for (Sanh sanh : sanhs) {
////			if (sanh.getTrangThai().equalsIgnoreCase("Đang Hoạt Động")) {
////				JPanel panel_2 = new JPanel();
////				tabbedPane.addTab("Sảnh " + sanh.getTenSanh(), null, panel_2, null);
////				panel.setLayout(gl_panel);
////				panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
////				for (Ban ban : bans) {
////					if (ban.getSanh().getTenSanh().equalsIgnoreCase(sanh.getTenSanh())
////							&& ban.getTrangThaiHoatDong().equalsIgnoreCase("Đang Sử Dụng")) {
////
////						JButton btnBan = new JButton(ban.getMaBan() + "");
////						btnBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
////						panel_2.add(btnBan);
////						if (ban.gettrangThaiDatBan().equalsIgnoreCase("Đã Đặt")) {
////							btnBan.setBackground(Color.RED);
////						}
////
////						btnBan.addActionListener(new ActionListener() {
////
////							@Override
////							public void actionPerformed(ActionEvent e) {
////								System.out.println(ban.getMaBan() + "-" + sanh.getTenSanh());
////								if (ban.gettrangThaiDatBan().equalsIgnoreCase("Đã Đặt")) {
////									JOptionPane.showMessageDialog(null, "Bàn đã đặt. Vui lòng chọn bàn bàn khác!",
////											"Thông báo", JOptionPane.ERROR_MESSAGE,
////											new ImageIcon("images\\warning.png"));
////								} else {
////									banDaChon.add(ban);
////									btnBan.setBackground(Color.RED);
////									int count = tableBanDaChon.getRowCount();
////									tableModel.addRow(
////											new Object[] { count + 1, ban.getMaBan(), ban.getSanh().getTenSanh() });
////
////								}
////							}
////						});
////					}
////				}
////			}
////		}
//
//		updateBan();
//
//		btnTiepTuc.addActionListener(this);
//		btnTroVe.addActionListener(this);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object obj = e.getSource();
//		if (obj.equals(btnTroVe)) {
//			KhachHangUI khachHangUI = new KhachHangUI();
//			TrangChu.tabbedPane.remove(TrangChu.tabbedPane.getSelectedComponent());
//			TrangChu.tabbedPane.addTab("Chọn Bàn", null, TrangChu.tabbedPane.add(khachHangUI.getContentPane()),
//					"Chọn Bàn");
//		} else if (obj.equals(btnTiepTuc)) {
////			try {
////				int soLuong=Integer.parseInt(txtSoLuong.getText().trim());
////			} catch (Exception e2) {
////				// TODO: handle exception
////			}catch ( e2) {
////				// TODO: handle exception
////			}
//
//			String soLuong = txtSoLuong.getText().trim();
//			if (soLuong.isEmpty()) {
//				JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng người!", "Thông báo",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//				txtSoLuong.requestFocus();
//			} else if (soLuong.matches(SOLUONG_PARRERN) == false) {
//				JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!", "Thông báo", JOptionPane.ERROR_MESSAGE,
//						new ImageIcon("images\\warning.png"));
//				txtSoLuong.selectAll();
//				txtSoLuong.requestFocus();
//			} else {
//				int sl = Integer.parseInt(soLuong);
//				if (sl > 500 || sl < 1) {
//					JOptionPane.showMessageDialog(null, "Số lượng phải phải từ 1-500!", "Thông báo",
//							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//					txtSoLuong.selectAll();
//					txtSoLuong.requestFocus();
//				} else {
//					DatBanTiec_ChonMon datBanTiec_ChonMon = new DatBanTiec_ChonMon();
//					TrangChu.tabbedPane.remove(TrangChu.tabbedPane.getSelectedComponent());
//					TrangChu.tabbedPane.addTab("Chọn Bàn", null,
//							TrangChu.tabbedPane.add(datBanTiec_ChonMon.getContentPane()), "Chọn Bàn");
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//
////		if (e.getClickCount() == 2) { // to detect doble click events
////			tableBanDaChon = (JTable) e.getSource();
////			int row = tableBanDaChon.getSelectedRow(); // select a row
//////			System.out.println("row " + row);
//////			System.out.println(tableBanDaChon.getValueAt(row, 1));
////
////			int maBan = Integer.parseInt(tableBanDaChon.getValueAt(row, 1).toString());
//////			Ban banHuy=banDAO.getBanById(maBan);
//////			banHuy.set
////
////		}
////
////		if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
////			System.out.println("btnClick");
////		}
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//	}
//
//	private void updateBanDaChon() {
//		tableModel = (DefaultTableModel) tableBanDaChon.getModel();
//		tableModel.getDataVector().removeAllElements();
//		if (banDaChon.isEmpty()) {
//			tableModel.fireTableDataChanged();
//		} else {
//			int i = 1;
//			for (Ban b : banDaChon) {
//				tableModel.addRow(new Object[] { i++, b.getMaBan(), b.getSanh().getTenSanh() });
//			}
//		}
//	}
//
//	private void updateBan() {
//		List<Sanh> sanhs = sanhDAO.getAllSanh();
//		List<Ban> bans = banDAO.getAllBan();
//
//		for (Sanh sanh : sanhs) {
//			if (sanh.getTrangThai().equalsIgnoreCase("Đang Hoạt Động")) {
//				JPanel panel_2 = new JPanel();
//				tabbedPane.addTab("Sảnh " + sanh.getTenSanh(), null, panel_2, null);
//				panel.setLayout(gl_panel);
//				panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//				for (Ban ban : bans) {
//					if (ban.getSanh().getTenSanh().equalsIgnoreCase(sanh.getTenSanh())
//							&& ban.getTrangThaiHoatDong().equalsIgnoreCase("Đang Sử Dụng")) {
//
//						JButton btnBan = new JButton(ban.getMaBan() + "");
//						btnBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//						panel_2.add(btnBan);
//						if (ban.gettrangThaiDatBan().equalsIgnoreCase("Đã Đặt")) {
//							btnBan.setBackground(Color.GRAY);
//						}
//
//						btnBan.addActionListener(new ActionListener() {
//
//							@Override
//							public void actionPerformed(ActionEvent e) {
//								System.out.println(ban.getMaBan() + "-" + sanh.getTenSanh());
//								if (ban.gettrangThaiDatBan().equalsIgnoreCase("Đã Đặt")) {
//									JOptionPane.showMessageDialog(null, "Bàn đã đặt. Vui lòng chọn bàn bàn khác!",
//											"Thông báo", JOptionPane.ERROR_MESSAGE,
//											new ImageIcon("images\\warning.png"));
//								} else {
//									if (btnBan.getBackground() == Color.red) {
//										banDaChon.remove(ban);
//										btnBan.setBackground(null);
//										updateBanDaChon();
//									} else {
//										banDaChon.add(ban);
//										btnBan.setBackground(Color.red);
//										updateBanDaChon();
//
//									}
//								}
//							}
//						});
//					}
//				}
//			}
//		}
//	}
//}
