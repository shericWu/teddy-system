const infoBox = document.getElementById("infoBox");
const infoButtom = document.getElementById("infoButtom");
init();

function init(){
    infoButtom.addEventListener('click', onButtomClick);
}

function onButtomClick(){
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