package org.funmeet.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.toComposeImageBitmap
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import org.jetbrains.skia.Image
import platform.Foundation.NSBundle
import platform.Foundation.NSData
import platform.Foundation.NSFileManager
import platform.Foundation.dataWithContentsOfFile
import platform.Foundation.getBytes

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun loadDrawable(resourceName: String): Painter {
    val bundle = NSBundle.mainBundle

    // Attempt to split the name and extension
    val name: String
    val extension: String

    if (resourceName.contains(".")) {
        val parts = resourceName.split(".")
        name = parts[0]
        extension = parts[1]
    } else {
        // Default to "png" if no extension is provided
        name = resourceName
        extension = "png"
    }

    // Get resource path
    val path = bundle.pathForResource(name, extension)
//        ?: throw IllegalStateException("Resource $resourceName not found in the bundle.")

    if (path == null) {
        // List all resources in bundle for debugging
        val enumerator = bundle.resourcePath?.let { NSFileManager.defaultManager.enumeratorAtPath(it) }
        println("Available resources in bundle:")
        while (enumerator?.nextObject() != null) {
            println(enumerator.nextObject())
        }
        throw IllegalStateException("Resource $resourceName not found in the bundle.")
    }

    // Load resource data
    val nsData = NSData.dataWithContentsOfFile(path)
        ?: throw IllegalStateException("Failed to load data for resource $resourceName.")

    // Convert NSData to ByteArray
    val bytes = ByteArray(nsData.length.toInt())
    bytes.usePinned { pinnedBytes ->
        nsData.getBytes(pinnedBytes.addressOf(0), nsData.length)
    }

    return try {
        val image = Image.makeFromEncoded(bytes)
            ?: throw IllegalStateException("Failed to decode image data")
        BitmapPainter(image.toComposeImageBitmap())
    } catch (e: Exception) {
        println("Error creating image: ${e.message}")
        throw e
    }

    // Create and return Painter
//    val image = Image.makeFromEncoded(bytes)
//        ?: throw IllegalStateException("Failed to decode image data for resource $resourceName.")
//    return BitmapPainter(image.toComposeImageBitmap())

//    val bundle = NSBundle.mainBundle
//    val path = bundle.pathForResource(resourceName.split(".")[0], resourceName.split(".")[1])
//        ?: throw IllegalStateException("Resource $resourceName not found")
//
//    val nsData = NSData.dataWithContentsOfFile(path)!!
//    val bytes = ByteArray(nsData.length.toInt())
//    bytes.usePinned { pinnedBytes ->
//        nsData.getBytes(pinnedBytes.addressOf(0), nsData.length)
//    }
//    return BitmapPainter(Image.makeFromEncoded(bytes).toComposeImageBitmap())

}
