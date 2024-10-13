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
        const response = await fetch("/caminhao");
        const items = await response.json();
        const tbody = document.querySelector("#itemsTable tbody");
        tbody.innerHTML = "";

        items.forEach(item => {
            const tr = document.createElement("tr");
            tr.innerHTML = `
                <td>${item.id}</td>
                <td>${item.descricao}</td>
                <td>${item.motorista}</td>
                <td>${item.placa}</td>
                <td>${item.capacidade}</td>
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
    const descricao = document.getElementById("itemDescricao").value;
    const motorista = document.getElementById("itemMotorista").value;
    const placa = document.getElementById("itemPlaca").value;
    const capacidade = document.getElementById("itemCapacidade").value;

    const method = id ? "PUT" : "POST";
    const url = "/caminhao";
    const item = { id, descricao, motorista, placa, capacidade };

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
    fetch(`/caminhao/${id}`)
        .then(response => response.json())
        .then(item => {
            document.getElementById("itemId").value = item.id;
            document.getElementById("itemDescricao").value = item.descricao;
            document.getElementById("itemMotorista").value = item.motorista;
            document.getElementById("itemPlaca").value = item.placa;
            document.getElementById("itemCapacidade").value = item.capacidade;
        })
        .catch(error => console.error("Erro ao buscar item:", error));
}

async function deleteItem(id) {
    if (!confirm("Tem certeza que deseja excluir este item?")) return;

    try {
        await fetch(`/caminhao/${id}`, { method: "DELETE" });
        loadItems();
    } catch (error) {
        console.error("Erro ao excluir item:", error);
    }
}