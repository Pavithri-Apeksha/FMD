// let name = 'kamal';
// const obj = {
//     name:'Nimal',
//     print:function(){
//         console.log(name);
//         console.log(this.name);
//     }
// }
// obj.print();
let box = document.getElementById('box');
boxStatus = true;
const Show=()=>{
    if(boxStatus){
        box.style.display='block';
        //show
    }
    else{
        box.style.display='none';
        //hide
    }
    boxStatus=!boxStatus;
}