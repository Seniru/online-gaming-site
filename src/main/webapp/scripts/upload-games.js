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
