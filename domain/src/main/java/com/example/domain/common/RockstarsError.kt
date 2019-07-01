package com.example.domain.common

/**
 * Created by Festus Kiambi on 7/1/19.
 */
sealed class RockstarsError : Exception(){
    object LocalIOException: RockstarsError()
    object RemoteIOException: RockstarsError()
    object NetworkUnavailableException: RockstarsError()
}