package adminAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import dao.WorkerDAO;

public class AdminLoginAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "NutsServlet?command=admin_page";
		String msg = "";
		String workerId = request.getParameter("workerId").trim();
		String workerPwd = request.getParameter("workerPwd").trim();
		WorkerDAO workerDAO = WorkerDAO.getInstance();
		int result = workerDAO.workerCheck(workerId, workerPwd);

		if (result == 1) {// �α��� ����
			HttpSession session = request.getSession();
			session.setAttribute("workerId", workerId);
			url = "NutsServlet?command=admin_page";
		} else if (result == 0) {
			msg = "��й�ȣ�� Ȯ���ϼ���.";
		} else if (result == -1) {
			msg = "���̵� Ȯ���ϼ���.";
		}
		request.setAttribute("message", msg);
		request.getRequestDispatcher(url).forward(request, response);
	}
}