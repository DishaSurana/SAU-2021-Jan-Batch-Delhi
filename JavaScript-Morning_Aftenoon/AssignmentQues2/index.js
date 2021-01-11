resetColor = () => {

    let divisionsCol = document.getElementsByName('numDivs');

    for(let i=0; i<divisionsCol.length ; i++){
        divisionsCol[i].classList.remove('evenColor');
        divisionsCol[i].classList.remove('multiple5Color');
        divisionsCol[i].classList.add('removeColor');
    }

}

highlightEven = () => {

    let divisionsCol = document.getElementsByName('numDivs');
    resetColor();
    for(let i=0; i<divisionsCol.length ; i++){
        if((i+1)%2 == 0)
            divisionsCol[i].classList.add('evenColor');
    }

}

highlight5Multiple = () => {

    let divisionsCol = document.getElementsByName('numDivs');
    resetColor();
    for(let i=0; i<divisionsCol.length ; i++){
        if((i+1)%5 == 0)
            divisionsCol[i].classList.add('multiple5Color');
    }

}