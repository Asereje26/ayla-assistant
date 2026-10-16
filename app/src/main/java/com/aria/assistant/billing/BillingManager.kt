package com.aria.assistant.billing

import android.app.Activity
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BillingManager @Inject constructor() {

    private val _isPremium = MutableStateFlow(true)
    val isPremium: StateFlow<Boolean> = _isPremium.asStateFlow()

    private val _formattedPrices = MutableStateFlow<Map<String, String>>(emptyMap())
    val formattedPrices: StateFlow<Map<String, String>> = _formattedPrices.asStateFlow()

    fun checkExistingPurchases() {
        // AYLA no utiliza compras integradas.
    }

    fun launchBillingFlow(activity: Activity, productId: String) {
        // No hay compras ni suscripciones en AYLA.
    }

    fun retryConnection() {
        // No se necesita conexión de facturación.
    }

    companion object {
        const val MONTHLY_PRODUCT_ID = "aria_premium_monthly"
        const val YEARLY_PRODUCT_ID = "aria_premium_yearly"
        val PREMIUM_PRODUCT_IDS = emptySet<String>()
    }
}
