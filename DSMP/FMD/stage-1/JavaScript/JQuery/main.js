// const trigger=()=>{
//     $('#box').toggle(1000)
// }
const loadData=()=>{
    $('.loader').show();
    $.ajax({
        url:'https://jsonplaceholder.typicode.com/posts',
        method:'GET',
        dataType:'json',
        success:(data)=>{
            console.log(data);
            data.forEach(element => {
                const row=`
                <tr>
                    <td>${element.userId}</td>
                    <td>${element.id}</td>
                    <td>${element.title}</td>
                </tr>
                `;
                $('#tbody').append(row);
            });
            $('.loader').hide();
        },
        error:(error)=>{
            console.log(error);
            $('.loader').hide();
        }
    })
}