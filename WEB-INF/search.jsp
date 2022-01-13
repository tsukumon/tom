
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<link href="https://fonts.googleapis.com/css2?family=Kosugi&family=Noto+Sans+JP:wght@100&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>あいまいみー検索 | 検索フォーム</title>
</head>
<body>
<!-- フォーム -->

<div class="wrapper">
<!-- フォーム -->

<a href="MainController"><img src="tomcat.png"></a>

<div class="main">

  <div class="user-menu-mypage"><!--メニュー全体-->
  <p><a href="MainController">ホーム</a></p>
    <p><a href="MainController?action=AllList&sort=id">管理</a></p>
    <p class="now-currentmypage"><a href="MainController?action=SearchItem">曖昧検索</a></p>
    <p><a href="MainController?action=AddItem">新規登録</a></p>
    <span class="user-menu-mypage-bar"></span>
  </div>

<br>


<h2>検索</h2>
<p>商品名で、あいまい検索できます<br>
<br></p>

<div class="search-area">
<form  action = "MainController"  method="post">

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

<input type="text" name="s_name" id="s_name" placeholder="&#xf002; 商品名を入力してください...">

<input type="hidden" name="s_mode" value="SearchItems">
</form>
</div>
<!-- フォーム終了 -->

<br><br><br><br><br><br><br><br><br><br>
</div>

<fotter>©2020 tsukumon</fotter>
</div>

</body>
</html>