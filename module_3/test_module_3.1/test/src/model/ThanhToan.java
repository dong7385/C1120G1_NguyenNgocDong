package model;

public class ThanhToan {
    private int hinhThucThanhToanId;
    private String hinhThucThanhToanTen;

    public ThanhToan() {
    }

    public ThanhToan(int hinhThucThanhToanId, String hinhThucThanhToanTen) {
        this.hinhThucThanhToanId = hinhThucThanhToanId;
        this.hinhThucThanhToanTen = hinhThucThanhToanTen;
    }

    public int getHinhThucThanhToanId() {
        return hinhThucThanhToanId;
    }

    public void setHinhThucThanhToanId(int hinhThucThanhToanId) {
        this.hinhThucThanhToanId = hinhThucThanhToanId;
    }

    public String getHinhThucThanhToanTen() {
        return hinhThucThanhToanTen;
    }

    public void setHinhThucThanhToanTen(String hinhThucThanhToanTen) {
        this.hinhThucThanhToanTen = hinhThucThanhToanTen;
    }
}
