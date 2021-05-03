drop database case_study_module4;
use case_study_module4;
insert into customer_type(customer_type_name)
values('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Members');
insert into customer(customer_id,customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone,customer_email, customer_address)
values	('KH-1',3, 'Lý liên Kiệt','1995/04/05', 1, '345345345', 0908111222, 'lylienkiet@gmail.com','MY'),
		('KH-2',3, 'Trương Tam Phong', '2000/03/05', 1, '111222333', 0908111333, 'trungtamphong@gmail.com', 'Nhat'),
		('KH-3',2, 'Trương Vô Kị', '2001/11/11', 1, '343444555', 0908111444, 'truongvoki@gmail.com', 'Anh'),
		('KH-4',1, 'Hồng Liên Quang', '2001/04/05', 0, '111111111', 0908111545, 'honglienquang@gmail.com', 'Phap'),
		('KH-5',2,'Phương Thế Ngọc', '1994/12/12', 0, '020202021', 0908111666,'phuongthengoc@gmail.com','Viet Nam'),
        ('KH-6', 4,'Lý Mạc Sầu', '1986/12/12', 1, '027699843', 0976798223,'lymacsau@gmail.com','Thai Lan');