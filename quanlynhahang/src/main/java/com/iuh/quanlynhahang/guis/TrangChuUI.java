package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.iuh.quanlynhahang.daoimpls.NhanVienDAOImpl;

public class TrangChuUI extends JFrame implements ActionListener, MenuListener {

	private static final long serialVersionUID = -7212075333686998729L;
	private JLabel lblXinCho, lblTenNhanVien;
//	private static TrangChuUI frame;
	public static JTabbedPane tabbedPane;
	private JMenuBar menuBar;
	private JMenu mnHeThong, mnDanhMuc, mnThongKebaoCao, mnTimKiem, mnXuLy;
	public JMenuItem mniThongTinCaNhan, mniDangXuat, mniKhachHang, mniNhanVien, mniBan, mniSanh, mniMonAn, mniTaiKhoan,
			mniThongKeDoanhThu, mniDoiMatKhau, mniThoat, mniChucVu, mniTimKiemHoaDon, mniTimKiemKhachHang,
			mniDatBanTiec, mniMuaVe, mniPhieuDat, mniLoaiMon, mniThongKeDoUong, mniThongKeMonAn, mniThongKeKhachHang,
			mniTimKiemMonAn;

//	private static NhanVienUI nvUI = new NhanVienUI();
//	private static ThongTinCaNhan ttUI = new ThongTinCaNhan();
//	private static TaiKhoanUI tkUI = new TaiKhoanUI();
//	private static KhachHangUI khUI = new KhachHangUI();
//	private static BanUI ban = new BanUI();
//	private static SanhUI sanh = new SanhUI();
//	private static ThongKeDoanhThu tkDoanhThu = new ThongKeDoanhThu();
//	private static DoiMatKhau doiMK = new DoiMatKhau();
//	private static DanhSachKhachHangUI dskhUI = new DanhSachKhachHangUI();
//	private static TimKiemKhachHangUI timKiemKHUI = new TimKiemKhachHangUI();
//	private static ChucVuUI cvUI = new ChucVuUI();
//	private static DatBanTiec_ChonBan datBanTiec = new DatBanTiec_ChonBan();
//	private static HoaDon hoaDon = new HoaDon();
//	private static LoaiMonUI loaiMonUI = new LoaiMonUI();
//	private static MonUI monUI = new MonUI();
//	private static MuaVeUI muaVeUI = new MuaVeUI();
//	private static PhieuDatMonUI phieuDatMonUI = new PhieuDatMonUI();
//	private static ThongKeDoUongUI thongKeDoUongUI = new ThongKeDoUongUI();
//	private static ThongKeKhachHangUI thongKeKhachHangUI = new ThongKeKhachHangUI();
//	private static ThongKeMonAnUI thongKeMonAnUI = new ThongKeMonAnUI();
//	private static ThongKeDoanhThu thongKeDoanhThuUI = new ThongKeDoanhThu();
//	private static TimKiemHoaDonUI timKiemHoaDonUI = new TimKiemHoaDonUI();
//	private static TimKiemKhachHangUI timKiemKhachHangUI = new TimKiemKhachHangUI();
//	private static TimKiemMonAnUI timKiemMonAnUI = new TimKiemMonAnUI();

//	private static TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();
	private static NhanVienDAOImpl nhanVienDAO = new NhanVienDAOImpl();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frame = new TrangChu();
//					frame.setVisible(true);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */

	public TrangChuUI() {
		setTitle("Quản Lý Nhà Hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1100, 650);
		setSize(1100, 650);
		setLocationRelativeTo(null);

		menuBar = new JMenuBar();

		mnHeThong = new JMenu("Hệ Thống");
		mnHeThong.setIcon(new ImageIcon("images\\system.png"));
		mnHeThong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnHeThong);

		mniTaiKhoan = new JMenuItem("Tài Khoản");
		mniTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnHeThong.add(mniTaiKhoan);

		mniThongTinCaNhan = new JMenuItem("Thông Tin Cá Nhân");
		mniThongTinCaNhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnHeThong.add(mniThongTinCaNhan);

		mniDoiMatKhau = new JMenuItem("Cập Nhật Tài Khoản");
		mniDoiMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnHeThong.add(mniDoiMatKhau);

		mniDangXuat = new JMenuItem("Đăng Xuất");
		mniDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnHeThong.add(mniDangXuat);

		mniThoat = new JMenuItem("Thoát");
		mniThoat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnHeThong.add(mniThoat);

		mnDanhMuc = new JMenu("Danh Mục");
		mnDanhMuc.setIcon(new ImageIcon("images\\modules.gif"));
		mnDanhMuc.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnDanhMuc);

		mniKhachHang = new JMenuItem("Khách Hàng");
		mniKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnDanhMuc.add(mniKhachHang);

		mniNhanVien = new JMenuItem("Nhân Viên");
		mniNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnDanhMuc.add(mniNhanVien);
		mniNhanVien.addActionListener(this);

		mniMonAn = new JMenuItem("Món");
		mniMonAn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnDanhMuc.add(mniMonAn);

		mniLoaiMon = new JMenuItem("Loại Món");
		mniLoaiMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnDanhMuc.add(mniLoaiMon);

		mniBan = new JMenuItem("Bàn");
		mniBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnDanhMuc.add(mniBan);

		mniSanh = new JMenuItem("Sảnh");
		mniSanh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnDanhMuc.add(mniSanh);

		mniChucVu = new JMenuItem("Chức Vụ");
		mniChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnDanhMuc.add(mniChucVu);

		mnXuLy = new JMenu("Xử Lý");
		mnXuLy.setIcon(new ImageIcon("images\\order.gif"));
		mnXuLy.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnXuLy.addActionListener(this);
		mnXuLy.addMenuListener(this);
		menuBar.add(mnXuLy);

		mniDatBanTiec = new JMenuItem("Đặt Bàn Tiệc");
		mniDatBanTiec.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnXuLy.add(mniDatBanTiec);

		mniMuaVe = new JMenuItem("Mua Về");
		mniMuaVe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnXuLy.add(mniMuaVe);

		mniPhieuDat = new JMenuItem("Phiếu Đặt Bàn");
		mniPhieuDat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnXuLy.add(mniPhieuDat);

		mnTimKiem = new JMenu("Tìm Kiếm");
		mnTimKiem.setIcon(new ImageIcon("images\\search_menu.png"));
		mnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnTimKiem);

		mniTimKiemMonAn = new JMenuItem("Món Ăn");
		mniTimKiemMonAn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnTimKiem.add(mniTimKiemMonAn);

		mniTimKiemHoaDon = new JMenuItem("Hóa Đơn");
		mniTimKiemHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnTimKiem.add(mniTimKiemHoaDon);

		mniTimKiemKhachHang = new JMenuItem("Khách Hàng");
		mniTimKiemKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnTimKiem.add(mniTimKiemKhachHang);

		mnThongKebaoCao = new JMenu("Thống Kê / Báo Cáo");
		mnThongKebaoCao.setIcon(new ImageIcon("images\\st_rp.png"));
		mnThongKebaoCao.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnThongKebaoCao);

		mniThongKeMonAn = new JMenuItem("Thống Kê Món Ăn");
		mniThongKeMonAn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnThongKebaoCao.add(mniThongKeMonAn);

		mniThongKeDoUong = new JMenuItem("Thống Kê Đồ Uống");
		mniThongKeDoUong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnThongKebaoCao.add(mniThongKeDoUong);

		mniThongKeKhachHang = new JMenuItem("Thống Kê Khách Hàng");
		mniThongKeKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnThongKebaoCao.add(mniThongKeKhachHang);

		mniThongKeDoanhThu = new JMenuItem("Thống Kê Doanh Thu");
		mniThongKeDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnThongKebaoCao.add(mniThongKeDoanhThu);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		lblXinCho = new JLabel("Xin chào");
		lblXinCho.setForeground(Color.RED);
		lblXinCho.setFont(new Font("Times New Roman", Font.BOLD, 16));

		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setForeground(Color.RED);
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE).addGap(18)
						.addComponent(lblXinCho, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblTenNhanVien, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
						.addGap(18)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblXinCho, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTenNhanVien, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
				.addGap(8).addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

		mniNhanVien.addActionListener(this);
		mniKhachHang.addActionListener(this);
		mniThongTinCaNhan.addActionListener(this);
		mniBan.addActionListener(this);
		mniSanh.addActionListener(this);
		mnTimKiem.addMenuListener(this);
		mniThongKeDoanhThu.addActionListener(this);
		mniThongKeDoUong.addActionListener(this);
		mniThongKeMonAn.addActionListener(this);
		mniThongKeKhachHang.addActionListener(this);
		mniDoiMatKhau.addActionListener(this);
		mniDangXuat.addActionListener(this);
		mniThoat.addActionListener(this);
		mniDatBanTiec.addActionListener(this);
		mniTimKiemKhachHang.addActionListener(this);
		mniTimKiemHoaDon.addActionListener(this);
		mniTimKiemMonAn.addActionListener(this);
		mniChucVu.addActionListener(this);
		mniTaiKhoan.addActionListener(this);
		mniPhieuDat.addActionListener(this);
		mniMuaVe.addActionListener(this);
		mniLoaiMon.addActionListener(this);
		mniMonAn.addActionListener(this);

		lblTenNhanVien.setText(nhanVienDAO.getNVByMaTaiKhoan(DangNhapUI.taiKhoan.getMaTaiKhoan()).getHoTenNhanVien());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(mniNhanVien)) {
			NhanVienUI nvUI = new NhanVienUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Nhân Viên", null, tabbedPane.add(nvUI.contentPane), "Nhân Viên");
		} else if (o.equals(mniThongTinCaNhan)) {
			ThongTinCaNhanUI thongTinCaNhan = new ThongTinCaNhanUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Thông Tin Cá Nhân", null, tabbedPane.add(thongTinCaNhan.contentPane),
					"Thông Tin Cá Nhân");
		} else if (o.equals(mniTaiKhoan)) {
			TaiKhoanUI taiKhoanUI = new TaiKhoanUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Tài Khoản", null, tabbedPane.add(taiKhoanUI.contentPane), "Tài Khoản");
		} else if (o.equals(mniKhachHang)) {
			KhachHangUI khachHangUI = new KhachHangUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Khách Hàng", null, tabbedPane.add(khachHangUI.contentPane), "Khách Hàng");

		} else if (o.equals(mniBan)) {
			BanUI ban = new BanUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Bàn", null, tabbedPane.add(ban.contentPane), "Bàn");
		} else if (o.equals(mniSanh)) {
			SanhUI sanh = new SanhUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Sảnh", null, tabbedPane.add(sanh.contentPane), "Sảnh");
		} else if (o.equals(mniThongKeDoanhThu)) {
			ThongKeDoanhThuUI thongKeDoanhThuUI = new ThongKeDoanhThuUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Thống Kê Doanh Thu", null, tabbedPane.add(thongKeDoanhThuUI.contentPane),
					"Thống Kê Doanh Thu");
		} else if (o.equals(mniDoiMatKhau)) {
			DoiMatKhauUI doiMatKhau = new DoiMatKhauUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Cập nhật tài khoản", null, tabbedPane.add(doiMatKhau.contentPane), "Cập nhật tài khoản");
		} else if (o.equals(mniDangXuat)) {
			int agree = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đăng xuất!", "Thông báo",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("images\\warning.png"));
			if (agree == 0) {
				DangNhapUI dangNhapUI = new DangNhapUI();
				this.dispose();
				dangNhapUI.setVisible(true);
			}
		} else if (o.equals(mniThoat)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
		} else if (o.equals(mniDatBanTiec)) {
//			KhachHangUI khachHangUI = new KhachHangUI();
			DatBanTiecUI datBanTiecUI = new DatBanTiecUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Chọn Khách Hàng", null, tabbedPane.add(datBanTiecUI.contentPane), "Chọn Khách Hàng");
		} else if (o.equals(mniChucVu)) {
			ChucVuUI chucVuUI = new ChucVuUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Chức Vụ", null, tabbedPane.add(chucVuUI.contentPane), "Chức Vụ");
		} else if (o.equals(mniLoaiMon)) {
			LoaiMonUI loaiMonUI = new LoaiMonUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Loại Món", null, tabbedPane.add(loaiMonUI.contentPane), "Loại Món");
		} else if (o.equals(mniPhieuDat)) {
			PhieuDatMonUI phieuDatMonUI = new PhieuDatMonUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Phiếu Đặt", null, tabbedPane.add(phieuDatMonUI.contentPane), "Phiếu Đặt");
		} else if (o.equals(mniMuaVe)) {
			MuaVeUI muaVeUI = new MuaVeUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Mua Về", null, tabbedPane.add(muaVeUI.contentPane), "Mua Về");
		} else if (o.equals(mniMonAn)) {
			MonUI monUI = new MonUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Món", null, tabbedPane.add(monUI.contentPane), "Món");
		} else if (o.equals(mniThongKeDoUong)) {
			ThongKeDoUongUI thongKeDoUongUI = new ThongKeDoUongUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Thống Kê Đồ Uống", null, tabbedPane.add(thongKeDoUongUI.contentPane),
					"Thống Kê Đồ Uống");
		} else if (o.equals(mniThongKeKhachHang)) {
			ThongKeKhachHangUI thongKeKhachHangUI = new ThongKeKhachHangUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Thống Kê Khách Hàng", null, tabbedPane.add(thongKeKhachHangUI.contentPane),
					"Thống Kê Khách Hàng");
		} else if (o.equals(mniThongKeMonAn)) {
			ThongKeMonAnUI thongKeMonAnUI = new ThongKeMonAnUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Thống Kê Món Ăn", null, tabbedPane.add(thongKeMonAnUI.contentPane), "Thống Kê Món Ăn");
		} else if (o.equals(mniTimKiemHoaDon)) {
			TimKiemHoaDonUI timKiemHoaDonUI = new TimKiemHoaDonUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Tìm Kiếm Hóa Đơn", null, tabbedPane.add(timKiemHoaDonUI.contentPane),
					"Tìm Kiếm Hóa Đơn");
		} else if (o.equals(mniTimKiemKhachHang)) {
			TimKiemKhachHangUI timKiemKhachHangUI = new TimKiemKhachHangUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Tìm Kiếm Khách Hàng", null, tabbedPane.add(timKiemKhachHangUI.contentPane),
					"Tìm Kiếm Khách Hàng");
		} else if (o.equals(mniTimKiemMonAn)) {
			TimKiemMonAnUI timKiemMonAnUI = new TimKiemMonAnUI();
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.addTab("Tìm Kiếm Món Ăn", null, tabbedPane.add(timKiemMonAnUI.contentPane), "Tìm Kiếm Món Ăn");
		}
	}

	@Override
	public void menuSelected(MenuEvent e) {
	}

	@Override
	public void menuDeselected(MenuEvent e) {
	}

	@Override
	public void menuCanceled(MenuEvent e) {
	}

}
