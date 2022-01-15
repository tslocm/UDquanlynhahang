package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.iuh.quanlynhahang.daoimpls.TaiKhoanDAOImpl;
import com.iuh.quanlynhahang.entities.NhanVien;
import com.iuh.quanlynhahang.entities.TaiKhoan;

public class DangNhapUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7809958078077975829L;
	private JPanel contentPane;
	private JPasswordField txtMatKhau;
	private JTextField txtTenDangNhap;
	private JButton btnDangNhap;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JRadioButton rdbHienMatKhau;

	public static TaiKhoan taiKhoan;
	public static NhanVien nhanVien;

	private static TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DangNhap frame = new DangNhap();
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
	public DangNhapUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon("images\\login.png"));
		btnDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		txtMatKhau = new JPasswordField();
		txtMatKhau.setToolTipText("Nhập mật khẩu");
		txtMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMatKhau.setColumns(10);

		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập");
		lblTenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setToolTipText("Nhập tên đăng nhập");
		txtTenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenDangNhap.setColumns(10);

		JLabel label_2 = new JLabel("HỆ THỐNG QUẢN LÝ NHÀ HÀNG LEGUE");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 22));

		lblUsername = new JLabel("");
		lblUsername.setForeground(Color.RED);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblPassword = new JLabel("");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.RED);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbHienMatKhau = new JRadioButton("Hiện mật khẩu");
		rdbHienMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbHienMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbHienMatKhau.isSelected()) {
					txtMatKhau.setEchoChar((char) 0);
				} else if (rdbHienMatKhau.isSelected() == false) {
					txtMatKhau.setEchoChar('*');
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(122)
						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE).addGap(132))
				.addGroup(gl_panel.createSequentialGroup().addGap(100).addGroup(gl_panel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(
										lblTenDangNhap, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
										.addComponent(txtTenDangNhap, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
										.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblMatKhau, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbHienMatKhau, GroupLayout.PREFERRED_SIZE, 145,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtMatKhau, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))))
						.addGap(100))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup().addGap(262)
						.addComponent(btnDangNhap, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE).addGap(174)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(23)
				.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(24)
				.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTenDangNhap, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTenDangNhap, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatKhau, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(rdbHienMatKhau, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
				.addComponent(btnDangNhap, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE).addGap(20)));
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE).addGap(1)));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE).addGap(1)));
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
		txtTenDangNhap.requestFocus();
		
		btnDangNhap.addActionListener(this);
		
		txtTenDangNhap.setText("NV12312312");
		txtMatKhau.setText("12345678");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnDangNhap)) {
//			TrangChu trangChuUI=new TrangChu();
//			trangChuUI.setVisible(true);
//			setVisible(false);
			String msgUsername = "";
			String msgPassword = "";
			boolean checkNull = true;
			boolean checkLogin = false;

			String username = txtTenDangNhap.getText().trim();
			String password = String.valueOf(txtMatKhau.getPassword());
			if (username.isEmpty()) {
				msgUsername = "Vui lòng nhập tên đăng nhập!";
				checkNull = false;
			}
			if (password.isEmpty()) {
				msgPassword = "Vui lòng nhập mật khẩu!";
				checkNull = false;
			}
			if (checkNull == true) {
				List<TaiKhoan> taiKhoans = taiKhoanDAO.getAllTK();
				for (TaiKhoan tk : taiKhoans) {
					if (tk.getTenTaiKhoan().equals(username) && tk.getMatKhau().equals(password)) {
						checkLogin = true;
						taiKhoan = new TaiKhoan(tk.getMaTaiKhoan(), tk.getLoaiTaiKhoan(), tk.getTenTaiKhoan(),
								tk.getMatKhau());
					}
				}
			}

			if (checkLogin == true) {
				if(taiKhoan.getLoaiTaiKhoan().getTenLoaiTaiKhoan().equals("Nhân Viên")) {
					TrangChuUI trangChuUI = new TrangChuUI();
					trangChuUI.mniTaiKhoan.setEnabled(false);
					trangChuUI.mniChucVu.setEnabled(false);
					trangChuUI.mniNhanVien.setEnabled(false);
					trangChuUI.mniMonAn.setEnabled(false);
					trangChuUI.mniBan.setEnabled(false);
					trangChuUI.mniSanh.setEnabled(false);
					trangChuUI.mniLoaiMon.setEnabled(false);
					trangChuUI.setVisible(true);
					this.dispose();
				}
				else {
					TrangChuUI trangChuUI = new TrangChuUI();
					trangChuUI.setVisible(true);
					this.dispose();
				}
			} else {
				lblUsername.setText("Tên đăng nhập hoặc mật khẩu không hợp lê!");
				lblPassword.setText("");
				if (checkNull == false) {
					lblUsername.setText(msgUsername);
					lblPassword.setText(msgPassword);
				}
			}

		}

	}
}
