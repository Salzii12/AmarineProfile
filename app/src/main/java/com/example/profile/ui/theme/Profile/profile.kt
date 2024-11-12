package com.example.profile.ui.theme.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.profile.R
import poppinsFonts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfile() {
    var showKeluarPopup by remember { mutableStateOf(false) }
    var showBerhasilKeluarPopup by remember { mutableStateOf(false) } // State untuk popup berhasil keluar

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
                .padding(paddingValues)
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Profile",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFonts,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Box(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        color = Color(0xFFFFB16D),
                        shape = RoundedCornerShape(42.dp)
                    )
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .offset(y = (-50).dp)
                            .background(Color.White, shape = RoundedCornerShape(30.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.foto_sementara),
                            contentDescription = "Foto Profil",
                            modifier = Modifier.size(100.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        modifier = Modifier.offset(y = (-42).dp),
                        text = "Pak Bahrul",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFonts,
                        color = Color.Black
                    )

                    ButtonField2(label = "Edit Profil", iconId = R.drawable.ic_editprofil)
                    ButtonField(label = "Ubah Kata Sandi", iconId = R.drawable.ic_ubahkatasandi)
                    ButtonField(label = "Artikel Favorit", iconId = R.drawable.ic_favorit)
                    ButtonField(label = "Pengaturan", iconId = R.drawable.ic_pengaturan)
                    ButtonField(
                        label = "Keluar",
                        iconId = R.drawable.ic_keluar,
                        onClick = {
                            showKeluarPopup = true
                        }
                    )
                }
            }
        }
    }

    if (showKeluarPopup) {
        KeluarPopup(
            onDismissRequest = { showKeluarPopup = false },
            onKeluar = {
                showKeluarPopup = false
                showBerhasilKeluarPopup = true // Menampilkan BerhasilKeluarPopup
            }
        )
    }

    if (showBerhasilKeluarPopup) {
        BerhasilDiubahPopup(
            onDismissRequest = { showBerhasilKeluarPopup = false }
        )
    }
}

@Composable
fun ButtonField(label: String, iconId: Int, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(10.dp),
                clip = false
            )
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = "Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = label,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFB16D),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun ButtonField2(label: String, iconId: Int, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(10.dp),
                clip = false
            )
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = "Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = label,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFB16D),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun KeluarPopup(onDismissRequest: () -> Unit, onKeluar: () -> Unit) {
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier
                .size(width = 360.dp, height = 116.dp)
                .background(color = Color(0xFFFA933A), shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "Anda Yakin Ingin Keluar dari Aplikasi?",
                fontSize = 11.sp,
                fontFamily = poppin,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 5.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(1.dp),
                modifier = Modifier
                    .padding(top = 52.dp)
                    .align(Alignment.BottomEnd)
            ) {
                TextButton(onClick = onDismissRequest) {
                    Text(
                        text = "Batal",
                        fontSize = 11.sp,
                        fontFamily = poppin,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
                TextButton(onClick = onKeluar) {
                    Text(
                        text = "Keluar",
                        fontFamily = poppin,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun BerhasilDiubahPopup(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier
                .size(width = 483.dp, height = 335.dp)
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .size(91.dp, 96.dp)
                        .background(color = Color(0xFFF24E1E).copy(alpha = 0.25f), shape = CircleShape)
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_ceklis),
                        contentDescription = "Ceklis Image",
                        modifier = Modifier.size(34.dp, 24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Berhasil",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = com.example.profile.ui.theme.Profile.poppinsFonts,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Kata sandi berhasil diubah",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = com.example.profile.ui.theme.Profile.poppinsFonts,
                    color = Color(0xFFA6A6A6),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 70.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    EditProfile()
}
