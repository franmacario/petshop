// Função para adicionar um serviço
    function adicionarServico(id, nome, preco) {
        // Aqui você pode implementar a lógica para adicionar o serviço conforme necessário
        alert(`Serviço "${nome}" adicionado com preço R$ ${preco.toFixed(2)}!`);
    }

    // Função para adicionar os serviços disponíveis
    function adicionarServicosDisponiveis() {
        fetch('/servicos/adicionar', { // Faz a requisição POST para o endpoint /servicos/adicionar
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify([
                { nome: 'Banho', preco: 30.0 },
                { nome: 'Hidratação', preco: 40.0 },
                { nome: 'Tosa Higiênica', preco: 25.0 },
                { nome: 'Escovação de Dentes', preco: 15.0 },
                { nome: 'Limpeza de Ouvido', preco: 20.0 },
                { nome: 'Corte de Unhas', preco: 15.0 },
                { nome: 'Vacina', preco: 50.0 }
            ])
        })
            .then(response => response.json())
            .then(data => {
                alert('Serviços adicionados com sucesso!');
                listarServicos();
            })
            .catch(error => console.error('Erro ao adicionar serviços:', error));
    }

    // Função para listar os serviços disponíveis
    function listarServicos() {
        fetch('/servicos') // Faz a requisição GET para o endpoint /servicos
            .then(response => response.json()) // Converte a resposta para JSON
            .then(data => {
                const servicoContainer = document.getElementById('servicoContainer');
                servicoContainer.innerHTML = ''; // Limpa o conteúdo antes de adicionar os serviços

                data.forEach(servico => {
                    const servicoItem = document.createElement('div');
                    servicoItem.classList.add('servico-item');
                    servicoItem.innerHTML = `
                        <p><strong>Serviço:</strong> ${servico.nome}</p>
                        <p><strong>Preço:</strong> R$ ${servico.preco.toFixed(2)}</p>
                        <button onclick="adicionarServico(${servico.id}, '${servico.nome}', ${servico.preco})">Adicionar</button>
                    `;
                    servicoContainer.appendChild(servicoItem);
                });
            })
            .catch(error => console.error('Erro ao obter a lista de serviços:', error));
    }

    // Chama a função adicionarServicosDisponiveis ao carregar a página
    document.addEventListener('DOMContentLoaded', adicionarServicosDisponiveis);