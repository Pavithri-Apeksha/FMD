let level = 1;
let sec = 0;
let min = 0;
let interval = null;
let x, y;
let operators = ['+', '-', '*', '/', '%'];
let answerData = [];
let correctAnswer;
let insertedAnswer;
let q_number = 0;
const selectedOp = document.getElementById('op');
const secElement = document.getElementById('sec');
const minElement = document.getElementById('min');
const number1 = document.getElementById('num1');
const number2 = document.getElementById('num2');
const selectElement = document.getElementById('form-controller');
const answerElement = document.getElementById('ans');
const qNUmberElement = document.getElementById('qnumber');
const cElement = document.getElementById('c');
const wElement = document.getElementById('w');
const sElement = document.getElementById('s');
const btnStartElement = document.getElementById('btn-start');
const tbodyElement = document.getElementById('answer-body');


selectElement.addEventListener("change", function () {
    console.log(selectElement.value);
    level = parseInt(selectElement.value);
});

const start = () => {
    btnStartElement.disabled = true;
    manageTime();
};

const manageTime = () => {
    q_number++;
    if (q_number > 10) {
        finalize();
        return;
    } else {
        qNUmberElement.textContent = q_number;
        min = 0;
        sec = 0;
        secElement.textContent = '00';
        minElement.textContent = '00';
        generateQuestion(level);
        clearInterval(interval);
        interval = setInterval(() => {
            sec++;
            if (sec < 10) {
                secElement.textContent = '0' + sec;
            } else {
                secElement.textContent = sec + '';
            }
            if (sec == 60) {
                sec = 0;
                min++;
                minElement.textContent = '0' + min;
            }
            if (min == 3) {
                min = 0;
                skipQuiz();
            }
        }, 1000);
    }
};

const generateQuestion = (selectedLevel) => {
    let maxNumber = 10;
    if (selectedLevel == 2) {
        maxNumber = 50;
    } else if (selectedLevel == 3) {
        maxNumber = 100;
    }

    x = Math.floor((Math.random() * maxNumber) + 1);
    y = Math.floor((Math.random() * maxNumber) + 1);
    number1.textContent = x;
    number2.textContent = y;

    selectedOperator = operators[Math.floor(Math.random() * 5)];
    selectedOp.textContent = selectedOperator;
};

const submitData = () => {
    insertedAnswer = parseFloat(answerElement.value);
    if (x && y && selectedOp.textContent && answerElement.value !== '') {
        switch (selectedOp.textContent) {
            case '+': correctAnswer = x + y; break;
            case '-': correctAnswer = x - y; break;
            case '*': correctAnswer = x * y; break;
            case '/': correctAnswer = x / y; break;
            case '%': correctAnswer = x % y; break;
        }
        if (correctAnswer === insertedAnswer) {
            let obj = {
                'q_number': q_number, 
                'Time': min + ':' + sec,
                'CorrectAnswer': correctAnswer,
                'userAnswer': insertedAnswer,
                'operator': selectedOp.textContent, 
                'first_number': x, 
                'last_number': y, 
                'isCorrect': true,
                'isSkip': false
            };
            answerData.push(obj);
        } else {
            let obj = {
                'q_number': q_number, 
                'Time': min + ':' + sec,
                'CorrectAnswer': correctAnswer,
                'userAnswer': insertedAnswer,
                'operator': selectedOp.textContent, 
                'first_number': x,
                'last_number': y, 
                'isCorrect': false,
                'isSkip': false
            };
            answerData.push(obj);
        }
        answerElement.value = '';
        manageTime(); 
        setStatistics();
        console.log(answerData);
    } else {
        alert('Try again');
    }
};

const skipQuiz = () => {
    if(q_number>10){
        finalize();
        return;
    }else{
        let obj = {
            'q_number': q_number,
            'Time': min + ':' + sec,
            'CorrectAnswer': correctAnswer, 
            'userAnswer': null,
            'operator': selectedOp.textContent, 
            'first_number': x, 
            'last_number': y, 
            'isCorrect': false, 
            'isSkip': true
        };
        answerData.push(obj);
    }
    manageTime(); 
    setStatistics();
};
const setStatistics=()=>{
    let c = 0;
    let w = 0;
    let s = 0;
    for(let p = 0 ;answerData.length>p;p++){
        let temp = answerData[p];
        if(temp.isCorrect){
            c++;
        }else{
            w++;
        }
        if(temp.isSkip){
            s++;
        }
    }
    cElement.textContent=c;
    wElement.textContent=w;
    sElement.textContent=s;
}
const reset = () =>{
    btnStartElement.disabled = false;
    answerData=[];
    setStatistics();
    q_number=0;
    qNUmberElement.textContent=q_number;
    clearInterval(interval);
    minElement.textContent='00';
    secElement.textContent='00';
    selectedOp.textContent='?';
    number1.textContent='?';
    number2.textContent='?';
    while(tbodyElement.firstChild){
        tbodyElement.removeChild(tbodyElement.firstChild);
    }
}
const finalize = ()=>{
    answerData.forEach(data=>{
        const row = document.createElement("tr");
        const cell1 = document.createElement("td");
        cell1.textContent=data.first_number;
        row.appendChild(cell1);
        const cell2 = document.createElement("td");
        cell2.textContent=data.operator;
        row.appendChild(cell2);
        const cell3 = document.createElement("td");
        cell3.textContent=data.last_number;
        row.appendChild(cell3);
        const cell4 = document.createElement("td");
        cell4.textContent=data.CorrectAnswer;
        row.appendChild(cell4);
        const cell5 = document.createElement("td");
        cell5.textContent=data.userAnswer;
        row.appendChild(cell5);
        const cell6 = document.createElement("td");
        cell6.textContent=data.isCorrect;
        row.appendChild(cell6);
        const cell7 = document.createElement("td");
        cell7.textContent=data.isSkip;
        row.appendChild(cell7);
        const cell8 = document.createElement("td");
        cell8.textContent=data.Time;
        row.appendChild(cell8);
        tbodyElement.appendChild(row);
    })
}