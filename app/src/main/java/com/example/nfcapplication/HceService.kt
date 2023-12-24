package com.example.nfcapplication

import android.nfc.cardemulation.HostApduService
import android.os.Bundle
import android.util.Log

class HceService: HostApduService() {
    override fun processCommandApdu(commandApdu: ByteArray, extras: Bundle?): ByteArray {
        Log.d(TAG, "commandApdu: ${commandApdu.toHex()}")
        return byteArrayOf(0x90.toByte(), 0x00)
    }
    override fun onDeactivated(reason: Int) {
    }
    companion object {
        private val TAG: String = HceService::class.java.simpleName
    }
}
private fun ByteArray.toHex(): String = joinToString(":") { "%02x".format(it).uppercase() }
private fun Byte.toUnsignedInt(): Int = (this.toInt() and 0xFF)