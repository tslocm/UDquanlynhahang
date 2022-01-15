package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.RandomStringUtils;

import com.iuh.quanlynhahang.daoimpls.SanhDAOImpl;
import com.iuh.quanlynhahang.entities.Sanh;

public class SanhUI extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2944673923021776783L;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SanhUI frame = new SanhUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable tableSanh;
	private JPanel panel;
	private JButton btnTimSanh;
	private JLabel lblNhpTnNgi;
	private JPanel panel_1;
	private JLabel lblThngTinTi;
	private JLabel lblMTiKhon;
	private JLabel lblMKhchHng;
	private JTextField txtTenSanh;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JTextField txtTimSanh;
	private JTextField txtMaSanh;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxTrangThai;
	private JButton btnLamMoiDuLieu;

	private static SanhDAOImpl sanhDAO = new SanhDAOImpl();
	private static BanUI banUI = new BanUI();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SanhUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTiKhon = new JLabel("Sảnh");
		lblTiKhon.setForeground(Color.RED);
		lblTiKhon.setFont(new Font("Times New Roman", Font.BOLD, 25));

		String[] header = "STT;Mã Sảnh;Tên Sảnh;Trạng Thái".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(tableSanh = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableSanh.setRowHeight(30);
		tableSanh.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "T\u00ECm Ki\u1EBFm S\u1EA3nh",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		btnTimSanh = new JButton("Tìm Kiếm");
		btnTimSanh.setIcon(new ImageIcon("images\\search.png"));
		btnTimSanh.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblNhpTnNgi = new JLabel("Nhập Tên Sảnh");
		lblNhpTnNgi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));

		lblThngTinTi = new JLabel("Thông Tin Sảnh");
		lblThngTinTi.setForeground(Color.BLACK);
		lblThngTinTi.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblMTiKhon = new JLabel("Mã Sảnh");
		lblMTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng = new JLabel("Tên Sảnh");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTenSanh = new JTextField();
		txtTenSanh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenSanh.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(539).addComponent(lblTiKhon,
								GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(
												scrollPane, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(lblTiKhon).addGap(37)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE).addGap(18)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(8))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
								.addContainerGap()))));

		txtTimSanh = new JTextField();
		txtTimSanh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTimSanh.setColumns(10);

		btnLamMoiDuLieu = new JButton("Làm Mới Dữ Liệu");
		btnLamMoiDuLieu.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoiDuLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblNhpTnNgi, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTimSanh, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnTimSanh, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnLamMoiDuLieu, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE).addGap(1)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap(21, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNhpTnNgi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLamMoiDuLieu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimSanh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimSanh))
				.addContainerGap()));
		panel.setLayout(gl_panel);

		txtMaSanh = new JTextField();
		txtMaSanh.setEditable(false);
		txtMaSanh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaSanh.setColumns(10);

		JLabel lblTrngThi = new JLabel("Trạng Thái");
		lblTrngThi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("images\\add.png"));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setIcon(new ImageIcon("images\\edit.png"));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cbxTrangThai = new JComboBox();
		cbxTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbxTrangThai.addItem("Đang Hoạt Động");
		cbxTrangThai.addItem("Ngừng Hoạt Động");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(152).addComponent(lblThngTinTi,
								GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(25).addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblTrngThi, GroupLayout.PREFERRED_SIZE, 74,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(9)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblMKhchHng, Alignment.LEADING,
														GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMTiKhon, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
														83, GroupLayout.PREFERRED_SIZE))))
								.addGap(29)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(cbxTrangThai, 0, 263, Short.MAX_VALUE)
										.addComponent(txtTenSanh, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
										.addGroup(gl_panel_1.createSequentialGroup().addGap(1).addComponent(txtMaSanh,
												GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE, 115,
																		Short.MAX_VALUE)
																.addGap(162))
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 96,
																		Short.MAX_VALUE)
																.addGap(31)
																.addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE, 112,
																		Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED)))))))
						.addGap(50)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(10).addComponent(lblThngTinTi).addGap(32)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGap(27)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTrngThi, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbxTrangThai, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(txtMaSanh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(txtTenSanh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
				.addGap(64).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnThem)
						.addComponent(btnCapNhat))
				.addGap(35).addComponent(btnLamMoi).addGap(71)));
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);

		btnCapNhat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnTimSanh.addActionListener(this);
		btnLamMoiDuLieu.addActionListener(this);
		tableSanh.addMouseListener(this);
		tableSanh.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableSanh.getColumnCount(); c++) {
			Class<?> col_class = tableSanh.getColumnClass(c);
			tableSanh.setDefaultEditor(col_class, null); // remove editor
		}

		txtMaSanh.setText(randomMaSanhNotExisted());
		updateTable();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableSanh.getSelectedRow();
		String maSanh = tableModel.getValueAt(row, 1).toString();
		try {
			Sanh s = sanhDAO.getSanhById(maSanh);
			txtMaSanh.setText(maSanh);
			txtTenSanh.setText(s.getTenSanh());

			cbxTrangThai.setSelectedItem(s.getTrangThai());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			String tenSanh = txtTenSanh.getText().trim();
			String trangThai = cbxTrangThai.getSelectedItem().toString();
			Sanh sanh = new Sanh(txtMaSanh.getText(), tenSanh, trangThai);
			List<String> tenSanhs = sanhDAO.getAllTenSanh();
			if (tenSanhs.contains(tenSanh)) {
				JOptionPane.showMessageDialog(this, "Tên sảnh đã tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("images\\warning.png"));
				txtMaSanh.setText(randomMaSanhNotExisted());
			} else {
				boolean check = sanhDAO.createSanh(sanh);
				if (check) {
					JOptionPane.showMessageDialog(this, "Thêm sảnh thành công!", "Thông báo", JOptionPane.CLOSED_OPTION,
							new ImageIcon("images\\yes.png"));
					updateTable();
					txtMaSanh.setText(randomMaSanhNotExisted());
					txtTenSanh.setText("");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm sảnh thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
				}
			}

		} else if (obj.equals(btnLamMoiDuLieu)) {
			updateTable();
			refresh();
		} else if (obj.equals(btnTimSanh)) {
			String tenSearch = txtTimSanh.getText().trim();
			if (tenSearch.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				txtTimSanh.requestFocus();
			}
//			else if (sDT.matches(regexSDT) == false) {
//				JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!", "Thông báo",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//				txtTimSanh.selectAll();
//				txtTimSanh.requestFocus();
//			}
			else {

				tableModel = (DefaultTableModel) tableSanh.getModel();
				tableModel.getDataVector().removeAllElements();
				try {
					Sanh s = sanhDAO.getSanhByTen(tenSearch);
					tableModel.addRow(new Object[] { 1, s.getMaSanh(), s.getTenSanh(), s.getTrangThai() });
					tableSanh.setModel(tableModel);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Không tồn tại sảnh!", "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
					txtTimSanh.selectAll();
					txtTimSanh.requestFocus();
				}
			}

		} else if (obj.equals(btnLamMoi)) {
			updateTable();
			refresh();
		} else if (obj.equals(btnCapNhat)) {
			int row = tableSanh.getSelectedRow();
			if (row >= 0) {
				String tenSanh = txtTenSanh.getText().trim();
				if (tenSanh.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sảnh để cập nhật!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				} else {
					String trangThai = cbxTrangThai.getSelectedItem().toString();
					Sanh sanh = new Sanh(txtMaSanh.getText(), tenSanh, trangThai);
					try {
						boolean check = sanhDAO.updateSanh(sanh);
						if (check) {
							JOptionPane.showMessageDialog(this, "Cập nhật sảnh thành công!", "Thông báo",
									JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
							updateTable();
							refresh();
							txtMaSanh.setText(randomMaSanhNotExisted());
						} else {
							JOptionPane.showMessageDialog(this, "Cập nhật sảnh thất bại!", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
						}
					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(this, "Cập nhật sảnh thất bại!", "Thông báo",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					}
				}

			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sảnh để cập nhật!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			}

		}

	}

	@SuppressWarnings("static-access")
	public String randomMaSanhNotExisted() {
		String maSanh;
		List<String> idSanhs = new ArrayList<String>();
		List<Sanh> sanhs = sanhDAO.getAllSanh();
		for (Sanh s : sanhs) {
			idSanhs.add(s.getMaSanh());
		}

		do {
			RandomStringUtils randomStringUtils = new RandomStringUtils();
			maSanh = randomStringUtils.randomNumeric(8);

		} while (idSanhs.contains(maSanh));
		return "S" + maSanh;
	}

	public void updateTable() {
		tableModel = (DefaultTableModel) tableSanh.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			List<Sanh> sanhs = sanhDAO.getAllSanh();
			int i = 0;
			for (Sanh s : sanhs) {
				i++;
				tableModel.addRow(new Object[] { i, s.getMaSanh(), s.getTenSanh(), s.getTrangThai() });
			}
			tableSanh.setModel(tableModel);
			tableSanh.getSelectionModel().clearSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void refresh() {
		txtTenSanh.setText("");
		txtMaSanh.setText(randomMaSanhNotExisted());
	}

	@SuppressWarnings("unchecked")
	public void updateTenSanhForBanUI() {
		List<Sanh> sanhs = sanhDAO.getAllSanh();
		for (Sanh sanh : sanhs) {
			if (sanh.getTrangThai().equalsIgnoreCase("Đang Hoạt Động")) {
				banUI.cbxThuocSanh.addItem(sanh.getTenSanh());
			}
		}
	}
}
