public class Ascensor {
    private int pisoActual;
    private boolean subiendo;
    private Puerta puerta;
    private Botonera botonera;
    private EstadoAscensor estado;
    private boolean puertasAbiertas;

    // Agregar un botón especial para mantener las puertas abiertas
    private Boton botonPuertasAbiertas;

    public Ascensor(int pisoActual, Puerta puerta, int cantidadPisos) {
        this.pisoActual = pisoActual;
        this.puerta = puerta;
        this.botonera = new Botonera(cantidadPisos); // Inicializa la botonera del ascensor
        this.estado = EstadoAscensor.PARADO;
        this.puertasAbiertas = false;

        // Inicializar los botones para cada piso
        for (int i = 1; i <= cantidadPisos; i++) {
            Boton botonPiso = new Boton_Ascensor(i, i, this);
            botonera.agregarBoton(botonPiso);
        }

    }

    public int getPisoActual() {
        return pisoActual;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public Botonera getBotonera() {
        return botonera;
    }

    public void alternarPuertas() {
        if (puertasAbiertas) {
            cerrarPuerta();
        } else {
            abrirPuerta();
        }
    }

    public void activarPuertasAbiertas() {
        if (!puertasAbiertas) {
            abrirPuerta();
        } else {
            System.out.println("Las puertas ya están abiertas.");
        }
    }

    public void desactivarPuertasAbiertas() {
        if (puertasAbiertas) {
            cerrarPuerta();
        } else {
            System.out.println("Las puertas ya están cerradas.");
        }
    }

    // Método para mover el ascensor hacia el piso destino
    public void moverAlPiso(int pisoDestino) {
        if (pisoDestino < 0 || pisoDestino > botonera.getCantidadPisos()) {
            System.out.println("Error: piso incorrecto, intenta nuevamente");
            return;
        }

        if (pisoDestino == pisoActual) {
            System.out.println("Ya se encuentra en el piso solicitado.");
            return;
        }

        // Si el destino es más alto
        if (pisoDestino > pisoActual) {
            subiendo = true;
            estado = EstadoAscensor.MOVIENDO;
            cerrarPuerta();  // Asegurar que la puerta se cierra antes de moverse
            System.out.println("El ascensor está subiendo al piso " + pisoDestino);
            pisoActual = pisoDestino;  // Actualizamos el piso actual
            System.out.println("El ascensor ha llegado al piso " + pisoActual);
            abrirPuerta();  // Asegurar que la puerta se abre al llegar
        }
        // Si el destino es más bajo
        else if (pisoDestino < pisoActual) {
            subiendo = false;
            estado = EstadoAscensor.MOVIENDO;
            cerrarPuerta();  // Asegurar que la puerta se cierra antes de moverse
            System.out.println("El ascensor está bajando al piso " + pisoDestino);
            pisoActual = pisoDestino;  // Actualizamos el piso actual
            System.out.println("El ascensor ha llegado al piso " + pisoActual);
            abrirPuerta();  // Asegurar que la puerta se abre al llegar
        }
        // Si ya está en el piso destino
        else {
            System.out.println("El ascensor ya está en el piso " + pisoDestino);
        }
    }

    // Método para abrir las puertas
    public void abrirPuerta() {
        if (!puertasAbiertas) {
            puerta.abrir();
            puertasAbiertas = true;
            System.out.println("Puerta abierta");
        }
    }

    // Método para cerrar las puertas
    public void cerrarPuerta() {
        if (!puerta.isObstaculoPresente()) {
            puerta.cerrar();
            puertasAbiertas = false;
        }else{
            System.out.println("No se puede cerrar la puerta, se ha detectado un obstáculo ");
        }
    }

    // Procesar solicitud de un piso destino
    public void procesarSolicitud(int pisoDestino) {
        moverAlPiso(pisoDestino);  // Mueve el ascensor al piso destino
    }

    // Detener el ascensor
    public void parar() {
        estado = EstadoAscensor.PARADO;
        System.out.println("El ascensor se ha detenido en el piso " + pisoActual);
    }
}
