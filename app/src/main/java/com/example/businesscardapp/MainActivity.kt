package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(Modifier.weight(1f)) {
            ComposableInfoTop(
                name = stringResource(R.string.full_name),
                jobTitle = stringResource(R.string.title)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoBottom(
                phoneNumber = stringResource(R.string.phone_number),
                socialLink = stringResource(R.string.social_link),
                email = stringResource(R.string.email_address)
            )
        }
    }
}

@Composable
private fun ComposableInfoTop(
    name: String,
    jobTitle: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.android_robot_head_transparency)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(60.dp)
                .width(85.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 34.sp
        )
        Text(
            text = jobTitle,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.androidGreen,
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
    val phoneIcon = painterResource(R.drawable.phone_icon)
    val socialIcon = painterResource(R.drawable.social_icon)
    val emailIcon = painterResource(R.drawable.email_icon)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp)
        ) {
            Icon(
                painter = phoneIcon,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 25.dp),
                Color(0xFF3ddc84)
            )
            Text(
                text = phoneNumber,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp
            )
        }
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp)
        ) {
            Icon(
                painter = socialIcon,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 25.dp),
                Color(0xFF3ddc84)
            )
            Text(
                text = socialLink,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp
            )
        }
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp)
        ) {
            Icon(
                painter = emailIcon,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 25.dp),
                Color(0xFF3ddc84)
            )
            Text(
                text = email,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}