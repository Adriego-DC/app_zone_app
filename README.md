📱 App Zone - Proyecto Android con Firebase
App Zone es una aplicación Android desarrollada desde cero, centrada en la gestión de juegos personales con un enfoque moderno en diseño, autenticación segura y almacenamiento en la nube.

🔧 Tecnologías utilizadas:
Lenguaje: Kotlin

Arquitectura: Android con Material Design

Backend: Firebase Authentication y Realtime Database

IDE: Android Studio

🚀 Funcionalidades implementadas
🔐 Autenticación con Firebase
Se implementó Firebase Authentication desde cero para permitir el inicio de sesión de usuarios mediante correo y contraseña. Al autenticarse exitosamente, el usuario es redirigido a la pantalla principal personalizada.

Validación de campos de correo y contraseña.

Manejo de sesiones de usuario.

Logout seguro con retroceso a la pantalla de login.

🗂️ Gestión de Juegos en la Nube
Se integró Firebase Realtime Database para almacenar y gestionar juegos por usuario autenticado.

Las funcionalidades implementadas incluyen:

🎮 Registrar Juegos
Pantalla diseñada para añadir un nuevo juego con los siguientes campos:

Título

Género

Puntuación (Rating)

Guardado automático con UID del usuario en la base de datos de Firebase.

✔ Mensajes de éxito y validación en tiempo real.

📋 Mostrar Juegos
Vista en lista (RecyclerView) que permite visualizar todos los juegos registrados por el usuario autenticado.
Cada elemento se muestra en tarjetas personalizadas que muestran:

Nombre del juego

Género

Puntuación visual con RatingBar

✏️ Editar y Eliminar Juegos
Desde la lista de juegos, al tocar un juego, el usuario accede a una pantalla donde puede:

Editar título, género o puntuación.

Guardar los cambios que se actualizan en la base de datos en tiempo real.

Eliminar el juego si lo desea, con confirmación visual.

✔ Se muestran Toast de confirmación al editar o eliminar.

🎨 Interfaz moderna y responsive
Uso de MaterialCardView, RatingBar, TextInputLayout y gradientes visuales personalizados.

Diseños responsivos con ConstraintLayout, ScrollView, y estilos temáticos para cada sección.

📦 Estructura adicional
Game.kt: Data class que define la estructura del juego en la base de datos.

GameAdapter.kt: Adaptador para RecyclerView con funcionalidad extendida.

AddGameActivity.kt, EditGameActivity.kt: Actividades separadas para registrar y editar.

FUNCIONALIDAD DEL PROGRAMA

Creamos la Base de Datos y usamos el Autentication para Correo/contraseña y Anonimo:

![WhatsApp Image 2025-06-28 at 12 10 24](https://github.com/user-attachments/assets/bf27ba86-eb45-49fa-be6e-b7c96f9266ee)

Comprobamos su funcionalidad registrnadonos

![WhatsApp Image 2025-06-28 at 12 12 30](https://github.com/user-attachments/assets/ab869600-0e03-4fb9-bd6d-ba8ac7dfe594)
![WhatsApp Image 2025-06-28 at 12 12 33](https://github.com/user-attachments/assets/a7434e4f-5d5b-4188-92b8-c8d533ad7771)

Y pues como podemos ver si aparece en nuestra base de datos e registro:

![WhatsApp Image 2025-06-28 at 12 12 55](https://github.com/user-attachments/assets/36d9dbb9-f53f-4e86-a19d-550770776cbe)


Ahora Agregaremos las funcionalidades extra de Registro de Juego, de Mostrar Juegos y Editar Juegos:

![WhatsApp Image 2025-06-28 at 12 15 38](https://github.com/user-attachments/assets/613e546c-16a1-43e8-8311-dd059d554cc6)

Entramos al de Registrar Juegos y llenamos los campos:

![WhatsApp Image 2025-06-28 at 12 18 24](https://github.com/user-attachments/assets/0c51073e-5933-409c-b005-a1447ac8a42c)

Comprobamos si se añadió a nuestra base de Datos

![WhatsApp Image 2025-06-28 at 12 18 07](https://github.com/user-attachments/assets/2491fe97-e0b0-4942-bdcf-5c818ef25e53)

Ahora mostramos el campo de Mostrar Juegos que se muestra en forma de lista todos los juegos de la base de datos:

![WhatsApp Image 2025-06-28 at 12 20 20](https://github.com/user-attachments/assets/a61d91bf-3366-48eb-9a83-570f34bca599)

Y el ultimo campo para editar los juegos donde se muestra la misma lista que en el campo de mostrar juegos, pero cada juego "escucha" al ser tocado y abre otra pantalla para ser editado:

![WhatsApp Image 2025-06-28 at 12 20 20](https://github.com/user-attachments/assets/653afae3-574d-44e7-ad0a-cab467d7b899)

Por ejemplo tocamos el de DOTA y nos precarga su contenido y podremos sobvreescribir o eliminar dicho juego:

![WhatsApp Image 2025-06-28 at 12 22 32](https://github.com/user-attachments/assets/3c14532e-004e-4f92-be98-c8d1344c058a)

Si loeliminamos nos aparecera lo siguiente :

![WhatsApp Image 2025-06-28 at 12 23 30](https://github.com/user-attachments/assets/bd473fd0-73e1-405c-b67f-91c2dd62dcb8)

Y por consecuencia desaparece de nuestra BD y ya no esta como podemos ver se elimino el juego "DOTA" de nuestra BD:

![WhatsApp Image 2025-06-28 at 12 24 29](https://github.com/user-attachments/assets/8fef8b29-0db4-4587-9955-1af9f18701bb)

asimismo se puede editar, por ejemplo editaremos el LOL que tiene estas caracteristicas de momento:

![WhatsApp Image 2025-06-28 at 12 26 04](https://github.com/user-attachments/assets/50fa32ff-5e5d-4d42-9665-227fc5415954)

Y editamos de la siguiente manera:

![WhatsApp Image 2025-06-28 at 12 26 07](https://github.com/user-attachments/assets/88f4a74f-2736-40ee-a579-db6bcd2ffa28)

Se actualiza en nuestr app:

![WhatsApp Image 2025-06-28 at 12 26 14](https://github.com/user-attachments/assets/881c4c6d-79cc-4841-ae4d-fa182eeb145c)

Y por ultimo se actualiza en nuestra BD:

![WhatsApp Image 2025-06-28 at 12 28 04](https://github.com/user-attachments/assets/4b500e65-d38a-4cd6-8274-43bd26e3a5ef)

