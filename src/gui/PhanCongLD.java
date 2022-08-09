package gui;

import java.awt.Component;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_CongTrinh;
import dao.DAO_CongViec;
import entity.CongTrinh;
import entity.CongViec;

public class PhanCongLD extends JFrame{
	private JTextField txtMaNLD;
	private JTextField txtTenNLD;
	private JTable tablePhanCong;
	private JComboBox cbCongTrinh;
	private JComboBox cbCongViec;
	private DAO_CongTrinh daoCT;
	private DAO_CongViec daoCV;
	private Component txtmaNLD;
	private JButton btnPhanCong;
	private Component btnXoaRong;
	private JButton btnThoat;
	public PhanCongLD() throws Exception {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 904, 512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phân công lao động");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(312, 11, 294, 31);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 43, 868, 419);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã NLD:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 14, 75, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên NLD:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(414, 14, 75, 24);
		panel.add(lblNewLabel_1_1);
		
		txtmaNLD = new JTextField();
		txtmaNLD.setBounds(105, 15, 150, 33);
		panel.add(txtmaNLD);
	
		
		txtTenNLD = new JTextField();
		txtTenNLD.setColumns(10);
		txtTenNLD.setBounds(528, 15, 201, 33);
		panel.add(txtTenNLD);
		
		JLabel lblNewLabel_2 = new JLabel("Công Trình:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(6, 81, 89, 24);
		panel.add(lblNewLabel_2);
		
		cbCongTrinh = new JComboBox();
		cbCongTrinh.setBounds(105, 75, 201, 41);
		panel.add(cbCongTrinh);
		
		JLabel lblNewLabel_2_1 = new JLabel("Công việc:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(414, 88, 89, 24);
		panel.add(lblNewLabel_2_1);
		
		cbCongViec = new JComboBox();
		cbCongViec.setBounds(528, 81, 201, 41);
		panel.add(cbCongViec);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 848, 207);
		panel.add(scrollPane);
		String col[] = {"Mã người lao động","Tên người lao động","Công việc","Công trình","Ngày tham gia"};
		DefaultTableModel tbmodel = new DefaultTableModel(col,0);
		tablePhanCong = new JTable(tbmodel);
		scrollPane.setViewportView(tablePhanCong);

		
		btnPhanCong = new JButton("Phân Công");
		btnPhanCong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPhanCong.setBounds(86, 372, 130, 36);
		panel.add(btnPhanCong);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoaRong.setBounds(347, 372, 130, 36);
		panel.add(btnXoaRong);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(571, 372, 130, 36);
		panel.add(btnThoat);
		
	
		daoCT = new DAO_CongTrinh();
		daoCV = new DAO_CongViec();
		ConnectDB.getInstance().connect();
		updateCboCongTrinh();
		updateCboCongViec();
	}
	public void updateCboCongTrinh() {
		
		ArrayList<CongTrinh> dsCT = daoCT.layTatCaCongTrinh();
		for (CongTrinh congTrinh : dsCT) {
			cbCongTrinh.addItem(congTrinh.getTenCT());
		}
	}
	public void updateCboCongViec() {
		ArrayList<CongViec> dsCV = daoCV.layTatCaCongViec();
		for (CongViec congViec : dsCV) {
			cbCongViec.addItem(congViec.getTenCV());
		}
	}
	public static void main(String[] args) throws Exception {
		new PhanCongLD().setVisible(true);
	}
	

 	
}
