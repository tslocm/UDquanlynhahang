package com.iuh.quanlynhahang;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.iuh.quanlynhahang.guis.DangNhapUI;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2675918615578547119L;

	/**
	 * Launch the application.
	 * Run application here
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapUI frame = new DangNhapUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
	}

}
