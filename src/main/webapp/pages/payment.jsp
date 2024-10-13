
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!--google fonts-->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">		<link rel="stylesheet" href="../styles/components.css">
		<link rel="stylesheet" href="styles/components.css">
		<link rel="stylesheet" href="styles/payment.css">
        <script src="scripts/payment.js"></script>
		<!--font awesome-->
		<script src="https://kit.fontawesome.com/36fdbb8e6c.js" crossorigin="anonymous"></script>
		<title>Payment</title>
	</head>
	<body>
		<div class="wrapper">
		 <br>
        <h1>PAYMENT AND CONFIRMATION</h1>
        <form class="container" method="POST" action="profile" onsubmit="return validate()">

            <br>
            <h2 id="caption"> Card Details </h2>
            <br>

            <h3>Card Number:</h3>
            <input type="text" name="cardnumber" id="cdNO" required><br>

            <h3>Expiry Date:</h3>
            <input type="text" name="exdate" id="exdate" required><br>

            <h3>Security Code:</h3>
            <input type="text" name="securitycode" id="cvv" required><br><br>

            <label>
                <input type="radio" name="paymentmode" value="Paypal">
                <i class="fa-brands fa-cc-paypal"></i>
            </label>
            <label>
                <input type="radio" name="paymentmode" value="Visa">
                <i class="fa-brands fa-cc-visa"></i>
            </label>
            <label>
                <input type="radio" name="paymentmode" value="Mastercard">
                <i class="fa-brands fa-cc-mastercard"></i>
            </label>
            <label>
                <input type="radio" name="paymentmode" value="Amazonpay">
                <i class="fa-brands fa-cc-amazon-pay"></i>
            </label>


            <br><br>

            <input type="checkbox" name="agree">
            I Agree to terms and conditions <a href="policy.php">Terms of use</a>

            <br><br>
            <input type="text" name="action" value="become-pro" hidden readonly>
            <input id="bank_confirm" type="submit" value="Confirm Payment">

        </form>
		</div>
	</body>
</html>
