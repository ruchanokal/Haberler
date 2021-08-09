package com.ruchanokal.haberler.model

import java.io.Serializable

data class Emoji(val loved : Integer ,
                 val clappingHand : Integer ,
                 val thumbsDown : Integer ,
                 val smiling:  Integer ,
                 val crying :  Integer ,
                 val angry : Integer ,
                 val suprised : Integer ) : Serializable {


}