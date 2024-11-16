Clase Ascensor: Incluye control de movimiento entre pisos, gestión del estado de sus puertas, 
y procesamiento de solicitudes de movimiento. Utiliza varios componentes como las clases Puerta 
y Botonera para proporcionar una funcionalidad completa y segura

Clase Boton_Ascensor: Se encarga de representar y gestionar los botones de un ascensor que permiten 
seleccionar un piso. Al utilizar el método presionar se registra la solicitud de
movimiento del ascensor al piso destino.

Clase Boton: Se define las caracteristicas y comportamientos basicos de un boton 
en el sistema del ascensor. Al ser una clase abstracta, está diseñada para ser extendida por 
clases específicas que implementen botones con funcionalidades adicionales.

Clase Botonera: Gestiona la interacción del usuario con el ascensor, permitiendo seleccionar
pisos y otras funciones a traves de botones. Los metodos proporcionados permiten
agregar botones, recuperar botones específicos por piso o identificador, y obtener la lista 
completa de botones. Esto facilita el control y la respuesta a las solicitudes del usuario.

Clase BotonPiso: Extiende de la clase Boton y representa un boton específico que se encuentra 
en cada piso del edificio. Este boton permite a los usuarios solicitar el ascensor desde ese piso.

Clase BotonPuertasAbierta: Extiende la clase Boton y representa un boton específico que 
controla la apertura y cierre de las puertas del ascensor.

Clase EstadoAscensor: Es una enumeracion (enum) que define los posibles estados en los que un 
ascensor puede encontrarse. Estos estados ayudan a controlar y gestionar el comportamiento del 
ascensor.

Clase Piso: Proporciona una estructura para representar cada piso en un edificio, incluyendo 
la creación y manejo de botones para solicitar el ascensor. Los métodos presionarBotonSubir() 
y presionarBotonBajar() permiten simular la interacción del usuario con los botones de llamado del ascensor.

Clase Puerta: Gestiona el estado de las puertas del ascensor, asegurando que no se cierren 
cuando hay un obstaculo y proporcionando métodos para abrir y cerrar las puertas. 

Clase SistemaControl: Gestiona el funcionamiento general del sistema de ascensores y pisos en un edificio. 
Se encarga de procesar solicitudes, gestionar emergencias y monitorear el estado del sistema.

Herencia:

Boton_Ascensor, BotonPiso, y BotonPuertasAbiertas heredan de Boton.

Composición:

Ascensor contiene una instancia de Puerta y Botonera.

Botonera contiene una lista de Boton.

Piso contiene instancias de BotonSubir y BotonBajar.

SistemaControl contiene listas de Ascensor y Piso, y colas de Integer para solicitudes.

Asociación:

Boton_Ascensor y BotonPuertasAbiertas están asociadas a Ascensor.
