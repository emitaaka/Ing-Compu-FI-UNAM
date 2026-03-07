import 'dart:io';

// Interfaz
abstract class ServicioTaller {
  double calcularServicio();
  String generarReporteServicio();
}

// Clase Abstracta Padre
abstract class Vehiculo implements ServicioTaller {
  String _marca;
  String _modelo;
  int _anio;

  Vehiculo(this._marca, this._modelo, this._anio);

  // Getters
  String get marca => _marca;
  String get modelo => _modelo;
  int get anio => _anio;

  // Setters con validaciones
  set marca(String nuevaMarca) {
    if (nuevaMarca.isEmpty) {
      throw ArgumentError("La marca no puede ser vacía...");
    }
    _marca = nuevaMarca;
  }

  set modelo(String nuevaModelo) {
    if (nuevaModelo.isEmpty) {
      throw ArgumentError("El modelo no puede ser vacío...");
    }
    _modelo = nuevaModelo;
  }

  set anio(int nuevoAnio) {
    if (nuevoAnio < 1900) {
      throw ArgumentError("El año no puede ser menor que 1900...");
    }
    _anio = nuevoAnio;
  }

  // Método para descripción
  String descripcion() {
    return "$marca $modelo ($anio)";
  }
}

class Auto extends Vehiculo {
  bool _tieneAireAcondicionado;

  Auto(String marca, String modelo, int anio, this._tieneAireAcondicionado)
      :super(marca, modelo, anio);

  bool get tieneAireAcondicionado => _tieneAireAcondicionado;

  set tieneAireAcondicionado(bool valor) {
    _tieneAireAcondicionado = valor;
  }

  @override
  double calcularServicio() {
    double costoBase = 500.0;
    double alineacion = 350.0;
    double recargaAC = _tieneAireAcondicionado ? 400.0 : 0.0;
    return costoBase + alineacion + recargaAC;
  }

  @override 
  String generarReporteServicio() {
    return "Servicio para AUTO ${marca} ${modelo}:\n"
        "- Año: $_anio\n"
        "- A/C: ${_tieneAireAcondicionado ? 'sí' : 'no'}\n"
        "- Total: \$${calcularServicio().toStringAsFixed(2)}";
  }

  @override
  String descripcion() {
    return "Auto: ${super.descripcion()} - A/C: ${_tieneAireAcondicionado ? 'sí' : 'no'}";
  }
}

// Subclase Moto
class Moto extends Vehiculo {
  int _cilindrada; //CC

  Moto(String marca, String modelo, int anio, this._cilindrada)
      :super(marca, modelo, anio);

  int get cilindrada => _cilindrada;

  set cilindrada(int nuevaCilindrada) {
    if (nuevaCilindrada <= 0) {
      throw ArgumentError("La cilindrada debe ser positiva...");
    }
    _cilindrada = nuevaCilindrada;
  }

  @override
  double calcularServicio() {
    double costoBase = 300.0;
    double ajusteCadena = 150.0;
    double recargoAltoDesempeno = _cilindrada >= 600 ? 200.0 : 0.0;
    return costoBase + ajusteCadena + recargoAltoDesempeno;
  }

  @override
  String generarReporteServicio() {
    return "Servicio para MOTO ${marca} ${modelo}:\n"
        "- Año: $anio\n"
        "- Cilindrada: ${_cilindrada}cc\n"
        "- Total: \$${calcularServicio().toStringAsFixed(2)}";
  }

  @override
  String descripcion() {
    return "Moto: ${super.descripcion()} - ${_cilindrada}cc";
  }
}

class Camion extends Vehiculo {
  double _capacidadToneladas;

  Camion(String marca, String modelo, int anio, this._capacidadToneladas)
      : super(marca, modelo, anio);

  double get capacidadToneladas => _capacidadToneladas;

  set capacidadToneladas(double nuevaCapacidad) {
    if (nuevaCapacidad <= 0) {
      throw ArgumentError("La capacidad debe ser positiva...");
    }
    _capacidadToneladas = nuevaCapacidad;
  }

  @override
  double calcularServicio() {
    double costoBase = 1200.0;
    double revisionFrenos = 800.0;
    double revisionSuspension = 600.0;
    double recargoCargaPesada = _capacidadToneladas > 10 ? 1000.0 : 0.0;
    return costoBase + revisionFrenos + revisionSuspension + recargoCargaPesada;
  }

  @override
  String generarReporteServicio() {
    return "Servicio para CAMIÓN ${marca} ${modelo}:\n"
        "- Año: $anio\n"
        "- Capacidad: ${_capacidadToneladas} toneladas\n"
        "- Total: \$${calcularServicio().toStringAsFixed(2)}";
  }

  @override
  String descripcion() {
    return "Camión: ${super.descripcion()} - Capacidad: ${_capacidadToneladas} toneladas";
  }
}

// Para capturar desde CLI

String leerLinea(String prompt) {
  stdout.write(prompt);
  final linea = stdin.readLineSync();
  return linea ?? "";
}

int leerEntero(String prompt) {
  while (true) {
    stdout.write(prompt);
    final linea = stdin.readLineSync();
    if (linea == null) continue;
    final valor = int.tryParse(linea);
    if (valor != null) return valor;
    print("Valor inválido. Debe ser un número entero...");
  }
}

double leerDouble(String prompt) {
  while (true) {
    stdout.write(prompt);
    final linea = stdin.readLineSync();
    if (linea == null) continue;
    final valor = double.tryParse(linea);
    if (valor != null) return valor;
    print("Valor inválido. Debe ser un número real...");
  }
}

bool leerBoolSN(String prompt) {
  while (true) {
    stdout.write(prompt);
    final linea = stdin.readLineSync();
    if (linea == null) continue;
    final l = linea.trim().toLowerCase();
    if (l == "s") return true;
    if (l == "n") return false;
    print("Responde 's' o 'n' por favor...");
  }
}

// Métodos para registrar objetos
Vehiculo crearAutoInteractivo() {
  print("\n== Registro de Auto ==");
  String marca = leerLinea("Marca: ");
  String modelo = leerLinea("Modelo: ");
  int anio = leerEntero("Año: ");
  bool ac = leerBoolSN("¿Tiene aire acondicionado? (s/n): ");
  return Auto(marca, modelo, anio, ac);
}

Vehiculo crearMotoInteractiva() {
  print("\n== Registro de Moto ==");
  String marca = leerLinea("Marca: ");
  String modelo = leerLinea("Modelo: ");
  int anio = leerEntero("Año: ");
  int cc = leerEntero("Cilindrara (cc): ");
  return Moto(marca, modelo, anio, cc);
}

Vehiculo crearCamionInteractivo() {
  print("\n== Registro de Camion ==");
  String marca = leerLinea("Marca: ");
  String modelo = leerLinea("Modelo: ");
  int anio = leerEntero("Año: ");
  double toneladas = leerDouble("Capacidad de carga (toneladas): ");
  return Camion(marca, modelo, anio, toneladas);
}

// Mostrar Reportes

void mostrarListadoBasico(List<Vehiculo> flotilla) {
  if (flotilla.isEmpty) {
    print("\n(No hay vehículos registrados todavía)\n");
    return;
  }

  print("\n=== Flotilla registrada ===\n");
  for (var i = 0; i < flotilla.length; i++) {
    var v = flotilla[i];
    print("[${i + 1}] ${v.descripcion()} | Servicio: \$${v.calcularServicio().toStringAsFixed(2)}");
  }
  print("");
}

void mostrarReportesDetallados(List<Vehiculo> flotilla) {
  if (flotilla.isEmpty) {
    print("\n(No hay vehículos registrados todavía)\n");
    return;
  }

  print("\n=== Flotilla registrada ===\n");
  for (var v in flotilla) {
    print(v.generarReporteServicio());
    print("");
  }
}

void main() {
  List<Vehiculo> flotilla = [];

  while (true) {
    print("==================================");
    print("   SISTEMA PARA TALLER MECÁNICO");
    print("==================================");
    print("1) Registrar Auto");
    print("2) Registrar Moto");
    print("3) Registrar Camión");
    print("4) Ver flotilla (resumen)");
    print("5) Ver reportes detallados");
    print("0) Salir");

    int opcion = leerEntero("Elige una opción: ");

    if (opcion == 0) {
      print("\nSaliendo del sistema. Buen día.\n");
      break;
    }

    switch (opcion) {
      case 1:
        try {
          Vehiculo nuevoAuto = crearAutoInteractivo();
          flotilla.add(nuevoAuto);
          print("\n[OK] Auto agregado.\n");
        } catch (e) {
          print("\n[ERROR] $e");
        }
        break;
      case 2:
        try {
          Vehiculo nuevaMoto = crearMotoInteractiva();
          flotilla.add(nuevaMoto);
          print("\n[OK] Moto agregada.\n");
        } catch (e) {
          print("\n[ERROR] $e");
        }
        break;
      case 3:
        try {
          Vehiculo nuevoCamion = crearCamionInteractivo();
          flotilla.add(nuevoCamion);
          print("\n[OK] Camión agregado.\n");
        } catch (e) {
          print("\n[ERROR] $e");
        }
        break;
      case 4:
        mostrarListadoBasico(flotilla);
        break;
      case 5:
        mostrarReportesDetallados(flotilla);
        break;
      default:
        print("\Opción inválida\n");
    }

    //Pausa intermedia antes de volver a mostrar el menú
    leerLinea("Presiona ENTER para continuar...");
    print("\n");
  }
}