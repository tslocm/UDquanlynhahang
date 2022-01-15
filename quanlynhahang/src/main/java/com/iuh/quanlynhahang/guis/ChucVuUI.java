package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.RandomStringUtils;

import com.iuh.quanlynhahang.daoimpls.LoaiTaiKhoanDAOImpl;
import com.iuh.quanlynhahang.entities.LoaiTaiKhoan;

public class ChucVuUI extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1595338602710271195L;
	public JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JPanel panel;
	private JLabel lblthongTinCV;
	private JLabel lblmaCV;
	private JLabel lbltenCV;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JTextField txtmaCV;
	private JTextField txttenCV;
	private JLabel lblChcV;

	private static LoaiTaiKhoanDAOImpl loaiTaiKhoanDAO = new LoaiTaiKhoanDAOImpl();

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChucVuUI frame = new ChucVuUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public ChucVuUI() {
		setTitle("Giao Diện Quản Lý Chức Vụ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		setLocationRelativeTo(null);
		// setVisible(true);
		taoGiaoDien();
	}

	public void taoGiaoDien() {
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String[] header = "STT;Mã Chức Vụ; Tên Chức Vụ".split(";");
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.addMouseListener(this);
		table.setRowHeight(30);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.control);

		lblthongTinCV = new JLabel("Thông Tin Chức Vụ");
		lblthongTinCV.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongTinCV.setForeground(Color.BLACK);
		lblthongTinCV.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblmaCV = new JLabel("Mã Chức Vụ");
		lblmaCV.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lbltenCV = new JLabel("Tên Chức Vụ:");
		lbltenCV.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtmaCV = new JTextField();
		txtmaCV.setEditable(false);
		txtmaCV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtmaCV.setColumns(10);

		txttenCV = new JTextField();
		txttenCV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txttenCV.setColumns(10);

		lblChcV = new JLabel("CHỨC VỤ");
		lblChcV.setHorizontalAlignment(SwingConstants.CENTER);
		lblChcV.setForeground(Color.RED);
		lblChcV.setFont(new Font("Times New Roman", Font.BOLD, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(489)
					.addComponent(lblChcV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(455))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChcV)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
						.addComponent(scrollPane))
					.addGap(3))
		);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("images\\add.png"));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setIcon(new ImageIcon("images\\edit.png"));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addGap(31)
						.addComponent(lblmaCV, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE).addGap(28)
						.addComponent(txtmaCV, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE).addGap(90))
				.addGroup(gl_panel.createSequentialGroup().addGap(31)
						.addComponent(lbltenCV, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE).addGap(28)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE).addGap(42)
										.addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
								.addComponent(txttenCV, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 235,
										Short.MAX_VALUE))
						.addGap(90))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGap(154)
						.addComponent(lblthongTinCV, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE).addGap(166)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addComponent(lblthongTinCV, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(23)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblmaCV, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addGap(2)
								.addComponent(txtmaCV, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
				.addGap(29)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbltenCV, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addGap(2)
								.addComponent(txttenCV, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
				.addGap(79)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
				.addGap(85)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		btnCapNhat.addActionListener(this);
		btnThem.addActionListener(this);

		txtmaCV.setText(randomMaLTKNotExisted());
		table.addMouseListener(this);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < table.getColumnCount(); c++) {
			Class<?> col_class = table.getColumnClass(c);
			table.setDefaultEditor(col_class, null); // remove editor
		}
		updateTable();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String maLTK = tableModel.getValueAt(row, 1).toString();
		try {
			LoaiTaiKhoan ltk = loaiTaiKhoanDAO.getLTKByMaLTK(maLTK);
			txtmaCV.setText(ltk.getMaLoaiTaiKhoan());
			txttenCV.setText(ltk.getTenLoaiTaiKhoan());
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
			String maLTK = txtmaCV.getText();
			String tenLTK = txttenCV.getText().trim();
			if (tenLTK.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên chức vụ!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			} else {
				try {
					LoaiTaiKhoan loaiTaiKhoan = new LoaiTaiKhoan(maLTK, tenLTK);
					boolean check = loaiTaiKhoanDAO.createLTK(loaiTaiKhoan);
					if (check) {
						JOptionPane.showMessageDialog(this, "Thêm chức vụ thành công!", "Thông báo",
								JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
						updateTable();
						txttenCV.setText("");
						txtmaCV.setText(randomMaLTKNotExisted());
					} else {
						JOptionPane.showMessageDialog(this, "Thêm chức vụ thất bại!", "Thông báo",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Lỗi. Vui lòng thử lại!", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
				}
			}
		} else if (obj.equals(btnCapNhat)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				String maLTK = txtmaCV.getText();
				String tenLTK = txttenCV.getText();

				try {
					LoaiTaiKhoan ltk = loaiTaiKhoanDAO.getLTKByMaLTK(maLTK);
					ltk.setTenLoaiTaiKhoan(tenLTK);
					boolean check = loaiTaiKhoanDAO.updateLTK(ltk);
					if (check) {
						JOptionPane.showMessageDialog(this, "Cập nhật chức vụ thành công!", "Thông báo",
								JOptionPane.CLOSED_OPTION, new ImageIcon("images\\yes.png"));
						updateTable();
						txttenCV.setText("");
						txtmaCV.setText(randomMaLTKNotExisted());
					} else {
						JOptionPane.showMessageDialog(this, "Cập nhật chức vụ thất bại!", "Thông báo",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Lỗi, hãy thử lại sau!", "Thông báo", JOptionPane.ERROR_MESSAGE,
							new ImageIcon("images\\warning.png"));
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ cần cập nhật!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			}
		}
	}

	@SuppressWarnings("static-access")
	public String randomMaLTKNotExisted() {
		String maLTK;
		List<String> idLTKs = new ArrayList<String>();
		List<LoaiTaiKhoan> loaiTaiKhoans = loaiTaiKhoanDAO.getAllLTK();
		for (LoaiTaiKhoan ltk : loaiTaiKhoans) {
			idLTKs.add(ltk.getMaLoaiTaiKhoan());
		}
		do {
			RandomStringUtils randomStringUtils = new RandomStringUtils();
			maLTK = randomStringUtils.randomNumeric(8);
		} while (idLTKs.contains(maLTK));
		return "LTK" + maLTK;
	}

	public void updateTable() {
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			List<LoaiTaiKhoan> lTKs = loaiTaiKhoanDAO.getAllLTK();
			int i = 0;
			for (LoaiTaiKhoan ltk : lTKs) {
				i++;
				tableModel.addRow(new Object[] { i, ltk.getMaLoaiTaiKhoan(), ltk.getTenLoaiTaiKhoan() });
			}
			table.setModel(tableModel);
			table.getSelectionModel().clearSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
