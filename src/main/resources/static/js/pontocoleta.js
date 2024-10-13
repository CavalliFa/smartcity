document.addEventListener("DOMContentLoaded", () => {
    loadItems();

    const form = document.getElementById("crud-form");
    form.addEventListener("submit", event => {
        event.preventDefault();
        saveItem();
    });
});

async function loadItems() {
    try {
        const response = await fetch("/pontocoleta");
        const items = await response.json();
        const tbody = document.querySelector("#itemsTable tbody");
        tbody.innerHTML = "";

        items.forEach(item => {
            const tr = document.createElement("tr");
            tr.innerHTML = `
                <td>${item.id}</td>
                <td>${item.endereco}</td>
                <td>${item.bairro}</td>
                <td>${item.cep}</td>
                <td>${item.cidade}</td>
                <td>${item.estado}</td>
                <td>${item.nome}</td>
                <td>${item.telefone}</td>
                <td>${item.email}</td>
                <td>${item.cpf}</td>
                <td>${item.numero}</td>
                <td>${item.complemento}</td>
                <td class="actions">
                    <button onclick="editItem(${item.id})">Editar</button>
                    <button onclick="deleteItem(${item.id})">Excluir</button>
                </td>
            `;
            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error("Erro ao carregar itens:", error);
    }
}

async function saveItem() {
    const id = document.getElementById("itemId").value;
    const endereco = document.getElementById("itemEndereco").value;
    const bairro = document.getElementById("itemBairro").value;
    const cep = document.getElementById("itemCep").value;
    const cidade = document.getElementById("itemCidade").value;
    const estado = document.getElementById("itemEstado").value;
    const nome = document.getElementById("itemNome").value;
    const telefone = document.getElementById("itemTelefone").value;
    const email = document.getElementById("itemEmail").value;
    const cpf = document.getElementById("itemCpf").value;
    const numero = document.getElementById("itemNumero").value;
    const complemento = document.getElementById("itemComplemento").value;


    const method = id ? "PUT" : "POST";
    const url = "/pontocoleta";
    const item = { id, endereco, bairro, cep, cidade, estado, nome, telefone, email, cep, numero, complemento };

    try {
        await fetch(url, {
            method: method,
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(item)
        });

        document.getElementById("crud-form").reset();
        loadItems();
    } catch (error) {
        console.error("Erro ao salvar item:", error);
    }
}

function editItem(id) {
    fetch(`/pontocoleta/${id}`)
        .then(response => response.json())
        .then(item => {
            document.getElementById("itemId").value = item.id;
            document.getElementById("itemEndereco").value = item.endereco;
            document.getElementById("itemBairro").value = item.bairro;
            document.getElementById("itemCep").value = item.cep;
            document.getElementById("itemCidade").value = item.cidade;
            document.getElementById("itemEstado").value = item.estado;
            document.getElementById("itemNome").value = item.nome;
            document.getElementById("itemTelefone").value = item.telefone;
            document.getElementById("itemCpf").value = item.cpf;
            document.getElementById("itemNumero").value = item.numero;
            document.getElementById("itemComplemento").value = item.complemento;
        })
        .catch(error => console.error("Erro ao buscar item:", error));
}

async function deleteItem(id) {
    if (!confirm("Tem certeza que deseja excluir este item?")) return;

    try {
        await fetch(`/pontocoleta/${id}`, { method: "DELETE" });
        loadItems();
    } catch (error) {
        console.error("Erro ao excluir item:", error);
    }
}