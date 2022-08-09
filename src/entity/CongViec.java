package entity;

import java.util.ArrayList;

public class CongViec {
	private String maCV;
	private String tenCV;
	private CongTrinh congTrinh;
	private String trangThai;
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public String getTenCV() {
		return tenCV;
	}
	public void setTenCV(String tenCV) {
		this.tenCV = tenCV;
	}
	public CongTrinh getCongTrinh() {
		return congTrinh;
	}
	public void setCongTrinh(CongTrinh congTrinh) {
		this.congTrinh = congTrinh;
	}
	

	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public CongViec(String maCV, String tenCV, CongTrinh congTrinh,String trangThai) {
		super();
		this.maCV = maCV;
		this.tenCV = tenCV;
		this.congTrinh = congTrinh;
		this.trangThai = trangThai;
	}
	public CongViec(String maCV) {
		super();
		this.maCV = maCV;
	}
	public CongViec() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCV == null) ? 0 : maCV.hashCode());
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
		CongViec other = (CongViec) obj;
		if (maCV == null) {
			if (other.maCV != null)
				return false;
		} else if (!maCV.equals(other.maCV))
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
