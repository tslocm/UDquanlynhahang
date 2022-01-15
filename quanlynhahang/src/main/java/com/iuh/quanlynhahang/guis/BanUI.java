package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.iuh.quanlynhahang.daoimpls.BanDAOImpl;
import com.iuh.quanlynhahang.daoimpls.SanhDAOImpl;
import com.iuh.quanlynhahang.entities.Ban;
import com.iuh.quanlynhahang.entities.Sanh;

public class BanUI extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4306434632363466260L;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BanUI frame = new BanUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable tableBan;
	private JPanel panel;
	private JButton btnTimKiem;
	private JLabel lblNhpTnNgi;
	private JPanel panel_1;
	private JLabel lblThngTinTi;
	private JLabel lblMTiKhon;
	private JLabel lblTnTiKhon;
	private JLabel lblMKhchHng;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JTextField txtTimMaBan;
	private JTextField txtMaBan;
	private JButton btnLamMoiDuLieu;
	@SuppressWarnings("rawtypes")
	protected JComboBox cbxThuocSanh;
	private JLabel lblTrngThit;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxTrangThaiHoatDong;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxTrangThaiDatBan;

	String regexMaBan = "^[0-9]{1,}$";

	private static SanhDAOImpl sanhDAO = new SanhDAOImpl();
	private static BanDAOImpl banDAO = new BanDAOImpl();
//	private static SanhUI sanhUI = new SanhUI();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BanUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTiKhon = new JLabel("Bàn");
		lblTiKhon.setForeground(Color.RED);
		lblTiKhon.setFont(new Font("Times New Roman", Font.BOLD, 25));

		String[] header = "STT;Mã Bàn;Thuộc Sảnh;Trạng Thái Hoạt Động;Trạng Thái Đặt Bàn".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(tableBan = new JTable(tableModel), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(new LineBorder(new Color(192, 192, 192)), "T\u00ECm Ki\u1EBFm T\u00E0i Kho\u1EA3n",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		btnTimKiem = new JButton("Tìm");
		btnTimKiem.setIcon(new ImageIcon("images\\search.png"));
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblNhpTnNgi = new JLabel("Nhập Mã Bàn");
		lblNhpTnNgi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));

		lblThngTinTi = new JLabel("Thông Tin Bàn");
		lblThngTinTi.setForeground(Color.BLACK);
		lblThngTinTi.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblMTiKhon = new JLabel("Mã Bàn");
		lblMTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTnTiKhon = new JLabel("Thuộc Sảnh ");
		lblTnTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng = new JLabel("Trạng Thái Hoạt Động");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(scrollPane)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(466).addComponent(lblTiKhon,
								GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(lblTiKhon).addGap(34)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
				.addGap(4)));

		txtTimMaBan = new JTextField();
		txtTimMaBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTimMaBan.setColumns(10);

		btnLamMoiDuLieu = new JButton("Làm Mới Dữ Liệu");
		btnLamMoiDuLieu.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoiDuLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(lblNhpTnNgi)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtTimMaBan, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnLamMoiDuLieu, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNhpTnNgi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTimMaBan, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTimKiem).addComponent(btnLamMoiDuLieu, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE))
						.addGap(19)));
		panel.setLayout(gl_panel);

		txtMaBan = new JTextField();
		txtMaBan.setEditable(false);
		txtMaBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaBan.setColumns(10);

		cbxThuocSanh = new JComboBox();
		cbxThuocSanh.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("images\\add.png"));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("images\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setIcon(new ImageIcon("images\\edit.png"));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTrngThit = new JLabel("Trạng Thái Đặt Bàn");
		lblTrngThit.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cbxTrangThaiHoatDong = new JComboBox();
		cbxTrangThaiHoatDong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbxTrangThaiHoatDong.addItem("Đang Sử Dụng");
		cbxTrangThaiHoatDong.addItem("Ngừng Sử Dụng");

		cbxTrangThaiDatBan = new JComboBox();
		cbxTrangThaiDatBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbxTrangThaiDatBan.addItem("Trống");
		cbxTrangThaiDatBan.addItem("Đã Đặt");

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
								.addComponent(lblTrngThit, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cbxTrangThaiDatBan, 0, 247, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(9).addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblMKhchHng).addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addGroup(
														gl_panel_1.createSequentialGroup()
																.addComponent(cbxTrangThaiHoatDong, 0, 247,
																		Short.MAX_VALUE)
																.addGap(1))
												.addComponent(cbxThuocSanh, 0, 248, Short.MAX_VALUE)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(txtMaBan, GroupLayout.DEFAULT_SIZE, 248,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_panel_1.createSequentialGroup()
														.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
																.addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE, 120,
																		Short.MAX_VALUE)
																.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 120,
																		Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
																.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE, 122,
																		Short.MAX_VALUE)
																.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 122,
																		Short.MAX_VALUE)))
												.addComponent(lblThngTinTi, Alignment.LEADING,
														GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblTnTiKhon, GroupLayout.PREFERRED_SIZE, 96,
										GroupLayout.PREFERRED_SIZE))))
						.addGap(46)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblThngTinTi).addGap(31)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaBan, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxThuocSanh, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGap(29)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxTrangThaiHoatDong, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addGroup(
								gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTrngThit, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbxTrangThaiDatBan, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		tableBan.setRowHeight(30);
		
		cbxThuocSanh.addActionListener(this);
		cbxTrangThaiDatBan.addActionListener(this);
		cbxTrangThaiHoatDong.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnThem.addActionListener(this);
		btnLamMoiDuLieu.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);

		tableBan.addMouseListener(this);
		tableBan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableBan.getColumnCount(); c++) {
			Class<?> col_class = tableBan.getColumnClass(c);
			tableBan.setDefaultEditor(col_class, null); // remove editor
		}

		List<Sanh> sanhs = sanhDAO.getAllSanh();
		for (Sanh sanh : sanhs) {
			if (sanh.getTrangThai().equalsIgnoreCase("Đang Hoạt Động")) {
				cbxThuocSanh.addItem(sanh.getTenSanh());
			}
		}

		updateTable();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableBan.getSelectedRow();
		System.out.println("=========="+row);
		String maBan = tableModel.getValueAt(row, 1).toString();
		try {
			Ban ban = banDAO.getBanById(Integer.parseInt(maBan));
			txtMaBan.setText(ban.getMaBan() + "");
			cbxThuocSanh.setSelectedItem(ban.getSanh().getTenSanh());
			cbxTrangThaiDatBan.setSelectedItem(ban.gettrangThaiDatBan());
			cbxTrangThaiHoatDong.setSelectedItem(ban.getTrangThaiHoatDong());
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

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			String tTHD = cbxTrangThaiHoatDong.getSelectedItem().toString();
			String tTDB = cbxTrangThaiDatBan.getSelectedItem().toString();
			String thuocSanh = cbxThuocSanh.getSelectedItem().toString();
			Sanh sanh = sanhDAO.getSanhByTen(thuocSanh);
			if (tTDB.equals("Đã Đặt")) {
				JOptionPane.showMessageDialog(this, "Trạng thái đặt bàn phải \"Trống\". Vui lòng chọn lại!",
						"Thông báo", JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			} else {
				try {
					Ban ban = new Ban(tTHD, tTDB, sanh);
					boolean check = banDAO.createBan(ban);
					if (check) {
						JOptionPane.showMessageDialog(this, "Thêm bàn thành công!", "Thông báo",
								JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
						updateTable();
						DatBanTiec_ChonBan datBanTiec_ChonBan = new DatBanTiec_ChonBan();
						datBanTiec_ChonBan.updateBan();
					} else {
						JOptionPane.showMessageDialog(this, "Thêm bàn thất bại!", "Thông báo",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Lỗi, hãy thử lại sau!", "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
				}
			}

		} else if (obj.equals(btnLamMoi)) {
			cbxThuocSanh.removeAllItems();
			List<Sanh> sanhs = sanhDAO.getAllSanh();
			for (Sanh sanh : sanhs) {
				if (sanh.getTrangThai().equalsIgnoreCase("Đang Hoạt Động")) {
					cbxThuocSanh.addItem(sanh.getTenSanh());
				}
			}
		} else if (obj.equals(btnXoa)) {
			int row = tableBan.getSelectedRow();
			if (row != -1) {
				String maBan = txtMaBan.getText();
				try {
					Ban ban = banDAO.getBanById(Integer.parseInt(maBan));
					if (ban.gettrangThaiDatBan().equalsIgnoreCase("Trống")) {
						boolean check = banDAO.deleteBan(ban);
						if (check) {
							JOptionPane.showMessageDialog(this, "Xóa bàn thành công!", "Thông báo",
									JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
							updateTable();
							DatBanTiec_ChonBan datBanTiec_ChonBan = new DatBanTiec_ChonBan();
							datBanTiec_ChonBan.updateBan();
						} else {
							JOptionPane.showMessageDialog(this, "Xóa bàn thất bại!", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
						}
					} else {
						JOptionPane.showMessageDialog(this, "Khách đang sử dụng bàn này. Không thể xóa!", "Thông báo",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					}

				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Lỗi. Vui lòng thử lại!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần xóa!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			}

		} else if (obj.equals(btnCapNhat)) {
			int row = tableBan.getSelectedRow();
			if (row != -1) {
				String maBan = txtMaBan.getText();
				String tTHD = cbxTrangThaiHoatDong.getSelectedItem().toString();
				String tTDB = cbxTrangThaiDatBan.getSelectedItem().toString();
				String thuocSanh = cbxThuocSanh.getSelectedItem().toString();
				Sanh sanh = sanhDAO.getSanhByTen(thuocSanh);

				try {
					Ban ban = banDAO.getBanById(Integer.parseInt(maBan));
					if (ban.gettrangThaiDatBan().equalsIgnoreCase("Trống")) {
						ban.setSanh(sanh);
						ban.settrangThaiDatBan(tTDB);
						ban.setTrangThaiHoatDong(tTHD);
						boolean check = banDAO.updateBan(ban);
						if (check) {
							JOptionPane.showMessageDialog(this, "Cập nhật bàn thành công!", "Thông báo",
									JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
							updateTable();
							DatBanTiec_ChonBan datBanTiec_ChonBan = new DatBanTiec_ChonBan();
							datBanTiec_ChonBan.updateBan();
						} else {
							JOptionPane.showMessageDialog(this, "Cập nhật bàn thất bại!", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
						}
					} else {
						JOptionPane.showMessageDialog(this, "Khách đang sử dụng bàn này. Không thể cập nhật!",
								"Thông báo", JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					}

				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Lỗi, hãy thử lại sau!", "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần cập nhật!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			}
		} else if (obj.equals(btnTimKiem)) {
			String maBan = txtTimMaBan.getText();
			if (maBan.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã bàn cần tìm!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				txtTimMaBan.requestFocus();
			} else if (maBan.matches(regexMaBan) == false) {
				JOptionPane.showMessageDialog(this, "Mã bàn không hợp lệ!", "Thông báo", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("images\\warning.png"));
				txtTimMaBan.selectAll();
				txtTimMaBan.requestFocus();
			} else {
				try {
					Ban b = banDAO.getBanById(Integer.parseInt(maBan));
					tableModel.getDataVector().removeAllElements();
					tableModel.addRow(new Object[] { 1, b.getMaBan(), b.getSanh().getTenSanh(),
							b.getTrangThaiHoatDong(), b.gettrangThaiDatBan() });
					txtTimMaBan.selectAll();
					txtTimMaBan.requestFocus();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Không tồn tại bàn!", "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
					txtTimMaBan.selectAll();
					txtTimMaBan.requestFocus();
				}
			}

		} else if (obj.equals(btnLamMoiDuLieu)) {
			updateTable();
			DatBanTiec_ChonBan datBanTiec_ChonBan = new DatBanTiec_ChonBan();
			datBanTiec_ChonBan.updateBan();
		}

	}

	public void updateTable() {
		tableModel = (DefaultTableModel) tableBan.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			List<Ban> bans = banDAO.getAllBan();
			int i = 0;
			for (Ban b : bans) {
				i++;
				tableModel.addRow(new Object[] { i, b.getMaBan(), b.getSanh().getTenSanh(), b.getTrangThaiHoatDong(),
						b.gettrangThaiDatBan() });
			}
			tableBan.setModel(tableModel);
			tableBan.getSelectionModel().clearSelection();
			tableModel.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
