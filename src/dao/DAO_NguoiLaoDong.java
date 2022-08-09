package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;

import entity.NguoiLaoDong;
import entity.PhongBan;

public class DAO_NguoiLaoDong {
	private DAO_PhongBan daoPB;
	/**
	 * Ham lay tat ca danh sach nguoi lao dong
	 * @return
	 */
	public ArrayList<NguoiLaoDong> layTatCaNLD(){
		ArrayList<NguoiLaoDong> dsNLD = new ArrayList<NguoiLaoDong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NguoiLaoDong ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maNLD = rs.getString(1);
				String tenNLD = rs.getString(2);
				String ngaySinh = rs.getString(3);
				boolean gioiTinh = rs.getBoolean(4);
				String chucVu = rs.getString(5);
				PhongBan phongBan = new PhongBan(rs.getString(6));
				NguoiLaoDong nld = new NguoiLaoDong(maNLD, tenNLD, ngaySinh, gioiTinh, chucVu, phongBan);
				dsNLD.add(nld);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNLD;
	}
	/**
	 * lay danh sach nguoi lao dong theo ma
	 * @param maNLD1 
	 * @return
	 */
	public ArrayList<NguoiLaoDong> layNLDTheoMa(String maNLD1){
		ArrayList<NguoiLaoDong> dsNLD = new ArrayList<NguoiLaoDong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NguoiLaoDong where maNLD = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maNLD1);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maNLD = rs.getString(1);
				String tenNLD = rs.getString(2);
				String ngaySinh = rs.getString(3);
				boolean gioiTinh = rs.getBoolean(4);
				String chucVu = rs.getString(5);
				PhongBan phongBan = new PhongBan(rs.getString(6));
				NguoiLaoDong nld = new NguoiLaoDong(maNLD, tenNLD, ngaySinh, gioiTinh, chucVu, phongBan);
				dsNLD.add(nld);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNLD;
	}
	/**
	 * Them vao 1 nguoi lao dong
	 * @return
	 */
	public boolean themNLD(NguoiLaoDong nld) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into NguoiLaoDong values(?,?,?,?,?,?)";
		int n =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, nld.getMaNLD());
			preparedStatement.setString(2, nld.getTenNLD());
			preparedStatement.setString(3, nld.getNgaySinh());
			preparedStatement.setBoolean(4, nld.getGioiTinh());
			preparedStatement.setString(5, nld.getChucVu());
			preparedStatement.setString(6, nld.getPhongBan().getMaPhongBan());

			n = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	/**
	 * Sua thong tin NLD
	 * @return
	 */
	public boolean suaNLD(NguoiLaoDong nld) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		daoPB = new DAO_PhongBan();
		String sql = "update NguoiLaoDong set tenNLD=?, ngaySinh=?, gioiTinh=?,chucVu=?,maPhongBan=? where maNLD=?";
		int n =0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, nld.getTenNLD());
			preparedStatement.setString(2, nld.getNgaySinh());
			preparedStatement.setBoolean(3, nld.getGioiTinh());
			preparedStatement.setString(4, nld.getChucVu());
			
			preparedStatement.setString(5, nld.getPhongBan().getMaPhongBan());
			preparedStatement.setString(6, nld.getMaNLD());
			n = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	/**
	 * xoa nguoi lao dong
	 * @param maNLD
	 * @return
	 */
	public boolean xoaNLD(String maNLD) {
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from NguoiLaoDong where maNLD = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maNLD);
			n = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n>0;
	}
	
}
	


