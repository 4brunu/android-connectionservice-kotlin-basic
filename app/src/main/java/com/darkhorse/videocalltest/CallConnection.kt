package com.darkhorse.videocalltest

import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telecom.CallAudioState
import android.telecom.Connection
import android.util.Log

class CallConnection(ctx: Context) : Connection(){

    val TAG = "CallConnection"
    val context: Context

    init {
        context = ctx
    }


    override fun onShowIncomingCallUi() {
        super.onShowIncomingCallUi()
        Log.i(TAG, "CallConnection - onShowIncomingCallUi")
    }

    override fun onAnswer() {
        super.onAnswer()
        Log.i(TAG, "CallConnection - onAnswer")

        val myIntent: Intent = Intent(context, MainActivity::class.java)
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(myIntent)
    }

    override fun onAnswer(videoState: Int) {
        super.onAnswer(videoState)
        Log.i(TAG, "CallConnection - onAnswer - $videoState")
    }

    override fun requestBluetoothAudio(bluetoothDevice: BluetoothDevice) {
        super.requestBluetoothAudio(bluetoothDevice)
        Log.i(TAG, "CallConnection - requestBluetoothAudio")

    }

    override fun onCallAudioStateChanged(state: CallAudioState?) {
        super.onCallAudioStateChanged(state)
        Log.i(TAG, "CallConnection - onCallAudioStateChanged")

    }

    override fun onStateChanged(state: Int) {
        super.onStateChanged(state)
        Log.i(TAG, "CallConnection - onStateChanged - $state")

    }

    override fun onPlayDtmfTone(c: Char) {
        super.onPlayDtmfTone(c)
        Log.i(TAG, "CallConnection - onPlayDtmfTone")

    }

    override fun onStopDtmfTone() {
        super.onStopDtmfTone()
        Log.i(TAG, "CallConnection - onStopDtmfTone")

    }

    override fun onDisconnect() {
        super.onDisconnect()
        Log.i(TAG, "CallConnection - onDisconnect")

    }

    override fun onSeparate() {
        super.onSeparate()
        Log.i(TAG, "CallConnection - onSeparate")

    }

    override fun onAbort() {
        super.onAbort()
        Log.i(TAG, "CallConnection - onAbort")

    }

    override fun onHold() {
        super.onHold()
        Log.i(TAG, "CallConnection - onHold")

    }

    override fun onUnhold() {
        super.onUnhold()
        Log.i(TAG, "CallConnection - onUnhold")

    }

    override fun onDeflect(address: Uri?) {
        super.onDeflect(address)
        Log.i(TAG, "CallConnection - onDeflect")

    }

    override fun onReject() {
        super.onReject()
        Log.i(TAG, "CallConnection - onReject")

    }

    override fun onReject(rejectReason: Int) {
        super.onReject(rejectReason)
        Log.i(TAG, "CallConnection - onReject")

    }

    override fun onReject(replyMessage: String?) {
        super.onReject(replyMessage)
        Log.i(TAG, "CallConnection - onReject")

    }

    override fun onSilence() {
        super.onSilence()
        Log.i(TAG, "CallConnection - onSilence")

    }

    override fun onPostDialContinue(proceed: Boolean) {
        super.onPostDialContinue(proceed)
        Log.i(TAG, "CallConnection - onPostDialContinue")

    }

    override fun onPullExternalCall() {
        super.onPullExternalCall()
        Log.i(TAG, "CallConnection - onPullExternalCall")

    }

    override fun onCallEvent(event: String?, extras: Bundle?) {
        super.onCallEvent(event, extras)
        Log.i(TAG, "CallConnection - onCallEvent")

    }

    override fun onHandoverComplete() {
        super.onHandoverComplete()
        Log.i(TAG, "CallConnection - onHandoverComplete")

    }

    override fun onExtrasChanged(extras: Bundle?) {
        super.onExtrasChanged(extras)
        Log.i(TAG, "CallConnection - onExtrasChanged")

    }

    override fun onStartRtt(rttTextStream: RttTextStream) {
        super.onStartRtt(rttTextStream)
        Log.i(TAG, "CallConnection - onStartRtt")

    }

    override fun onStopRtt() {
        super.onStopRtt()
        Log.i(TAG, "CallConnection - onStopRtt")

    }

    override fun handleRttUpgradeResponse(rttTextStream: RttTextStream?) {
        super.handleRttUpgradeResponse(rttTextStream)
        Log.i(TAG, "CallConnection - handleRttUpgradeResponse")

    }

    override fun sendConnectionEvent(event: String?, extras: Bundle?) {
        super.sendConnectionEvent(event, extras)
        Log.i(TAG, "CallConnection - sendConnectionEvent")
    }
}