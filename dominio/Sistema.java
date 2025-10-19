package dominio;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class Sistema implements Serializable {

    private static boolean modoOscuro = false;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Contrato> listaContratos;
    private ArrayList<Movimiento> listaMovimientos;
    private ArrayList<Servicio> listaServicios;
    private transient ArrayList<Observador> observadores = new ArrayList<>();

    public Sistema() {
        listaVehiculos = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaClientes = new ArrayList<>();
        listaContratos = new ArrayList<>();
        listaMovimientos = new ArrayList<>();
        listaServicios = new ArrayList<>();
        observadores = new ArrayList<>();

    }

    public ArrayList<Empleado> getListaEmpleados() {
        ArrayList<Empleado> nueva = new ArrayList<>();
        for (Empleado empleador : this.listaEmpleados) {
            nueva.add(empleador);
        }
        return nueva;
    }

    public ArrayList<Cliente> getListaClientes() {
        ArrayList<Cliente> nueva = new ArrayList<>();
        for (Cliente clientes : this.listaClientes) {
            nueva.add(clientes);
        }
        return nueva;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return this.listaVehiculos;
    }

    public ArrayList<Contrato> getListaContratos() {
        ArrayList<Contrato> nueva = new ArrayList<>();
        for (Contrato contratos : this.listaContratos) {
            nueva.add(contratos);
        }
        return nueva;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return this.listaMovimientos;
    }

    public ArrayList<Servicio> getListaServicios() {
        ArrayList<Servicio> nueva = new ArrayList<>();
        for (Servicio servicios : this.listaServicios) {
            nueva.add(servicios);
        }
        return nueva;
    }

    //Observadores 
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar();
        }
    }

    public void cambiarModoOscuro() {
        modoOscuro = !modoOscuro;
        notificarObservadores();
    }

    public boolean isModoOscuro() {
        return modoOscuro;
    }

    //Metodo que me sugiere chatGPT para reiniciar los observadores y que no explote al recuperar archivo
    private void readObject(java.io.ObjectInputStream in)
            throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();
        observadores = new ArrayList<>();
    }

// Interacciones con Clientes
    public void agregarCliente(String nombre, int cedula, String direccion, String celular, int año) {
        Cliente nuevoCliente = new Cliente(nombre, cedula, direccion, celular, año);
        this.listaClientes.add(nuevoCliente);
        notificarObservadores();
    }

    public boolean existeCliente(int cedula) {
        boolean existe = false;
        if (!listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {
                if (cedula == cliente.getCedula()) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    public void eliminarCliente(Cliente unCliente) {
        int i = 0;
        boolean eliminado = false;
        while (i < this.listaClientes.size() && !eliminado) {
            Cliente cliente = this.listaClientes.get(i);
            if (cliente.getCedula() == unCliente.getCedula()) {
                eliminarContratosClientes(unCliente);
                this.listaClientes.remove(i);
                eliminado = true;
            } else {
                i++;
            }
        }
        notificarObservadores();
    }

    public void eliminarContratosClientes(Cliente unCliente) {
        int i = 0;
        while (i < this.listaContratos.size()) {
            Contrato contrato = this.listaContratos.get(i);
            if (contrato.getCliente().getCedula() == unCliente.getCedula()) {
                this.listaContratos.remove(i);
            } else {
                i++;
            }
        }
        notificarObservadores();
    }

    //Interacciones con Empleados
    public void agregarEmpelado(String nombre, int cedula, String direccion, int numeroEmpleado) {
        Empleado nuevoEmpleado = new Empleado(nombre, cedula, direccion, numeroEmpleado);
        listaEmpleados.add(nuevoEmpleado);
        notificarObservadores();
    }

    public boolean existeEmpleado(int numeroEmpleado) {
        boolean existe = false;
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getNumeroEmpleado() == numeroEmpleado) {
                existe = true;
            }
        }
        return existe;
    }

// Interacciones con Vehiculos
    public void agregarVehiculo(String matricula, String marca, String modelo, String estado) {
        Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, modelo, estado);
        this.listaVehiculos.add(nuevoVehiculo);
        notificarObservadores();
    }

    public boolean existeVehiculo(String matricula) {
        boolean existe = false;
        if (!listaVehiculos.isEmpty()) {
            for (Vehiculo vehiculo : listaVehiculos) {
                if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    public ArrayList<Vehiculo> getListaVehiculosFuera() {
        ArrayList<Vehiculo> listaVehiculosFuera = new ArrayList<>();
        for (Vehiculo vFuera : listaVehiculos) {
            if (!vFuera.getEstacionado()) {
                listaVehiculosFuera.add(vFuera);
            }
        }
        return listaVehiculosFuera;
    }

    //Interacciones con Movimientos
    public ArrayList<Vehiculo> getListaVehiculosDentro() {
        ArrayList<Vehiculo> listaVehiculosDentro = new ArrayList<>();
        for (Vehiculo vDentro : listaVehiculos) {
            if (vDentro.getEstacionado()) {
                listaVehiculosDentro.add(vDentro);
            }
        }
        return listaVehiculosDentro;
    }

    public void setEntradaVehiculo(String matricula) {
        for (Vehiculo vehiculo : this.getListaVehiculos()) {
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                vehiculo.setEstacionado(true);
            }
        }
        notificarObservadores();
    }

    public void setSalidaVehiculo(String matricula) {
        for (Vehiculo vehiculo : this.getListaVehiculos()) {
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                vehiculo.setEstacionado(false);
            }
        }
        notificarObservadores();
    }

    public Movimiento getSalidaParaVehiculo(Vehiculo unVehiculo) {
        Movimiento movimiento = new Movimiento();
        for (Movimiento mov : listaMovimientos) {
            if (mov.getVehiculo().getMatricula().equals(unVehiculo.getMatricula()) && mov.getFechaSalida() == null) {
                movimiento = mov;
            }
        }
        return movimiento;
    }

    public boolean existeContratoConVehiculo(Vehiculo vehiculo) {
        boolean tieneContrato = false;
        for (Contrato cont : listaContratos) {
            if (cont.getVehiculo().getMatricula().trim().equals(vehiculo.getMatricula().trim())) {
                tieneContrato = true;
            }
        }
        return tieneContrato;
    }

    //Interacciones con Contratos
    public void agregarContrato(int id, Cliente cliente, Vehiculo vehiculo, Empleado empleado, int valor) {
        Contrato contrato = new Contrato(getContratosMaxId() + 1, cliente, vehiculo, empleado, valor);
        this.listaContratos.add(contrato);
        notificarObservadores();
    }

    public int existeContrato(Cliente cliente, Vehiculo vehiculo) { //devuelvo el id del contrato o -1 si no tiene
        int tieneContrato = -1;
        for (Contrato cont : listaContratos) {
            if (cont.getCliente() == cliente && cont.getVehiculo() == vehiculo) {
                tieneContrato = cont.getId();
            }
        }
        return tieneContrato;
    }

    public int getContratosMaxId() {
        int maxid = 0;
        if (!listaContratos.isEmpty()) {
            for (Contrato cont : listaContratos) {
                if (cont.getId() > maxid) {
                    maxid = cont.getId();
                }
            }
        }
        return maxid;
    }

    //Interacciones con Servicios
    public void agregarServicioAdicional(Vehiculo unVehiculo, Empleado unEmpleado, String unServicio, String unaFecha, int unCosto) {
        Servicio nuevoServicio = new Servicio(unVehiculo, unEmpleado, unServicio, unaFecha, unCosto);
        this.listaServicios.add(nuevoServicio);
        notificarObservadores();
    }

    //Interacciones con Reportes
    public ArrayList<String[]> getHistorialCompleto(ArrayList<Movimiento> movimientos, ArrayList<Servicio> servicios) {
        ArrayList<String[]> historial = new ArrayList<>();

        for (Movimiento mov : movimientos) {
            if (mov.getFechaEntrada() != null) {
                historial.add(new String[]{
                    mov.getFechaEntrada(),
                    "Entrada",
                    mov.getEmpleadoEntrada().toString(),
                    mov.getNotaEntrada(),
                    mov.getVehiculo().toString()
                }
                );
            }

            if (mov.getFechaSalida() != null) {
                historial.add(new String[]{
                    mov.getFechaSalida(),
                    "Salida",
                    mov.getEmpleadoSalida().toString(),
                    mov.getNotaSalida(),
                    mov.getVehiculo().toString()
                }
                );
            }
        }

        for (Servicio serv : servicios) {
            historial.add(new String[]{
                serv.getFecha(),
                "Servicio",
                serv.getEmpleado().toString(),
                serv.getServicio() + " ($" + serv.getValor() + ")",
                serv.getVehiculo().toString()}
            );
        }
        return historial;
    }

    public ArrayList<String[]> getHistorialEntradas(ArrayList<Movimiento> listaMovimientos) {
        ArrayList<String[]> entradas = new ArrayList<>();
        for (Movimiento mov : listaMovimientos) {
            if (mov.getFechaEntrada() != null) {
                entradas.add(new String[]{
                    mov.getFechaEntrada(),
                    "Entrada",
                    mov.getEmpleadoEntrada().toString(),
                    mov.getNotaEntrada(),
                    mov.getVehiculo().toString()
                }
                );
            }
        }
        return entradas;
    }

    public ArrayList<String[]> getHistorialSalidas(ArrayList<Movimiento> listaMovimientos) {
        ArrayList<String[]> salidas = new ArrayList<>();
        for (Movimiento mov : listaMovimientos) {
            if (mov.getFechaSalida() != null) {
                salidas.add(new String[]{
                    mov.getFechaSalida(),
                    "Salida",
                    mov.getEmpleadoSalida().toString(),
                    mov.getNotaSalida(),
                    mov.getVehiculo().toString()
                }
                );
            }
        }
        return salidas;
    }

    public ArrayList<String[]> getHistorialServicios(ArrayList<Servicio> listaServicios) {
        ArrayList<String[]> servicios = new ArrayList<>();
        for (Servicio serv : listaServicios) {
            servicios.add(new String[]{
                serv.getFecha(),
                "Servicio",
                serv.getEmpleado().toString(),
                serv.getServicio() + " ($" + serv.getValor() + ")",
                serv.getVehiculo().toString()}
            );
        }
        return servicios;
    }

    public ArrayList<String[]> ordenarLista(ArrayList<String[]> lista, boolean ascendente) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); //para que sepa que la fecha que recibe usa este formato
        ArrayList<String[]> copiaOrdenada = new ArrayList<>(lista);

        Collections.sort(copiaOrdenada, new Comparator<String[]>() { //quiero ordenar, pero le especifico el criterio
            @Override
            public int compare(String[] fila1, String[] fila2) {
                LocalDateTime f1 = LocalDateTime.parse(fila1[0], formato); // Fecha de la fila 1
                LocalDateTime f2 = LocalDateTime.parse(fila2[0], formato); // Fecha de la fila 2

                int comparacion = f1.compareTo(f2); // Comparo las fechas y devuelve -1 si f1 es antes que f2 y 1 si f2 es antes que f1

                if (!ascendente) {
                    comparacion = -comparacion; // Invierto si es descendente 
                }

                return comparacion; // Resultado de la comparación
            }
        });
        return copiaOrdenada; // Devuelvo la copia ordenada
    }

    // Filtra la lista de movimientos por vehículo (o devuelve toda si filtroVehiculo es null)
    public ArrayList<Movimiento> filtrarMovimientosPorVehiculo(ArrayList<Movimiento> movimientos, Vehiculo filtroVehiculo) {
        if (filtroVehiculo == null) {
            return new ArrayList<>(movimientos);
        }
        ArrayList<Movimiento> filtrados = new ArrayList<>();
        for (Movimiento mov : movimientos) {
            if (mov.getVehiculo().equals(filtroVehiculo)) {
                filtrados.add(mov);
            }
        }
        return filtrados;
    }

// Filtra la lista de servicios por vehículo (o devuelve toda si filtroVehiculo es null)
    public ArrayList<Servicio> filtrarServiciosPorVehiculo(ArrayList<Servicio> servicios, Vehiculo filtroVehiculo) {
        if (filtroVehiculo == null) {
            return new ArrayList<>(servicios);
        }
        ArrayList<Servicio> filtrados = new ArrayList<>();
        for (Servicio serv : servicios) {
            if (serv.getVehiculo().equals(filtroVehiculo)) {
                filtrados.add(serv);
            }
        }
        return filtrados;
    }

    public ArrayList<Empleado> empleadosConMenosMovimientos() {
        ArrayList<Empleado> empleadosMinimos = new ArrayList<>();
        int minMovimientos = Integer.MAX_VALUE;
        for (Empleado empleado : listaEmpleados) {
            int contador = 0;
            int numeroEmpleado = empleado.getNumeroEmpleado();

            for (Movimiento mov : listaMovimientos) {
                if ((mov.getEmpleadoEntrada() != null && mov.getEmpleadoEntrada().getNumeroEmpleado() == numeroEmpleado) || (mov.getEmpleadoSalida() != null && mov.getEmpleadoSalida().getNumeroEmpleado() == numeroEmpleado)) {
                    contador++;
                }
            }

            for (Servicio serv : listaServicios) {
                if ((serv.getEmpleado() != null && serv.getEmpleado().getNumeroEmpleado() == numeroEmpleado)) {
                    contador++;
                }
            }

            if (contador < minMovimientos) {
                minMovimientos = contador;
                empleadosMinimos.clear();
                empleadosMinimos.add(empleado);
            } else if (contador == minMovimientos) {
                empleadosMinimos.add(empleado);
            }
        }
        return empleadosMinimos;
    }

    public ArrayList<String> serviciosMasUtilizados() {
        ArrayList<String> nombreServicios = new ArrayList<>();
        ArrayList<Integer> cantidadServicios = new ArrayList<>();
        for (Servicio servicio : listaServicios) {
            String nombre = servicio.getServicio();
            int index = nombreServicios.indexOf(nombre);
            if (index >= 0) {
                cantidadServicios.set(index, cantidadServicios.get(index) + 1);
            } else {
                nombreServicios.add(nombre);
                cantidadServicios.add(1);
            }
        }
        int max = 0;
        for (int cantidad : cantidadServicios) {
            if (cantidad > max) {
                max = cantidad;
            }
        }
        ArrayList<String> masUtilizados = new ArrayList<>();
        for (int i = 0; i < cantidadServicios.size(); i++) {
            if (cantidadServicios.get(i) == max) {
                masUtilizados.add(nombreServicios.get(i));
            }
        }
        return masUtilizados;
    }

    public ArrayList<Cliente> clientesConMasContratos() {
        ArrayList<Cliente> clientesContados = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();
        for (Contrato contrato : listaContratos) {
            Cliente cliente = contrato.getCliente();
            int index = clientesContados.indexOf(cliente);
            if (index >= 0) {
                cantidades.set(index, cantidades.get(index) + 1);
            } else {
                clientesContados.add(cliente);
                cantidades.add(1);
            }
        }
        int max = 0;
        for (int cantidad : cantidades) {
            if (cantidad > max) {
                max = cantidad;
            }
        }
        ArrayList<Cliente> clientesMaximos = new ArrayList<>();
        for (int i = 0; i < cantidades.size(); i++) {
            if (cantidades.get(i) == max) {
                clientesMaximos.add(clientesContados.get(i));
            }
        }
        return clientesMaximos;
    }

    public String[] masTiempoEnParking() {
        String[] res = new String[3];
        long maxTiempo = -1;
        long tiempoTotal = 0;
        for (Movimiento movimiento : listaMovimientos) {
            String fechaEntrada = movimiento.getFechaEntrada();
            String fechaSalida = movimiento.getFechaSalida();
            if (fechaEntrada != null && fechaSalida != null && !fechaEntrada.isEmpty() && !fechaSalida.isEmpty()) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    LocalDateTime entrada = LocalDateTime.parse(fechaEntrada, formatter);
                    LocalDateTime salida = LocalDateTime.parse(fechaSalida, formatter);
                    long minutos = Duration.between(entrada, salida).toMinutes();
                    tiempoTotal = minutos;
                    if (tiempoTotal > maxTiempo) {
                        maxTiempo = tiempoTotal;
                        res[0] = movimiento.getVehiculo().getMatricula();
                        res[1] = movimiento.getFechaEntrada();
                        res[2] = movimiento.getFechaSalida();

                    }
                } catch (DateTimeParseException e) {
                }
            }
        }
        return res;
    }

    public ArrayList<String> nombresClientesConMasContratos() {
        ArrayList<Cliente> clientes = clientesConMasContratos(); // Reutilizás el método actual
        ArrayList<String> nombres = new ArrayList<>();
        for (Cliente client : clientes) {
            nombres.add(client.getNombre());  // O el atributo que quieras mostrar
        }
        return nombres;
    }

    // Filtra la lista de servicios por fecha
    public ArrayList<Servicio> filtrarServiciosPorFecha(ArrayList<Servicio> servicios, String fecha) {
        ArrayList<Servicio> filtrados = new ArrayList<>();
        for (Servicio serv : servicios) {
            if (serv.getFecha().equals(fecha)) {
                filtrados.add(serv);
            }
        }
        return filtrados;
    }

    //Filtra Entradas por fecha 
    public ArrayList<Movimiento> filtrarEntradasPorFecha(ArrayList<Movimiento> movimientos, String fecha) {
        ArrayList<Movimiento> filtrados = new ArrayList<>();
        DateTimeFormatter conHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter soloFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Movimiento mov : movimientos) {
            String fechaEntrada = mov.getFechaEntrada();
            if (fechaEntrada != null && !fechaEntrada.isEmpty()) {
                LocalDate fechaEntradaLocalDate = LocalDate.parse(fechaEntrada, conHora);
                String soloFechaEntrada = fechaEntradaLocalDate.format(soloFecha);
                if (soloFechaEntrada.equals(fecha)) {
                    filtrados.add(mov);
                }
            }
        }
        return filtrados;
    }

    //Filtra Salidas por fecha 
    public ArrayList<Movimiento> filtrarSalidasPorFecha(ArrayList<Movimiento> movimientos, String fecha) {
        ArrayList<Movimiento> filtrados = new ArrayList<>();
        DateTimeFormatter conHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter soloFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Movimiento mov : movimientos) {
            String fechaSalida = mov.getFechaSalida();
            if (fechaSalida != null && !fechaSalida.isEmpty()) {
                LocalDate fechaSalidaLocalDate = LocalDate.parse(fechaSalida, conHora);
                String soloFechaSalida = fechaSalidaLocalDate.format(soloFecha);
                if (soloFechaSalida.equals(fecha)) {
                    filtrados.add(mov);
                }
            }
        }
        return filtrados;
    }
}
