function gerarLinha(item) {
    var linha = document.createElement("tr");
    linha.classList.add("cellItem");
    var cn = document.createElement("td");
    cn.textContent = lista.contrato.contratoId;
    var ci = document.createElement("td");
    ci.textContent = lista.contrato.dataAbertura;
    linha.appendChild(cn);
    linha.appendChild(ci);
    return linha;
}

function recriarTabela() {
    var itensTabela = document.getElementById("itensTabela");
    for (var i in lista) {
        itensTabela.appendChild(gerarLinha(lista[i]));
    }
}

function destruirTabela() {
    var itensTabela = document.getElementById("itensTabela");
    while (itensTabela.childNodes.length > 0) {
        itensTabela.removeChild(itensTabela.childNodes[0]);
    }
}

function ordenarPorIdade(a, b) {
    if (a.idade < b.idade)
        return -1;
    if (a.idade > b.idade)
        return 1;
    return 0;
}

function ordenarPorNome(a, b) {
    if (a.nome < b.nome)
        return -1;
    if (a.nome > b.nome)
        return 1;
    return 0;
}

function ordenar(e) {
    var campo = e.target.id;
    if (campo == "cellNome")
        items.sort(ordenarPorNome);
    if (campo == "cellIdade")
        items.sort(ordenarPorIdade);
    destruirTabela();
    recriarTabela();
}

recriarTabela();
document.getElementById("cellNome").addEventListener("click", ordenar);
document.getElementById("cellIdade").addEventListener("click", ordenar);


