package com.example.profile.ui.theme.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.R
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString

val poppinsFonts = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TentangAplikasi() {
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
                            text = "Tentang Aplikasi",
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
                text = "Selamat Datang di Amarine!!",
                modifier = Modifier
                    .padding(top = 25.dp, start = 20.dp)
                    .widthIn(max = 800.dp),
                fontSize = 15.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )

            Text(
                text = "Deskripsi",
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .widthIn(max = 800.dp),
                fontSize = 15.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )

            Text(
                text = "Amarine adalah aplikasi untuk membantu nelayan \n mengelola hasil tangkapan,  melihat panduan atau \n artikel terkait perikanan dan berinteraksi di \n komunitas.",
                modifier = Modifier
                    .padding(top = 4.dp, start = 20.dp)
                    .width(328.dp),
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )

            Text(
                text = "Fitur",
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .widthIn(max = 800.dp),
                fontSize = 15.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )

            Text(
                text =  " 1. Catat Hasil Tangkapan \n" +
                        "      Melihat dan mengelola hasil tangkapan dengan \n" +
                        "      mudah. \n" +
                        " 2. Kelola Stok \n" +
                        "     Catat, kelola dan lihat stok yang ada. \n" +
                        " 3. Panduan atau Artikel \n" +
                        "     Akses panduan atau artikel secara praktis terkait \n" +
                        "     tentang pengelolaan hasil tangkapan.\n" +
                        " 4. Komunitas \n" +
                        "     Forum diskusi dan berbagi pengalaman sesama \n" +
                        "     nelayan.\n",
                modifier = Modifier
                    .padding(top = 4.dp, start = 22.dp)
                    .width(328.dp),
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )

            Text(
                text = "Tujuan Aplikasi",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .widthIn(max = 800.dp),
                fontSize = 15.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )

            Text(
                text = "Amarine bertujuan untuk membantu nelayan \n mengelola hasil tangkapan melalui teknologi digital.",
                modifier = Modifier
                    .padding(top = 4.dp, start = 20.dp)
                    .width(328.dp),
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )

            Text(
                text = "Keunggulan",
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .widthIn(max = 800.dp),
                fontSize = 15.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )

            Text(
                text =  " 1. Pengelolaan hasil tangkapan yang efisien dan \n" +
                        "    terstruktur. \n" +
                        " 2. Akses mudah ke panduan atau artikel terkini. \n" +
                        " 3. Dukungan dari komunitas yang peduli dan siap \n" +
                        "    membantu.",
                modifier = Modifier
                    .padding(top = 4.dp, start = 22.dp)
                    .width(328.dp),
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )

            Text(
                text = "Kontak dan Dukungan",
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .widthIn(max = 800.dp),
                fontSize = 15.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )

            Text(
                text = buildAnnotatedString {
                    append("Jika Anda memiliki pertanyaan atau butuh bantuan, \n jangan ragu hubungi kami di ")
                    withStyle(style = SpanStyle(color = Color(0xFFFF620A))) {
                        append("Amarine@gmail.com")
                    }
                },
                modifier = Modifier
                    .padding(top = 4.dp, start = 20.dp)
                    .width(328.dp),
                fontSize = 12.sp,
                color = Color.Black, // Warna default
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )

            Text(
                text = "atau kunjungi halaman Laporkan Masalah.",
                modifier = Modifier
                    .padding(top = 4.dp, start = 20.dp)
                    .width(328.dp),
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TentangAplikasiPreview() {
    TentangAplikasi()
}
