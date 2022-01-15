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

import com.iuh.quanlynhahang.daoimpls.LoaiMonDAOImpl;
import com.iuh.quanlynhahang.entities.LoaiMon;

public class LoaiMonUI extends JFrame implements ActionListener, MouseListener {

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
//					LoaiMonUI frame = new LoaiMonUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable tableLoaiMon;
	private JPanel panel;
	private JButton btnTim;
	private JLabel lblNhpTnNgi;
	private JPanel panel_1;
	private JLabel lblThngTinTi;
	private JLabel lblMTiKhon;
	private JLabel lblMKhchHng;
	private JTextField txtTenLoai;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JTextField txtTim;
	private JTextField txtMaLoai;
	private JButton btnLamMoiDuLieu;
//	private static final String TENLOAIMON_PATTERN="";
	private static LoaiMonDAOImpl loaiMonDAO = new LoaiMonDAOImpl();

	public LoaiMonUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTiKhon = new JLabel("LOẠI MÓN ĂN");
		lblTiKhon.setForeground(Color.RED);
		lblTiKhon.setFont(new Font("Times New Roman", Font.BOLD, 25));

		String[] header = "STT;Mã Loại;Tên Loại".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(tableLoaiMon = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableLoaiMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(new LineBorder(new Color(192, 192, 192)), "T\u00ECm Lo\u1EA1i M\u00F3n \u0102n",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon("images\\search.png"));
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblNhpTnNgi = new JLabel("Nhập Tên Loại");
		lblNhpTnNgi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));

		lblThngTinTi = new JLabel("Thông Tin Loại Món Ăn");
		lblThngTinTi.setForeground(Color.BLACK);
		lblThngTinTi.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblMTiKhon = new JLabel("Mã Loại");
		lblMTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblMKhchHng = new JLabel("Tên Loại");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTenLoai = new JTextField();
		txtTenLoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenLoai.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addGap(455).addComponent(lblTiKhon)
						.addContainerGap(430, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblTiKhon).addGap(26)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE).addGap(18)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(8))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
								.addContainerGap()))));

		txtTim = new JTextField();
		txtTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTim.setColumns(10);

		btnLamMoiDuLieu = new JButton("Làm Mới Dữ Liệu");
		btnLamMoiDuLieu.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoiDuLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblNhpTnNgi, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTim, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnTim, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE).addGap(18)
						.addComponent(btnLamMoiDuLieu, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE).addGap(11)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap(21, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNhpTnNgi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLamMoiDuLieu, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		panel.setLayout(gl_panel);

		txtMaLoai = new JTextField();
		txtMaLoai.setEditable(false);
		txtMaLoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaLoai.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("images\\add.png"));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setIcon(new ImageIcon("images\\edit.png"));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon("images\\refresh.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(152).addComponent(lblThngTinTi).addContainerGap(129,
						Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup().addGap(34)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(30).addComponent(txtMaLoai,
										GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(29).addGroup(gl_panel_1
										.createParallelGroup(Alignment.LEADING)
										.addComponent(txtTenLoai, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 115,
														GroupLayout.PREFERRED_SIZE)
												.addGap(38)
												.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 115,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 112,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)))))
						.addGap(50)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(10).addComponent(lblThngTinTi).addGap(57)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMaLoai, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTenLoai, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(51)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGap(32).addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(88)));
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		
		tableLoaiMon.setRowHeight(30);

		btnCapNhat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnLamMoiDuLieu.addActionListener(this);

		tableLoaiMon.addMouseListener(this);
		tableLoaiMon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < tableLoaiMon.getColumnCount(); c++) {
			Class<?> col_class = tableLoaiMon.getColumnClass(c);
			tableLoaiMon.setDefaultEditor(col_class, null); // remove editor
		}

		txtMaLoai.setText(randomMaLoaiMonNotExisted());
		updateTable();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableLoaiMon.getSelectedRow();
		String maLoai = tableModel.getValueAt(row, 1).toString();
		try {
			LoaiMon lm = loaiMonDAO.getLoaiMonById(maLoai);
			txtMaLoai.setText(maLoai);
			txtTenLoai.setText(lm.getTenLoaiMon());

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
			String ma = txtMaLoai.getText();
			String ten = txtTenLoai.getText().trim();
			if (ten.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên món ăn!", "Thông báo", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("images\\warning.png"));
			} else {
				boolean existed = checkExistedTenMon();
				if (existed == false) {
					JOptionPane.showMessageDialog(this, "Loại món đã tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
				} else {
					try {
						LoaiMon loaiMon = new LoaiMon(ma, ten);
						boolean check = loaiMonDAO.createLoaiMon(loaiMon);
						if (check == true) {
							JOptionPane.showMessageDialog(this, "Thêm loại món ăn thành công!", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\yes.png"));
							updateTable();
							refresh();
						} else {
							JOptionPane.showMessageDialog(this, "Thêm loại món ăn thất bại!", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
						}
					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(this, "Lỗi, hãy thử lại!", "Thông báo", JOptionPane.ERROR_MESSAGE,
								new ImageIcon("images\\warning.png"));
					}

				}
			}

		}

		else if (obj.equals(btnLamMoiDuLieu)) {
			updateTable();
		} else if (obj.equals(btnTim)) {
			String tenSearch = txtTim.getText().trim();
			if (tenSearch.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập loại món!", "Thông báo", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("images\\warning.png"));
				txtTim.requestFocus();
			}

			else {

				tableModel = (DefaultTableModel) tableLoaiMon.getModel();
				tableModel.getDataVector().removeAllElements();
				try {
					LoaiMon loaiMon = loaiMonDAO.getLoaiMonByTenLoai(tenSearch);
					tableModel.addRow(new Object[] { 1, loaiMon.getMaLoaiMon(), loaiMon.getTenLoaiMon() });
					tableLoaiMon.setModel(tableModel);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Không tồn tại loại món!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					txtTim.selectAll();
					txtTim.requestFocus();
				}
			}

		} else if (obj.equals(btnLamMoi)) {
			refresh();
		} else if (obj.equals(btnCapNhat)) {
			int row = tableLoaiMon.getSelectedRow();
			if (row >= 0) {
				String tenLoai = txtTenLoai.getText().trim();
				if (tenLoai.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập tên loại để cập nhật!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				} else {
					try {
						LoaiMon loaiMon = loaiMonDAO.getLoaiMonById(txtMaLoai.getText());
						loaiMon.setTenLoaiMon(tenLoai);
						boolean check = loaiMonDAO.updateLoaiMon(loaiMon);
						if (check) {
							JOptionPane.showMessageDialog(this, "Cập nhật loại món thành công!", "Thông báo",
									JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
							updateTable();
							refresh();
						} else {
							JOptionPane.showMessageDialog(this, "Cập nhật loại món thất bại!", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
						}
					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(this, "Lỗi, hãy thử lại!", "Thông báo", JOptionPane.ERROR_MESSAGE,
								new ImageIcon("images\\warning.png"));
					}
				}

			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại món để cập nhật!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			}

		}

	}

	@SuppressWarnings("static-access")
	public String randomMaLoaiMonNotExisted() {
		String maLoai;
		List<String> idLMAs = new ArrayList<String>();
		List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
		for (LoaiMon lm : loaiMons) {
			idLMAs.add(lm.getMaLoaiMon());
		}

		do {
			RandomStringUtils randomStringUtils = new RandomStringUtils();
			maLoai = randomStringUtils.randomNumeric(8);

		} while (idLMAs.contains(maLoai));
		return "LMA" + maLoai;
	}

	public void updateTable() {
		tableModel = (DefaultTableModel) tableLoaiMon.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
			int i = 0;
			for (LoaiMon lm : loaiMons) {
				i++;
				tableModel.addRow(new Object[] { i, lm.getMaLoaiMon(), lm.getTenLoaiMon() });
			}
			tableLoaiMon.setModel(tableModel);
			tableLoaiMon.getSelectionModel().clearSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void refresh() {
		txtTenLoai.setText("");
		txtMaLoai.setText(randomMaLoaiMonNotExisted());
	}

	private boolean checkExistedTenMon() {
		List<LoaiMon> loaiMons = loaiMonDAO.getAllLoaiMon();
		for (LoaiMon loaiMon : loaiMons) {
			if (loaiMon.getTenLoaiMon().equalsIgnoreCase(txtTenLoai.getText().trim())) {
				return false;
			}
		}
		return true;
	}
}
