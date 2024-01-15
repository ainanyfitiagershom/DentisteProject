function AfficheDonne(Data , count){
    const all_teeth = document.querySelectorAll('.teeth')[count];
    const content_table_after = all_teeth.querySelector('.after');
    const table = content_table_after.querySelector('table');
    const reste = all_teeth.querySelector('.reste')
    table.innerHTML=""
    const new_teeth = Data[0]
    console.log(new_teeth)
    const tr_title = 
        `  
            <tr>
                <th>Numero dents</th>
                <th>Emplacement</th>
                <th>Etat</th>
            </tr>
        `
    table.innerHTML += tr_title
    for(let i = 0 ; i< new_teeth.length ; i++){
        const temp_data = 
            `
                <tr>
                    <td>${new_teeth[i].numeroDent}</td>
                    <td>${new_teeth[i].emplacement}</td>
                    <td>${new_teeth[i].etat}</td>
                </tr>
            ` 
        table.innerHTML += temp_data
    }
    reste.innerHTML = 
    `
        Reste : ${Data[1]} ar
    `
}
function sendRequest(Forms , count){
    var xhr = new XMLHttpRequest();
    xhr.open('post', 'getdonnee',true)
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            const donnee =  JSON.parse(xhr.responseText)
            AfficheDonne(donnee,count)
        }
    }
    console.log(Forms.get("idpersonne"))
    xhr.send(Forms);
}

const div_abput = document.querySelectorAll('.about');
div_abput.forEach(function(teeth , index){
    const form =  teeth.querySelector('form') ;
    const select = form.querySelector('select')
    select.addEventListener('change', function(e){
        e.preventDefault();
        const forms = new FormData(form);
        sendRequest(forms , index)
    })
})