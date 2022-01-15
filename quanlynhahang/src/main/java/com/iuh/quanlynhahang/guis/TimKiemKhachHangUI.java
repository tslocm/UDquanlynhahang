package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.iuh.quanlynhahang.daoimpls.KhachHangDAOImpl;
import com.iuh.quanlynhahang.entities.KhachHang;

public class TimKiemKhachHangUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable tableKhachHang;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	public JPanel contentPane;
	private JTextField txtTenKH;
	private JButton btnTimKiem;
	private JTextField txtSDT;
	private JLabel lblTmKimKhch;
	private JLabel lblMKhchHng;
	private JTextField txtMa;

	private JRadioButton rdbMa;
	private JRadioButton rdbTen;
	private JRadioButton rdbSDT;

	private static boolean validateData = true;

	private static List<KhachHang> khachHangs = new ArrayList<KhachHang>();

	private static KhachHangDAOImpl khachHangDAO = new KhachHangDAOImpl();

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TimKiemKhachHangUI frame = new TimKiemKhachHangUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public TimKiemKhachHangUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);

		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenKH.setColumns(10);

		JLabel lblSinThoi = new JLabel("Số Điện Thoại");
		lblSinThoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon("images\\search.png"));
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSDT.setColumns(10);

		String[] header = "STT;Mã Khách Hàng;Tên Khách Hàng;Số Điện Thoại;Giới Tính;Địa Chỉ;".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(tableKhachHang = new JTable(tableModel),
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(tableKhachHang);

		JLabel lblTmKimTheo = new JLabel("Tìm Kiếm Theo");
		lblTmKimTheo.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTmKimKhch = new JLabel("TÌM KIẾM KHÁCH HÀNG");
		lblTmKimKhch.setForeground(Color.RED);
		lblTmKimKhch.setFont(new Font("Times New Roman", Font.BOLD, 25));

		rdbTen = new JRadioButton("Tên");
		rdbTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbSDT = new JRadioButton("Số điện thoại");
		rdbSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbMa = new JRadioButton("Mã");
		rdbMa.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng = new JLabel("Mã Khách Hàng");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtMa = new JTextField();
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMa.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(5)
								.addComponent(lblTmKimTheo, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addGap(35)
								.addComponent(rdbMa, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(rdbTen,
										GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(rdbSDT)
								.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(183)
												.addComponent(btnTimKiem).addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(lblSinThoi, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 110,
																GroupLayout.PREFERRED_SIZE))
												.addGap(31)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(txtTenKH, GroupLayout.DEFAULT_SIZE, 240,
																Short.MAX_VALUE)
														.addComponent(txtSDT, GroupLayout.DEFAULT_SIZE, 240,
																Short.MAX_VALUE)
														.addComponent(txtMa, GroupLayout.DEFAULT_SIZE, 240,
																Short.MAX_VALUE))
												.addGap(14)))))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE).addGap(29))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(389, Short.MAX_VALUE)
						.addComponent(lblTmKimKhch, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
						.addGap(340)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(97).addComponent(lblTmKimTheo,
								GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(22).addComponent(lblTmKimKhch))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(97)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(rdbSDT).addComponent(rdbTen).addComponent(rdbMa))
												.addGap(23)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtMa, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE))
												.addGap(22)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE))
												.addGap(22)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE))
												.addGap(35).addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)))))
				.addGap(23)));
		contentPane.setLayout(gl_contentPane);

		txtMa.setEditable(false);
		txtTenKH.setEditable(false);
		txtSDT.setEditable(false);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbMa);
		buttonGroup.add(rdbTen);
		buttonGroup.add(rdbSDT);

		TableColumnModel columnModel = tableKhachHang.getColumnModel();
		tableKhachHang.setDefaultEditor(Object.class, null);
		tableKhachHang.setRowHeight(30);
		columnModel.getColumn(0).setPreferredWidth(50);// stt
		columnModel.getColumn(1).setPreferredWidth(100);// ma
		columnModel.getColumn(2).setPreferredWidth(200);// tec
		columnModel.getColumn(3).setPreferredWidth(100);// sdt
		columnModel.getColumn(4).setPreferredWidth(70);// gt
		columnModel.getColumn(5).setPreferredWidth(250);// dc
		tableKhachHang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tableKhachHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableKhachHang.getColumnCount(); c++) {
			Class<?> col_class = tableKhachHang.getColumnClass(c);
			tableKhachHang.setDefaultEditor(col_class, null); // remove editor
		}

		btnTimKiem.addActionListener(this);
		rdbMa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(true);
				txtTenKH.setEditable(false);
				txtSDT.setEditable(false);

			}
		});
		rdbSDT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(false);
				txtTenKH.setEditable(false);
				txtSDT.setEditable(true);
			}
		});
		rdbTen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(false);
				txtTenKH.setEditable(true);
				txtSDT.setEditable(false);
			}
		});
	}

	public void timKiemKH() {

		String ma = txtMa.getText().trim();
		String ten = txtTenKH.getText().trim();
		String sdt = txtSDT.getText().trim();

		if (rdbMa.isSelected()) {
			if (ma.equalsIgnoreCase("") || ma == null || ma.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				validateData = false;
			}
//			else if (ma.matches("^(KH)+[0-9]{8}$") == false) {
//				JOptionPane.showMessageDialog(this, "Mã khách hàng không hợp lệ!", "Thông báo",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//			}
			else {
				khachHangs = khachHangDAO.getKHsByID(ma);
				validateData = true;
			}
		} else if (rdbTen.isSelected()) {
			if (ten.equalsIgnoreCase("") || ten == null || ten.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khách hàng!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				validateData = false;
			} else {
				khachHangs = khachHangDAO.getKHsByTen(ten);
				validateData = true;
			}
		} else if (rdbSDT.isSelected()) {
			if (sdt.equalsIgnoreCase("") || sdt == null || sdt.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại khách hàng!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				validateData = false;
			}
//			else if (sdt.matches("^0[0-9]{9}$") == false) {
//				JOptionPane.showMessageDialog(this, "Số điện thoại khách hàng không hợp lệ!", "Thông báo",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
//			}
			else {
				khachHangs = khachHangDAO.getKHsBySDT(sdt);
				validateData = true;
			}
		}

	}

	public void updateTable() {
		tableModel = (DefaultTableModel) tableKhachHang.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			int i = 0;
			if (khachHangs.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu!", "Thông báo", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("images\\warning.png"));
				tableModel.fireTableDataChanged();
			} else {
				for (KhachHang kh : khachHangs) {
					i++;
					tableModel.addRow(new Object[] { i, kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoDienThoai(),
							kh.getGioiTinh(), kh.getDiaChi() });
				}
				tableKhachHang.setModel(tableModel);
				tableKhachHang.getSelectionModel().clearSelection();
				tableModel.fireTableDataChanged();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnTimKiem)) {
			if (!rdbSDT.isSelected() && !rdbMa.isSelected() && !rdbTen.isSelected()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			} else {
				timKiemKH();
				if (validateData == true) {
					updateTable();
				}
			}
		}

	}
}
