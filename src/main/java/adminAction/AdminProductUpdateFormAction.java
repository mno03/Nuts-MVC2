package adminAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ProductDAO;
import dto.ProductVO;

public class AdminProductUpdateFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productUpdate.jsp";
		String pseq = request.getParameter("pseq").trim();
		ProductDAO productDAO = ProductDAO.getInstance();
		ProductVO productVO = productDAO.getProduct(pseq);
		request.setAttribute("productVO", productVO);
		String tpage = "1";
		if (request.getParameter("tpage") != null) {
			tpage = request.getParameter("tpage");
		}
		request.setAttribute("tpage", tpage);

		String kindList[] = {"�� �ǰ�", "�� �ǰ�", "�� �ǰ�", "�Ǻ� �ǰ�", "�� �ǰ�", "���� �ǰ�", "�Ƿ� �ǰ�" };
		request.setAttribute("kindList", kindList);

		request.getRequestDispatcher(url).forward(request, response);
	}
}