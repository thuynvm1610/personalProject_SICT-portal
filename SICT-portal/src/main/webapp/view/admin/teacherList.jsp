<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hệ thống quản lý trường SICT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body>
    <c:if test="${not empty message}">
        <div class="alert-error">
            &#9888; ${message}
        </div>
    </c:if>
    <c:if test="${not empty succeedAddMessage}">
        <div class="alert-success">
            &#9989; ${succeedAddMessage}
        </div>
    </c:if>
    <c:if test="${not empty succeedUpdateMessage}">
        <div class="alert-success">
            &#9989; ${succeedUpdateMessage}
        </div>
    </c:if>
    <c:if test="${not empty succeedDeleteMessage}">
        <div class="alert-success">
            &#9989; ${succeedDeleteMessage}
        </div>
    </c:if>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-2 sidebar p-0">
                <div class="text-left p-3 bg-dark">
                    <div class="logo">SICT<span class="sub"> Portal</span></div>
                </div>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <form method="get" action="admin">
                            <input type="hidden" name="action" value="dashboard">
                            <button type="submit" class="sidebar-btn">
                                <div class="sidebar__icon-container">
                                    <i class="fas fa-tachometer-alt me-2"></i>
                                </div>
                                Dashboard
                            </button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form method="get" action="admin">
                            <input type="hidden" name="action" value="accountList">
                            <button type="submit" class="sidebar-btn">
                                <div class="sidebar__icon-container">
                                    <i class="fas fa-users me-2"></i>
                                </div>
                                Tài khoản người dùng
                            </button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form method="get" action="admin">
                            <input type="hidden" name="action" value="studentList">
                            <button type="submit" class="sidebar-btn">
                                <div class="sidebar__icon-container">
                                    <i class="fas fa-user-graduate me-2"></i>
                                </div>
                                Thông tin sinh viên
                            </button>
                        </form>
                    </li>
                    <li class="nav-item active">
                        <span class="active__subItem"></span>
                        <form method="get" action="admin">
                            <input type="hidden" name="action" value="teacherList">
                            <button type="submit" class="sidebar-btn">
                                <div class="sidebar__icon-container">
                                    <i class="fas fa-chalkboard-teacher me-2"></i>
                                </div>
                                Thông tin giáo viên
                            </button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form method="get" action="admin">
                            <input type="hidden" name="action" value="classroomList">
                            <button type="submit" class="sidebar-btn">
                                <div class="sidebar__icon-container">
                                    <i class="fas fa-school me-2"></i>
                                </div>
                                Thông tin lớp học
                            </button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form method="get" action="admin">
                            <input type="hidden" name="action" value="student_classroom">
                            <button type="submit" class="sidebar-btn">
                                <div class="sidebar__icon-container">
                                    <i class="fas fa-user-plus me-2"></i>
                                </div>
                                Sinh viên - Lớp học
                            </button>
                        </form>
                    </li>
                    <li class="nav-item mt-3">
                        <form method="get" action="admin">
                            <input type="hidden" name="action" value="logout">
                            <button type="submit" class="sidebar-btn">
                                <div class="sidebar__icon-container">
                                    <i class="fas fa-sign-out-alt me-2"></i>
                                </div>
                                Đăng xuất
                            </button>
                        </form>
                    </li>
                </ul>
            </div>
            <!-- Main content -->
            <div class="col-md-10 main-content">
                <div class="tab-content">
                    <!-- Teachers Tab -->
                    <div>
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <h2>Quản lý thông tin giáo viên</h2>
                            <form method="get" action="admin">
                                <input type="hidden" name="action" value="addTeacherForm" />
                                <button class="btn btn-primary" type="submit">
                                    <i class="fas fa-plus me-1"></i>
                                    Thêm giáo viên
                                </button>
                            </form>
                        </div>
                        <div class="card">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Danh sách giáo viên</span>
                                <div class="filter-controls" style="margin: 0px 30px 0px auto;">
                                    <span style="margin-right: 5px; font-weight: normal;" class="filter-controls__text">
                                        Bộ lọc
                                    </span>
                                    <button class="btn btn-outline-secondary" id="filterBtn">
                                        <i class="fa-solid fa-filter"></i>
                                    </button>
                                </div>
                                <form method="get" action="admin">
                                    <div style="display: flex;">
                                        <input type="hidden" name="action" value="searchTeacher" />
                                        <input
                                            style="outline: none; border: none; border-bottom-left-radius: 6px; border-top-left-radius: 6px; padding-left: 10px;"
                                            type="text" name="teacherID" placeholder="Nhập mã giáo viên..." required />
                                        <button class="btn btn-outline-secondary" type="submit">
                                            <i class="fas fa-search"></i>
                                        </button>
                                    </div>
                                </form>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <div style="max-height: 520.5px; overflow: auto;">
                                        <table class="table table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Mã GV</th>
                                                    <th>Họ tên</th>
                                                    <th>Giới tính</th>
                                                    <th>Ngày sinh</th>
                                                    <th>Email</th>
                                                    <th>Quê quán</th>
                                                    <th>Hành động</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="t" items="${teacherList}">
                                                    <tr>
                                                        <td>${t.teacherID}</td>
                                                        <td>${t.name}</td>
                                                        <td>${t.gender}</td>
                                                        <td>${t.dob}</td>
                                                        <td>${t.email}</td>
                                                        <td>${t.hometown}</td>
                                                        <td>
                                                            <div style="display: flex; gap: 5px;">
                                                                <form method="get" action="admin">
                                                                    <input type="hidden" name="action"
                                                                        value="updateTeacherForm" />
                                                                    <input type="hidden" name="teacherID"
                                                                        value="${t.teacherID}" />
                                                                    <button class="btn btn-sm btn-warning"
                                                                        type="submit">
                                                                        <i class="fas fa-edit"></i>
                                                                    </button>
                                                                </form>
                                                                <form method="get" action="admin">
                                                                    <input type="hidden" name="action"
                                                                        value="deleteTeacherForm" />
                                                                    <input type="hidden" name="teacherID"
                                                                        value="${t.teacherID}" />
                                                                    <button class="btn btn-sm btn-danger" type="submit">
                                                                        <i class="fas fa-trash"></i>
                                                                    </button>
                                                                </form>
                                                                <form method="get" action="admin">
                                                                    <input type="hidden" name="action"
                                                                        value="searchClassroomListByTeacherID" />
                                                                    <input type="hidden" name="teacherID"
                                                                        value="${t.teacherID}" />
                                                                    <button class="btn btn-sm btn-info" type="submit">
                                                                        <i class="fas fa-eye"></i>
                                                                    </button>
                                                                </form>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="cursor: pointer;" id="overlay" class="filter-overlay"></div>
    <div id="filterModal" class="filter-modal">
        <h3>Bộ lọc giáo viên</h3>
        <form action="admin" method="get">
            <input type="hidden" name="action" value="teacherFilter" />
            <div class="mb-3">
                <label for="gender" class="form-label">Giới tính</label>
                <select class="form-select" id="gender" name="gender">
                    <option value="">Chọn giới tính</option>
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="yob" class="form-label">Năm sinh</label>
                <select class="form-select" id="yob" name="yob">
                    <option value="">Chọn năm sinh</option>
                    <c:forEach var="yob" items="${yobList}">
                        <option value="${yob}">${yob}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="hometown" class="form-label">Quê quán</label>
                <select class="form-select" id="hometown" name="hometown">
                    <option value="">Chọn quê quán</option>
                    <c:forEach var="hometown" items="${hometownList}">
                        <option value="${hometown}">${hometown}</option>
                    </c:forEach>
                </select>
            </div>
            <div style="display: flex; flex-direction: row-reverse;">
                <button style="margin-left: 10px;" type="submit" class="btn btn-primary">Lưu</button>
                <button id="cancel-filter__btn" type="button" class="btn btn-secondary"
                    data-bs-dismiss="modal">Hủy</button>
            </div>
        </form>
    </div>
    <script>
        const filterBtn = document.getElementById('filterBtn');
        const filterModal = document.getElementById('filterModal');
        const overlay = document.getElementById('overlay');
        const cancelFilter__btn = document.getElementById('cancel-filter__btn');

        filterBtn.addEventListener('click', () => {
            filterModal.style.display = 'block';
            overlay.style.display = 'block';
        });

        overlay.addEventListener('click', () => {
            filterModal.style.display = 'none';
            overlay.style.display = 'none';
        });

        cancelFilter__btn.addEventListener('click', () => {
            filterModal.style.display = 'none';
            overlay.style.display = 'none';
        });
    </script>
</body>

</html>