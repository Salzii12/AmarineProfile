package com.example.profile.ui.theme.Profile

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notifikasi() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Kembali",
                            modifier = Modifier
                                .clickable(onClick = { /* Halaman kembali jika ditekan */ })
                                .size(30.dp)
                                .padding(start = 5.dp)
                        )
                        Text(
                            text = "Notifikasi",
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsFonts
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF620A),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "Pemberitahuan notifikasi dari Forum Komunitas yang \ndiikuti untuk memastikan anda mendapatkan \ninformasi terbaru.",
                modifier = Modifier
                    .padding(top = 25.dp, start = 20.dp)
                    .width(350.dp),
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = poppin,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )

            Row(
                modifier = Modifier
                    .padding(top = 25.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Nonaktifkan notifikasi ketika ada \ninformasi terbaru dari komunitas",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = poppin,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(1f)
                )

                // Toggle Button
                var isToggled by remember { mutableStateOf(false) }
                val offsetX by animateDpAsState(targetValue = if (isToggled) 32.dp else 5.dp)

                Box(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .size(width = 58.dp, height = 35.dp)
                        .background(
                            color = Color(0xFFFFD2A5),
                            shape = RoundedCornerShape(50)
                        )
                        .clickable { isToggled = !isToggled },
                    contentAlignment = Alignment.CenterStart
                ) {
                    Box(
                        modifier = Modifier
                            .offset(x = offsetX)
                            .size(width = 17.dp, height = 21.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(50)
                            )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotifikasiPreview() {
    Notifikasi()
}
