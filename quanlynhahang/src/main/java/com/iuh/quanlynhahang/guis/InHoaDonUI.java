package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class InHoaDonUI extends JFrame implements Printable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	public static JTable table;
	public static JLabel lblQLT;
	public static JLabel lblMSThue;
	public static JLabel lblDiaChi;
	public static JLabel lblDienThoai;
	public static JLabel lblGPKD;
	public static JLabel lblMHDon;
	public static JLabel lblHD;
	public static JLabel lblNgayLap;
	public static JLabel lblHoTenKH;
	public static JLabel lblDiaChiKH;
	public static JLabel lblSDTKH;
	public static JLabel lblGioiTinh;
	public static JLabel lblTenKH1;
	public static JLabel lblMaHD;
	public static JLabel lblNgayLap1;
	public static JLabel lblGTinh1;
	public static JLabel lblDCKH1;
	public static JLabel lblsdtkh1;
	public static JLabel lblTongTien;
	public static JLabel lblNguoiBan;
	public static JLabel lblNguoiMuaHang1;
	private static JPanel panel;
	public static DefaultTableModel tableModel;
	private JLabel lblLoiHd;
	public static JLabel lblLoaiHD;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InHoaDonUI frame = new InHoaDonUI();
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
	public InHoaDonUI() {
		setTitle("HÓA ĐƠN BÁN HÀNG NHÀ HÀNG LEGUE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setSize(1382, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(true);
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.setLayout(null);

		lblQLT = new JLabel("NHÀ HÀNG LEGUE");
		lblQLT.setBounds(219, 11, 301, 27);
		lblQLT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQLT.setForeground(new Color(255, 0, 0));
		panel.add(lblQLT);

		lblMSThue = new JLabel("M\u00E3 s\u1ED1 thu\u1EBF:");
		lblMSThue.setBounds(33, 38, 75, 14);
		lblMSThue.setForeground(new Color(0, 0, 255));
		lblMSThue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblMSThue);

		lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChi.setBounds(33, 88, 58, 14);
		lblDiaChi.setForeground(Color.BLUE);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblDiaChi);

		lblDienThoai = new JLabel("\u0110i\u1EC7n tho\u1EA1i:");
		lblDienThoai.setBounds(33, 52, 75, 14);
		lblDienThoai.setForeground(Color.BLUE);
		lblDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblDienThoai);

		lblGPKD = new JLabel("GPKD s\u1ED1:");
		lblGPKD.setBounds(33, 67, 66, 20);
		lblGPKD.setForeground(Color.BLUE);
		lblGPKD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblGPKD);

		lblMHDon = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n:");
		lblMHDon.setBounds(365, 38, 75, 14);
		lblMHDon.setForeground(Color.BLUE);
		lblMHDon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblMHDon);

		lblHD = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblHD.setBounds(190, 107, 193, 27);
		lblHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblHD.setForeground(new Color(0, 0, 255));
		lblHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblHD);

		lblNgayLap = new JLabel("Ng\u00E0y l\u1EADp:");
		lblNgayLap.setBounds(365, 49, 75, 20);
		lblNgayLap.setForeground(Color.BLUE);
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblNgayLap);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 133, 596, 84);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblHoTenKH = new JLabel("Tên Khách hàng:");
		lblHoTenKH.setForeground(new Color(0, 0, 255));
		lblHoTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHoTenKH.setBounds(10, 11, 116, 17);
		panel_1.add(lblHoTenKH);

		lblDiaChiKH = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChiKH.setForeground(Color.BLUE);
		lblDiaChiKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChiKH.setBounds(10, 61, 75, 14);
		panel_1.add(lblDiaChiKH);

		lblSDTKH = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSDTKH.setForeground(Color.BLUE);
		lblSDTKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSDTKH.setBounds(336, 12, 106, 14);
		panel_1.add(lblSDTKH);

		lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblGioiTinh.setForeground(Color.BLUE);
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGioiTinh.setBounds(10, 36, 67, 17);
		panel_1.add(lblGioiTinh);

		lblTenKH1 = new JLabel("");
		lblTenKH1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTenKH1.setBounds(111, 14, 205, 14);
		panel_1.add(lblTenKH1);

		lblsdtkh1 = new JLabel("");
		lblsdtkh1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblsdtkh1.setBounds(415, 14, 122, 14);
		panel_1.add(lblsdtkh1);

		lblDCKH1 = new JLabel("");
		lblDCKH1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDCKH1.setBounds(66, 61, 390, 14);
		panel_1.add(lblDCKH1);

		lblGTinh1 = new JLabel("");
		lblGTinh1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGTinh1.setBounds(78, 36, 106, 14);
		panel_1.add(lblGTinh1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		scrollPane_1.setBounds(10, 228, 596, 308);
		panel.add(scrollPane_1);

		String[] tb = new String[] { "STT", "Tên Món","Số Lượng", "ĐVT","Giá Tiền" };

		tableModel = new DefaultTableModel(tb, 0);
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);

		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane_1.setViewportView(table);

		JLabel lblNguoiMuaHang = new JLabel("Ng\u01B0\u1EDDi mua h\u00E0ng");
		lblNguoiMuaHang.setBounds(33, 593, 134, 14);
		lblNguoiMuaHang.setForeground(Color.BLUE);
		lblNguoiMuaHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNguoiMuaHang);

		JLabel lblkghiRH = new JLabel("(K\u00ED,ghi r\u00F5 h\u1ECD t\u00EAn)");
		lblkghiRH.setBounds(10, 605, 134, 14);
		lblkghiRH.setHorizontalAlignment(SwingConstants.CENTER);
		lblkghiRH.setForeground(Color.BLUE);
		lblkghiRH.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel.add(lblkghiRH);

		JLabel lblNguoiBanHang = new JLabel("Ng\u01B0\u1EDDi b\u00E1n h\u00E0ng");
		lblNguoiBanHang.setBounds(435, 593, 134, 14);
		lblNguoiBanHang.setForeground(Color.BLUE);
		lblNguoiBanHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNguoiBanHang);

		JLabel label_1 = new JLabel("(K\u00ED,ghi r\u00F5 h\u1ECD t\u00EAn)");
		label_1.setBounds(435, 605, 134, 14);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_3.setBounds(10, 547, 596, 35);
		panel.add(panel_3);

		JLabel lblTongThanhToan = new JLabel("T\u1ED5ng ti\u1EC1n thanh to\u00E1n:");
		lblTongThanhToan.setBounds(130, 12, 133, 23);
		panel_3.add(lblTongThanhToan);
		lblTongThanhToan.setForeground(Color.BLUE);
		lblTongThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		lblTongTien = new JLabel("");
		lblTongTien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTongTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongTien.setBounds(256, 12, 330, 23);
		panel_3.add(lblTongTien);

		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(130, 12, 116, 14);
		panel_3.add(label_4);

		JLabel lblMaSoThue = new JLabel("0107853191");
		lblMaSoThue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaSoThue.setBounds(107, 38, 106, 14);
		panel.add(lblMaSoThue);

		JLabel lblSDT1 = new JLabel("0802.090.301  - 0975.326.451");
		lblSDT1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSDT1.setBounds(107, 54, 199, 14);
		panel.add(lblSDT1);

		JLabel lblGPDK1 = new JLabel(" 0117070000067");
		lblGPDK1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGPDK1.setBounds(107, 70, 106, 14);
		panel.add(lblGPDK1);

		JLabel lblDiaChi1 = new JLabel("56 Quang Trung - Quận Gò Vấp - Tp.Hồ Chí Minh");
		lblDiaChi1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChi1.setBounds(88, 85, 295, 21);
		panel.add(lblDiaChi1);

		lblMaHD = new JLabel("");
		lblMaHD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaHD.setBounds(435, 38, 162, 14);
		panel.add(lblMaHD);

		lblNgayLap1 = new JLabel("");
		lblNgayLap1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNgayLap1.setBounds(424, 52, 126, 14);
		panel.add(lblNgayLap1);

		lblNguoiBan = new JLabel("");
		lblNguoiBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblNguoiBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNguoiBan.setBounds(410, 675, 168, 27);
		panel.add(lblNguoiBan);

		lblNguoiMuaHang1 = new JLabel("");
		lblNguoiMuaHang1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNguoiMuaHang1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNguoiMuaHang1.setBounds(18, 675, 157, 30);
		panel.add(lblNguoiMuaHang1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(427)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		lblLoiHd = new JLabel("Loại HD:");
		lblLoiHd.setForeground(Color.BLUE);
		lblLoiHd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLoiHd.setBounds(365, 71, 58, 20);
		panel.add(lblLoiHd);
		
		lblLoaiHD = new JLabel("");
		lblLoaiHD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLoaiHD.setBounds(424, 73, 126, 14);
		panel.add(lblLoaiHD);
		contentPane.setLayout(gl_contentPane);

	}

	public void printingHoaDon() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if (ok) {
			try {
				job.print();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) graphics;
		if (pageIndex > 0) {
			return NO_SUCH_PAGE;
		}
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		panel.printAll(graphics);
		return PAGE_EXISTS;
	}
}
