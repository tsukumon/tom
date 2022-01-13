<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.ProductList,java.util.List" %>

 <%
 	List<ProductList> list = (List<ProductList>)session.getAttribute("list");
 %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<link href="https://fonts.googleapis.com/css2?family=Kosugi&family=Noto+Sans+JP:wght@100&display=swap" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>あいまいみー検索 | 編集</title>
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

<br>


<h2>編集</h2>
<p>てーぶるの商品情報を編集しましょう。<br>
商品IDはユニークなので重複は許されません。<br>
※削除はページ下部でできます。<br>
<br></p>

<div class="form-area">
<% for(ProductList lst: list){%>
<form action = "MainController"  method="post">
<p>商品ID</p>
<input type="text" name="s_id" value="<%=lst.getId()%>">

<p>商品名</p>
<input type="text" name="s_name" value="<%=lst.getName()%>">

<p>価格</p>
<input type="text" name="s_price" value="<%=lst.getPrice()%>">

<div class="submit-button">
<input type="hidden" name="e_id" value="<%=lst.getId()%>">
<input type="hidden" name="s_mode" value="EditItems">
<input type="submit" value="編集">
</div>
</form>
<% }%>
</div>
</div>
<br>
<h2>削除</h2>
<p>一度消えた情報は元に戻りません。ボタンを押した瞬間削除されます。注意してください。<br>
<br></p>

<div class="submit-area2-area">
      <div class="submit-area2">
      <% for(ProductList lst: list){%>
      <form action = "MainController"  method="post">

      <input type="hidden" name="e_id" value="<%=lst.getId()%>">
      <input type="hidden" name="s_mode" value="DeleteItems">
      <input type="submit" name="delete" value="削除する" formmethod="post">
<% }%>
      </form></div>
</div>
<br><br>
<fotter>©2020 tsukumon</fotter>
</div>

</body>
</html>