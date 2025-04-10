# 📦 API de Tienda - Indicaciones Especiales

Este documento contiene información importante para el consumo y uso de la API RESTful desarrollada para una tienda online.

---

## 1. 🔧 Configuraciones necesarias para la aplicación de consumo (cliente)

- Asegúrate de que la API esté **ejecutándose** en: `http://localhost:8080`
- Verifica que el **puerto 8080** esté disponible en tu equipo.
- Si estás consumiendo desde frontend (React, Angular, etc.), habilita CORS si es necesario.
- Si en un futuro se integra seguridad con JWT o Basic Auth, el cliente deberá enviar un token en los headers.

---

## 2. 📡 Cómo acceder a la sección del consumo del RESTful

Puedes consumir la API de dos formas principales:

### a) Postman

Ejemplos de endpoints que puedes probar:
- `GET http://localhost:8080/api/productos`
- `POST http://localhost:8080/api/categoria`
- `PUT http://localhost:8080/api/usuario/1`

### b) Swagger UI (interfaz visual de pruebas)

Accede desde tu navegador a:
```
http://localhost:8080/swagger-ui.html
```
Desde ahí podrás:
- Ver todos los endpoints disponibles
- Probar directamente cada operación (`GET`, `POST`, `PUT`, `DELETE`)
- Consultar validaciones, respuestas y errores

---

## 3. 📄 Cómo consultar la documentación OpenAPI

1. Ejecuta el proyecto desde tu IDE o con:
```bash
mvn spring-boot:run
```
2. Abre tu navegador en la siguiente URL:
```
http://localhost:8080/swagger-ui.html
```
3. Usa "Try it out" para probar los endpoints con datos reales.

---

## 4. 💡 Otras indicaciones importantes

- Todos los datos se envían y reciben en formato **JSON**.
- Las fechas se manejan con formato ISO (`yyyy-MM-dd'T'HH:mm:ss`).
- Campos obligatorios están validados con anotaciones como `@NotBlank`, `@NotNull`, `@Email`.
- Si faltan datos requeridos, se devuelve un error `400 Bad Request` con detalle del campo afectado.

---

### 📘 Ejemplos de cuerpos JSON para pruebas

#### 🛒 Crear un producto
```json
{
  "nombreProducto": "Mouse inalámbrico",
  "descripcion": "Mouse ergonómico para oficina",
  "precio": 399.99,
  "stock": 50,
  "imagen": "mouse.jpg",
  "idCategoria": 1
}
```

#### 📂 Crear una categoría
```json
{
  "nombre": "Electrónica",
  "descripcion": "Productos tecnológicos y dispositivos electrónicos"
}
```

#### 👤 Crear un usuario
```json
{
  "nombreUsuario": "ana.solis",
  "email": "ana@example.com",
  "password": "clave123"
}
```

#### 🧾 Crear un pedido
```json
{
  "total": 1299.99,
  "idUsuario": 5
}
```

---

