<%--
  Created by IntelliJ IDEA.
  User: Anouk
  Date: 1/6/2021
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title>Cocktail Picker</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/style.css">
    <style>
        input[type=text], select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
            text-align-last: center;
        }
    </style>

</head>

<body style="background-image: url(images/cocktails.jpg);">

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setHeader("Expires", "0"); // Proxies.

    if(session.getAttribute("Username")==null)
    {
        response.sendRedirect("login.jsp");
    }

%>

<div class="header">
    <a class="navbar-brand scroll-top" style="text-align: left; font-size: 20px;"><b>WELCOME "${Username}"! </b></a>
    <a href="<%=request.getContextPath()%>/LogoutServlet" class="navbar-brand scroll-top" style="float: right; border: 2px solid darkred;">LOG OUT</a>
    <div class="container">
        <a href="#" class="navbar-brand scroll-top" style="text-align:center; font-size: 40px; display:block;">Cocktail Picker</a>
    </div>
</div>
<!--header-->

<!--Find cocktail section-->
<section id="choose_c">
    <div class="container" style="border: 4px solid navajowhite;">
        <div class="row">
            <div class="col-md-12">
                <div class="heading">
                    <h2 style="text-align:center; color:white; display:block;">Fill out the form below to find the perfect cocktail for you!</h2>
                </div>
            </div>
                <div class="container" style="text-align:center;">
                    <form action="/action_page.php">
                       <label for="base">Base liquor:</label>
                        <select id="base" name="base">
                            <option value="vodka">Vodka</option>
                            <option value="gin">Gin</option>
                            <option value="whiskey">Whiskey</option>
                            <option value="Rum">Rum</option>
                        </select>

                        <label for="taste">Taste:</label>
                        <select id="taste" name="taste">
                            <option value="sweet">Sweet</option>
                            <option value="sour">Sour</option>
                            <option value="spicy">Spicy</option>
                            <option value="sweet&sour">Sweet & Sour</option>
                            <option value="sweet&spicy">Sweet & Spicy</option>
                        </select>

                        <label>Possible Allergies:</label>
                        <div>
                            <input type="checkbox" id="nuts" name="nuts">
                            <label for="nuts">Nuts</label>
                        </div>
                        <div>
                            <input type="checkbox" id="egg_white" name="egg_white">
                            <label for="egg_white">Egg White</label>
                        </div>
                    </form>
                    <br>
                    <div>
                        <input type="submit" value="SUBMIT" style="background-color: mediumseagreen; width: 50%;">
                    </div>
                    <br>
                </div>
        </div>
    </div>
</section>

<p><br><br></p>

<!--Choose cocktail section-->
<section class="drinks">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="heading">
                    <h2 style="text-align:center; color:white; display:block;">Choose by category:</h2>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="service-item">
                    <a href="menu.html">
                        <img src="images/vodka.png" alt="Vodka">
                        <h4 style="color: navajowhite;">Vodka</h4>
                    </a>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="service-item">
                    <a href="menu.html">
                        <img src="images/gin.png" alt="Gin">
                        <h4 style="color: navajowhite;">Gin</h4>
                    </a>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="service-item">
                    <a href="menu.html">
                        <img src="images/whiskey.png" alt="Whiskey">
                        <h4 style="color: navajowhite;">Whiskey</h4>
                    </a>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="service-item">
                    <a href="menu.html">
                        <img src="images/rum.png" alt="Rum">
                        <h4 style="color: navajowhite;">Rum</h4>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
