use case_study;
/*2.	Hiển thị thông tin của tất cả nhân viên có
 trong hệ thống có tên bắt đầu là một trong các ký tự 
“H”, “T” hoặc “K” và có tối đa 15 ký tự.*/

select *
from NhanVien
where hoTen like'%K%';

SELECT 
    *
FROM
    NhanVien
WHERE
    hoTen LIKE '%K%' OR hoTen LIKE '%K%'
        OR hoTen LIKE '%K%'
        AND CHAR_LENGTH(hoTen) < 15
;
/*task 3.Hiển thị thông tin của tất cả khách hàng có 
độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/

select * 
from KhachHang
where (timestampdiff(YEAR, ngaySinh, curdate())>18 or timestampdiff(YEAR, ngaySinh, curdate())<50)
and diaChi in ('Huế','Quảng Trị')
;
/*task 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
*/

SELECT 
    KhachHang.hoTen,
    COUNT(HopDong.idHopDong) AS so_lan_dat_phong
FROM
    KhachHang
        INNER JOIN
    HopDong ON KhachHang.idKhachHang = HopDong.idKhachHang
WHERE
    KhachHang.idLoaiKhach = 1
GROUP BY KhachHang.idKhachHang
ORDER BY so_lan_dat_phong;

/*task 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từ ng đặt phòng cũng phải hiển thị ra).*/

SELECT 
    KhachHang.idLoaiKhach,
    KhachHang.hoTen,
    LoaiKhach.tenLoaiKhach,
    HopDong.idHopDong,
    DichVu.idDichVu,
    HopDong.ngayLamHopDong,
    HopDong.ngayKetThuc,
    SUM(DichVu.chiPhiThue + HopDongChiTiet.soLuong * DichVuDiKem.gia) AS Tong_tien
FROM
    KhachHang
        LEFT JOIN
    LoaiKhach ON KhachHang.idLoaiKhach = LoaiKhach.idLoaiKhach
        LEFT JOIN
    HopDong ON KhachHang.idKhachHang = HopDong.idKhachHang
        LEFT JOIN
    DichVu ON HopDong.idDichVu = DichVu.idDichVu
        LEFT JOIN
    HopDongChiTiet ON HopDong.idHopDong = HopDongChiTiet.idHopDong
        LEFT JOIN
    DichVuDiKem ON HopDongChiTiet.idDichVuDiKem = DichVuDiKem.idDichVuDiKem
GROUP BY HopDong.idHopDong
ORDER BY KhachHang.idKhachHang;

/* task 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 
của năm 2019 (Quý 1 là tháng 1, 2, 3).*/

select DichVu.IdDichVu, tenDichVu, dienTich, chiPhiThue, LoaiDichVu.tenLoaiDichVu,HopDong.ngayLamHopDong
from DichVu
left join LoaiDichVu on DichVu.idLoaiDichVu=LoaiDichVu.idLoaiDichVu
left join HopDong on DichVu.idDichVu=HopDong.idDichVu
where (year(HopDong.ngayLamHopDong)<=2019) and month(HopDong.ngayLamHopDong) in (1,2,3) ;

/*task 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
nhưng chưa từng được Khách hàng đặt phòng trong năm 2019.*/

SELECT 
    DichVu.idDichVu,
    tenDichVu,
    dienTich,
    soNguoiToiDa,
    chiPhiThue,
    LoaiDichVu.tenLoaiDichVu,
    HopDong.ngayLamHopDong
FROM
    DichVu
        LEFT JOIN
    LoaiDichVu ON DichVu.idLoaiDichVu = LoaiDichVu.idLoaiDichVu
        LEFT JOIN
    HopDong ON DichVu.idDichVu = HopDong.idDichVu
WHERE
    (YEAR(HopDong.ngayLamHopDong) = 2018)
        AND NOT YEAR(HopDong.ngayLamHopDong) = 2019;

/*task8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, 
với yêu cầu HoTenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên*/

select distinct KhachHang.hoTen
from KhachHang;

select  KhachHang.hoTen
from KhachHang
group by KhachHang.hoTen;

/*task 9.	Thực hiện thống kê doanh thu theo tháng, 
nghĩa là tương ứng với mỗi tháng trong năm 2019 
thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/

select month(HopDong.ngayLamHopDong) as soThang, count(month(HopDong.ngayLamHopDong)) as SoKhachHangDatPhong
from HopDong
where year(HopDong.ngayLamHopDong)=2019
group by month(HopDong.ngayLamHopDong);

/*10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
(được tính dựa trên việc count các IDHopDongChiTiet).
*/

SELECT 
    HopDong.idHopDong,
    HopDong.ngayLamHopDong,
    HopDong.ngayKetthuc,
    HopDong.tienDatCoc,
    COUNT(HopDongChiTiet.idDichVuDiKem) AS so_luong_dung_dich_vu_di_kem
FROM
    HopDong
        LEFT JOIN
    HopDongChiTiet ON HopDong.idHopDong = HopDongChiTiet.idHopDong
        LEFT JOIN
    DichVuDiKem ON HopDongChiTiet.idDichVuDiKem = DichVuDiKem.idDichVuDiKem
GROUP BY HopDong.idHopDong;

/*11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng
 có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/
 
 
