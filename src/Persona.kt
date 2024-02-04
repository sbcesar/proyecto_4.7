class Persona(val DNI: String) {

    private val cuentas = arrayOfNulls<Cuenta>(3)
    private var numCuentas = 0

    fun agregarCuenta(cuenta: Cuenta): Boolean {
        if (numCuentas < 3) {
            cuentas[0] = cuenta
            numCuentas++
            return true
        }
        return false
    }

    fun morosidad(): Boolean {
        for (i in 0..numCuentas) {
            if (cuentas[i]!!.saldo < 0) {
                return true
            }
        }
        return false
    }

    fun transferencia(destinatario: Persona,idCuentaOrigen: Int,idCuentaDestino: Int,cantidad: Double): Boolean {
        val cuentaOrigen = cuentas.getOrNull(idCuentaOrigen)
        val cuentaDestino = destinatario.cuentas.getOrNull(idCuentaDestino)

        if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.saldo >= cantidad) {
            cuentaOrigen.saldo -= cantidad
            cuentaDestino.saldo += cantidad

            if (cuentaDestino.saldo >= 0) {
                return true
            } else {
                cuentaOrigen.saldo += cantidad
                cuentaDestino.saldo -= cantidad
                return false
            }
        }
        return false
    }
}