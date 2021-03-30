import android.view.MotionEvent
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInteropFilter

@Composable
fun Slider(
    modifier: Modifier = Modifier,
    @IntRange(from = 1) steps: Int = 5,
    @FloatRange(from = 0.0, to = 1.0) stepSize: Float = 0.5f,
    @FloatRange(from = 0.0) value: Float = 0.0f,
    isIndicator: Boolean = false,
    out: @Composable () -> Unit,
    fill: @Composable () -> Unit,
    onValueChanged: (rating: Float) -> Unit = { _ -> }
) {
    SliderImpl(
        modifier,
        isIndicator,
        steps,
        stepSize,
        value,
        out,
        fill
    ) {
        onValueChanged(it)
    }
}

@Composable
private fun SliderImpl(
    modifier: Modifier,
    isIndicator: Boolean,
    steps: Int,
    stepSize: Float,
    value: Float,
    out: @Composable () -> Unit,
    fill: @Composable () -> Unit,
    onValueChanged: (Float) -> Unit
) {
    var sizeRowWidth by remember { mutableStateOf(0f) }
    if (value > steps.toFloat()) {
        onValueChanged(steps.toFloat())
    }
    val offsetX = (value / steps) * sizeRowWidth
    Box(modifier = modifier) {
        Row(
            Modifier
                .then(
                    if (isIndicator) {
                        Modifier
                    } else {
                        Modifier.pointerInteropFilter { event ->
                            when (event.action) {
                                MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                                    move(
                                        event,
                                        sizeRowWidth,
                                        stepSize,
                                        steps,
                                        value,
                                        onValueChanged
                                    )
                                }
                            }
                            true
                        }
                    }
                )
        ) {
            repeat(steps) {
                out()
            }
        }
        Row(
            modifier = Modifier
                .clip(GenericShape { size, _ ->
                    sizeRowWidth = size.width
                    moveTo(offsetX, 0f)
                    lineTo(offsetX, size.height)
                    lineTo(0f, size.height)
                    lineTo(0f, 0f)
                })
        ) {
            repeat(steps) {
                Row {
                    fill()
                }
            }
        }
    }
}

private fun move(
    event: MotionEvent,
    sizeRowWidth: Float,
    stepSize: Float,
    steps: Int,
    preview: Float,
    onChange: (Float) -> Unit
) {
    val sizeItemPx = sizeRowWidth / steps
    val stepPx = sizeItemPx * stepSize
    val scrollPosition = (event.x / sizeRowWidth) * sizeRowWidth
    var partFill = (scrollPosition / stepPx).toInt() * stepSize
    if (partFill > steps) {
        partFill = steps.toFloat()
    } else if (partFill < 0) {
        partFill = 0f
    }
    if (partFill != preview) {
        onChange(partFill)
    }
}