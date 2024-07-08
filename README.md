# Gestión de Tareas API

Esta API te permite gestionar tus tareas de manera eficiente. Con esta API, puedes crear nuevas tareas, visualizar las tareas existentes, editar las tareas para actualizar su información y eliminar tareas que ya no son necesarias. 

## **Respuestas de Error Comunes**

| HTTP Status Code | Descripción |
| --- | --- |
| 400 Bad Request | Solicitud inválida o malformada. |
| 401 Unauthorized | Autenticación requerida. |
| 403 Forbidden | No tienes permiso para realizar esta acción. |
| 404 Not Found | Recurso no encontrado. |
| 500 Internal Server Error | Error del servidor. |

## **Endpoints**

### **Endpoints soportados**

| HTTP Method | URL | Endpoint |
| --- | --- | --- |
| POST | /tasks | Crear nueva tarea  |
| GET | /tasks | Obtener tareas |
| POST | /tasks/{id} | Editar una tarea |
| DELETE | /tasks/{id} | Eliminar una tarea |
| POST | /close-tasks/{id} | Cerrar tarea |
| POST | /reopen-tasks/{id} | Reabrir tarea |
