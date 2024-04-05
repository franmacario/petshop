// Função para cadastrar um novo animal
function cadastrarAnimal(event) {
    event.preventDefault();

    const tipo = document.getElementById('tipo').value;
    const nome = document.getElementById('nome').value;
    const raca = document.getElementById('raca').value;
    const idade = document.getElementById('idade').value;
    const cliente = document.getElementById('cliente').value;

    // Simulação de requisição Ajax para cadastrar o animal
    fetch('/animais', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ tipo, nome, raca, idade, cliente })
    })
    .then(response => response.json())
    .then(data => {
        // Limpa os campos após cadastrar o animal
        document.getElementById('tipo').value = '';
        document.getElementById('nome').value = '';
        document.getElementById('raca').value = '';
        document.getElementById('idade').value = '';
        document.getElementById('cliente').value = '';

        // Atualiza a lista de animais
        listarAnimais();
    })
    .catch(error => console.error('Erro ao cadastrar animal:', error));
}

// Função para buscar um animal por ID
function buscarAnimal() {
    const idAnimal = document.getElementById('idAnimal').value;

    // Simulação de requisição Ajax para buscar o animal por ID
    fetch(`/animais/${idAnimal}`)
    .then(response => response.json())
    .then(animal => {
        // Exibe os dados do animal encontrado
        alert(`Tipo: ${animal.tipo}, Nome: ${animal.nome}, Raça: ${animal.raca}, Idade: ${animal.idade}, Cliente: ${animal.cliente}`);
    })
    .catch(error => console.error('Erro ao buscar animal:', error));
}

// Função para listar os animais cadastrados
function toggleLista() {
     const listaAnimais = document.getElementById('listaAnimais');

     // Verifica o estado atual da lista e altera para o estado oposto
     if (listaAnimais.style.display === 'none') {
         listaAnimais.style.display = 'block';
         document.getElementById('btnMostrarLista').textContent = 'Ocultar Lista de Animais';
     } else {
         listaAnimais.style.display = 'none';
         document.getElementById('btnMostrarLista').textContent = 'Mostrar Lista de Animais';
     }
 }