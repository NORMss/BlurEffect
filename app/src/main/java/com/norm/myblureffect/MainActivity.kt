package com.norm.myblureffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import com.norm.myblureffect.ui.theme.MyBlurEffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBlurEffectTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var checked by remember {
        mutableStateOf(false)
    }
    val animateBlur by animateDpAsState(targetValue = if (checked) 10.dp else 0.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .blur(
                    radius = animateBlur,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded,
                ),
            text = "Hello, World!",
            fontSize = MaterialTheme.typography.displayLarge.fontSize,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = !checked
            },
        )
    }
}