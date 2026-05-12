package com.example.ordinario_23414.ordinario

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.ordinarioDataStore by preferencesDataStore(name = "ordinario_chiste")

data class ChisteGuardado(
    val frase: String = "",
    val autor: String = ""
)

class OrdinarioDataStore(
    private val context: Context
) {
    private val CHISTE_KEY = stringPreferencesKey("chiste_guardado")
    private val AUTOR_KEY = stringPreferencesKey("autor_guardado")

    val chisteGuardado: Flow<ChisteGuardado> = context.ordinarioDataStore.data.map { preferences ->
        ChisteGuardado(
            frase = preferences[CHISTE_KEY].orEmpty(),
            autor = preferences[AUTOR_KEY].orEmpty()
        )
    }

    suspend fun guardarChiste(chiste: ChisteGuardado) {
        context.ordinarioDataStore.edit { preferences ->
            preferences[CHISTE_KEY] = chiste.frase
            preferences[AUTOR_KEY] = chiste.autor
        }
    }
}
