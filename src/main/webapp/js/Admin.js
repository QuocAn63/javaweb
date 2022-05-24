    /**
 * 
 */

const adminSideBarButton = document.querySelectorAll(".sidebar_item_link")
const searchParams = new URLSearchParams(window.location.search);

adminSideBarButton.forEach(button => {
    if(button.dataset.site === searchParams.get("site") || (button.dataset.site === "shop" && searchParams.get("site") == undefined)) {
        button.classList.add("current")
    }
})