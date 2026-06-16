# Factory Method Pattern

> **Categoria:** Criacional
> **Dificuldade:** Fácil
> **Status:** ✅ Concluído

---

## 🧩 O problema

Uma aplicação precisa enviar notificações de tipos diferentes (Email, SMS, Push), mas o código cliente não deve conhecer os detalhes de criação de cada tipo. Criar os objetos diretamente no cliente acoplaria o sistema às classes concretas, dificultando a adição de novos tipos no futuro.

---

## 💡 A solução com o padrão

A `NotificacaoFactory` centraliza a criação dos objetos. O cliente pede uma notificação pelo tipo (`"EMAIL"`, `"SMS"`, `"PUSH"`) e recebe de volta uma `Notificacao` — sem saber qual classe concreta foi instanciada. Para adicionar um novo tipo, basta criar uma nova classe e adicionar um caso na factory, sem tocar no código cliente.

---

## 🗂️ Estrutura do código

    factory/
    ├── Notificacao.java          # contrato principal (interface)
    ├── NotificacaoEmail.java     # implementação Email
    ├── NotificacaoSMS.java       # implementação SMS
    ├── NotificacaoPush.java      # implementação Push
    └── NotificacaoFactory.java   # factory — centraliza a criação

---

## 📐 Diagrama UML (ASCII)

             <<interface>>
             +Notificacao+
           + enviar(String): void
                   |
          _________|________________________
         |                |                 |
    NotificacaoEmail  NotificacaoSMS  NotificacaoPush
    + enviar()        + enviar()      + enviar()

                             ^
                             | cria
                    +--------------------+
                    | NotificacaoFactory |
                    + criar(String)      |
                    +--------------------+

---

## ▶️ Como executar os testes

    mvn test -Dtest=NotificacaoFactoryTest

Resultado esperado:

    [INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

---

## 🔴🟢🔵 Ciclo TDD aplicado

| Etapa | Teste | Resultado antes | Resultado depois |
|-------|-------|-----------------|------------------|
| Red | `testEmail()` | ❌ falha — `criar()` retorna `null` | — |
| Green | `testEmail()` | — | ✅ passa com `if` mínimo |
| Refactor | todos | ✅ ainda passam | ✅ switch expression limpo |
| Red | `testSMS()` | ❌ falha — caso não existe | — |
| Green | `testSMS()` | — | ✅ passa |
| Red | `testPush()` | ❌ falha — caso não existe | — |
| Green | `testPush()` | — | ✅ passa |
| Red | `testTipoInvalido()` | ❌ falha — sem exception | — |
| Green | `testTipoInvalido()` | — | ✅ `IllegalArgumentException` lançada |

---

## ⚖️ Decisões de design

- Usado `switch` expression do Java 21 em vez de `if/else` — mais conciso e legível
- `IllegalArgumentException` escolhida para tipos inválidos por ser uma exceção unchecked adequada para erros de uso incorreto da API
- Interface `Notificacao` como contrato garante que o cliente nunca depende das classes concretas
- Método `criar()` é `static` — a factory não precisa de estado próprio

---

## ✅ Quando usar este padrão

- Quando o tipo exato do objeto a ser criado só é conhecido em tempo de execução
- Quando você quer centralizar e isolar a lógica de criação de objetos
- Quando adicionar novos tipos não deve exigir alteração no código cliente

## ❌ Quando NÃO usar

- Quando existe apenas um tipo concreto — a factory seria complexidade desnecessária
- Quando a criação do objeto é simples e improvável de variar
- Quando o acoplamento às classes concretas não é um problema no contexto do projeto

---

## 🔗 Referências

- [Refactoring.Guru — Factory Method](https://refactoring.guru/pt-br/design-patterns/factory-method)
- Livro GoF, p. 107