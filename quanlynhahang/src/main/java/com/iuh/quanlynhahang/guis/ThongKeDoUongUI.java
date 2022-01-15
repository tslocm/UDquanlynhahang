package com.iuh.quanlynhahang.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.iuh.quanlynhahang.daoimpls.MonDAOImpl;
import com.iuh.quanlynhahang.entities.Mon;
import com.quanlynhahang.baocao.BaoCao;
import com.quanlynhahang.dto.DoUongDTO;

public class ThongKeDoUongUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JLabel lblTheoThng;
	private JLabel lblNm;
	private static MonDAOImpl monDAO = new MonDAOImpl();
	private static List<Mon> mons = new ArrayList<Mon>();
	private static List<String> maMons = new ArrayList<String>();
	private static NumberFormat df = new DecimalFormat("#,###.00 VNĐ");

	public static List<DoUongDTO> listDU = new ArrayList<DoUongDTO>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThongKeDoUongUI frame = new ThongKeDoUongUI();
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
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnThongKe;
	@SuppressWarnings("rawtypes")
	private JComboBox cboMonAn, cbxThang, cbxNam;
	private JLabel lblThngKTheo;
	private JRadioButton rdbThang;
	private JRadioButton rdbNam;
	private JLabel lblThngKTheo_1;
	private JButton btnBaoCao;

	public static final String banChayNhat = "Bán chạy nhất";
	public static final String banItNhat = "Bán ít nhất";
	public static String getCBXMonAn;
	public static String getMonth;
	public static String getYear;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ThongKeDoUongUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);

		JLabel lblThngKMn = new JLabel("THỐNG KÊ ĐỒ UỐNG");
		lblThngKMn.setForeground(Color.RED);
		lblThngKMn.setFont(new Font("Times New Roman", Font.BOLD, 25));

		String[] header = "STT;Mã Đồ Uống;Tên Đồ Uống;Loại;Giá Tiền".split(";");
		tableModel = new DefaultTableModel(header, 0);
		scrollPane = new JScrollPane(table = new JTable(tableModel), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		table.setRowHeight(30);

		JLabel lblMnn = new JLabel("Đồ Uống");
		lblMnn.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cboMonAn = new JComboBox();
		cboMonAn.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cbxThang = new JComboBox();
		cbxThang.setEnabled(false);
		cbxThang.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cbxNam = new JComboBox();
		cbxNam.setEnabled(false);
		cbxNam.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnThongKe = new JButton("Thống Kê");
		btnThongKe.setIcon(new ImageIcon("images\\calculator.png"));
		btnThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblTheoThng = new JLabel("Tháng");
		lblTheoThng.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblNm = new JLabel("Năm");
		lblNm.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblThngKTheo = new JLabel("Thống kê theo");
		lblThngKTheo.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbThang = new JRadioButton("Tháng");
		rdbThang.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		rdbNam = new JRadioButton("Năm");
		rdbNam.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblThngKTheo_1 = new JLabel("Thống kê theo top 10");
		lblThngKTheo_1.setForeground(Color.RED);
		lblThngKTheo_1.setFont(new Font("Times New Roman", Font.ITALIC, 15));

		btnBaoCao = new JButton("Báo Cáo");
		btnBaoCao.setIcon(new ImageIcon("images\\report.png"));
		btnBaoCao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(23)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblThngKTheo_1, GroupLayout.PREFERRED_SIZE, 178,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblThngKTheo, GroupLayout.PREFERRED_SIZE, 95,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(rdbThang, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE)
										.addGap(21).addComponent(rdbNam, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblMnn, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE)
										.addGap(32).addComponent(cboMonAn, 0, 126, Short.MAX_VALUE).addGap(33))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblTheoThng, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE)
										.addGap(32).addComponent(cbxThang, 0, 126, Short.MAX_VALUE).addGap(33))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNm, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addGap(40)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(cbxNam, 0, 129, Short.MAX_VALUE).addGap(33))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnBaoCao, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnThongKe, GroupLayout.DEFAULT_SIZE, 118,
																Short.MAX_VALUE)))))
								.addGap(25).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
								.addGap(30))))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(410)
						.addComponent(lblThngKMn, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(389, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(20).addComponent(lblThngKMn).addGap(33)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblThngKTheo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(4).addComponent(rdbThang,
										GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(4).addComponent(rdbNam,
										GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGap(12)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMnn, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboMonAn, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTheoThng, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxThang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNm, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxNam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(29).addComponent(btnThongKe, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addGap(33).addComponent(btnBaoCao, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(4).addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblThngKTheo_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

		cboMonAn.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnBaoCao.addActionListener(this);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbNam);
		buttonGroup.add(rdbThang);

		loadComboboxNam();
		for (int i = 1; i <= 12; i++) {
			cbxThang.addItem(i + "");
		}
		cboMonAn.addItem("Bán chạy nhất");
		cboMonAn.addItem("Bán ít nhất");

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int c = 0; c < table.getColumnCount(); c++) {
			Class<?> col_class = table.getColumnClass(c);
			table.setDefaultEditor(col_class, null); // remove editor
		}
		rdbNam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbxNam.setEnabled(true);
				cbxThang.setEnabled(false);

			}
		});
		rdbThang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbxNam.setEnabled(true);
				cbxThang.setEnabled(true);

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThongKe)) {
			if (!rdbNam.isSelected() && !rdbThang.isSelected()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại thống kê!", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images\\warning.png"));
			} else {
				thongKeDoUong();
				updateTable();
			}
		} else if (o.equals(btnBaoCao)) {
			try {
				if (table.getRowCount() <= 0) {
					int options = JOptionPane.showConfirmDialog(this,
							"Không có dữ liệu nào hết. Bạn có chắc muốn tiếp tục?", "Thông báo",
							JOptionPane.YES_NO_OPTION);
					if (options == JOptionPane.YES_OPTION) {
						BaoCao bc = new BaoCao();
						bc.BaoCaoDoUong();
					}
				} else {
					BaoCao bc = new BaoCao();
					bc.BaoCaoDoUong();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	private void thongKeDoUong() {
		try {
			String loai = cboMonAn.getSelectedItem().toString();
			String thang = cbxThang.getSelectedItem().toString();
			String nam = cbxNam.getSelectedItem().toString();

			getCBXMonAn = loai;

			if (rdbThang.isSelected()) {
				getMonth = thang;
				if (loai.equalsIgnoreCase("Bán chạy nhất")) {
					maMons = monDAO.ThongKeDoUongNhieuNhatTrongThang(Integer.parseInt(thang), Integer.parseInt(nam),
							"Đồ Uống");
					mons = convertStringtoMon(maMons);
				} else if (loai.equalsIgnoreCase("Bán ít nhất")) {
					maMons = monDAO.ThongKeDoUongItNhatTrongThang(Integer.parseInt(thang), Integer.parseInt(nam),
							"Đồ Uống");
					mons = convertStringtoMon(maMons);
				}
			} else if (rdbNam.isSelected()) {
				getYear = nam;
				if (loai.equalsIgnoreCase("Bán chạy nhất")) {
					maMons = monDAO.ThongKeDoUongNhieuNhatTrongNam(Integer.parseInt(nam), "Đồ Uống");
					mons = convertStringtoMon(maMons);
				} else if (loai.equalsIgnoreCase("Bán ít nhất")) {
					maMons = monDAO.ThongKeDoUongItNhatTrongNam(Integer.parseInt(nam), "Đồ Uống");
					mons = convertStringtoMon(maMons);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<Mon> convertStringtoMon(List<String> list) {
		List<Mon> mons = new ArrayList<Mon>();
		try {
			for (String str : list) {
				Mon mon = monDAO.getMonByMa(str);
				mons.add(mon);
			}
		} catch (Exception e) {
		}
		return mons;
	}

	public void updateTable() {
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.getDataVector().removeAllElements();
		try {
			int i = 0;
			if (mons.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu!", "Thông báo", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("images\\warning.png"));
				tableModel.fireTableDataChanged();
			} else {
				for (Mon mon : mons) {
					i++;
					tableModel.addRow(new Object[] { i, mon.getMaMon(), mon.getTenMon(),
							mon.getLoaiMon().getTenLoaiMon(), df.format(mon.getGiaTien()) });
					DoUongDTO doUongDTO = new DoUongDTO(mon.getMaMon(), mon.getTenMon(),
							mon.getLoaiMon().getTenLoaiMon(), df.format(mon.getGiaTien()));
					listDU.add(doUongDTO);
				}
				table.setModel(tableModel);
				table.getSelectionModel().clearSelection();
				tableModel.fireTableDataChanged();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void loadComboboxNam() {

		List<Integer> list = monDAO.getAllNamsInHoaDon();
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(list);
		for (Integer i : set) {
			cbxNam.addItem(i + "");
		}

	}
}
