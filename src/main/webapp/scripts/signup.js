function validate(event) {
    // validate firstname and lastname
    let username = document.getElementById("username").value
    if (username.length > 20 || username.length > 20) {
        alert("Username cannot be more than 20 characters")
        return false
    }

	// validate email
	let email = document.getElementById("email").value
	if (email.length > 50) {
		alert("Email is too long. Should be less than 50 characters");
		return false;
	}

    // validate password
    let password = document.getElementById("password").value
    if (password.length < 10) {
        alert("Password must be more than 10 characters long")
        return false
    }
    if (password.length > 20) {
        alert("Password should not be more than 20 characters long")
        return false
    }

    // check password and confirmation password are equal
    let confPass = document.getElementById("re-password").value
    if (password != confPass) {
        alert("Password and confirmation password should match")
        return false
    }

}