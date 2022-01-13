package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderControlDBAccess {

	//DBとの接続を確立
	private Connection createConnection() {
		Connection conn = null;
		try {
			//JDBC読み込み
			Class.forName("org.mariadb.jdbc.Driver");

			//DB接続
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost/db11904164","user11904164", "11904164");
			//ドライバないときのエラー
		}catch(ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
			//SQL処理関係の失敗
		}catch(SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました");
			e.printStackTrace();

		}
		return conn;
	}

	//DBとの接続を閉じる
	private void closeConnection(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました");
			e.printStackTrace();
		}
	}//商品リストを取得する

	public ArrayList<ProductList> findAllProducts(){
		Connection conn = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductList> list = new ArrayList<ProductList>();
		try {
				if(conn != null) {
					String sql = "select 商品ID,商品名,単価 from 商品マスタ";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						String id = rs.getString("商品ID");
						String name= rs.getString("商品名");
						int price = rs.getInt("単価");
						ProductList bean = new ProductList(id,name,price);
						list.add(bean);
					}
				}
		}catch(SQLException e) {
			System.out.println("DB切断時にエラーが発生しました(商品検索)");
			e.printStackTrace();
		}finally {
			try {
					if(rs != null) {
						rs.close();
					}
			}catch(SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました");
				e.printStackTrace();
			}
		}
		closeConnection(conn);
		return list;
	}

	public ArrayList<ProductList> findSortIdProducts(){

		//接続
		Connection conn = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductList> list = new ArrayList<ProductList>();
		try{
			if(conn != null){
				String sql = "SELECT 商品ID,商品名,単価 from 商品マスタ order by 商品ID ASC";

				 pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();
				while (rs.next() ){
					String id = rs.getString("商品ID");
					String name = rs.getString("商品名");
					int price = rs.getInt("単価");
					ProductList bean = new ProductList(id,name,price);
					list.add(bean);
				}
			}
		}catch(SQLException e){
			System.out.println("DB切断時にエラーが発生しました。（商品検索）");
			e.printStackTrace();
		} finally{
			try{
				if (rs != null){
					rs.close();
				}
			}catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try{
				if (pstmt != null){
					pstmt.close();
				}
			}catch (SQLException e){
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		closeConnection(conn);
		return list;
	}
	public ArrayList<ProductList> findSortNameProducts(){

		//接続
		Connection conn = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductList> list = new ArrayList<ProductList>();
		try{
			if(conn != null){
				String sql = "SELECT 商品ID,商品名,単価 from 商品マスタ order by 商品名 ASC";

				 pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();
				while (rs.next() ){
					String id = rs.getString("商品ID");
					String name = rs.getString("商品名");
					int price = rs.getInt("単価");
					ProductList bean = new ProductList(id,name,price);
					list.add(bean);
				}
			}
		}catch(SQLException e){
			System.out.println("DB切断時にエラーが発生しました。（商品検索）");
			e.printStackTrace();
		} finally{
			try{
				if (rs != null){
					rs.close();
				}
			}catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try{
				if (pstmt != null){
					pstmt.close();
				}
			}catch (SQLException e){
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		closeConnection(conn);
		return list;
	}
	public ArrayList<ProductList> findSortPriceProducts(){

		//接続
		Connection conn = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductList> list = new ArrayList<ProductList>();
		try{
			if(conn != null){
				String sql = "SELECT 商品ID,商品名,単価 from 商品マスタ order by 単価 ASC";

				 pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();
				while (rs.next() ){
					String id = rs.getString("商品ID");
					String name = rs.getString("商品名");
					int price = rs.getInt("単価");
					ProductList bean = new ProductList(id,name,price);
					list.add(bean);
				}
			}
		}catch(SQLException e){
			System.out.println("DB切断時にエラーが発生しました。（商品検索）");
			e.printStackTrace();
		} finally{
			try{
				if (rs != null){
					rs.close();
				}
			}catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try{
				if (pstmt != null){
					pstmt.close();
				}
			}catch (SQLException e){
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		closeConnection(conn);
		return list;
	}

	public ArrayList<ProductList> findlimitProducts(){
		Connection conn = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductList> list = new ArrayList<ProductList>();
		try {
				if(conn != null) {
					String sql = "select 商品ID,商品名,単価 from 商品マスタ ORDER BY RAND() LIMIT 3";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						String id = rs.getString("商品ID");
						String name= rs.getString("商品名");
						int price = rs.getInt("単価");
						ProductList bean = new ProductList(id,name,price);
						list.add(bean);
					}
				}
		}catch(SQLException e) {
			System.out.println("DB切断時にエラーが発生しました(商品検索)");
			e.printStackTrace();
		}finally {
			try {
					if(rs != null) {
						rs.close();
					}
			}catch(SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました");
				e.printStackTrace();
			}
		}
		closeConnection(conn);
		return list;
	}

	//あいまい検索
	public ArrayList<ProductList> selectProductPlace(String search){

		//接続
		Connection conn = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductList> list = new ArrayList<ProductList>();
		try{
			if(conn != null){
				String sql = "SELECT 商品ID,商品名,単価 from 商品マスタ where 商品名 like ?";

				 pstmt = conn.prepareStatement(sql);

				//プレースホルダに挿入
				pstmt.setString(1, "%"+search+ "%");

				rs = pstmt.executeQuery();
				while (rs.next() ){
					String id = rs.getString("商品ID");
					String name = rs.getString("商品名");
					int price = rs.getInt("単価");
					ProductList bean = new ProductList(id,name,price);
					list.add(bean);
				}
			}
		}catch(SQLException e){
			System.out.println("DB切断時にエラーが発生しました。（商品検索）");
			e.printStackTrace();
		} finally{
			try{
				if (rs != null){
					rs.close();
				}
			}catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try{
				if (pstmt != null){
					pstmt.close();
				}
			}catch (SQLException e){
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		closeConnection(conn);
		return list;
	}

	//あいまい検索
		public ArrayList<ProductList> selectProductId(String search){

			//接続
			Connection conn = createConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProductList> list = new ArrayList<ProductList>();
			try{
				if(conn != null){
					String sql = "SELECT 商品ID,商品名,単価 from 商品マスタ where 商品ID = ?";

					 pstmt = conn.prepareStatement(sql);

					//プレースホルダに挿入
					pstmt.setString(1, search);

					rs = pstmt.executeQuery();
					while (rs.next() ){
						String id = rs.getString("商品ID");
						String name = rs.getString("商品名");
						int price = rs.getInt("単価");
						ProductList bean = new ProductList(id,name,price);
						list.add(bean);
					}
				}
			}catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。（商品検索）");
				e.printStackTrace();
			} finally{
				try{
					if (rs != null){
						rs.close();
					}
				}catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
				try{
					if (pstmt != null){
						pstmt.close();
					}
				}catch (SQLException e){
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			closeConnection(conn);
			return list;
		}


	//商品登録
	public ArrayList<ProductList> AddProduct(String id, String name, int price){
		//接続
		Connection conn = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductList> list = new ArrayList<ProductList>();
		try{
			if(conn != null){
				String sql = "insert into 商品マスタ values(?,?,?);";

				 pstmt = conn.prepareStatement(sql);

				//プレースホルダに挿入
				pstmt.setString(1,id);
				pstmt.setString(2,name);
				pstmt.setInt(3,price);
				rs = pstmt.executeQuery();

				sql = "select 商品ID,商品名,単価 from 商品マスタ";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next() ){
					String id1 = rs.getString("商品ID");
					String name1 = rs.getString("商品名");
					int price1 = rs.getInt("単価");
					ProductList bean = new ProductList(id1,name1,price1);
					list.add(bean);
				}
			}
		}catch(SQLException e){
			System.out.println("DB切断時にエラーが発生しました。（商品検索）");
			e.printStackTrace();
		} finally{
			try{
				if (rs != null){
					rs.close();
				}
			}catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try{
				if (pstmt != null){
					pstmt.close();
				}
			}catch (SQLException e){
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		closeConnection(conn);
		return list;
	}

	//商品登録
		public ArrayList<ProductList> EditProduct(String id, String name, int price, String e_id){
			//接続
			Connection conn = createConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProductList> list = new ArrayList<ProductList>();
			try{
				if(conn != null){
					String sql = "update 商品マスタ set 商品ID = ? ,商品名 = ?, 単価 = ? where 商品ID = ?;";

					 pstmt = conn.prepareStatement(sql);

					//プレースホルダに挿入
					pstmt.setString(1,id);
					pstmt.setString(2,name);
					pstmt.setInt(3,price);
					pstmt.setString(4,e_id);
					rs = pstmt.executeQuery();

					sql = "select 商品ID,商品名,単価 from 商品マスタ";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next() ){
						String id1 = rs.getString("商品ID");
						String name1 = rs.getString("商品名");
						int price1 = rs.getInt("単価");
						ProductList bean = new ProductList(id1,name1,price1);
						list.add(bean);
					}
				}
			}catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。（商品検索）");
				e.printStackTrace();
			} finally{
				try{
					if (rs != null){
						rs.close();
					}
				}catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
				try{
					if (pstmt != null){
						pstmt.close();
					}
				}catch (SQLException e){
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			closeConnection(conn);
			return list;
		}


		//商品登録
				public ArrayList<ProductList> DeleteProduct(String id){
					//接続
					Connection conn = createConnection();
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ArrayList<ProductList> list = new ArrayList<ProductList>();
					try{
						if(conn != null){
							String sql = "delete from 商品マスタ where 商品ID = ?;";

							 pstmt = conn.prepareStatement(sql);

							//プレースホルダに挿入
							pstmt.setString(1,id);
							rs = pstmt.executeQuery();

							sql = "select 商品ID,商品名,単価 from 商品マスタ";
							pstmt = conn.prepareStatement(sql);
							rs = pstmt.executeQuery();
							while (rs.next() ){
								String id1 = rs.getString("商品ID");
								String name1 = rs.getString("商品名");
								int price1 = rs.getInt("単価");
								ProductList bean = new ProductList(id1,name1,price1);
								list.add(bean);
							}
						}
					}catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。（商品検索）");
						e.printStackTrace();
					} finally{
						try{
							if (rs != null){
								rs.close();
							}
						}catch (SQLException e){
							System.out.println("DB切断時にエラーが発生しました。");
							e.printStackTrace();
						}
						try{
							if (pstmt != null){
								pstmt.close();
							}
						}catch (SQLException e){
							System.out.println("DBアクセス時にエラーが発生しました。");
							e.printStackTrace();
						}
					}
					closeConnection(conn);
					return list;
				}





}
