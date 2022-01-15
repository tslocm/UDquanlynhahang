package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.iuh.quanlynhahang.daoimpls.TaiKhoanDAOImpl;
import com.iuh.quanlynhahang.entities.TaiKhoan;

public class DoiMatKhauUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7138654934388109855L;
	public JPanel contentPane;
	private JButton btnXacNhan, btnLamMoi;
	private JPasswordField txtMKHT;
	private JPasswordField txtMKM;
	private JPasswordField txtXNMK;
	private JRadioButton radHienMatKhau;
	private JLabel lblDoiMatKhau;
	private JLabel lblMKHienTai;
	private JComponent lblMKMoi;
	private JComponent lblNhapLaiMK;
	private JLabel lblMKHT;
	private JLabel lblMKM;
	private JLabel lblXNMK;

	private static TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoiMatKhau frame = new DoiMatKhau();
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
	public DoiMatKhauUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblDoiMatKhau = new JLabel("Đổi Mật Khẩu");
		lblDoiMatKhau.setForeground(Color.RED);
		lblDoiMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 25));

		lblMKHienTai = new JLabel("Mật Khẩu Hiện Tại :");
		lblMKHienTai.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKMoi = new JLabel("Mật Khẩu Mới :");
		lblMKMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblNhapLaiMK = new JLabel("Nhập Lại Mật Khẩu :");
		lblNhapLaiMK.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnXacNhan = new JButton("Xác Nhận");
		btnXacNhan.setIcon(new ImageIcon("images\\accept.png"));

		btnXacNhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtMKHT = new JPasswordField();
		txtMKHT.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtMKM = new JPasswordField();
		txtMKM.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtXNMK = new JPasswordField();
		txtXNMK.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		radHienMatKhau = new JRadioButton("Hiện mật khẩu");
		radHienMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		radHienMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (radHienMatKhau.isSelected()) {
					txtMKHT.setEchoChar((char) 0);
					txtMKM.setEchoChar((char) 0);
					txtXNMK.setEchoChar((char) 0);
				} else if (radHienMatKhau.isSelected() == false) {
					txtMKHT.setEchoChar('*');
					txtMKM.setEchoChar('*');
					txtXNMK.setEchoChar('*');
				}
			}
		});

		lblMKHT = new JLabel("");
		lblMKHT.setForeground(Color.RED);
		lblMKHT.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKM = new JLabel("");
		lblMKM.setForeground(Color.RED);
		lblMKM.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblXNMK = new JLabel("");
		lblXNMK.setForeground(Color.RED);
		lblXNMK.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin m\u1EADt kh\u1EA9u", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(90)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addComponent(lblMKHienTai).addGap(62).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING).addComponent(radHienMatKhau)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnXacNhan, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
										.addGap(65)
										.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
								.addComponent(txtMKHT, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
								.addComponent(lblMKHT, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblMKMoi, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addGap(78)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMKM, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
										.addComponent(txtMKM, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNhapLaiMK, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
								.addGap(42)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblXNMK, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
										.addComponent(txtXNMK, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))))
				.addGap(47).addComponent(panel, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
				.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addGap(403)
						.addComponent(lblDoiMatKhau, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE).addGap(485)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(lblDoiMatKhau, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(46).addComponent(lblMKHT, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMKHienTai, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMKHT, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGap(24).addComponent(lblMKM, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMKM, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMKMoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(26).addComponent(lblXNMK, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtXNMK, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNhapLaiMK, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(radHienMatKhau).addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addGap(142)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(115, Short.MAX_VALUE)));

		JLabel label_1 = new JLabel("Chứa ít nhất 1 ký tự từ 0-9");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		JLabel label_2 = new JLabel("Chứa ít nhất một ký tự thường từ a-z");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		JLabel label_3 = new JLabel("Chứa ít nhất một ký tự hoa từ A-Z");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		JLabel label_4 = new JLabel("Chứa ít nhất một trong các ký tự đặc biệt sau: ! @ # & ( )");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		JLabel label_5 = new JLabel("Chiều dài phải từ 8 đến 20 ký tự");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup().addGap(17).addGroup(gl_panel
						.createParallelGroup(
								Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
										.addGap(50))
								.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
						.addGroup(
								gl_panel.createSequentialGroup().addGap(1)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(label_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
														383, Short.MAX_VALUE)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 325,
																		Short.MAX_VALUE)
																.addGap(58))
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 325,
																		Short.MAX_VALUE)
																.addGap(58))))))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addContainerGap(32, Short.MAX_VALUE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(134)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		btnLamMoi.addActionListener(this);
		btnXacNhan.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnLamMoi)) {
			refresh();
		} else if (obj.equals(btnXacNhan)) {
			boolean check = true;
			String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
			String matKhauHienTai = String.valueOf(txtMKHT.getPassword());
			String matKhauMoi = String.valueOf(txtMKM.getPassword());
			String xNMK = String.valueOf(txtXNMK.getPassword());
			String msgMKHT = "";
			String msgMKM = "";
			String msgXNMK = "";

			/**
			 * mat khau hien tai
			 */
			if (matKhauHienTai.equals("") || matKhauHienTai == null || matKhauHienTai.isEmpty()) {
				msgMKHT = "Vui lòng nhập mật khẩu hiện tại!";
				check = false;
			} else if (!matKhauHienTai.equals(DangNhapUI.taiKhoan.getMatKhau())) {
				msgMKHT = "Mật khẩu hiện tại không hợp lệ!";
				check = false;
			} else {
				msgMKHT = "";
			}

			/**
			 * mat khau moi
			 */
			if (matKhauMoi.isEmpty() || matKhauMoi == null || matKhauMoi.isEmpty()) {
				msgMKM = "Vui lòng nhập mật khẩu mới!";
				check = false;
			} else if (matKhauMoi.matches(regexPassword) == false) {
				msgMKM = "Mật khẩu mới tại không hợp lệ!";
				check = false;
			} else {
				msgMKM = "";
			}

			/**
			 * xac nhan mat khau
			 */
			if (xNMK.isEmpty() || xNMK == null || xNMK.isEmpty()) {
				msgXNMK = "Vui lòng nhập xác nhân mật khẩu mới!";
				check = false;
			} else if (!xNMK.equals(matKhauMoi)) {
				msgXNMK = "Xác nhận mật khẩu không hợp lệ!";
				check = false;
			} else {
				msgXNMK = "";
			}

			if (!check) {
				lblMKHT.setText(msgMKHT);
				lblMKM.setText(msgMKM);
				lblXNMK.setText(msgXNMK);
			} else {
				try {
					TaiKhoan taiKhoan = DangNhapUI.taiKhoan;
					taiKhoan.setMatKhau(matKhauMoi);
					taiKhoanDAO.updateTK(taiKhoan);
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!", "Thông báo",
							JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
					refresh();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					e2.printStackTrace();
				}

			}

		}

	}

	public void refresh() {
		txtMKHT.setText("");
		txtMKM.setText("");
		txtXNMK.setText("");
		lblMKHT.setText("");
		lblMKM.setText("");
		lblXNMK.setText("");
	}
}
