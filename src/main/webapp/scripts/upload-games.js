window.onload = () => {
	const uploadOption = document.getElementById("upload-option")
	const uploadMethod = document.getElementById("upload-method")

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

}
