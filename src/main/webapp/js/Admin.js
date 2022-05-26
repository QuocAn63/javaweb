    /**
 * 
 */

const adminSideBarButton = document.querySelectorAll(".sidebar_item_link")
const uploadImageInput = document.querySelector(".image_controller input")
const imagePreviewElement = document.querySelector(".image_preview_side .image_holder .image")
const searchParams = new URLSearchParams(window.location.search);
const deleteProductButtons = document.querySelectorAll("#admin_shop .button.delete");
const selectStatusElement = document.querySelector("select[name='INVOICE_STATUS']")

window.onload = () => {
	if(selectStatusElement) {
		selectStatusElement.value = searchParams.get("status") || "all";
	}
}

adminSideBarButton.forEach(button => {
    if(button.dataset.site === searchParams.get("site") || (button.dataset.site === "shop" && searchParams.get("site") == undefined)) {
        button.classList.add("current")
    }
})

if( uploadImageInput ) {
	uploadImageInput.onchange = e => {
	var file = e.target.files[0];
    var url = URL.createObjectURL(file);

    imagePreviewElement.style.backgroundImage = ` url(${ url }) `;
}
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

const handleDeleteProduct = (PRODUCT_ID) => {
	var form = document.querySelector("#product_form")
	form.action = `AdminProduct?action=delete&PRODUCT_ID=${ PRODUCT_ID }`;
	form.method = "POST";
	
	form.submit();
}

const handleCancelProduct = (PRODUCT_ID) => {
	var form = document.querySelector("#product_form")
	form.action = `AdminProduct?action=cancel&PRODUCT_ID=${ PRODUCT_ID }`;
	form.method = "POST";
	
	form.submit();
}

const handleDeleteUser = (USER_ID) => {
	var form = document.querySelector("#user_form")
	form.action = `AdminUser?action=delete&USER_ID=${ USER_ID }`;
	form.method = "POST";
	
	form.submit();
}

const handleCancelUser = (USER_ID) => {
	var form = document.querySelector("#user_form")
	form.action = `AdminUser?action=cancel&USER_ID=${ USER_ID }`;
	form.method = "POST";
	
	form.submit();
}

function insertParam(key, value) {			
		    key = encodeURIComponent(key);
		    value = encodeURIComponent(value);

		    
		    
		    // kvp looks like ['key1=value1', 'key2=value2', ...]
		    var kvp = document.location.search.substr(1).split('&');
		    let i=0;

		    for(; i<kvp.length; i++){
		        if (kvp[i].startsWith(key + '=')) {
		            let pair = kvp[i].split('=');
		            pair[1] = value;
		            kvp[i] = pair.join('=');
		            break;
		        }
		    }

		    if(i >= kvp.length){
		        kvp[kvp.length] = [key,value].join('=');
		    }

		    // can return this or...
		    let params = kvp.join('&');

		    // reload page with new params
		    document.location.search = params;
		}