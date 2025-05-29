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
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        .main-content {
            margin-left: 16.6667%; /* Đẩy phần main-content sang phải bằng chiều rộng sidebar */
            padding: 20px; /* Có thể tùy chỉnh */
        }
    </style>
</head>

<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-2 sidebar p-0" style="position: fixed;">
                <div class="text-left p-3 bg-dark">
                    <h4 class="text-white">Hệ thống quản lý</h4>
                </div>
                <ul class="nav flex-column">
                    <li class="nav-item active">
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
                    <li class="nav-item">
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
                    <!-- Dashboard Tab -->
                    <div class="dashboard">
                        <h2 class="mb-4">Dashboard</h2>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="card text-white bg-primary mb-3">
                                    <div class="card-body">
                                        <div
                                            style="display: flex; align-items: center; justify-content: space-between;">
                                            <h5 class="card-title">Tài khoản người dùng</h5>
                                            <i class="fas fa-users me-2"></i>
                                        </div>
                                        <p class="card-text display-6">${totalAccount}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card text-white bg-success mb-3">
                                    <div class="card-body">
                                        <div
                                            style="display: flex; align-items: center; justify-content: space-between;">
                                            <h5 class="card-title">Sinh viên</h5>
                                            <i class="fas fa-user-graduate me-2"></i>
                                        </div>
                                        <p class="card-text display-6">${totalStudent}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card text-white bg-info mb-3">
                                    <div class="card-body">
                                        <div
                                            style="display: flex; align-items: center; justify-content: space-between;">
                                            <h5 class="card-title">Giáo viên</h5>
                                            <i class="fas fa-chalkboard-teacher me-2"></i>
                                        </div>
                                        <p class="card-text display-6">${totalTeacher}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card text-white bg-warning mb-3">
                                    <div class="card-body">
                                        <div
                                            style="display: flex; align-items: center; justify-content: space-between;">
                                            <h5 class="card-title">Lớp học</h5>
                                            <i class="fas fa-school me-2"></i>
                                        </div>
                                        <p class="card-text display-6">${totalClassroom}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div style="width: 600px; margin-top: 30px;">
                                    <canvas id="barChart"></canvas>
                                </div>
                            </div>        
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <div style="width: 400px; margin-top: 30px;">
                                    <canvas id="userPieChart"></canvas>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div style="width: 400px; margin-top: 30px;">
                                    <canvas id="teacherClassroomPieChart"></canvas>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div style="width: 400px; margin-top: 30px;">
                                    <canvas id="studentClassroomPieChart"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        const ctx1 = document.getElementById('userPieChart').getContext('2d');
        const userPieChart = new Chart(ctx1, {
            type: 'pie',
            data: {
                labels: ['Sinh viên', 'Giáo viên'],
                datasets: [{
                    data: [<c:out value="${totalStudent}" />, <c:out value="${totalTeacher}" />], // Số lượng thực tế
                    backgroundColor: [
                        'rgba(54, 162, 235, 0.7)',  // Màu xanh dương
                        'rgba(255, 206, 86, 0.7)'   // Màu vàng
                    ],
                    borderColor: [
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'bottom',
                        labels: {
                            font: {
                                size: 16
                            },
                            padding: 30
                        }
                    },
                    title: {
                        display: true,
                        text: 'Tỷ lệ Sinh viên và Giáo viên',
                        font: {
                            size: 20
                        }
                    }
                }
            }
        });

        const ctx2 = document.getElementById('teacherClassroomPieChart').getContext('2d');
        const teacherClassroomPieChart = new Chart(ctx2, {
            type: 'pie',
            data: {
                labels: ['Lớp học', 'Giáo viên'],
                datasets: [{
                    data: [<c:out value="${totalClassroom}" />, <c:out value="${totalTeacher}" />],
                    backgroundColor: [
                        'rgba(126, 214, 165, 0.7)',
                        'rgba(248, 225, 108, 0.7)'
                    ],
                    borderColor: [
                        'rgba(126, 214, 165, 1)',
                        'rgba(248, 225, 108, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'bottom',
                        labels: {
                            font: {
                                size: 16
                            },
                            padding: 30
                        }
                    },
                    title: {
                        display: true,
                        text: 'Tỷ lệ Lớp học và Giáo viên',
                        font: {
                            size: 20
                        }
                    }
                }
            }
        });

        const ctx3 = document.getElementById('studentClassroomPieChart').getContext('2d');
        const studentClassroomPieChart = new Chart(ctx3, {
            type: 'pie',
            data: {
                labels: ['Lớp học', 'Sinh viên'],
                datasets: [{
                    data: [<c:out value="${totalClassroom}" />, <c:out value="${totalStudent}" />],
                    backgroundColor: [
                        'rgba(233, 78, 119, 0.7)',
                        'rgba(155, 89, 182, 0.7)'
                    ],
                    borderColor: [
                        'rgba(233, 78, 119, 1)',
                        'rgba(155, 89, 182, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'bottom',
                        labels: {
                            font: {
                                size: 16
                            },
                            padding: 30
                        }
                    },
                    title: {
                        display: true,
                        text: 'Tỷ lệ Lớp học và Giáo viên',
                        font: {
                            size: 20
                        }
                    }
                }
            }
        });

        const ctx4 = document.getElementById('barChart').getContext('2d');
        const barChart = new Chart(ctx4, {
            type: 'bar',
            data: {
                labels: ['Sinh viên', 'Giáo viên', 'Lớp học'],
                datasets: [{
                    label: 'Số lượng',
                    data: [
                        <c:out value="${totalStudent}" />,
                        <c:out value="${totalTeacher}" />,
                        <c:out value="${totalClassroom}" />
                    ],
                    backgroundColor: [
                        'rgba(54, 162, 235, 0.7)',
                        'rgba(255, 206, 86, 0.7)',
                        'rgba(126, 214, 165, 0.7)',
                    ],
                    borderColor: [
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(126, 214, 165, 1)',
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        display: false // ẩn legend vì chỉ có 1 dataset
                    },
                    title: {
                        display: true,
                        text: 'Thống kê tổng số Sinh viên, Giáo viên, Lớp học',
                        font: {
                            size: 20
                        }
                    },
                    tooltip: {
                        enabled: true
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        ticks: {
                            stepSize: 1 // tăng giảm tùy dữ liệu của bạn
                        }
                    }
                }
            }
        });

    </script>
</body>

</html>