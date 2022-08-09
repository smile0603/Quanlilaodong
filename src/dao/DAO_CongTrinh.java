package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CongTrinh;


public class DAO_CongTrinh {
	/**
	 * Ham lay tat ca danh sach cong trinh
	 * @return
	 */
	public ArrayList<CongTrinh> layTatCaCongTrinh(){
		ArrayList<CongTrinh> dsCT = new ArrayList<CongTrinh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from CongTrinh ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maCT = rs.getString(1);
				String tenCT = rs.getString(2);
				String diaDiemCT = rs.getString(3);
				Date ngayCapPhep = rs.getDate(4);
				Date ngayKhoiCong = rs.getDate(5);
				Date ngayHoanThanh = rs.getDate(6);
				CongTrinh ct = new CongTrinh(maCT, tenCT, diaDiemCT, ngayCapPhep, ngayKhoiCong, ngayHoanThanh);
				dsCT.add(ct);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCT;
	}
	/**
	 * lay danh sach Cong Trinh theo ma
	 * @param maNLD1 
	 * @return
	 */
	public ArrayList<CongTrinh> layNLDTheoMa(String maCT1){
		ArrayList<CongTrinh> dsCT = new ArrayList<CongTrinh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from CongTrinh where maCT = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maCT1);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maCT = rs.getString(1);
				String tenCT = rs.getString(2);
				String diaDiemCT = rs.getString(3);
				Date ngayCapPhep = rs.getDate(4);
				Date ngayKhoiCong = rs.getDate(5);
				Date ngayHoanThanh = rs.getDate(6);
				CongTrinh ct = new CongTrinh(maCT, tenCT, diaDiemCT, ngayCapPhep, ngayKhoiCong, ngayHoanThanh);
				dsCT.add(ct);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCT;
	}
	/**
	 * Them vao 1 cong trinh
	 * @return
	 */
	public boolean themCongTrinh(CongTrinh ct) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into CongTrinh values(?,?,?,?,?,?)";
		int n =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, ct.getMaCT());
			preparedStatement.setString(2, ct.getTenCT());
			preparedStatement.setString(3, ct.getDiaDiemCT());
			preparedStatement.setDate(4, ct.getNgayCapPhep());
			preparedStatement.setDate(5, ct.getNgayKhoiCong());
			preparedStatement.setDate(6, ct.getNgayHoanThanhDuKien());

			n = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	/**
	 * Sua thong tin CT
	 * @return
	 */
	public boolean suaCongTrinh(CongTrinh ct) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "update CongTrinh set tenCT=?, diaDiemCT=?, ngayCapPhep=?,ngayKhoiCong=?,ngayHoanThanhDuKien=? where maCT=?";
		int n =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, ct.getTenCT());
			preparedStatement.setString(2, ct.getDiaDiemCT());
			preparedStatement.setDate(3, ct.getNgayCapPhep());
			preparedStatement.setDate(4, ct.getNgayKhoiCong());
			preparedStatement.setDate(5, ct.getNgayHoanThanhDuKien());
			preparedStatement.setString(6, ct.getMaCT());
			n = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	/**
	 * xoa cong trinh
	 * @param maCT
	 * @return
	 */
	public boolean xoaCongTrinh(String maCT) {
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from CongTrinh where maCT = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maCT);
			n = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n>0;
	}
	
}
	


