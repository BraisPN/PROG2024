## Exercicio 2

Segue os seguintes pasos:

### Clase Deportista (abstracta)

Crea unha clase **abstracta** chamada `Deportista` coas seguintes características:

- Gardar o seu **nome completo**, **nome polo que é coñecido popularmente** e a súa **data de nacemento**.
- Crea os **getters** e **setters** necesarios.
- Crea un **construtor** que reciba todos os atributos (co formato de data: `dd/MM/yyyy`).
- **Documenta** os construtores.
- Crea o método `int getIdade()` que devolva a idade do deportista.
- **Documenta** os métodos.
- Redefine o método `toString()` para que mostre os datos do deportista no seguinte formato:

  ```
  <nomePopular> : <idade> anos
  ```

---

### Clase Tenista

Crea unha clase `Tenista` que **herde** de `Deportista`:

- Indicar o seu **número no ranking mundial de tenis**.
- Crea os **getters** e **setters** necesarios.
- Redefine o **construtor** para incluír o novo atributo.
- **Documenta** os construtores.
- Redefine o método `toString()` co seguinte formato:

  ```
  Tenista: <nomePopular> : <idade> anos. Nº <posicionRanking> do mundo.
  ```

---

### Clase Piloto (abstracta)

Crea unha clase **abstracta** chamada `Piloto` que **herde** de `Deportista`:

- Indicar o seu **nome de equipo**.
- Crea os **getters** e **setters** necesarios.
- Redefine o **construtor** para incluír o novo atributo.
- **Documenta** os construtores.
- Crea o método **abstracto** `double getPuntos()` que devolva o número de puntos.
- **Documenta** os métodos.
- Redefine o método `toString()` co seguinte formato:

  ```
  <nomePopular> : <idade> anos. Equipo: <equipo> - Puntos: <puntos>
  ```

---

### Clase PilotoF1

Crea unha clase `PilotoF1` que **herde** de `Piloto`:

- Indicar:
  - Número de **vitorias totais**
  - Número de **voltas rápidas**
  - Número de **poles positions**

- Crea os **getters** e **setters** necesarios.
- Redefine o **construtor** para incluír os novos atributos.
- **Documenta** os construtores.
- Redefine o método `getPuntos()`:
  - Cada vitoria: **25 puntos**
  - Cada volta rápida: **1 punto**
  - Cada poles position: **5 puntos**

---

### Clase PilotoMotoGP

Crea unha clase `PilotoMotoGP` que **herde** de `Piloto`:

- Indicar o **número total de puntos**.
- Redefine o **construtor** para incluír o novo atributo.
- **Documenta** os construtores.
- Redefine o método `getPuntos()` para que devolva directamente o número de puntos.

---

### Programa Principal

1. Crea un `ArrayList` para almacenar **tódolos deportistas**.
2. Crea un `ArrayList` para almacenar **tódolos tenistas**.
3. Crea un `ArrayList` para almacenar **tódolos pilotos**.
4. Crea un `ArrayList` para almacenar **tódolos pilotos de Fórmula 1**.
5. Crea un `ArrayList` para almacenar **tódolos pilotos de MotoGP**.

---

### Instancias

- **Tenista**:
  - Nome e Apelidos: Carlos Jonás Alcaraz
  - Nome polo que é coñecido: Carlos Alcaraz
  - Data de nacemento: 23 de maio de 2003
  - Ranking mundial: 3º

- **Tenista**:
  - Nome e Apelidos: Novak Djokovic
  - Nome polo que é coñecido: Djokovic
  - Data de nacemento: 22 de maio de 1987
  - Ranking mundial: 2º

- **PilotoF1**:
  - Nome e Apelidos: Fernando Alonso Díaz
  - Nome polo que é coñecido: Fernando Alonso
  - Data de nacemento: 29 de xullo de 1981
  - Equipo: Aston Martin
  - Vitorias: 33
  - Voltas rápidas: 26
  - Poles Positions: 22

- **PilotoF1**:
  - Nome e Apelidos: Max Emilian Verstappen
  - Nome polo que é coñecido: Verstappen
  - Data de nacemento: 30 de setembro de 1997
  - Equipo: Red Bull Racing
  - Vitorias: 62
  - Voltas rápidas: 33
  - Poles Positions: 40

- **PilotoMotoGP**:
  - Nome e Apelidos: Marc Márquez Alentà
  - Nome polo que é coñecido: Marc Márquez
  - Data de nacemento: 17 de febreiro de 1993
  - Equipo: Grenesi Racing
  - Puntos: 102

- **PilotoMotoGP**:
  - Nome e Apelidos: Francesco Bagnaia
  - Nome polo que é coñecido: Bagnaia
  - Data de nacemento: 14 de xaneiro de 1997
  - Equipo: Ducati Lenovo Team
  - Puntos: 461

---

### Recorre e imprime:

- `ArrayList` de **deportistas** → usando polimorfismo, imprime `toString()`.
- `ArrayList` de **pilotos** → usando polimorfismo, imprime `toString()`.
- `ArrayList` de **tenistas** → imprime `toString()`.
- `ArrayList` de **pilotos de Fórmula 1** → imprime `toString()`.
- `ArrayList` de **pilotos de MotoGP** → imprime `toString()`.