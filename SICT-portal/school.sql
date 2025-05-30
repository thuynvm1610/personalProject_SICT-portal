create database school
character set utf8mb4
collate utf8mb4_unicode_ci;
use school;

create table teacher (
    teacherID varchar(30) primary key,
    name varchar(100) not null,
    gender enum('Nam','Nữ') not null,
    dob date not null,
    email varchar(100) unique not null
);

create table classroom (
    classroomID varchar(30) primary key,
    name varchar(100) not null,
    teacherID varchar(30) not null,
	constraint fk_class_teacherID foreign key (teacherID) references teacher(teacherID) on delete cascade
);

create table student (
    studentID varchar(30) primary key,
    name varchar(100) not null,
    gender enum('Nam','Nữ') not null,
    dob date not null,
    email varchar(100) unique not null,
    hometown varchar(100)
);

create table student_classroom (
    classroomID varchar(30),
    studentID varchar(30),
    constraint pk_student_classroom primary key (studentID, classroomID),
    constraint fk_student_classroom_studentID foreign key (studentID) references student(studentID) on delete cascade,
    constraint fk_student_classroom_classroomID foreign key (classroomID) references classroom(classroomID) on delete cascade
);

create table account (
    accountID varchar(30) primary key,
    username varchar(50) unique not null,
    password varchar(255) not null,
    role enum('admin','student') not null,
    studentID varchar(30),
    constraint fk_account_studentID foreign key (studentID) references student(studentID) on delete cascade,
    constraint ck_studentID_role check ((role = 'admin' and studentID is null) or (role = 'student' and studentID is not null))
);

insert into teacher values
('GV_001','Nguyễn Thống Nhất','Nam','1975-04-30','nhatnt3004@gmail.com'),
('GV_002','Nguyễn Văn Hải','Nam','1980-02-27','hainv2702@gmail.com'),
('GV_003','Trần Huyền Trang','Nữ','1985-12-14','trangth1412@gmail.com'),
('GV_004','Nguyễn Thị Minh Nguyệt','Nữ','1997-09-24','nguyetntm2409@gmail.com'),
('GV_005','Phùng Thanh Độ','Nam','1996-01-02','dopt0201@gmail.com');

insert into classroom values
('QLDACNTT_01','Quản lý dự án công nghệ thông tin','GV_001'),
('LTJW_01','Lập trình Java Web','GV_001'),
('LTJW_02','Lập trình Java Web','GV_002'),
('TKW_01','Thiết kế Web','GV_002'),
('HQTCSDL_01','Hệ quản trị cơ sở dữ liệu','GV_002'),
('HQTCSDL_02','Hệ quản trị cơ sở dữ liệu','GV_003'),
('TTNM_01','Tương tác người máy','GV_004'),
('CNDPT_01','Công nghệ đa phương tiện','GV_004'),
('CNDPT_02','Công nghệ đa phương tiện','GV_005'),
('PTNV_01','Phân tích nghiệp vụ','GV_005');

insert into student values 
('SV_0001','Nguyễn Văn Minh Thủy','Nam','2004-10-16','thuynvm1610@gmail.com','Hải Dương'),
('SV_0002','Phạm Thị Hồng Duyên','Nữ','2004-05-10','duyenpth1005@gmail.com','Nam Định'),
('SV_0003','Tô Phương Thảo','Nữ','2004-07-21','thaotp2107@gmail.com','Bắc Giang'),
('SV_0004','Hồ Thị Phương','Nữ','2004-03-04','phuonght0403@gmail.com','Nghệ An'),
('SV_0005','Hoàng Nhật Trung','Nam','2004-12-27','trunghn2712@gmail.com','Nghệ An'),
('SV_0006','Tăng Mạnh Đạt','Nam','2004-01-17','dattm1701@gmail.com','Thanh Hóa'),
('SV_0007','Phạm Trí Định','Nam','2004-11-17','dinhpt1711@gmail.com','Bắc Giang'),
('SV_0008','Hoàng Thu Hằng','Nữ','2004-06-05','hanght0506@gmail.com','Ninh Bình'),
('SV_0009','Nguyễn Thùy Trang','Nữ','2004-09-09','trangnt0909@gmail.com','Hải Dương'),
('SV_0010','Nguyễn Thị Hồng Ngọc','Nữ','2004-12-11','ngocnth1112@gmail.com','Bắc Ninh'),
('SV_0011','Nguyễn Thanh Bảo','Nam','2005-10-18','baont1810@gmail.com','Hà Nội'),
('SV_0012','Nguyễn Văn Quang','Nam','2005-02-09','quangnv0902@gmail.com','Hải Phòng'),
('SV_0013','Dương Danh Hiếu','Nam','2005-09-27','hieudd2709@gmail.com','Hà Nam'),
('SV_0014','Trần Văn Thắng','Nam','2005-03-12','thangtv1203@gmail.com','Thái Bình'),
('SV_0015','Lê Anh Tạo','Nam','2005-10-10','taola1010@gmail.com','Hà Nội'),
('SV_0016','Đỗ Trọng Hoàng','Nam','2005-12-11','hoangdt1112@gmail.com','Thái Nguyên'),
('SV_0017','Tống Đăng Quang','Nam','2005-07-17','quangtd1707@gmail.com','Hải Phòng'),
('SV_0018','Cù Minh Hải','Nam','2005-01-01','haicm0101@gmail.com','Hà Nội'),
('SV_0019','Nguyễn Thành Công','Nam','2005-04-20','congnt2004@gmail.com','Hưng Yên'),
('SV_0020','Phạm Thị Phương','Nữ','2005-07-15','phuongpt1507@gmail.com','Nam Định'),
('SV_0021','Lê Thị Thảo','Nữ','2006-10-09','thaolt0910@gmail.com','Vĩnh Phúc'),
('SV_0022','Nguyễn Đặng Hải Quân','Nam','2006-11-11','quanndh1111@gmail.com','Nghệ An'),
('SV_0023','Nguyễn Thị My','Nữ','2006-12-19','mynguyen1912@gmail.com','Phú Thọ'),
('SV_0024','Đỗ Đức Nhật','Nam','2006-02-16','nhatdd1602@gmail.com','Hòa Bình'),
('SV_0025','Nguyễn Hữu Hưởng','Nam','2006-09-05','huongnh0509@gmail.com','Quảng Ninh'),
('SV_0026','Lê Tuấn Minh','Nam','2006-08-10','minhlt1008@gmail.com','Bắc Giang'),
('SV_0027','Nghiêm Đình Việt','Nam','2006-05-16','vietnd1605@gmail.com','Hà Nội'),
('SV_0028','Nguyễn Viết Nam','Nam','2006-04-23','namnv2304@gmail.com','Hà Nội'),
('SV_0029','Nguyễn Thanh Tùng','Nam','2006-11-16','tungnt1611@gmail.com','Ninh Bình'),
('SV_0030','Hồ Quốc Anh Tùng','Nam','2006-12-12','tunghaq1212@gmail.com','Thanh Hóa');

insert into student_classroom values 
('LTJW_01', 'SV_0001'),
('QLDACNTT_01', 'SV_0001'),
('TKW_01', 'SV_0001'),
('HQTCSDL_01', 'SV_0002'),
('CNDPT_01', 'SV_0002'),
('TKW_01', 'SV_0002'),
('HQTCSDL_01', 'SV_0003'),
('QLDACNTT_01', 'SV_0003'),
('TKW_01', 'SV_0003'),
('LTJW_01', 'SV_0003');

insert into account values 
('TK_0001','ThuyNguyen1610','thuynguyen1610','student','SV_0001'),
('TK_0002','DuyenPham1005','duyenpham1005','student','SV_0002'),
('TK_0003','ThaoTo2107','thaoto2107','student','SV_0003'),
('TK_0004','PhuongHo0403','phuongho0403','student','SV_0004'),
('TK_0005','TrungHoang2712','trunghoang2712','student','SV_0005'),
('TK_0006','DatTang1701','dattang1701','student','SV_0006'),
('TK_0007','DinhPham1711','dinhpham1711','student','SV_0007'),
('TK_0008','HangHoang0506','hanghoang0506','student','SV_0008'),
('TK_0009','TrangNguyen0909','trangnguyen0909','student','SV_0009'),
('TK_0010','NgocNguyen1112','ngocnguyen1112','student','SV_0010'),
('TK_0011','BaoNguyen1810','baonguyen1810','student','SV_0011'),
('TK_0012','QuangNguyen0902','quangnguyen0902','student','SV_0012'),
('TK_0013','HieuDuong2709','hieuduong2709','student','SV_0013'),
('TK_0014','ThangTran1203','thangtran1203','student','SV_0014'),
('TK_0015','TaoLe1010','taole1010','student','SV_0015'),
('TK_0016','HoangDo1112','hoangdo1112','student','SV_0016'),
('TK_0017','QuangTong1707','quangtong1707','student','SV_0017'),
('TK_0018','HaiCu0101','haicu0101','student','SV_0018'),
('TK_0019','CongNguyen2004','congnguyen2004','student','SV_0019'),
('TK_0020','PhuongPham1507','phuongpham1507','student','SV_0020'),
('TK_0021','ThaoLe0910','thaole0910','student','SV_0021'),
('TK_0022','QuanNguyen1111','quannguyen1111','student','SV_0022'),
('TK_0023','MyNguyen1912','mynguyen1912','student','SV_0023'),
('TK_0024','NhatDo1602','nhatdo1602','student','SV_0024'),
('TK_0025','HuongNguyen0509','huongnguyen0509','student','SV_0025'),
('TK_0026','MinhLe1008','minhle1008','student','SV_0026'),
('TK_0027','VietNghiem1605','vietnghiem1605','student','SV_0027'),
('TK_0028','NamNguyen2304','namnguyen2304','student','SV_0028'),
('TK_0029','TungNguyen1611','tungnguyen1611','student','SV_0029'),
('TK_0030','HiepMau1212','hiepmau1212','student','SV_0030'),
('TK_0031','Admin01','admin123','admin', null);
