let addCategory = evt => {
	let urlParams = new URLSearchParams(location.search)
	let categories = []
	if (urlParams.get("categories")) categories = urlParams.get("categories").split(",")
	categories.push(evt.target.getElementsByClassName("name-container")[0].innerText)
	urlParams.set("categories", categories.join(","))
	window.location = "explore?" + urlParams.toString()
}

let removeCategory = evt => {
	let urlParams = new URLSearchParams(location.search)
	let categories = []
	if (urlParams.get("categories")) categories = urlParams.get("categories").split(",")
	categories.splice(
		categories.indexOf(evt.target.parentElement.getElementsByClassName("name-container")[0].innerText),
		1
	)
	urlParams.set("categories", categories.join(","))
	window.location = "explore?" + urlParams.toString()
}

window.onload = () => {
	let go = document.getElementById("Gobutton")
	let query = document.getElementById("game-search")
	go.onclick = () => {
		let urlParams = new URLSearchParams(location.search)
		urlParams.set("query", query.value)
		window.location = "explore?" + urlParams.toString()
	}
}