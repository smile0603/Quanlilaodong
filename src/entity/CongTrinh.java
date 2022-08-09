package entity;

import java.sql.Date;

public class CongTrinh {
	private String maCT;
	private String tenCT;
	private String diaDiemCT;
	private Date ngayCapPhep;
	private Date ngayKhoiCong;
	private Date ngayHoanThanhDuKien;
	public String getMaCT() {
		return maCT;
	}
	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}
	public String getTenCT() {
		return tenCT;
	}
	public void setTenCT(String tenCT) {
		this.tenCT = tenCT;
	}
	public String getDiaDiemCT() {
		return diaDiemCT;
	}
	public void setDiaDiemCT(String diaDiemCT) {
		this.diaDiemCT = diaDiemCT;
	}
	
	
	public Date getNgayCapPhep() {
		return ngayCapPhep;
	}
	public void setNgayCapPhep(Date ngayCapPhep) {
		this.ngayCapPhep = ngayCapPhep;
	}
	public Date getNgayKhoiCong() {
		return ngayKhoiCong;
	}
	public void setNgayKhoiCong(Date ngayKhoiCong) {
		this.ngayKhoiCong = ngayKhoiCong;
	}
	public Date getNgayHoanThanhDuKien() {
		return ngayHoanThanhDuKien;
	}
	public void setNgayHoanThanhDuKien(Date ngayHoanThanhDuKien) {
		this.ngayHoanThanhDuKien = ngayHoanThanhDuKien;
	}
	public CongTrinh() {
		super();
	}
	public CongTrinh(String maCT) {
		super();
		this.maCT = maCT;
	}
	
	
	public CongTrinh(String maCT, String tenCT, String diaDiemCT, Date ngayCapPhep, Date ngayKhoiCong,
			Date ngayHoanThanhDuKien) {
		super();
		this.maCT = maCT;
		this.tenCT = tenCT;
		this.diaDiemCT = diaDiemCT;
		this.ngayCapPhep = ngayCapPhep;
		this.ngayKhoiCong = ngayKhoiCong;
		this.ngayHoanThanhDuKien = ngayHoanThanhDuKien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCT == null) ? 0 : maCT.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongTrinh other = (CongTrinh) obj;
		if (maCT == null) {
			if (other.maCT != null)
				return false;
		} else if (!maCT.equals(other.maCT))
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
