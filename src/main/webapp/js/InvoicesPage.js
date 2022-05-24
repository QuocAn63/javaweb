
const invoiceFilterButton = document.querySelectorAll(".invoice_side_filter .item_link");

invoiceFilterButton.forEach( button => {
    if(button.dataset.type === searchParams.get("type") || (button.dataset.type === "all" && searchParams.get("type") == undefined)) {
        button.classList.add("current");
    }
})