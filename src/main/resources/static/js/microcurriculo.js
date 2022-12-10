var evento_formulario = function(event) {
	event.preventDefault();
	alert("Rinde 2 kilómetros por litro");
	const obj = {
		descripcion: "Microcurrículo 1",
		competencias: ["Competencia 1", "Competencia 2", "Competencia 3"],
		unidades: ["Unidad 1", "Unidad 2", "Unidad 3"]
	};

	var cuerpo_tabla = document.getElementById("table-body");
	cuerpo_tabla.innerHTML = ''

	for (const key in obj) {
		if (!obj.hasOwnProperty(key)) continue;
		const value = Array.isArray(obj[key]) ? obj[key] : [obj[key]];
		const row = document.createElement('tr');
		const key_cell = Object.assign(document.createElement('td'), {
			innerText: key
		});
		const value_column = Object.assign(document.createElement('td'), {
			innerText: value.splice(0, 1)[0]
		});

		row.append(...[key_cell, value_column]);
		cuerpo_tabla.append(row);

		value.forEach(val => {
			const inner_row = document.createElement('tr');
			const empty_key_cell = document.createElement('td');
			const value_cell = Object.assign(document.createElement('td'), {
				innerText: val
			});
			inner_row.append(...[empty_key_cell, value_cell]);
			cuerpo_tabla.append(inner_row);
		});
	}

}

var form = document.getElementById("formulario");
form.addEventListener("submit", evento_formulario, true);
