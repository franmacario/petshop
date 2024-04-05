function listarFuncionarios() {
        fetch('/funcionarios')
            .then(response => response.json())
            .then(data => {
                const lista = document.getElementById('lista');
                lista.innerHTML = '';
                data.forEach(funcionario => {
                    const li = document.createElement('li');
                    li.textContent = `${funcionario.nome} - ${funcionario.cargo}`;
                    lista.appendChild(li);
                });
            });
    }

    document.getElementById('formFuncionario').addEventListener('submit', function (event) {
        event.preventDefault();
        const formData = new FormData(this);
        fetch('/funcionarios', {
            method: 'POST',
            body: formData
        })
            .then(response => response.json())
            .then(data => {
                alert('Funcionário cadastrado com sucesso!');
                this.reset();
            })
            .catch(error => console.error('Erro ao cadastrar funcionário:', error));
    });