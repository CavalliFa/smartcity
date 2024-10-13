document.addEventListener("DOMContentLoaded", () => {
    loadItems();
    loadItemscaminhao();
    loadItemslocal();

    const form = document.getElementById("crud-form");
    form.addEventListener("submit", event => {
        event.preventDefault();
        saveItem();
    });
});

async function loadItems() {
    try {
        const response = await fetch("/coleta");
        const items = await response.json();
        const tbody = document.querySelector("#itemsTable tbody");
        tbody.innerHTML = "";

        items.forEach(item => {
            const tr = document.createElement("tr");
            tr.innerHTML = `
                <td>${item.id}</td>
                <td>${item.coleta}</td>
                <td>${item.caminhao.id}</td>
                <td>${item.caminhao.descricao}</td>
                <td>${item.caminhao.motorista}</td>
                <td>${item.pontocoleta.id}</td>
                <td>${item.pontocoleta.bairro}</td>
                <td>${item.pontocoleta.cidade}</td>
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

async function loadItemscaminhao() {
    try {
        const response = await fetch("/caminhao");
        const items = await response.json();
        const tbody = document.querySelector("#itemic tbody");
        tbody.innerHTML = "";

        items.forEach(item => {
            const tr = document.createElement("tr");
            tr.innerHTML = `
                <td>${item.id}</td>
                <td>${item.descricao}</td>
                <td>${item.motorista}</td>
                <td>${item.placa}</td>
                <td>${item.capacidade}</td>
            `;
            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error("Erro ao carregar itens:", error);
    }
}

async function loadItemslocal() {
    try {
        const response = await fetch("/pontocoleta");
        const items = await response.json();
        const tbody = document.querySelector("#itemil tbody");
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
            `;
            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error("Erro ao carregar itens:", error);
    }
}

async function saveItem() {
    const id = document.getElementById("itemId").value;
    const coleta = document.getElementById("itemColeta").value;

    const method = id ? "PUT" : "POST";
    const url = "/coleta";
    const item = { id, coleta };

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
        loadItemscaminhao();

    } catch (error) {
        console.error("Erro ao salvar item:", error);
    }
}

function editItem(id) {
    fetch(`/coleta/${id}`)
        .then(response => response.json())
        .then(item => {
            document.getElementById("itemId").value = item.id;
            document.getElementById("itemColeta").value = item.coleta;
            document.getElementById("itemColeta").value = item.coleta;
            document.getElementById("itemColeta").value = item.coleta;
        })
        .catch(error => console.error("Erro ao buscar item:", error));
}

async function deleteItem(id) {
    if (!confirm("Tem certeza que deseja excluir este item?")) return;

    try {
        await fetch(`/coleta/${id}`, { method: "DELETE" });
        loadItems();
    } catch (error) {
        console.error("Erro ao excluir item:", error);
    }
}