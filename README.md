# 💰 Projeto: Sistema Bancário com BDD (Java + Cucumber)

Este projeto simula um **Sistema Bancário** básico utilizando **Desenvolvimento Orientado por Comportamento (BDD)** com **Java**, **JUnit**, **Cucumber** e outras boas práticas de testes automatizados.

---

## 🧪 Tecnologias e Ferramentas

- **Java 17+**
- **JUnit 5**
- **Cucumber (Gherkin)** – para escrita de cenários em linguagem natural
- **AssertJ** – para asserções fluent
- **Maven** – gerenciamento de dependências e build
- **JaCoCo** – geração de relatório de cobertura de testes (opcional)
- **IDE recomendada**: IntelliJ IDEA ou Eclipse

---

---

## 📖 Funcionalidades Implementadas

- **Depósito**  
  Cenários com depósitos válidos e inválidos.

- **Saque**  
  Cenários com saque dentro do limite e tentativa com saldo insuficiente.

- **Transferência**  
  Transferência entre contas, com controle de saldo e tipo da transação.

---

## 📌 Como Executar os Testes

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. Execute os testes com Maven:

  ```bash
  mvn clean test
  ```

---

## 🔄 Próximos Passos
 
 - Implementar extrato bancário com histórico de transações
 - Adicionar autenticação/sessão no domínio
 - Expandir testes com equivalência e partições
 - Integração com um banco de dados em memória (H2)

---

## 👤 Autor
Desenvolvido por Danilo Takeo Kanizawa — com foco em aprendizado de BDD e testes automatizados com Java.
