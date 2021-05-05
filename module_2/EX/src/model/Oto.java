package model;

public class Oto extends Xe{
    private String soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(String soChoNgoi, String kieuXe) {
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public Oto(String bienKiemSoat, String tenHangSanXuat, String namSanXuat, String chuSanXuat, String soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSanXuat);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }
    public Oto(String []oto) {
        super(oto[0], oto[1], oto[2], oto[3]);
        this.soChoNgoi = oto[4];
        this.kieuXe = oto[5];
    }

    public Oto(String[] xe, String soChoNgoi, String kieuXe) {
        super(xe);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    @Override
    public void showInFor() {
        System.out.println(" \"Oto{\" +\n" +
                "                \"soChoNgoi='\" + soChoNgoi + '\\'' +\n" +
                "                \", kieuXe='\" + kieuXe + '\\'' +\n" +
                "                \"} \" + super.toString();");
    }

    @Override
    public String toString() {
        return super.toString()+","+soChoNgoi+","+kieuXe;
    }
}
