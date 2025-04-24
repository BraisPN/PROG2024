# Exercicio 1

Unha tenda de música de Santiago de Compostela, **Musi.com**, desexa realizar unha aplicación para xestionar a compra de produtos na súa tenda.

## Requisitos da Aplicación

### Xestión de Usuarios

- Rexistro e inicio de sesión mediante nome de usuario e contrasinal.
- Dous perfís de usuario:
  - **Administradores**
  - **Clientes**
- Non poden existir dous usuarios co mesmo nome de usuario.

### Xestión de Produtos

- Cada produto terá:
  - Identificador único
  - Prezo (con IVE e sen IVE)
  - Stock dispoñible
  - Breve descrición
- O IVE de tódolos produtos será do **21%**.

### Categorías de Produtos

#### 1. Instrumentos Musicais

- Gardan os datos comúns de produto, máis:
  - Marca
  - Modelo

| Tipo de Instrumento | Características Propias                         |
|---------------------|-------------------------------------------------|
| Frautas             | Poden ter “pe de Si” ou non                    |
| Saxofóns            | Tipos: soprano, alto, tenor, barítono          |
| Trombóns            | Poden ter transpositor ou non                  |

#### 2. Complementos

| Complemento | Características Propias                                     |
|------------|-------------------------------------------------------------|
| Libros     | Título, autor, ISBN de 10 díxitos (verificación incluída)   |
| Estoxos    | Instrumento ao que pertence e marca                          |

### Formato de Visualización dos Produtos

| Tipo Produto | Formato Texto |
|--------------|----------------|
| Frauta       | Frauta. \<marca\>: \<modelo\> - \<características\>. Prezo con IVE: € ; Prezo sen IVE: € ; Stock: unidades ; Descrición: \<descrición\>. |
| Saxofón      | Saxofón. \<marca\>: \<modelo\> - \<características\>. Prezo con IVE: € ; Prezo sen IVE: € ; Stock: unidades ; Descrición: \<descrición\>. |
| Trombón      | Trombón. \<marca\>: \<modelo\> - \<características\>. Prezo con IVE: € ; Prezo sen IVE: € ; Stock: unidades ; Descrición: \<descrición\>. |
| Libro        | Libro. \<título\>: \<autor\> - ISBN: \<isbn\>. Prezo con IVE: € ; Prezo sen IVE: € ; Stock: unidades ; Descrición: \<descrición\>. |
| Estoxo       | Estoxo. \<instrumento\> - \<marca\>. Prezo con IVE: € ; Prezo sen IVE: € ; Stock: unidades ; Descrición: \<descrición\>. |

## Funcionalidades por Rol

### Administrador

- **Engadir produto** (submenú para escoller tipo)
- **Ver produtos** (submenú):
  - Tódolos produtos
  - Tódolos instrumentos
  - Tódalas frautas
  - Tódolos saxofóns
  - Tódolos trombóns
  - Tódolos complementos
  - Tódolos libros
  - Tódolos estoxos
  - Información dun produto concreto (por identificador)
- **Engadir stock** (por identificador)
- **Eliminar stock** (por identificador)

### Cliente

- **Ver produtos** (submenú):
  - Tódolos produtos
  - Tódolos instrumentos
  - Tódalas frautas
  - Tódolos saxofóns
  - Tódolos trombóns
  - Tódolos complementos
  - Tódolos libros
  - Tódolos estoxos
- **Comprar unha unidade** (por identificador, sen almacenar compras, só modificar stock)

## Excepcións Personalizadas

- Rexistro con nome de usuario xa existente.
- Prezo negativo.
- Stock negativo.
- ISBN incorrecto.
- Acceso a produto con identificador inválido.
- Eliminar máis stock do dispoñible.
- Comprar produto sen stock dispoñible.

## Datos de Proba

- Ao iniciar o programa deben cargarse usuarios e produtos de proba automaticamente.

## Patróns de Deseño

- **Singleton**: Para almacenar os datos da tenda.
- **MVC**: Para modelar a aplicación.

## Rúbrica de Corrección

| Ítem                                                                 | Puntuación       |
|----------------------------------------------------------------------|------------------|
| Xerarquía de clases (usuarios, produtos, herdanza, etc.)             | 1,5 puntos       |
| Enumerandos para roles de usuario                                    | 0,5 puntos       |
| Rexistro de usuarios                                                 | 0,75 puntos      |
| Inicio de sesión                                                     | 0,75 puntos      |
| Engadir produto (administrador)                                      | 0,75 puntos      |
| Ver produtos (administrador)                                         | 1,25 puntos      |
| Ver info dun produto (administrador)                                 | 0,25 puntos      |
| Engadir/eliminar stock (administrador)                               | 0,25 puntos      |
| Ver produtos (cliente)                                               | 0,5 puntos       |
| Comprar produto (cliente)                                            | 0,25 puntos      |
| MVC implantado correctamente                                         | 1 punto          |
| Método estático para comprobar ISBN                                  | 0,75 punto       |
| Captura de excepcións                                                | 1 punto          |
| Patrón Singleton                                                     | 0,25 puntos      |
| Engadir datos de proba                                               | 0,25 puntos      |
