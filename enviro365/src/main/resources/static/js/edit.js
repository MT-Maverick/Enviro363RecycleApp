const formInfo = document.getElementById('dataList');
const wasteType = document.getElementById('wasteType');
const wasteName = document.getElementById('wasteName');
const wasteDescription = document.getElementById('wasteDescription');
const disposalGuidelines = document.getElementById('disposalGuidelines');
const recycleTips = document.getElementById('recycleTips');
const numberSelect = document.getElementById('numberSelect');
const  updateForm = document.getElementById('updateForm');

function loadList(){
    
    let i=1;
    //nmberSelect is -1 because when its initialized there already exists a option tag: "select id for row"
    if (numberSelect.getElementsByTagName('option').length-1<formInfo.getElementsByTagName('tr').length) {
   
        while(i<=formInfo.getElementsByTagName('tr').length){
            const value =document.createElement('option');
            numberSelect.appendChild(value).textContent = i;
            i++;
        }
        
    }
}


function deleteFormAction(form, id) {
    if(confirm('are you sure you wish to delete this document ?')?true:false){
        form.action = '/delete/'+ id;
    }
    
}

function updateFormAction(form,id){
    
    if(confirm('are you sure you wish to update this document ?')?'yes':'no'){

        form.action = '/update/'+id+"/"+wasteType.value+"/"+wasteName.value+"/"+wasteDescription.value+"/"+disposalGuidelines.value+"/"+recycleTips.value;
    }
}

function fillForm() {
    // Split by tab characters then convert to sting which is split by the new line character to get the initial array of values
    let tableInfo = formInfo.innerText.split("\t").toString().split('\n');
    let numberSelectValue = numberSelect.value-1;
    let container = tableInfo[numberSelectValue].split(',');
    
    // Assign values to the form fields if they exist in the numberSelectValue array:
    wasteName.value = container[1] || '';
    wasteType.value = container[2] || '';
    wasteDescription.value = container[3]|| '';
    disposalGuidelines.value = container[4] || '';
    recycleTips.value = container[5] || '';
}