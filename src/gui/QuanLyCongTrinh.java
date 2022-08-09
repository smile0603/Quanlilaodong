package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;

import dao.DAO_CongTrinh;
import dao.DAO_NguoiLaoDong;
import entity.CongTrinh;

import entity.NguoiLaoDong;

public class QuanLyCongTrinh extends JFrame implements ActionListener{
	
	private JTable tableCongTrinh;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThemCT;
	private JButton btnSuaCT;
	private JButton btnPhanCong;
	private JButton btnXoaCT;
	private ThemCongTrinh themCT;
	private PhanCongLD phanCongLD;
	private DAO_CongTrinh daoCT;
	private DefaultTableModel tbmodel;
	private JButton btnThoat;
	private SuaCongTrinh suaCT;
	

	public QuanLyCongTrinh() throws Exception {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 994, 602);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Quản lí công trình");
		lblNewLabel.setBounds(279, 0, 316, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		getContentPane().add(lblNewLabel);
		

		JPanel panel = new JPanel();
		panel.setBounds(10, 35, 958, 517);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(257, 11, 691, 495);
		panel.add(scrollPane);
		String col[] = {"Mã Công Trình","Tên Công Trình","Địa điểm","Ngày cấp phép","Ngày khởi công","Ngày HT Dự kiến"};
		tbmodel = new DefaultTableModel(col,0);
		tableCongTrinh = new JTable(tbmodel);
		scrollPane.setViewportView(tableCongTrinh);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm công trình theo mã:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 18, 169, 24);
		panel.add(lblNewLabel_1);
		
		txtTim = new JTextField();
		txtTim.setBounds(10, 53, 128, 35);
		panel.add(txtTim);
		txtTim.setColumns(10);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTim.setBounds(148, 53, 89, 35);
		panel.add(btnTim);
		
		btnThemCT = new JButton("Thêm mới công trình");
		btnThemCT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemCT.setBounds(10, 119, 227, 46);
		panel.add(btnThemCT);
		
		btnSuaCT = new JButton("Sửa thông tin công trình");
		btnSuaCT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSuaCT.setBounds(10, 201, 227, 46);
		panel.add(btnSuaCT);
		
		btnPhanCong = new JButton("Phân công lao động");
		btnPhanCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhanCong.setBounds(10, 282, 227, 46);
		panel.add(btnPhanCong);
		
		btnXoaCT = new JButton("Xóa Công Trình");
		btnXoaCT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaCT.setBounds(10, 369, 227, 46);
		panel.add(btnXoaCT);
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(10, 448, 227, 46);
		panel.add(btnThoat);
		
	
		btnThemCT.addActionListener(this);
		btnXoaCT.addActionListener(this);
		btnSuaCT.addActionListener(this);
		btnPhanCong.addActionListener(this);
		btnThoat.addActionListener(this);
		btnTim.addActionListener(this);
		themCT = new ThemCongTrinh();
		suaCT = new SuaCongTrinh();
		phanCongLD = new PhanCongLD();
		ConnectDB.getInstance().connect();
		updateTableData();
		
	}
	public static void main(String[] args) throws Exception {
		new QuanLyCongTrinh().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		//them CT
		if(object.equals(btnThemCT)) {
			themCT.setVisible(true);
			this.dispose();
		}
		//Tim CT
		else if(object.equals(btnTim)) {
			String maTim = txtTim.getText().trim();
			tbmodel.setRowCount(0);
			txtTim.setText("");
			for (CongTrinh ct : daoCT.layNLDTheoMa(maTim)) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				String ngayCP = dateFormat.format(ct.getNgayCapPhep());
				String ngayKC = dateFormat.format(ct.getNgayKhoiCong());
				String ngayHT = dateFormat.format(ct.getNgayHoanThanhDuKien());
				String [] row = {ct.getMaCT(),ct.getTenCT(),ct.getDiaDiemCT(),ngayCP,ngayKC,ngayHT};
				tbmodel.addRow(row);
			}
			tableCongTrinh.setModel(tbmodel);
		}
		//thoat CT
		else if(object.equals(btnThoat)) {
			this.dispose();
		}
		//Sửa
		else if(object.equals(btnSuaCT)) {
			int row=tableCongTrinh.getSelectedRow();
			
			
			//ArrayList<CongTrinh> dsCT = daoCT.layNLDTheoMa(maSua);
			if(row == -1){
				JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
			}
			else {
				String maSua = tbmodel.getValueAt(row,0).toString();
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn sửa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION){
					
					suaCT.setVisible(true);
					try {
						suaCT.getCongTrinhTheoMa(maSua);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					this.dispose();
				}
			}
		}
		//Xoa
		else if(object.equals(btnXoaCT)) {
			int row=tableCongTrinh.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(this, "Chọn Dòng cần xóa!");
			}
			else {
			String maXoa = tbmodel.getValueAt(row,0).toString();
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION){
					if(daoCT.xoaCongTrinh(maXoa)){
						JOptionPane.showMessageDialog(this, "Xóa thành công!");
						tbmodel.setRowCount(0);
						updateTableData();
					}
				}
			}
		}
		else if(object.equals(btnPhanCong)) {
			phanCongLD.setVisible(true);
		}
	}
	
	
	
	public void updateTableData(){
		daoCT = new DAO_CongTrinh();
		ArrayList<CongTrinh> dsCT = daoCT.layTatCaCongTrinh(); // lay danh sach nld
		for (CongTrinh ct : dsCT) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String ngayCP = df.format(ct.getNgayCapPhep());
			String ngayKC = df.format(ct.getNgayKhoiCong());
			String ngayHT = df.format(ct.getNgayHoanThanhDuKien());
			String [] row = {ct.getMaCT(),ct.getTenCT(),ct.getDiaDiemCT(),ngayCP,ngayKC,ngayHT};
			tbmodel.addRow(row);
		}
		tableCongTrinh.setModel(tbmodel);
 	}
}

