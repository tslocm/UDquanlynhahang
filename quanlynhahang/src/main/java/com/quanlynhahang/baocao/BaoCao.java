package com.quanlynhahang.baocao;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.iuh.quanlynhahang.guis.ThongKeDoUongUI;
import com.iuh.quanlynhahang.guis.ThongKeDoanhThuUI;
import com.iuh.quanlynhahang.guis.ThongKeKhachHangUI;
import com.iuh.quanlynhahang.guis.ThongKeMonAnUI;
import com.quanlynhahang.dto.DoUongDTO;
import com.quanlynhahang.dto.DoanhThu;
import com.quanlynhahang.dto.KhachHangDTO;
import com.quanlynhahang.dto.MonAnDTO;

public class BaoCao {
	FileDialog fd = new FileDialog(new JFrame(), "Xuất Excel", FileDialog.SAVE);
	private ThongKeDoanhThuUI tkDT = new ThongKeDoanhThuUI();
	private ThongKeMonAnUI tkMA = new ThongKeMonAnUI();
	private ThongKeDoUongUI tkDU = new ThongKeDoUongUI();
	private ThongKeKhachHangUI tkKH = new ThongKeKhachHangUI();
	private static String[] columnsDT = { "STT", "Mã Hóa Đơn", "Ngày In Hóa Đơn", "Thành Tiền" };
	private static String[] columnsMA = { "STT", "Mã Món Ăn", "Tên Món Ăn", "Loại Món Ăn", "Giá Tiền" };
	private static String[] columnsDO = { "STT", "Mã Đồ Uống", "Tên Đồ Uống", "Giá Tiền" };
	private static String[] columnsKH = { "STT", "Mã Khách Hàng", "Tên Khách Hàng", "Số Lần Đặt", "Số Điện Thoại",
			"Giới Tính", "Địa Chỉ" };

	private String getFile() {
		fd.setFile("untitled.xlsx");
		fd.setVisible(true);
		String url = fd.getDirectory() + fd.getFile();
		if (url.equals("nullnull")) {
			return null;
		}
		return url;
	}

	// Xuất Excel Doanh thu
	@SuppressWarnings({ "resource", "static-access", "unused" })
	public void BaoCaoDoanhThu() {
		fd.setTitle("Báo Cáo Doanh Thu");
		String url = getFile();

		if (url == null) {
			return;
		}

		FileOutputStream outFile = null;

		try {
			Workbook workbook = null;
			boolean check = true;
			if (url.endsWith("xlsx")) {
				workbook = new XSSFWorkbook();
				check = true;

			} else if (url.endsWith("xls")) {
				workbook = new HSSFWorkbook();
				check = false;
			} else {
				JOptionPane.showMessageDialog(null, "Đuôi file không hợp lệ! Vui lòng chọn file xlsx hoặc xlsx");
				// throw new IllegalArgumentException("Đuôi file không hợp lệ! Vui lòng chọn
				// file xlsx hoặc xlsx");
				return;

			}
			Sheet sheet = workbook.createSheet("Doanh Thu");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 14);

			Font color = workbook.createFont();
			color.setItalic(true);
			color.setColor(IndexedColors.RED.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setFont(color);

			List<DoanhThu> listDT = tkDT.listDT;

			int rownum = 0;
			Row row = sheet.createRow(rownum);

			for (int i = 0; i < columnsDT.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(columnsDT[i]);
				cell.setCellStyle(headerCellStyle);
			}

			double t = 0;
			for (DoanhThu dt : listDT) {
				rownum++;
				row = sheet.createRow(rownum);

				row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
				row.createCell(1, CellType.STRING).setCellValue(dt.getMaHD());
				row.createCell(2, CellType.STRING).setCellValue(dt.getNgayInHD());
//				Double d = dt.getThanhTien().doubleValue();
				row.createCell(3, CellType.STRING).setCellValue(dt.getThanhTien());
				// t+=d;
			}

			if (check == true) {

//				XSSFCell cell=(XSSFCell) sheet.getRow(1).getCell(3);
				row = sheet.createRow(rownum + 1);
				row.createCell(2, CellType.STRING).setCellValue("Tổng tiền");
				;
//				cell = (XSSFCell) row.createCell(3, CellType.FORMULA);
//				cell.setCellFormula(t+"");
				row.createCell(3, CellType.STRING).setCellValue(tkDT.tienTong);

			} else {
//				HSSFCell cell=(HSSFCell) sheet.getRow(1).getCell(3);
				row = sheet.createRow(rownum + 1);
				row.createCell(2, CellType.STRING).setCellValue("Tổng tiền");
				;
				row.createCell(3, CellType.STRING).setCellValue(tkDT.tienTong);
			}

			row = sheet.createRow(rownum + 2);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue("*Doanh thu của nhà hàng từ ngày " + tkDT.ngayBD + " đến ngày " + tkDT.ngayEnd);
			cell1.setCellStyle(textStyle);
			sheet.addMergedRegion(new CellRangeAddress(rownum + 2, rownum + 2, 0, 10));

			for (int i = 0; i < rownum; i++) {
				sheet.autoSizeColumn(i);
			}

			File file = new File(url);
			file.getParentFile().mkdirs();
			outFile = new FileOutputStream(file);
			workbook.write(outFile);

			JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File name'" + url + "' đang sử dụng! Vui lòng tắt hoặc tạo tên mới! ");
			// Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE,
			// null, ex);

		} catch (IOException ex) {
			Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				if (outFile != null) {
					outFile.close();
				}
			} catch (IOException ex) {
				Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	// Xuất Excel Báo cáo Món ăn
	@SuppressWarnings({ "unused", "resource", "static-access" })
	public void BaoCaoMonAn() {
		fd.setTitle("Báo Cáo Món Ăn");
		String url = getFile();

		if (url == null) {
			return;
		}

		FileOutputStream outFile = null;

		try {
			Workbook workbook = null;
			boolean check;
			if (url.endsWith("xlsx")) {
				workbook = new XSSFWorkbook();
				check = true;
			} else if (url.endsWith("xls")) {
				workbook = new HSSFWorkbook();
				check = false;
			} else {
				JOptionPane.showMessageDialog(null, "Đuôi file không hợp lệ! Vui lòng chọn file xlsx hoặc xlsx");
				// throw new IllegalArgumentException("Đuôi file không hợp lệ! Vui lòng chọn
				// file xlsx hoặc xlsx");
				return;
			}

			Sheet sheet = workbook.createSheet("Món Ăn");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 14);

			Font color = workbook.createFont();
			color.setItalic(true);
			color.setColor(IndexedColors.RED.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setFont(color);

			@SuppressWarnings("static-access")
			List<MonAnDTO> list = tkMA.listMA;

			int rownum = 0;
			Row row = sheet.createRow(rownum);

			for (int i = 0; i < columnsMA.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(columnsMA[i]);
				cell.setCellStyle(headerCellStyle);
			}

			double t = 0;
			for (MonAnDTO mons : list) {
				rownum++;
				row = sheet.createRow(rownum);

				row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
				row.createCell(1, CellType.STRING).setCellValue(mons.getMaMon());
				row.createCell(2, CellType.STRING).setCellValue(mons.getTenMon());
				row.createCell(3, CellType.STRING).setCellValue(mons.getLoaiMon());
				row.createCell(4, CellType.STRING).setCellValue(mons.getGiatienMon());
			}
			row = sheet.createRow(rownum + 2);
			Cell cell1 = row.createCell(0);
			if (tkMA.getMonth == null) {
				cell1.setCellValue("*Top 10 món ăn " + tkMA.getCBXMonAn + " theo năm " + tkMA.getYear);
			} else {
				cell1.setCellValue(
						"*Top 10 món ăn " + tkMA.getCBXMonAn + " theo tháng " + tkMA.getMonth + " năm " + tkMA.getYear);
			}

			cell1.setCellStyle(textStyle);
			sheet.addMergedRegion(new CellRangeAddress(rownum + 2, rownum + 2, 0, 10));

			for (int i = 0; i < rownum; i++) {
				sheet.autoSizeColumn(i);
			}

			File file = new File(url);
			file.getParentFile().mkdirs();
			outFile = new FileOutputStream(file);
			workbook.write(outFile);

			JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File name'" + url + "' đang sử dụng! Vui lòng tắt hoặc tạo tên mới! ");
			// Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE,
			// null, ex);

		} catch (IOException ex) {
			Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				if (outFile != null) {
					outFile.close();
				}
			} catch (IOException ex) {
				Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	// Xuất Excel Báo cáo Đồ Uống
	@SuppressWarnings({ "resource", "unused", "static-access" })
	public void BaoCaoDoUong() {
		fd.setTitle("Báo Cáo Đồ Uống");
		String url = getFile();

		if (url == null) {
			return;
		}

		FileOutputStream outFile = null;

		try {
			Workbook workbook = null;
			boolean check;
			if (url.endsWith("xlsx")) {
				workbook = new XSSFWorkbook();
				check = true;
			} else if (url.endsWith("xls")) {
				workbook = new HSSFWorkbook();
				check = false;
			} else {
				JOptionPane.showMessageDialog(null, "Đuôi file không hợp lệ! Vui lòng chọn file xlsx hoặc xlsx");
				// throw new IllegalArgumentException("Đuôi file không hợp lệ! Vui lòng chọn
				// file xlsx hoặc xlsx");
				return;
			}

			Sheet sheet = workbook.createSheet("Đồ Uống");
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 14);

			Font color = workbook.createFont();
			color.setItalic(true);
			color.setColor(IndexedColors.RED.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setFont(color);

			List<DoUongDTO> list = tkDU.listDU;

			int rownum = 0;
			Row row = sheet.createRow(rownum);

			for (int i = 0; i < columnsDO.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(columnsDO[i]);
				cell.setCellStyle(headerCellStyle);
			}

			double t = 0;
			for (DoUongDTO nuoc : list) {
				rownum++;
				row = sheet.createRow(rownum);

				row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
				row.createCell(1, CellType.STRING).setCellValue(nuoc.getDoUong());
				row.createCell(2, CellType.STRING).setCellValue(nuoc.getTenMon());
				// row.createCell(3, CellType.STRING).setCellValue(nuoc.getLoaiDoUong());
				row.createCell(4, CellType.STRING).setCellValue(nuoc.getGiatienDoUong());
			}
			row = sheet.createRow(rownum + 2);

//				row.createCell(0, CellType.STRING).setCellValue("Top 10 món ăn "+tkMA.getCBXMonAn+" theo tháng "+tkMA.getMonth
//						+" năm "+tkMA.getYear);
			Cell cell1 = row.createCell(0);
			if (tkDU.getMonth == null) {
				cell1.setCellValue("*Top 10 đồ uống " + tkDU.getCBXMonAn + " theo năm " + tkDU.getYear);
			} else {
				cell1.setCellValue("*Top 10 đồ uống " + tkDU.getCBXMonAn + " theo tháng " + tkDU.getMonth + " năm "
						+ tkDU.getYear);
			}

			cell1.setCellStyle(textStyle);
			sheet.addMergedRegion(new CellRangeAddress(rownum + 2, rownum + 2, 0, 10));

			for (int i = 0; i < rownum; i++) {
				sheet.autoSizeColumn(i);
			}

			File file = new File(url);
			file.getParentFile().mkdirs();
			outFile = new FileOutputStream(file);
			workbook.write(outFile);

			JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File name'" + url + "' đang sử dụng! Vui lòng tắt hoặc tạo tên mới! ");
			// Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE,
			// null, ex);

		} catch (IOException ex) {
			Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				if (outFile != null) {
					outFile.close();
				}
			} catch (IOException ex) {
				Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	// Xuất Excel Báo cáo Khách Hàng
	@SuppressWarnings({ "unused", "resource", "static-access" })
	public void BaoCaoKhachHang() {
		fd.setTitle("Báo Cáo Khách Hàng");
		String url = getFile();

		if (url == null) {
			return;
		}

		FileOutputStream outFile = null;

		try {
			Workbook workbook = null;
			boolean check;
			if (url.endsWith("xlsx")) {
				workbook = new XSSFWorkbook();
				check = true;
			} else if (url.endsWith("xls")) {
				workbook = new HSSFWorkbook();
				check = false;
			} else {
				JOptionPane.showMessageDialog(null, "Đuôi file không hợp lệ! Vui lòng chọn file xlsx hoặc xlsx");
				// throw new IllegalArgumentException("Đuôi file không hợp lệ! Vui lòng chọn
				// file xlsx hoặc xlsx");
				return;
			}

			Sheet sheet = workbook.createSheet("Khách Hàng");
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 14);

			Font color = workbook.createFont();
			color.setItalic(true);
			color.setColor(IndexedColors.RED.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setFont(color);

			List<KhachHangDTO> list = tkKH.listKHDTO;

			int rownum = 0;
			Row row = sheet.createRow(rownum);

			for (int i = 0; i < columnsKH.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(columnsKH[i]);
				cell.setCellStyle(headerCellStyle);
			}

			double t = 0;
			for (KhachHangDTO kh : list) {
				rownum++;
				row = sheet.createRow(rownum);

				row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
				row.createCell(1, CellType.STRING).setCellValue(kh.getMaKH());
				row.createCell(2, CellType.STRING).setCellValue(kh.getTenKH());
				row.createCell(3, CellType.STRING).setCellValue(kh.getSoLanDat());
				row.createCell(4, CellType.STRING).setCellValue(kh.getsDT());
				row.createCell(5, CellType.STRING).setCellValue(kh.getGioiTinh());
				row.createCell(6, CellType.STRING).setCellValue(kh.getDiaChi());
			}
			row = sheet.createRow(rownum + 2);

//						row.createCell(0, CellType.STRING).setCellValue("Top 10 món ăn "+tkMA.getCBXMonAn+" theo tháng "+tkMA.getMonth
//								+" năm "+tkMA.getYear);
			Cell cell1 = row.createCell(0);
			if (tkKH.getMonth == null) {
				cell1.setCellValue("*Top 10 khách hàng " + tkKH.getCBXMonAn + " theo năm " + tkKH.getYear);
			} else {
				cell1.setCellValue("*Top 10 khách hàng " + tkKH.getCBXMonAn + " theo tháng " + tkKH.getMonth + " năm "
						+ tkKH.getYear);
			}

			cell1.setCellStyle(textStyle);
			sheet.addMergedRegion(new CellRangeAddress(rownum + 2, rownum + 2, 0, 10));

			for (int i = 0; i < rownum; i++) {
				sheet.autoSizeColumn(i);
			}

			File file = new File(url);
			file.getParentFile().mkdirs();
			outFile = new FileOutputStream(file);
			workbook.write(outFile);

			JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File name'" + url + "' đang sử dụng! Vui lòng tắt hoặc tạo tên mới! ");
			// Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE,
			// null, ex);

		} catch (IOException ex) {
			Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				if (outFile != null) {
					outFile.close();
				}
			} catch (IOException ex) {
				Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
