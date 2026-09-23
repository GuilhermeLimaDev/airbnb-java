<div align="center">

# 🏡 Airbnb Java

**Cadastro de usuários, propriedades e reservas pelo terminal.**

Java 11+ · Orientação a objetos · Interface de console

[Funcionalidades](#-funcionalidades) · [Como executar](#-como-executar) · [Exemplo de uso](#-exemplo-de-uso) · [Estrutura](#-estrutura-do-projeto)

</div>

---

## 📖 Sobre o projeto

Uma aplicação em Java que simula um fluxo de locação e hospedagem: cadastrar um locador, registrar sua propriedade e criar reservas para um locatário. A interação acontece por um menu no terminal, com cálculo automático do valor da estadia.

O código utiliza classes para representar usuários, propriedades e reservas, além de recursos da biblioteca padrão do Java para leitura de dados, armazenamento em memória e operações com datas.

## ✨ Funcionalidades

| Módulo | O que é possível fazer |
| --- | --- |
| 👤 Usuários | Cadastrar locador e locatário e consultar seus dados, com a senha mascarada na exibição. |
| 🏠 Propriedades | Cadastrar título, descrição, localização, capacidade e preço por noite, vinculando a propriedade ao locador. |
| 📅 Reservas | Criar reservas com datas de entrada e saída e listar as reservas cadastradas. |
| 💰 Valor da estadia | Calcular o custo total a partir da quantidade de noites e do preço por noite. |

### Regras para criar uma reserva

- É necessário cadastrar um **locatário** e uma **propriedade**.
- Para cadastrar a propriedade, é necessário ter um **locador**.
- As datas devem ser válidas e seguir o formato **`AAAA-MM-DD`**.
- A data de saída deve ser posterior à data de entrada.

## 🚀 Como executar

### Pré-requisitos

- **JDK 11 ou superior**, com os comandos `java` e `javac` disponíveis no terminal. O projeto utiliza `String.repeat`, disponível a partir do Java 11.
- Não são necessárias bibliotecas externas, Maven ou Gradle.

### Compilar e iniciar

Na pasta que contém os arquivos `.java`, execute:

```sh
javac -encoding UTF-8 Principal.java Usuario.java Propriedade.java Reserva.java
java Principal
```

### Menu principal

```text
USUÁRIOS ________________
1 - Criar usuário
2 - Exibir dados dos usuários

PROPRIEDADES ____________
3 - Criar propriedade
4 - Exibir dados da propriedade

RESERVAS ________________
5 - Criar reserva
6 - Listar reservas

7 - Encerrar
```

## 🧭 Exemplo de uso

1. Escolha **1 — Criar usuário** e selecione **1 — Locador**. Preencha nome, e-mail e senha.
2. Escolha **3 — Criar propriedade** e informe os dados do imóvel. Para este exemplo, use o título `Chale` e o preço por noite `150`.
3. Escolha **1 — Criar usuário** novamente e selecione **2 — Locatário**. Use `Ana` como nome e preencha os demais dados.
4. Escolha **5 — Criar reserva**. Informe entrada em `2026-10-10` e saída em `2026-10-13`.
5. Escolha **6 — Listar reservas** para consultar a estadia:

```text
Usuário: Ana
Propriedade: Chale
Check-in: 2026-10-10
Check-out: 2026-10-13
Custo total: R$ 450.0
```

**Cálculo:** 3 noites × R$ 150,00 = **R$ 450,00**. A data de saída não conta como uma noite adicional.

> Na versão atual, preencha os campos de texto sem espaços, por exemplo, `Chale_da_Serra`. A leitura desses campos utiliza `Scanner.next()`.

## 🗂️ Estrutura do projeto

```text
airbnb-java/
├── Principal.java      # Menu e integração dos cadastros e reservas
├── Usuario.java        # Dados e tipo do usuário: locador ou locatário
├── Propriedade.java    # Dados do imóvel e vínculo com o proprietário
├── Reserva.java        # Datas, cálculo da estadia e exibição da reserva
└── README.md           # Documentação do projeto
```

## 📌 Escopo atual

- Os dados ficam **em memória** e são descartados ao encerrar o programa.
- A aplicação mantém **um locador, um locatário e uma propriedade** por execução, com uma lista que permite múltiplas reservas. Um novo cadastro do mesmo tipo substitui os dados anteriores.
- As reservas referenciam o usuário e a propriedade cadastrados; alterações nesses cadastros também aparecem ao listar reservas existentes.
- Não há verificação de conflito entre períodos de reservas, cancelamento ou autenticação de usuários.
