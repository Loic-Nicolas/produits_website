/**
 * 
 */

function $ (selecteur) {
    return (selecteur[0] == '#') ? document.querySelector(selecteur) : document.querySelectorAll(selecteur);
}

function affiche(id, titre, quantite, prix, description) {
	var divPerso = document.createElement('td');
	//divPerso.style = 
	var inputTitre = document.createElement('input');
	inputTitre.type = 'text';
	inputTitre.value = titre;
	console.log("test");
	console.log(inputTitre);
	inputTitre.className = "form-control";
	divPerso.appendChild(inputTitre);
	$('#id_'+id).replaceChild(divPerso, $('#id_'+id).childNodes[1]);
	
	var divPerso = document.createElement('td');
	var inputQuantite = document.createElement('input');
	inputQuantite.type = 'text';
	inputQuantite.value = quantite;
	inputQuantite.className = "form-control";
	divPerso.appendChild(inputQuantite);
	$('#id_'+id).replaceChild(divPerso, $('#id_'+id).childNodes[3]);
	
	
	var divPerso = document.createElement('td');
	var inputPrix = document.createElement('input');
	inputPrix.type = 'text';
	inputPrix.value = prix;
	inputPrix.className = "form-control";
	divPerso.appendChild(inputPrix);
	$('#id_'+id).replaceChild(divPerso, $('#id_'+id).childNodes[5]);
	
	var divPerso = document.createElement('td');
	var inputDescription = document.createElement('input');
	inputDescription.type = 'text';
	inputDescription.value = description;
	inputDescription.className = "form-control";
	divPerso.appendChild(inputDescription);
	$('#id_'+id).replaceChild(divPerso, $('#id_'+id).childNodes[7]);
	
	$('#boutton_envoyer_mod').style = '';
	$('#list_ids').value = $('#list_ids').value + id + '- -';
}

function envoyer(){
	var list_id = $('#list_ids').value.split("- -");
	
	for (var i = 0; i < list_id.length-1; i++) {
		$('#list_titres').value = $('#list_titres').value + $('#id_'+list_id[i]).childNodes[1].childNodes[0].value + '- -';
		$('#list_quantites').value = $('#list_quantites').value + $('#id_'+list_id[i]).childNodes[3].childNodes[0].value + '- -';
		$('#list_prix').value = $('#list_prix').value + $('#id_'+list_id[i]).childNodes[5].childNodes[0].value + '- -';
		$('#list_descriptions').value = $('#list_descriptions').value + $('#id_'+list_id[i]).childNodes[7].childNodes[0].value + '- -';
	}
	
	$('#form_mod').submit();
}