<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ProductList, java.util.List" %>
<%
	ProductList list = (ProductList) session.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<link href="https://fonts.googleapis.com/css2?family=Kosugi&family=Noto+Sans+JP:wght@100&display=swap" rel="stylesheet">
<title>あいまいみー検索 | 登録内容の確認</title>
</head>
<body>


<div class="wrapper">
<!-- フォーム -->

<a href="MainController"><img src="tomcat.png"></a>

<div class="main">

  <div class="user-menu-mypage"><!--メニュー全体-->
  <p><a href="MainController">ホーム</a></p>
    <p><a href="MainController?action=AllList&sort=id">管理</a></p>
    <p><a href="MainController?action=SearchItem">曖昧検索</a></p>
    <p class="now-currentmypage"><a href="MainController?action=AddItem">新規登録</a></p>
    <span class="user-menu-mypage-bar"></span>
  </div>

<br>


<h2>登録内容の確認</h2>
<p>登録内容を確認してください。<br><br>
この情報で宜しければ適用ボタンを押してください。
<br></p>
<div class="form-area">
<form action = "MainController"  method="post">

<p>商品ID</p>
<input type="text" name="s_id" placeholder="<%=list.getId()%>" disabled>

<p>商品名</p>
<input type="text" name="s_name" placeholder="<%=list.getName()%>" disabled>

<p>価格</p>
<input type="text" name="s_price" placeholder="<%=list.getPrice()%>" disabled>

<div class="submit-button">
<input type="hidden" name="s_mode" value="AddSubmitItems">
<input type="submit" value="登録する">
</div>
</form>
</div>
</div>

<br><br><br>
<fotter>©2020 tsukumon</fotter>
</div>
<!-- フォーム終了 -->



</body>
</html>