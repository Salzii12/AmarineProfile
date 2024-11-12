package com.example.profile.ui.theme.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily


val inter = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal)
)



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtikelFavorit() {
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
                            text = "Artikel Favorit",
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            item {
                Row(
                    modifier = Modifier
                        .padding(top = 40.dp, start = 30.dp, end = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(25.dp)
                ) {
                    FavoriteCard(
                        imageResourceId = R.drawable.img_artikel1,
                        title = "Pengolahan Perikanan",
                        tanggal = "Disukai pada : 11 Jan 2023"
                    )

                    FavoriteCard(
                        imageResourceId = R.drawable.img_artikel1,
                        title = "Pengolahan Perikanan",
                        tanggal = "Disukai pada : 29 Feb 2020"
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp, end = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(25.dp)
                ) {
                    FavoriteCard(
                        imageResourceId = R.drawable.img_artikel2,
                        title = "Pengolahan Perikanan",
                        tanggal = "Disukai pada : 23 Sep 2023"
                    )

                    FavoriteCard(
                        imageResourceId = R.drawable.img_artikel2,
                        title = "Pengolahan Perikanan",
                        tanggal = "Disukai pada : 25 Sep 2023"
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp, end = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(25.dp)
                ) {
                    FavoriteCard(
                        imageResourceId = R.drawable.img_artikel3,
                        title = "Pengolahan Perikanan",
                        tanggal = "Disukai pada : 12 Aug 2023"
                    )

                    FavoriteCard(
                        imageResourceId = R.drawable.img_artikel3,
                        title = "Pengolahan Perikanan",
                        tanggal = "Disukai pada : 29 Sep 2023"
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp, end = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(25.dp)
                ) {
                    FavoriteCard(
                        imageResourceId = R.drawable.img_artikel4,
                        title = "Pengolahan Perikanan",
                        tanggal = "Disukai pada : 25 July 2023"
                    )

                    FavoriteCard(
                        imageResourceId = R.drawable.img_artikel4,
                        title = "Pengolahan Perikanan",
                                tanggal = "Disukai pada : 05 Sep 2024"
                    )
                }
            }
        }
    }
}

@Composable
fun RoundedImageCard(imageResourceId: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = "Card Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(148.dp)
                .clip(RoundedCornerShape(15.dp))
        )
    }
}

@Composable
fun FavoriteCard(imageResourceId: Int, title: String, tanggal: String) {
    Card(
        modifier = Modifier
            .size(width = 153.dp, height = 210.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFD2A5)),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        RoundedImageCard(
            imageResourceId = imageResourceId,
            modifier = Modifier
                .fillMaxWidth()
                .height(148.dp)
        )

        Text(
            text = title,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppin,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )

        Text(
            text = tanggal,
            fontSize = 9.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = poppin,
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(top = 20.dp, start = 13.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtikelFavoritPreview() {
    ArtikelFavorit()
}