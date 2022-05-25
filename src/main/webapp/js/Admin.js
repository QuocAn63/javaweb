    /**
 * 
 */

const adminSideBarButton = document.querySelectorAll(".sidebar_item_link")
const uploadImageInput = document.querySelector(".image_controller input")
const imagePreviewElement = document.querySelector(".image_preview_side .image_holder .image")
const searchParams = new URLSearchParams(window.location.search);

adminSideBarButton.forEach(button => {
    if(button.dataset.site === searchParams.get("site") || (button.dataset.site === "shop" && searchParams.get("site") == undefined)) {
        button.classList.add("current")
    }
})


uploadImageInput.onchange = e => {
	var file = e.target.files[0];
    var url = URL.createObjectURL(file);

    imagePreviewElement.style.backgroundImage = ` url(${ url }) `;
}

const seasonRendering = (SEASON) => {
	switch(SEASON) {
		case "spring": return "Xuân";
		case "summer": return "Hạ";
		case "attumn": return "Thu";
		case "winter": return "Đông";
		
		default: return "Tất cả"
	}
}