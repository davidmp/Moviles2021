package pe.edu.upeu.appupeunative.modelo

data class User(
    var username:String?="davidmp",
    var password:String?="S1stemas"
)

data class Token(
    var access_token:String?=""
)
