# [Nome do Padrão] Pattern

> **Categoria:** Criacional | Estrutural | Comportamental  
> **Dificuldade:** Fácil | Médio | Difícil  
> **Status:** ⏳ Pendente | 🔄 Em andamento | ✅ Concluído

---

## 🧩 O problema

<!-- Descreva em 2-3 frases o problema concreto que motivou este desafio.
     Exemplo: "Precisamos criar objetos de notificação (Email, SMS, Push) sem
     acoplar o código cliente às classes concretas." -->

---

## 💡 A solução com o padrão

<!-- Explique em linguagem simples como o padrão resolve o problema acima.
     Foque no "por quê", não no "como" — o código já mostra o como. -->

---

## 🗂️ Estrutura do código

```
[nome-do-padrao]/
├── NomeInterface.java       # contrato principal
├── ClasseConcretaA.java     # implementação A
├── ClasseConcretaB.java     # implementação B
└── Contexto.java            # quem usa o padrão (opcional)
```

---

## 📐 Diagrama UML (ASCII)

```
        <<interface>>
        +NomeInterface+
              |
     _________|_________
    |                   |
ClasseConcretaA    ClasseConcretaB
+ metodo()         + metodo()
```

<!-- Dica: use https://asciiflow.com para diagramas mais elaborados -->

---

## ▶️ Como executar os testes

```bash
mvn test -Dtest=NomeDoPadraoTest
```

Resultado esperado:

```
[INFO] Tests run: N, Failures: 0, Errors: 0, Skipped: 0
```

---

## 🔴🟢🔵 Ciclo TDD aplicado

| Etapa | Teste | Resultado antes | Resultado depois |
|-------|-------|-----------------|------------------|
| Red   | `deveXxx()` | ❌ falha — classe não existe | — |
| Green | `deveXxx()` | — | ✅ passa com implementação mínima |
| Refactor | `deveXxx()` | ✅ ainda passa | ✅ código limpo |

<!-- Documente aqui os testes que você escreveu antes de implementar
     e o que cada um valida. -->

---

## ⚖️ Decisões de design

<!-- O que você considerou durante a implementação?
     Exemplos de perguntas úteis:
     - Usei interface ou classe abstrata? Por quê?
     - Considerei outra abordagem? O que a descartou?
     - Há algum trade-off nessa implementação? -->

-

---

## ✅ Quando usar este padrão

-
-
-

## ❌ Quando NÃO usar

-
-
-

---

## 🔗 Referências

- [Refactoring.Guru — Nome do Padrão](https://refactoring.guru/pt-br/design-patterns/nome)
- Livro GoF, p. XXX
