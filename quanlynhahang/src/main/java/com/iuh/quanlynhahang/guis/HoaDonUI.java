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
import java.time.Month;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.iuh.quanlynhahang.daoimpls.HoaDonDAOImpl;
import com.iuh.quanlynhahang.daoimpls.KhachHangDAOImpl;
import com.iuh.quanlynhahang.daoimpls.NhanVienDAOImpl;
import com.iuh.quanlynhahang.entities.HoaDon;
import com.iuh.quanlynhahang.entities.KhachHang;
import com.iuh.quanlynhahang.entities.NhanVien;
import com.toedter.calendar.JDateChooser;

import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class HoaDonUI extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HoaDonUI frame = new HoaDonUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

//	public HoaDonUI() {
//		HoaDonUI();
//	}
//
//	public HoaDonUI(String tenKhachHang, String hoTenNhanVien, LocalDate tuNgay, LocalDate denNgay) {
//		HoaDonUI();
//		SearchKH(tenKhachHang, hoTenNhanVien, tuNgay, denNgay);
//	}

	/**
	 * Create the frame.
	 */
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JLabel lblDanhSchKhch;
	private JPanel panel_1;
	private JLabel lblThongTinHoaDon;
	private JLabel lblMKhchHng;
	private JLabel lblTnKhchHng;
	private JLabel lblMKhchHng_2;
	private JLabel lblMKhchHng_4;
	private JTextField txtTenKH;
	private JTextField txtTenNV;
	private JTextField txtmaHD;
	@SuppressWarnings("unused")
	private JDateChooser dateFrom, dateTo;
	private JButton btnTroVe, btnXemDSHD;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public HoaDonUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 1100, 650);
		setSize(1100, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JLabel lblKhchHng = new JLabel("Hóa Đơn");
		lblKhchHng.setBounds(506, 5, 101, 24);
		lblKhchHng.setForeground(Color.RED);
		lblKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		String[] header = "Mã Hóa Đơn; Tên Khách Hàng; Nhân Viết Xuất Hóa Đơn;Ngày Xuất Hóa Đơn;".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 91, 639, 437);

		lblDanhSchKhch = new JLabel("Danh Sách Hóa Đơn :");
		lblDanhSchKhch.setBounds(10, 61, 206, 20);
		lblDanhSchKhch.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		LocalDate date = LocalDate.now();
		int year = date.getYear();
		Month month = date.getMonth();
		int m = month.getValue();
		int day = date.getDayOfMonth();
		UtilDateModel model = new UtilDateModel();
		model.setDate(year, m, day);
		model.setSelected(true);

//		datePanelImpl = new JDatePanelImpl(model);

//		datePanelImpl2 = new JDatePanelImpl(model);

		panel_1 = new JPanel();
		panel_1.setBounds(659, 102, 417, 351);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));

		lblThongTinHoaDon = new JLabel("Thông Tin Hóa Đơn");
		lblThongTinHoaDon.setBounds(120, 10, 221, 24);
		lblThongTinHoaDon.setForeground(new Color(0, 0, 0));
		lblThongTinHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblMKhchHng = new JLabel("Mã Hóa Đơn : ");
		lblMKhchHng.setBounds(10, 67, 138, 28);
		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTnKhchHng = new JLabel("Tên Khách Hàng :");
		lblTnKhchHng.setBounds(10, 179, 120, 28);
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng_2 = new JLabel("Tên Nhân Viên :");
		lblMKhchHng_2.setBounds(10, 238, 120, 28);
		lblMKhchHng_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng_4 = new JLabel("Ngày Xuất Hóa Đơn :");
		lblMKhchHng_4.setBounds(10, 300, 138, 28);
		lblMKhchHng_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setBounds(150, 181, 245, 28);
		txtTenKH.setColumns(10);

		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setBounds(150, 238, 245, 28);
		txtTenNV.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(657, 452, 419, 76);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Thao T\u00E1c",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setBounds(288, 28, 104, 29);
		btnTroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTroVe.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnXemDSHD = new JButton("Danh Sách Hóa Đơn");
		btnXemDSHD.setBounds(43, 28, 165, 29);
		btnXemDSHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.setLayout(null);
		contentPane.add(lblKhchHng);
		contentPane.add(lblDanhSchKhch);
		contentPane.add(scrollPane);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblThongTinHoaDon);
		panel_1.add(lblMKhchHng);
		panel_1.add(lblTnKhchHng);
		panel_1.add(txtTenKH);
		panel_1.add(lblMKhchHng_2);
		panel_1.add(txtTenNV);
		panel_1.add(lblMKhchHng_4);

		txtmaHD = new JTextField();
		txtmaHD.setEditable(false);
		txtmaHD.setColumns(10);
		txtmaHD.setBounds(150, 67, 245, 28);
		panel_1.add(txtmaHD);

		dateTo = new JDateChooser();
		dateTo.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dateTo.setBounds(150, 297, 171, 31);
		dateTo.setLocale(Locale.forLanguageTag("vi-VN"));
		dateTo.setDateFormatString("yyyy-MM-dd");
		// dateTo.setDate(java.sql.Date.valueOf(LocalDate.now()));
		panel_1.add(dateTo);

		JLabel lblMKhchHng_3 = new JLabel("Mã Khách Hàng :");
		lblMKhchHng_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMKhchHng_3.setBounds(10, 124, 138, 28);
		panel_1.add(lblMKhchHng_3);

		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(150, 124, 245, 28);
		panel_1.add(txtMaKH);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(btnXemDSHD);
		panel_2.add(btnTroVe);

		table.addMouseListener(this);
		btnTroVe.addActionListener(this);
		btnXemDSHD.addActionListener(this);
	}

	private HoaDonDAOImpl hdDAO = new HoaDonDAOImpl();
	private KhachHangDAOImpl khDAO = new KhachHangDAOImpl();
	private NhanVienDAOImpl nvDAO = new NhanVienDAOImpl();

	@SuppressWarnings("unused")
	private void SearchKH(String tenKhachHang, String hoTenNhanVien, LocalDate tuNgay, LocalDate denNgay) {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		// int i = 0;
		List<KhachHang> listKH = khDAO.getKHByTen(tenKhachHang);
		List<HoaDon> listHD = hdDAO.getAllHoaDon();
		List<NhanVien> listNV = nvDAO.getAllNV();
		// List<HoaDon> listHDs=hdDAO.searchHD(tenKhachHang, hoTenNhanVien, tuNgay,
		// denNgay);
		for (HoaDon hd : listHD) {
			for (KhachHang kh : listKH) {
				try {
					if (hd.getKhachHang().getTenKhachHang().equals(kh.getTenKhachHang())
							&& hd.getNhanVien().getHoTenNhanVien().equals(hoTenNhanVien)
							&& ((hd.getNgayXuatHoaDon().isBefore(denNgay) || hd.getNgayXuatHoaDon().isEqual(denNgay))
									&& (hd.getNgayXuatHoaDon().isAfter(tuNgay)
											|| hd.getNgayXuatHoaDon().isEqual(tuNgay)))) {
						String[] rowData = { hd.getMaHoaDon(), hd.getKhachHang().getTenKhachHang(),
								hd.getNhanVien().getHoTenNhanVien(), hd.getNgayXuatHoaDon() + "" };
						tableModel.addRow(rowData);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}
		table.setModel(tableModel);
	}

	public void updateTable() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		try {
			List<HoaDon> listHD = hdDAO.getAllHoaDon();
			for (HoaDon hd : listHD) {
				try {
					tableModel.addRow(new Object[] { hd.getMaHoaDon(), hd.getKhachHang().getTenKhachHang(),
							hd.getNhanVien().getHoTenNhanVien(), hd.getNgayXuatHoaDon() + "" });
				} catch (Exception e) {
					tableModel.addRow(new Object[] { hd.getMaHoaDon(), "NULL", hd.getNhanVien().getHoTenNhanVien(),
							hd.getNgayXuatHoaDon() + "" });
				}

			}
			table.setModel(tableModel);
			table.getSelectionModel().clearSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTroVe)) {
			setVisible(false);
		} else if (o.equals(btnXemDSHD)) {
			updateTable();
		}

	}

	private JTextField txtMaKH;

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String maHD = tableModel.getValueAt(row, 0).toString();

		try {
			HoaDon hd = hdDAO.getHoaDonById(maHD);
			txtmaHD.setText(hd.getMaHoaDon());
			dateTo.setDate(Date.valueOf(hd.getNgayXuatHoaDon()));
			txtTenNV.setText(hd.getNhanVien().getHoTenNhanVien());
			try {
				txtTenKH.setText(hd.getKhachHang().getTenKhachHang());
				txtMaKH.setText(hd.getKhachHang().getMaKhachHang());
			} catch (Exception e3) {
				txtTenKH.setText("NULL");
				txtMaKH.setText("NULL");
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
