package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.commons.lang3.RandomStringUtils;

import com.iuh.quanlynhahang.daoimpls.LoaiTaiKhoanDAOImpl;
import com.iuh.quanlynhahang.daoimpls.NhanVienDAOImpl;
import com.iuh.quanlynhahang.daoimpls.TaiKhoanDAOImpl;
import com.iuh.quanlynhahang.entities.LoaiTaiKhoan;
import com.iuh.quanlynhahang.entities.NhanVien;
import com.iuh.quanlynhahang.entities.TaiKhoan;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class NhanVienUI extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1714356301148854595L;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhanVienUI frame = new NhanVienUI();
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
	public JPanel contentPane;
	private JLabel lblKhchHng;
	private DefaultTableModel tableModel;
	private JTable tableNhanVien;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnTimNV;
	private JButton btnLamMoiDuLieu;
	private JLabel lblNhpSin;
	private JTextField txtTimNhanVien;
	private JPanel panel_1;
	private JLabel lblThngTinKhch;
	private JLabel lblMNhnVin;
	private JLabel lblTnNhnVin;
	private JLabel lblMKhchHng_1;
	private JLabel lblMKhchHng_2;
	private JLabel lblMKhchHng_3;
	private JLabel lblMKhchHng_5;
	private JLabel lblMKhchHng_6;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JRadioButton rdbNam;
	private JRadioButton rdbNu;
	private JPanel panel_2;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JTextField txtMaNV;
	private JLabel lblNewLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxTrangThai;
	private JDateChooser dateNgaySinh;
	@SuppressWarnings("rawtypes")
	private JComboBox cboLoaiNV;
	JTextFieldDateEditor editor;

//	private static final String regexEmail = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
	private static final String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
//	private static final String BIRTHDAY_PATTERN = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((?:19|20)[0-9][0-9])$";
	private static final String BIRTHDAY_PATTERN = "^((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
	private static final String PHONE_PATTERN = "^0[0-9]{9}$";
	private static final String passwordDefault = "12345678";

	private static TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();
//	private static TaiKhoanUI taiKhoanUI = new TaiKhoanUI();
	private static NhanVienDAOImpl nhanVienDAO = new NhanVienDAOImpl();
	private static LoaiTaiKhoanDAOImpl loaiTaiKhoanDAO = new LoaiTaiKhoanDAOImpl();
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NhanVienUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblKhchHng = new JLabel("NHÂN VIÊN");
		lblKhchHng.setForeground(Color.RED);
		lblKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		String[] header = "STT;Mã Nhân Viên; Tên Nhân Viên;Giới Tính;Số Điện Thoại;Tình Trạng;Email;Địa Chỉ;Chức Vụ"
				.split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(tableNhanVien = new JTable(tableModel),
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(new LineBorder(new Color(192, 192, 192)), "T\u00ECm Ki\u1EBFm Nh\u00E2n Vi\u00EAn",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		btnTimNV = new JButton("Tìm Kiếm");
		btnTimNV.setIcon(new ImageIcon("images\\search.png"));
		btnTimNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblNhpSin = new JLabel("Nhập SDT");
		lblNhpSin.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTimNhanVien = new JTextField();
		txtTimNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTimNhanVien.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));

		lblThngTinKhch = new JLabel("Thông Tin Nhân Viên");
		lblThngTinKhch.setForeground(Color.BLACK);
		lblThngTinKhch.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblMNhnVin = new JLabel("Mã Nhân Viên");
		lblMNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTnNhnVin = new JLabel("Tên Nhân Viên");
		lblTnNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng_1 = new JLabel("Địa Chỉ");
		lblMKhchHng_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng_2 = new JLabel("Giới Tính");
		lblMKhchHng_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng_3 = new JLabel("Ngày Sinh");
		lblMKhchHng_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng_5 = new JLabel("Số Điện Thoại");
		lblMKhchHng_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng_6 = new JLabel("Email");
		lblMKhchHng_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenNV.setColumns(10);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSDT.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtEmail.setColumns(10);

		rdbNam = new JRadioButton("Nam");
		rdbNam.setSelected(true);
		rdbNam.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbNu = new JRadioButton("Nữ");
		rdbNu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbNam);
		buttonGroup.add(rdbNu);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Thao T\u00E1c",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("images\\add.png"));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setIcon(new ImageIcon("images\\edit.png"));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(434)
										.addComponent(lblKhchHng, GroupLayout.PREFERRED_SIZE, 159,
												GroupLayout.PREFERRED_SIZE)
										.addGap(52))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(5)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 630,
														Short.MAX_VALUE)
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 630,
														Short.MAX_VALUE))
										.addGap(10)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 413, Short.MAX_VALUE))
						.addGap(0)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(lblKhchHng).addGap(14)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE).addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(6)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
				.addContainerGap()));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(28)
						.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE).addGap(18)
						.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE).addGap(26)
						.addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE).addGap(18)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(btnThem)
								.addComponent(btnLamMoi).addComponent(btnCapNhat))
						.addContainerGap(18, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);

		lblNewLabel = new JLabel("Trạng Thái\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cbxTrangThai = new JComboBox();
		cbxTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		dateNgaySinh = new JDateChooser();
		dateNgaySinh.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dateNgaySinh.setLocale(Locale.forLanguageTag("vi-VN"));
		dateNgaySinh.setDateFormatString("yyyy-MM-dd");
		dateNgaySinh.setDate(Date.valueOf(LocalDate.now()));
		editor = (JTextFieldDateEditor) dateNgaySinh.getDateEditor();
		editor.setEditable(false);

		JLabel lblNewLabel_1 = new JLabel("Loại NV");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cboLoaiNV = new JComboBox();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(119)
						.addComponent(lblThngTinKhch, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE).addGap(77))
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(lblMKhchHng_6, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(cbxTrangThai, 0, 310, Short.MAX_VALUE)
						.addGap(16))
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblMNhnVin, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										ComponentPlacement.UNRELATED)
								.addComponent(txtMaNV, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(lblMKhchHng_3, GroupLayout.PREFERRED_SIZE, 99,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED))
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 72,
																GroupLayout.PREFERRED_SIZE)
														.addGap(28)))
										.addComponent(lblMKhchHng_2)
										.addComponent(lblMKhchHng_1, GroupLayout.PREFERRED_SIZE, 71,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTnNhnVin, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
												.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(txtDiaChi, GroupLayout.DEFAULT_SIZE, 273,
																Short.MAX_VALUE)
														.addComponent(txtTenNV, GroupLayout.DEFAULT_SIZE, 273,
																Short.MAX_VALUE)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(rdbNam, GroupLayout.PREFERRED_SIZE, 63,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(59)
																.addComponent(rdbNu, GroupLayout.PREFERRED_SIZE, 57,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, 94,
																		Short.MAX_VALUE))))
												.addComponent(cboLoaiNV, 0, 273, Short.MAX_VALUE).addComponent(
														dateNgaySinh, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblMKhchHng_5, GroupLayout.PREFERRED_SIZE, 99,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(txtEmail, Alignment.TRAILING).addComponent(txtSDT,
														Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 276,
														Short.MAX_VALUE))))
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGap(16)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(9).addComponent(lblThngTinKhch).addGap(7)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(lblMNhnVin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnNhnVin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenNV, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMKhchHng_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboLoaiNV, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMKhchHng_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbNu, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbNam, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMKhchHng_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateNgaySinh, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(14)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMKhchHng_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMKhchHng_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(cbxTrangThai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addGap(12)));
		panel_1.setLayout(gl_panel_1);

		btnLamMoiDuLieu = new JButton("Làm Mới Dữ Liệu");
		btnLamMoiDuLieu.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoiDuLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(7).addComponent(lblNhpSin).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(txtTimNhanVien, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnTimNV, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE).addGap(18)
				.addComponent(btnLamMoiDuLieu, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLamMoiDuLieu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNhpSin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTimNhanVien, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTimNV)))
				.addContainerGap(12, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		TableColumnModel columnModel = tableNhanVien.getColumnModel();
		tableNhanVien.setDefaultEditor(Object.class, null);
		tableNhanVien.setRowHeight(30);
		columnModel.getColumn(0).setPreferredWidth(50);// stt
		columnModel.getColumn(1).setPreferredWidth(100);// ma
		columnModel.getColumn(2).setPreferredWidth(200);// tec
		columnModel.getColumn(3).setPreferredWidth(70);
		columnModel.getColumn(4).setPreferredWidth(120);// sdt
		columnModel.getColumn(5).setPreferredWidth(120);// gt
		columnModel.getColumn(6).setPreferredWidth(200);// dc
		columnModel.getColumn(7).setPreferredWidth(350);// dc
		columnModel.getColumn(8).setPreferredWidth(100);// dc
		tableNhanVien.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		btnCapNhat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnTimNV.addActionListener(this);
		btnLamMoiDuLieu.addActionListener(this);
		txtMaNV.setText(randomMaNVNotExisted());
		cboLoaiNV.addActionListener(this);
		cbxTrangThai.addActionListener(this);
		tableNhanVien.addMouseListener(this);
		tableNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableNhanVien.getColumnCount(); c++) {
			Class<?> col_class = tableNhanVien.getColumnClass(c);
			tableNhanVien.setDefaultEditor(col_class, null);
		}

		List<String> loaiNVs = getAllTenLTK();
		for (String lvn : loaiNVs) {
			cboLoaiNV.addItem(lvn);
		}
		cbxTrangThai.addItem("Đang Làm Việc");
		cbxTrangThai.addItem("Nghỉ Việc");

		updateTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnLamMoi)) {
			refresh();
			updateTable();
		} else if (obj.equals(btnCapNhat)) {
			try {

				int row = tableNhanVien.getSelectedRow();
				if (row != -1) {
					boolean check = true;
					StringBuilder mesgError = new StringBuilder();
					String maNV = txtMaNV.getText();
					String tenNV = txtTenNV.getText().trim();
					String diaChi = txtDiaChi.getText().trim();
					String gioiTinh = null;
					if (rdbNam.isSelected()) {
						gioiTinh = "Nam";
					} else if (rdbNu.isSelected()) {
						gioiTinh = "Nữ";
					}
					Date ngaySinhsql = null;
					String ngaySinhtxt = "";
					try {
						ngaySinhtxt = dateFormat.format(dateNgaySinh.getDate());
						if (ngaySinhtxt.isEmpty() || ngaySinhtxt.equalsIgnoreCase("") || ngaySinhtxt == null) {
							mesgError.append("Vui lòng nhập ngày sinh!\n");
							check = false;
						} else if (ngaySinhtxt.matches(BIRTHDAY_PATTERN) == false) {
							mesgError.append("Ngày sinh không hợp lệ!\n");
							check = false;
						} else if (ngaySinhtxt.matches(BIRTHDAY_PATTERN) == true) {
							java.util.Date ngaySinh;
							ngaySinh = dateFormat.parse(ngaySinhtxt);
							ngaySinhsql = new Date(ngaySinh.getTime());
							check = true;
						} else {
							mesgError.append("Ngày sinh không hợp lệ!\n");
							check = false;
						}
					} catch (Exception e2) {
					}
					String sDT = txtSDT.getText().trim();
					String email = txtEmail.getText().trim();
					String trangThai = cbxTrangThai.getSelectedItem().toString();

					if (tenNV.isEmpty()) {
						mesgError.append("Vui lòng nhập tên khách hàng!\n");
						check = false;
					}
					if (diaChi.isEmpty()) {
						mesgError.append("Vui lòng nhập địa chỉ!\n");
						check = false;
					}
					if (sDT.isEmpty()) {
						mesgError.append("Vui lòng nhập số điện thoại!\n");
						check = false;
					} else if (sDT.matches(PHONE_PATTERN) == false) {
						mesgError.append("Số điện thoại không hợp lệ!\n");
						check = false;
					}
					if (email.isEmpty()) {
						mesgError.append("Vui lòng nhập email!\n");
						check = false;
					} else if (email.matches(EMAIL_PATTERN) == false) {
						mesgError.append("Email không hợp lệ!\n");
					}
					if (check == false) {
						JOptionPane.showMessageDialog(this, mesgError, "Thông báo", JOptionPane.ERROR_MESSAGE,
								new ImageIcon("images\\warning.png"));

						txtTenNV.selectAll();
						txtTenNV.requestFocus();
					} else {
						try {
							LoaiTaiKhoan loaiTaiKhoan = loaiTaiKhoanDAO
									.getLTKByTenLTK(cboLoaiNV.getSelectedItem().toString());
							System.out.println("loai tai khoản   " + loaiTaiKhoan.getTenLoaiTaiKhoan());

							NhanVien nhanVien = nhanVienDAO.getNVByID(txtMaNV.getText());
							TaiKhoan taiKhoan = nhanVien.getTaiKhoan();

							System.out.println("============" + taiKhoan);
							taiKhoan.setLoaiTaiKhoan(loaiTaiKhoan);
							taiKhoanDAO.updateTK(taiKhoan);
							NhanVien nv = new NhanVien(maNV, tenNV, ngaySinhsql, gioiTinh, diaChi, sDT, trangThai,
									email, taiKhoan);
							nhanVienDAO.updateNV(nv);
							updateTable();
							refresh();
							txtMaNV.setText(randomMaNVNotExisted());
							JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công!", "Thông báo",
									JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thất bại!", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
							e2.printStackTrace();
						}

					}
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để cập nhật!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				}

			} catch (Exception e2) {
			}
		} else if (obj.equals(btnLamMoiDuLieu)) { // refresh data for table
			updateTable();
			refresh();
		} else if (obj.equals(btnTimNV)) {
			try {

				String sDT = txtTimNhanVien.getText().trim();
				if (sDT.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					txtTimNhanVien.requestFocus();
				} else if (sDT.matches(PHONE_PATTERN) == false) {
					JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					txtTimNhanVien.selectAll();
					txtTimNhanVien.requestFocus();
				} else {
					try {
						NhanVien nv = nhanVienDAO.getNVBySDT(sDT);
						tableModel.getDataVector().removeAllElements();
						tableModel.addRow(new Object[] { 1, nv.getMaNhanVien(), nv.getHoTenNhanVien(), nv.getDiaChi(),
								nv.getGioiTinh(), nv.getNgaySinh(), nv.getSoDienThoai(), nv.getTinhTrang() });
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên!", "Thông báo",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
						txtTimNhanVien.selectAll();
						txtTimNhanVien.requestFocus();
					}
				}

			} catch (Exception e2) {
			}
		} else if (obj.equals(btnThem)) {
			try {
				List<NhanVien> nhanViens = nhanVienDAO.getAllNV();
				List<String> sdts = new ArrayList<String>();
				for (NhanVien nv : nhanViens) {
					sdts.add(nv.getSoDienThoai());
				}
				boolean check = true;
				StringBuilder mesgError = new StringBuilder();

				String ma = txtMaNV.getText().trim();
				String ten = txtTenNV.getText().trim();
				String diaChi = txtDiaChi.getText().trim();

				java.util.Date ngaySinhsql = dateNgaySinh.getDate();

				String sDT = txtSDT.getText().trim();
				String email = txtEmail.getText().trim();

				String gioiTinh = "";
				if (rdbNam.isSelected()) {
					gioiTinh = "Nam";
				} else if (rdbNu.isSelected()) {
					gioiTinh = "Nữ";
				}
				String trangThai = cbxTrangThai.getSelectedItem().toString();

				if (ten.isEmpty()) {
					mesgError.append("Vui lòng nhập tên nhân viên!\n");
					check = false;
				}
				if (diaChi.isEmpty()) {
					mesgError.append("Vui lòng nhập địa chỉ!\n");
					check = false;
				}
				if (sDT.isEmpty()) {
					mesgError.append("Vui lòng nhập số điện thoại!\n");
					check = false;
				} else if (sDT.matches(PHONE_PATTERN) == false) {
					mesgError.append("Số điện thoại không hợp lệ!\n");
					check = false;
				} else {
					for (String string : sdts) {
						if (sDT.equalsIgnoreCase(string)) {
							mesgError.append("Số điện thoại đã tồn tại trong hệ thống!\n");
							check = false;
						}
					}
				}
				if (email.isEmpty()) {
					mesgError.append("Vui lòng nhập email!\n");
					check = false;
				} else if (email.matches(EMAIL_PATTERN) == false) {
					mesgError.append("Email không hợp lệ!\n");
					check = false;
				}

				if (check == false) {
					JOptionPane.showMessageDialog(this, mesgError, "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));

//					txtTenNV.selectAll();
					txtTenNV.requestFocus();
				} else {
					try {
						LoaiTaiKhoan loaiTaiKhoan = loaiTaiKhoanDAO
								.getLTKByTenLTK(cboLoaiNV.getSelectedItem().toString());
						TaiKhoan taiKhoan = new TaiKhoan(TaiKhoanUI.randomMaTKNotExisted(), loaiTaiKhoan,
								txtMaNV.getText(), passwordDefault);
						taiKhoanDAO.createTK(taiKhoan);

						System.out.println(taiKhoan.getMaTaiKhoan());
						NhanVien nhanVien = new NhanVien(ma, ten, ngaySinhsql, gioiTinh, diaChi, sDT, trangThai, email,
								taiKhoan);
						System.out.println(nhanVien.getTaiKhoan().getMaTaiKhoan());
						boolean checkCreateNV = nhanVienDAO.createNV(nhanVien);
						if (checkCreateNV == true) {
							updateTable();
							refresh();
							JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!", "Thông báo",
									JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
						} else {
							JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại!", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
						}
					} catch (Exception e2) {
						e2.printStackTrace();
						e2.getMessage();
					}
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableNhanVien.getSelectedRow();
		String maNV = tableModel.getValueAt(row, 1).toString();
		try {
			NhanVien nv = nhanVienDAO.getNVByID(maNV);
			txtMaNV.setText(maNV);
			txtTenNV.setText(nv.getHoTenNhanVien());
			txtDiaChi.setText(nv.getDiaChi());
			txtSDT.setText(nv.getSoDienThoai());
			String gioiTinh = nv.getGioiTinh().toString().trim();
			if (gioiTinh.equalsIgnoreCase("Nam")) {
				rdbNam.setSelected(true);
				rdbNu.setSelected(false);
			} else {
				rdbNu.setSelected(true);
				rdbNam.setSelected(false);
			}
			dateNgaySinh.setDate(nv.getNgaySinh());
//			LocalDate date = LocalDate.parse(dateFormat.format(dateNgaySinh.getDate()));
			txtSDT.setText(nv.getSoDienThoai());
			txtEmail.setText(nv.getEmail());
			cboLoaiNV.setSelectedItem(nv.getTaiKhoan().getLoaiTaiKhoan().getTenLoaiTaiKhoan());
			cbxTrangThai.setSelectedItem(nv.getTinhTrang());
		} catch (Exception e2) {
			System.out.println("error mouse clicked");
			e2.printStackTrace();
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

	@SuppressWarnings("static-access")
	public String randomMaNVNotExisted() {
		String maNV;
		List<String> idNVs = new ArrayList<String>();
		List<NhanVien> nhanViens = nhanVienDAO.getAllNV();
		for (NhanVien nhanVien : nhanViens) {
			idNVs.add(nhanVien.getMaNhanVien());
		}

		do {
			RandomStringUtils randomStringUtils = new RandomStringUtils();
			maNV = randomStringUtils.randomNumeric(8);

		} while (idNVs.contains(maNV));
		return "NV" + maNV;
	}

	public List<String> getAllTenLTK() {
		List<LoaiTaiKhoan> loaiTKs = loaiTaiKhoanDAO.getAllLTK();
		List<String> tenLTKs = new ArrayList<String>();
		for (LoaiTaiKhoan ltk : loaiTKs) {
			tenLTKs.add(ltk.getTenLoaiTaiKhoan());
		}
		return tenLTKs;
	}

	public void updateTable() {
		tableModel = (DefaultTableModel) tableNhanVien.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			List<NhanVien> nhanViens = nhanVienDAO.getAllNV();
			int i = 0;
			for (NhanVien nv : nhanViens) {
				i++;
				tableModel.addRow(new Object[] { i, nv.getMaNhanVien(), nv.getHoTenNhanVien(), nv.getGioiTinh(),
						nv.getSoDienThoai(), nv.getTinhTrang(), nv.getEmail(), nv.getDiaChi(),
						nv.getTaiKhoan().getLoaiTaiKhoan().getTenLoaiTaiKhoan() });
			}
			tableNhanVien.setModel(tableModel);
			tableNhanVien.getSelectionModel().clearSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void refresh() {
		txtDiaChi.setText("");
		txtEmail.setText("");
		dateNgaySinh.setDate(null);
		txtSDT.setText("");
		txtTenNV.setText("");
		txtMaNV.setText(randomMaNVNotExisted());

		cboLoaiNV.removeAllItems();
		List<LoaiTaiKhoan> lTKs = loaiTaiKhoanDAO.getAllLTK();
		for (LoaiTaiKhoan ltk : lTKs) {
			cboLoaiNV.addItem(ltk.getTenLoaiTaiKhoan());
		}
	}
}
