
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <title>Customer List</title>
</head>
<body>
<div class="jumbotron text-center" style="margin-top:2px;height: 5px">
    <img src="assert/image/logo@2x.png" width="80px" height="70px" style="float: left" alt="Logo">
    <h1 style="float: right">Nguyen Ngoc Dong</h1>
</div>
<div class="menu-fluid">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="">
        <a class="navbar-brand" href="index.jsp">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/employee">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/service">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contract">Contract</a>
                </li>
            </ul>

        </div>
        <form class="d-flex" style="float: right">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </nav>
</div>


<div class="container-fluid" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-2">

            <h3>Customer List</h3>
            <p></p>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <hr class="d-sm-none">
        </div>
        <div class="col-sm-10 container-fluid">
            <h2>PHONG CÁCH Furuma</h2>
            <h5>Title description, Dec 3, 2021</h5>

            <div class="" >
                <img src="assert/image/menu.jpg" alt="Logoa" style="height:500px;width: 100% ">
            </div>
            <br>
            <p>Furuma Retreat là sự kết hợp hài hòa giữa những di sản, văn hóa Việt Nam vượt thời gian cùng vẻ thanh lịch
                của kiến trúc đương đại. Tạo ấn tượng bởi kiến trúc tre truyền thống, sự tinh tế trong trang trí nội
                thất cùng lòng mến khách của người Việt, Naman Retreat tự tin mang đến cho bạn một trải nghiệm nghỉ
                dưỡng tuyệt vời.

                Furuma Retreat - chốn nghỉ dưỡng hoàn hảo cho những ai mong mỏi tìm kiếm sự phá cách, độc đáo cùng khao
                khát đánh thức các giác quan của riêng mình. Chúng tôi làm nhòa đi ranh giới giữa nghỉ dưỡng và trị liệu
                spa, mang đến không gian sống thoải mái cùng các cơ hội làm dịu tâm trí, chữa lành thân thể cũng như làm
                mới lại tâm hồn. Naman Retreat khơi nguồn cảm hứng, mang đến sự đổi mới và làm phong phú cho cuộc sống
                của chính bạn.

                Chúng tôi mong muốn mang lại những trải nghiệm kỳ diệu và thú vị cho từng khách hàng của mình. Mọi nhu
                cầu và ước nguyện của quý khách đều được đáp ứng trọn vẹn khi quý vị bắt đầu hành trình ‘Sống. Trải
                nghiệm. Đam mê.’ của riêng mình.</p>

            <br>
            <h2>TITLE HEADING</h2>
            <h5>Title description, Sep 2, 2017</h5>
            <div class="fakeimg">Fake Image</div>

        </div>
    </div>
</div>

<footer class="bg-dark text-center text-white">
    <!-- Grid container -->
    <div class="container p-4 pb-0">
        <!-- Section: Form -->
        <section class="">
            <form action="">
                <!--Grid row-->
                <div class="row d-flex justify-content-center">
                    <!--Grid column-->
                    <div class="col-auto">
                        <p class="pt-2">
                            <strong>Sign up for our newsletter</strong>
                        </p>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-md-5 col-12">
                        <!-- Email input -->
                        <div class="form-outline form-white mb-4">
                            <input type="email" id="form5Example2" class="form-control"/>
                            <label class="form-label" for="form5Example2">Email address</label>
                        </div>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-auto">
                        <!-- Submit button -->
                        <button type="submit" class="btn btn-outline-light mb-4">
                            Subscribe
                        </button>
                    </div>
                    <!--Grid column-->
                </div>
                <!--Grid row-->
            </form>
        </section>
        <!-- Section: Form -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2021 Case Study:
        <a class="text-white" href="#">Nguyen Ngoc Dong </a>
    </div>
    <!-- Copyright -->
</footer>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
