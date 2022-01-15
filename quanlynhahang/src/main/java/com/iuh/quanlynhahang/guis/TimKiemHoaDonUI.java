package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.iuh.quanlynhahang.daoimpls.HoaDonDAOImpl;
import com.iuh.quanlynhahang.daoimpls.NhanVienDAOImpl;
import com.iuh.quanlynhahang.entities.HoaDon;
import com.iuh.quanlynhahang.entities.NhanVien;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class TimKiemHoaDonUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JTextField txtTenKH;
	private JButton btnTimKiem;
	private JDateChooser dateFrom, dateTo;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JLabel lblTmKimHa;
	private JLabel label;
	private JRadioButton rdbMa;
	private JRadioButton rdbtenKH;
	private JRadioButton rdbTenNV;
	private JRadioButton rdbNgay;
	private JLabel lblMHd;
	private JTextField txtMa;
	JTextFieldDateEditor editor;
	@SuppressWarnings("rawtypes")
	private JComboBox cboNV;

	private static List<HoaDon> hoaDons = new ArrayList<HoaDon>();
	private NhanVienDAOImpl nhanVienDAO = new NhanVienDAOImpl();
	private HoaDonDAOImpl hoaDonDAO = new HoaDonDAOImpl();
	private static boolean validateData = true;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TimKiemHoaDonUI frame = new TimKiemHoaDonUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TimKiemHoaDonUI() {

		setTitle("Tìm Kiếm Hóa Đơn");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);

		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblTnNhnVin = new JLabel("Tên Nhân Viên");
		lblTnNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblnNgy = new JLabel("Đến Ngày:");
		lblnNgy.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblTNgy = new JLabel("Từ Ngày:");
		lblTNgy.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon("images\\search.png"));
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblNgyLpHa = new JLabel("Ngày Lập Hóa Đơn");
		lblNgyLpHa.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenKH.setColumns(10);

		btnTimKiem.addActionListener(this);

		dateFrom = new JDateChooser();
		dateFrom.getCalendarButton().setEnabled(false);
		dateFrom.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dateFrom.setLocale(Locale.forLanguageTag("vi-VN"));
		dateFrom.setDateFormatString("yyyy-MM-dd");
		dateFrom.setDate(Date.valueOf(LocalDate.now()));
		editor = (JTextFieldDateEditor) dateFrom.getDateEditor();
		editor.setEditable(false);

		dateTo = new JDateChooser();
		dateTo.getCalendarButton().setEnabled(false);
		dateTo.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dateTo.setLocale(Locale.forLanguageTag("vi-VN"));
		dateTo.setDateFormatString("yyyy-MM-dd");
		dateTo.setDate(Date.valueOf(LocalDate.now()));
		editor = (JTextFieldDateEditor) dateTo.getDateEditor();
		editor.setEditable(false);

		String[] header = "STT;Mã Hóa Đơn; Tên Khách Hàng;Ngày Xuất Hóa Đơn;Nhân Viên Xuất HD".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTmKimHa = new JLabel("TÌM KIẾM HÓA ĐƠN");
		lblTmKimHa.setForeground(Color.RED);
		lblTmKimHa.setFont(new Font("Times New Roman", Font.BOLD, 25));

		label = new JLabel("Tìm Kiếm Theo");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbMa = new JRadioButton("Mã");
		rdbMa.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbtenKH = new JRadioButton("Tên KH");
		rdbtenKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbTenNV = new JRadioButton("Tên NV");
		rdbTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbNgay = new JRadioButton("Ngày lập HD");
		rdbNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMHd = new JLabel("Mã HD");
		lblMHd.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMa.setColumns(10);

		cboNV = new JComboBox();
		cboNV.setEnabled(false);
		cboNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(406).addComponent(lblTmKimHa,
						GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(6).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addGap(19)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbMa, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbTenNV, GroupLayout.PREFERRED_SIZE, 81,
												GroupLayout.PREFERRED_SIZE))
								.addGap(36)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbNgay, GroupLayout.PREFERRED_SIZE, 108,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtenKH, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3)
								.addComponent(lblMHd, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGap(40).addComponent(txtMa, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
						.addComponent(lblNgyLpHa, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(53)
								.addComponent(lblTNgy, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addGap(20).addComponent(dateFrom, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addGap(52))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(53)
								.addComponent(lblnNgy, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addGap(20).addComponent(dateTo, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addGap(52))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(lblTnNhnVin,
										GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
								.addGap(17)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(cboNV, 0, 238, Short.MAX_VALUE).addGap(2))
										.addComponent(txtTenKH, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(153).addComponent(btnTimKiem,
								GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
						.addGap(35).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
						.addGap(31)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(10).addComponent(lblTmKimHa).addGap(48)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(rdbMa).addGap(3)
										.addComponent(rdbTenNV))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(4)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbNgay)
												.addGroup(gl_contentPane
														.createSequentialGroup().addGap(28).addComponent(rdbtenKH)))))
						.addGap(7)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMHd, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMa, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(21)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(23)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnNhnVin, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboNV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(24).addComponent(lblNgyLpHa, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTNgy, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateFrom, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(14)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblnNgy, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateTo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(29)
						.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(5).addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)))
				.addGap(10)));
		contentPane.setLayout(gl_contentPane);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbTenNV);
		group.add(rdbMa);
		group.add(rdbNgay);
		group.add(rdbtenKH);

		TableColumnModel columnModel = table.getColumnModel();
		table.setDefaultEditor(Object.class, null);
		table.setRowHeight(30);
		columnModel.getColumn(0).setPreferredWidth(70);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(200);
		columnModel.getColumn(3).setPreferredWidth(150);
		columnModel.getColumn(4).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		List<NhanVien> list = nhanVienDAO.getAllNV();
		for (NhanVien nv : list) {
			cboNV.addItem(nv.getHoTenNhanVien());
		}

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < table.getColumnCount(); c++) {
			Class<?> col_class = table.getColumnClass(c);
			table.setDefaultEditor(col_class, null); // remove editor
		}

		rdbMa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(true);
				txtTenKH.setEditable(false);
				cboNV.setEnabled(false);
				dateFrom.setEnabled(false);
				dateTo.setEnabled(false);

			}
		});
		rdbtenKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(false);
				txtTenKH.setEditable(true);
				cboNV.setEnabled(false);
				dateFrom.setEnabled(false);
				dateTo.setEnabled(false);
			}
		});
		rdbTenNV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(false);
				txtTenKH.setEditable(false);
				cboNV.setEnabled(true);
				dateFrom.setEnabled(false);
				dateTo.setEnabled(false);
			}
		});
		rdbNgay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(false);
				txtTenKH.setEditable(false);
				cboNV.setEnabled(false);
				dateFrom.setEnabled(true);
				dateTo.setEnabled(true);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTimKiem)) {
			if (!rdbNgay.isSelected() && !rdbTenNV.isSelected() && !rdbMa.isSelected() && !rdbtenKH.isSelected()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			} else {
				timHoaDon();
				if (validateData == true) {
					updateTable();
				}
			}
		}

	}

	private void timHoaDon() {
		try {

			String ma = txtMa.getText().trim();
			String tenKH = txtTenKH.getText().trim();
			String tenNV = cboNV.getSelectedItem().toString().trim();
			java.util.Date from = dateFrom.getDate();
			java.util.Date to = dateTo.getDate();
			ZoneId defaultZoneId = ZoneId.systemDefault();
			Instant instantFrom = from.toInstant();
			Instant instantTo = to.toInstant();
			LocalDate localDateFrom = instantFrom.atZone(defaultZoneId).toLocalDate();
			LocalDate localDateTo = instantTo.atZone(defaultZoneId).toLocalDate();

			if (rdbMa.isSelected()) {
				if (ma.equalsIgnoreCase("") || ma == null || ma.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hóa đơn!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					validateData = false;
				} else {
					hoaDons.clear();
					hoaDons = hoaDonDAO.getHoaDonsById(ma);
					validateData = true;
				}
			} else if (rdbTenNV.isSelected()) {
				hoaDons.clear();
				hoaDons = hoaDonDAO.getHoaDonsByTenNV(tenNV);
				System.out.println(hoaDons.size());
				validateData = true;
			} else if (rdbtenKH.isSelected()) {
				if (tenKH.equalsIgnoreCase("") || tenKH == null || tenKH.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khách hàng!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					validateData = false;
				} else {
					hoaDons.clear();
					hoaDons = hoaDonDAO.getHoaDonsByTenKH(tenKH);
					validateData = true;
				}
			} else if (rdbNgay.isSelected()) {
				if (from.after(to)) {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hợp lệ(Ngày bắt đầu <= ngày kết thúc)!",
							"Thông báo", JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					validateData = false;
				} else {
					hoaDons.clear();
					hoaDons = hoaDonDAO.getHoaDonsFromDateToDate(localDateFrom, localDateTo);
					validateData = true;
				}
			}

		} catch (Exception e) {
		}
	}

	private void updateTable() {
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			int i = 0;
			if (hoaDons.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu!", "Thông báo", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("images\\warning.png"));
				tableModel.fireTableDataChanged();
			} else {
				for (HoaDon hd : hoaDons) {
					i++;
					if (hd.getKhachHang() == null) {
						tableModel.addRow(new Object[] { i, hd.getMaHoaDon(), "Null", hd.getNgayXuatHoaDon(),
								hd.getNhanVien().getHoTenNhanVien() });
					} else {
						tableModel.addRow(new Object[] { i, hd.getMaHoaDon(), hd.getKhachHang().getTenKhachHang(),
								hd.getNgayXuatHoaDon(), hd.getNhanVien().getHoTenNhanVien() });
					}
				}
				table.setModel(tableModel);
				table.getSelectionModel().clearSelection();
				tableModel.fireTableDataChanged();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
