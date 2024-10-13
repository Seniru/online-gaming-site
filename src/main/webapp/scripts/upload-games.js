function validate(event) {
	// validate title
	let title = document.getElementById("title").value
	if (title.length > 30) {
		alert("Title should not be more than 30 characters")
		return false
	}

	// validate description
	let description = document.getElementById("description").value
	if (description.length > 1024) {
		alert("Description should not be more than 1024 characters")
		return false
	}

	// validate cover image
	let imageLink = document.getElementById("image-link").value
	if (imageLink.length > 100) {
		alert("Image link should not be more than 100 characters")
		return false
	}

	if (!(/^http(s)?:\/\/.+\.(png|jpg|jpeg|gif)$/.test(imageLink))) {
		alert("Please enter a valid image link")
		return false
	}

	// validate url
	let url = document.getElementById("url").value
	if (url.length > 200) {
		alert("URL should not be more than 200 characters")
		return false
	}

	if (!(/^http(s)?:\/\/.+\..+$/.test(url))) {
		alert("Please enter a valid URL")
		return false
	}
}

window.onload = () => {
	const uploadOption = document.getElementById("upload-option")
	const uploadMethod = document.getElementById("upload-method")
	const imageLink = document.getElementById("image-link")
	const imagePreview = document.getElementById("image-preview")

	uploadOption.onchange = () => {
		if (uploadOption.value == "link") {
			uploadMethod.innerHTML = `
				<input type="text" placeholder="Enter link">
			`
		} else {
			uploadMethod.innerHTML = `
				Add file
				<input type="file">
			`
		}
	}

	imageLink.onchange = () => {
		imagePreview.innerHTML = `<img src="${imageLink.value}">`
	}

}
