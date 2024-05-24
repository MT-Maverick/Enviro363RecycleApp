function fetchData() {
    
const pageName= document.title

fetch("/"+pageName)
.then(res=>res.json())
.then(data=>{
    const dataList = document.getElementById('dataList');
    
    data.forEach(element => {

        const open = document.createElement('tr');
        const ID = document.createElement('td');
        const name = document.createElement('td');
        const type = document.createElement('td');

        let id = element.wasteLogId;
        let wasteType = element.wasteType;
        let wasteName = element.wasteName;
        
        ID.innerText = id; 
        type.innerText = wasteType;
        name.innerText = wasteName;
    
        dataList.appendChild(open);
        open.appendChild(ID);
        open.appendChild(name);
        open.appendChild(type);

        if (pageName =="recycle") {
            console.log(element);
            const tips = document.createElement('td');
            let recyleTips = element.recyleTips;
            tips.innerText = recyleTips;
            open.appendChild(tips);
            
        } else if(pageName =="waste"){
            const description = document.createElement('td');
            let wasteDescription = element.wasteDescription;
            description.innerText = wasteDescription;
            open.appendChild(description);
            
        }else if(pageName =="disposal"){
            const disposal = document.createElement('td');
            let dispoaslGuidelines = element.dispoaslGuidelines;
            disposal.innerText = dispoaslGuidelines;
            open.appendChild(disposal);
        }else{

            const description = document.createElement('td');
            let wasteDescription = element.wasteDescription;
            description.innerText = wasteDescription;
            open.appendChild(description);

            const disposal = document.createElement('td');
            let dispoaslGuidelines = element.dispoaslGuidelines;
            disposal.innerText = dispoaslGuidelines;
            open.appendChild(disposal);

            const tips = document.createElement('td');
            let recyleTips = element.recyleTips;
            tips.innerText = recyleTips;
            open.appendChild(tips);
        }
        

    });
})
.catch(err => console.error('Error fetching data',err));
}
