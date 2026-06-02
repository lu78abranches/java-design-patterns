# ☕ Java Design Patterns

Repositório de estudos sobre padrões de projeto (Design Patterns) em Java, implementados com TDD usando JUnit 5 e Mockito. Os desafios foram organizados de forma progressiva — do mais simples ao mais complexo — seguindo o livro clássico *Design Patterns* (GoF).

---

## 🎯 Objetivo

Praticar os 12 principais padrões de projeto através de desafios contextualizados, aplicando:

- **TDD** (Test-Driven Development) com ciclo Red → Green → Refactor
- **Clean Code** e boas práticas de orientação a objetos
- **Git workflow** com branches por feature e Pull Requests documentadas

---

## 🛠️ Tecnologias

| Ferramenta | Versão | Uso |
|------------|--------|-----|
| Java | 21 | Linguagem principal |
| Maven | 3.9+ | Gerenciamento de dependências e build |
| JUnit 5 | 5.10.2 | Framework de testes |
| Mockito | 5.11.0 | Mocks e stubs nos testes |

---

## 📁 Estrutura do projeto

```
java-design-patterns/
├── src/
│   ├── main/java/
│   │   ├── criacionais/
│   │   │   ├── singleton/
│   │   │   ├── factory/
│   │   │   ├── builder/
│   │   │   └── prototype/
│   │   ├── estruturais/
│   │   │   ├── adapter/
│   │   │   ├── decorator/
│   │   │   ├── composite/
│   │   │   └── facade/
│   │   └── comportamentais/
│   │       ├── strategy/
│   │       ├── observer/
│   │       ├── command/
│   │       └── chain/
│   └── test/java/
│       └── (mesma estrutura acima)
├── pom.xml
└── README.md
```

---

## 🗺️ Roadmap de implementação

### Nível 1 — Padrões Criacionais

| # | Padrão | Contexto do desafio | Status | PR |
|---|--------|---------------------|--------|----|
| 01 | [Singleton](./src/main/java/criacionais/singleton/) | Configuração global da aplicação (thread-safe) | 🔄 | [#1]() |
| 02 | [Factory Method](./src/main/java/criacionais/factory/) | Sistema de notificações (Email, SMS, Push) |⏳| [#2]() |
| 03 | [Builder](./src/main/java/criacionais/builder/) | Construção fluente de pedidos com validação | ⏳ | [#3]() |
| 04 | [Prototype](./src/main/java/criacionais/prototype/) | Templates de documentos com deep copy | ⏳ | — |

### Nível 2 — Padrões Estruturais

| # | Padrão | Contexto do desafio | Status | PR |
|---|--------|---------------------|--------|----|
| 05 | [Adapter](./src/main/java/estruturais/adapter/) | Gateway de pagamento legado → novo | ⏳ | — |
| 06 | [Decorator](./src/main/java/estruturais/decorator/) | Bebidas personalizadas de cafeteria | ⏳ | — |
| 07 | [Composite](./src/main/java/estruturais/composite/) | Sistema de arquivos e pastas recursivo | ⏳ | — |
| 08 | [Facade](./src/main/java/estruturais/facade/) | Home theater com múltiplos subsistemas | ⏳ | — |

### Nível 3 — Padrões Comportamentais

| # | Padrão | Contexto do desafio | Status | PR |
|---|--------|---------------------|--------|----|
| 09 | [Strategy](./src/main/java/comportamentais/strategy/) | Ordenação de produtos em e-commerce | ⏳ | — |
| 10 | [Observer](./src/main/java/comportamentais/observer/) | Alertas de estoque com múltiplos listeners | ⏳ | — |
| 11 | [Command](./src/main/java/comportamentais/command/) | Editor de texto com undo/redo | ⏳ | — |
| 12 | [Chain of Responsibility](./src/main/java/comportamentais/chain/) | Pipeline de aprovação de despesas | ⏳ | — |

### Nível 4 — Desafio Integrador

| # | Desafio | Padrões utilizados | Status |
|---|---------|-------------------|--------|
| 13 | Mini e-commerce | Builder + Strategy + Observer + Factory + Decorator | ⏳ |

**Legenda:** ✅ Concluído · 🔄 Em andamento · ⏳ Pendente

---

## 🚀 Como executar

### Pré-requisitos

- Java 21+
- Maven 3.9+

### Rodando todos os testes

```bash
mvn test
```

### Rodando testes de um padrão específico

```bash
mvn test -Dtest=SingletonTest
mvn test -Dtest=ObserverTest
```

### Rodando testes de um pacote inteiro

```bash
mvn test -Dtest="criacionais.*"
```

---

## 📐 Workflow de desenvolvimento

Cada padrão segue o mesmo fluxo:

```
main
 └── feature/nome-do-padrao
      ├── commit: feat: scaffold [Padrão] classes
      ├── commit: feat: implement [Padrão] logic
      ├── commit: test: add JUnit tests for [Padrão]
      └── PR → merge → tag v0.N-padrao
```

### Convenção de commits

```
feat:     nova implementação ou funcionalidade
test:     adição ou ajuste de testes
refactor: melhoria sem mudança de comportamento
fix:      correção de bug
docs:     documentação, README, comentários
chore:    configuração, pom.xml, .gitignore
```

---

## 📖 Referências

- **Livro:** *Design Patterns: Elements of Reusable Object-Oriented Software* — GoF (Gang of Four)
- **Livro:** *Head First Design Patterns* — Freeman & Robson
- **Site:** [Refactoring.Guru](https://refactoring.guru/pt-br/design-patterns) — explicações visuais em português
- **Documentação:** [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- **Documentação:** [Mockito Docs](https://javadoc.io/doc/org.mockito/mockito-core/latest/index.html)

---

## 📝 Anotações por padrão

Cada pasta de padrão contém um `README.md` próprio com:

- Problema que o padrão resolve
- Diagrama UML simplificado (ASCII)
- Decisões de design tomadas
- Quando usar (e quando **não** usar)

---

*Estudos em progresso — atualizado a cada PR mergeada na `main`.*
