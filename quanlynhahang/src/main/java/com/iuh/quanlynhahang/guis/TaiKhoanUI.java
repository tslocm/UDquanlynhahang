package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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

import com.iuh.quanlynhahang.daoimpls.NhanVienDAOImpl;
import com.iuh.quanlynhahang.daoimpls.TaiKhoanDAOImpl;
import com.iuh.quanlynhahang.entities.NhanVien;
import com.iuh.quanlynhahang.entities.TaiKhoan;

public class TaiKhoanUI extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2193273638206490749L;
	public JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable tableTaiKhoan;
	private JPanel panel;
	private JButton btnTim;
	private JLabel lblNhpTnNgi;
	private JTextField txtTimTK;
	private JPanel panel_1;
	private JLabel lblThngTinTi;
	private JLabel lblMTiKhon;
	private JLabel lblTnTiKhon;
	private JLabel lblMKhchHng_2;
	private JTextField txtTenTK;
	private JPasswordField txtMK;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JTextField txtMaTK;
	private JLabel lblTrngThi;
	private JTextField txtTrangThai;
	private JRadioButton rdbHienMatKhau;
	private JButton btnLamMoiDuLieu;
	private static final String MANV_PATTERN = "^NV[0-9]{8}$";

	private static TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();
	private static NhanVienDAOImpl nhanVienDAO = new NhanVienDAOImpl();
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TaiKhoanUI frame = new TaiKhoanUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public TaiKhoanUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTiKhon = new JLabel("Tài Khoản");
		lblTiKhon.setForeground(Color.RED);
		lblTiKhon.setFont(new Font("Times New Roman", Font.BOLD, 25));

		String[] header = "STT;Mã NV;Mã Tài Khoản;Tên Tài Khoản;Tên NV;Chức Vụ".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(tableTaiKhoan = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		TableColumnModel columnModel = tableTaiKhoan.getColumnModel();
		tableTaiKhoan.setDefaultEditor(Object.class, null);
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(250);
		columnModel.getColumn(5).setPreferredWidth(200);
		tableTaiKhoan.setRowHeight(30);
		tableTaiKhoan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(new LineBorder(new Color(192, 192, 192)), "T\u00ECm Ki\u1EBFm T\u00E0i Kho\u1EA3n",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon("images\\search.png"));
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblNhpTnNgi = new JLabel("Nhập Tên Tài Khoản");
		lblNhpTnNgi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTimTK = new JTextField();
		txtTimTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTimTK.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));

		lblThngTinTi = new JLabel("Thông Tin Tài Khoản");
		lblThngTinTi.setForeground(Color.BLACK);
		lblThngTinTi.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblMTiKhon = new JLabel("Mã Tài Khoản");
		lblMTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTnTiKhon = new JLabel("Tên Tài Khoản");
		lblTnTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng_2 = new JLabel("Mật Khẩu");
		lblMKhchHng_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTenTK = new JTextField();
		txtTenTK.setEditable(false);
		txtTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenTK.setColumns(10);

		txtMK = new JPasswordField();
		txtMK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMK.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(495).addComponent(lblTiKhon,
								GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(5)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 603,
												Short.MAX_VALUE)
										.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 603,
												Short.MAX_VALUE))
								.addGap(6)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(lblTiKhon).addGap(32)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE).addGap(18)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));

		btnLamMoiDuLieu = new JButton("Làm Mới Dữ Liệu");
		btnLamMoiDuLieu.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoiDuLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(5)
						.addComponent(lblNhpTnNgi, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTimTK, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnTim, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnLamMoiDuLieu, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(17)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(lblNhpTnNgi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTimTK, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLamMoiDuLieu, GroupLayout.PREFERRED_SIZE, 34,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))));
		panel.setLayout(gl_panel);

		txtMaTK = new JTextField();
		txtMaTK.setEditable(false);
		txtMaTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaTK.setColumns(10);

		lblTrngThi = new JLabel("Trạng Thái");
		lblTrngThi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTrangThai = new JTextField();
		txtTrangThai.setEditable(false);
		txtTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTrangThai.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setEnabled(false);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setIcon(new ImageIcon("images\\add.png"));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setEnabled(false);
		btnCapNhat.setIcon(new ImageIcon("images\\edit.png"));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.setIcon(new ImageIcon("images\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnLamMoi = new JButton("Reset Mật Khẩu");
		btnLamMoi.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbHienMatKhau = new JRadioButton("Hiện mật khẩu");
		rdbHienMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbHienMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbHienMatKhau.isSelected()) {
					txtMK.setEchoChar((char) 0);
				} else if (rdbHienMatKhau.isSelected() == false) {
					txtMK.setEchoChar('*');
				}
			}
		});

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(119).addComponent(lblThngTinTi,
						GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblTnTiKhon, GroupLayout.PREFERRED_SIZE, 104,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)))
								.addGap(20))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblMKhchHng_2, GroupLayout.PREFERRED_SIZE, 100,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
								.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtTenTK, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284,
												Short.MAX_VALUE)
										.addComponent(txtMaTK, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284,
												Short.MAX_VALUE)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtMK, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
								.addContainerGap())
								.addGroup(gl_panel_1.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 114,
																Short.MAX_VALUE)
														.addGap(28).addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE,
																107, Short.MAX_VALUE))
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 114,
																Short.MAX_VALUE)
														.addGap(24).addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE,
																111, Short.MAX_VALUE)))
										.addGap(45))))
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(lblTrngThi, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbHienMatKhau, GroupLayout.PREFERRED_SIZE, 135,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTrangThai, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(9).addComponent(lblThngTinTi).addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaTK, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(32)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenTK, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMKhchHng_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMK, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTrngThi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTrangThai, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(17)
						.addComponent(rdbHienMatKhau, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGap(6)));
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);

		btnCapNhat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLamMoiDuLieu.addActionListener(this);

		tableTaiKhoan.addMouseListener(this);
		tableTaiKhoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableTaiKhoan.getColumnCount(); c++) {
			Class<?> col_class = tableTaiKhoan.getColumnClass(c);
			tableTaiKhoan.setDefaultEditor(col_class, null); // remove editor
		}

		updateTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// reset password
		if (obj.equals(btnLamMoi)) {
			int row = tableTaiKhoan.getSelectedRow();
			if (row != -1) {
				try {
					TaiKhoan taiKhoan = DangNhapUI.taiKhoan;
					taiKhoan.setMatKhau("12345678");
					taiKhoanDAO.updateTK(taiKhoan);
					updateTable();
					refresh();
					JOptionPane.showMessageDialog(this, "Reset mật khẩu thành công, Mật khẩu là: \"12345678\"", "Thông báo",
							JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Lỗi, hãy thử lại sau!", "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
					updateTable();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản để thực hiện!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			}
		} else if (obj.equals(btnCapNhat)) {

		} else if (obj.equals(btnTim)) {
			String maNV = txtTimTK.getText().trim();
			if (maNV.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên cần tìm!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			} else if (maNV.matches(MANV_PATTERN) == false) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			} else {
				try {
					NhanVien nv = nhanVienDAO.getNVByID(maNV);
					if (nv != null) {
						tableModel = (DefaultTableModel) tableTaiKhoan.getModel();
						tableModel.getDataVector().removeAllElements();
						tableModel.addRow(new Object[] { 1, nv.getMaNhanVien(), nv.getTaiKhoan().getMaTaiKhoan(),
								nv.getTaiKhoan().getTenTaiKhoan(), nv.getHoTenNhanVien(),
								nv.getTaiKhoan().getLoaiTaiKhoan().getTenLoaiTaiKhoan() });
					} else {
						JOptionPane.showMessageDialog(this, "Không tồn tại tài khoản!", "Thông báo",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		} else if (obj.equals(btnLamMoiDuLieu)) {
			updateTable();
		}

	}

	@SuppressWarnings("static-access")
	public static String randomMaTKNotExisted() {
		String maTK;
		List<String> idTKs = new ArrayList<String>();
		List<TaiKhoan> taiKhoans = taiKhoanDAO.getAllTK();
		for (TaiKhoan tk : taiKhoans) {
			idTKs.add(tk.getMaTaiKhoan());
		}

		do {
			RandomStringUtils randomStringUtils = new RandomStringUtils();
			maTK = randomStringUtils.randomNumeric(8);

		} while (idTKs.contains(maTK));
		return "TK" + maTK;
	}

	public void updateTable() {
		tableModel = (DefaultTableModel) tableTaiKhoan.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			List<NhanVien> nhanViens = nhanVienDAO.getAllNV();
			int i = 0;
			for (NhanVien nv : nhanViens) {
				i++;
				tableModel.addRow(new Object[] { i, nv.getMaNhanVien(), nv.getTaiKhoan().getMaTaiKhoan(),
						nv.getTaiKhoan().getTenTaiKhoan(), nv.getHoTenNhanVien(),
						nv.getTaiKhoan().getLoaiTaiKhoan().getTenLoaiTaiKhoan() });
			}
			tableTaiKhoan.setModel(tableModel);
			tableTaiKhoan.getSelectionModel().clearSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableTaiKhoan.getSelectedRow();
		String maNV = tableModel.getValueAt(row, 1).toString();
		try {
			NhanVien nv = nhanVienDAO.getNVByID(maNV);
			txtMaTK.setText(nv.getTaiKhoan().getMaTaiKhoan());
			txtTenTK.setText(nv.getTaiKhoan().getTenTaiKhoan());
			txtMK.setText(nv.getTaiKhoan().getMatKhau());
			txtTrangThai.setText(nv.getTinhTrang());
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

	private void refresh() {
		txtMaTK.setText("");
		txtMK.setText("");
		txtTenTK.setText("");
		txtTrangThai.setText("");
	}
}
