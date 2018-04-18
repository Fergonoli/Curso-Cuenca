
function lanzarMensaje()
{
	alert('Hola mundo');
}


function muestra_texto()
{
	//Variable para mostrar el elemento
	var elem = document.getElementById("parrafo1");

	elem.innerHTML = "Texto Cambiado"

}


function nombrecompleto() 
{
	
	//Variable para el nombre
	var nombre = document.getElementById("nombre").innerHTML;

	//Variable para los apellidos
	var apellidos = document.getElementById("apellidos").innerHTML;


	//Variable para el nombre completo
	var completo = document.getElementById("nombrecompleto");	

	completo.innerHTML = nombre+apellidos;

}


//  Funciones para calculadora, hay que tener en cuanta que estas funciones afectan a inputs, no al hipertexto de 
//  HTML de las etiquetas, por ello las variables se localizan con .value
function sumar()
{
	//Mantener oculto el resto
	document.getElementById("resto").style.visibility = "hidden";

	//Variable para un sumando
	var sumando1 = document.getElementById("sumando1").value;

	//Variable para un sumando
	var sumando2 = document.getElementById("sumando2").value;	
 
	//Variable para el resultado
	var resultado = document.getElementById("resultado").value;	

	document.getElementById("resultado").value = parseFloat(sumando1) + parseFloat(sumando2);
}


function restar()
{
	//Mantener oculto el resto
	document.getElementById("resto").style.visibility = "hidden";

	//Variable para un sumando
	var sumando1 = document.getElementById("sumando1").value;

	//Variable para un sumando
	var sumando2 = document.getElementById("sumando2").value;	
 
	//Variable para el resultado
	var resultado = document.getElementById("resultado").value;	

	document.getElementById("resultado").value = parseFloat(sumando1) - parseFloat(sumando2);
}


function multiplicar()
{

	//Mantener oculto el resto
	document.getElementById("resto").style.visibility = "hidden";

	//Variable para un sumando
	var sumando1 = document.getElementById("sumando1").value;

	//Variable para un sumando
	var sumando2 = document.getElementById("sumando2").value;	
 
	//Variable para el resultado
	var resultado = document.getElementById("resultado").value;	

	document.getElementById("resultado").value = parseFloat(sumando1) * parseFloat(sumando2);
}

function dividir()
{
	//Mantener oculto el resto
	document.getElementById("resto").style.visibility = "hidden";

	//Variable para un sumando
	var sumando1 = document.getElementById("sumando1").value;

	//Variable para un sumando
	var sumando2 = document.getElementById("sumando2").value;	
 
	//Variable para el resultado
	var resultado = document.getElementById("resultado").value;	

	//Si tiene resto hay que mostrarlo
	if(parseInt(sumando1) % parseInt(sumando2) != 0)
	{

		//Dividimos en entero
		document.getElementById("resultado").value = Math.trunc (parseInt(sumando1) / parseInt(sumando2) );

		//Y devolvemos el resto y lo mostramos
		document.getElementById("resto").value = parseInt(sumando1) % parseInt(sumando2);


		//Mostrar el resto
		document.getElementById("resto").style.visibility = "visible";
	}
	else
	{
		document.getElementById("resultado").value = parseFloat(sumando1) / parseFloat(sumando2);
	}

}


function exp()
{

	//Mantener oculto el resto
	document.getElementById("resto").style.visibility = "hidden";

	//Variable para un sumando
	var sumando1 = document.getElementById("sumando1").value;

	//Variable para un sumando
	var sumando2 = document.getElementById("sumando2").value;	
 
	//Variable para el resultado
	var resultado = document.getElementById("resultado").value;	

	document.getElementById("resultado").value = parseFloat(sumando1) ** parseFloat(sumando2);
}

function par()
{

	//Mantener oculto el resto
	document.getElementById("resto").style.visibility = "hidden";

	//Variable para un sumando
	var sumando1 = document.getElementById("sumando1").value;

	//Variable para un sumando
	var sumando2 = document.getElementById("sumando2").value;	
 
	//Variable para el resultado
	var resultado = document.getElementById("resultado").value;	

	//Variable donde introduciremos el texto de resultado
	var resul;

	//Comprobar que el primero es par o no
	if(parseInt(sumando1) % 2 == 0)
	{
		resul = "Numero: "+ sumando1 + " es par";
	}
	else
	{
		resul = "Numero: "+ sumando1 + " es impar";
	}

	//Comprobar que el segundo es par o no
	if(parseInt(sumando2) % 2 == 0)
	{
		resul = resul + " -- Numero: "+ sumando2 + " es par";
	}
	else
	{
		resul = resul + " -- Numero: "+ sumando2 + " es impar";
	}


	alert(resul);
}


//Primer bucle del dia
function mostrarcoches()
{
	var coches = ["renault","ford","nisan","citroen"];
    var texto = "<ul>";


	for(i=0; i<coches.length; i++)
	{

		texto = texto + "<li>" + coches[i] + "</li>";

	}


	texto = texto + "</ul>";

	//Variable para el nombre completo
	var completo = document.getElementById("nombrecompleto");	

	completo.innerHTML = texto;

}


//Funcion para mostrar personas
function mostrarPersonas()
{

	//Creamos una lista de objetos de personas con su nombre y peso
	var personas =  [ {Nombre:"Juan", Peso:80 },
					  {Nombre:"Pepe", Peso:100 },
					  {Nombre:"Ana", Peso:73 },
					  {Nombre:"Luis", Peso:67 },
					  {Nombre:"Jose", Peso:93 },
					  {Nombre:"Javier", Peso:89 },
					  {Nombre:"Manolo", Peso:81 },
					  {Nombre:"Gabriel", Peso:79 }					  
					]; 
    var texto = "<ul>";


    //Recorremos la lista de personas
	for(i=0; i<personas.length; i++)
	{
		//Si el peso de la persona es mayor que 80, se muestra
		if(personas[i].Peso > 80)
		{
			texto = texto + "<li>" + personas[i].Nombre+ " - "+ personas[i].Peso + "</li>";
		}

	}


	texto = texto + "</ul>";

	//Variable para el nombre completo
	var completo = document.getElementById("nombrecompleto");	

	completo.innerHTML = texto;
}

//Funcion para contar aprobados, sobre una lista random
function contarAprobados()
{

	//Creamos una lista de objetos de personas con su nombre y peso
	var notas =  generarnotas(12);


    var texto = "";

    var suspenso = 0;
    var aprobados = 0;
    var bien = 0;
    var notable = 0;
    var sobresaliente = 0;
    var matricula = 0;


    //Recorremos la lista de notas para mostrarlas
	for(i=0; i<notas.length; i++)
	{

		//Para que el ultimo de la lista no incluya el separador
		if(i+1 == notas.length )
		{
			texto = texto  + notas[i]
		}
		else
		{
			texto = texto  + notas[i] + "  ||  ";			
		}


		//Comprobar la nota que a sacado
		var comprobacion = comprobarNota(notas[i]);

		//Comprobar la nota
		switch(comprobacion)
		{
			//Suspenso
			case 1:

				suspenso++;
				break;

			//aprobados
			case 2:

				aprobados++;
				break;

			//bien
			case 3:

				bien++;
				break;

			//notable
			case 4:

				notable++;
				break;

			//sobresaliente
			case 5:

				sobresaliente++;
				break;

			//matricula
			case 6:

				matricula++
				break;
		}
	}


	//Una vez mostradas las notas se muestran los resultados goblales
	texto = texto + "<br>"  + "<br>" +" suspensos: "+ suspenso + "<br>" +
						             " aprobados: "+ aprobados +  "<br>" +
						             " bien: "+ bien + "<br>" +
						             " notables: "+ notable +  "<br>" +
						             " sobresalientes: "+ sobresaliente +  "<br>" +
						             " matriculas: "+ matricula ;

	//Variable para el nombre completo
	var completo = document.getElementById("nombrecompleto");	

	completo.innerHTML = texto;
}

//Esta subfuncion generara notas aleatorias
function generarnotas(alumnos)
{
	//La variable que devolvera las notas aleatorias
	var notas = [];

	//Rellenamos el array con las notas
	for(i=0; i<alumnos; i++)
	{
		notas[i] = Math.floor(Math.random() * (1000 - 100) + 100) / 100;
	}

	//Devolvemos la lista de notas
	return notas;
}



//Esta subfuncion se utilizara para comprobar que etiqueta tiene la nota
function comprobarNota(nota)
{
	//Suspenso
	if(nota<5)
	{
		return 1;
	}

	//Aprobado
	if(nota<6)
	{
		return 2;
	}

	//bien
	if(nota<7)
	{
		return 3;
	}

	//Notable
	if(nota<8.5)
	{
		return 4;
	}

	//Sobresaliente
	if(nota<10)
	{
		return 5;
	}

	//Matricula
	if(nota==10)
	{
		return 6;
	}	

	return 0;			

}




//Funcion para mostrar personas
function trabajoPersonas()
{

	//Creamos una lista de objetos de personas con su nombre y peso
	var personas =  [ {Nombre:"Marta", Salario:1000, Horas:50 },
					  {Nombre:"Javier", Salario:3500, Horas:100 },
					  {Nombre:"Pepe", Salario:800, Horas:100 },
					  {Nombre:"Sandra", Salario:950, Horas:95 },
				      {Nombre:"Teresa", Salario:2700, Horas:90 }				  
					]; 

	//Variables de comparacion para trabajar
	var menosCobra = Infinity;
	var masTrabaja = 0;
	var SaldoMedio = 0;

	//Listas de candidatos de trabajo y horas
	var personasMenosCobra = [];
	var personasMasTrabaja = [];


	//Recorremos el array
	for(i=0; i<personas.length; i++)
	{

		//Comprobar el que mas cobra
		if(menosCobra > personas[i].Salario)
		{
			//Si encuentras alguien que cobra menos tienes que vaciar la lista
			personasMenosCobra = [];

			menosCobra =  personas[i].Salario;

			personasMenosCobra.push(i);
		}
		else
		{

			//Aunque no sea menor, hay que asegurarse que no cobre lo mismo
			if(menosCobra == personas[i].Salario)
			{
				personasMenosCobra.push(i);
			}
		}

		//Comprobar el que mas trabaj
		if(masTrabaja < personas[i].Horas)
		{
			//Si encuentras alguien que trabaja mas tienes que vaciar la lista
			personasMasTrabaja = [];

			masTrabaja =  personas[i].Horas;

			personasMasTrabaja.push(i);
		}
		else
		{
			//Aunque no sea menor, hay que asegurarse que no cobre lo mismo
			if(masTrabaja == personas[i].Horas)
			{
				personasMasTrabaja.push(i);
			}
		}

		//Sumatorio para la media
		SaldoMedio = SaldoMedio + personas[i].Salario;
	}

	//Realizar la media
	SaldoMedio = SaldoMedio/personas.length;

	var texto = "";


	texto = texto + "<table id='example'><thead> <tr> <th>NOMBRE</th><th>SUELDO</th><th>HORAS</th> </tr></thead>"

    //Recorremos la lista de personas
	for(i=0; i<personas.length; i++)
	{

		texto = texto + "<tr><td>" + personas[i].Nombre+ " </td> <td> "+ 
		                         personas[i].Salario + " </td> <td>  " +
		                         personas[i].Horas + "</td></tr>";
	}
	texto = texto + "</tr> </table> <br>";




	//Incluimos la informacion
	texto= texto + " Persona que mas trabaja: "+printPersona(personasMasTrabaja, personas)+ "<br>"+
				   " Persona que menos cobra: "+printPersona(personasMenosCobra, personas)+ "<br>"+
				   " Sueldo medio: "+SaldoMedio;

	//Variable para el nombre completo
	var completo = document.getElementById("nombrecompleto");	


	completo.innerHTML = texto;

	formatJquery.onload();

}


//Funcion para imprimir los datos de personas elegidas
function printPersona(ids, lista)
{

	texto = "";

	for (i=0; i<lista.length; i++)
	{
		//Comprueba si ese identificador esta en la lista de validos
		if(ids.includes(i))
		{
			texto = texto + lista[i].Nombre + "; "
		}
	}

	return texto;
}



var dataSet 

= [
    [ "Tiger Nixon", "System Architect", "Edinburgh", "5421", "2011/04/25", "$320,800" ],
    [ "Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750" ],
    [ "Ashton Cox", "Junior Technical Author", "San Francisco", "1562", "2009/01/12", "$86,000" ],
    [ "Cedric Kelly", "Senior Javascript Developer", "Edinburgh", "6224", "2012/03/29", "$433,060" ],
    [ "Airi Satou", "Accountant", "Tokyo", "5407", "2008/11/28", "$162,700" ],
    [ "Brielle Williamson", "Integration Specialist", "New York", "4804", "2012/12/02", "$372,000" ],
    [ "Herrod Chandler", "Sales Assistant", "San Francisco", "9608", "2012/08/06", "$137,500" ],
    [ "Rhona Davidson", "Integration Specialist", "Tokyo", "6200", "2010/10/14", "$327,900" ],
    [ "Colleen Hurst", "Javascript Developer", "San Francisco", "2360", "2009/09/15", "$205,500" ],
    [ "Sonya Frost", "Software Engineer", "Edinburgh", "1667", "2008/12/13", "$103,600" ],
    [ "Jena Gaines", "Office Manager", "London", "3814", "2008/12/19", "$90,560" ],
    [ "Quinn Flynn", "Support Lead", "Edinburgh", "9497", "2013/03/03", "$342,000" ],
    [ "Charde Marshall", "Regional Director", "San Francisco", "6741", "2008/10/16", "$470,600" ],
    [ "Haley Kennedy", "Senior Marketing Designer", "London", "3597", "2012/12/18", "$313,500" ],
    [ "Tatyana Fitzpatrick", "Regional Director", "London", "1965", "2010/03/17", "$385,750" ],
    [ "Michael Silva", "Marketing Designer", "London", "1581", "2012/11/27", "$198,500" ],
    [ "Paul Byrd", "Chief Financial Officer (CFO)", "New York", "3059", "2010/06/09", "$725,000" ],
    [ "Gloria Little", "Systems Administrator", "New York", "1721", "2009/04/10", "$237,500" ],
    [ "Bradley Greer", "Software Engineer", "London", "2558", "2012/10/13", "$132,000" ],
    [ "Dai Rios", "Personnel Lead", "Edinburgh", "2290", "2012/09/26", "$217,500" ],
    [ "Jenette Caldwell", "Development Lead", "New York", "1937", "2011/09/03", "$345,000" ],
    [ "Yuri Berry", "Chief Marketing Officer (CMO)", "New York", "6154", "2009/06/25", "$675,000" ],
    [ "Caesar Vance", "Pre-Sales Support", "New York", "8330", "2011/12/12", "$106,450" ],
    [ "Doris Wilder", "Sales Assistant", "Sidney", "3023", "2010/09/20", "$85,600" ],
    [ "Angelica Ramos", "Chief Executive Officer (CEO)", "London", "5797", "2009/10/09", "$1,200,000" ],
    [ "Gavin Joyce", "Developer", "Edinburgh", "8822", "2010/12/22", "$92,575" ],
    [ "Jennifer Chang", "Regional Director", "Singapore", "9239", "2010/11/14", "$357,650" ],
    [ "Brenden Wagner", "Software Engineer", "San Francisco", "1314", "2011/06/07", "$206,850" ],
    [ "Fiona Green", "Chief Operating Officer (COO)", "San Francisco", "2947", "2010/03/11", "$850,000" ],
    [ "Shou Itou", "Regional Marketing", "Tokyo", "8899", "2011/08/14", "$163,000" ],
    [ "Michelle House", "Integration Specialist", "Sidney", "2769", "2011/06/02", "$95,400" ],
    [ "Suki Burks", "Developer", "London", "6832", "2009/10/22", "$114,500" ],
    [ "Prescott Bartlett", "Technical Author", "London", "3606", "2011/05/07", "$145,000" ],
    [ "Gavin Cortez", "Team Leader", "San Francisco", "2860", "2008/10/26", "$235,500" ],
    [ "Martena Mccray", "Post-Sales support", "Edinburgh", "8240", "2011/03/09", "$324,050" ],
    [ "Unity Butler", "Marketing Designer", "San Francisco", "5384", "2009/12/09", "$85,675" ]
];
 
$(document).ready(function() {
    $('#ejemplo').DataTable( {
        data: dataSet,
        columns: [
            { title: "Name" },
            { title: "Position" },
            { title: "Office" },
            { title: "Extn." },
            { title: "Start date" },
            { title: "Salary" }
        ]
    } );
} );