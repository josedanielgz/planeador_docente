function appendComponents(items, parent) {
	temp_item = document.createElement("td");
	temp_item.setAttribute( 'colspan', 1 );
	temp_table = document.createElement("table");
	temp_tbody = document.createElement("tbody");
	temp_table.classList.add("table","table-bordered","border-light","table-light");
	items.forEach(val => {
		var temp_td = document.createElement("tr");
		temp_td.innerText = val;
		temp_tbody.append(temp_td)
	});
	temp_table.append(temp_tbody)
	temp_item.append(temp_table);
	parent.append(temp_item);
}

var evento_formulario = function(event) {
	event.preventDefault();

	var tbody = document.getElementById("table-body");
	tbody.innerHTML = ''
	var fila = document.createElement("tr");
	var item = document.createElement("td");
	item.innerText = "Hacer"
	fila.append(item);
	var resultados = ["Resultado uno", "*", "*", "*"];
	appendComponents(resultados,fila);
	var competencias = ["2", "*", "*", "*"];
	appendComponents(competencias, fila);
	var unidades = ["10%", "*", "*", "*"];
	appendComponents(unidades, fila);
	tbody.append(fila);

}
//	const obj = {
//		descripcion: "Microcurrículo 1",
//		competencias: ["Competencia 1", "Competencia 2", "Competencia 3"],
//		unidades: ["Unidad 1", "Unidad 2", "Unidad 3"]
//	};

//	for (const key in obj) {
//		if (!obj.hasOwnProperty(key)) continue;
//		const value = Array.isArray(obj[key]) ? obj[key] : [obj[key]];
//		const row = document.createElement('tr');
//		const key_cell = Object.assign(document.createElement('td'), {
//			innerText: key
//		});
//		const value_column = Object.assign(document.createElement('td'), {
//			innerText: value.splice(0, 1)[0]
//		});
//
//		row.append(...[key_cell, value_column]);
//		tbody.append(row);
//
//		value.forEach(val => {
//			const inner_row = document.createElement('tr');
//			const empty_key_cell = document.createElement('td');
//			const value_cell = Object.assign(document.createElement('td'), {
//				innerText: val
//			});
//			inner_row.append(...[empty_key_cell, value_cell]);
//			tbody.append(inner_row);
//		});
//	}
//




var form = document.getElementById("formulario");
form.addEventListener("submit", evento_formulario, true);

document.getElementById("descargarPDF")
            .addEventListener("click", () => {
                const invoice = this.document.getElementById("main-table");
//                console.log(invoice);
//                console.log(window);
                let currentDate = new Date();
                let cDay = currentDate.getDate();
                let cMonth = currentDate.getMonth() + 1;
                let cYear = currentDate.getFullYear();
                let fulldate = cDay + "-" + cMonth + "-" + cYear;
                
                var opt = {
                    margin: 1,
                    filename: 'archivo'+fulldate+'.pdf',
                    image: {type: 'jpeg', quality: 0.98},
                    html2canvas: {scale: 2},
                    jsPDF: {unit: 'in', format: 'letter', orientation: 'portrait'}
                };
                html2pdf().from(invoice).set(opt).save();
            });

//https://javascript.tutorialink.com/how-to-dynamically-create-a-table-from-a-json-with-nested-lists-using-javascript/
//https://developer.mozilla.org/en-US/docs/Web/API/Element/classList
//https://stackoverflow.com/questions/13980982/add-class-to-html-with-javascript