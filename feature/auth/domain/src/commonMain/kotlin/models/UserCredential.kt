package models

import markers.models.RequestModel

data class UserCredential(
    val identifier: String,
    val password: String,
    val hasTermsApproved: Boolean
): RequestModel
