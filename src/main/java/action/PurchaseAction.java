package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import dto.MemberVO;
import dto.OrderVO;
/*
public class PurchaseAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			// �α����� �Ǿ� ���� �ʴٸ� �α��� �������� �̵�
			response.sendRedirect("NutsServlet?command=login_form");
			return;
		}

		int pseq = Integer.parseInt(request.getParameter("pseq"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		// �ֹ� ���� ����
		OrderVO orderVO = new OrderVO();
		orderVO.setId(loginUser.getId());
		orderVO.setPseq(pseq);
		orderVO.setQuantity(quantity);

		// �ֹ� ���� DB�� �߰�
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.insertPurchase(orderVO);

		// �ֹ� ������ �����ͼ� �� �ֹ� ���� ���
		//List<OrderVO> orderList = orderDAO.listOrderById(loginUser.getId(), "1");
		int totalPrice = 0;
		for (OrderVO vo : orderList) {
			totalPrice += vo.getPrice() * vo.getQuantity();
		}

		// JSP �������� ������ ����
		request.setAttribute("cartList", orderList);
		request.setAttribute("totalPrice", totalPrice);
		request.getRequestDispatcher("NutsServlet?command=order_insert").forward(request, response);
	}
}*/
