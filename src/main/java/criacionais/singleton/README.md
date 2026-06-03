# Singleton Pattern

> **Categoria:** Criacional
> **Dificuldade:** Médio
> **Status:** ✅ Concluído

---

## 🧩 O problema

Uma aplicação precisa acessar configurações globais como idioma, tema e versão em diversos pontos do sistema.

Criar múltiplas instâncias dessas configurações pode gerar inconsistências, desperdício de memória e comportamentos inesperados. Precisamos garantir que exista apenas uma instância compartilhada por toda a aplicação.

---

## 💡 A solução com o padrão

O padrão Singleton garante que apenas uma instância da classe seja criada durante todo o ciclo de vida da aplicação.

Além de controlar a criação do objeto, ele fornece um ponto único de acesso para qualquer parte do sistema que precise consultar ou modificar as configurações globais.

---

## 🗂️ Estrutura do código

```src/
├── main/java/criacionais/singleton/
│   ├── ConfiguracaoApp.java
│   └── README.md
│
└── test/java/criacionais/singleton/
    └── ConfiguracaoAppTest.java
```

---

## 📐 Diagrama UML (ASCII)

```text
+----------------------+
|   ConfiguracaoApp    |
+----------------------+
| - instancia          |
| - idioma             |
| - tema               |
| - versao             |
+----------------------+
| + getInstance()      |
| + getIdioma()        |
| + setIdioma()        |
| + getTema()          |
| + setTema()          |
| + getVersao()        |
| + setVersao()        |
+----------------------+
```

---

## ▶️ Como executar os testes

```bash
mvn test -Dtest=ConfiguracaoAppTest
```

Resultado esperado:

```text
[INFO] Tests run: N, Failures: 0, Errors: 0, Skipped: 0
```

---

## 🔴🟢🔵 Ciclo TDD aplicado

| Etapa    | Teste                                      | Resultado antes              | Resultado depois            |
| -------- | ------------------------------------------ | ---------------------------- | --------------------------- |
| Red      | `deveRetornarMesmaInstancia()`             | ❌ falha — classe inexistente | —                           |
| Green    | `deveRetornarMesmaInstancia()`             | —                            | ✅ retorna a mesma instância |
| Red      | `deveCompartilharEstadoEntreReferencias()` | ❌ falha                      | —                           |
| Green    | `deveCompartilharEstadoEntreReferencias()` | —                            | ✅ estado compartilhado      |
| Red      | `deveSerThreadSafe()`                      | ❌ falha                      | —                           |
| Green    | `deveSerThreadSafe()`                      | —                            | ✅ única instância criada    |
| Refactor | Todos os testes                            | ✅ continuam passando         | ✅ código simplificado       |

---

## ⚖️ Decisões de design

* Implementar o Singleton utilizando Double-Checked Locking.
* Utilizar o modificador `volatile` para evitar problemas de visibilidade entre threads.
* Construtor privado para impedir instanciação externa.
* Método estático `getInstance()` como ponto único de acesso.
* Comparar posteriormente a implementação com Singleton baseado em `enum`.

### Trade-offs

**Vantagens**

* Controle centralizado da instância.
* Economia de memória.
* Consistência dos dados globais.

**Desvantagens**

* Introduz estado global.
* Pode dificultar testes em cenários complexos.
* Uso excessivo pode aumentar acoplamento.

---

## ✅ Quando usar este padrão

* Configurações globais da aplicação.
* Gerenciamento de logs.
* Pools de conexão.
* Cache compartilhado.
* Objetos de configuração carregados uma única vez.

---

## ❌ Quando NÃO usar

* Quando múltiplas instâncias podem existir sem problemas.
* Quando a classe possui estado específico por usuário.
* Quando a necessidade é apenas compartilhar dependências (preferir Injeção de Dependência).
* Quando o Singleton é utilizado apenas por conveniência.

---

## 🎯 Objetivos do desafio

* [ ] Implementar a classe `ConfiguracaoApp`.
* [ ] Garantir apenas uma instância da classe.
* [ ] Implementar solução thread-safe.
* [ ] Criar testes validando que múltiplas referências apontam para o mesmo objeto.
* [ ] Comparar a implementação com Singleton usando Enum.
* [ ] Pesquisar Double-Checked Locking.

---

## 🔗 Referências

* Refactoring.Guru — Singleton Pattern
* Design Patterns: Elements of Reusable Object-Oriented Software (GoF)
* Effective Java — Item: Prefer Enum Types to Singleton
* Pesquisar:

  * Double-Checked Locking
  * Enum Singleton
  * Lazy Initialization
  * Thread Safety em Java

Esse formato fica mais alinhado com um repositório de estudos de Design Patterns, documentando o desafio, os requisitos, os testes TDD planejados e os tópicos de pesquisa antes da implementação.

