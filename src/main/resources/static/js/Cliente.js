const listaClientes = document.getElementById('listaClientes');
const formCliente = document.getElementById('formCliente');
const idCliente = document.getElementById('idCliente');

// Função para buscar todos os clientes
function listarClientes() {
    fetch('/clientes')
        .then(response => response.json())
        .then(data => {
            listaClientes.innerHTML = '';
            data.forEach(cliente => {
                const item = document.createElement('li');
                item.textContent = `${cliente.id} - ${cliente.nome} (${cliente.email})`;
                listaClientes.appendChild(item);
            });
        })
        .catch(error => console.error('Erro ao buscar clientes:', error));
}

// Função para cadastrar novo cliente
formCliente.addEventListener('submit', function (event) {
    event.preventDefault();

    const formData = new FormData(formCliente);
    const novoCliente = {
        nome: formData.get('nome'),
        email: formData.get('email')
    };

    fetch('/clientes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(novoCliente)
    })
    .then(response => response.json())
    .then(data => {
        alert('Cliente cadastrado com sucesso!');
        listarClientes();
        formCliente.reset();
    })
    .catch(error => console.error('Erro ao cadastrar cliente:', error));
});

// Função para buscar cliente por ID
function buscarCliente() {
    const id = idCliente.value.trim();
    if (!id) {
        alert('Por favor, informe o ID do cliente.');
        return;
    }

    fetch(`/clientes/${id}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Cliente não encontrado.');
            }
        })
        .then(cliente => {
            alert(`Cliente encontrado: ${cliente.nome} (${cliente.email})`);
        })
        .catch(error => {
            alert('Erro ao buscar cliente.');
            console.error('Erro:', error);
        });
}

// Iniciar listagem de clientes ao carregar a página
listarClientes();