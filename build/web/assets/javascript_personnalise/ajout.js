document.getElementById("ajouterElementP").addEventListener("click", function () {
    const elementsContainer = document.getElementById("dynamicElementsProduit");
    const rowDiv = document.createElement("div");
    rowDiv.className = "row mb-1";

    const selectDiv = document.createElement("div");
    selectDiv.className = "col-sm-5";
    const select = document.createElement("select");
    select.name = "id_produit[]";
    select.className = "form-control form-control-sm";

    // Replace this array with your actual PHP array
    // const produits = <?php echo json_encode($produits); ?>;

    produits.forEach(row => {
        const option = document.createElement("option");
        option.value = row.id;
        option.textContent = row.nom;
        select.appendChild(option);
    });

    selectDiv.appendChild(select);
    rowDiv.appendChild(selectDiv);

    const inputDiv = document.createElement("div");
    inputDiv.className = "col-sm-4";
    const input = document.createElement("input");
    input.type = "text";
    input.name = "qtt[]";
    input.className = "form-control form-control-sm";
    input.placeholder = "Quantité";

    inputDiv.appendChild(input);
    rowDiv.appendChild(inputDiv);

    elementsContainer.appendChild(rowDiv);
});
