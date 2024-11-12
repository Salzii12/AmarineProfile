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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.profile.R

val poppinsFonts = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Verivikasi() {
    var verifiedCode by remember { mutableStateOf("") }
    var showBerhasilPopup by remember { mutableStateOf(false) }

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
                            text = "Ubah Kata Sandi",
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Masukkan Kode Verifikasi",
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 40.dp)
                    .widthIn(max = 800.dp),
                fontSize = 15.sp,
                color = Color.Black,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(12.dp),
                        clip = false
                    )
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            ) {
                TextField(
                    value = verifiedCode,
                    onValueChange = { verifiedCode = it },
                    modifier = Modifier
                        .size(width = 367.dp, height = 72.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xFFFF8532),
                        unfocusedIndicatorColor = Color(0xFFE0E0E0)
                    )
                )
            }

            Button(
                onClick = {
                    showBerhasilPopup = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                ),
                modifier = Modifier
                    .padding(start = 56.dp, end = 56.dp, top = 36.dp)
                    .size(width = 272.dp, height = 50.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    "Ubah Kata Sandi",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
        }
    }

    if (showBerhasilPopup) {
        BerhasilDikirim(onDismissRequest = { showBerhasilPopup = false })
    }
}

@Composable
fun BerhasilDikirim(onDismissRequest: () -> Unit) {
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
fun VerifikasiPreview() {
    Verivikasi()
}
