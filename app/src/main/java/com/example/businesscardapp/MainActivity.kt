package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    //val PrimaryColor = Color(0xFF073042)
    Surface(color = Color.White) {
        Column(Modifier.fillMaxWidth()) {
            Row {
                ComposableInfoTop(
                    name = stringResource(R.string.full_name),
                    jobTitle = stringResource(R.string.title)
                )
            }
            Row {
                ComposableInfoBottom(
                    phoneNumber = stringResource(R.string.phone_number),
                    socialLink = stringResource(R.string.social_link),
                    email = stringResource(R.string.email_address)
                )
            }
        }
    }
}

@Composable
private fun ComposableInfoTop(
    name: String,
    jobTitle: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.android_image)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp
        )
        Text(
            text = jobTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
    }
}

@Composable
private fun ComposableInfoBottom(
    phoneNumber: String,
    socialLink: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = phoneNumber,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = socialLink,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = email,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}