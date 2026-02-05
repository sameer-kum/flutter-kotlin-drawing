package com.example.flutter_kotlin_drawing

import android.content.Context
import android.graphics.*
import android.view.View
import io.flutter.plugin.platform.PlatformView

class ComplexDrawingView(context: Context, id: Int, creationParams: Map<String?, Any?>?) : PlatformView, View(context) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private val rectF = RectF()

    override fun getView(): View {
        return this
    }

    override fun dispose() {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        val width = width.toFloat()
        val height = height.toFloat()
        val centerX = width / 2
        val centerY = height / 2
        val radius = (Math.min(width, height) / 2) * 0.8f

        // 1. Draw Outer Ring (Gradient)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 40f
        paint.shader = SweepGradient(centerX, centerY, 
            intArrayOf(Color.parseColor("#FF6B6B"), Color.parseColor("#4ECDC4"), Color.parseColor("#45B7D1"), Color.parseColor("#FF6B6B")), 
            null)
        canvas.drawCircle(centerX, centerY, radius, paint)
        paint.shader = null // Reset shader

        // 2. Draw Inner Dashboard Background
        paint.style = Paint.Style.FILL
        paint.color = Color.parseColor("#2C3E50")
        canvas.drawCircle(centerX, centerY, radius - 25f, paint)

        // 3. Draw Ticks
        paint.color = Color.WHITE
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE
        
        for (i in 0 until 12) {
            val angle = Math.toRadians((i * 30).toDouble())
            val startX = centerX + (radius - 60f) * Math.cos(angle).toFloat()
            val startY = centerY + (radius - 60f) * Math.sin(angle).toFloat()
            val endX = centerX + (radius - 30f) * Math.cos(angle).toFloat()
            val endY = centerY + (radius - 30f) * Math.sin(angle).toFloat()
            canvas.drawLine(startX, startY, endX, endY, paint)
        }

        // 4. Draw Center "Metallic" Cap
        paint.style = Paint.Style.FILL
        paint.color = Color.LTGRAY
        canvas.drawCircle(centerX, centerY, 30f, paint)
        paint.color = Color.DKGRAY
        canvas.drawCircle(centerX, centerY, 15f, paint)

        // 5. Draw Needle (Complex Path)
        path.reset()
        path.moveTo(centerX, centerY - 20f) // Top of base
        path.lineTo(centerX + 15f, centerY) // Right of base
        path.lineTo(centerX, centerY + radius - 50f) // Tip (pointing down for demo)
        path.lineTo(centerX - 15f, centerY) // Left of base
        path.close()

        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.setShadowLayer(10f, 0f, 5f, Color.BLACK)
        
        // Rotate needle for effect (e.g., pointing to 2 o'clock)
        canvas.save()
        canvas.rotate(135f, centerX, centerY)
        canvas.drawPath(path, paint)
        canvas.restore()
        
        paint.clearShadowLayer()

        // 6. Draw Text Label
        paint.color = Color.WHITE
        paint.textSize = 50f
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText("TURBO", centerX, centerY - radius / 2, paint)
    }
}
