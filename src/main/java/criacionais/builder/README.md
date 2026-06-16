# Builder Pattern

> **Categoria:** Criacional
> **Dificuldade:** Fácil
> **Status:** ✅ Concluído

---

## 🧩 O problema

A classe `Pedido` possui muitos atributos — alguns obrigatórios, outros opcionais. Criar objetos via construtor convencional resultaria em assinaturas ilegíveis e propensas a erros de ordem de parâmetros, além de impossibilitar validações antes da criação do objeto.

---

## 💡 A solução com o padrão

O `Pedido.Builder` oferece uma API fluente para construção do pedido atributo por atributo. O método `build()` centraliza as validações e só retorna o objeto se o estado for válido. O cliente nunca instancia `Pedido` diretamente — sempre passa pelo Builder.

---

## 🗂️ Estrutura do código

    builder/
    └── Pedido.java               # classe principal + classe interna Builder
        ├── Pedido(Builder)       # construtor privado
        ├── getters               # acesso aos atributos
        └── Builder               # classe interna estática
            ├── Builder(String)   # construtor com campo obrigatório
            ├── comItens()        # método encadeado
            ├── comEnderecoEntrega()
            ├── comCupomDesconto()
            ├── comPrioridade()
            └── build()           # valida e retorna Pedido

---

## 📐 Diagrama UML (ASCII)

    +------------------+          +----------------------+
    |      Pedido      |          |    Pedido.Builder    |
    +------------------+          +----------------------+
    | - cliente        |  cria    | - cliente            |
    | - itens          | <------- | - itens              |
    | - enderecoEntrega|          | - enderecoEntrega    |
    | - cupomDesconto  |          | - cupomDesconto      |
    | - prioridade     |          | - prioridade="NORMAL"|
    +------------------+          +----------------------+
    | + getCliente()   |          | + Builder(String)    |
    | + getItens()     |          | + comItens()         |
    | + getEndereco()  |          | + comEndereco()      |
    | + getCupom()     |          | + comCupom()         |
    | + getPrioridade()|          | + comPrioridade()    |
    +------------------+          | + build()            |
                                  +----------------------+

---

## ▶️ Como executar os testes

    mvn test -Dtest=PedidoTest

Resultado esperado:

    [INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

---

## 🔴🟢🔵 Ciclo TDD aplicado

| Etapa | Teste | Resultado antes | Resultado depois |
|-------|-------|-----------------|------------------|
| Red | `deveCriarPedidoValido()` | ❌ classe não existe | — |
| Green | `deveCriarPedidoValido()` | — | ✅ Builder completo retorna Pedido |
| Red | `deveCriarPedidoComValoresPadrao()` | ❌ sem valor default | — |
| Green | `deveCriarPedidoComValoresPadrao()` | — | ✅ prioridade default "NORMAL" |
| Red | `deveLancarExcecaoSemCliente()` | ❌ sem validação | — |
| Green | `deveLancarExcecaoSemCliente()` | — | ✅ IllegalArgumentException no construtor |
| Red | `deveLancarExcecaoSemItens()` | ❌ sem validação | — |
| Green | `deveLancarExcecaoSemItens()` | — | ✅ IllegalStateException no build() |
| Red | `deveLancarExcecaoSemEnderecoEntrega()` | ❌ sem validação | — |
| Green | `deveLancarExcecaoSemEnderecoEntrega()` | — | ✅ IllegalStateException no build() |

> ⚠️ Na prática, os 5 testes foram escritos antes da implementação e todos passaram juntos no Green. Para os próximos padrões, o ciclo será aplicado um teste por vez.

---

## ⚖️ Decisões de design

- `Pedido` com atributos `final` — imutabilidade garantida após o `build()`
- Construtor de `Pedido` é `private` — a única forma de criar um pedido é pelo Builder
- `IllegalArgumentException` no construtor do Builder para `cliente` nulo — argumento inválido
- `IllegalStateException` no `build()` para itens e endereço ausentes — estado incompleto
- `prioridade` inicializada como `"NORMAL"` no Builder — valor default sem necessidade de `if` nos getters
- `Builder` como classe interna estática de `Pedido` — forte coesão, sem arquivo extra

---

## ✅ Quando usar este padrão

- Quando a classe tem muitos atributos, especialmente opcionais
- Quando a criação do objeto requer validações antes de ser concluída
- Quando você quer garantir imutabilidade do objeto após a criação
- Quando construtores com muitos parâmetros tornam o código ilegível

## ❌ Quando NÃO usar

- Quando a classe tem poucos atributos simples — um construtor convencional é suficiente
- Quando o objeto precisa ser mutável após a criação
- Quando a criação não envolve nenhuma lógica de validação

---

## 🔗 Referências

- [Refactoring.Guru — Builder](https://refactoring.guru/pt-br/design-patterns/builder)
- Livro GoF, p. 97