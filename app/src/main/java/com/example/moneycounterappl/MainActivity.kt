package com.example.moneycounterappl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneycounterappl.ui.theme.MoneyCounterApplTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyCounterApplTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MoneyCounter()
                }
            }
        }
    }
}

@Composable
fun CounterButton(count: Int, UpdateCount: (Int) -> Unit) {

    Button(onClick = {
        UpdateCount(count)
    },
        shape = CircleShape,
        elevation = ButtonDefaults.elevation(8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = LightGray),
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)
    ){
        Text(text = "Tap", fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun MoneyCounter() {
    var count by remember {

        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "$$count", fontSize =50.sp,fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(200.dp))
        CounterButton(count){
            count = it + 10
        }
        Spacer(modifier =Modifier.height(50.dp))
        if(count >= 100){
            Text(text = "You have Lots of Money")
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MoneyCounterApplTheme {
        MoneyCounter()
    }
}