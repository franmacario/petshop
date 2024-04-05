function listarAtendimentos() {
        fetch('/atendimentos')
            .then(response => response.json())
            .then(data => {
                const lista = document.getElementById('lista');
                lista.innerHTML = '';
                data.forEach(atendimento => {
                    const li = document.createElement('li');
                    li.textContent = `ID: ${atendimento.id} - Descrição: ${atendimento.descricao}`;
                    lista.appendChild(li);
                });
            });
    }

    document.getElementById('formAtendimento').addEventListener('submit', function (event) {
        event.preventDefault();
        const formData = new FormData(this);
        fetch('/atendimentos', {
            method: 'POST',
            body: formData
        })
            .then(response => response.json())
            .then(data => {
                alert('Atendimento cadastrado com sucesso!');
                this.reset();
            })
            .catch(error => console.error('Erro ao cadastrar atendimento:', error));
    });