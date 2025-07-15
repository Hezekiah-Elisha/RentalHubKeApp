package ke.hub.rentalhubke

import android.app.Application
import io.kotzilla.sdk.analytics.koin.analytics
import ke.hub.rentalhubke.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RentalhubkeApplication:Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@RentalhubkeApplication)
            analytics()
            modules(
                appModule
            )
        }
    }
}