package com.darkhorse.videocalltest

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.telecom.*
import android.util.Log

class CallConnectionService : ConnectionService() {

    val TAG = "CallConnectionService"

    override fun onCreateIncomingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection {
        super.onCreateIncomingConnection(connectionManagerPhoneAccount, request)
        Log.i("CallConnectionService", "onCreateIncomingConnection")
        val conn = CallConnection(this)
        conn.connectionProperties = Connection.PROPERTY_SELF_MANAGED
        conn.setCallerDisplayName("Doutora XPTO", TelecomManager.PRESENTATION_ALLOWED)
        conn.videoState = VideoProfile.STATE_PAUSED // VideoProfile.STATE_BIDIRECTIONAL
//        conn.setAddress(Uri.parse("tel:" + "+919582940055"), TelecomManager.PRESENTATION_ALLOWED)
        conn.setRinging()
        conn.setInitializing()
        conn.setActive()
        return conn
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.i(TAG, "CallConnectionService - onUnbind")
        return super.onUnbind(intent)
    }

    override fun onCreateIncomingConnectionFailed(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ) {
        super.onCreateIncomingConnectionFailed(connectionManagerPhoneAccount, request)
        Log.i(TAG, "CallConnectionService - onCreateIncomingConnectionFailed")
    }

    override fun onCreateOutgoingConnectionFailed(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ) {
        super.onCreateOutgoingConnectionFailed(connectionManagerPhoneAccount, request)
        Log.i(TAG, "CallConnectionService - onCreateOutgoingConnectionFailed")
    }

    override fun onCreateOutgoingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection {
        Log.i(TAG, "CallConnectionService - onCreateOutgoingConnection")
        return super.onCreateOutgoingConnection(connectionManagerPhoneAccount, request)
    }

    override fun onCreateOutgoingHandoverConnection(
        fromPhoneAccountHandle: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection {
        Log.i(TAG, "CallConnectionService - onCreateOutgoingHandoverConnection")
        return super.onCreateOutgoingHandoverConnection(fromPhoneAccountHandle, request)
    }

    override fun onCreateIncomingHandoverConnection(
        fromPhoneAccountHandle: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection {
        Log.i(TAG, "CallConnectionService - onCreateIncomingHandoverConnection")
        return super.onCreateIncomingHandoverConnection(fromPhoneAccountHandle, request)
    }

    override fun onHandoverFailed(request: ConnectionRequest?, error: Int) {
        super.onHandoverFailed(request, error)
        Log.i(TAG, "CallConnectionService - onHandoverFailed")
    }

    override fun onConference(connection1: Connection?, connection2: Connection?) {
        super.onConference(connection1, connection2)
        Log.i(TAG, "CallConnectionService - onConference")
    }

    override fun onRemoteConferenceAdded(conference: RemoteConference?) {
        super.onRemoteConferenceAdded(conference)
        Log.i(TAG, "CallConnectionService - onRemoteConferenceAdded")
    }

    override fun onRemoteExistingConnectionAdded(connection: RemoteConnection?) {
        super.onRemoteExistingConnectionAdded(connection)
        Log.i(TAG, "CallConnectionService - onRemoteExistingConnectionAdded")
    }

    override fun onConnectionServiceFocusLost() {
        super.onConnectionServiceFocusLost()
        Log.i(TAG, "CallConnectionService - onConnectionServiceFocusLost")
    }

    override fun onConnectionServiceFocusGained() {
        super.onConnectionServiceFocusGained()
        Log.i(TAG, "CallConnectionService - onConnectionServiceFocusGained")

    }
}