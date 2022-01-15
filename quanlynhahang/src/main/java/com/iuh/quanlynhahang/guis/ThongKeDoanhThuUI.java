package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.iuh.quanlynhahang.daoimpls.ChiTietHoaDonDAOImpl;
import com.iuh.quanlynhahang.daoimpls.HoaDonDAOImpl;
import com.iuh.quanlynhahang.daoimpls.MonDAOImpl;
import com.iuh.quanlynhahang.daoimpls.PhieuDatBanDAOImpl;
import com.iuh.quanlynhahang.entities.ChiTietHoaDon;
import com.iuh.quanlynhahang.entities.HoaDon;
import com.iuh.quanlynhahang.entities.PhieuDatBan;
import com.quanlynhahang.baocao.BaoCao;
import com.quanlynhahang.dto.DoanhThu;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class ThongKeDoanhThuUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private static String muaVe = "Mua Về";
	private static String suDungNgay = "Sử Dụng Ngay";
	public static BigDecimal tongTien = BigDecimal.valueOf(0d);

	public static List<DoanhThu> listDT = new ArrayList<DoanhThu>();
	public static String ngayBD;
	public static String ngayEnd;

	double tongTienTheoHoaDons = 0;

	private static MonDAOImpl monDAO = new MonDAOImpl();
	private static HoaDonDAOImpl hoaDonDAO = new HoaDonDAOImpl();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThongKeDoanhThu frame = new ThongKeDoanhThu();
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
	private JLabel lblTNgy, lblThngKDoanh, lblnNgy;
	private JPanel panel;
	private JButton btnThongKe;

	private JTable tableThongKeDoanhThu;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JLabel lblTongTien;
	private JButton btnBaoCao;
	private JTextField txtTongTien;
	public static String tienTong;
	JTextFieldDateEditor editor;
	private JDateChooser dateFrom, dateTo;
	private static NumberFormat df = new DecimalFormat("#,###.00 VNĐ");
	private static HoaDonDAOImpl hdDAO = new HoaDonDAOImpl();
	private static PhieuDatBanDAOImpl phieuDAO = new PhieuDatBanDAOImpl();
	private static ChiTietHoaDonDAOImpl cthdDAO = new ChiTietHoaDonDAOImpl();
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private JLabel label;
	private JLabel lblThng;
	private JLabel lblNgy;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxThang;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxNgay;
	private JLabel lblThngKTheo;
	private JRadioButton rdbNgay;
	private JRadioButton rdbThang;
	private JRadioButton rdbNam;
	private JRadioButton rdbTuyChon;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxNam;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ThongKeDoanhThuUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblThngKDoanh = new JLabel("THỐNG KÊ DOANH THU");
		lblThngKDoanh.setForeground(Color.RED);
		lblThngKDoanh.setFont(new Font("Times New Roman", Font.BOLD, 25));

		panel = new JPanel();

		String[] header = "STT; Mã Hóa Đơn; Ngày In Hóa Đơn; Thành Tiền".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(tableThongKeDoanhThu = new JTable(tableModel),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableThongKeDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTongTien = new JLabel("Doanh Thu");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Times New Roman", Font.BOLD, 22));

		txtTongTien = new JTextField();
		txtTongTien.setForeground(Color.RED);
		txtTongTien.setEditable(false);
		txtTongTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTongTien.setColumns(10);

		lblTNgy = new JLabel("Từ Ngày");
		lblTNgy.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		dateFrom = new JDateChooser();
		dateFrom.getCalendarButton().setEnabled(false);
		dateFrom.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dateFrom.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dateFrom.setLocale(Locale.forLanguageTag("vi-VN"));
		dateFrom.setDateFormatString("yyyy-MM-dd");
		dateFrom.setDate(Date.valueOf(LocalDate.now()));
		editor = (JTextFieldDateEditor) dateFrom.getDateEditor();
		editor.setEditable(false);

		lblnNgy = new JLabel("Đến Ngày");
		lblnNgy.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		dateTo = new JDateChooser();
		dateTo.getCalendarButton().setEnabled(false);
		dateTo.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dateTo.setLocale(Locale.forLanguageTag("vi-VN"));
		dateTo.setDateFormatString("yyyy-MM-dd");
		dateTo.setDate(Date.valueOf(LocalDate.now()));
		editor = (JTextFieldDateEditor) dateTo.getDateEditor();
		editor.setEditable(false);

		btnThongKe = new JButton("Thống Kê");
		btnThongKe.setIcon(new ImageIcon("images\\calculator.png"));
		btnThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnThongKe.addActionListener(this);

		btnBaoCao = new JButton("Báo Cáo");
		btnBaoCao.setIcon(new ImageIcon("images\\report.png"));
		btnBaoCao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBaoCao.addActionListener(this);

		label = new JLabel("Năm");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblThng = new JLabel("Tháng");
		lblThng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblNgy = new JLabel("Ngày");
		lblNgy.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cbxNam = new JComboBox();
		cbxNam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbxNam.setEnabled(false);

		cbxThang = new JComboBox();
		cbxThang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbxThang.setEnabled(false);

		cbxNgay = new JComboBox();
		cbxNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbxNgay.setEnabled(false);

		rdbNgay = new JRadioButton("Ngày");
		rdbNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbThang = new JRadioButton("Tháng");
		rdbThang.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbNam = new JRadioButton("Năm");
		rdbNam.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbTuyChon = new JRadioButton("Tùy chọn");
		rdbTuyChon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblThngKTheo = new JLabel("Thống kê theo");
		lblThngKTheo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnThongKe, GroupLayout.PREFERRED_SIZE, 135,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnBaoCao, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
										.createParallelGroup(Alignment.LEADING).addComponent(label)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblThng, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNgy, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addGap(34))
								.addComponent(lblThngKTheo)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblnNgy)
										.addComponent(lblTNgy, GroupLayout.PREFERRED_SIZE, 71,
												GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(dateTo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(dateFrom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(rdbNam, GroupLayout.DEFAULT_SIZE, 59,
																		Short.MAX_VALUE)
																.addGap(1))
														.addComponent(
																rdbNgay, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(rdbThang, GroupLayout.DEFAULT_SIZE, 75,
																		Short.MAX_VALUE)
																.addGap(6))
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(rdbTuyChon, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGap(1)))
												.addGap(3))
										.addComponent(cbxNam, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbxThang, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbxNgay, 0, 142, Short.MAX_VALUE))
								.addGap(32)))
						.addGap(0)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 115,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtTongTien, GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(rdbNgay)
										.addComponent(rdbThang).addComponent(lblThngKTheo))
								.addGap(1)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(rdbNam)
										.addComponent(rdbTuyChon))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNgy, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbxNgay, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblThng, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbxThang, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbxNam, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addGap(15).addComponent(lblTNgy,
												GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addGap(18).addComponent(dateFrom,
												GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
								.addGap(17)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(dateTo, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblnNgy, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))
								.addGap(32)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnThongKe, GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnBaoCao, GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)))
						.addGap(21)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTongTien, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGap(23)));
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(436).addComponent(lblThngKDoanh,
										GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE))
						.addGap(6)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblThngKDoanh, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panel, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE).addGap(0)));
		contentPane.setLayout(gl_contentPane);

		tableThongKeDoanhThu.setRowHeight(30);
		loadTable();
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbNgay);
		buttonGroup.add(rdbThang);
		buttonGroup.add(rdbNam);
		buttonGroup.add(rdbTuyChon);

		loadComboboxNam();

		for (int i = 1; i <= 31; i++) {
			cbxNgay.addItem(i + "");
		}

		for (int i = 1; i <= 12; i++) {
			cbxThang.addItem(i + "");
		}

		tableThongKeDoanhThu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableThongKeDoanhThu.getColumnCount(); c++) {
			Class<?> col_class = tableThongKeDoanhThu.getColumnClass(c);
			tableThongKeDoanhThu.setDefaultEditor(col_class, null);
		}

		rdbNgay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbxNgay.setEnabled(true);
				cbxThang.setEnabled(true);
				cbxNam.setEnabled(true);
				dateFrom.setEnabled(false);
				dateTo.setEnabled(false);

			}
		});
		rdbThang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbxNgay.setEnabled(false);
				cbxThang.setEnabled(true);
				cbxNam.setEnabled(true);
				dateFrom.setEnabled(false);
				dateTo.setEnabled(false);

			}
		});
		rdbNam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbxNgay.setEnabled(false);
				cbxThang.setEnabled(false);
				cbxNam.setEnabled(true);
				dateFrom.setEnabled(false);
				dateTo.setEnabled(false);

			}
		});
		rdbTuyChon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbxNgay.setEnabled(false);
				cbxThang.setEnabled(false);
				cbxNam.setEnabled(false);
				dateFrom.setEnabled(true);
				dateTo.setEnabled(true);

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		List<ChiTietHoaDon> hoaDons;
		if (o.equals(btnThongKe)) {
			if (rdbNgay.isSelected()) {
				int ngay = Integer.parseInt(cbxNgay.getSelectedItem().toString());
				int thang = Integer.parseInt(cbxThang.getSelectedItem().toString());
				int nam = Integer.parseInt(cbxNam.getSelectedItem().toString());
				hoaDons = hoaDonDAO.getAllHoaDonByNgay(ngay, thang, nam);
				if (hoaDons.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE,
							new ImageIcon("images\\warning.png"));
					updateTable(hoaDons);
				} else {
					updateTable(hoaDons);
				}
			} else if (rdbThang.isSelected()) {
				int thang = Integer.parseInt(cbxThang.getSelectedItem().toString());
				int nam = Integer.parseInt(cbxNam.getSelectedItem().toString());
				hoaDons = hoaDonDAO.getAllHoaDonByThang(thang, nam);
				if (hoaDons.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE,
							new ImageIcon("images\\warning.png"));
					updateTable(hoaDons);
				} else {
					updateTable(hoaDons);
				}
			} else if (rdbNam.isSelected()) {
				int nam = Integer.parseInt(cbxNam.getSelectedItem().toString());
				hoaDons = hoaDonDAO.getAllHoaDonByNam(nam);
				if (hoaDons.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE,
							new ImageIcon("images\\warning.png"));
					updateTable(hoaDons);
				} else {
					updateTable(hoaDons);
				}
			} else if (rdbTuyChon.isSelected()) {
				LocalDate from = dateFrom.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate to = dateTo.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				hoaDons = hoaDonDAO.getAllHoaDonFromDateToDate(from, to);
				if (hoaDons.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE,
							new ImageIcon("images\\warning.png"));
					updateTable(hoaDons);
				} else {
					updateTable(hoaDons);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại thống kê!", "Thông báo",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("images\\warning.png"));
			}

//			updateTable();
		} else if (o.equals(btnBaoCao)) {
			try {
				if (tableThongKeDoanhThu.getRowCount() <= 0) {
					int options = JOptionPane.showConfirmDialog(this,
							"Không có dữ liệu nào hết. Bạn có chắc muốn tiếp tục?", "Thông báo",
							JOptionPane.YES_NO_OPTION);
					if (options == JOptionPane.YES_OPTION) {
						BaoCao bc = new BaoCao();
						bc.BaoCaoDoanhThu();
					}
				} else {
					BaoCao bc = new BaoCao();
					bc.BaoCaoDoanhThu();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void loadComboboxNam() {
		List<Integer> list = monDAO.getAllNamsInHoaDon();
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(list);
		for (Integer i : set) {
			cbxNam.addItem(i + "");
		}

	}

	private void updateTable(List<ChiTietHoaDon> list) {
		tableModel = (DefaultTableModel) tableThongKeDoanhThu.getModel();
		tableModel.getDataVector().removeAllElements();
		int i = 0;
		double thanhTien;
		for (ChiTietHoaDon c : list) {
			i++;
//			if (c.getPhieuDatBan().getTrangThai().equalsIgnoreCase("Đặt Trước")) {
//				thanhTien = (Double.parseDouble(c.getPhieuDatBan().getTienCoc().toString()) / 0.3)
//						- Double.parseDouble(c.getPhieuDatBan().getTienCoc().toString());
//				tongTienTheoHoaDons = tongTienTheoHoaDons
//						+ (Double.parseDouble(c.getPhieuDatBan().getTienCoc().toString()) / 0.3)
//						- Double.parseDouble(c.getPhieuDatBan().getTienCoc().toString());
//			} else {
			thanhTien = Double.parseDouble(c.getPhieuDatBan().getTienCoc().toString()) / 0.3;
			tongTienTheoHoaDons = tongTienTheoHoaDons
					+ Double.parseDouble(c.getPhieuDatBan().getTienCoc().toString()) / 0.3;
//			}
			tableModel.addRow(new Object[] { i, c.getHoaDon().getMaHoaDon(), c.getHoaDon().getNgayXuatHoaDon(),
					df.format(thanhTien) });
		}
		tableModel.fireTableDataChanged();
		txtTongTien.setText(df.format(tongTienTheoHoaDons));
	}

	public void updateTable() {
		java.util.Date from = dateFrom.getDate();
		java.util.Date to = dateTo.getDate();// localdate kia
		if (from.after(to)) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hợp lệ!", "Thông báo", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("images\\warning.png"));
		} else {
			tongTien = BigDecimal.valueOf(0);
			try {

				// tableModel.getDataVector().removeAllElements();
				int rowCount = tableThongKeDoanhThu.getRowCount();
				for (int i = rowCount; i > 0; i--) {
					tableModel.removeRow(i - 1);
				}
				try {
					int i = 0;
					String ngayBD = "";
					String ngayEnd = "";
					ngayBD = dateFormat.format(dateFrom.getDate());
					ngayEnd = dateFormat.format(dateTo.getDate());
					System.out.println(ngayBD);

					List<HoaDon> listHD = hdDAO.getHoaDonByDate(ngayBD, ngayEnd);
					List<PhieuDatBan> listPDB = phieuDAO.getAllPhieuDatBan();
					List<ChiTietHoaDon> listCTHD = cthdDAO.getAllCTHD();

					for (HoaDon hd : listHD) {
						i++;
						try {
							for (ChiTietHoaDon cthd : listCTHD) {
								for (PhieuDatBan pdb : listPDB) {
									if (hd.getMaHoaDon() == cthd.getHoaDon().getMaHoaDon()
											&& cthd.getPhieuDatBan().getMaPhieuDatBan() == pdb.getMaPhieuDatBan()) {
										BigDecimal t = BigDecimal.valueOf(0.3d);
										BigDecimal t1 = pdb.getTienCoc();
										BigDecimal t2;
										if (pdb.getTrangThai().equals(suDungNgay)) {
											t2 = t1.divide(t);
											tableModel.addRow(new Object[] { i, hd.getMaHoaDon(),
													hd.getNgayXuatHoaDon(), df.format(t2) });

										} else if (pdb.getTrangThai().equals(muaVe)) {
											t2 = t1.divide(t);
											tableModel.addRow(new Object[] { i, hd.getMaHoaDon(),
													hd.getNgayXuatHoaDon(), df.format(t2) });

										} else {
											t2 = (t1.divide(t)).subtract(t1);
											tableModel.addRow(new Object[] { i, hd.getMaHoaDon(),
													hd.getNgayXuatHoaDon(), df.format(pdb.getTienCoc()) });
										}
										tongTien = tongTien.add(t2);

									}
								}
							}

						} catch (Exception e) {
							tableModel.addRow(new Object[] { i, hd.getMaHoaDon(), hd.getNgayXuatHoaDon() });
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				txtTongTien.setText(df.format(tongTien));
				tienTong = txtTongTien.getText();
				tableThongKeDoanhThu.setModel(tableModel);

			} catch (Exception e) {
			}

		}
	}

	public void loadTable() {
		try {

			// tableModel.getDataVector().removeAllElements();
			int rowCount = tableThongKeDoanhThu.getRowCount();
			for (int i = rowCount; i > 0; i--) {
				tableModel.removeRow(i - 1);
			}
			try {
				ngayBD = dateFormat.format(dateFrom.getDate());
				ngayEnd = dateFormat.format(dateTo.getDate());
				int i = 0;
				List<HoaDon> listHD = hdDAO.getAllHoaDon();
				List<PhieuDatBan> listPDB = phieuDAO.getAllPhieuDatBan();
				List<ChiTietHoaDon> listCTHD = cthdDAO.getAllCTHD();

				for (HoaDon hd : listHD) {
					i++;
					try {
						for (ChiTietHoaDon cthd : listCTHD) {
							for (PhieuDatBan pdb : listPDB) {
								if (hd.getMaHoaDon() == cthd.getHoaDon().getMaHoaDon()
										&& cthd.getPhieuDatBan().getMaPhieuDatBan() == pdb.getMaPhieuDatBan()) {
									BigDecimal t = BigDecimal.valueOf(0.3d);
									BigDecimal t1 = pdb.getTienCoc();
									BigDecimal t2;
									if (pdb.getTrangThai().equals(suDungNgay)) {
										t2 = t1.divide(t);
										tableModel.addRow(new Object[] { i, hd.getMaHoaDon(), hd.getNgayXuatHoaDon(),
												df.format(t2) });
										DoanhThu dt = new DoanhThu(hd.getMaHoaDon(), hd.getNgayXuatHoaDon() + "",
												df.format(t2));
										listDT.add(dt);

									} else if (pdb.getTrangThai().equals(muaVe)) {
										t2 = t1.divide(t);
										tableModel.addRow(new Object[] { i, hd.getMaHoaDon(), hd.getNgayXuatHoaDon(),
												df.format(t2) });
										DoanhThu dt = new DoanhThu(hd.getMaHoaDon(), hd.getNgayXuatHoaDon() + "",
												df.format(t2));
										listDT.add(dt);

									} else {
										t2 = (t1.divide(t)).subtract(t1);
										tableModel.addRow(new Object[] { i, hd.getMaHoaDon(), hd.getNgayXuatHoaDon(),
												df.format(pdb.getTienCoc()) });
										DoanhThu dt = new DoanhThu(hd.getMaHoaDon(), hd.getNgayXuatHoaDon() + "",
												df.format(t2));
										listDT.add(dt);
									}
									tongTien = tongTien.add(t2);

								}
							}
						}

					} catch (Exception e) {
						tableModel.addRow(new Object[] { i, hd.getMaHoaDon(), hd.getNgayXuatHoaDon() });
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			txtTongTien.setText(df.format(tongTien));
			tableThongKeDoanhThu.setModel(tableModel);

		} catch (Exception e) {
		}
	}
}
