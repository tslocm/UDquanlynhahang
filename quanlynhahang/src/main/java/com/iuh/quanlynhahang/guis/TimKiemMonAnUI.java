package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.iuh.quanlynhahang.daoimpls.LoaiMonDAOImpl;
import com.iuh.quanlynhahang.daoimpls.MonDAOImpl;
import com.iuh.quanlynhahang.entities.LoaiMon;
import com.iuh.quanlynhahang.entities.Mon;

public class TimKiemMonAnUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable tableMon;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	public JPanel contentPane;
	private JTextField txtTen;
	private JButton btnTimKiem;
	private JLabel lblTmKimKhch;
	private JLabel lblMKhchHng;
	private JTextField txtMa;
	private JRadioButton rdbMa;
	private JRadioButton rdbTen;
	private JRadioButton rdbLoai;

	private JRadioButton rdbGiaTien;
	@SuppressWarnings("rawtypes")
	private JComboBox cboLoai;
	private JLabel lblGiTin;
	private JTextField txtGiaFrom;
	private JLabel lblT;
	private JLabel lbln;
	private JTextField txtGiaTo;
	private static final String PRICE_PATTERN = "^[0-9]*$";
	private static NumberFormat df = new DecimalFormat("#,###.00 VNĐ");
	private static MonDAOImpl monDAO = new MonDAOImpl();
	private static LoaiMonDAOImpl loaiMonDAO = new LoaiMonDAOImpl();
	private static List<Mon> mons = new ArrayList<Mon>();
	private static boolean validateData = true;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TimKiemMonAnUI frame = new TimKiemMonAnUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TimKiemMonAnUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);

		JLabel lblTnKhchHng = new JLabel("Tên Món Ăn");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTen.setColumns(10);

		JLabel lblSinThoi = new JLabel("Loại Món Ăn");
		lblSinThoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon("images\\search.png"));
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		String[] header = "STT;Mã Món;Tên Món;Loại Món;Giá Tiền".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(tableMon = new JTable(tableModel), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(tableMon);

		JLabel lblTmKimTheo = new JLabel("Tìm Kiếm Theo");
		lblTmKimTheo.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTmKimKhch = new JLabel("TÌM KIẾM MÓN ĂN");
		lblTmKimKhch.setForeground(Color.RED);
		lblTmKimKhch.setFont(new Font("Times New Roman", Font.BOLD, 25));

		rdbTen = new JRadioButton("Tên");
		rdbTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbLoai = new JRadioButton("Loại món ăn");
		rdbLoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbMa = new JRadioButton("Mã");
		rdbMa.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng = new JLabel("Mã Món Ăn");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtMa = new JTextField();
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMa.setColumns(10);

		rdbGiaTien = new JRadioButton("Giá tiền");
		rdbGiaTien.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cboLoai = new JComboBox();

		lblGiTin = new JLabel("Giá Tiền");
		lblGiTin.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtGiaFrom = new JTextField();
		txtGiaFrom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaFrom.setEditable(false);
		txtGiaFrom.setColumns(10);

		lblT = new JLabel("Từ");
		lblT.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lbln = new JLabel("Đến");
		lbln.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtGiaTo = new JTextField();
		txtGiaTo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaTo.setEditable(false);
		txtGiaTo.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup().addGap(11)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(134)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(rdbMa, GroupLayout.PREFERRED_SIZE, 59,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(rdbGiaTien))
												.addGap(28)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(rdbLoai).addComponent(rdbTen,
																GroupLayout.PREFERRED_SIZE, 59,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblTmKimTheo,
														GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 110,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtMa, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
												.addGap(3))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(33)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(lblT,
																						GroupLayout.PREFERRED_SIZE, 62,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(18).addComponent(txtGiaFrom,
																						GroupLayout.DEFAULT_SIZE, 260,
																						Short.MAX_VALUE))
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(lbln,
																						GroupLayout.PREFERRED_SIZE, 53,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(27).addComponent(txtGiaTo,
																						GroupLayout.DEFAULT_SIZE, 260,
																						Short.MAX_VALUE))))
														.addComponent(lblGiTin, GroupLayout.PREFERRED_SIZE, 64,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE,
																		106, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(cboLoai, 0, 260, Short.MAX_VALUE)
																.addGap(3))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE,
																		110, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(txtTen, GroupLayout.DEFAULT_SIZE, 259,
																		Short.MAX_VALUE)))))
								.addGap(47))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(212)
										.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(389).addComponent(lblTmKimKhch,
								GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
				.addGap(26)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(22).addComponent(lblTmKimKhch).addGap(46)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTmKimTheo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(rdbMa).addGap(10)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(rdbGiaTien, GroupLayout.PREFERRED_SIZE, 29,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(rdbLoai)))
								.addComponent(rdbTen))
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMa, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(19)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(19)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboLoai, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(10).addComponent(lblGiTin, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblT)
								.addComponent(txtGiaFrom, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(14)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGiaTo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(33).addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
								.addGap(20)))));
		contentPane.setLayout(gl_contentPane);

		txtMa.setEditable(false);
		txtTen.setEditable(false);

		List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
		for (LoaiMon loaiMon : loaiMons) {
			cboLoai.addItem(loaiMon.getTenLoaiMon());
		}

		tableMon.setRowHeight(30);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbMa);
		buttonGroup.add(rdbTen);
		buttonGroup.add(rdbLoai);
		buttonGroup.add(rdbGiaTien);

		tableMon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableMon.getColumnCount(); c++) {
			Class<?> col_class = tableMon.getColumnClass(c);
			tableMon.setDefaultEditor(col_class, null); // remove editor
		}

		btnTimKiem.addActionListener(this);

		rdbMa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(true);
				txtTen.setEditable(false);
				cboLoai.setEnabled(false);
				txtGiaFrom.setEditable(false);
				txtGiaTo.setEditable(false);

			}
		});
		rdbLoai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(false);
				txtTen.setEditable(false);
				cboLoai.setEnabled(true);
				txtGiaFrom.setEditable(false);
				txtGiaTo.setEditable(false);
			}
		});
		rdbTen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(false);
				txtTen.setEditable(true);
				cboLoai.setEnabled(false);
				txtGiaFrom.setEditable(false);
				txtGiaTo.setEditable(false);
			}
		});
		rdbGiaTien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMa.setEditable(false);
				txtTen.setEditable(false);
				cboLoai.setEnabled(false);
				txtGiaFrom.setEditable(true);
				txtGiaTo.setEditable(true);
			}
		});
	}

	public void timKiemMon() {
		try {

			String ma = txtMa.getText().trim();
			String ten = txtTen.getText().trim();
			String loai = cboLoai.getSelectedItem().toString().trim();
			String giaFrom = txtGiaFrom.getText().trim();
			String giaTo = txtGiaTo.getText().trim();

			if (rdbMa.isSelected()) {
				if (ma.equalsIgnoreCase("") || ma == null || ma.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập mã món ăn!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					validateData = false;
				} else {
					mons = monDAO.getMonsByMa(ma);
					validateData = true;
				}
			} else if (rdbTen.isSelected()) {
				if (ten.equalsIgnoreCase("") || ten == null || ten.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập tên món!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					validateData = false;
				} else {
					mons = monDAO.getMonsByTen(ten);
					validateData = true;
				}
			} else if (rdbLoai.isSelected()) {
				mons = monDAO.getMonsByLoai(loai);
				validateData = true;
			} else if (rdbGiaTien.isSelected()) {
				StringBuilder msg = new StringBuilder();
				boolean check = true;
				if (giaFrom.equalsIgnoreCase("") || giaFrom == null || giaFrom.isEmpty()) {
					msg.append("Vui lòng nhập giá tiền(từ)!\n");
					check = false;
					validateData = false;
				} else if (giaFrom.matches(PRICE_PATTERN) == false) {
					msg.append("Giá tiền(từ) không hợp lệ!\n");
					check = false;
					validateData = false;
				}
				if (giaTo.equalsIgnoreCase("") || giaTo == null || giaTo.isEmpty()) {
					msg.append("Vui lòng nhập giá tiền(đến)!\n");
					check = false;
					validateData = false;
				} else if (giaTo.matches(PRICE_PATTERN) == false) {
					msg.append("Giá tiền(đến) không hợp lệ!\n");
					check = false;
					validateData = false;
				}

				if (check == true) {
					BigDecimal from = new BigDecimal(giaFrom);
					BigDecimal to = new BigDecimal(giaTo);
					if (from.compareTo(to) == 1) {
						JOptionPane.showMessageDialog(this, "Giá tiền(từ) phải lớn hơn giá tiền(đến)!", "Thông báo",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
						validateData = false;
					} else {
						mons = monDAO.getMonsByFromGiaToGia(from, to);
						validateData = true;
					}
				} else {
					JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTable() {
		tableModel = (DefaultTableModel) tableMon.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			int i = 0;
			if (mons.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu!", "Thông báo", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("images\\warning.png"));
				tableModel.fireTableDataChanged();
			} else {
				for (Mon m : mons) {
					i++;
					tableModel.addRow(new Object[] { i, m.getMaMon(), m.getTenMon(), m.getLoaiMon().getTenLoaiMon(),
							df.format(m.getGiaTien()) });
				}
				tableMon.setModel(tableModel);
				tableMon.getSelectionModel().clearSelection();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnTimKiem)) {
			if (!rdbGiaTien.isSelected() && !rdbLoai.isSelected() && !rdbMa.isSelected() && !rdbTen.isSelected()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			} else {
				timKiemMon();
				if (validateData == true) {
					updateTable();
				}
			}
		}

	}
}
