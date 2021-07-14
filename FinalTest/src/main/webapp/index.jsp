<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Final Exam</title>
  <link rel="stylesheet" href="lib/bootstrap-4.6.0-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="view/css/style_of_me.css">
</head>
<body>
<div class="container-fluid" >
  <div class="h-auto" id="header-background">
    <div class="row head">
      <div class="col-3">
        <img src="view/img/logo.jpg" alt="Logo" height="100%" width="40%">
      </div>
      <div class="col-6"></div>
      <div class="col-3 text-center" style="line-height: 150px; font-size: 20px">
        <b>Tran Hong Gia Dong - C1220G2</b>
      </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-light bg-secondary">
      <a class="navbar-brand text-light" href="#">Home</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link text-light" href="http://localhost:8087/products">Product <span class="sr-only">(current)</span></a>
          </li>
          <%--          <li class="nav-item">--%>
          <%--            <a class="nav-link text-light" href="#"></a>--%>
          <%--          </li>--%>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
  </div>
  <div id="carouselExampleFade" class="carousel slide carousel-fade" data-ride="carousel">
    <div class="carousel-inner ">
      <div class="carousel-item active">
        <img src="view/img/body.jpg" class="d-block w-100" alt="..." >
      </div>
      <div class="carousel-item">
        <img src="view/img/courasel2.jpg" class="d-block w-100" alt="..." >
      </div>
      <div class="carousel-item">
        <img src="view/img/courasel3.jpg" class="d-block w-100" alt="..." >
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<div class="footer text-center"><h3>Final Exam</h3></div>
</body>
<script src="lib/jquery-3.6.0.min.js"></script>
<script src="lib/bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
</html>
