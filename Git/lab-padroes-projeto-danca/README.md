# Gerador de aula de dança (Padrões de Projeto em Java)

Projeto final do laboratório de Padrões de Projeto da DIO. Em vez de refazer o exemplo da aula, montei um problema do meu mundo: dança de salão. O professor informa ritmo, nível, duração e alunos, e o programa devolve um plano de aula com andamento, contagem e a sequência de passos.

Java puro, sem framework, só para os padrões ficarem visíveis.

## Por que cada padrão

**Strategy (`ritmo/`)**
Samba, forró e zouk mudam em quase tudo: BPM, contagem e quanto tempo a turma leva para fixar um passo. Se eu usasse `if/else` por ritmo, cada ritmo novo mexeria em código que já funciona. Com Strategy, cada ritmo é uma classe e adicionar um novo não toca nas outras.

**Factory Method (`passos/`)**
Montar a sequência é igual para qualquer ritmo (filtrar pelo nível e limitar a quantidade). O que muda é o catálogo de passos. A classe abstrata `FabricaDePassos` guarda a montagem e cada subclasse só responde "quais passos existem no meu ritmo".

**Chain of Responsibility (`validacao/`)**
Antes de gerar a aula, o pedido passa por três checagens: duração, quantidade de alunos (dança de par precisa de número par) e nível versus duração. Cada checagem é um elo e pode ser trocada ou reordenada sem mexer nas outras.

**Observer (`notificacao/`)**
Quando uma aula é gerada, quem precisa saber é avisado: os alunos (WhatsApp simulado) e o caderno do professor. O gerador não sabe quem está ouvindo, então dá para plugar um novo aviso sem alterar nada dele.

**Facade (`fachada/`)**
`GeradorDeAulaFacade` junta tudo isso. O `Main` só chama `gerar(pedido)`.

## Estrutura

```
src/
├── modelo/       # Nivel, Passo, PedidoDeAula, PlanoDeAula
├── ritmo/        # Strategy
├── passos/       # Factory Method
├── validacao/    # Chain of Responsibility
├── notificacao/  # Observer
├── fachada/      # Facade
└── app/Main.java
```

## Como rodar

Precisa do JDK 17 ou superior (uso `record` e `switch` com setas).

```bash
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out app.Main
```

No Windows (PowerShell):

```powershell
mkdir out
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out app.Main
```

Exemplo de saída:

```
[WhatsApp] Oi, Ana! Sua aula de zouk está confirmada (60 min).
...
=== Aula de zouk | iniciante | 60 min ===
Música: ~80 BPM | Contagem: 1-2-3 / 4-5-6 (ondulação no tempo 1)
Passos:
  1. Base lateral (iniciante)
  2. Ondulação de corpo (iniciante)

Pedido recusado (samba): Aula de iniciante com mais de 90 min rende pouco. Divida em duas.
Pedido recusado (samba): Número ímpar de alunos (3): alguém ficaria sem par.
```

## O que aprendi

> ESCREVA AQUI com as suas palavras: 2 ou 3 frases sobre o que foi mais difícil
> (por exemplo, entender o papel do `proximo` na chain, ou quando vale a pena
> usar Strategy em vez de herança) e o que você faria diferente.

## Próximos passos

- Guardar as aulas em banco de dados em vez de só em memória
- Migrar para Spring Boot e expor uma API REST
- Adicionar mais ritmos (bolero, salsa) para testar a facilidade de estender
- Testes unitários para cada validador
