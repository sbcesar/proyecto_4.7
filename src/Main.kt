fun main() {
    val cuenta1 = Cuenta("1234", 0.0)
    val cuenta2 = Cuenta("4321", 700.0)

    val persona = Persona("49304339K")
    persona.agregarCuenta(cuenta1)
    persona.agregarCuenta(cuenta2)

    cuenta1.recibirAbono(1100.0)
    cuenta2.realizarPagos(750.0)

    println("Es morosa? ${persona.morosidad()}")

    val otraPersona = Persona("12345678A")
    otraPersona.agregarCuenta(Cuenta("111111111", 0.0))
    otraPersona.agregarCuenta(Cuenta("222222222", 0.0))

    val transferenciaExitosa = persona.transferencia(otraPersona,0,1,500.0)
    if (transferenciaExitosa) {
        println("Transferencia exitosa")
    } else {
        println("Transferencia fallida")
    }

    println("Saldo de la cuenta 1: ${cuenta1.consultarSaldoDisponible()}")
    println("Saldo de la cuenta 2: ${cuenta2.consultarSaldoDisponible()}")
}