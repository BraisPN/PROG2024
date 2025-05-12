# Exercicio 1 - Xestión da Rede de Bibliotecas de Galicia

Crea un programa en Java para realizar a xestión da Rede de Bibliotecas de Galicia.

O programa contará con tres partes ben diferenciadas:

- Administración xeral
- Administración dunha biblioteca concreta
- Portal para usuarios

O acceso a calquera destas partes está restrinxido mediante credenciais de nome de usuario e contrasinal.

Ademais, o programa debe contar con persistencia de datos mediante ficheiros binarios.

---

## Administradores Xerais

Os administradores xerais poderán:

### Xestión de bibliotecas

- Dar de alta novas bibliotecas.
- Cada biblioteca contará con:
  - Nome (pode haber duplicados)
  - Dirección
  - Cidade
  - Provincia
  - Identificador único

- Ver a lista de tódalas bibliotecas no formato:
  ```
  <id> <nome>, <direccion>; <cidade> (<provincia>)
  ```

### Xestión de libros

- Dar de alta novos libros con:
  - Título
  - Autor(es) (poden ser varios)
  - Editorial
  - ISBN (10 díxitos, validar que é correcto)
  - Lingua (GALEGO, CASTELÁN ou INGLÉS)

> Non engadir libros duplicados. Para que dous libros sexan iguais deben ter o mesmo ISBN.

- Ver lista de libros no formato:
  ```
  <isbn>, <titulo> de <autores> en <lingua> (<editorial>)
  ```
  *(Os autores separados por `;`)*

- Indicar o número de exemplares comprados ao dar de alta un libro.
  - Cada exemplar terá un identificador único que conteña o ISBN.

### Formas de alta de libros

- A través da liña de comandos
- Mediante un ficheiro CSV co formato:
  ```
  titulo,editorial,lingua,autores,isbn,numExemplares
  ```

#### Exemplo CSV:

```
Artificial Intelligence: A Modern Approach,Pearson,INGLES,Stuart Russell & Peter Norvig,0201633612,5
Historia da literatura galega,Xerais,GALEGO,Xosé Ramón Pena & Dolores Vilavedra & Anxo Tarrío & María do Cebreiro Rábade Villar & Arturo Casas,0307474720,3
El nombre del viento,Plaza & Janés,ESPAÑOL,Patrick Rothfuss,8499890946,1
```

- Asignar exemplares a bibliotecas:
  - Só os que non estean xa asignados.
  - Pode haber varios exemplares do mesmo libro na mesma biblioteca.

### Xestión de administradores de biblioteca

- Dar de alta administradores de biblioteca con nome de usuario e contrasinal.
- No momento da alta, asignarlles unha única biblioteca.

> Conta inicial obrigatoria ao iniciar o programa:
```
Usuario: admin
Contrasinal: abc123..
```

---

## Administradores de Biblioteca

Responsables de:

### Préstamos e devolucións

- Ver exemplares libres da súa biblioteca no formato:
  ```
  <isbn>, <titulo> de <autores> en <lingua> (<editorial>)
  ID Exemplar: <id_exemplar>
  ```

- Realizar préstamos/devolucións indicando:
  - Identificador do exemplar
  - DNI do usuario

- Gardar:
  - Data do préstamo (data actual)
  - Data límite de devolución (2 semanas despois do préstamo)
    - Se coincide en domingo, adiar un día máis
  - Data de devolución se xa foi devolto

#### Regras:

- O usuario só pode ter **un libro prestado ao mesmo tempo**
- Non pode coller libros se está **sancionado**

### Sancións

- Un usuario queda sancionado se supera dúas veces a data límite no último ano.
- O ano conta dende a data de préstamo.

---

## Usuarios

Para darse de alta deben indicar:

- Nome
- Apelidos
- DNI (validar formato e que non exista xa)
- Correo electrónico (validar formato)
- Nome de usuario
- Contrasinal

### Funcionalidades

- Buscar libros por título e autor.
  - Amosar só os que teñen exemplares libres
  - Ordenar alfabeticamente por título
  - Usar **programación funcional** e **expresións regulares** na busca

- Consultar a **data límite de devolución** (formato `dd/mm/yyyy`) do préstamo en curso, se tiver.

---

## Notas importantes

- Realiza todas as **comprobacións mediante excepcións**.
- O uso incorrecto do **Modelo-Vista-Controlador (MVC)** implicará unha **nota de 0 puntos** no exercicio.
