package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.ClassroomDAO;
import dao.StudentDAO;
import dao.Student_classroomDAO;
import dao.TeacherDAO;
import model.Account;
import model.Classroom;
import model.Student;
import model.Student_classroom;
import model.Teacher;

@WebServlet(urlPatterns = "/admin")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String action = req.getParameter("action");

		if (action.equals("teacherList")) {
			TeacherDAO teacherDAO = new TeacherDAO();
			List<Teacher> teacherList = teacherDAO.findAll();
			req.getSession().setAttribute("teacherList", teacherList);
			String succeedAddMessage = (String) req.getSession().getAttribute("succeedAddMessage");
			if (succeedAddMessage != null) {
			    req.setAttribute("succeedAddMessage", succeedAddMessage);
			    req.getSession().removeAttribute("succeedAddMessage");
			}
			String succeedUpdateMessage = (String) req.getSession().getAttribute("succeedUpdateMessage");
			if (succeedUpdateMessage != null) {
			    req.setAttribute("succeedUpdateMessage", succeedUpdateMessage);
			    req.getSession().removeAttribute("succeedUpdateMessage");
			}
			String succeedDeleteMessage = (String) req.getSession().getAttribute("succeedDeleteMessage");
			if (succeedDeleteMessage != null) {
			    req.setAttribute("succeedDeleteMessage", succeedDeleteMessage);
			    req.getSession().removeAttribute("succeedDeleteMessage");
			}
			List<Integer> yobList = teacherDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = teacherDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getRequestDispatcher("view/admin/teacherList.jsp").forward(req, resp);
			return;
		} else if (action.equals("teacherFilter")) {
			String gender = req.getParameter("gender");
			String yob = req.getParameter("yob");
			String hometown = req.getParameter("hometown");
			TeacherDAO teacherDAO = new TeacherDAO();
			List<Teacher> teacherList = new ArrayList<>();
			
			teacherList = teacherDAO.teacherListByFilter(gender, yob, hometown);
			List<Integer> yobList = teacherDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = teacherDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getSession().setAttribute("teacherList", teacherList);
			req.getRequestDispatcher("view/admin/teacherList.jsp").forward(req, resp);
		} else if (action.equals("classroomList")) {
			ClassroomDAO classroomDAO = new ClassroomDAO();
			List<Classroom> classroomList = classroomDAO.findAll();
			req.getSession().setAttribute("classroomList", classroomList);
			String succeedAddMessage = (String) req.getSession().getAttribute("succeedAddMessage");
			if (succeedAddMessage != null) {
			    req.setAttribute("succeedAddMessage", succeedAddMessage);
			    req.getSession().removeAttribute("succeedAddMessage");
			}
			String succeedUpdateMessage = (String) req.getSession().getAttribute("succeedUpdateMessage");
			if (succeedUpdateMessage != null) {
			    req.setAttribute("succeedUpdateMessage", succeedUpdateMessage);
			    req.getSession().removeAttribute("succeedUpdateMessage");
			}
			String succeedDeleteMessage = (String) req.getSession().getAttribute("succeedDeleteMessage");
			if (succeedDeleteMessage != null) {
			    req.setAttribute("succeedDeleteMessage", succeedDeleteMessage);
			    req.getSession().removeAttribute("succeedDeleteMessage");
			}
			req.getRequestDispatcher("view/admin/classroomList.jsp").forward(req, resp);
			return;
		} else if (action.equals("studentList")) {
			StudentDAO studentDAO = new StudentDAO();
			List<Student> studentList = studentDAO.findAll();
			req.getSession().setAttribute("studentList", studentList);
			String succeedAddMessage = (String) req.getSession().getAttribute("succeedAddMessage");
			if (succeedAddMessage != null) {
			    req.setAttribute("succeedAddMessage", succeedAddMessage);
			    req.getSession().removeAttribute("succeedAddMessage");
			}
			String succeedUpdateMessage = (String) req.getSession().getAttribute("succeedUpdateMessage");
			if (succeedUpdateMessage != null) {
			    req.setAttribute("succeedUpdateMessage", succeedUpdateMessage);
			    req.getSession().removeAttribute("succeedUpdateMessage");
			}
			String succeedDeleteMessage = (String) req.getSession().getAttribute("succeedDeleteMessage");
			if (succeedDeleteMessage != null) {
			    req.setAttribute("succeedDeleteMessage", succeedDeleteMessage);
			    req.getSession().removeAttribute("succeedDeleteMessage");
			}
			List<Integer> yobList = studentDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = studentDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getRequestDispatcher("view/admin/studentList.jsp").forward(req, resp);
			return;
		} else if (action.equals("studentFilter")) {
			String gender = req.getParameter("gender");
			String yob = req.getParameter("yob");
			String hometown = req.getParameter("hometown");
			StudentDAO studentDAO = new StudentDAO();
			List<Student> studentList = new ArrayList<Student>();
			
			studentList = studentDAO.studentListByFilter(gender, yob, hometown);
			List<Integer> yobList = studentDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = studentDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getSession().setAttribute("studentList", studentList);
			req.getRequestDispatcher("view/admin/studentList.jsp").forward(req, resp);
		} else if (action.equals("student_classroom")) {
			req.getRequestDispatcher("view/admin/student_classroom.jsp").forward(req, resp);
			return;
		} else if (action.equals("accountList")) {
			AccountDAO accountDAO = new AccountDAO();
			List<Account> accountList = accountDAO.findAll();
			req.getSession().setAttribute("accountList", accountList);
			String succeedAddMessage = (String) req.getSession().getAttribute("succeedAddMessage");
			if (succeedAddMessage != null) {
			    req.setAttribute("succeedAddMessage", succeedAddMessage);
			    req.getSession().removeAttribute("succeedAddMessage");
			}
			String succeedUpdateMessage = (String) req.getSession().getAttribute("succeedUpdateMessage");
			if (succeedUpdateMessage != null) {
			    req.setAttribute("succeedUpdateMessage", succeedUpdateMessage);
			    req.getSession().removeAttribute("succeedUpdateMessage");
			}
			String succeedDeleteMessage = (String) req.getSession().getAttribute("succeedDeleteMessage");
			if (succeedDeleteMessage != null) {
			    req.setAttribute("succeedDeleteMessage", succeedDeleteMessage);
			    req.getSession().removeAttribute("succeedDeleteMessage");
			}
			req.getRequestDispatcher("view/admin/accountList.jsp").forward(req, resp);
			return;
		} else if (action.equals("searchTeacher")) {
			String teacherID = req.getParameter("teacherID");
			TeacherDAO teacherDAO = new TeacherDAO();
			Teacher teacher = teacherDAO.findById(teacherID);
			if (teacher != null) {
				req.setAttribute("teacherList", List.of(teacher));
			} else {
				req.setAttribute("message", "Không tìm thấy giáo viên " + teacherID);
				req.setAttribute("teacherList", List.of());
			}
			req.getRequestDispatcher("view/admin/teacherList.jsp").forward(req, resp);
			return;
		} else if (action.equals("searchClassroom")) {
			String classroomID = req.getParameter("classroomID");
			ClassroomDAO classroomDAO = new ClassroomDAO();
			Classroom classroom = classroomDAO.findByID(classroomID);
			if (classroom != null) {
				req.setAttribute("classroomList", List.of(classroom));
			} else {
				req.setAttribute("message", "Không tìm thấy lớp học " + classroomID);
				req.setAttribute("classroomList", List.of());
			}
			req.getRequestDispatcher("view/admin/classroomList.jsp").forward(req, resp);
			return;
		} else if (action.equals("searchStudent")) {
			String studentID = req.getParameter("studentID");
			StudentDAO studentDAO = new StudentDAO();
			Student student = studentDAO.findByID(studentID);
			if (student != null) {
				req.setAttribute("studentList", List.of(student));
			} else {
				req.setAttribute("message", "Không tìm thấy sinh viên " + studentID);
				req.setAttribute("studentList", List.of());
			}
			req.getRequestDispatcher("view/admin/studentList.jsp").forward(req, resp);
			return;
		} else if (action.equals("searchClassroomListByTeacherID")) {
			String teacherID = req.getParameter("teacherID");
			ClassroomDAO classroomDAO = new ClassroomDAO();
			List<Classroom> classroomList = classroomDAO.findByTeacherID(teacherID);
			req.setAttribute("classroomList", classroomList);
			req.setAttribute("teacherID", teacherID);
			if (classroomList.isEmpty()) {	
				req.setAttribute("message", "Giáo viên " + teacherID + " hiện chưa dạy lớp nào");
			}
			req.getRequestDispatcher("view/admin/classroomListByTeacherID.jsp").forward(req, resp);
			return;
		} else if (action.equals("searchClassroomListByStudentID")) {
			String studentID = req.getParameter("studentID");
			StudentDAO studentDAO = new StudentDAO();
			Student student = studentDAO.findByID(studentID);
			if (student == null) {
				req.setAttribute("message", "Không tìm thấy sinh viên " + req.getParameter("studentID"));
				req.getRequestDispatcher("view/admin/student_classroom.jsp").forward(req, resp);
			}
			else {
				Student_classroomDAO student_classroomDAO = new Student_classroomDAO();
				List<Student_classroom> student_classroomList = student_classroomDAO.findByID(null, studentID);
				List<Classroom> classroomList = new ArrayList<>();
				ClassroomDAO classroomDAO = new ClassroomDAO();
				for (int i = 0; i < student_classroomList.size(); i++) {
					String classroomID = student_classroomList.get(i).getClassroomID();
					String classroomName = classroomDAO.getClassroomName(classroomID);
					Classroom classroom = new Classroom();
					classroom.setClassroomID(classroomID);
					classroom.setName(classroomName);
					classroom.setTeacherID(null);
					classroomList.add(classroom);
				}
				req.setAttribute("classroomList", classroomList);
				req.setAttribute("studentID", studentID);
				if (student_classroomList.isEmpty()) {
					req.setAttribute("message", "Sinh viên " + req.getParameter("studentID") + " hiện chưa học lớp nào");
				}
				req.getRequestDispatcher("view/admin/classroomListByStudentID.jsp").forward(req, resp);
			}
			return;
		} else if (action.equals("searchStudentListByClassroomID")) {
			String classroomID = req.getParameter("classroomID");
			ClassroomDAO classroomDAO = new ClassroomDAO();
			Classroom classroom = classroomDAO.findByID(classroomID);
			if (classroom == null) {
				req.setAttribute("message", "Không tìm thấy lớp học " + req.getParameter("classroomID"));
				req.getRequestDispatcher("view/admin/student_classroom.jsp").forward(req, resp);
			}
			else {
				Student_classroomDAO student_classroomDAO = new Student_classroomDAO();
				List<Student_classroom> student_classroomList = student_classroomDAO.findByID(classroomID, null);
				List<Student> studentList = new ArrayList<>();
				StudentDAO studentDAO = new StudentDAO();
				for (int i = 0; i < student_classroomList.size(); i++) {
					String studentID = student_classroomList.get(i).getStudentID();
					String studentName = studentDAO.getStudentName(studentID);
					Student student = new Student();
					student.setStudentID(studentID);
					student.setName(studentName);
					student.setDob(null);
					student.setEmail(null);
					student.setGender(null);
					studentList.add(student);
				}
				req.setAttribute("studentList", studentList);
				req.setAttribute("classroomID", classroomID);
				if (student_classroomList.isEmpty()) {
					req.setAttribute("message", "Lớp " + req.getParameter("classroomID") + " hiện chưa có sinh viên nào");
				}
				req.getRequestDispatcher("view/admin/studentListByClassroomID.jsp").forward(req, resp);
			}
			return;
		} else if (action.equals("searchAccount")) {
			String accountID = req.getParameter("accountID");
			AccountDAO accountDAO = new AccountDAO();
			Account account = accountDAO.findByID(accountID);
			if (account != null) {
				req.setAttribute("accountList", List.of(account));
			} else {
				req.setAttribute("message", "Không tìm thấy tài khoản " + accountID);
				req.setAttribute("accountList", List.of());
			}
			req.getRequestDispatcher("view/admin/accountList.jsp").forward(req, resp);
			return;
		} else if (action.equals("addTeacherForm")) {
			TeacherDAO teacherDAO = new TeacherDAO();
			List<Integer> yobList = teacherDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = teacherDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getRequestDispatcher("view/admin/addTeacher.jsp").forward(req, resp);
			return;
		} else if (action.equals("addClassroomForm")) {
			req.getRequestDispatcher("view/admin/addClassroom.jsp").forward(req, resp);
			return;
		} else if (action.equals("addStudentForm")) {
			StudentDAO studentDAO = new StudentDAO();
			List<Integer> yobList = studentDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = studentDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getRequestDispatcher("view/admin/addStudent.jsp").forward(req, resp);
			return;
		} else if (action.equals("addAccountForm")) {
			req.getRequestDispatcher("view/admin/addAccount.jsp").forward(req, resp);
			return;
		} else if (action.equals("updateTeacherForm")) {
			String teacherID = req.getParameter("teacherID");
			TeacherDAO teacherDAO = new TeacherDAO();
			Teacher teacher = teacherDAO.findById(teacherID);
			req.setAttribute("teacher", teacher);
			List<Integer> yobList = teacherDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = teacherDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getRequestDispatcher("view/admin/updateTeacher.jsp").forward(req, resp);
			return;
		} else if (action.equals("updateClassroomForm")) {
			String classroomID = req.getParameter("classroomID");
			ClassroomDAO classroomDAO = new ClassroomDAO();
			Classroom classroom = classroomDAO.findByID(classroomID);
			req.setAttribute("classroom", classroom);
			req.getRequestDispatcher("view/admin/updateClassroom.jsp").forward(req, resp);
			return;
		} else if (action.equals("updateStudentForm")) {
			String studentID = req.getParameter("studentID");
			StudentDAO studentDAO = new StudentDAO();
			Student student = studentDAO.findByID(studentID);
			req.setAttribute("student", student);
			List<Integer> yobList = studentDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = studentDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getRequestDispatcher("view/admin/updateStudent.jsp").forward(req, resp);
			return;
		} else if (action.equals("updateAccountForm")) {
			String accountID = req.getParameter("accountID");
			AccountDAO accountDAO = new AccountDAO();
			Account account = accountDAO.findByID(accountID);
			req.setAttribute("account", account);
			req.getRequestDispatcher("view/admin/updateAccount.jsp").forward(req, resp);
			return;
		} else if (action.equals("deleteTeacherForm")) {
			String teacherID = req.getParameter("teacherID");
			req.setAttribute("teacherID", teacherID);
			TeacherDAO teacherDAO = new TeacherDAO();
			List<Integer> yobList = teacherDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = teacherDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getRequestDispatcher("view/admin/deleteTeacher.jsp").forward(req, resp);
			return;
		} else if (action.equals("deleteClassroomForm")) {
			String classroomID = req.getParameter("classroomID");
			req.setAttribute("classroomID", classroomID);
			req.getRequestDispatcher("view/admin/deleteClassroom.jsp").forward(req, resp);
			return;
		} else if (action.equals("deleteStudentForm")) {
			String studentID = req.getParameter("studentID");
			req.setAttribute("studentID", studentID);
			StudentDAO studentDAO = new StudentDAO();
			List<Integer> yobList = studentDAO.getListOfYear();
			req.setAttribute("yobList", yobList);
			List<String> hometownList = studentDAO.getListOfHometown();
			req.setAttribute("hometownList", hometownList);
			req.getRequestDispatcher("view/admin/deleteStudent.jsp").forward(req, resp);
			return;
		} else if (action.equals("deleteAccountForm")) {
			String accountID = req.getParameter("accountID");
			req.setAttribute("accountID", accountID);
			req.getRequestDispatcher("view/admin/deleteAccount.jsp").forward(req, resp);
			return;
		} else if (action.equals("dashboard")) {
			StudentDAO studentDAO = new StudentDAO();
			int totalStudent = studentDAO.totalStudent();
			ClassroomDAO classroomDAO = new ClassroomDAO();
			int totalClassroom = classroomDAO.totalClassroom();
			TeacherDAO teacherDAO = new TeacherDAO();
			int totalTeacher = teacherDAO.totalTeacher();
			AccountDAO accountDAO = new AccountDAO();
			int totalAccount = accountDAO.totalAccount();
			req.setAttribute("totalStudent", totalStudent);
			req.setAttribute("totalClassroom", totalClassroom);
			req.setAttribute("totalTeacher", totalTeacher);
			req.setAttribute("totalAccount", totalAccount);
			req.getRequestDispatcher("view/admin/dashboard.jsp").forward(req, resp);
			return;
		} else if (action.equals("logout")) {
			HttpSession session = req.getSession(false);
		    if (session != null) {
		        session.invalidate();
		    }
			req.getRequestDispatcher("view/login/loginForm.jsp").forward(req, resp);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String action = req.getParameter("action");

		if (action.equals("addTeacher")) {
			TeacherDAO teacherDAO = new TeacherDAO();
			StringBuilder message = new StringBuilder();

			if (teacherDAO.findById(req.getParameter("teacherID")) != null) {
				message.append("Mã giáo viên đã tồn tại<br>");
			} else if (teacherDAO.isEmailExists(req.getParameter("email"), req.getParameter("teacherID"))) {
				message.append("Email đã được sử dụng<br>");
			}

			Teacher teacher = new Teacher();
			teacher.setTeacherID(req.getParameter("teacherID"));
			teacher.setName(req.getParameter("name"));
			teacher.setGender(req.getParameter("gender"));
			teacher.setDob(Date.valueOf(req.getParameter("dob")));
			teacher.setEmail(req.getParameter("email"));
			teacher.setHometown(req.getParameter("hometown"));

			if (message.length() > 0) {
				req.setAttribute("teacher", teacher);
				req.setAttribute("message", message.toString());
				req.getRequestDispatcher("view/admin/addTeacher.jsp").forward(req, resp);
				return;
			}

			teacherDAO.insert(teacher);
			req.getSession().setAttribute("succeedAddMessage", "Thêm giáo viên thành công");
			resp.sendRedirect("admin?action=teacherList");
			return;
		} else if (action.equals("addClassroom")) {
			ClassroomDAO classroomDAO = new ClassroomDAO();
			TeacherDAO teacherDAO = new TeacherDAO();
			StringBuilder message = new StringBuilder();

			if (classroomDAO.findByID(req.getParameter("classroomID")) != null) {
				message.append("Mã lớp học đã tồn tại<br>");
			} else if (teacherDAO.findById(req.getParameter("teacherID")) == null) {
				message.append("Mã giáo viên không tồn tại<br>");
			}

			Classroom classroom = new Classroom();
			classroom.setClassroomID(req.getParameter("classroomID"));
			classroom.setName(req.getParameter("name"));
			classroom.setTeacherID(req.getParameter("teacherID"));

			if (message.length() > 0) {
				req.setAttribute("classroom", classroom);
				req.setAttribute("message", message.toString());
				req.getRequestDispatcher("view/admin/addClassroom.jsp").forward(req, resp);
				return;
			}

			classroomDAO.insert(classroom);
			req.getSession().setAttribute("succeedAddMessage", "Thêm lớp học thành công");
			resp.sendRedirect("admin?action=classroomList");
			return;
		} else if (action.equals("addStudent")) {
			StudentDAO studentDAO = new StudentDAO();
			StringBuilder message = new StringBuilder();

			if (studentDAO.findByID(req.getParameter("studentID")) != null) {
				message.append("Mã sinh viên đã tồn tại<br>");
			} else if (studentDAO.isEmailExists(req.getParameter("email"), req.getParameter("studentID"))) {
				message.append("Email đã được sử dụng<br>");
			}
			Student student = new Student();
			student.setStudentID(req.getParameter("studentID"));
			student.setName(req.getParameter("name"));
			student.setGender(req.getParameter("gender"));
			student.setDob(Date.valueOf(req.getParameter("dob")));
			student.setEmail(req.getParameter("email"));
			student.setHometown(req.getParameter("hometown"));

			if (message.length() > 0) {
				req.setAttribute("student", student);
				req.setAttribute("message", message.toString());
				req.getRequestDispatcher("view/admin/addStudent.jsp").forward(req, resp);
				return;
			}

			studentDAO.insert(student);
			req.getSession().setAttribute("succeedAddMessage", "Thêm sinh viên thành công");
			resp.sendRedirect("admin?action=studentList");
			return;
		} else if (action.equals("addStudent_classroom")) {
			Student_classroomDAO student_classroomDAO = new Student_classroomDAO();
			StudentDAO studentDAO = new StudentDAO();
			ClassroomDAO classroomDAO = new ClassroomDAO();
			StringBuilder message = new StringBuilder();

			if (classroomDAO.findByID(req.getParameter("classroomID")) == null) {
				message.append("Mã lớp không tồn tại<br>");
			} else if (studentDAO.findByID(req.getParameter("studentID")) == null) {
				message.append("Mã sinh viên không tồn tại<br>");
			} else if (!student_classroomDAO.findByID(req.getParameter("classroomID"), req.getParameter("studentID")).isEmpty()) {
				message.append("Sinh viên " + req.getParameter("studentID") + " đã học lớp " + req.getParameter("classroomID"));
			}

			Student_classroom student_classroom = new Student_classroom();
			student_classroom.setClassroomID(req.getParameter("classroomID"));
			student_classroom.setStudentID(req.getParameter("studentID"));

			if (message.length() > 0) {
				req.setAttribute("student_classroom", student_classroom);
				req.setAttribute("message", message.toString());
				req.setAttribute("classroomID", req.getParameter("classroomID"));
			    req.setAttribute("studentID", req.getParameter("studentID"));
				req.getRequestDispatcher("view/admin/student_classroom.jsp").forward(req, resp);
				return;
			}

			student_classroomDAO.insert(student_classroom);
			StringBuilder succeedAddMessage = new StringBuilder();
			succeedAddMessage.append("Thêm sinh viên vào lớp thành công<br>");
			req.setAttribute("succeedAddMessage", succeedAddMessage.toString());
			req.getRequestDispatcher("view/admin/student_classroom.jsp").forward(req, resp);
			return;
		} else if (action.equals("addAccount")) {
			AccountDAO accountDAO = new AccountDAO();
			StudentDAO studentDAO = new StudentDAO();
			StringBuilder message = new StringBuilder();

			if (accountDAO.findByID(req.getParameter("accountID")) != null) {
				message.append("Mã tài khoản đã tồn tại<br>");
			} else if (accountDAO.isUsernameExists(req.getParameter("username"), req.getParameter("accountID"))) {
				message.append("Tên tài khoản đã được sử dụng<br>");
			} else if (accountDAO.isStudentIDUsed(req.getParameter("studentID"), null, req.getParameter("role"))) {
				message.append("Mã sinh viên đã được sử dụng<br>");
			} else if (!studentDAO.isStudentExists(req.getParameter("studentID"), req.getParameter("role"))) {
				message.append("Mã sinh viên không tồn tại<br>");
			}

			Account account = new Account();
			account.setAccountID(req.getParameter("accountID"));
			account.setUsername(req.getParameter("username"));
			account.setPassword(req.getParameter("password"));
			account.setRole(req.getParameter("role"));
			account.setStudentID(req.getParameter("role").equals("student") ? req.getParameter("studentID") : null);

			if (message.length() > 0) {
				req.setAttribute("account", account);
				req.setAttribute("message", message.toString());
				req.getRequestDispatcher("view/admin/addAccount.jsp").forward(req, resp);
				return;
			}

			accountDAO.insert(account);
			req.getSession().setAttribute("succeedAddMessage", "Thêm tài khoản thành công");
			resp.sendRedirect("admin?action=accountList");
			return;
		} else if (action.equals("updateTeacher")) {
			TeacherDAO teacherDAO = new TeacherDAO();
			StringBuilder message = new StringBuilder();

			if (teacherDAO.isEmailExists(req.getParameter("email"), req.getParameter("teacherID"))) {
				message.append("Email đã được sử dụng<br>");
			}

			Teacher teacher = new Teacher();
			teacher.setTeacherID(req.getParameter("teacherID"));
			teacher.setName(req.getParameter("name"));
			teacher.setGender(req.getParameter("gender"));
			teacher.setDob(Date.valueOf(req.getParameter("dob")));
			teacher.setEmail(req.getParameter("email"));
			teacher.setHometown(req.getParameter("hometown"));

			if (message.length() > 0) {
				req.setAttribute("teacher", teacher);
				req.setAttribute("message", message.toString());
				req.getRequestDispatcher("view/admin/updateTeacher.jsp").forward(req, resp);
				return;
			}

			teacherDAO.update(teacher);
			req.getSession().setAttribute("succeedUpdateMessage", "Sửa thông tin giáo viên thành công");
			resp.sendRedirect("admin?action=teacherList");
			return;
		} else if (action.equals("updateClassroom")) {
			ClassroomDAO classroomDAO = new ClassroomDAO();
			TeacherDAO teacherDAO = new TeacherDAO();
			StringBuilder message = new StringBuilder();

			if (teacherDAO.findById(req.getParameter("teacherID")) == null) {
				message.append("Mã giáo viên không tồn tại<br>");
			}

			Classroom classroom = new Classroom();
			classroom.setClassroomID(req.getParameter("classroomID"));
			classroom.setName(req.getParameter("name"));
			classroom.setTeacherID(req.getParameter("teacherID"));

			if (message.length() > 0) {
				req.setAttribute("classroom", classroom);
				req.setAttribute("message", message.toString());
				req.getRequestDispatcher("view/admin/updateClassroom.jsp").forward(req, resp);
				return;
			}

			classroomDAO.update(classroom);
			req.getSession().setAttribute("succeedUpdateMessage", "Sửa thông tin lớp học thành công");
			resp.sendRedirect("admin?action=classroomList");
			return;
		} else if (action.equals("updateStudent")) {
			StudentDAO studentDAO = new StudentDAO();
			StringBuilder message = new StringBuilder();

			if (studentDAO.isEmailExists(req.getParameter("email"), req.getParameter("studentID"))) {
				message.append("Email đã được sử dụng<br>");
			}

			Student student = new Student();
			student.setStudentID(req.getParameter("studentID"));
			student.setName(req.getParameter("name"));
			student.setGender(req.getParameter("gender"));
			student.setDob(Date.valueOf(req.getParameter("dob")));
			student.setEmail(req.getParameter("email"));
			student.setHometown(req.getParameter("hometown"));

			if (message.length() > 0) {
				req.setAttribute("student", student);
				req.setAttribute("message", message.toString());
				req.getRequestDispatcher("view/admin/updateStudent.jsp").forward(req, resp);
				return;
			}

			studentDAO.update(student);
			req.getSession().setAttribute("succeedUpdateMessage", "Sửa thông tin sinh viên thành công");
			resp.sendRedirect("admin?action=studentList");
			return;
		} else if (action.equals("updateAccount")) {
			AccountDAO accountDAO = new AccountDAO();
			StringBuilder message = new StringBuilder();

			if (accountDAO.isUsernameExists(req.getParameter("username"), req.getParameter("accountID"))) {
				message.append("Tên tài khoản đã được sử dụng<br>");
			}

			Account account = new Account();
			account.setAccountID(req.getParameter("accountID"));
			account.setUsername(req.getParameter("username"));
			account.setPassword(req.getParameter("password"));
			account.setRole(req.getParameter("role"));
			account.setStudentID(req.getParameter("studentID"));

			if (message.length() > 0) {
				req.setAttribute("account", account);
				req.setAttribute("message", message.toString());
				req.getRequestDispatcher("view/admin/updateAccount.jsp").forward(req, resp);
				return;
			}

			accountDAO.update(account);
			req.getSession().setAttribute("succeedUpdateMessage", "Sửa thông tin tài khoản thành công");
			resp.sendRedirect("admin?action=accountList");
			return;
		} else if (action.equals("deleteTeacher")) {
			TeacherDAO teacherDAO = new TeacherDAO();
			teacherDAO.delete(req.getParameter("teacherID"));
			req.getSession().setAttribute("succeedDeleteMessage", "Xóa giáo viên thành công");
			resp.sendRedirect("admin?action=teacherList");
			return;
		} else if (action.equals("deleteClassroom")) {
			ClassroomDAO classroomDAO = new ClassroomDAO();
			classroomDAO.delete(req.getParameter("classroomID"));
			req.getSession().setAttribute("succeedDeleteMessage", "Xóa lớp học thành công");
			resp.sendRedirect("admin?action=classroomList");
			return;
		} else if (action.equals("deleteStudent")) {
			StudentDAO studentDAO = new StudentDAO();
			studentDAO.delete(req.getParameter("studentID"));
			req.getSession().setAttribute("succeedDeleteMessage", "Xóa sinh viên thành công");
			resp.sendRedirect("admin?action=studentList");
			return;
		} else if (action.equals("deleteStudent_classroom")) {
			Student_classroomDAO student_classroomDAO = new Student_classroomDAO();
			StudentDAO studentDAO = new StudentDAO();
			ClassroomDAO classroomDAO = new ClassroomDAO();
			StringBuilder message = new StringBuilder();

			if (classroomDAO.findByID(req.getParameter("classroomID")) == null) {
				message.append("Mã lớp không tồn tại<br>");
			} else if (studentDAO.findByID(req.getParameter("studentID")) == null) {
				message.append("Mã sinh viên không tồn tại<br>");
			}
			
			if (message.length() > 0) {
				req.setAttribute("message", message.toString());
				req.setAttribute("classroomID", req.getParameter("classroomID"));
			    req.setAttribute("studentID", req.getParameter("studentID"));
				req.getRequestDispatcher("view/admin/student_classroom.jsp").forward(req, resp);
				return;
			}
			
			student_classroomDAO.delete(req.getParameter("classroomID"), req.getParameter("studentID"));
			StringBuilder succeedDeleteMessage = new StringBuilder();
			succeedDeleteMessage.append("Xóa sinh viên khỏi lớp thành công<br>");
			req.setAttribute("succeedDeleteMessage", succeedDeleteMessage.toString());
			req.getRequestDispatcher("view/admin/student_classroom.jsp").forward(req, resp);
			return;
		} else if (action.equals("deleteAccount")) {
			AccountDAO accountDAO = new AccountDAO();
			accountDAO.delete(req.getParameter("accountID"));
			req.getSession().setAttribute("succeedDeleteMessage", "Xóa tài khoản thành công");
			resp.sendRedirect("admin?action=accountList");
			return;
		}
	}

}
