package com.example.plantapp.services

import com.example.plantapp.services.data.Plant
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await

class StorageService {
    private val firestore: FirebaseFirestore = Firebase.firestore
    val authentication: FirebaseAuth = Firebase.auth

    fun getAll(): Flow<List<Plant>> {
        return firestore
            .collection(PLANTS_COLLECTION)
            .dataObjects<Plant>()
    }

    suspend fun getById(plantId: String) : Plant? {
        return firestore
            .collection(PLANTS_COLLECTION)
            .document(plantId)
            .get()
            .await()
            .toObject()
    }

    companion object {
        private const val PLANTS_COLLECTION = "plants"
    }
}