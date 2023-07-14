package com.example.scanbotsdkocr

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import io.scanbot.sdk.ScanbotSDK
import io.scanbot.sdk.ScanbotSDKInitializer
import io.scanbot.sdk.entity.Language
import io.scanbot.sdk.ocr.intelligence.OcrSettings
import io.scanbot.sdk.ocr.process.OcrResult
import io.scanbot.sdk.persistence.Page
import io.scanbot.sdk.persistence.PageFileStorage
import io.scanbot.sdk.ui.view.camera.DocumentScannerActivity
import io.scanbot.sdk.ui.view.camera.configuration.DocumentScannerConfiguration

class MainActivity : AppCompatActivity() {
    private lateinit var pageFileStorage: PageFileStorage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.start_scanner_button).setOnClickListener {
            startDocument()
        }
    }

    private fun startDocument() {
//        val ocrRecognizer = ScanbotSDK(this).createOcrRecognizer()
//        val et : EditText = findViewById(R.id.textview)
//        val imageString : Uri = Uri.parse("/storage/emulated/0/DCIM/Camera/IMG_20230707_103544.jpg")
//        val uri : List<Uri> = listOf(imageString)
//        val languages = mutableSetOf<Language>()
//        languages.add(Language.ENG)
//        var result: OcrResult
//        result = ocrRecognizer.recognizeTextFromUris(uri, false, languages)
//        val text : String = result.recognizedText
//        Toast.makeText(this,text,Toast.LENGTH_LONG).show()

        val configuration = DocumentScannerConfiguration()
        configuration.setTopBarBackgroundColor(Color.RED)
        // It is possible to customize the behavior and appearance of the SDK screen
        val docIntent = DocumentScannerActivity.newIntent(this, configuration)
        startActivityForResult(docIntent, DOCUMENT_SCANNER_ACTIVITY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == DOCUMENT_SCANNER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            val snappedPagesExtra = data?.getParcelableArrayExtra(DocumentScannerActivity.toString())
            snappedPagesExtra?.get(0)?.let { page ->
                processPagePreview(page as Page)
            }
        }
    }

    private fun processPagePreview(page: Page) {
        val imageType = PageFileStorage.PageFileType.DOCUMENT
        val filteredPreviewImage = pageFileStorage.getImage(page.pageId, imageType)
//        val previewWidget = findViewById<ImageView>(R.id.page_preview)
//        previewWidget.setImageBitmap(filteredPreviewImage)
    }

    companion object {
        const val DOCUMENT_SCANNER_ACTIVITY_REQUEST_CODE = 100
    }
}