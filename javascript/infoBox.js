const infoBox = document.getElementById("infoBox");
const infoButtom = document.getElementById("infoButtom");
const pages = document.querySelectorAll('.infoPage');
const nextButtom = document.getElementById('nextPage');
const prevButtom = document.getElementById('prevPage');
let currentPage = 0;

init();

function init(){
    infoButtom.addEventListener('click', onInfoButtomClick);
    nextButtom.addEventListener('click', nextPage);
    prevButtom.addEventListener('click', prevPage);

    showPage(currentPage);
}

export function onInfoButtomClick(){
    if(infoBox.style.display == 'none'){
        infoBox.style.display = '';
        infoButtom.style.right = '335px';
        infoButtom.textContent = '▶';
    }
    else{
        infoBox.style.display = 'none';
        infoButtom.style.right = '16px';
        infoButtom.textContent = '◀';
    }
}

function showPage(index) {
    pages.forEach((page, i) => {
        page.classList.toggle('active', i === index);
    });
}

function nextPage() {
    currentPage = (currentPage + 1) % pages.length;
    showPage(currentPage);
}

function prevPage() {
    currentPage = (currentPage - 1 + pages.length) % pages.length;
    showPage(currentPage);
}