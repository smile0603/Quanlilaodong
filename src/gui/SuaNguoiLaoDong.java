package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_NguoiLaoDong;
import dao.DAO_PhongBan;
import entity.NguoiLaoDong;
import entity.PhongBan;

public class SuaNguoiLaoDong extends JFrame implements ActionListener, MouseListener{
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JDateChooser date_ngaySinh;
	private JRadioButton rdPhaiNam;
	private JRadioButton rdPhaiNu;
	private JComboBox cbChucVu;
	private JComboBox cbPhongBan;

	private JButton btnXoa;
	private JButton btnThoat;
	private JTextField txtMess;
	private DAO_PhongBan daoPB;
	private DAO_NguoiLaoDong daoLD;
	private JButton btnSua;
	
	public SuaNguoiLaoDong() throws Exception {
		// TODO Auto-generated constructor stub
		
		setBounds(100, 100, 850, 498);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTieuDe = new JLabel("Cập nhật thông tin người lao động");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTieuDe.setBounds(211, 11, 398, 35);
		getContentPane().add(lblTieuDe);
		
		txtMess = new JTextField();
		txtMess.setBounds(20,40 , 300, 20);
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(txtMess);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 54, 814, 383);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân Viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 29, 108, 35);
		panel_1.add(lblNewLabel);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(153, 29, 616, 34);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);
		txtMaNV.setEditable(false);
		JLabel lblTnNhnVin = new JLabel("Tên Nhân Viên:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnNhnVin.setBounds(23, 87, 119, 35);
		panel_1.add(lblTnNhnVin);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(153, 89, 616, 34);
		panel_1.add(txtTenNV);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgySinh.setBounds(23, 154, 108, 35);
		panel_1.add(lblNgySinh);
		
		date_ngaySinh = new JDateChooser();
		date_ngaySinh.setBounds(153, 154, 289, 35);
		panel_1.add(date_ngaySinh);
		
		
		JLabel lblPhi = new JLabel("Phái:");
		lblPhi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhi.setBounds(470, 154, 78, 35);
		panel_1.add(lblPhi);
		
		rdPhaiNam = new JRadioButton("Nam");
		rdPhaiNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdPhaiNam.setBounds(555, 160, 59, 23);
		panel_1.add(rdPhaiNam);
		
		rdPhaiNu = new JRadioButton("Nữ");
		rdPhaiNu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdPhaiNu.setBounds(637, 157, 70, 29);
		panel_1.add(rdPhaiNu);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdPhaiNu);
		bg.add(rdPhaiNam);
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChcV.setBounds(23, 225, 108, 35);
		panel_1.add(lblChcV);
		
		cbChucVu = new JComboBox();
		cbChucVu.setBounds(153, 225, 198, 30);
		cbChucVu.addItem("Nhân Viên");
		cbChucVu.addItem("Quản Lý");
		panel_1.add(cbChucVu);
		
		JLabel lblPhngBan = new JLabel("Phòng ban:");
		lblPhngBan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhngBan.setBounds(410, 225, 108, 35);
		panel_1.add(lblPhngBan);
		
		cbPhongBan = new JComboBox();
		cbPhongBan.setBounds(543, 229, 198, 30);
		panel_1.add(cbPhongBan);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 297, 794, 75);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(82, 24, 133, 40);
		panel_2.add(btnSua);
		
		btnXoa = new JButton("Xóa rỗng");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(316, 24, 133, 40);
		panel_2.add(btnXoa);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(570, 24, 133, 40);
		panel_2.add(btnThoat);
		
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		daoLD = new DAO_NguoiLaoDong();
		
		//Add Combobox phong ban
		ConnectDB.getInstance().connect();
		updateComboBox();

		
	}
	public static void main(String[] args) throws Exception {
		new SuaNguoiLaoDong().setVisible(true);
	}
	public void getNguoiLaoDongTheoMa(String ma) throws ParseException {
		ArrayList<NguoiLaoDong> dsNLD = daoLD.layNLDTheoMa(ma);
		
		for (NguoiLaoDong nguoiLaoDong : dsNLD) {
			txtMaNV.setText(ma);
			txtTenNV.setText(nguoiLaoDong.getTenNLD());
			String s = nguoiLaoDong.getNgaySinh();
			if(nguoiLaoDong.getGioiTinh() == true) {
				rdPhaiNam.setSelected(true);
			}else {
				rdPhaiNu.setSelected(true);
			}
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
			date_ngaySinh.setDate(date);
			cbChucVu.setSelectedItem(nguoiLaoDong.getChucVu());
			cbPhongBan.setSelectedItem(nguoiLaoDong.getPhongBan().toString());
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			this.dispose();
		}
		else if(o.equals(btnXoa)) {
			xoaRongTextfields();
		}
		else if(o.equals(btnSua)) {
			if(validData()) {
				NguoiLaoDong nld = reverseNLDFromTxtField();
				if(daoLD.suaNLD(nld)) {
					JOptionPane.showMessageDialog(this,"Sửa thành công");
					updateComboBox();
					try {
						new QuanLyLaoDong().setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					this.dispose();
				}
			}
		}
	}
	
	private void xoaRongTextfields() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		date_ngaySinh.setCalendar(null);
		
	}
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	
	private boolean validData() {
		String maLD = txtMaNV.getText().trim();
		String tenLD = txtTenNV.getText().trim();
		String ngaySinh = ((JTextField)date_ngaySinh.getDateEditor().getUiComponent()).getText();
		//Mã NLD gồm 4 chữ cái và 2 chữ số vd NVTC12
		if (!(maLD.length() > 0 && maLD.matches("[A-Z]{4}\\d{2}"))) {
			showMessage("Error: Mã NLD gồm 4 chữ cái và 2 chữ số!", txtMaNV);
			return false;
		}
		if (!(tenLD.length() > 0 && tenLD.matches("[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+"))) {
			showMessage("Error: Tên NLD gồm chữ và số", txtTenNV);
			return false;
		}
		if (ngaySinh.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh", "Warning!", JOptionPane.ERROR_MESSAGE);
		    return false;
		}
		return true;
	}
	
	public NguoiLaoDong reverseNLDFromTxtField(){
		String maNLD = txtMaNV.getText().trim();
		String tenNLD = txtTenNV.getText();
		String s = ((JTextField)date_ngaySinh.getDateEditor().getUiComponent()).getText();
		String chucVu = cbChucVu.getSelectedItem().toString();
		String pb = cbPhongBan.getSelectedItem().toString();
		NguoiLaoDong ld = new NguoiLaoDong(maNLD, tenNLD, s, true, chucVu, new PhongBan(pb));
		return ld;
		
	}
	
	private void updateComboBox() {
		daoPB = new DAO_PhongBan();
		ArrayList<PhongBan> dsPB = daoPB.layTatPhongBan();
		for (PhongBan pb : dsPB) {
			cbPhongBan.addItem(pb.getTenPhongBan());
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
