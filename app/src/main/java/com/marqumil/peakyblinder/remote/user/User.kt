package com.marqumil.peakyblinder.remote.user

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class User (
    val text: String? = null,
    val name: String? = null,
    val photoUrl: String? = null,
    val timestamp: Long? = null
){
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}