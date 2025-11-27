# 🏦 Banco Digital

Este proyecto es una **aplicación Java orientada a objetos**, diseñada para aplicar **TODOS** los principios fundamentales y avanzados de POO:

* **Clases y Objetos**
* **Encapsulamiento**
* **Herencia**
* **Polimorfismo**
* **Abstracción**
* **Interfaces**
* **Excepciones personalizadas**
* **Composición**
* **Relaciones entre clases (UML)**
* **Capas de repositorio, servicio y dominio**

El resultado es una simulación de un **Banco Digital** completamente funcional mediante consola.

---

# 📌 Objetivo del Proyecto

Este proyecto sirve como una **base sólida** para entender, practicar y dominar POO en Java de manera profunda y profesional.

Incluye gestión de:

* Clientes
* Cuentas bancarias (ahorro, corriente, inversión)
* Tarjetas (débito, crédito)
* Préstamos
* Transacciones (depósitos, retiros, transferencias)
* Notificaciones
* Repositorios en memoria (como si fuese una BD)
* Servicios de negocio

---

# 📦 Estructura de Paquetes

```
com.banco
 ├── app
 │    └── DemoBanco.java
 ├── exception
 │    ├── SaldoInsuficienteException.java
 │    ├── CuentaNoEncontradaException.java
 │    ├── ClienteNoEncontradoException.java
 │    └── LimiteCreditoExcedidoException.java
 ├── model
 │    ├── Cliente.java
 │    ├── Cuenta.java
 │    ├── CuentaAhorro.java
 │    ├── CuentaCorriente.java
 │    ├── CuentaInversion.java
 │    ├── Tarjeta.java
 │    ├── TarjetaDebito.java
 │    ├── TarjetaCredito.java
 │    ├── Prestamo.java
 │    ├── Transaccion.java
 │    ├── TipoTransaccion.java
 │    └── TipoPrestamo.java
 ├── repo
 │    ├── IRepositorio.java
 │    ├── RepositorioClientes.java
 │    ├── RepositorioCuentas.java
 │    └── RepositorioPrestamos.java
 └── service
      ├── INotificacion.java
      ├── ServicioNotificaciones.java
      ├── ServicioClientes.java
      └── ServicioCuentas.java
```

---

# 🧠 Descripción del Dominio

## 👤 Cliente

Representa a un usuario del banco.

**Atributos:** nombre, email, teléfono, cuentas, tarjetas.

**Relaciones:**

* *1 a muchos* con **Cuenta**
* *1 a muchos* con **Tarjeta**

---

## 🏦 Cuenta (Abstracta)

Clase base para todos los tipos de cuenta.

**Atributos:** número, balance, historial de transacciones.

**Métodos comunes:** depositar, retirar, transferir.

**Subclases:**

* CuentaAhorro
* CuentaCorriente
* CuentaInversion

---

## 💳 Tarjeta (Abstracta)

Clase base para representar tarjetas asociadas a una cuenta.

**Subclases:**

* TarjetaDebito (usa el balance de la cuenta)
* TarjetaCredito (usa un límite de crédito)

---

## 💸 Transaccion

Representa depósitos, retiros y transferencias.

---

## 📄 Prestamo

Modelo de un préstamo simple con interés.

---

## 📦 Repositorios (como BD en memoria)

Implementan CRUD básico.

---

## 🛠 Servicios

### ServicioClientes

* Registrar clientes
* Buscar por ID o email

### ServicioCuentas

* Depositar
* Retirar
* Transferir

### ServicioNotificaciones

* Envía “notificaciones” (simuladas por consola)

---

# 🔗 Relaciones entre Clases

## 📘 Diagrama Modelo del Cliente

```
Cliente
 ├── nombre
 ├── email
 ├── telefono
 ├── cuentas List<Cuenta>
 └── tarjetas List<Tarjeta>
```

---

## 🏦 Jerarquía de Cuentas

```
           Cuenta (abstract)
           /        |        \
  Ahorro        Corriente     Inversion
```

### Relación Cliente → Cuenta

```
Cliente 1 ----- * Cuenta
```

---

## 💳 Jerarquía de Tarjetas

```
           Tarjeta (abstract)
           /                \
     Debito               Credito
```

### Relación Cuenta → TarjetaDébito

```
Cuenta 1 ----- * TarjetaDebito
```

### Relación Cuenta → TarjetaCrédito

```
(La tarjeta de crédito no depende de una cuenta específica)
```

---

## 💸 Transacciones

```
Cuenta 1 ----- * Transaccion
```

---

## 🛠 Servicios

```
ServicioClientes -----> RepositorioClientes
ServicioCuentas  -----> RepositorioCuentas
ServicioNotificaciones -> Consola
```

---

# ▶️ Flujo General del Sistema

1. Registrar un cliente
2. Crear cuentas
3. Asignar tarjetas
4. Realizar depósitos
5. Hacer retiros y transferencias
6. Solicitar préstamos
7. Registrar transacciones
8. Notificar al cliente

---

# 🚀 Cómo ejecutar el proyecto

1. Clonar el proyecto
2. Abrirlo en IntelliJ o cualquier IDE Java
3. Asegurarse de tener Java 17+ instalado
4. Ejecutar:

```
com.banco.app.DemoBanco
```

---

# 📚 Conceptos de POO aplicados

### ✔ Abstracción

Clases abstractas `Cuenta` y `Tarjeta`.

### ✔ Herencia

`CuentaAhorro`, `CuentaCorriente`, `TarjetaDebito`, etc.

### ✔ Polimorfismo

Métodos `retirar`, `aplicarInteres`, etc.

### ✔ Encapsulación

Atributos privados, getters/setters necesarios.

### ✔ Composición

Cliente → cuentas, tarjetas.

### ✔ Interfaces

`INotificacion`, `IRepositorio`.

### ✔ Excepciones Personalizadas

`SaldoInsuficienteException`, etc.

### ✔ Capas

Dominio, repositorio, servicios, aplicación.

---

