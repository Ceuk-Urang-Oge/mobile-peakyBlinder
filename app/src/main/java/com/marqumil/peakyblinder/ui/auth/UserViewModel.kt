package com.marqumil.peakyblinder.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class UserViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val currentUserLiveData = MutableLiveData<FirebaseUser?>()

    init {
        currentUserLiveData.value = auth.currentUser
        // Set up an AuthStateListener to update the LiveData when the user's authentication state changes.
        auth.addAuthStateListener { firebaseAuth ->
            currentUserLiveData.value = firebaseAuth.currentUser
        }
    }

    // LiveData to observe changes in the user's authentication state
    fun getCurrentUserLiveData(): LiveData<FirebaseUser?> = currentUserLiveData

    // Method to sign out the current user
    fun signOut() {
        auth.signOut()
    }

    // Method to check if the user is signed in
    fun isUserSignedIn(): Boolean {
        return auth.currentUser != null
    }

    fun getEmail(): String? {
        return auth.currentUser?.email
    }

    fun getUsername(): String? {
        return auth.currentUser?.displayName
    }
}