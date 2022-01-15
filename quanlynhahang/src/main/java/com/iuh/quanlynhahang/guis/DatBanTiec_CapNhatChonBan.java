package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.iuh.quanlynhahang.daoimpls.BanDAOImpl;
import com.iuh.quanlynhahang.daoimpls.PhieuDatBanDAOImpl;
import com.iuh.quanlynhahang.daoimpls.SanhDAOImpl;
import com.iuh.quanlynhahang.entities.Ban;
import com.iuh.quanlynhahang.entities.PhieuDatBan;
import com.iuh.quanlynhahang.entities.Sanh;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class DatBanTiec_CapNhatChonBan extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1365508516624801001L;
	public JPanel contentPane;
	public JTextField txtSoLuong;
	private DefaultTableModel tableModel;
	private JTable tableBanDaChon;
	@SuppressWarnings("rawtypes")
	public static JComboBox cbxGio;
	@SuppressWarnings("rawtypes")
	public static JComboBox cbxPhut;
	public static JDateChooser dateNgaySuDung;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private GroupLayout gl_panel;
	private JButton btnTroVe;
	private JButton btnTiepTuc;
	private JPanel panel_6;
	private JLabel lblangChn;
	private JLabel lblClickChn;
	public static JRadioButton rdbDatTruoc;
	public static JRadioButton rdbSuDungNgay;
//	private static final String DATE_PATTERN = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((?:19|20)[0-9][0-9])$";
	private static final String SOLUONG_PARRERN = "[0-9]{1,4}$";
	JTextFieldDateEditor editor;

	private static SanhDAOImpl sanhDAO = new SanhDAOImpl();
	private static BanDAOImpl banDAO = new BanDAOImpl();
	private static PhieuDatBanDAOImpl phieuDatBanDAO = new PhieuDatBanDAOImpl();
	public static List<Ban> banDaChon = new ArrayList<Ban>();
//	private static DatBanTiec_CapNhatChonMon datBanTiec_ChonMon;

	public static int soLuongNguoiNextScreen;
	public static String trangThaiNextScreen;
	public static LocalDate ngaySuDungNextScreen;
	public static String gioSuDungNextScreen;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DatBanTiec_CapNhatChonBan frame = new DatBanTiec_CapNhatChonBan();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DatBanTiec_CapNhatChonBan() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Ch\u1ECDn b\u00E0n", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE).addContainerGap()));
		JLabel lblChnBnTic_1 = new JLabel("CẬP NHẬT BÀN TIỆC");
		lblChnBnTic_1.setForeground(Color.RED);
		lblChnBnTic_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Th\u00F4ng tin ch\u1ECDn b\u00E0n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JLabel lblt = new JLabel("Đã đặt");
		lblt.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		JLabel lblTrng = new JLabel("Trống");
		lblTrng.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);

		JLabel lblNewLabel = new JLabel("Nhập số lượng người");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoLuong.setColumns(10);

		panel_6 = new JPanel();
		panel_6.setBackground(Color.RED);

		lblangChn = new JLabel("Đang chọn");
		lblangChn.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		lblClickChn = new JLabel("Click để chọn hoặc bỏ chọn");
		lblClickChn.setForeground(Color.RED);
		lblClickChn.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
								.addGap(102).addComponent(lblChnBnTic_1).addContainerGap(403, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblt, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblTrng, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblangChn).addGap(18)
										.addComponent(lblClickChn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 542,
										GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
								.addContainerGap()))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblChnBnTic_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(6).addComponent(panel,
								GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(8).addComponent(panel_3,
								GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblt, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTrng, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblClickChn, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblangChn, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE))))
				.addGap(4)));
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Mã Bàn", "Thuộc Sảnh" });
		scrollPane = new JScrollPane(tableBanDaChon = new JTable(tableModel));
		tableBanDaChon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EED d\u1EE5ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_3.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 454,
										Short.MAX_VALUE)
								.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(10)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE).addGap(18)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JLabel lblNgySDng = new JLabel("Ngày sử dụng");
		lblNgySDng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		dateNgaySuDung = new JDateChooser();
		dateNgaySuDung.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dateNgaySuDung.setLocale(Locale.forLanguageTag("vi-VN"));
		dateNgaySuDung.setDateFormatString("yyyy-MM-dd");

		dateNgaySuDung.setDate(Date.valueOf(LocalDate.now()));
		editor = (JTextFieldDateEditor) dateNgaySuDung.getDateEditor();
		editor.setEditable(false);

		JLabel lblGi = new JLabel("Giờ");
		lblGi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cbxGio = new JComboBox();
		cbxGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		for (int i = 8; i < 24; i++) {
			if (i < 10) {
				cbxGio.addItem("0" + i);
			} else {
				cbxGio.addItem(i + "");
			}
		}

		JLabel lblPht = new JLabel("Phút");
		lblPht.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cbxPhut = new JComboBox();
		cbxPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbxPhut.addItem("00");
		for (int i = 10; i <= 50; i++) {
			if (i % 10 == 0) {
				cbxPhut.addItem(i + "");
			}
		}

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setIcon(new ImageIcon("images\\back.png"));
		btnTroVe.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnTiepTuc = new JButton("Tiếp Tục");
		btnTiepTuc.setIcon(new ImageIcon("images\\continue.png"));
		btnTiepTuc.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbSuDungNgay = new JRadioButton("Sử dụng ngay");
		rdbSuDungNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbSuDungNgay.setSelected(true);

		rdbDatTruoc = new JRadioButton("Đặt trước");
		rdbDatTruoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		ButtonGroup group = new ButtonGroup();
		group.add(rdbDatTruoc);
		group.add(rdbSuDungNgay);

		/**
		 * disable using informations
		 */
		dateNgaySuDung.setEnabled(false);
		cbxGio.setEnabled(false);
		cbxPhut.setEnabled(false);

		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5
				.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup().addGroup(gl_panel_5
								.createParallelGroup(Alignment.LEADING).addGroup(
										gl_panel_5.createSequentialGroup().addGap(102)
												.addComponent(btnTroVe, GroupLayout.PREFERRED_SIZE, 120,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnTiepTuc,
														GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE))
								.addGroup(gl_panel_5.createSequentialGroup().addContainerGap().addGroup(gl_panel_5
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_5
												.createSequentialGroup().addGap(90).addComponent(rdbSuDungNgay)
												.addGap(18).addComponent(rdbDatTruoc, GroupLayout.PREFERRED_SIZE, 103,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_panel_5.createSequentialGroup()
														.addComponent(lblNgySDng, GroupLayout.PREFERRED_SIZE, 88,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(dateNgaySuDung, GroupLayout.DEFAULT_SIZE, 139,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 24,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(cbxGio, 0, 57, Short.MAX_VALUE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblPht, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cbxPhut, 0, 74, Short.MAX_VALUE)))
								.addGap(0)));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_5
						.createParallelGroup(Alignment.BASELINE).addComponent(rdbDatTruoc).addComponent(rdbSuDungNgay))
				.addGap(7)
				.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5.createSequentialGroup()
						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5
								.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxGio, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPht, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxPhut, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addComponent(dateNgaySuDung, GroupLayout.PREFERRED_SIZE, 28,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnTroVe, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTiepTuc, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_5.createSequentialGroup()
								.addComponent(lblNgySDng, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))));
		panel_5.setLayout(gl_panel_5);

//		tableBanDaChon = new JTable();
//		tableBanDaChon.setModel(new DefaultTableModel(new Object[][] {},
//				new String[] { "STT", "M\u00E3 B\u00E0n", "Thu\u1ED9c S\u1EA3nh" }));

//		String[] header = "STT;Mã Bàn;Thuộc Sảnh".split(";");
//		tableModel = new DefaultTableModel(header, 0);
//		scrollPane = new JScrollPane(tableBanDaChon = new JTable(tableModel));
//		tableBanDaChon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		scrollPane.setViewportView(tableBanDaChon);
		panel_3.setLayout(gl_panel_3);
		contentPane.setLayout(gl_contentPane);

		tableBanDaChon.addMouseListener(this);
		tableBanDaChon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableBanDaChon.getColumnCount(); c++) {
			Class<?> col_class = tableBanDaChon.getColumnClass(c);
			tableBanDaChon.setDefaultEditor(col_class, null); // remove editor
		}

		Set<Ban> banDaDatTruoc = PhieuDatMonUI.phieuDatBan.getBans();
		for (Ban ban : banDaDatTruoc) {
			banDaChon.add(ban);
		}
		updateBanDaChon();

		txtSoLuong.setText(PhieuDatMonUI.phieuDatBan.getSoLuongNguoi() + "");
		String trangThai = PhieuDatMonUI.phieuDatBan.getTrangThai();
		if (trangThai.equalsIgnoreCase("Đặt Trước")) {
			rdbDatTruoc.setSelected(true);
			dateNgaySuDung.setEnabled(true);
			cbxGio.setEnabled(true);
			cbxPhut.setEnabled(true);
			dateNgaySuDung.setDate(Date.valueOf(PhieuDatMonUI.phieuDatBan.getNgaySuDung()));
			String gioSuDung = PhieuDatMonUI.phieuDatBan.getGioSuDung();
			cbxGio.setSelectedItem(gioSuDung.substring(0, 2));
			cbxPhut.setSelectedItem(gioSuDung.substring(3, 5));
		}

		updateBan();

		rdbDatTruoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbDatTruoc.isSelected()) {
					dateNgaySuDung.setEnabled(true);
					cbxGio.setEnabled(true);
					cbxPhut.setEnabled(true);
				}
			}
		});
		rdbSuDungNgay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbSuDungNgay.isSelected()) {
					dateNgaySuDung.setEnabled(false);
					cbxGio.setEnabled(false);
					cbxPhut.setEnabled(false);
				}

			}
		});

		btnTiepTuc.addActionListener(this);
		btnTroVe.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnTroVe)) {
			PhieuDatMonUI phieuDatMonUI = new PhieuDatMonUI();
			TrangChuUI.tabbedPane.remove(TrangChuUI.tabbedPane.getSelectedComponent());
			TrangChuUI.tabbedPane.addTab("Phiếu đặt bàn", null, TrangChuUI.tabbedPane.add(phieuDatMonUI.getContentPane()),
					"Phiếu đặt bàn");
			banDaChon.clear();

		} else if (obj.equals(btnTiepTuc)) {
			try {

				String soLuong = txtSoLuong.getText().trim();
				System.out.println("sl la;" + soLuong);
				if (soLuong.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng người!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					System.out.println("acb");
					txtSoLuong.requestFocus();
				} else if (soLuong.matches(SOLUONG_PARRERN) == false) {
					JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					txtSoLuong.selectAll();
					txtSoLuong.requestFocus();
				} else {
					int sl = Integer.parseInt(soLuong);
					if (sl > 500 || sl < 1) {
						JOptionPane.showMessageDialog(null, "Số lượng phải phải từ 1-500!", "Thông báo",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
						txtSoLuong.selectAll();
						txtSoLuong.requestFocus();
					} else {
						int size = 0;
						boolean check = true;
						int soLuongNguoi = Integer.parseInt(soLuong);
						if (soLuongNguoi < 10) {
							size = 1;
							if (banDaChon.size() != size) {
								JOptionPane.showMessageDialog(null, "Vui lòng chọn " + size + " bàn!", "Thông báo",
										JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
								check = false;
							}
						} else {
							if (soLuongNguoi % 10 == 0) {
								size = soLuongNguoi / 10;
								if (banDaChon.size() != size) {
									JOptionPane.showMessageDialog(null, "Vui lòng chọn " + size + " bàn!", "Thông báo",
											JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
									check = false;
								}
							} else {
								size = (soLuongNguoi / 10) + 1;
								if (banDaChon.size() != size) {
									JOptionPane.showMessageDialog(null, "Vui lòng chọn " + size + " bàn!", "Thông báo",
											JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
									check = false;
								}
							}
						}

						if (check == true) {
							if (rdbDatTruoc.isSelected()) {
								if (dateNgaySuDung.getDate().before(Date.valueOf(LocalDate.now()))) {
									JOptionPane.showMessageDialog(null,
											"Ngày sử dụng không được nhỏ hơn ngày hiện tại!", "Thông báo",
											JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
								} else {

									gioSuDungNextScreen = cbxGio.getSelectedItem().toString() + "h"
											+ cbxPhut.getSelectedItem().toString();

									trangThaiNextScreen = "Đặt Trước";
									ngaySuDungNextScreen = dateNgaySuDung.getDate().toInstant()
											.atZone(ZoneId.systemDefault()).toLocalDate();
									DatBanTiec_CapNhatChonMon datBanTiec_ChonMon = new DatBanTiec_CapNhatChonMon();
									TrangChuUI.tabbedPane.remove(TrangChuUI.tabbedPane.getSelectedComponent());
									TrangChuUI.tabbedPane.addTab("Cập nhật món", null,
											TrangChuUI.tabbedPane.add(datBanTiec_ChonMon.getContentPane()),
											"Cập nhật món");
									soLuongNguoiNextScreen = soLuongNguoi;
//									System.out.println("Chon Ban TT:" + banDaChon.size());
//									System.out.println("Chon ban TT:" + KhachHangUI.khachHang.getTenKhachHang());
								}
							} else {
								gioSuDungNextScreen = LocalDateTime.now().getHour() + "h"
										+ LocalDateTime.now().getMinute() + "";
								trangThaiNextScreen = "Sử Dụng Ngay";
								ngaySuDungNextScreen = LocalDate.now();
								DatBanTiec_CapNhatChonMon datBanTiec_ChonMon = new DatBanTiec_CapNhatChonMon();
								TrangChuUI.tabbedPane.remove(TrangChuUI.tabbedPane.getSelectedComponent());
								TrangChuUI.tabbedPane.addTab("Cập nhật món", null,
										TrangChuUI.tabbedPane.add(datBanTiec_ChonMon.getContentPane()), "Cập nhật món");
								soLuongNguoiNextScreen = soLuongNguoi;
//								System.out.println("Chon Ban TT:" + banDaChon.size());
//								System.out.println("Chon ban TT:" + KhachHangUI.khachHang.getTenKhachHang());
							}

						}
					}
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (rdbDatTruoc.isSelected()) {
			dateNgaySuDung.setEnabled(true);
			cbxGio.setEnabled(true);
			cbxPhut.setEnabled(true);
		} else {
			dateNgaySuDung.setEnabled(false);
			cbxGio.setEnabled(false);
			cbxPhut.setEnabled(false);
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

	private void updateBanDaChon() {
		tableModel = (DefaultTableModel) tableBanDaChon.getModel();
		tableModel.getDataVector().removeAllElements();
		if (banDaChon.isEmpty()) {
			tableModel.fireTableDataChanged();
		} else {
			int i = 1;
			for (Ban b : banDaChon) {
				tableModel.addRow(new Object[] { i++, b.getMaBan(), b.getSanh().getTenSanh() });
			}
		}
	}

	public void updateBan() {
		List<Sanh> sanhs = sanhDAO.getAllSanh();
		List<Ban> bans = banDAO.getAllBan();

		for (Sanh sanh : sanhs) {
			if (sanh.getTrangThai().equalsIgnoreCase("Đang Hoạt Động")) {
				JPanel panel_2 = new JPanel();
				tabbedPane.addTab("Sảnh " + sanh.getTenSanh(), null, panel_2, null);
				panel.setLayout(gl_panel);
				panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

				Set<Ban> banDaDatTruoc = PhieuDatMonUI.phieuDatBan.getBans();

				for (Ban ban : bans) {
					if (ban.getSanh().getTenSanh().equalsIgnoreCase(sanh.getTenSanh())
							&& ban.getTrangThaiHoatDong().equalsIgnoreCase("Đang Sử Dụng")) {

						JButton btnBan = new JButton("Bàn số " + ban.getMaBan());
						btnBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
						panel_2.add(btnBan);
						/**
						 * load cac ban da dat truoc do co color là red
						 */
						for (Ban badadat : banDaDatTruoc) {
							if (ban.getMaBan() == badadat.getMaBan()) {
								btnBan.setBackground(Color.red);
							}
						}

//						System.out.println("=======");
//						banDaDatTruoc.forEach(x -> System.out.println(x.getMaBan()));

						List<PhieuDatBan> phieuDatBans = phieuDatBanDAO.getAllPhieuDatBan();
						for (PhieuDatBan p : phieuDatBans) {
							if (ban.gettrangThaiDatBan().equalsIgnoreCase("Đã Đặt")
									&& p.getNgaySuDung().isEqual(LocalDate.now()) == true
									&& p.getTrangThai().equalsIgnoreCase("Đặt Trước") && p.getBans().contains(ban)) {
								btnBan.setBackground(Color.GRAY);
							}
						}
						/**
						 * load cac ban da dat truoc do co color là red
						 */
						for (Ban badadat : banDaDatTruoc) {
							if (ban.getMaBan() == badadat.getMaBan()) {
								btnBan.setBackground(Color.red);
							}
						}

						btnBan.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								if (btnBan.getBackground() == Color.GRAY) {
									JOptionPane.showMessageDialog(null, "Bàn đã đặt. Vui lòng chọn bàn bàn khác!",
											"Thông báo", JOptionPane.ERROR_MESSAGE,
											new ImageIcon("images\\warning.png"));
								} else {
									if (btnBan.getBackground() == Color.red) {
										banDaChon.remove(ban);
										btnBan.setBackground(null);
										updateBanDaChon();
									} else {
										banDaChon.add(ban);
										btnBan.setBackground(Color.red);
										updateBanDaChon();

									}
								}
							}
						});
					}
				}
			}
		}
	}
}
