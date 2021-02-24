package model;

public class NnKhachHang extends KhachHang {
    private String quocTich;

    public NnKhachHang() {
    }

    public NnKhachHang(String maKhachHang, String hoten, String quocTich) {
        super(maKhachHang, hoten);
        this.quocTich = quocTich;
    }

    public NnKhachHang(String []nnKhachHang) {
        super(nnKhachHang[0], nnKhachHang[1]);
        this.quocTich = nnKhachHang[2];
    }

    @Override
    public String toString() {
        return super.toString()+","+quocTich ;
    }

    @Override
    public void showInfor() {
        System.out.println("NnKhachHang{" + super.toString()+
                "quocTich='" + quocTich + '\'' +
                "} ");
    }
}
