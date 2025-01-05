//package org.funmeet.project
//
////import androidx.compose.foundation.content.MediaType.Companion.Image
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.graphics.painter.BitmapPainter
//import org.jetbrains.skia.Image
//import platform.UIKit.UIImage
//import org.jetbrains.skiko.toImage
//import platform.Foundation.NSData
//import platform.Foundation.getBytes
//import platform.UIKit.UIImagePNGRepresentation
//
//@Composable
//actual fun loadDrawable(resourceName: String): Painter {
//    val uiImage = UIImage.imageNamed(resourceName)
//        ?: throw IllegalArgumentException("Image not found: $resourceName")
//    val imageData = uiImage.toPNGData()
//        ?: throw IllegalArgumentException("Failed to convert UIImage to PNG data")
//    val skiaImage = Image.makeFromEncoded(imageData.toByteArray())
//    return BitmapPainter(skiaImage.toComposeBitmap())
//}
//
//// Helper function to convert UIImage to PNG data
//private fun UIImage.toPNGData(): NSData? = UIImagePNGRepresentation(this)
//
//// Helper function to convert NSData to ByteArray
//private fun NSData.toByteArray(): ByteArray {
//    val size = this.length.toInt()
//    val bytes = ByteArray(size)
//    this.getBytes(bytes, size.toULong())
//    return bytes
//}
//
//// Extension function to convert Skia Image to Compose Bitmap
//private fun Image.toComposeBitmap() = org.jetbrains.compose.ui.graphics.toComposeImageBitmap()