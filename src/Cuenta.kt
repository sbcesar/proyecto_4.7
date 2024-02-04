class Cuenta(val numCuenta: String,var saldo: Double) {

    fun consultarSaldoDisponible(): Double {
        return saldo
    }

    fun recibirAbono(abono: Double) {
        saldo += abono
    }

    fun realizarPagos(pago: Double) {
        saldo -= pago
    }
}