object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"//SI
    const val gradle = "com.android.tools.build:gradle:7.0.3"//SI //4.0.1
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
    const val ktLint = "org.jlleitschuh.gradle:ktlint-gradle:9.2.1"
    const val materialDesign = "com.google.android.material:material:1.2.1"//SI
    const val materialDialog = "com.shreyaspatil:MaterialDialog:2.1"
    const val coil = "io.coil-kt:coil:0.9.5"
}

object Android {
    const val appcompat = "androidx.appcompat:appcompat:1.2.0"//si
    const val activityKtx = "androidx.activity:activity-ktx:1.1.0"
    const val coreKtx = "androidx.core:core-ktx:1.3.1" //SI
    const val legacyKts="androidx.legacy:legacy-support-v4:1.0.0" //SI
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.1"//si
    const val navegationFragment="androidx.navigation:navigation-fragment:2.3.0"//si
    const val navegationUI="androidx.navigation:navigation-ui:2.3.0"//si
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"
}

object Navigation{
    const val navegationFragmentKtx="androidx.navigation:navigation-fragment-ktx:2.3.0"
    const val navegationUiKtx="androidx.navigation:navigation-ui-ktx:2.3.0"
}

object Testing {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.9"
    const val room = "androidx.room:room-testing:2.2.5"
    const val jUnit = "junit:junit:4.12"//si
    const val extJUnit = "androidx.test.ext:junit:1.1.2"//SI
    const val espresso = "androidx.test.espresso:espresso-core:3.3.0"//si
    const val okHttp = "com.squareup.okhttp3:mockwebserver:4.4.0"
    const val core = "androidx.arch.core:core-testing:2.1.0"
}

object Lifecycle {
    const val lifeCicleExtension = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
}

object Versions{//1.4.10
    const val kotlin="1.5.31"
    const val room="2.3.0"
}

object Hilt {
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
    const val hiltAndroid = "com.google.dagger:hilt-android:2.28-alpha"
}

object Moshi { //1.9.2
    const val moshi = "com.squareup.moshi:moshi-kotlin:1.12.0"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:1.12.0"
}

object Retrofit { //2.8.1   //2.7.2
    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val moshiRetrofitConverter = "com.squareup.retrofit2:converter-moshi:2.9.0"
}

object Coroutines { //1.3.9
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
}


object Room { //2.2.5
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val ktx = "androidx.room:room-ktx:${Versions.room}"
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
}