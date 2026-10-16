package com.aria.assistant.ads

import android.app.Activity
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val _canRequestAds = MutableStateFlow(false)
    val canRequestAds: StateFlow<Boolean> = _canRequestAds.asStateFlow()

    private val _privacyOptionsRequired = MutableStateFlow(false)
    val privacyOptionsRequired: StateFlow<Boolean> =
        _privacyOptionsRequired.asStateFlow()

    private val _showInterstitialEvents = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1
    )
    val showInterstitialEvents: SharedFlow<Unit> =
        _showInterstitialEvents.asSharedFlow()

    fun requestConsent(activity: Activity) {
        // AYLA no utiliza anuncios ni solicita consentimiento publicitario.
        _canRequestAds.value = false
        _privacyOptionsRequired.value = false
    }

    fun showPrivacyOptions(activity: Activity) {
        // AYLA no utiliza anuncios ni opciones de privacidad publicitaria.
    }

    fun recordInteraction() {
        // No se registran interacciones para mostrar anuncios.
    }

    fun showInterstitial(activity: Activity) {
        // AYLA no muestra anuncios intersticiales.
    }
}
