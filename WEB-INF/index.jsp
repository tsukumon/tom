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
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<link href="https://fonts.googleapis.com/css2?family=Kosugi&family=Noto+Sans+JP:wght@100&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<title>あまいみー検索 | トップページ</title>

<style>

</style>

</head>
<body>

<div class="wrapper">
<!-- フォーム -->

<a href="MainController"><img src="tomcat.png"></a>

<div class="main">

  <div class="user-menu-mypage"><!--メニュー全体-->
  <p><a href="MainController">ホーム</a></p>
    <p><a href="MainController?action=AllList&sort=id">管理</a></p>
    <p ><a href="MainController?action=SearchItem">曖昧検索</a></p>
    <p><a href="MainController?action=AddItem">新規登録</a></p>
    <span class="user-menu-mypage-bar"></span>
  </div>

<br>
<h2>webサイト情報</h2>
<p>
   概要: DBの商品テーブルをごちゃごちゃするwebアプリケーション。<br>
   実装された機能: 全件検索、曖昧検索、新規登録、編集、削除<br>
   変更点: カラム「商品ID」をユニークに。<br>
   <br>
   製作者: tsukumon<br>
</p>

<br>

<h2>ランダムで商品を表示</h2>
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




















