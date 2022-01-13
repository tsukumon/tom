<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import = "model.ProductList,java.util.List" %>

 <%
 	List<ProductList> list = (List<ProductList>)session.getAttribute("list");
 %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<link href="https://fonts.googleapis.com/css2?family=Kosugi&family=Noto+Sans+JP:wght@100&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>あいまいみー検索 | 全データ</title>
</head>
<body>

<div class="wrapper">
<!-- フォーム -->

<a href="MainController"><img src="tomcat.png"></a>

<div class="main">

  <div class="user-menu-mypage"><!--メニュー全体-->
  <p><a href="MainController">ホーム</a></p>
    <p class="now-currentmypage"><a href="MainController?action=AllList&sort=id">管理</a></p>
    <p><a href="MainController?action=SearchItem">曖昧検索</a></p>
    <p><a href="MainController?action=AddItem">新規登録</a></p>
    <span class="user-menu-mypage-bar"></span>
  </div>

<br><br>

 <div class="search-area">
<form  action = "MainController"  method="post">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

<input type="text" name="s_name" id="s_name" placeholder="&#xf002; 商品名を入力してください...">
<input type="hidden" name="s_mode" value="SearchItems">
</form>
</div>
<br><br>

<h2>商品一覧</h2>
<p>
下のボタンで並び替え可能。
<br><br>
クリックして商品を編集・削除することができます。<br>
バリデーションは設定していません。</p>
<div class="ranking-menu-hide">
<a href="MainController?action=AllList&sort=id">商品コード順</a>
<a href="MainController?action=AllList&sort=name">商品名順</a>
<a href="MainController?action=AllList&sort=price">単価順</a>
</div>
<br>
<div class="list">

<table class="table_box">
  <tr>
  <th>商品コード</th>
    <th>商品名</th>
    <th>価格</th>
  </tr>

<% for(ProductList lst: list){%>

  <tr>

    <td><a href="MainController?action=edit&code=<%=lst.getId()%>"><%= lst.getId() %></a></td>
    <td><a href="MainController?action=edit&code=<%=lst.getId()%>"><%= lst.getName() %></a></td>
    <td><a href="MainController?action=edit&code=<%=lst.getId()%>"><%= lst.getPrice() %></a></td>
  </tr>
</a>



</div>
<% }%>
</table>
</div>
</div>
<br><br>
<fotter>©2020 tsukumon</fotter>
</div>

</body>
</html>
