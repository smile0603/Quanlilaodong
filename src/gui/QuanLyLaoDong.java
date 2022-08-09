package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
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

import dao.DAO_NguoiLaoDong;

import entity.NguoiLaoDong;

public class QuanLyLaoDong extends JFrame implements ActionListener{
	
	

	private JTable tableLaoDong;
	private JTextField txtTimLD;
	private JButton btnTimLD;
	
	private JButton btnThemLD;
	
	private JButton btnXoaLD;
	private ThemLaoDong themLD;
	private DAO_NguoiLaoDong daoLD;
	private DefaultTableModel tbmodel;
	private JButton btnSuaLD;
	private SuaNguoiLaoDong suaLD;
	private JButton btnThoat;

	public QuanLyLaoDong() throws Exception {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 994, 602);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Quản lí lao động");
		lblNewLabel.setBounds(279, 0, 400, 40);
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
		String col[] = {"Mã Nhân Viên","Tên Nhân Viên","Ngày sinh","Giới tính","Chức Vụ","Phòng Ban"};
		tbmodel = new DefaultTableModel(col,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tableLaoDong = new JTable(tbmodel);
		scrollPane.setViewportView(tableLaoDong);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm lao động theo mã:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 18, 169, 24);
		panel.add(lblNewLabel_1);
		
		txtTimLD = new JTextField();
		txtTimLD.setBounds(10, 53, 128, 35);
		panel.add(txtTimLD);
		txtTimLD.setColumns(10);
		
		btnTimLD = new JButton("Tìm");
		btnTimLD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimLD.setBounds(148, 53, 89, 35);
		panel.add(btnTimLD);
		
		btnThemLD = new JButton("Thêm mới lao động");
		btnThemLD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemLD.setBounds(10, 119, 227, 46);
		panel.add(btnThemLD);
		
		btnXoaLD = new JButton("Xóa lao động");
		btnXoaLD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaLD.setBounds(10, 201, 227, 46);
		panel.add(btnXoaLD);
		
		
		btnSuaLD = new JButton("Sửa Thông tin lao động");
		btnSuaLD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSuaLD.setBounds(10, 282, 227, 46);
		panel.add(btnSuaLD);
		
		btnThoat= new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(10, 369, 227, 46);
		panel.add(btnThoat);
		
		btnThemLD.addActionListener(this);
		btnXoaLD.addActionListener(this);
		
		
		btnThoat.addActionListener(this);
		btnSuaLD.addActionListener(this);
		btnTimLD.addActionListener(this);
		themLD = new ThemLaoDong();
		suaLD = new SuaNguoiLaoDong();
		// Nạp toàn bộ bảng lên 
		ConnectDB.getInstance().connect();
		updateTableData();
		
		
	}
	public static void main(String[] args) throws Exception {
		new QuanLyLaoDong().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if(object.equals(btnThemLD)) {
			themLD.setVisible(true);
			this.dispose();
		}
		//Xóa
		else if(object.equals(btnXoaLD)) {
			int row=tableLaoDong.getSelectedRow();
			
			if(row == -1){
				JOptionPane.showMessageDialog(this, "Chọn Dòng cần xóa!");
			}
			else {
				String maXoa = tbmodel.getValueAt(row,0).toString();
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION){
					if(daoLD.xoaNLD(maXoa)){
						JOptionPane.showMessageDialog(this, "Xóa thành công!");
						tbmodel.setRowCount(0);
						updateTableData();
					}
				}
			}
				
		}
		//Sửa
		else if(object.equals(btnSuaLD)) {
			int row=tableLaoDong.getSelectedRow();
			
			
			//ArrayList<NguoiLaoDong> dsLD = daoLD.layNLDTheoMa(maSua);
			if(row == -1){
				JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
			}
			else {
				String maSua = tbmodel.getValueAt(row,0).toString();
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn sửa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION){
					
					suaLD.setVisible(true);
					try {
						suaLD.getNguoiLaoDongTheoMa(maSua);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					this.dispose();
				}
			}
		}
		//thoát
		else if(object.equals(btnThoat)) {
			this.dispose();
		}
		//tìm
		else if(object.equals(btnTimLD)) {
			String maTim = txtTimLD.getText().trim();
			tbmodel.setRowCount(0);
			
			txtTimLD.setText("");
			for (NguoiLaoDong ld : daoLD.layNLDTheoMa(maTim)) {
				String gt = ld.getGioiTinh() == true ? "Nam" : "Nữ";
				String [] row = {ld.getMaNLD(),ld.getTenNLD(),ld.getNgaySinh(),gt,ld.getChucVu(),ld.getPhongBan().getMaPhongBan()};
				tbmodel.addRow(row);
			}
			tableLaoDong.setModel(tbmodel);
		}
		
		
		
				
}
	public void updateTableData(){
		daoLD = new DAO_NguoiLaoDong();
		ArrayList<NguoiLaoDong> dsLD = daoLD.layTatCaNLD(); // lay danh sach nld
		
		for (NguoiLaoDong ld : dsLD) {
			String gt = ld.getGioiTinh() == true ? "Nam" : "Nữ";
			String [] row = {ld.getMaNLD(),ld.getTenNLD(),ld.getNgaySinh(),gt,ld.getChucVu(),ld.getPhongBan().getMaPhongBan()};
			tbmodel.addRow(row);
		}
		tableLaoDong.setModel(tbmodel);
 	}
}
