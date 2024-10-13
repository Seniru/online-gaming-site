function validate() {
    // card number validation
    let cardNumber = document.getElementById("cdNO").value
    if (cardNumber.length != 16) {
        alert("Card number should be 16 digits long")
        return false
    }

    // expiry date validation
    let expiry = document.getElementById("exdate").value
    if (!(/\d{2,2}\/\d{2,2}/.test(expiry))) {
        alert("Expiry date should be in the format MM/YY")
        return false
    }

    // CVV validation
    let cvv = document.getElementById("cvv").value
    if (!(/\d{3,3}/.test(cvv))) {
        alert("Please enter a valid CVV")
        return false
    }

}