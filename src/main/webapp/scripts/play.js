let saveGame = () => {
	console.log("this")
	const params = new URLSearchParams(location.search)
    const title = params.get('title')

	fetch("./profile?action=save-game&title=" + title)
}