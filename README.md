# ⚙️ Sistema de Gestão de Oficina (Mecânica do Zé)

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge" alt="Status" />
</div>

---

> **Aplicação de consola desenvolvida em Java com o objetivo de aplicar e demonstrar os fundamentos da Programação Orientada a Objetos (POO) num cenário real de gestão industrial/mecânica.**

---

## 🎯 Sobre o Projeto

Este sistema foi construído para gerir o fluxo de Ordens de Serviço (OS) de uma oficina mecânica. Toda a interação é feita via Linha de Comandos (CLI), priorizando a lógica de negócio, o encapsulamento e a separação de responsabilidades na arquitetura do código.

### 🛠️ Funcionalidades Implementadas
- **Cadastro de OS:** Geração de novas ordens de serviço com registo de data usando a API `java.time`.
- **Listagem Dinâmica:** Filtros para visualizar apenas Ordens em Aberto ou Ordens Concluídas.
- **Busca Específica:** Consulta detalhada de uma Ordem de Serviço através do seu ID único.
- **Atualização de Estado:** Fechamento/Conclusão de Ordens de Serviço ativas.
- **Controle de Capacidade:** Sistema preparado para alocar e gerir até 100 instâncias simultâneas na memória.

---

## 🧩 Arquitetura e Orientação a Objetos

O projeto foi estruturado utilizando boas práticas de separação de pacotes em Java:

* 📁 **Pacote `classe`:** Contém o modelo `OrdensDeServico.java`. Atua como o molde dos objetos, definindo os atributos (Estado, ID, Datas) e encapsulando as regras de negócio.
* 📁 **Pacote `main`:** Contém a classe principal `MecanicaDoZe.java`. Atua como o controlador (Controller/View) da aplicação, gerindo o menu interativo via `Scanner` e instanciando os objetos do modelo.

---

## 🚀 Como Executar

Por ser uma aplicação nativa Java (Console), a execução é simples:

1. Clone o repositório para a sua máquina.
2. Abra o projeto na sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code).
3. Execute o ficheiro `MecanicaDoZe.java` localizado em `src/MecanicaDoZe/main/`.
4. Interaja com o sistema através do terminal/consola.
