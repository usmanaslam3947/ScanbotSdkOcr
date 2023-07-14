package com.example.scanbotsdkocr

import android.app.Application
import io.scanbot.sdk.ScanbotSDKInitializer
import io.scanbot.sdk.ocr.intelligence.OcrSettings

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val LICENSE_KEY =
            "CTZU7zqBIj2EsO6YXJfT7J9wA9x0m8" +
                    "gVn0RYFicS3OSDfSsYwbBInC/hU/Cc" +
                    "+EzXn7zlWbRzB1ejVQd2o+xnVAbd6d" +
                    "APd4S0JofwZbrFBwt8BRgorzjqJb3M" +
                    "igk/zHpMu9A4FAMLHR3ZgE3JLyfAdw" +
                    "/UgE8bVyrFuWU/pW2iTeYdLVtzz8xE" +
                    "WlGlsniXsBC6mOtJ67k0TuEVwTXdXK" +
                    "io/2h56WmPCHN/Iist/jUMFvdmSbZe" +
                    "y/phQcBCadIURR6N5syuMjouzEU6+C" +
                    "ugSlTJf9Fw2RmtJzti7hJb7u0qUMo9" +
                    "GWkzFuZISbTL3IIoGxTQEz/xW15tvi" +
                    "0thTCJjPksGw==\nU2NhbmJvdFNESw" +
                    "pjb20uYXllc2hhLnNjYW5ib3RvY3IK" +
                    "MTY5MTg4NDc5OQo4Mzg4NjA3CjE5\n"
        ScanbotSDKInitializer()
            .license(this,LICENSE_KEY)
            .prepareOCRLanguagesBlobs(true)
            .initialize(this)
    }
}