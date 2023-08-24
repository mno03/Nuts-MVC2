package adminAction;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import dao.ProductDAO;
import dto.ProductVO;

public class AdminProductWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "NutsServlet?command=admin_product_list";

		HttpSession session = request.getSession();

		int sizeLimit = 5 * 1024 * 1024;
		String savePath = "product_images";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

		MultipartRequest multi = new MultipartRequest(request, // 1. ��û ��ü
				uploadFilePath, // 2. ���ε�� ������ ����� ���� ��θ�
				sizeLimit, // 3. ���ε�� ������ �ִ� ũ��(5Mb)
				"UTF-8", // 4. ���ڵ� Ÿ�� ����
				new DefaultFileRenamePolicy());// 5. ����⸦ ���� ���� �κ�
		ProductVO productVO = new ProductVO();
		productVO.setKind(multi.getParameter("kind"));
		productVO.setName(multi.getParameter("name"));
		productVO.setPrice(Integer.parseInt(multi.getParameter("price")));
		productVO.setContent1(multi.getParameter("content1"));
		productVO.setContent2(multi.getParameter("content2"));
		productVO.setContent3(multi.getParameter("content3"));

		productVO.setImage(multi.getFilesystemName("image"));
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.insertProduct(productVO);

		response.sendRedirect(url);
	}
}