package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderControlDBAccess;
import model.ProductList;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		// フォワード先を変数で指定する
		String forwardPath = null;
		String action = request.getParameter("action");


		if(action == null) {
			OrderControlDBAccess dao = new OrderControlDBAccess();

			//商品リスト取得
			ArrayList<ProductList> list = dao.findlimitProducts();

			//スコープ
			HttpSession session = request.getSession();
			session.setAttribute("list", list);

			forwardPath = "/WEB-INF/index.jsp";
		}

		//全表示
		else if( action.equals("AllList")) {

			String sort = request.getParameter("sort");

			if(sort.equals("id")) {
				OrderControlDBAccess dao = new OrderControlDBAccess();

				//商品リスト取得
				ArrayList<ProductList> list = dao.findSortIdProducts();

				//スコープ
				HttpSession session = request.getSession();
				session.setAttribute("list", list);
				forwardPath = "WEB-INF/AllList.jsp";
			}
			else if(sort.equals("name")) {
				OrderControlDBAccess dao = new OrderControlDBAccess();

				//商品リスト取得
				ArrayList<ProductList> list = dao.findSortNameProducts();

				//スコープ
				HttpSession session = request.getSession();
				session.setAttribute("list", list);
				forwardPath = "WEB-INF/AllList.jsp";
			}
			else if(sort.equals("price")) {
				OrderControlDBAccess dao = new OrderControlDBAccess();

				//商品リスト取得
				ArrayList<ProductList> list = dao.findSortPriceProducts();

				//スコープ
				HttpSession session = request.getSession();
				session.setAttribute("list", list);
				forwardPath = "WEB-INF/AllList.jsp";
			}
			else {

			OrderControlDBAccess dao = new OrderControlDBAccess();

			//商品リスト取得
			ArrayList<ProductList> list = dao.findAllProducts();

			//スコープ
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			forwardPath = "WEB-INF/AllList.jsp";
			}


		}
		//曖昧検索
		else if(action.equals("SearchItem")) {

			forwardPath = "WEB-INF/search.jsp";
		}
		//新規登録
		else if(action.equals("AddItem")) {
			forwardPath = "WEB-INF/AddItem.jsp";
		}
		//編集
		else if(action.equals("edit")) {
			String e_id = request.getParameter("code");

			OrderControlDBAccess dao = new OrderControlDBAccess();
			//商品リスト取得
			ArrayList<ProductList> list = dao.selectProductId(e_id);
			//スコープ
			HttpSession session = request.getSession();
			session.setAttribute("list", list);

			forwardPath = "WEB-INF/edit.jsp";

		}

		// フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String forwardPath = null;
		//パラメーター取得
		request.setCharacterEncoding("UTF-8");
		String s_mode = request.getParameter("s_mode");
		String delete = request.getParameter("delete");

			if(s_mode.equals("SearchItems")) {
				//検索キーワード抽出
				String s_name = request.getParameter("s_name");

				OrderControlDBAccess dao = new OrderControlDBAccess();

				//商品リスト取得
				ArrayList<ProductList> list = dao.selectProductPlace(s_name);
				//スコープ
				HttpSession session = request.getSession();
				session.setAttribute("list", list);

				forwardPath = "WEB-INF/AllList.jsp";

			}
			else if(s_mode.equals("AddItems")) {

				//登録データ抽出
				String s_name = request.getParameter("s_name");
				int s_price = Integer.parseInt(request.getParameter("s_price"));
				String s_id = request.getParameter("s_id");

				ProductList list = new ProductList(s_name,s_id,s_price);
				//スコープ
				HttpSession session = request.getSession();
				session.setAttribute("list", list);

				forwardPath = "WEB-INF/add_submit.jsp";

			}
			else if(s_mode.equals("AddSubmitItems")) {

				// セッション用スコープに保存されているデータを利用する
				HttpSession session = request.getSession();

				// セッションスコープの "list" からインスタンスを取得
				ProductList list = (ProductList) session.getAttribute("list");

				// DAOを生成する
				OrderControlDBAccess dao = new OrderControlDBAccess();

				//商品リスト取得
				dao.AddProduct(list.getId(), list.getName(),list.getPrice());
				//スコープ
				ArrayList<ProductList> list_done = dao.selectProductId(list.getId());

				session.setAttribute("list", list_done);

				forwardPath = "WEB-INF/AllList.jsp";
			}
			else if(s_mode.equals("EditItems")) {
				String s_name = request.getParameter("s_name");
				int s_price = Integer.parseInt(request.getParameter("s_price"));
				String s_id = request.getParameter("s_id");
				String e_id = request.getParameter("e_id");

				ProductList list = new ProductList(s_name,s_id,s_price,e_id);
				//スコープ
				HttpSession session = request.getSession();
				session.setAttribute("list", list);

				forwardPath = "WEB-INF/edit_submit.jsp";
			}
			else if(s_mode.equals("EditSubmitItems")){

				// セッション用スコープに保存されているデータを利用する
				HttpSession session = request.getSession();

				// セッションスコープの "list" からインスタンスを取得
				ProductList list = (ProductList) session.getAttribute("list");

				// DAOを生成する
				OrderControlDBAccess dao = new OrderControlDBAccess();
				//商品リスト取得
				dao.EditProduct(list.getId(), list.getName(),list.getPrice(),list.getEid());
				//スコープ

				ArrayList<ProductList> list_done = dao.selectProductId(list.getId());

				session.setAttribute("list", list_done);

				forwardPath = "WEB-INF/AllList.jsp";
			}

			else if(s_mode.equals("DeleteItems")) {
				String e_id = request.getParameter("e_id");

				OrderControlDBAccess dao = new OrderControlDBAccess();
				//商品リスト取得
				ArrayList<ProductList> list = dao.DeleteProduct(e_id);
				//スコープ
				HttpSession session = request.getSession();
				session.setAttribute("list", list);

				forwardPath = "WEB-INF/AllList.jsp";

			}
			else {
				forwardPath = "WEB-INF/index.jsp";
			}

		// フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}

}
