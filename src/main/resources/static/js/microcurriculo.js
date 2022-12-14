var evento_formulario = function(event) {
	event.preventDefault();
	alert("El importe mediante Excel no está disponible de momento por problemas técnicos. Lamentamos las molestias.");
}

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